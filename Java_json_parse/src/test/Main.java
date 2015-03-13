package test;

import logic.JsonParser;

public class Main {
	public static void main(String args[]) {
		JsonParser p = new JsonParser();
		p.readInputFile("res\\input.txt");

		// Egy tetszőleges személy kilistázása
		// p.getSzemely(3);

		// Felhasználok kilistázása
		//p.getSzemelyek();

		// Azon személyek akik 1990 elött születtek
		// p.getSzemelyek1990();
		
		//TOP 5 legfiatalabb felhasználó
		//p.getSzemelyekKorAlapjanNovekvoTOP5();
		
		//TOP 5 legidősebb felhasználó
		//p.getSzemelyekKorAlapjanCsokkenoTOP5();
		
		//Felhasználók listázva város szerint
		//p.getSzemelyekHelyAlapjan();
		
		//Felhasználók kor szerint növekvőben
		//p.getSzemelyekKorAlapjanNovekvo();
		
		

	}
}
