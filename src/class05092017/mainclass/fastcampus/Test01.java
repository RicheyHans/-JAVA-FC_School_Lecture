package class05092017.mainclass.fastcampus;

/*	
 * 	(ÀÔ·Â°ª "A",5)
 *	A
 * 	AA
 * 	AAA
 *	AAAA
 *	AAAAA
 */

public class Test01 {
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
