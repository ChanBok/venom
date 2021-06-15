package controller.member;

import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import member.DAO.MemberDAO;
import member.DTO.MemberDTO;

public class MemberModifyPage {
	public void empUpdate(HttpServletRequest request) {
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		MemberDTO dto = new MemberDTO();
		dto.setDetailAdd(request.getParameter("detailAdd"));
		dto.setMemAccount(request.getParameter("memAccount"));
		dto.setMemAddress(request.getParameter("memAddress"));
		dto.setMemEmail(request.getParameter("memEmail"));
		dto.setMemEmailCk(request.getParameter("memEmailCk"));
		dto.setMemPhon(request.getParameter("memPhon"));
		dto.setPostNumber(request.getParameter("postNumber"));
		dto.setMemId(request.getParameter("memId"));
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
		Date memBirth = null;
		try {
			memBirth = sf.parse(request.getParameter("memBirth"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		dto.setMemBirth(memBirth);
		MemberDAO dao = new MemberDAO();
		dao.memUpdate(dto);
	}
}
