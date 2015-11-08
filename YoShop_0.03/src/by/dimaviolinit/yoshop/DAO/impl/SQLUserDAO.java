package by.dimaviolinit.yoshop.DAO.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import by.dimaviolinit.yoshop.DAO.IUserDAO;
import by.dimaviolinit.yoshop.DAO.connectionpool.ConnectionPool;
import by.dimaviolinit.yoshop.domain.User;
import by.dimaviolinit.yoshop.exception.ConnectionPoolException;

public class SQLUserDAO implements IUserDAO {

	private static ConnectionPool connectionPool;
	private static SQLUserDAO instance;

	private static final String CHECKUSERUYLOGINQUERY = "SELECT id FROM users WHERE isdeleted = 0 AND login = ?";
	private static final String CHECKUSERBYEMAILQUERY = "SELECT id FROM users WHERE isdeleted = 0 AND email = ?";
	private static final String GETUSERQUERY = "SELECT * FROM categories WHERE id = ?";
	private static final String ADDUSERQUERY = "INSERT INTO users (login,password,name,surname,email) VALUES (?,?,?,?,?)";
	private static final String DELETEUSERQUERY = "UPDATE users SET isdeleted = 1 WHERE id = ?";
	private static final String USERLISTQUERY = "SELECT * FROM users WHERE isdeleted = 0 ORDER BY id";
	private static final String LOGINUSERQUERY = "SELECT * FROM users WHERE isdeleted = 0 AND login = ? AND password = ?";
	private static final String ISBANNEDQUERY = "SELECT MAX(banend) FROM blacklist WHERE iduser = ?";

	private SQLUserDAO() {

	}

	public static SQLUserDAO getInstance(ConnectionPool pool) {
		if (instance == null) {
			connectionPool = pool;
			instance = new SQLUserDAO();
		}
		return instance;
	}

	@Override
	public boolean checkUserByLogin(String login) throws SQLException {

		boolean check = false;
		try (Connection connection = connectionPool.takeConnection();
				PreparedStatement pStmt = connection.prepareStatement(CHECKUSERUYLOGINQUERY)) {
			pStmt.setString(1, login);
			try (ResultSet rs = pStmt.executeQuery()) {
				check = rs.next();
			}
		} catch (ConnectionPoolException e) {
			e.printStackTrace();
		}
		return check;
	}

	@Override
	public boolean checkUserByEmail(String email) throws SQLException {

		boolean check = false;
		try (Connection connection = connectionPool.takeConnection();
				PreparedStatement pStmt = connection.prepareStatement(CHECKUSERBYEMAILQUERY)) {
			pStmt.setString(1, email);
			try (ResultSet rs = pStmt.executeQuery()) {
				check = rs.next();
			}
		} catch (ConnectionPoolException e) {
			e.printStackTrace();
		}
		return check;
	}

	@Override
	public User getUser(int userId) throws SQLException {

		User user = new User();
		try (Connection connection = connectionPool.takeConnection();
				PreparedStatement pStmt = connection.prepareStatement(GETUSERQUERY)) {
			pStmt.setInt(1, userId);
			try (ResultSet rs = pStmt.executeQuery()) {
				rs.next();
				user = DataReaderEx.toUser(rs);
			}
		} catch (ConnectionPoolException e) {
			e.printStackTrace();
		}
		return user;
	}

	@Override
	public boolean addUser(User user) {

		int result = 0;
		try (Connection connection = connectionPool.takeConnection();
				PreparedStatement pStmt = connection.prepareStatement(ADDUSERQUERY)) {
			pStmt.setString(1, user.getLogin());
			pStmt.setString(2, user.getPassword());
			pStmt.setString(3, !user.getName().isEmpty() ? user.getName() : "");
			pStmt.setString(4, !user.getSurname().isEmpty() ? user.getSurname() : "");
			pStmt.setString(5, user.getEmail());
			result = pStmt.executeUpdate();
		} catch (ConnectionPoolException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (result > 0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean deleteUser(User user) throws SQLException {

		int result = 0;
		try (Connection connection = connectionPool.takeConnection();
				PreparedStatement pStmt = connection.prepareStatement(DELETEUSERQUERY)) {
			pStmt.setInt(1, user.getId());
			result = pStmt.executeUpdate();
		} catch (ConnectionPoolException e) {
			e.printStackTrace();
		}
		if (result > 0) {
			return true;
		}
		return false;
	}

	@Override
	public List<User> userList() throws SQLException {

		List<User> users = new ArrayList<User>();
		try (Connection connection = connectionPool.takeConnection();
				PreparedStatement pStmt = connection.prepareStatement(USERLISTQUERY)) {
			try (ResultSet rs = pStmt.executeQuery()) {
				while (rs.next()) {
					users.add(DataReaderEx.toUser(rs));
				}
			}
		} catch (ConnectionPoolException e) {
			e.printStackTrace();
		}
		return users;
	}

	// по хорошему нужно две таблицы на login+password и account
	@Override
	public User loginUser(String login, String password) throws SQLException {

		User user = new User();
		try (Connection connection = connectionPool.takeConnection();
				PreparedStatement pStmt = connection.prepareStatement(LOGINUSERQUERY)) {
			pStmt.setString(1, login);
			pStmt.setString(2, password);
			try (ResultSet rs = pStmt.executeQuery()) {
				rs.next();
				user = DataReaderEx.toUser(rs);
			}
		} catch (ConnectionPoolException e) {
			e.printStackTrace();
		}
		return user;
	}

	@Override
	public Date isBanned(User user) throws SQLException, ParseException {

		Date banEnd = new Date();
		try (Connection connection = connectionPool.takeConnection();
				PreparedStatement pStmt = connection.prepareStatement(ISBANNEDQUERY)) {
			pStmt.setInt(1, user.getId());
			try (ResultSet rs = pStmt.executeQuery()) {
				if (!rs.next()) {
					banEnd = null;
				} else {
					SimpleDateFormat df = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");
					Date banend = df.parse(rs.getString("banend"));
					Date now = new Date();
					if (now.before(banend)) {
						banEnd = banend;
					} else {
						banEnd = null;
					}
				}
			}
		} catch (ConnectionPoolException e) {
			e.printStackTrace();
		}
		return banEnd;
	}

	@Override
	public boolean updateUser(User user) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

}
