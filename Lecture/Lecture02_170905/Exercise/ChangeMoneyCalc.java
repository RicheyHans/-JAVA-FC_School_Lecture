/* 
 *	�ݾ��� �����ϰ� ���� �Ž��� ���� ����ϴ� ���α׷��� �ۼ��Ͻÿ�.
 *	�Է°� : ���� �ݾ�, ���Աݾ� (10,000�� / 3,750��)
 *  ��°� : ���� �� ����(10000��, 5000��, 1000��, 500��, 100��, 50��, 10��)
 */
public class ChangeMoneyCalc {

	// ���� �� �ݾ� �迭 ����
	int[] arrayMoney = {10000, 5000, 1000, 500, 100, 50, 10}; 
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ChangeMoneyCalc cc = new ChangeMoneyCalc();
		cc.ChangeCalc(10000, 3750);
	}
	
	public void ChangeCalc(int pay, int price) {
		
		int changeMoney = pay - price;
		System.out.println("�Ž��� �� : " + changeMoney + "��");
		System.out.println("");
		
		for(int item : arrayMoney) {
			System.out.println(item+"�� �� :"+changeMoney/item+"��");
			changeMoney = changeMoney % item;
		}
	}
}
