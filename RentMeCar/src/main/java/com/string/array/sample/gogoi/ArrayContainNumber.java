package com.string.array.sample.gogoi;

public class ArrayContainNumber {
	public static void main(String[] args) {
		String[] numbers = {"Hello", "Jennifer", "w123", "1234", "Ilu4ch"};
		for(String num:numbers){
			System.out.println(check(num));
			//System.out.println(checkNumber(num));
		}
	}
	
	public static boolean check(String num){
		for(int i = 0 ; i < num.length() ; i++){
			if(num.charAt(i) >= 48 && num.charAt(i) <= 57)
				return true;
		}
		return false;
	}
	
	public static boolean checkNumber(String num){
		char[] ch = num.toCharArray();
		for(int i=0;i<ch.length;i++){
			if(isNum(ch[i])){
				return true;
			}
		}
		return false;
	}
	public static boolean isNum(char ch){
		try{
			Integer.parseInt(ch+"");
			return true;
		}catch (Exception e) {
			// TODO: handle exception
		}
		return false;
	}
}
