package com.bmc.qa.utils;

public class UserUtility {
	public static long PAGE_LOAD_TIMEOUT = 20;
	public static long IMPLICIT_WAIT = 10;
	public static String URL = "http://itsm-web.robi.com.bd:8080/arsys/shared/login.jsp?/arsys/home";
	public static String USER_NAME = System.getenv("BMC_USER");
	public static String USER_PASS = System.getenv("BMC_PASS");
}
