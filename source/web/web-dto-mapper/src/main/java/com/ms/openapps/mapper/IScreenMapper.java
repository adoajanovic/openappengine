/**
 * 
 */
package com.ms.openapps.mapper;

import com.ms.openapps.dto.GenericDto;

/**
 * @author hrishi
 * @param <T>
 *
 */
public interface IScreenMapper<T> {
	
	public <T extends GenericDto> T  mapScreen();

}
