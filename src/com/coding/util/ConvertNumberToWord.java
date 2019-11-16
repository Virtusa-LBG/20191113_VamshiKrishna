package com.coding.util;

import java.util.HashMap;
import java.util.Map;

public class ConvertNumberToWord {

	
	public static void convertToWord(int number) {
		
		String numberWord = Integer.toString(number);
		
		char[] numberArr = numberWord.toCharArray();
		
		int length = numberArr.length;
		
		int remainder = length % 3;
		
		int divided = length / 3;
		
		String result = "";
		
			
			if( divided > 0) {
			
			  if(remainder == 1) { result +=
			  getOnePositionMap(convertCharToInt(numberArr[0]))+" "+getremainingPositions(
			  numberArr.length);
			  
			  }
			 			for(int i= divided; i >0 ; i--) {
					
					result += getHundradString(numberArr, (i));
					
				}
				
				
			}
			
			System.out.println(result);
		}
	
	public static String getHundradString(char[] numberArr, int divided) {
		String result = "";
		int req = 3;
		int j = 0;
		
		if(divided == 3 && numberArr.length == 9) {
			j=0;
		}else if(divided == 2 && numberArr.length == 9) {
			j=3;
		}else if(divided == 1 && numberArr.length == 9) {
			j=6;
		}
		else if(divided == 2 && numberArr.length == 6) {
			j=0;
		}else if(divided == 1 && numberArr.length == 6) {
			j =3;
		}
		else if(divided == 1 && numberArr.length == 3) {
			j = 0;
		}
	
		for(int i = 0; i < 3; i++) {
		
		if(req == 3) {
			result += getOnePositionMap(convertCharToInt(numberArr[j])) +" "+ getremainingPositions(req)+" and ";
			j++;
			req --;
		}
		else if(req ==2) {
			result += getSecondPositionMap(convertCharToInt(numberArr[j]))+" ";
			j++;
			req --;
		}else if(req == 1) {
			result += getOnePositionMap(convertCharToInt(numberArr[j]))+" ";
			j++;
			req --;
		}
		
	}
		if(divided == 2) {
			result += "Thousand ";
		}
		if(divided == 3) {
			result += "Million ";
		}
		return result;
	}
	
	
	public static int convertCharToInt(char c) {
		
		return Character.getNumericValue(c);
	}
	
	public static String getremainingPositions(int position) {
		String s = "";
		if(position ==3 ||position == 9 ) {
			s = "Hundard";
		}else if(position == 7) {
			s = "Million";
		}
		return s;
	}
	public static String getOnePositionMap(Integer no){
		
		Map<Integer, String> oneMap = new HashMap<>();
		oneMap.put(0, "");
		oneMap.put(1, "One");
		oneMap.put(2, "Two");
		oneMap.put(3, "Three");
		oneMap.put(4, "Four");
		oneMap.put(5, "Five");
		oneMap.put(6, "Six");
		oneMap.put(7, "Seven");
		oneMap.put(8, "Eight");
		oneMap.put(9, "Nine");
		
		return oneMap.get(no);
	}
	
public static String getSecondPositionMap(Integer no){
		
		Map<Integer, String> oneMap = new HashMap<>();
		oneMap.put(1, "Ten");
		oneMap.put(2, "Twenty");
		oneMap.put(3, "Threty");
		oneMap.put(4, "Fourty");
		oneMap.put(5, "Fivety");
		oneMap.put(6, "Sixty");
		oneMap.put(7, "Seventy");
		oneMap.put(8, "Eightty");
		oneMap.put(9, "Ninety");
		
		return oneMap.get(no);
	}
}
