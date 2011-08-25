/**
 * 
 */
package com.ms.openapps.service.reader;

import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;

import javolution.util.FastList;

import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import com.ms.openapps.entity.EntityDelegatorFactory;
import com.ms.openapps.entity.EntityNames;
import com.ms.openapps.entity.IGenericEntityDelegator;
import com.ms.openapps.entity.context.EntityContext;
import com.ms.openapps.model.ArchAggregateService;
import com.ms.openapps.service.ModelService;
import com.ms.openapps.service.ModelServiceFactory;
import com.ms.openapps.service.ModelServiceRunner;
import com.ms.openapps.service.ServiceReaderUtils;
import com.ms.openapps.util.UtilLogger;

/**
 * @author hrishi
 *
 */
public class ModelServiceReader {
	
	/* Read Input Services for Service Engine from DB. Default TRUE*/
	private static boolean readDBServices = Boolean.TRUE;
	
	private EntityContext entityContext = EntityContext.getInstance();
	
	private UtilLogger logger = new UtilLogger(getClass());
	
	/**
	 * 	Loads the ModelServices to {@link ModelServiceFactory}
	 */
	public void loadModelServices(){
		if(readDBServices) {
			DbModelServiceReader dbModelServiceReader = new DbModelServiceReader();
			dbModelServiceReader.getModelServices();
		} else {
		//TODO - No Implementation for Case - False
		throw new NotImplementedException();
		}
	}

	private class DbModelServiceReader {
		
		private IGenericEntityDelegator archAggregateDelegator;
		
		public DbModelServiceReader() {
			EntityDelegatorFactory entityDelegatorFactory = entityContext.getEntityDelegatorFactory();
			archAggregateDelegator = entityDelegatorFactory.getEntityDelegator(EntityNames.ARCH_AGGREGATE);
		}

		public List<ModelService> getModelServices() {
			
			final EntityManager em = entityContext.getEntityManager();
			final PlatformTransactionManager transactionManager = entityContext.getPlatformTransactionManager();
			final TransactionStatus transactionStatus = transactionManager.getTransaction(new DefaultTransactionDefinition());
			
			List findByQueryString = archAggregateDelegator
					.findByQueryString("from ArchAggregateService");
			List<ModelService> modelServices = new FastList<ModelService>();
			for (Iterator iterator = findByQueryString.iterator(); iterator.hasNext();) {
				ArchAggregateService aggregateService = (ArchAggregateService) iterator
						.next();
				//Get the entity delegator for this service.
				IGenericEntityDelegator delegator = null;
				if (aggregateService.getRequiresDelegator()) {
					delegator = entityContext.getEntityDelegatorFactory()
							.getEntityDelegator(aggregateService.getArchAggregate().getAggregateName());
				}
				String serviceRunnerClass = aggregateService.getServiceRunnerClass();
				Class<?> modelServiceReaderClass = ServiceReaderUtils.getRunnerClass(serviceRunnerClass);
				boolean isXmlService = aggregateService.getXmlService();
				boolean requiresDelegator = aggregateService
						.getRequiresDelegator();
				ModelServiceRunner runner = new ModelServiceRunner(modelServiceReaderClass);
				modelServices.add(new ModelService(aggregateService.getServiceName(),runner, delegator,requiresDelegator,isXmlService));
			}
			
			transactionManager.commit(transactionStatus);
			logger.logInfo("Transaction Committed");
			
			for(ModelService modelService : modelServices) {
				logger.logInfo("Adding Service :" + modelService.getServiceId() + " to the ModelServiceFactory");
				ModelServiceFactory.addService(modelService.getServiceId(), modelService);
			}
			return modelServices;
		}
		
	}	
	
	/**
	 * @return the readDBServices
	 */
	public boolean isReadDBServices() {
		return readDBServices;
	}

	/**
	 * @param readDBServices the readDBServices to set
	 */
	public void setReadDBServices(boolean readDBServices) {
		ModelServiceReader.readDBServices = readDBServices;
	}

}
