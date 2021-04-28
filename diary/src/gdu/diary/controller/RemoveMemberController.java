package gdu.diary.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import gdu.diary.service.MemberService;
import gdu.diary.vo.Member;

/**
 * Servlet implementation class RemoveMemberController
 */
@WebServlet("/auth/removeMember")
public class RemoveMemberController extends HttpServlet {
	private MemberService memberService;
	//비밀번호 입력 폼 - 뷰로 연결
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/view/auth/removeMemberTest.jsp").forward(request, response);
	}
	
	//삭제 액션
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//세션에서 member(memberNo, memberId) 받고 removeMember에서 받음 pw를 넣어줌
		Member member = (Member)request.getSession().getAttribute("sessionMember");
		//requset 처리 - 삭제를 확인하기 위해서 비밀번호 입력
		String memberPw = request.getParameter("memberPw");
		member.setMemberPw(memberPw);
		
		this.memberService = new MemberService();
		boolean result = this.memberService.removeMemberByKey(member);
		if(result == false) {//if(!result) //회원탈퇴 실패하면 removeMember 폼으로 돌아감
			System.out.println("회원탈퇴 실패!");
			response.sendRedirect(request.getContextPath()+"/auth/removeMember");
			return;
		}
		response.sendRedirect(request.getContextPath()+"/auth/logout");
	}
}
