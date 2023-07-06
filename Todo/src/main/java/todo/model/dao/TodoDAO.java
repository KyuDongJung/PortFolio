package todo.model.dao;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import todo.model.vo.Todo;

import static todo.common.JDBCTemplete.*;
public class TodoDAO {
	
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	private Properties prop;
	
	public TodoDAO() {
		try {
			prop = new Properties();
			
			String filePath = TodoDAO.class.getResource("/todo/sql/todo-sql.xml").getPath();
			
			prop.loadFromXML(new FileInputStream(filePath));
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	public int addList(Connection conn, String listTitle) throws Exception{
		int result = 0;
		
		try {
			String sql = prop.getProperty("addList");
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, listTitle);
			
			result = pstmt.executeUpdate();
		}finally {
			close(pstmt);
		}
		return result;
	}
	public int updateList(Connection conn, String span) throws Exception{
		
		int result=0;
		try {
			String sql = prop.getProperty("updateList");
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, span);
			
			result = pstmt.executeUpdate();
		}finally {
			close(pstmt);
		}
		return result;
	}
	public int deleteList(Connection conn, String listTitle) throws Exception {
		
		int result = 0;
		try {
			String sql = prop.getProperty("deleteList");
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, listTitle);
			
			result = pstmt.executeUpdate();
		}finally {
			close(pstmt);
		}
		
		return result;
	}
	public int alldelete(Connection conn) throws Exception {
		
		int result = 0;
		
		try {
			String sql = prop.getProperty("alldelete");
			
			pstmt = conn.prepareStatement(sql);
			
			result = pstmt.executeUpdate();
			
		}finally {
			close(pstmt);
		}
		return result;
	}
	public List<Todo> selectAll(Connection conn) throws Exception{
		
		List<Todo> todoList = new ArrayList<>();
		
		try {
			String sql = prop.getProperty("selectAll");
			
			stmt = conn.createStatement();
			
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				int listNo = rs.getInt("LIST_NO");
				String listTitle = rs.getString("LIST_TITLE");
				String listDate = rs.getString("MON") + "-" + rs.getString("DAY");
				String complete = rs.getString("COMPLETE");
				
				todoList.add(
						new Todo(listNo, listTitle, listDate, complete)
						);
			}
		}finally {
			close(rs);
			close(pstmt);
		}
		return todoList;
	}
	public int updateList2(Connection conn, String span) throws Exception{
		int result=0;
		try {
			String sql = prop.getProperty("updateList2");
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, span);
			
			result = pstmt.executeUpdate();
		}finally {
			close(pstmt);
		}
		return result;
	}
	public String selectComplete(Connection conn, String span) throws Exception{
		String result = null;
		try {
			String sql = prop.getProperty("selectComplete");
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, span);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				result = rs.getString("COMPLETE");
			}
		}finally {
			close(rs);
			close(pstmt);
		}
		return result;
	}

}
