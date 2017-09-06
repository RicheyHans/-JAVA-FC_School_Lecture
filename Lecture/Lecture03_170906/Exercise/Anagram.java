/*
 * Anagram 검색 체크 프로그램을 구현하시오.
 * (문자열 두 개를 입력 받아 순서만 다른 알파벳으로 구성된 단어 여부를 검색 / 공백 무시)
 */

import java.util.Arrays;

public class Anagram {
	public static void main(String[] args) {
		Anagram anagram = new Anagram();
		boolean result = anagram.checkAnagram("cat", "act");
		System.out.println(result);
	}
	
	public boolean checkAnagram(String a, String b) {		
		// 대소문자 처리
		a = a.toLowerCase();
		b = b.toLowerCase();
		// 공백제거
		a = a.replace(" ", "");
		b = b.replace(" ", "");
		
		// 길이 비교
		if(a.length() != b.length()) {
			return false;
		}
		
		// 정렬을 위해 char 배열로 변경
		char aTemp[] = a.toCharArray();
		char bTemp[] = b.toCharArray();
		
		// 캐릭터 배열 정렬
		Arrays.sort(aTemp);
		Arrays.sort(bTemp);
		
		return Arrays.equals(aTemp, bTemp);			
	}
}