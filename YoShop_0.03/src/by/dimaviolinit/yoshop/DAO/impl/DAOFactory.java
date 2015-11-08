package by.dimaviolinit.yoshop.DAO.impl;

import by.dimaviolinit.yoshop.DAO.ICategoryDAO;
import by.dimaviolinit.yoshop.DAO.IDAOFactory;
import by.dimaviolinit.yoshop.DAO.IModelDAO;
import by.dimaviolinit.yoshop.DAO.IUserDAO;
import by.dimaviolinit.yoshop.DAO.connectionpool.ConnectionPool;

public class DAOFactory implements IDAOFactory {

	private static DAOFactory instance;
	private ICategoryDAO categoryDAO;
	private IModelDAO modelDAO;
	private IUserDAO userDAO;

	private DAOFactory() {

	}

	public static DAOFactory getInstance() {
		if (instance == null) {
			instance = new DAOFactory();
		}
		return instance;
	}

	public void initDAOFactory(ConnectionPool connectionPool) {
		categoryDAO = SQLCategoryDAO.getInstance(connectionPool);
		modelDAO = SQLModelDAO.getInstance(connectionPool);
		userDAO = SQLUserDAO.getInstance(connectionPool);
	}

	public ICategoryDAO getCategoryDAO() {
		return categoryDAO;
	}

	public IModelDAO getModelDAO() {
		return modelDAO;
	}

	public IUserDAO getUserDAO() {
		return userDAO;
	}

}
