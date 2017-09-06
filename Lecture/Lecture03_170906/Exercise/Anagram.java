/*
 * Anagram �˻� üũ ���α׷�
 */

import java.util.Arrays;

public class Anagram {
	public static void main(String[] args) {
		Anagram anagram = new Anagram();
		boolean result = anagram.checkAnagram("cat", "act");
		System.out.println(result);
	}
	
	public boolean checkAnagram(String a, String b) {		
		// ��ҹ��� ó��
		a = a.toLowerCase();
		b = b.toLowerCase();
		// ��������
		a = a.replace(" ", "");
		b = b.replace(" ", "");
		
		// ���� ��
		if(a.length() != b.length()) {
			return false;
		}
		
		// ������ ���� char �迭�� ����
		char aTemp[] = a.toCharArray();
		char bTemp[] = b.toCharArray();
		
		// ĳ���� �迭 ����
		Arrays.sort(aTemp);
		Arrays.sort(bTemp);
		
		return Arrays.equals(aTemp, bTemp);			
	}
}