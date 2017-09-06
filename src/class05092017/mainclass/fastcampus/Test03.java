package class05092017.mainclass.fastcampus;

public class Test03 {
	public void run03(String mark, int lines) {
		for(int i=0; i<lines; i++) {
			for(int j=lines-1; j>i; j--) {
				System.out.print(" ");
			}
			for(int k=-1; k<=(i*2)-1; k++) {
				System.out.print(mark);
			}
			System.out.println("");
		}
	}
}
/*
for(int i = 0; i < lines; i++) {
	for(int j = lines-1; j > i; j--) {
		System.out.print("x");
	}
	
	//System.out.print(mark);
	for(int m = 0; m <= i; m++) {
		System.out.print(mark);
		for(int n = 0; n <=m-1; n++) {
			System.out.print(mark);
		}
	}
	
	for(int j = lines-1; j > i; j--) {
		System.out.print("x");
	}
	System.out.println("");
}
}
*/