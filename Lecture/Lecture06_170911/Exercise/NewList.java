
public class NewList<T> {
	private Object[] list;
	
	public NewList() {				// ���� ���� ���� ���¿��� ������ ���� üũ�� �� �� �ֱ� ������, ����Ҹ� �ʱ�ȭ ���ִ� �۾��� �ʿ�
		// if(target instanceOf xxx)
		list = (T[])new Object[1];
	}
	
	public void add(T item) {
		// �迭�� �� �� �������� ũ�⸦ �ٲ� �� ����. �迭�� ũ�⸦ �ӽ÷� �÷��� ���
		Object[] tempList = new Object[size()+1];
		for(int i = 0; i<list.length; i++) {
			tempList[i] = list[i];
		}
		tempList[list.length] = item;
		list = tempList;
	}
	
	public T get(int i) {
		T result = null;
		
		return result;
	}
	
	public void remove(int position) {
		// �迭�� ũ�⸦ �ӽ÷� �÷� ���
		Object[] tempList = new Object[size()-1];
		// position ������ �����͸� �ӽð������� ����
		for(int i = 0; i < position; i++) {
			tempList[i] = list[i];
		}
		for(int i = position+1 ; i < list.length; i++) {
			tempList[i-1] = list[i];
		}
		list = tempList;
	}
	
	public int size() {
		return list.length - 1;
	}
}