package com.bmc.qa.utils;

public class UserUtility {
	public static short PAGE_LOAD_TIMEOUT = 20;
	public static short IMPLICIT_WAIT = 10;
	public static short EXPLICIT_WAIT = 30;
	public static String URL = "http://itsm-web.robi.com.bd:8080/arsys/shared/login.jsp?/arsys/home";
	public static String USER_NAME = System.getenv("BMC_USER");
	public static String USER_PASS = System.getenv("BMC_PASS");
//	public static String USER_NAME = "Jis2462"; // For static use purpose set this
//	public static String USER_PASS = "1234";
	
	public static String[] TNR_GROUP = {
            "Muhammad Shahed",
            "Ripan Kumar",
            "Sudipta Das"
	};
	
	public static String[] ANR_GROUP = {
            "Faisal Mahmud Fuad",
            "Sumon Kumar Biswas",
            "Shahriar Mahbub",
            "Md. Musfiqur  Rahman",
            "Md. Rakibuzzaman",
            "K.M Khairul Bashar"
	};
}
