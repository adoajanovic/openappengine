/**
 * 
 */
package test.openappengine.facade;

import java.util.List;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.openappengine.facade.ad.ApplicationDictionaryFacade;
import com.openappengine.facade.ad.dto.ADColumnDTO;
import com.openappengine.facade.ad.dto.ADTableDTO;
import com.openappengine.facade.context.FacadeContext;

/**
 * @author hrishi
 *
 */
public class TestApplicationDictionayFacade {
	
	@BeforeClass
	public static void startup() {
		new ClassPathXmlApplicationContext("facade-context.xml");
	}
	
	@Test
	public void testListApplicationTables() {
		ApplicationDictionaryFacade applicationDictionaryFacade = FacadeContext.getApplicationDictionaryFacade();
		List<ADTableDTO> tableNames = applicationDictionaryFacade.listAllApplicationTableNames();
		Assert.assertNotNull(tableNames);
		Assert.assertTrue(!tableNames.isEmpty());
	}
	
	@Test
	public void testListApplicationTableColumns() {
		ApplicationDictionaryFacade applicationDictionaryFacade = FacadeContext.getApplicationDictionaryFacade();
		List<ADColumnDTO> columnNames = applicationDictionaryFacade.listAllApplicationTableColumnNames("AB_ADDRESS_BOOK");
		Assert.assertNotNull(columnNames);
		Assert.assertTrue(!columnNames.isEmpty());
	}

}
