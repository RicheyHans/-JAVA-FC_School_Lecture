package class05092017.mainclass.fastcampus;


public class Test01 {
	//입력1 : String 타입의 마크가 되는 문자열 run("A")
	//입력2 : 출력할 줄 수 run("A", 5)
	
	public void run(String mark, int lines) {
		for(int i = 0; i < lines; i++)
		{
			for(int j = 0; j < i+1; j++) {
				System.out.print(mark);	
			}
			System.out.println("");
		}
	}
}
