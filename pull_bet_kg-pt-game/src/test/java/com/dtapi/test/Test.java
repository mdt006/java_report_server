package com.dtapi.test;

import java.time.LocalDate;


public class Test {
	public static void main(String[] args) {
	//	EncryptUtils.getAuthenticator(paras);
		LocalDate date = LocalDate.now(); 
		LocalDate nextDay=date.plusDays(-1);  
		System.out.println(date);
		System.out.println(nextDay);
		Boolean a  = null;
		System.out.println(a == null);
	}
}
