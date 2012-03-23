/**
 * 
 */
package sun.net.www.protocol.component;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLStreamHandler;

/**
 * @author hrishi
 *
 */
public class Handler extends URLStreamHandler {

	/* (non-Javadoc)
	 * @see java.net.URLStreamHandler#openConnection(java.net.URL)
	 */
	@Override
	protected URLConnection openConnection(URL url) throws IOException {
		return new UserURLConnection(url);
	}
	
	 private static class UserURLConnection extends URLConnection {
		    
		 	private String fileName;
		    
		    public UserURLConnection(URL url) {
		      super(url);
		      String path = url.getPath();
		      fileName = url.getPath();
		    }
		    
		    @Override
		    public void connect() throws IOException {
		    }
		    
		    @Override
		    public InputStream getInputStream() throws IOException {
		      File absolutePath = new File(System.getProperty("user.home"), fileName);
		      
		      return new FileInputStream(absolutePath);
		    }
		  }
}