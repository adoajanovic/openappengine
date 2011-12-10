/**
 * 
 */
package test.openappengine.facade.entity.definition;

import org.junit.Test;

import com.openappengine.facade.entity.definition.EntityDefinitionReader;

/**
 * @author hrishi
 *
 */
public class TestEntityDefinitionReader {
    
    @Test
    public void testReadEntityDefinitions() {
	String location = "EntityDefinitions.xml";
	EntityDefinitionReader reader = new EntityDefinitionReader();
	reader.readEntityDefinitions(location);
    }

}
