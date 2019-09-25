package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import db.DBHelper;
import vo.Employees;

public class EmployeesDao {
	// 사원 목록의 마지막 페이지를 리턴하는 메소드
	public int selectLastPage(int rowPerPage) {
		// 단위 테스트
		System.out.println("EmployeesDao.selectLastPage() param rowPerPage" + rowPerPage);
		// 전체 행의 수 리턴하는 메소드 호출하여 값 저장
		EmployeesDao employeesdao = new EmployeesDao();
		int rowCount = 0;
		rowCount = employeesdao.selectEmployeesCount();
		// 마지막 페이지 구하기
		int lastPage = 0;
		if(rowCount%rowPerPage==0) {
			lastPage = rowCount/rowPerPage;
		} else {
			lastPage = rowCount/rowPerPage +1;
		}
		
		return lastPage;
		
	}
	
	// 페이징을 위해 사원 리스트를 원하는 행의 개수만큼 리턴하는 메소드
	public List<Employees> selectEmployeesListByPage(int currentPage, int rowPerPage) {
		//단위 테스트
		System.out.println("EmployeesDao.selectEmployeesListByPage() param currentPage: " + currentPage);
		System.out.println("EmployeesDao.selectEmployeesListByPage() param rowPerPage: " + rowPerPage);
		// 리턴할 리스트 생성
		List<Employees> list = new ArrayList<Employees>();
		// try-catch에서 사용할 변수 생성
		final String SQL = "SELECT emp_no, birth_date, first_name, last_name, gender, hire_date FROM employees LIMIT ?,?";
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			// 드라이버 로딩, DB연결
			conn = DBHelper.getConnection();
			// 쿼리문 저장
			stmt = conn.prepareStatement(SQL);
			// 쿼리 완성
			// 각 페이지의 시작 행 구하기
			int beginRow = (currentPage-1)*rowPerPage;
			stmt.setInt(1, beginRow);
			stmt.setInt(2, rowPerPage);
			//쿼리문 실행
			rs = stmt.executeQuery();
			// 결과값 Employees로 List에 저장하여 리턴
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
	
	// 성별 사원 수를 리턴하는 메소드
	public List<Map<String, Object>> selectEmployeesCountGroupByGender() {
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		
		final String SQL = "SELECT gender, COUNT(gender) FROM employees GROUP BY gender";
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
			// 결과값 Map으로 List에 저장하여 리턴
			while(rs.next()) {
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("gender", rs.getString(1));
				map.put("count", rs.getInt(2));
				list.add(map);
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			// 자원 반납
			DBHelper.close(rs, conn, stmt);
		}
		
		return list;
	}
	// employees테이블 에서 emp_no 범위 사이의 사원 목록을 출력하는 메소드
	public List<Employees> selectEmployeesListBetween(int begin, int end) {
		// 단위 테스트
		System.out.println("EmployeesDao selectEmployeesListBetween() param begin: " + begin);
		System.out.println("EmployeesDao selectEmployeesListBetween() param end: " + end);
		List<Employees> list = new ArrayList<Employees>();
		
		// try-catch에 쓸 변수 선언
		final String SQL = "SELECT emp_no, birth_date, first_name, last_name, gender, hire_date FROM employees WHERE emp_no BETWEEN ? AND ? ORDER BY emp_no ASC";
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			// DB연결 , 드라이버 로딩
			conn = DBHelper.getConnection();
			// 쿼리 저장
			stmt = conn.prepareStatement(SQL);
			// 쿼리 완성
			stmt.setInt(1, begin);
			stmt.setInt(2, end);
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
	
	// employees 테이블의 emp_no의 MIN과 MAX를 구하는 메소드
	public int selectEmpNo(String str) {
		int empNo=0;
		// 단위 테스트
		System.out.println("EmployeesDao selectEmpNo() param str: " + str);
		// 동적 쿼리 구현
		String sql = null;
		if(str.equals("max")) {
			sql = "SELECT MAX(emp_no) FROM employees";
		} else if(str.equals("min")) {
			sql = "SELECT MIN(emp_no) FROM employees";
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
			if(rs.next()) {
				empNo = rs.getInt(1);
			}
		} catch(Exception e) { 
			e.printStackTrace();
		} finally {
			// 자원 반납
			DBHelper.close(rs, conn, stmt);
		}
		
		return empNo;
	}
	
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
