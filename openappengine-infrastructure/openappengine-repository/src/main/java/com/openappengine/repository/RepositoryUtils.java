/**
 * 
 */
package com.openappengine.repository;

import org.hibernate.FlushMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.SessionFactoryUtils;
import org.springframework.orm.hibernate3.SessionHolder;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import com.openappengine.repository.context.RepositoryContext;

/**
 * @author hrishi
 *
 */
public abstract class RepositoryUtils {
	
	private static SessionFactory sessionFactory;
	
	private static RepositoryContext repositoryContext;
	
	private RepositoryUtils() {
		
	}

	static {
		repositoryContext = RepositoryContext.getInstance();
		sessionFactory = repositoryContext.getSessionFactory();
	}
	
	public static Session openSession() {
		Session newSession = SessionFactoryUtils.getSession(sessionFactory, true);
		newSession.beginTransaction();
		newSession.setFlushMode(FlushMode.AUTO);
		boolean bound = TransactionSynchronizationManager.hasResource(sessionFactory);
		if(!bound) {
			TransactionSynchronizationManager.bindResource(sessionFactory, new SessionHolder(newSession));
		}
		return newSession;
	}
	
	public static Session getExistingSession() {
		Session session = SessionFactoryUtils.getSession(sessionFactory, false);
		return session;
	}

	public static void closeOpenSession() {
		Session session = SessionFactoryUtils.getSession(sessionFactory, false);
		if(session != null) {
			session.getTransaction().commit();
			session.close();
		}
		TransactionSynchronizationManager.unbindResourceIfPossible(sessionFactory);
	}
}
