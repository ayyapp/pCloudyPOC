package com.cash.utilities;

import java.util.Random;

public class Randomizer {
	
	
	public static String getRandomNumber(){
		Random rn = new Random();
		int range = 9 - 6 + 1;
		int randomNum =  rn.nextInt(range) + 6;
		// System.out.println(randomNum);
		String mobileNum="";
		for(int i=0;i<9;i++){
			mobileNum=mobileNum+Integer.toString(rn.nextInt(9));
		}
		mobileNum = Integer.toString(randomNum)+mobileNum;
		System.out.println(mobileNum);

		return mobileNum;   
	}
	
	
	/*public static String getRandomNumber(int digCount) {
	    StringBuilder sb = new StringBuilder(digCount);
	    Random rand=new Random();
	    for(int i=0; i < digCount; i++)
	        sb.append((char)(rand.nextInt(10)));
	    return sb.toString();
	    }*/
	
	
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
