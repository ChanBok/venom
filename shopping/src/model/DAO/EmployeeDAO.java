package model.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.DTO.EmployeeDTO;

public class EmployeeDAO {
	final String COLUMNS = "EMPLOYEE_ID, EMP_USERID, EMP_PW, EMP_NAME, HIRE_DATE, JOB_ID, PH_NUMBER, OFFICE_NUMBER, EMP_EMAIL, EMP_ADDRESS";
	static String jdbcDriver;
	static String jdbcUrl;
	static Connection conn;
	String sql;
	PreparedStatement pstmt;
	Integer result;
	ResultSet rs;
	
	static {
		jdbcDriver = "oracle.jdbc.driver.OracleDriver";
		jdbcUrl = "jdbc:oracle:thin:@localhost:1521:xe";
	}
	
	public List<EmployeeDTO> getEmpList() {
		List<EmployeeDTO> list = new ArrayList<EmployeeDTO>();
		sql = "select "+COLUMNS+" from employees";
		getConnect();
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				EmployeeDTO dto = new EmployeeDTO();
				dto.setEmployeeId(rs.getString("EMPLOYEE_ID"));
				dto.setEmpUserid(rs.getString(2));
				dto.setEmpPw(rs.getString("EMP_PW"));
				dto.setEmpName(rs.getString(4));
				dto.setHireDate(rs.getString("HIRE_DATE"));
				dto.setPhNumber(rs.getString("PH_NUMBER"));
				dto.setJobId(rs.getString("JOB_ID"));
				dto.setOfficeNumber(rs.getString("OFFICE_NUMBER"));
				dto.setEmail(rs.getString("EMP_EMAIL"));
				dto.setEmpAddress(rs.getString("EMP_ADDRESS"));
				list.add(dto);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return list;
	}
	
	public void getConnect() {
		try {
			Class.forName(jdbcDriver);
			conn = DriverManager.getConnection(jdbcUrl,"venom" , "oracle");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	public int getEmpNo() {
		getConnect();
		sql = "select nvl(max(employee_id), 10000) + 1 from employees";
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			rs.next();
			result = rs.getInt(1);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		
		return result;
	}
	public void empInsert(EmployeeDTO dto) {
		sql = "insert into employees (" + COLUMNS + ")"
				+ "values(?,?,?,?,?,?,?,?,?,?)";
		getConnect();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getEmployeeId());
			pstmt.setString(2, dto.getEmpUserid());
			pstmt.setString(3, dto.getEmpPw());
			pstmt.setString(4, dto.getEmpName());
			pstmt.setString(5, dto.getHireDate());
			pstmt.setString(6, dto.getJobId());
			pstmt.setString(7, dto.getPhNumber());
			pstmt.setString(8, dto.getOfficeNumber());
			pstmt.setString(9, dto.getEmail());
			pstmt.setString(10, dto.getEmpAddress());
			result = pstmt.executeUpdate();
			System.out.println(result + "??? ?????? ?????????????????????.");
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			close();
		}
	}
	private void close() {
		if(rs != null) try {rs.close();}
		catch (SQLException e) {}
		if(pstmt != null) try {pstmt.close();}
		catch (SQLException e) {}
		if(conn != null) try {conn.close();}
		catch (SQLException e) {}
	}
	// pstmt??? ???????????? ???????????? ????????? ??????.
	public EmployeeDTO empInfo(String empId) {
		EmployeeDTO dto = new EmployeeDTO();
		sql = "select " + COLUMNS + " from employees " + " where employee_id = ? ";
		getConnect();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, empId);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				dto.setEmployeeId(rs.getString("EMPLOYEE_ID"));
				dto.setEmpUserid(rs.getString(2));
				dto.setEmpPw(rs.getString("EMP_PW"));
				dto.setEmpName(rs.getString(4));
				dto.setHireDate(rs.getString("HIRE_DATE"));
				dto.setPhNumber(rs.getString("PH_NUMBER"));
				dto.setJobId(rs.getString("JOB_ID"));
				dto.setOfficeNumber(rs.getString("OFFICE_NUMBER"));
				dto.setEmail(rs.getString("EMP_EMAIL"));
				dto.setEmpAddress(rs.getString("EMP_ADDRESS"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dto;
	}
	public void empUpdate(EmployeeDTO dto) {
		sql = "update employees set job_id = ?, ph_number = ?, office_number = ?, emp_email = ?, emp_address = ? where employee_id = ?";
		getConnect();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getJobId());
			pstmt.setString(2, dto.getPhNumber());
			pstmt.setString(3, dto.getOfficeNumber());
			pstmt.setString(4, dto.getEmail());
			pstmt.setString(5, dto.getEmpAddress());
			pstmt.setString(6, dto.getEmployeeId());
			int i = pstmt.executeUpdate();
			System.out.println(i + "??? ?????? ?????????????????????.");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void empDelete(String empId) {
		sql = "delete from employees where employee_id = ?";
		getConnect();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, empId);
			int i = pstmt.executeUpdate();
			System.out.println(i + "??? ?????? ?????????????????????.");
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close();
		}
	}
}
