/**
 * 
 */
package com.openappengine.bpm.xml;

/**
 * @author hrishi
 * 
 */
public class Problem {

	public static final int LEVEL_INFO = 0;

	public static final int LEVEL_WARN = 1;

	public static final int LEVEL_ERROR = 2;

	public static final int LEVEL_FATAL = 3;

	/**
	 * Description.
	 */
	private String description;
	
	/**
	 * Level.
	 */
	private int level;
	
	/**
	 * Folder.
	 */
	private String folder;
	
	public Problem(String description, int level) {
		super();
		this.description = description;
		this.level = level;
	}

	public String getFolder() {
		return folder;
	}

	public void setFolder(String folder) {
		this.folder = folder;
	}

	public String getDescription() {
		return description;
	}

	public int getLevel() {
		return level;
	}

	public Problem(String description, int level, String folder) {
		super();
		this.description = description;
		this.level = level;
		this.folder = folder;
	}
	
}
