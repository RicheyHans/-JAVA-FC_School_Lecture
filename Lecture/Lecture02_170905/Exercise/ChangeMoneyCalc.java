/* 
 *	금액을 지불하고 남은 거스름 돈을 계산하는 프로그램을 작성하시오.
 *	입력값 : 지불 금액, 구입금액 (10,000원 / 3,750원)
 *  출력값 : 권종 별 갯수(10000원, 5000원, 1000원, 500원, 100원, 50원, 10원)
 */
public class ChangeMoneyCalc {

	// 권종 별 금액 배열 선언
	int[] arrayMoney = {10000, 5000, 1000, 500, 100, 50, 10}; 
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ChangeMoneyCalc cc = new ChangeMoneyCalc();
		cc.ChangeCalc(10000, 3750);
	}
	
	public void ChangeCalc(int pay, int price) {
		
		int changeMoney = pay - price;
		System.out.println("거스름 돈 : " + changeMoney + "원");
		System.out.println("");
		
		for(int item : arrayMoney) {
			System.out.println(item+"원 권 :"+changeMoney/item+"장");
			changeMoney = changeMoney % item;
		}
	}
}
