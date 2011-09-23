/**
 * 
 */
package com.openappengine.bpm.scxml.invoker;

import java.util.Map;

/**
 * @author hrishikesh.joshi
 *
 */
public interface Invoker {
	
	 /**
     * Set the state ID of the owning state for the &lt;invoke&gt;.
     * Implementations must use this ID for constructing the event name
     * (and optionally, for other event names
     * as well).
     *
     * @param parentStateId The ID of the parent state.
     */
    void setParentStateId(String parentStateId);
	
    
    /**
     * Begin this invocation.
     *
     * @param source The activity being invoked.
     * @param params The &lt;param&gt; values
     * @throws InvokerException In case there is a fatal problem with
     *                          invoking the source.
     */
    void invoke(String source, Map<String,Object> params) throws InvokerException;
    
    /**
     * Cancel this invocation.
     *
     * @throws InvokerException In case there is a fatal problem with
     *                          canceling this invoke.
     */
    void cancel();

}
