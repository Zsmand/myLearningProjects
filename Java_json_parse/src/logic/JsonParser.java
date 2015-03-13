package logic;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

public class JsonParser {
	private String szig;
	private String Nev;
	private Date szulDatum;
	private String szulHely;
	private int eletKor;
	private List<User> felhasz = new ArrayList<User>();
	private Date maiDatum = new Date();
	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd");
	private SimpleDateFormat ev = new SimpleDateFormat("yyyy");

	public List<User> readInputFile(String path) {

		BufferedReader br = null;

		try {
			String line;

			br = new BufferedReader(new FileReader(path));

			Logger.getInstance().logInfo(getClass(), "####################");
			Logger.getInstance().logInfo(getClass(), "##Sorok olvasása...");
			Logger.getInstance().logInfo(getClass(), "####################");

			while ((line = br.readLine()) != null) {

				if (line.contains("\"szig\"")) {
					szig = line.substring(line.indexOf(':') + 2,
							line.length() - 2);

				}
				if (line.contains("\"nev\"")) {
					Nev = line.substring(line.indexOf(':') + 2,
							line.length() - 2);
				}

				if (line.contains("\"szuldatum\"")) {
					try {
						szulDatum = sdf.parse(line.substring(
								line.indexOf(':') + 2, line.length() - 2));
						eletKor = Integer.parseInt(ev.format(maiDatum))
								- Integer.parseInt(ev.format(szulDatum));
					} catch (ParseException e) {

						e.printStackTrace();
					}
				}

				if (line.contains("\"szulhely\"")) {
					szulHely = line.substring(line.indexOf(':') + 2,
							line.length() - 1);
					// felhasználó hozzáadása a listához
					felhasz.add(new User(szig, Nev, szulDatum, szulHely,
							eletKor));

				}
			}

			Logger.getInstance().logInfo(getClass(), "####################");
			Logger.getInstance().logInfo(getClass(),
					"## Sorok olvasása sikeres volt...");
			Logger.getInstance().logInfo(getClass(), "####################");

		} catch (IOException e) {
			Logger.getInstance().logWarning(getClass(), e.getMessage());

		} finally {
			try {
				if (br != null)
					br.close();
			} catch (IOException ex) {
				Logger.getInstance().logError(getClass(), ex.getMessage());
			}
		}
		return felhasz;
	}

	// Getterek

	public void getSzemely(int i) {
		felhasz.get(i).getAll();
	}

	public void getSzemelyek() {
		for (User element : felhasz) {
			element.getAll();
		}
	}

	public void getSzemelyek1990() {
		Date date = null;
		try {
			date = sdf.parse("1990.01.01");
		} catch (ParseException e) {

			e.printStackTrace();
		}
		for (User element : felhasz) {
			if (element.getSzulDatum().before(date))
				element.getAll();
		}
	}

	public void getSzemelyekKorAlapjanNovekvoTOP5() {
		int i = 0;
		Collections.sort(felhasz);
		for (i = 0; i < 5; i++) {
			felhasz.get(i).getAll();
		}

	}

	public void getSzemelyekKorAlapjanNovekvo() {

		Collections.sort(felhasz);
		for (User element : felhasz) {
			element.getAll();
		}

	}

	public void getSzemelyekHelyAlapjan() {
		Collections.sort(felhasz, hely);
		for (User element : felhasz) {
			element.getAll();
		}
	}

	public void getSzemelyekKorAlapjanCsokkenoTOP5() {
		int i = 0;
		Collections.sort(felhasz);
		for (i = felhasz.size() - 1; i > felhasz.size() - 6; i--) {
			felhasz.get(i).getAll();
		}

	}

	// Rendezés lakhely alapján csoportosítva
	public Comparator<User> hely = new Comparator<User>() {

		@Override
		public int compare(User u1, User u2) {
			// TODO Auto-generated method stub
			return u1.getSzulHely().compareTo(u2.getSzulHely());
		}

	};

}
