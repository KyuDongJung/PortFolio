package todo.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import todo.model.service.TodoService;

@WebServlet("/delete")
public class DeleteServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			String listTitle = req.getParameter("listTitle");
			
			int result = new TodoService().deleteList(listTitle);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
