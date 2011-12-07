/**
 * 
 */
package com.openappengine.form;

import java.io.Serializable;

/**
 * @author hrishikesh.joshi
 * 
 */
public abstract class UIForm implements Serializable {

    private static final long serialVersionUID = 1L;

    private int renderMode;

    public int getRenderMode() {
	return renderMode;
    }

    public void setRenderMode(int renderMode) {
	this.renderMode = renderMode;
    }

    public abstract void preRenderAction();

}
