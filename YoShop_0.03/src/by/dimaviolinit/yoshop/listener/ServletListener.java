package by.dimaviolinit.yoshop.listener;

import javax.servlet.ServletContextEvent;

import by.dimaviolinit.yoshop.DAO.connectionpool.ConnectionPool;
import by.dimaviolinit.yoshop.DAO.impl.DAOFactory;
import by.dimaviolinit.yoshop.exception.ConnectionPoolException;

public class ServletListener implements javax.servlet.ServletContextListener {

	@Override
	public void contextInitialized(ServletContextEvent arg0) {

		ConnectionPool connectionPool = new ConnectionPool();
		try {
			connectionPool.initPoolData();
		} catch (ConnectionPoolException e) {
			e.printStackTrace();
		}
		DAOFactory factory = DAOFactory.getInstance();
		factory.initDAOFactory(connectionPool);

	}

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {

	}

}