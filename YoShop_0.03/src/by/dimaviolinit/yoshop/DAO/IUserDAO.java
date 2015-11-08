package by.dimaviolinit.yoshop.DAO;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.Date;
import java.util.List;

import by.dimaviolinit.yoshop.domain.User;

public interface IUserDAO {

	// will be check login and email separately with AJAX

	public boolean checkUserByLogin(String login) throws SQLException;

	public boolean checkUserByEmail(String email) throws SQLException;

	public User getUser(int userId) throws SQLException;

	public boolean addUser(User user) throws SQLException;

	public boolean updateUser(User user) throws SQLException;

	public boolean deleteUser(User user) throws SQLException;

	public List<User> userList() throws SQLException;

	public User loginUser(String login, String password) throws SQLException;

	public Date isBanned(User user) throws SQLException, ParseException;

}
