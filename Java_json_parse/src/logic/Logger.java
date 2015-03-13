package logic;

import java.util.Date;

public class Logger {
	public Date date = new Date();
	private static Logger instance = null;

	protected Logger() {

	};

	public static Logger getInstance() {
		if (instance == null) {
			instance = new Logger();
		}
		return instance;

	}

	public  void logError(Class clasz,String message) {

		 System.out.println("[ERROR]\t"+new Date().toString()+"\t"+clasz.getSimpleName()+message);
	}

	public  void logWarning(Class clasz,String message) {

		System.out.println("[WARNING]\t"+new Date().toString()+"\t"+clasz.getSimpleName()+message);
	}

	public  void logInfo(Class clasz,String message) {

		System.out.println("[INFO]\t"+new Date().toString()+"\t"+clasz.getSimpleName()+" "+message);
	}

}
