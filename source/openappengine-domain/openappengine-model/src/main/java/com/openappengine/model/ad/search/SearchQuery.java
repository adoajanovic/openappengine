/**
 * 
 */
package com.openappengine.model.ad.search;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.openappengine.model.ad.ADTable;
import com.openappengine.model.valueobject.ValueObject;
import com.truemesh.squiggle.output.Output;
import com.truemesh.squiggle.output.Outputable;

/**
 * @author hrishikesh.joshi
 *
 */
@Entity
@Table(name="AD_SEARCH_QUERY")
public class SearchQuery implements Serializable,Outputable,ValueObject<SearchQuery> {

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="SQ_SEARCH_QUERY_ID", unique=true, nullable=false)
	private int adSearchQueryId;
	
	@Column(name="SQ_IS_DISTINCT", nullable=true, length=50)
	private boolean isDistinct = false;
	
	@Column(name="SQ_SEARCH_QUERY_NAME", nullable=false, length=50)
	private String name;

	@OneToMany(cascade = { CascadeType.ALL }, orphanRemoval = true)
	@JoinTable(name = "AD_SEARCHQUERY_SELECTION", joinColumns = { @JoinColumn(name = "SS_SEARCH_QUERY_ID", unique = true) }, inverseJoinColumns = { @JoinColumn(name = "SS_SELECTION_ID") })
	private List<Selection> selection = new ArrayList<Selection>();
	
	@OneToMany(cascade = { CascadeType.ALL }, orphanRemoval = true)
	@JoinTable(name = "AD_SEARCHQUERY_CRITERIA", joinColumns = { @JoinColumn(name = "SC_SEARCH_QUERY_ID", unique = true) }, inverseJoinColumns = { @JoinColumn(name = "SC_CRITERIA_ID") })
	private List<Criteria> criteria = new ArrayList<Criteria>();
	
	@OneToMany(cascade = { CascadeType.ALL }, orphanRemoval = true)
	@JoinTable(name = "AD_SEARCHQUERY_ORDER", joinColumns = { @JoinColumn(name = "SO_SEARCH_QUERY_ID", unique = true) }, inverseJoinColumns = { @JoinColumn(name = "SO_ORDER_BY_ID") })
	private List<Order> order = new ArrayList<Order>();
	
	@OneToMany(cascade = { CascadeType.ALL }, orphanRemoval = true)
	@JoinTable(name = "AD_SEARCHQUERY_REFERENCED_TABLES", joinColumns = { @JoinColumn(name = "SR_SEARCH_QUERY_ID", unique = true) }, inverseJoinColumns = { @JoinColumn(name = "SR_AD_TABLE_ID") })
	private Set<ADTable> referencedTables = new HashSet<ADTable>();
	
	public int getAdSearchQueryId() {
		return adSearchQueryId;
	}

	public void setAdSearchQueryId(int adSearchQueryId) {
		this.adSearchQueryId = adSearchQueryId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Criteria> getCriteria() {
		return criteria;
	}

	public void setCriteria(List<Criteria> criteria) {
		this.criteria = criteria;
	}
	
	public void addCriteria(Criteria criteria) {
		if(criteria == null) {
			return;
		}
		
		referencedTables.addAll(criteria.getReferenceTables());
		this.criteria.add(criteria);
	}

	public void write(Output out) {
		out.print("SELECT");
        if (isDistinct) {
            out.print(" DISTINCT");
        }
        
        out.println();
        
        printOut(out,selection,",");
        
        out.println();
        
        out.print("FROM");
        
        printOut(out, referencedTables, ",");
        
        if(!criteria.isEmpty()) {
        	out.print("WHERE");
        	printOut(out,criteria,",");
        }
        
        // Add order
        if (!order.isEmpty()) {
            out.println("ORDER BY");
            printOut(out, order, ",");
        }
        
	}

	/**
	 * @param out
	 */
	protected void printOut(Output out,Collection<? extends Outputable> outputables,String seperator) {
		Iterator<? extends Outputable> iterator = outputables.iterator();
        boolean hasNext = iterator.hasNext();
		while(hasNext) {
        	Outputable sel = iterator.next();
        	hasNext = iterator.hasNext();
        	
        	sel.write(out);
        	if(hasNext) {
        		out.print(seperator);
        	}
        }
	}
	
	public List<Selection> getSelection() {
		return selection;
	}

	public void setSelection(List<Selection> selection) {
		this.selection = selection;
	}
	
	public void addToSelection(Selection selection) {
		if(selection == null) {
			return;
		}
		
		referencedTables.add(selection.getAdTable());
		this.selection.add(selection);
	}

	public List<Order> getOrder() {
		return order;
	}

	public void setOrder(List<Order> order) {
		this.order = order;
	}

	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((criteria == null) ? 0 : criteria.hashCode());
		result = prime * result + (isDistinct ? 1231 : 1237);
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((order == null) ? 0 : order.hashCode());
		result = prime * result + ((referencedTables == null) ? 0 : referencedTables.hashCode());
		result = prime * result + ((selection == null) ? 0 : selection.hashCode());
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
		SearchQuery other = (SearchQuery) obj;
		if (criteria == null) {
			if (other.criteria != null)
				return false;
		} else if (!criteria.equals(other.criteria))
			return false;
		if (isDistinct != other.isDistinct)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (order == null) {
			if (other.order != null)
				return false;
		} else if (!order.equals(other.order))
			return false;
		if (referencedTables == null) {
			if (other.referencedTables != null)
				return false;
		} else if (!referencedTables.equals(other.referencedTables))
			return false;
		if (selection == null) {
			if (other.selection != null)
				return false;
		} else if (!selection.equals(other.selection))
			return false;
		return true;
	}

	public boolean sameValueAs(SearchQuery other) {
		return this.equals(other);
	}
}
