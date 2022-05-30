package kr.co.sist.user.DbConnection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DbConnection {

	private static DbConnection dc;
	/**
	 * Ŭ���� �ܺο��� ��üȭ�ϴ� ���� ���´�
	 */
	private DbConnection() {
		
	}
	/**
	 * DbConnection ��ü�� ��ȯ�ϴ� �� 
	 * @return
	 */
	public static DbConnection getInstance() {
		
		if(dc==null) {
			dc=new DbConnection();
			
		}
		
		return dc;
	}
	/**
	 * Connection�� ��� ��
	 * @return
	 */
	public Connection getConn() throws SQLException{
		Connection con=null;
		//1. ����̹� �ε�
		try {
		Class.forName("oracle.jdbc.OracleDriver");
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}
		//2.Ŀ�ؼ� ���
		String url="jdbc:oracle:thin:@211.63.89.133:1521:orcl";
		String id="exhibition";
		String pass="three";
		
		con=DriverManager.getConnection(url,id,pass);
		return con;
	}
	public Statement getStatement() throws SQLException {
		Statement stmt=null;
		stmt=getConn().createStatement();
		return stmt;
	}
	
	/**
	 * DBMS��������
	 * @param rs
	 * @param stmt
	 * @param con
	 * @throws SQLException
	 */
	public void close(ResultSet rs,Statement stmt,Connection con)throws SQLException{
		if(rs!=null) {rs.close();}
		if(stmt!=null) {stmt.close();}
		if(con!=null) {con.close();}
	}
}