package gdu.diary.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import gdu.diary.service.MemberService;
import gdu.diary.vo.Member;

//로그인 폼과 액션: 로그인 컨트롤러 doget-> 로그인 뷰 -> 로그인 컨트롤러 doPost -> 서비스 -> dao -> 서비스 -> 컨트롤러doPost 
@WebServlet("/login")
public class LoginController extends HttpServlet {
	private MemberService memberService;
	//로그인 폼
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/view/login.jsp").forward(request, response);
	}
	//로그인 액션
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//request 로그인을 위해서 id pw를 받음
		String memberId = request.getParameter("memberId");
		String memberPw = request.getParameter("memberPw");
		
		Member member = new Member();
		member.setMemberId(memberId);
		member.setMemberPw(memberPw);
		System.out.println(member.toString());
		//멤버 서비스와 연결
		memberService = new MemberService();
		//returnMember가 있으면 로그인 성공 없으면 로그인 실패
		Member returnMember = this.memberService.getMemberByKey(member);
		
		if(returnMember == null) {
			System.out.println("로그인 실패");
		} else {
			//로그인 성공하면 세션에 sessionMember 값을 넣어줌
			System.out.println("로그인 성공");
			HttpSession session = request.getSession();
			session.setAttribute("sessionMember", returnMember);
		}
		//로그인 성공 후 돌아감
		response.sendRedirect(request.getContextPath()+"/login");
	}
	
}
