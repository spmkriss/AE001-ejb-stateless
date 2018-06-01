package pl.javastart.servlet;

import java.io.IOException;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pl.javastart.ejb.TaskRepository;
import pl.javastart.model.TodoTask;


public class TaskServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Inject
	private TaskRepository taskRepo;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<TodoTask> tasklist = taskRepo.getAll();
		request.setAttribute("tasks", tasklist);
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String taskName = request.getParameter("taskName");
		String taskDesc = request.getParameter("taskDesc");
		
		TodoTask task = new TodoTask(taskName, taskDesc);
		taskRepo.add(task);
		response.sendRedirect(request.getContextPath());
	}

}
