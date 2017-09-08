
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class MemoMain {

	Model model = new Model();
	View view = new View();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// �Է��� �޾Ƽ� ó���ϴ� ����
		Scanner scanner = new Scanner(System.in);
		MemoMain main = new MemoMain();
		
		// ��ɾ �Է¹޾Ƽ� �ļ� ó��
		String command ="";
		
		while(!command.equals("exit")){
			main.view.println("-----------��ɾ �Է��ϼ���-----------");
			main.view.println("c : ����, r : �б�, u : ����, d : ����, l : ���");
			main.view.println("exit : ����");
			main.view.println("-----------------------------------");
				command = scanner.nextLine();		// Ű���� �Է��߿� ����Ű�� �Էµ� �� ���� ���
				// ��ɾ �б�ó��
				switch(command) {
				case "c":
					Memo memo = main.view.create(scanner);
					// �޸� �����Ϳ� ���� ������ �ʿ��� ��� ��� ��Ʈ�ѷ����� �۾��Ѵ�. 
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
		System.out.println("�ý��� ����");
	}
	
	public void read(Scanner scanner) {
		view.println("�۹�ȣ�� �Է��ϼ���");
		//------���� ���Է½� ����ó��------//
		String tempNo = scanner.nextLine();
		int no = Integer.parseInt(tempNo);
		for(Memo memo : model.list) {
			if(memo.no == no) {
				view.println("| No:"+memo.no);
				view.println("| Author:"+memo.name);
				view.println("| Content:"+memo.content);
				
				// longŸ������ ���� ��¥���� ���� ��¥�� ����
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
				String formattedDate = sdf.format(memo.datetime);
				view.println(formattedDate);
				break;
			}
		}
	}
	
	public void update(Scanner scanner) {
		System.out.println("������ �۹�ȣ�� �Է��ϼ���");
		String tempNo = scanner.nextLine();
		int no = Integer.parseInt(tempNo);
		for(Memo memo : model.list) {
			if(memo.no == no) {
				view.println("�̸��� �Է��ϼ���");
				memo.name = scanner.nextLine();
				view.println("������ �Է��ϼ���");
				memo.content = scanner.nextLine();
				// ��¥
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
		view.println("������ �۹�ȣ�� �Է��ϼ���");
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

// ȭ�� ������� �����ϴ� ��ü
class View{
	public Memo create(Scanner scanner) {		// �޸� �ϳ� ������ ����
		// �� �ϳ��� �����ϱ� ���� �޸𸮰��� Ȯ��
		Memo memo = new Memo();
		
		println("�̸��� �Է��ϼ���");
		memo.name = scanner.nextLine();
		println("������ �Է��ϼ���");
		memo.content = scanner.nextLine();
		
		// ��¥
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

// ���� �� �Ѱ��� �����ϴ� Ŭ����
class Memo{
	int no;
	String name;
	String content;
	long datetime;
}