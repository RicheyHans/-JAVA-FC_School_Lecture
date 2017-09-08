import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

//�����͸� �����ϴ� ����Ҹ� �����ϴ� ��ü
public class Model {
	private final String DB_DIR = "C:/workspace/java/database";
	private final String DB_FILE = "memo.txt";
	private File database = null;
	
	// ��ü �޸� �����ϴ� �����
	ArrayList<Memo> list = new ArrayList<>();
	// ����� ����ڰ� Ŭ���� �� �ϸ� �������� ��� �ҷ��´�. �׷��Ƿ� �� ����Ʈ �� �� Ŭ���� �� �� �ؾ� �Ѵ�.�ߺ����� �ʰ�.
	
	// ������ �۹�ȣ�� �����ϴ� ����
	int lastIndex = 0;
	
	public Model() {
		// ������
		File dir = new File(DB_DIR);
		// ���丮 ���� üũ
		if(!dir.exists()) {
			dir.mkdirs();	// ��λ� ���丮�� ������ �ڵ� ����
		}
		// DB���� �� ���� ����
		File file = new File(DB_DIR+File.separator+DB_FILE);
		// separator�� OS�� �����ð� �ٸ� �� �ֱ⿡ �����ϰ� ����Ѵ�.
		
		// ���� ���� Ȯ�� �� ������ ����
		if(!file.exists()){
			try {
				file.createNewFile();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		database = file;
	}
	
	final private String COLUMN_SEP="::";
	
	// �� �ϳ��� ������ �޸𸮸� ����ҷ� �̵�
	public void create(Memo memo){
	// �۹�ȣ
		memo.no = ++lastIndex;
		FileOutputStream fos = null;
		
		// memo��ü�� ������ ���Ͽ� ����. 
		// 1. ������ ���� ��Ʈ���� ����.
		try {
			fos = new FileOutputStream(database, true);
			// 2. ��Ʈ���� �߰� ó���� �Ѵ�. (�ؽ�Ʈ�� encoding�� �����ϴ� �۾�)
			// �ؽ�Ʈ�� ���ڵ��� �����ϰ�, ��Ÿ ���� ������ �߰�ó�� ���� �ʴ´�.
			OutputStreamWriter osw = new OutputStreamWriter(fos);	// ���� ��Ʈ��
			// 3. ���� ó��
			BufferedWriter bw = new BufferedWriter(osw);
			
			// �޸𿡼� ������ ������ �����ڷ� �и��Ͽ� ������ ���ڿ��� �ٲپ� �����´�.
			String row = memo.no+COLUMN_SEP 
					+memo.name+COLUMN_SEP+memo.content
					+COLUMN_SEP+"\n";
			
			bw.append(row);	// IOException ����ó�� �߰�
			bw.flush();	// ����
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {	
			// ��Ʈ���� �����Ǳ� ���� ������ �߻��� ���� �����Ƿ� nullüũ�� ���� �ؾ��Ѵ�.
			if(fos != null) {
			try {
				fos.close();
			} catch (IOException e) {
				e.printStackTrace();
				}		
			}
		}
		// �� �ϳ��� ������ �޸𸮸� ����ҷ� �̵�
		// list.add(memo);
		// ������ ������, ��Ʈ���� ������� �Ѵ�.
	}
	
	public ArrayList<Memo> getList(){
		//�����Ͱ� �ߺ��ؼ� ������ �ʵ��� ����Ҹ� �����ش�.
		list.clear();
		
		// 1. ��ũ�� �޸� �������Ƿ� �д� ��Ʈ���� �����Ѵ�.
		try(FileInputStream fis = new FileInputStream(database);){	//try-with ������ �ڵ����� fis.close(); �߻�
			// 2. ���� ���� ���ڵ��� �ٲپ��ִ� ���� Ŭ������ ����Ѵ�.
			InputStreamReader isr = new InputStreamReader(fis,"UTF-8");	// ASCII�� �ƴ� ���ڵ� Ÿ��
			// 3. ����ó��
			BufferedReader br = new BufferedReader(isr);
			
			String row;
			// while, ���ο� ���� �� �پ� �о row�� �����ϰ�
			// �� �̻� ���� �����Ͱ� ������ null�� ���ϵǹǷ� ������ ����ȴ�.
			while((row = br.readLine()) != null){		// �ؽ�Ʈ���� �� �پ� �� �о�´�. �� �� ����.
				
				String tempRow[] = row.split(COLUMN_SEP);	// �� ���� �÷� ���۷����ͷ� �и�
				// 1::aaaa::bbbb::cccc
				// tempRow[0] = 1
				// tempOrw[1] = aaaa
				// temprow[2] = bbbb
				// tempRow[3] = cccc
				
				Memo memo = new Memo();
				
				memo.no = Integer.parseInt(tempRow[0]);
				memo.name = tempRow[1];
				memo.content = tempRow[2];
				memo.datetime = Long.parseLong(tempRow[3]);
				
				list.add(memo);	
			}
		} catch(Exception e) {
			e.printStackTrace();
		} 
		return list;
	}
}
