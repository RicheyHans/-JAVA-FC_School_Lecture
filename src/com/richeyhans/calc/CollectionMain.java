package com.richeyhans.calc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class CollectionMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CollectionMain cm = new CollectionMain();
		cm.checkArray();
	}
	
	public void checkArray() {
		// ����
		// Ÿ��[] �迭�� = new Ÿ��[�迭����ũ��];
		// int, long ���� ���� �Ҵ縸���ε� �⺻�� 0�� ����
		
		int[] intArray = new int[10];
		System.out.println(intArray[7]);
		
		// Object �迭
		Item itemArray[] = new Item[10];		// �������� �Ҵ�
		int itemLength = itemArray.length;		// JAVA�Ծ� �� ������ ����.
		for(int i=0; i<itemLength; i++) {
			itemArray[i] = new Item();
		}
		System.out.println(itemArray[7].getMyname());		// 
	}
	
	// index�� �����ϴ� ���� ��ü�迭
	public void checkList() {
		//List list = new List(); Interface�̹Ƿ� ����ü�� �ʿ��ϴ�.
		
		// ������ �Ϲ��� ��ü ����. ����� Ÿ���� List�ε� ������ ����Ǿ. ������ ���� ���� ���� Ÿ��
		ArrayList list = new ArrayList();
		
		// �Է�
		list.add(new Item()); // <- 0�� index�� ����
		// <- 1�� index�� ����
		
		// ��ȸ
		list.get(0);	// <- index�� 0��°�� ���� ������ �´�.
		// ����
		list.set(1, new Item());	// <- 1�� index�� �������� ��ü�Ѵ�.
		// add�� �ٸ� ���
		list.add(1, new Item());	// <- 1������ ������ ������ index�� �ϳ��� ������Ű��, �ڽ��� 1������ ����.
		// set���� �ϸ� 1���� �����ϰ� ����, add�ϸ� �ε��� ���̿� ���Ƿ� �迭�� �����Ѵ�.
		list.remove(1);	// ������ �������� index�� �����Ѵ�. ���� �� �ڿ� �ε����� ��ܿ´�.
	}
	
	public void checkGeneric() {
		// ���׸��� ����ϴ� ���
		// Ÿ��<���׸�Ÿ��> �����̸�;	// <- ���׸� Ÿ���� Ŭ������ �����ϴ�.
		ArrayList<Item> list = new ArrayList<>();
		
		// list.add(123);
		// list.add("Hello");
		list.add(new Item());
		
		for(int i=0; i<list.size(); i++) {
			
		}
	}
	
	// List�� �����ϳ�, �ߺ����� ������� �ʴ� �����迭
	public void checkSet() {
		HashSet<String> set = new HashSet<>();
		set.add("Hello");
		set.add("Good to see you");
		set.add("Hello");
		
		// Set�� iterator�� �޾Ƽ� listó�� ������� ó���� �� �ִ�.
		Iterator<String> iterator = set.iterator();
		while(iterator.hasNext()) {
			System.out.println(iterator.next());	// Object������ ����
		}
	}
	
	// Map�� Key, Value�� ����
	public void checkMap() {
		// ����
		HashMap<String, Integer> map = new HashMap<>();
		// �Է�
		map.put("key01", 123456);
		// ��ȸ
		System.out.println(map.get("key01"));
	}
}

class Item{
	private String myName = "�ѽ¹�";
	public String getMyname() {		// object array�� �����ϰ� �ȴ�.
		return myName;
	}
}
