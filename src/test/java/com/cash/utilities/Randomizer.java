package com.cash.utilities;

import java.util.Random;

public class Randomizer {
	
	
	
	public static String getRandomNumber(int digCount) {
	    StringBuilder sb = new StringBuilder(digCount);
	    Random rand=new Random();
	    for(int i=0; i < digCount; i++)
	        sb.append((char)(rand.nextInt(10)));
	    return sb.toString();
	    }
	
	
	public static String getRandomString(int digCount) {
	    StringBuilder sb = new StringBuilder(digCount);
	    Random rand=new Random();
	    String s="abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
	    for(int i=0; i < digCount; i++)
	        sb.append(s.charAt(rand.nextInt(s.length())));
	    return sb.toString();
	    }
	
	
	public static void main(String[] args) {
		System.out.println(getRandomString(9));
	}


	

}
