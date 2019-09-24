package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import db.DBHelper;

public class TitlesDao {
	// titles의 중복을 제거한 title 리스트를 리턴하는 메소드
	public List<String> selectTitlesList() {
		List<String> list = new ArrayList<String>();
		// try-catch에 사용할 변수 초기화
		final String SQL = "SELECT DISTINCT title from titles";
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			// DB연결
			conn = DBHelper.getConnection();
			// 쿼리 저장
			stmt = conn.prepareStatement(SQL);
			//쿼리 실행
			rs = stmt.executeQuery();
			// 결과값 list에 저장하여 리턴
			while(rs.next()) {
				list.add(rs.getString(1));
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			// 자원 반납
			DBHelper.close(rs, conn, stmt);
		}
		return list;
	}
	// titles 테이블의 전체 행 카운트 리턴하는 메소드
		public int selectTitlesCount() {
			int count = 0;
			// try-catch에서 쓸 변수들 미리 선언
			final String SQL = "SELECT COUNT(*) FROM titles";
			Connection conn = null;
			PreparedStatement stmt = null;
			ResultSet rs = null;
			try {
				//
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
				//
				DBHelper.close(rs, conn, stmt);
			}
			
			return count;
		}
}
