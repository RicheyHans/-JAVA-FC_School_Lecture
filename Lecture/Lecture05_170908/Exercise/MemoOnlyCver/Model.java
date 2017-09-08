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

//데이터를 저장하는 저장소를 관리하는 객체
public class Model {
	private final String DB_DIR = "C:/workspace/java/database";
	private final String DB_FILE = "memo.txt";
	private File database = null;
	
	// 전체 메모를 저장하는 저장소
	ArrayList<Memo> list = new ArrayList<>();
	// 현재는 사용자가 클릭을 막 하면 전역으로 계속 불려온다. 그러므로 겟 리스트 할 때 클리어 한 번 해야 한다.중복되지 않게.
	
	// 마지막 글번호를 저장하는 변수
	int lastIndex = 0;
	
	public Model() {
		// 생성자
		File dir = new File(DB_DIR);
		// 디렉토리 존재 체크
		if(!dir.exists()) {
			dir.mkdirs();	// 경로상 디렉토리가 없으면 자동 생성
		}
		// DB생성 후 파일 생성
		File file = new File(DB_DIR+File.separator+DB_FILE);
		// separator는 OS별 슬래시가 다를 수 있기에 안전하게 사용한다.
		
		// 파일 존재 확인 후 없으면 생성
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
	
	// 글 하나를 저장한 메모리를 저장소로 이동
	public void create(Memo memo){
	// 글번호
		memo.no = ++lastIndex;
		FileOutputStream fos = null;
		
		// memo객체의 내용을 파일에 쓴다. 
		// 1. 파일을 쓰는 스트림을 연다.
		try {
			fos = new FileOutputStream(database, true);
			// 2. 스트림의 중간 처리를 한다. (텍스트의 encoding을 변경하는 작업)
			// 텍스트만 인코딩을 변경하고, 기타 음악 영상은 중간처리 하지 않는다.
			OutputStreamWriter osw = new OutputStreamWriter(fos);	// 래퍼 스트림
			// 3. 버퍼 처리
			BufferedWriter bw = new BufferedWriter(osw);
			
			// 메모에서 저장할 내용을 구분자로 분리하여 한줄의 문자열로 바꾸어 가져온다.
			String row = memo.no+COLUMN_SEP 
					+memo.name+COLUMN_SEP+memo.content
					+COLUMN_SEP+"\n";
			
			bw.append(row);	// IOException 예외처리 추가
			bw.flush();	// 버퍼
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {	
			// 스트릶이 생성되기 전에 오류가 발생할 수도 있으므로 null체크를 먼저 해야한다.
			if(fos != null) {
			try {
				fos.close();
			} catch (IOException e) {
				e.printStackTrace();
				}		
			}
		}
		// 글 하나를 저장한 메모리를 저장소로 이동
		// list.add(memo);
		// 파일을 넣을때, 스트림을 열어줘야 한다.
	}
	
	public ArrayList<Memo> getList(){
		//데이터가 중복해서 쌓이지 않도록 저장소를 지워준다.
		list.clear();
		
		// 1. 디스크의 메모를 가져오므로 읽는 스트림을 오픈한다.
		try(FileInputStream fis = new FileInputStream(database);){	//try-with 절에서 자동으로 fis.close(); 발생
			// 2. 실제 파일 인코딩을 바꾸어주는 래퍼 클래스를 사용한다.
			InputStreamReader isr = new InputStreamReader(fis,"UTF-8");	// ASCII가 아닌 인코딩 타입
			// 3. 버퍼처리
			BufferedReader br = new BufferedReader(isr);
			
			String row;
			// while, 새로운 줄을 한 줄씩 읽어서 row에 저장하고
			// 더 이상 읽을 데이터가 없으면 null이 리턴되므로 로직이 종료된다.
			while((row = br.readLine()) != null){		// 텍스트에서 한 줄씩 다 읽어온다. 빌 때 까지.
				
				String tempRow[] = row.split(COLUMN_SEP);	// 한 줄을 컬럼 세퍼레이터로 분리
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
