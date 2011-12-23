/**
 * 
 */
package com.openappengine.web.filter;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;

import org.apache.log4j.Logger;

import com.openappengine.web.annotations.PostRestoreView;
import com.openappengine.web.annotations.PreInvokeApplication;
import com.openappengine.web.annotations.PreRenderView;

/**
 * @author hrishikesh.joshi
 *
 */
public class PerViewPhaseListener implements PhaseListener {

	private static final long serialVersionUID = 1L;
	
	protected final Logger logger = Logger.getLogger(getClass());
	
	private Object target;
	
	private Class<?> controllerClass;
	
	private Map<Class<? extends Annotation>, List<Method>> methodAnnotationsMap = new HashMap<Class<? extends Annotation>, List<Method>>();
	
	private final Class<Annotation>[] ENTITY_FORM_LIFECYCLE_ANNOTATIONS = new Class[]{PreRenderView.class,PreInvokeApplication.class,PostRestoreView.class}; 
	
	public PerViewPhaseListener(Object target) {
		this.target = target;
		this.controllerClass = target.getClass();
		registerController();
	}

	/**
	 * @throws IllegalArgumentException
	 */
	protected void registerController() throws IllegalArgumentException {
		for (Class<Annotation> annotation : ENTITY_FORM_LIFECYCLE_ANNOTATIONS) {
			List<Method> methods = findAnnotatedMethods(controllerClass, annotation);
			methodAnnotationsMap.put(annotation, methods);
		}
	}
	
	private List<Method> findAnnotatedMethods(Class<?> clazz, Class<? extends Annotation> annotationClass) {
		Method[] methods = clazz.getMethods();
		List<Method> annotatedMethods = new ArrayList<Method>(methods.length);
		for (Method method : methods) {
			if (method.isAnnotationPresent(annotationClass)) {
				annotatedMethods.add(method);
			}
		}
		return annotatedMethods;
	}

	@Override
	public void afterPhase(PhaseEvent event) {
		logger.info("Phase End : " + event.getPhaseId());
		if (PhaseId.RESTORE_VIEW.equals(event.getPhaseId())) {
			invokeAnnotatedMethod(PostRestoreView.class, target);
		}
	}

	@Override
	public void beforePhase(PhaseEvent event) {
		logger.info("Phase Begin : " + event.getPhaseId());
		if (PhaseId.RENDER_RESPONSE.equals(event.getPhaseId())) {
            invokeAnnotatedMethod(PreRenderView.class, target);
        } else if (PhaseId.INVOKE_APPLICATION.equals(event.getPhaseId())) {
            invokeAnnotatedMethod(PreInvokeApplication.class, target);
        }
	}

	@Override
	public PhaseId getPhaseId() {
		return PhaseId.ANY_PHASE;
	}
	
	void invokeAnnotatedMethod(Class<? extends Annotation> annotation, Object targetObject) {
       for (Method method : methodAnnotationsMap.get(annotation)) {
            try {
                method.invoke(targetObject);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

}
