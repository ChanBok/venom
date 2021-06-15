package controller.member;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import member.DAO.MemberDAO;
import member.DTO.MemberDTO;


public class MemberListPage {
	public void memList(HttpServletRequest request) {
		MemberDAO dao = new MemberDAO();
		List<MemberDTO> list = dao.getMemList();
		request.setAttribute("lists", list);
	}
}
