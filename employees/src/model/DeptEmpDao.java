package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import db.DBHelper;

public class DeptEmpDao {
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
