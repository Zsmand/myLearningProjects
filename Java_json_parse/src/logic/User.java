package logic;

import java.text.SimpleDateFormat;
import java.util.Date;

public class User implements Comparable<User> {

	private String szig;
	private String Nev;
	private Date szulDatum;
	private String szulHely;
	private int eletKor;
	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd");

	public User(String sztg, String Nev, Date szulDatum, String szulHely,
			int eletKor) {
		this.szig = sztg;
		this.Nev = Nev;
		this.szulDatum = szulDatum;
		this.szulHely = szulHely;
		this.eletKor = eletKor;
	}

	public String getSztg() {
		return szig;
	}

	public void setSztg(String sztg) {
		this.szig = sztg;
	}

	public String getNev() {
		return Nev;
	}

	public void setNev(String nev) {
		Nev = nev;
	}

	public Date getSzulDatum() {
		return szulDatum;
	}

	public void setSzulDatum(Date szulDatum) {
		this.szulDatum = szulDatum;
	}

	public String getSzulHely() {
		return szulHely;
	}

	public void setSzulHely(String szulHely) {
		this.szulHely = szulHely;
	}

	public int getEletKor() {
		return eletKor;
	}

	public void setEletKor(int eletKor) {
		this.eletKor = eletKor;
	}

	public void getAll() {
		System.out.println("Szig szám: " + getSztg() + ", Név: " + getNev()
				+ "\n Szül.idő: " + sdf.format(getSzulDatum())
				+ ", Szül.hely: " + getSzulHely() + ", Kora: " + getEletKor()
				+ "\n");
	}

	@Override
	public int compareTo(User o) {
		int comperAge = o.getEletKor();
		return this.getEletKor() - comperAge;
	}

}
