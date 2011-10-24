/**
 * 
 */
package test.openappengine.facade;

import java.util.List;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.openappengine.facade.code.dto.CodeDTO;
import com.openappengine.facade.context.FacadeContext;
import com.openappengine.facade.party.PartyManagerFacade;
import com.openappengine.model.code.CodeTypeConstants;

/**
 * @author hrishi
 *
 */
public class TestPartyManagerFacade {
	
	@BeforeClass
	public static void startup() {
		new ClassPathXmlApplicationContext("facade-context.xml");
	}
	
	@Test
	public void testListAllCodes() {
		PartyManagerFacade partyManagerFacade = FacadeContext.getPartyManagerFacade();
		Assert.assertNotNull(partyManagerFacade);
		List<CodeDTO> codes = partyManagerFacade.listAllCodes(CodeTypeConstants.PARTY_TYPE);
		Assert.assertTrue(codes != null && !codes.isEmpty());
	}

}
