package class05092017.mainclass.fastcampus;


public class Test01 {
	//�Է�1 : String Ÿ���� ��ũ�� �Ǵ� ���ڿ� run("A")
	//�Է�2 : ����� �� �� run("A", 5)
	
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
