/*
 *  �ζǹ�ȣ ��÷ ���α׷��� �ۼ��Ͻÿ�.
 *  (6���� ������ ���� ���� / �ߺ� �Ұ�)
 */

public class LottoMachine {
	
	int[] result = new int[6];

	public static void main(String[] args) {
		LottoMachine lm = new LottoMachine();
		int[] result = lm.getLottoNumbers();
		for(int item : result) {
			System.out.println(item);
		}
	}
	
	public int[] getLottoNumbers() {
		for(int i = 0; i < 6; i++) {
			result[i] = (int) (Math.random()*45);				
			for(int j = 0; i < j; j++) {
				if(result[i] == result[j]) {
					i--;
					break;
				}
			}
		}
		return result;
	}
	

	/* ����
	 * 	public List<Integer> getLottoNumber(){ 
	 * 	ArrayList<Integer> result = new ArrayList();
	 *  Set<Integer> treeSet = new TreeSet<>();
	 *  
	 *  Random random = new Random();
	 * 
	 *  for(int i=6; i != treeSet.size(); //��������) { 
	 *  	treeSet.add(random.nextInt(45)+1);
	 *  
	 *   }
	 * 	Iterator iterator = treeSet.iterator();
	 *  while(iterator.hasNext()){ 
	 *  		result.add(iterator.next());
	 *  	} 
	 * 	return result;
	 * }
	 *  // ���� �迭 - ũ�⸦ �������� �ʴ� ��ü �迭
	 *  // ���� : List, Set, Map
	 *  // List : �ε����� ���� �����ִ� �迭
	 *  // Set : List�� �����ѵ�, �ߺ� ���� �Էµ��� �ʴ´�.
	 *  // Map : Ű�� ���� ���� ���� �迭, ���� �ߺ��� ��� Ű�� ����
	 *     Map.map = new HashMap();
	 *     map.put("key", 33); 
	 * */
	
}
