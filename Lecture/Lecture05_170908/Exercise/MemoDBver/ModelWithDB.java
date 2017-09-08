
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;


//�����͸� �����ϴ� ����Ҹ� �����ϴ� ��ü

public class ModelWithDB {
	private static String URL ="jdbc:mysql://localhost:3306/memo";	
	private static String ID = "Richey";
	private static String PASSWORD = "gkstmdqja1";

	Connection con = null;

	// ������
	public ModelWithDB(){
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	// ����
	public void create(Memo memo){
		// 1. �����ͺ��̽� ����
		try(Connection con = DriverManager.getConnection(URL, ID, PASSWORD);) {
			System.out.println("���ӵǾ����ϴ�");
			// 2. ������ ����
			// 2.1 ���� ������ ���ؼ� ������ ����
			String query = " insert into memo(name, content, datetime)"
					+ " values(?,?,?)";
			// 2.2 ������ ���� ������ ���·� ������ش�.
			java.sql.PreparedStatement pstmt = con.prepareStatement(query);
			// 2.3 ����ǥ�� ���� �����Ѵ�.
			pstmt.setString(1, memo.name);
			pstmt.setString(2, memo.content);
			pstmt.setTimestamp(3, new Timestamp(System.currentTimeMillis()));
			// 2.4 ������ ����
			pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println("���ӿ���");
			e.printStackTrace();
		}
			// 3. �����ͺ��̽� ���� ����
	}

	// �б�
	public Memo read(int no){
		Memo memo = new Memo();
		// 1. �����ͺ��̽� ����
		try(Connection con = DriverManager.getConnection(URL, ID, PASSWORD);) {
		System.out.println("���ӵǾ����ϴ�");
		// 2. ������ ����
		// 2.1 ���� ������ ���ؼ� ������ ����
		String query = "select * from memo";
		// 2.2 ������ ������ ���� ������ ���·� ������ش�.
		java.sql.Statement stmt = con.createStatement();
		// 2.3 select�� ������� �����ޱ� ���� ������ ����
		ResultSet rs = stmt.executeQuery(query);
		// ������� �ݺ��ϸ鼭 �ϳ��� ���� �� �ִ�.
		if(rs.next()) {
			memo.no = rs.getInt("no");
			memo.name = rs.getString("name");
			memo.content = rs.getString("content");
			memo.datetime = rs.getLong("datetime");
		}
	} catch (Exception e) {
		e.printStackTrace();
	}
		return memo;
	}

	// ����
	public void update(Memo memo){

		

	}

	// ����

	public void delete(int no){


	}

	// ���
	public ArrayList<Memo> getList(){
		ArrayList<Memo> list = new ArrayList<>();
		// 1. �����ͺ��̽� ����
		try(Connection con = DriverManager.getConnection(URL, ID, PASSWORD);) {
		System.out.println("���ӵǾ����ϴ�");
		// 2. ������ ����
		// 2.1 ���� ������ ���ؼ� ������ ����
		String query = "select * from memo";
		// 2.2 ������ ������ ���� ������ ���·� ������ش�.
		java.sql.Statement stmt = con.createStatement();
		// 2.3 select�� ������� �����ޱ� ���� ������ ����
		ResultSet rs = stmt.executeQuery(query);
		// ������� �ݺ��ϸ鼭 �ϳ��� ���� �� �ִ�.
		while(rs.next()) {
			Memo memo = new Memo();
			memo.no = rs.getInt("no");
			memo.name = rs.getString("name");
			memo.content = rs.getString("content");
			memo.datetime = rs.getLong("datetime");
			list.add(memo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		// 3. �����ͺ��̽� ���� ����
		return list;
	}
}