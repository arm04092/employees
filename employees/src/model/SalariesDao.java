package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;

import db.DBHelper;

public class SalariesDao {
	public Map<String, Long> selectSalariesStatistics() {
		Map<String, Long> map = new HashMap<String, Long>();
		
		// try-catch에서 쓸 변수들 미리 선언
		final String SQL = "SELECT COUNT(salary), SUM(salary), AVG(salary), MAX(salary), MIN(salary), STD(salary) FROM salaries";
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			// DB연결
			conn = DBHelper.getConnection();
			// 쿼리문 저장
			stmt = conn.prepareStatement(SQL);
			//쿼리문 실행
			rs = stmt.executeQuery();
			// 결과값 저장하여 리턴
			if(rs.next()) {
				map.put("count", rs.getLong("COUNT(salary)"));
				map.put("sum", rs.getLong("SUM(salary)"));
				map.put("avg", rs.getLong("AVG(salary)"));
				map.put("max", rs.getLong("MAX(salary)"));
				map.put("min", rs.getLong("MIN(salary)"));
				map.put("std", rs.getLong("STD(salary)"));
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			// 자원 반납
			DBHelper.close(rs, conn, stmt);
		}
		
		return map;
	}
	// salaries 테이블의 전체 행 카운트 리턴하는 메소드
		public int selectSalariesCount() {
			int count = 0;
			// try-catch에서 쓸 변수들 미리 선언
			final String SQL = "SELECT COUNT(*) FROM salaries";
			Connection conn = null;
			PreparedStatement stmt = null;
			ResultSet rs = null;
			try {
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
				DBHelper.close(rs, conn, stmt);
			}
			
			return count;
		}
}
