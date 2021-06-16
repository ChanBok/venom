package controller.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import member.DAO.MemberDAO;
import member.DTO.MemberDTO;
import model.DTO.AuthInfo;

public class MemberDetailPage {
	public void memberDetail(HttpServletRequest request) {
		HttpSession session = request.getSession();
		AuthInfo authInfo = (AuthInfo)session.getAttribute("authInfo");
		String memId = authInfo.getUserId();
		MemberDAO dao = new MemberDAO();
		MemberDTO dto = dao.memInfo(memId);
		request.setAttribute("dto", dto);
	}
}
