package by.dimaviolinit.yoshop.controller;

import java.text.ParseException;

import by.dimaviolinit.yoshop.DAO.connectionpool.ConnectionPool;
import by.dimaviolinit.yoshop.exception.ConnectionPoolException;

public class Test {

	public static void main(String[] args) throws ParseException {

		ConnectionPool connectionPool = new ConnectionPool();
		try {
			connectionPool.initPoolData();
		} catch (ConnectionPoolException e) {
			e.printStackTrace();
		}

		try {
			connectionPool.takeConnection();
		} catch (ConnectionPoolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// try {
		// Property.initialization();
		// Connection con = Property.getConnectionPool().getConnection();
		// Statement stmt;
		//
		// stmt = con.createStatement();
		//
		// String strSelect = "select * from users";
		// ResultSet rset = stmt.executeQuery(strSelect);
		// while (rset.next()) {
		// System.out.println(rset.getInt(1));
		// System.out.println(rset.getString(2));
		// System.out.println(rset.getString(3));
		// System.out.println(rset.getString(4));
		// System.out.println(rset.getString(5));
		// System.out.println(rset.getString(6));
		// System.out.println(rset.getString(7));
		// System.out.println(rset.getInt("isdeleted"));
		// System.out.println(!rset.getString("name").isEmpty() ?
		// rset.getString("name") : null);
		// System.out.println();
		// System.out.println();
		// }
		//
		// PreparedStatement pStmt = con
		// .prepareStatement("SELECT MAX(banend), banstart FROM blacklist WHERE
		// iduser = ?");
		// pStmt.setInt(1, 4);
		// ResultSet rs = pStmt.executeQuery();
		// rs.next();
		// System.out.println(rs.getString(1));
		// System.out.println(rs.getString(2));
		// SimpleDateFormat df = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");
		// System.out.println(df.format(new Date()));
		//
		// System.out.println(df.parse("2015.11.02 23:37:29"));
		// System.out.println(rs.getString(2));
		// System.out.println(df.parse(rs.getString(2)));
		//
		// } catch (SQLException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }

	}

}
