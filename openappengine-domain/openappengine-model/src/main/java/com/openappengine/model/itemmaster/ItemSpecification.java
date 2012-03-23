/**
 * 
 */
package com.openappengine.model.itemmaster;

import com.openappengine.model.specification.AbstractSpecification;
import com.openappengine.model.valueobject.ValueObject;

/**
 * @author hrishi
 *
 */
public class ItemSpecification extends AbstractSpecification<Item> implements ValueObject<ItemSpecification>{
	
	private String name;
	
	private String type;
	
	public ItemSpecification(String name, String type) {
		super();
		this.name = name;
		this.type = type;
	}

	@Override
	public boolean isSatisfiedBy(Item t) {
		if(t == null) {
			return false;
		}
		
		return (t.getName() != null && t.getName().contains(name))
				&& (t.getType() != null && t.getType().equals(type));
	}

	public boolean sameValueAs(ItemSpecification other) {
		return this.equals(other);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ItemSpecification other = (ItemSpecification) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}

}
