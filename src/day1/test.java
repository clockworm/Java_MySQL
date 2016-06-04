package day1;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import jdbc.mysql.util.JDBC_MYSQL;

public class test {
	public static void main(String[] args) {
		int page = 1;
		int pageSize = 5;
		int start = (page - 1) * pageSize;
		PreparedStatement prestatemet = JDBC_MYSQL
				.getPreparedStatement("select * from user limit " + start + "," + pageSize + "");
		try {
			ResultSet res = prestatemet.executeQuery();
			while (res.next()) {
				System.out.print(res.getObject(1) + " ");
				System.out.print(res.getObject(2) + " ");
				System.out.print(res.getObject(3) + " ");
				System.out.print(res.getObject(4) + " ");
				System.out.println();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		PreparedStatement prestatemets = JDBC_MYSQL.getPreparedStatement(
				"create table tt(id int auto_increment primary key,name varchar(10),pass varchar(10))");
		try {
			boolean c = prestatemets.execute();
			System.out.println(c);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
