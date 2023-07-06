package todo.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import todo.model.service.TodoService;
@WebServlet("/selectComplete")
public class SelectCompleteServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
		
		TodoService service = new TodoService();
		
		String span = req.getParameter("span");
		
		String result = service.selectComplete(span);
		
		resp.getWriter().print(result);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
