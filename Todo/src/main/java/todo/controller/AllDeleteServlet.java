package todo.controller;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import todo.model.service.TodoService;

@WebServlet("/alldelete")
public class AllDeleteServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			
			int result = new TodoService().alldelete();
			if(result > 0) {
				resp.getWriter().println("삭제 성공");
			}else {
				resp.getWriter().println("삭제 실패");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
}
