package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import db.DBHelper;
import vo.Employees;

public class EmployeesDao {
	// employees 테이블 리스트 first_name 정렬하여 리턴하는 메소드
	public List<Employees> selectEmployeesListOrderBy(String order) {
		// 단위 테스트
		System.out.println("EmployeesDao.selectEmployeesListOrderBy() param order: " + order);
		// 리턴할 리스트 생성
		List<Employees> list = new ArrayList<Employees>();
		// 동적 쿼리 구현
		String sql = null;
		if(order.equals("asc")) {
			sql = "SELECT emp_no, birth_date, first_name, last_name, gender, hire_date FROM employees ORDER BY first_name ASC LIMIT 50";
		} else if(order.equals("desc")) {
			sql = "SELECT emp_no, birth_date, first_name, last_name, gender, hire_date FROM employees ORDER BY first_name DESC LIMIT 50";
		}
		// try-catch에 쓸 변수 선언
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			// DB연결 , 드라이버 로딩
			conn = DBHelper.getConnection();
			// 쿼리 저장
			stmt = conn.prepareStatement(sql);
			// 쿼리 실행
			rs = stmt.executeQuery();
			// 결과값 departments타입으로 list에 저장
			while(rs.next()) {
				Employees employees = new Employees();
				employees.setEmpNo(rs.getInt("emp_no"));
				employees.setBirthDate(rs.getString("birth_date"));
				employees.setFirstName(rs.getString("first_name"));
				employees.setLastName(rs.getString("last_name"));
				employees.setGender(rs.getString("gender"));
				employees.setHireDate(rs.getString("hire_date"));
				list.add(employees);
			}
		} catch(Exception e) { 
			e.printStackTrace();
		} finally {
			// 자원 반납
			DBHelper.close(rs, conn, stmt);
		}

		return list;
	}
	// employees 리스트 리턴하는 메소드
	public List<Employees> selectEmployeesListByLimit(int limit) {
		// 단위 테스트
		System.out.println("EmployeesDao.selectEmployeesListByLimit() param limit: " + limit);
		List<Employees> list = new ArrayList<Employees>();
		// try-catch에 쓸 변수 선언
		final String SQL = "SELECT emp_no, birth_date, first_name, last_name, gender, hire_date FROM employees LIMIT ?";
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			// DB연결 , 드라이버 로딩
			conn = DBHelper.getConnection();
			// 쿼리 저장
			stmt = conn.prepareStatement(SQL);
			// 쿼리 완성
			stmt.setInt(1, limit);
			// 쿼리 실행
			rs = stmt.executeQuery();
			// 결과값 departments타입으로 list에 저장
			while(rs.next()) {
				Employees employees = new Employees();
				employees.setEmpNo(rs.getInt("emp_no"));
				employees.setBirthDate(rs.getString("birth_date"));
				employees.setFirstName(rs.getString("first_name"));
				employees.setLastName(rs.getString("last_name"));
				employees.setGender(rs.getString("gender"));
				employees.setHireDate(rs.getString("hire_date"));
				list.add(employees);
			}
		} catch(Exception e) { 
			e.printStackTrace();
		} finally {
			// 자원 반납
			DBHelper.close(rs, conn, stmt);
		}

		return list;
	}
	// employees 테이블의 전체 행 카운트 리턴하는 메소드
	public int selectEmployeesCount() {
		int count = 0;
		// try-catch에서 쓸 변수들 미리 선언, 변수 생명주기 {}
		final String SQL = "SELECT COUNT(*) FROM employees";
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			// 드라이버 로딩, DB연결
			conn = DBHelper.getConnection();
			// 쿼리문 저장
			stmt = conn.prepareStatement(SQL);
			//쿼리문 실행
			rs = stmt.executeQuery();
			// 결과값 저장하여 리턴
			if(rs.next()) {
				count = rs.getInt("COUNT(*)");
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			// 자원 반납
			DBHelper.close(rs, conn, stmt);
		}
		
		return count;
	}
}
