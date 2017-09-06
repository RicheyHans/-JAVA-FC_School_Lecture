/*
 * (ÀÔ·Â°ª "x",5)
 * 	    x
 * 	   x x
 * 	  x   x  
 * 	 x     x
 * 	xxxxxxxxx	
 */

public class Test03_06 {
	public void run(String mark, int lines) {
		for(int i = 0; i < lines; i++) {
			for(int j = lines; j > i; j-- ) {
				System.out.print(" ");
			}
			for(int k = 0; k <=(i*2); k++) {
				if(k == 0 || k == (i*2)) {
					System.out.print(mark);
				} else if(i == lines-1){
					System.out.print(mark);
				} else{ System.out.print(" ");}
			}
			System.out.println("");
		}
		System.out.println("---------------");	
	}
}
