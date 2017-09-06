package class04092017.mainclass.fastcampus;

public class Sub {
	public String changeNumberToString(int number) {
		//return Integer.toString(number);
		return number+"";
	}
	
	public int changeStringToInteger(String str) {
		return Integer.parseInt(str);
	}
	
	int sum = changeStringToInteger("13");
}
