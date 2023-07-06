package todo.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import todo.model.service.TodoService;
import todo.model.vo.Todo;


@WebServlet("/checked2")
public class CheckServlet2 extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			
			String span = req.getParameter("span");
			 int result = new TodoService().updateList2(span);
			 resp.getWriter().print(result);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}