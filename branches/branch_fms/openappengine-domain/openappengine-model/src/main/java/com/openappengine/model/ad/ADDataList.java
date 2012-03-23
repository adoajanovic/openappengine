/**
 * 
 */
package com.openappengine.model.ad;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.openappengine.model.valueobject.ValueObject;

/**
 * @author hrishi
 * 
 */
@Entity
@Table(name = "AD_DATA_LIST")
public class ADDataList implements ValueObject<ADDataList>{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "DL_DATA_LIST_ID", unique = true, nullable = false)
    private int adDataListId;

    @Column(name = "DL_LABEL", nullable = false, length = 255)
    private String label;

    @Column(name = "DL_VALUE", nullable = false, length = 255)
    private String value;

    @Column(name = "DL_DESCRIPTION", nullable = false, length = 255)
    private String description;

    @ManyToOne
    @JoinColumn(name = "DL_DATA_LIST_TYPE_ID")
    private ADDataListType adDataListType;

    public int getAdDataListId() {
        return adDataListId;
    }

    public void setAdDataListId(int adDataListId) {
        this.adDataListId = adDataListId;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ADDataListType getAdDataListType() {
        return adDataListType;
    }

    public void setAdDataListType(ADDataListType adDataListType) {
        this.adDataListType = adDataListType;
    }

    @Override
    public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result
		+ ((adDataListType == null) ? 0 : adDataListType.hashCode());
	result = prime * result + ((label == null) ? 0 : label.hashCode());
	result = prime * result + ((value == null) ? 0 : value.hashCode());
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
	ADDataList other = (ADDataList) obj;
	if (adDataListType == null) {
	    if (other.adDataListType != null)
		return false;
	} else if (!adDataListType.equals(other.adDataListType))
	    return false;
	if (label == null) {
	    if (other.label != null)
		return false;
	} else if (!label.equals(other.label))
	    return false;
	if (value == null) {
	    if (other.value != null)
		return false;
	} else if (!value.equals(other.value))
	    return false;
	return true;
    }

    @Override
    public String toString() {
	return "ADDataList [label=" + label + ", value=" + value
		+ ", description=" + description + ", adDataListType="
		+ adDataListType + "]";
    }

    /* (non-Javadoc)
     * @see com.openappengine.model.valueobject.ValueObject#sameValueAs(java.lang.Object)
     */
    public boolean sameValueAs(ADDataList other) {
	return this.equals(other);
    }
    
}
