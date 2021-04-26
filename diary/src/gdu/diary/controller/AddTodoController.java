package gdu.diary.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import gdu.diary.service.DiaryService;
import gdu.diary.service.TodoService;
import gdu.diary.vo.Member;
import gdu.diary.vo.Todo;
import gdu.diary.vo.TodoDate;


@WebServlet("/auth/addTodo")
public class AddTodoController extends HttpServlet {
	private TodoService todoService;
	//todo 입력폼 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int year = Integer.parseInt(request.getParameter("year"));
		int month = Integer.parseInt(request.getParameter("month"));
		int day = Integer.parseInt(request.getParameter("day"));
		
		System.out.printf("%s\n %s\n %s\n",year, month, day);
		
		TodoDate todoDate = new TodoDate();
		todoDate.setDay(day);
		todoDate.setMonth(month);
		todoDate.setYear(year);
		

		request.setAttribute("todoDate", todoDate);
		request.getRequestDispatcher("/WEB-INF/view/auth/addTodo.jsp").forward(request, response);
	}
	// 액션: controller.doPost()-> DiaryService -> dao -> DiaryService -> addtodoController.doPost()
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		//request정리
		int memberNo = ((Member)(session.getAttribute("sessionMember"))).getMemberNo();
		String todoDate = request.getParameter("todoDate");
		String todoTitle = request.getParameter("todoTitle");
		String todoContent = request.getParameter("todoContent");
		String todoFontColor = request.getParameter("todoFontColor");
		
		Todo todo = new Todo();
		todo.setMemberNo(memberNo);
		todo.setTodoTitle(todoTitle);
		todo.setTodoContent(todoContent);
		todo.setTodoDate(todoDate);
		todo.setTodoFontColor(todoFontColor);
		
		System.out.println(todo);//todo.toString()
		
		//서비스 호출 - db에 일정을 저장
		this.todoService = new TodoService();
		this.todoService.addTodo(todo);
		
		//그달읠 달력을 보기위해서는 년도랑 월을 넘겨줘야함 (월을 -1)해줘야함
		String[] arr = todoDate.split("-");
		//DiaryController//달력으로 돌아감
		response.sendRedirect(request.getContextPath()+"/auth/diary?targetYear="+arr[0]+"&targetMonth="+(Integer.parseInt(arr[1])-1));
	}

}
