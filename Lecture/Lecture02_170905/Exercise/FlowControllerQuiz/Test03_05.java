/*
 * 	    x
 * 	   x x
 * 	  x   x  
 * 	 x     x
 * 	x       x	
 */

public class Test03_05 {
	public void run(String mark, int lines) {
		for(int i = 0; i < lines; i++) {
			for(int j = lines; j > i; j-- ) {
				System.out.print(" ");
			}
			for(int k = 0; k <=(i*2); k++) {
				if(k == 0 || k == (i*2)) {
					System.out.print(mark);
				} else { System.out.print(" ");}
			}
			System.out.println("");
		}
		System.out.println("---------------");	
	}
}
