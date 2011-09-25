/**
 * 
 */
package com.openappengine.serviceengine.engine;

import java.util.Map;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.classic.Session;
import org.w3c.dom.Document;

import com.openappengine.repository.context.EntityContext;
import com.openappengine.serviceengine.context.DispatchContext;
import com.openappengine.serviceengine.context.ServiceContext;
import com.openappengine.serviceengine.dispatcher.IServiceDispatcher;
import com.openappengine.serviceengine.engine.router.XmlServiceRouter;
import com.openappengine.serviceengine.engine.router.XmlServiceRouterException;
import com.openappengine.serviceengine.model.GenericServiceModel;
import com.openappengine.serviceengine.model.ModelServiceRunner;
import com.openappengine.utility.UtilLogger;

/**
 * @author hrishi
 *
 */
public class GenericServiceEngine implements IGenericServiceEngine {

	private UtilLogger logger = new  UtilLogger(getClass());
	
	private EntityContext entityContext = EntityContext.getInstance();
	
	/* (non-Javadoc)
	 * @see com.ms.openapps.service.engine.IGenericServiceEngine#runService(com.ms.openapps.service.ModelService, java.util.Map)
	 */
	@Override
	public Map<String, Object> runService(GenericServiceModel modelService,
			Map<String, ? extends Object> context) throws GenericServiceException {
		Map<String,Object> returnVal = (Map<String, Object>) invokeService(modelService, context);
		return returnVal;
	}
	
	public Document runXmlService(GenericServiceModel modelService,
			Document params) throws GenericServiceException {
		if (params == null) {
			throw new GenericServiceException(
					"No Input Parameters passed to the Service.");
		}
		Document returnVal = (Document) invokeService(modelService, params);
		return returnVal;
	}

	/* (non-Javadoc)
	 * @see com.ms.openapps.service.engine.IGenericServiceEngine#runServiceIgnoreResult(com.ms.openapps.service.ModelService, java.util.Map)
	 */
	@Override
	public void runServiceIgnoreResult(GenericServiceModel modelService,
			Map<String, ? extends Object> context) throws GenericServiceException {
			invokeService(modelService, context);
	}
	
	public void runXmlServiceIgnoreResult(GenericServiceModel modelService,
			Document params) throws GenericServiceException {
		Document returnVal = (Document) invokeService(modelService, params);
	}
	
	/**
	 * @return IServiceDispatcher
	 */
	private IServiceDispatcher getServiceDispatcher() {
		return ServiceContext.getServiceDispatcher();
	}
	
	/**
	 * @param modelService
	 * @return DispatchContext
	 */
	private DispatchContext getDispatchContext(GenericServiceModel modelService) {
		DispatchContext dispatchContext = new DispatchContext(getServiceDispatcher());
		return dispatchContext;
	}
	
	/**
	 * @param modelService
	 * @param context
	 * @return Map<String,Object> returned from the called Service
	 * @throws GenericServiceException
	 */
	private Object invokeService(GenericServiceModel modelService,
			Object context) throws GenericServiceException {
		
		if(modelService == null) {
			logger.logError("ModelService not initialized");
			throw new GenericServiceException("ModelService not initialized ");
		}
		
		Object returnVal = null;
		
		DispatchContext dispatchContext = getDispatchContext(modelService);
		
		// Get the runner responsible for this ModelService
		ModelServiceRunner modelServiceRunner = modelService.getServiceRunner();
		if(modelServiceRunner != null) {
			SessionFactory sessionFactory = entityContext.getSessionFactory();
			Session session = sessionFactory.openSession();
			Transaction transaction = session.beginTransaction();
			Class<?> runnerClass = modelServiceRunner.getRunnerClass();
			logger.logInfo("Transaction Started " );
			try {
				XmlServiceRouter xmlServiceRouter = new XmlServiceRouter(runnerClass);
				returnVal = xmlServiceRouter.invokeXmlService(dispatchContext, context);
				commitTransaction(transaction);
				logger.logInfo("Transaction Committed");
			} catch (IllegalArgumentException e) {
				logger.logInfo("ModelService [ " + modelService.getServiceName() + " ] Invalid Parameters");
				rollbackTransaction(transaction);
				logger.logInfo("Transaction Rolled Back");
				throw new GenericServiceException("ModelService [ " + modelService.getServiceName() + " ] Invalid Parameters", e);
			} catch (XmlServiceRouterException e) {
				logger.logInfo("ModelService [ " + modelService.getServiceName() + " ] Class could not be instantiated");
				rollbackTransaction(transaction);
				throw new GenericServiceException("ModelService [ " + modelService.getServiceName() + " ] Class could not be instantiated", e);
			}
			finally {
				session.close();
			}
		}
		return returnVal;
	}

	/**
	 * @param transaction
	 */
	private void rollbackTransaction(Transaction transaction) {
		if(!transaction.wasRolledBack()) {
			transaction.rollback();
		}
	}

	/**
	 * @param transaction
	 */
	private void commitTransaction(Transaction transaction) {
		if(!transaction.wasRolledBack()) {
			transaction.commit();
		}
	}
}
