/**
 * 
 */
package com.ms.openapps.tests.util;

import static org.junit.Assert.*;

import java.io.InputStream;
import java.net.URL;

import org.junit.Test;

/**
 * @author hrishi
 * 
 */
public class TestURLHandler {

	@Test
	public void testUserProtocol() throws Exception {
		URL url = new URL("component:.profile");
		InputStream ins = url.openStream();
		assertNotNull(ins);
		ins.close();
	}

}
