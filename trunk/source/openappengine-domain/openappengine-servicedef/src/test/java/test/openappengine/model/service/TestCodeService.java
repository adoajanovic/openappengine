/**
 * 
 */
package test.openappengine.model.service;

import java.util.List;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.openappengine.model.code.CodeType;
import com.openappengine.service.ICodesService;
import com.openappengine.service.ServiceNames;
import com.openappengine.service.context.ServiceContext;


/**
 * @author hrishi
 *
 */
public class TestCodeService {
	
	@BeforeClass
	public static void setupServiceLayer() {
		new ClassPathXmlApplicationContext("service-context.xml");
	}
	
	@Test
	public void testGetCodeTypes() {
		ICodesService codeService = (ICodesService) ServiceContext.getService(ServiceNames.CODE_SERVICE);
		List<CodeType> codeTypes = codeService.getCodeTypes();
		Assert.assertTrue("No Data Present in CodeTypes table.", codeTypes != null && !codeTypes.isEmpty());
	}

}
