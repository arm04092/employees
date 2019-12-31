package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import db.DBHelper;
import vo.Departments;
import vo.DeptManager;
import vo.Employees;

public class DeptManagerDao {
	// 부서별 매니저 목록을 리턴하는 메소드
	public List<DeptManager> getDeptManagerList() {
		List<DeptManager> list = new ArrayList<DeptManager>();
		
		// JDBC에 사용할 객체를 저장할 변수 초기화
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		// sql 쿼리
		String sql = "SELECT d.dept_name, e.first_name, e.last_name, dm.from_date, dm.to_date FROM dept_manager dm INNER JOIN departments d INNER JOIN employees e ON dm.emp_no = e.emp_no AND d.dept_no = dm.dept_no";
		
		try {
			// 객체 생성
			// 드라이버 로딩, DB 연결
			conn = DBHelper.getConnection();
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			// 한 행씩 읽어서 리스트에 저장
			while(rs.next()) {
				DeptManager dm = new DeptManager();
				dm.setDepartments(new Departments());
				dm.getDepartments().setDeptName(rs.getString("d.dept_name"));
				dm.setEmployees(new Employees());
				dm.getEmployees().setFirstName(rs.getString("e.first_name"));
				dm.getEmployees().setLastName(rs.getString("e.last_name"));
				dm.setFromDate(rs.getString("dm.from_date"));
				dm.setToDate(rs.getString("dm.to_date"));			
				
				list.add(dm);
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			// 자원 반납
			DBHelper.close(rs, conn, stmt);
		}
		
		return list;
	}
	
	// dept_manager 테이블의 전체 행 카운트 리턴하는 메소드
	public int selectDeptManagerCount() {
		int count = 0;
		// try-catch에서 쓸 변수들 미리 선언
		final String SQL = "SELECT COUNT(*) FROM dept_manager";
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			// 드라이버 로딩, DB 연결
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
