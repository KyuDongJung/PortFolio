package todo.model.service;

import java.sql.Connection;
import java.util.List;

import static todo.common.JDBCTemplete.*;
import todo.model.dao.TodoDAO;
import todo.model.vo.Todo;

public class TodoService {
	
	private TodoDAO dao = new TodoDAO();
	
	public int addList(String listTitle) throws Exception {
		
		Connection conn = getConnection();
		
		int result = dao.addList(conn, listTitle);
		System.out.println("ttttt" + result);
		
		if(result > 0) commit(conn);
		else			rollback(conn);
		
		close(conn);
		return result;
	}

	public int updateList(String span) throws Exception{
		Connection conn = getConnection();
		
		int result = dao.updateList(conn, span);
		
		if(result > 0) commit(conn);
		else			rollback(conn);
		
		close(conn);
		return result;
		
	}

	public int deleteList(String listTitle) throws Exception {
		Connection conn = getConnection();
		
		int result = dao.deleteList(conn, listTitle);
		
		if(result > 0) commit(conn);
		else			rollback(conn);
		
		close(conn);
		return result;		
	}

	public int alldelete() throws Exception{
		Connection conn = getConnection();
		
		int result = dao.alldelete(conn);
		
		if(result > 0) commit(conn);
		else			rollback(conn);
		
		close(conn);
		return result;
	}

	public List<Todo> selectAll() throws Exception{
		Connection conn = getConnection();
		
		List<Todo> todoList = dao.selectAll(conn);
		
		close(conn);
		
		return todoList;
	}

	public int updateList2(String span) throws Exception {
		Connection conn = getConnection();
		
		int result = dao.updateList2(conn, span);
		
		if(result > 0) commit(conn);
		else			rollback(conn);
		
		close(conn);
		return result;
	}

	public String selectComplete(String span) throws Exception{
		Connection conn = getConnection();
		
		String result = dao.selectComplete(conn, span);
		
		close(conn);
		
		return result;
	}

}
