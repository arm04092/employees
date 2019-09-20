package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import vo.Departments;
// MODEL
public class DepartmentsDao {
	// 부서 목록 ArrayList 리턴하는 메소드
	public List<Departments> selectDepartmentsList() {
		List<Departments> list = new ArrayList<Departments>();
		// try-catch에 쓸 변수 선언
		final String SQL = "SELECT dept_no, dept_name FROM departments";
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			// 드라이버 로딩
			Class.forName("org.mariadb.jdbc.Driver");
			// db 연결
			conn = DriverManager.getConnection("jdbc:mariadb://127.0.0.1:3306/employees", "root", "java1234");
			// 쿼리 저장
			stmt = conn.prepareStatement(SQL);
			// 쿼리 실행
			rs = stmt.executeQuery();
			// 결과값 departments타입으로 list에 저장
			while(rs.next()) {
				Departments departments = new Departments();
				departments.setDeptNo(rs.getString(1));
				departments.setDeptName(rs.getString(2));
				list.add(departments);
			}
		} catch(Exception e) { 
			e.printStackTrace();
		} finally {
			// db연결에 쓰인 자원 반납
			try {
				rs.close();
				stmt.close();
				conn.close();
				// close안됐으면 예외메세지 출력
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		return list;
	}
}
