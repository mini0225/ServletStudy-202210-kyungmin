package com.study.util;

public class StringBuilderTest {

	public static void main(String[] args) {
		//메모리의 낭비가 일어남.
		String str = "문자열1";
		str += "문자열2";
		str = str.replaceAll("문자열2", "문자열3"); //replace 문자열 바꾸기.
		
		System.out.println(str);
		
		StringBuilder builder = new StringBuilder(); //비동기  // capacity 0=16 -> 16칸의미. char 문자 2byte  => 32byte 메모리 의미.
		//append 함으로써 새로운 문자열에 따른 메모리를 만드는게 아니라 기존의 16칸 안에 계속 집어 넣는다
		//stringBuilder 는 append / delete 해줌에 따른 16칸을 넘어가는(줄어드는) 상황에 자동으로 16개 단위로 증감이 일어난다.

		StringBuffer buffer = new StringBuffer(); //동기 ,
		
		
	}

}
