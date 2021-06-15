package controller.member;

import javax.servlet.http.HttpServletRequest;

import member.DAO.MemberDAO;
import member.DTO.MemberDTO;

public class MemberInfoPage {
	public void mamInfo(HttpServletRequest request) {
		String memId = request.getParameter("memId");
		MemberDAO dao = new MemberDAO();
		MemberDTO dto = dao.mamInfo(memId);
		request.setAttribute("dto", dto);
	}
}
