package controller.employee;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;

import model.DAO.EmployeeDAO;
import model.DTO.EmployeeDTO;

public class EmployeeJoinAction {
   public void empInsert(HttpServletRequest request) { //반환하는거 없으니까 void
	  try {
		request.setCharacterEncoding("utf-8");
	} catch (UnsupportedEncodingException e) {
		e.printStackTrace();
	}
      EmployeeDTO dto = new EmployeeDTO();
      dto.setEmail(request.getParameter("email"));
      dto.setEmpAddress(request.getParameter("empAddress"));
      dto.setEmployeeId(request.getParameter("employeeId"));
      dto.setEmpName(request.getParameter("empName"));
      dto.setEmpPw(request.getParameter("empPw"));
      dto.setEmpUserid(request.getParameter("empUserid"));
      dto.setHireDate(request.getParameter("hireDate"));
      dto.setJobId(request.getParameter("jobId"));
      dto.setOfficeNumber(request.getParameter("officeNumber"));
      dto.setPhNumber(request.getParameter("phNumber"));
      EmployeeDAO dao = new EmployeeDAO();
      dao.empInsert(dto);
   
      
   }
}
// request가  page_controller 까지 넘어옴 