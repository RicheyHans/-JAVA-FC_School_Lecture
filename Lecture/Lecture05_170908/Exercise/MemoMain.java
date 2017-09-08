
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class MemoMain {

	Model model = new Model();
	View view = new View();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 입력을 받아서 처리하는 도구
		Scanner scanner = new Scanner(System.in);
		MemoMain main = new MemoMain();
		
		// 명령어를 입력받아서 후속 처리
		String command ="";
		
		while(!command.equals("exit")){
			main.view.println("-----------명령어를 입력하세요-----------");
			main.view.println("c : 쓰기, r : 읽기, u : 수정, d : 삭제, l : 목록");
			main.view.println("exit : 종료");
			main.view.println("-----------------------------------");
				command = scanner.nextLine();		// 키보드 입력중에 엔터키가 입력될 때 까지 대기
				// 명령어를 분기처리
				switch(command) {
				case "c":
					Memo memo = main.view.create(scanner);
					// 메모 데이터에 대한 조작이 필요할 경우 모두 컨트롤러에서 작업한다. 
					main.model.create(memo);
					break;
				case "r":
					main.read(scanner);
					break;
				case "u":
					main.update(scanner);
					break;
				case "d":
					main.delete(scanner);
					break;
				case "l":
					main.showList();
					break;
				}
		}
		System.out.println("시스템 종료");
	}
	
	public void read(Scanner scanner) {
		view.println("글번호를 입력하세요");
		//------숫자 미입력시 예외처럼------//
		String tempNo = scanner.nextLine();
		int no = Integer.parseInt(tempNo);
		for(Memo memo : model.list) {
			if(memo.no == no) {
				view.println("| No:"+memo.no);
				view.println("| Author:"+memo.name);
				view.println("| Content:"+memo.content);
				
				// long타입으로 받은 날짜값을 실제 날짜로 변경
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
				String formattedDate = sdf.format(memo.datetime);
				view.println(formattedDate);
				break;
			}
		}
	}
	
	public void update(Scanner scanner) {
		System.out.println("수정할 글번호를 입력하세요");
		String tempNo = scanner.nextLine();
		int no = Integer.parseInt(tempNo);
		for(Memo memo : model.list) {
			if(memo.no == no) {
				view.println("이름을 입력하세요");
				memo.name = scanner.nextLine();
				view.println("내용을 입력하세요");
				memo.content = scanner.nextLine();
				// 날짜
				memo.datetime = System.currentTimeMillis();
				break;
			}
		}
	}
	
	public void showList() {	
		for(Memo memo : model.list) {
			view.print("No:"+memo.no);
			view.print("||Author:"+memo.name);
			view.println("||Content:"+memo.content);
		}
	}
	
	public void delete(Scanner scanner) {
		view.println("삭제할 글번호를 입력하세요");
		String tempNo = scanner.nextLine();
		int no = Integer.parseInt(tempNo);
		for(Memo memo : model.list) {
			if(memo.no == no) {
				model.list.remove(memo);
				break;
			}
		}
	}
}

// 화면 입출력을 관리하는 객체
class View{
	public Memo create(Scanner scanner) {		// 메모를 하나 생성해 저장
		// 글 하나를 저장하기 위한 메모리공간 확보
		Memo memo = new Memo();
		
		println("이름을 입력하세요");
		memo.name = scanner.nextLine();
		println("내용을 입력하세요");
		memo.content = scanner.nextLine();
		
		// 날짜
		memo.datetime = System.currentTimeMillis();
		
		return memo;
	}
	
	public void print(String string) {
		System.out.print(string);
	}
	
	public void println(String string) {
		System.out.println(string);
	}
}

// 개별 글 한개를 저장하는 클래스
class Memo{
	int no;
	String name;
	String content;
	long datetime;
}