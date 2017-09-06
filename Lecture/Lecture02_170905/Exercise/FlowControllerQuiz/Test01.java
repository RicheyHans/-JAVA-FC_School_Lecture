/*	
 * 	(ÀÔ·Â°ª "X",5)
 *	x
 * 	xx
 * 	xxx
 *	xxxx
 *	xxxxx
 */

public class Test01 {
	public void run(String mark, int lines) {
		for(int i = 0; i < lines; i++){
			for(int j = 0; j < i+1; j++) {
				System.out.print(mark);	
			}
			System.out.println("");
		}
		System.out.println("---------------");	
	}
}
