/*
 *  로또번호 추첨 프로그램을 작성하시오.
 *  (6개의 임의의 정수 추출 / 중복 불가)
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
	

	/* 참고
	 * 	public List<Integer> getLottoNumber(){ 
	 * 	ArrayList<Integer> result = new ArrayList();
	 *  Set<Integer> treeSet = new TreeSet<>();
	 *  
	 *  Random random = new Random();
	 * 
	 *  for(int i=6; i != treeSet.size(); //증감없음) { 
	 *  	treeSet.add(random.nextInt(45)+1);
	 *  
	 *   }
	 * 	Iterator iterator = treeSet.iterator();
	 *  while(iterator.hasNext()){ 
	 *  		result.add(iterator.next());
	 *  	} 
	 * 	return result;
	 * }
	 *  // 동적 배열 - 크기를 제한하지 않는 객체 배열
	 *  // 종류 : List, Set, Map
	 *  // List : 인덱스와 값을 갖고있는 배열
	 *  // Set : List와 유사한데, 중복 값이 입력되지 않는다.
	 *  // Map : 키와 값을 가진 동적 배열, 값의 중복이 허용 키는 불허
	 *     Map.map = new HashMap();
	 *     map.put("key", 33); 
	 * */
	
}
