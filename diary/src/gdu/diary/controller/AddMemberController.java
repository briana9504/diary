package gdu.diary.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import gdu.diary.service.MemberService;
import gdu.diary.vo.Member;

@WebServlet("/addMember")
public class AddMemberController extends HttpServlet {
	private MemberService memberService;
	//회원가입 폼으로
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/view/addMember.jsp").forward(request, response);
	}
	//회원가입 액션
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//request처리
		String memberId = request.getParameter("memberId");
		String memberPw = request.getParameter("memberPw");
	
		Member member = new Member();
		member.setMemberId(memberId);
		member.setMemberPw(memberPw);
		System.out.println(member.toString());
		
		this.memberService = new MemberService();
		
		boolean check = this.memberService.checkMemberIdAndAddMember(member);
		if(check == false) {
			response.sendRedirect(request.getContextPath()+"/addMember");
			return;
		}
		/*
		//아이디 유효성검사
		if(this.memberService.checkMemberIdForInsert(member) != null) {
			System.out.println("이미 사용중인 아이디입니다.");
			response.sendRedirect(request.getContextPath()+"/insertMember");
			return;
		}
		//회원가입
		this.memberService.addMember(member);
		*/
		//회원가입 성공
		response.sendRedirect(request.getContextPath()+"/login");
	}
}
