package todo.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import todo.model.service.TodoService;
import todo.model.vo.Todo;

@WebServlet("/selectAll")
public class AllSelectServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			TodoService service = new TodoService();
			
			List<Todo> todoList = service.selectAll();
			
			new Gson().toJson(todoList, resp.getWriter());
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
