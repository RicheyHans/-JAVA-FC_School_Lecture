package class05092017.mainclass.fastcampus;

public class Test0305 {
	public void run0305(String mark, int lines) {
		for(int i=0; i<lines; i++) {
			for(int j=lines-1; j>i; j--) {
				System.out.print(" ");
			}
			for(int k=0; k<=(i*2); k++) {
				if(k==0 || k==(i*2)) {
				System.out.print(mark);
				} else { System.out.print(" ");}
				
			}
			System.out.println("");
		}
	}
}
