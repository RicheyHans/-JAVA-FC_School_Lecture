// �ζǹ�ȣ �����⸦ �ϼ��Ͻÿ�
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
			// ������ �ߺ�����X, 0X
		}
		return result;
	}
	
	/* �ٸ� Ǯ��
	 * public int[] getLottoNumbers(){
	 * 
	 * int[] result = new int[6];
	 * 
	 * Random random = new Random();
	 * int temp = 0;
	 * int cnt = 0;
	 * for(int i=0; i<result.length; i++){
	 * 	temp = random.nextInt(45)+1;
	 * if(cnt > 0){ 
	 * 	for(int item : result){ 
	 *		while(item == temp){ 
	 *			temp = random.nextInt(45)+1;
	 *		} 
	 *    }
	 *   }
	 * 		result[cnt] = temp;
	 * 		cnt++;
	 * }
	 * 	return result;
	 * }
	 */

	/* ����
	 * public List<Integer> getLottoNumber(){ 
	 * 	ArrayList<Integer> result = new ArrayList();
	 *  Set<Integer> treeSet = new TreeSet<>();
	 *  
	 *  Random random = new Random();
	 *  // ���� �迭 - ũ�⸦ �������� �ʴ� ��ü �迭
	 *  // ���� : List, Set, Map
	 *  // List : �ε����� ���� �����ִ� �迭
	 *  // Set : List�� �����ѵ�, �ߺ� ���� �Էµ��� �ʴ´�.
	 *  // Map : Ű�� ���� ���� ���� �迭, ���� �ߺ��� ��� Ű�� ����
	 *     Map.map = new HashMap();
	 *     map.put("key", 33); 
	 *  
	 *  for(int i=6; i != treeSet.size(); //��������) { 
	 *  	treeSet.add(random.nextInt(45)+1);
	 *  
	 *   }
	 * 	Iterator iterator = treeSet.iterator();
	 *  while(iterator.hasNext()){ 
	 *  		result.add(iterator.next());
	 *  	} 
	 * 
	 *  
	 *  return result;
	 * 
	 * }
	 * */
}
