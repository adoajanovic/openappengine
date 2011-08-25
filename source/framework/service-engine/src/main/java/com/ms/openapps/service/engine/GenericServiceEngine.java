/**
 * 
 */
package com.ms.openapps.service.engine;

import java.lang.reflect.Method;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.FlushModeType;

import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionException;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import org.w3c.dom.Document;

import com.ms.openapps.entity.context.EntityContext;
import com.ms.openapps.service.ModelService;
import com.ms.openapps.service.ModelServiceRunner;
import com.ms.openapps.service.context.DispatchContext;
import com.ms.openapps.service.context.ServiceContext;
import com.ms.openapps.service.dispatcher.IServiceDispatcher;
import com.ms.openapps.service.engine.router.XmlServiceRouter;
import com.ms.openapps.service.engine.router.XmlServiceRouterException;
import com.ms.openapps.util.UtilLogger;

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
	public Map<String, Object> runService(ModelService modelService,
			Map<String, ? extends Object> context) throws GenericServiceException {
		Map<String,Object> returnVal = (Map<String, Object>) invokeService(modelService, context);
		return returnVal;
	}
	
	public Document runXmlService(ModelService modelService,
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
	public void runServiceIgnoreResult(ModelService modelService,
			Map<String, ? extends Object> context) throws GenericServiceException {
			invokeService(modelService, context);
	}
	
	public void runXmlServiceIgnoreResult(ModelService modelService,
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
	private DispatchContext getDispatchContext(ModelService modelService) {
		DispatchContext dispatchContext = new DispatchContext(modelService.getDelegator(),getServiceDispatcher());
		return dispatchContext;
	}
	
	/**
	 * @param modelService
	 * @param context
	 * @return Map<String,Object> returned from the called Service
	 * @throws GenericServiceException
	 */
	private Object invokeService(ModelService modelService,
			Object context) throws GenericServiceException {
		
		if(modelService == null) {
			logger.logError("ModelService not initialized");
			throw new GenericServiceException("ModelService not initialized ");
		}
		
		Object returnVal = null;
		
		DispatchContext dispatchContext = getDispatchContext(modelService);
		
		// Get the runner responsible for this ModelService
		ModelServiceRunner modelServiceRunner = modelService.getModelServiceRunner();
		if(modelServiceRunner != null) {
			
			final EntityManager em = entityContext.getEntityManager();
			em.setFlushMode(FlushModeType.AUTO);
			final PlatformTransactionManager transactionManager = entityContext.getPlatformTransactionManager();
			final TransactionStatus transactionStatus = transactionManager.getTransaction(new DefaultTransactionDefinition());
			
			Class<?> runnerClass = modelServiceRunner.getRunnerClass();
			logger.logInfo("Transaction Started " );
			try {
				XmlServiceRouter xmlServiceRouter = new XmlServiceRouter(runnerClass);
				returnVal = xmlServiceRouter.invokeXmlService(dispatchContext, context);
				commitTransaction(transactionManager, transactionStatus);
				logger.logInfo("Transaction Committed");
				
			} catch (IllegalArgumentException e) {
				logger.logInfo("ModelService [ " + modelService.getServiceId() + " ] Invalid Parameters");
				rollbackTransaction(transactionManager, transactionStatus);
				logger.logInfo("Transaction Rolled Back");
				throw new GenericServiceException("ModelService [ " + modelService.getServiceId() + " ] Invalid Parameters", e);
			} catch (XmlServiceRouterException e) {
				logger.logInfo("ModelService [ " + modelService.getServiceId() + " ] Class could not be instantiated");
				throw new GenericServiceException("ModelService [ " + modelService.getServiceId() + " ] Class could not be instantiated", e);
			}
			finally {
				em.close();
			}
		}
		return returnVal;
	}

	/**
	 * @param transactionManager
	 * @param transactionStatus
	 * @throws TransactionException
	 */
	private void commitTransaction(
			final PlatformTransactionManager transactionManager,
			final TransactionStatus transactionStatus)
			throws TransactionException {
		if(!transactionStatus.isRollbackOnly()) {
			transactionManager.commit(transactionStatus);
		}
	}

	/**
	 * @param transactionManager
	 * @param transactionStatus
	 * @throws TransactionException
	 */
	private void rollbackTransaction(
			final PlatformTransactionManager transactionManager,
			final TransactionStatus transactionStatus)
			throws TransactionException {
		if(!transactionStatus.isRollbackOnly()) {
			transactionManager.rollback(transactionStatus);
		}
	}

}
