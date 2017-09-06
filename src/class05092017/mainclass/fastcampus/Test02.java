package class05092017.mainclass.fastcampus;

public class Test02 {
	public void run02(String mark, int lines) {
		
		for(int i=0; i<lines;i++) {
			for(int j=lines-1; j > i; j--) {
				System.out.print(" ");
			}
			for(int k=0; k<=i; k++) {
				System.out.print(mark);
			}
			System.out.println("");
		}
	}
}