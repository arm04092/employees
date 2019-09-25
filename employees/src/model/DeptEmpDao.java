package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import db.DBHelper;

public class DeptEmpDao {
	public List<Map<String, Object>> selectDepartmentsCountByDeptNo() {
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		
		final String SQL = "SELECT d.dept_name, COUNT(de.dept_no) FROM dept_emp de INNER JOIN departments d ON de.dept_no = d.dept_no WHERE de.to_date = '9999-01-01' GROUP BY de.dept_no ORDER BY COUNT(de.dept_no) DESC";
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
			while(rs.next()) {
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("name", rs.getString(1));
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
	
	// dept_emp 테이블의 전체 행 카운트 리턴하는 메소드
	public int selectDeptEmpCount() {
		int count = 0;
		// try-catch에서 쓸 변수들 미리 선언
		final String SQL = "SELECT COUNT(*) FROM dept_emp";
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
