/**
 * 
 */
package com.openappengine.model.ad;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.openappengine.model.valueobject.ValueObject;

/**
 * @author hrishi
 * 
 */
@Entity
@Table(name = "AD_DATA_LIST_TYPE")
public class ADDataListType implements ValueObject<ADDataListType>{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "DL_DATA_LIST_TYPE_ID", unique = true, nullable = false)
    private int dataListTypeId;

    @Column(name = "DT_NAME", nullable = false, length = 50)
    private String name;

    @OneToMany(cascade = { CascadeType.ALL }, mappedBy = "adDataListType", fetch = FetchType.EAGER)
    private List<ADDataList> adDataList = new ArrayList<ADDataList>();
    
    public int getDataListTypeId() {
        return dataListTypeId;
    }

    public void setDataListTypeId(int dataListTypeId) {
        this.dataListTypeId = dataListTypeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((name == null) ? 0 : name.hashCode());
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
	ADDataListType other = (ADDataListType) obj;
	if (name == null) {
	    if (other.name != null)
		return false;
	} else if (!name.equals(other.name))
	    return false;
	return true;
    }

    @Override
    public String toString() {
	return "ADDataListType [name=" + name + "]";
    }

    /* (non-Javadoc)
     * @see com.openappengine.model.valueobject.ValueObject#sameValueAs(java.lang.Object)
     */
    public boolean sameValueAs(ADDataListType other) {
	return this.equals(other);
    }

    public List<ADDataList> getAdDataList() {
	return adDataList;
    }

    public void setAdDataList(List<ADDataList> adDataList) {
	this.adDataList = adDataList;
    }
    
}
