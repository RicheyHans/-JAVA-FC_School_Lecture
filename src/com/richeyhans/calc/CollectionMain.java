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
		// 선언
		// 타입[] 배열명 = new 타입[배열공간크기];
		// int, long 등은 공간 할당만으로도 기본값 0이 생성
		
		int[] intArray = new int[10];
		System.out.println(intArray[7]);
		
		// Object 배열
		Item itemArray[] = new Item[10];		// 번지수만 할당
		int itemLength = itemArray.length;		// JAVA규약 상 변수로 지정.
		for(int i=0; i<itemLength; i++) {
			itemArray[i] = new Item();
		}
		System.out.println(itemArray[7].getMyname());		// 
	}
	
	// index를 포함하는 동적 객체배열
	public void checkList() {
		//List list = new List(); Interface이므로 구현체가 필요하다.
		
		// 선언은 일반적 객체 참조. 참고로 타입은 List인데 다형성 적용되어서. 지금은 이해 쉽게 원래 타입
		ArrayList list = new ArrayList();
		
		// 입력
		list.add(new Item()); // <- 0번 index로 생성
		// <- 1번 index로 생성
		
		// 조회
		list.get(0);	// <- index가 0번째인 값을 가지고 온다.
		// 수정
		list.set(1, new Item());	// <- 1번 index의 아이템을 대체한다.
		// add의 다른 방법
		list.add(1, new Item());	// <- 1번부터 이후의 아이템 index를 하나씩 증가시키고, 자신이 1번으로 들어간다.
		// set으로 하면 1번을 삭제하고 들어가고, add하면 인덱스 사이에 들어가므로 배열이 증가한다.
		list.remove(1);	// 삭제할 아이템의 index를 지정한다. 삭제 시 뒤에 인덱스를 당겨온다.
	}
	
	public void checkGeneric() {
		// 제네릭을 사용하는 방법
		// 타입<제네릭타입> 변수이름;	// <- 제네릭 타입은 클래스만 가능하다.
		ArrayList<Item> list = new ArrayList<>();
		
		// list.add(123);
		// list.add("Hello");
		list.add(new Item());
		
		for(int i=0; i<list.size(); i++) {
			
		}
	}
	
	// List와 유사하나, 중복값을 허용하지 않는 동적배열
	public void checkSet() {
		HashSet<String> set = new HashSet<>();
		set.add("Hello");
		set.add("Good to see you");
		set.add("Hello");
		
		// Set은 iterator를 달아서 list처럼 순서대로 처리할 수 있다.
		Iterator<String> iterator = set.iterator();
		while(iterator.hasNext()) {
			System.out.println(iterator.next());	// Object형으로 리턴
		}
	}
	
	// Map은 Key, Value로 구성
	public void checkMap() {
		// 선언
		HashMap<String, Integer> map = new HashMap<>();
		// 입력
		map.put("key01", 123456);
		// 조회
		System.out.println(map.get("key01"));
	}
}

class Item{
	private String myName = "한승범";
	public String getMyname() {		// object array를 선언하게 된다.
		return myName;
	}
}
