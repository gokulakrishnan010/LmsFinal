package com.tvscs.lms.model;

import java.util.Date;
import java.util.Objects;


public class Performance {
    private double assignedTotal;
	private double collection;
	private Date targetDate;
	private String forTheMonth;
	private String rating;
	/**
	 * 
	 */
	public Performance() {
		super();
	}
	
	/**
	 * @param alloc_Amount
	 * @param collection
	 * @param targetDate
	 * @param rating
	 */
	public Performance(double alloc_Amount, double collection, Date targetDate, String forTheMonth,String rating) {
		super();
		this.assignedTotal = alloc_Amount;
		this.collection = collection;
		this.targetDate = targetDate;
		this.rating = rating;
		this.forTheMonth = forTheMonth;
	}
	/**
	 * @return the alloc_Amount
	 */
	public double getAssignedTotal() {
		return assignedTotal;
	}
	/**
	 * @param alloc_Amount the alloc_Amount to set
	 */
	public void setAssignedTotal(double alloc_Amount) {
		this.assignedTotal = alloc_Amount;
	}
	/**
	 * @return the collection
	 */
	public double getCollection() {
		return collection;
	}
	/**
	 * @param collection the collection to set
	 */
	public void setCollection(double collection) {
		this.collection = collection;
	}
	/**
	 * @return the targetDate
	 */
	public Date getTargetDate() {
		return targetDate;
	}
	/**
	 * @param targetDate the targetDate to set
	 */
	public void setTargetDate(Date targetDate) {
		this.targetDate = targetDate;
	}
	/**
	 * @return the rating
	 */
	public String getRating() {
		return rating;
	}
	/**
	 * @param rating the rating to set
	 */
	public void setRating(String rating) {
		this.rating = rating;
	}
	
	/**
	 * @return the forTheMonth
	 */
	public String getForTheMonth() {
		return forTheMonth;
	}

	/**
	 * @param forTheMonth the forTheMonth to set
	 */
	public void setForTheMonth(String forTheMonth) {
		this.forTheMonth = forTheMonth;
	}
    
	@Override
	public int hashCode() {
		return Objects.hash(assignedTotal, collection, targetDate);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Performance other = (Performance) obj;
		return Double.doubleToLongBits(assignedTotal) == Double.doubleToLongBits(other.assignedTotal)
				&& Double.doubleToLongBits(collection) == Double.doubleToLongBits(other.collection)
				&& Objects.equals(targetDate, other.targetDate);
	}

	@Override
	public String toString() {
		return "Performance [alloc_Amount=" + assignedTotal + ", collection=" + collection + ", targetDate=" + targetDate
				+ ", rating=" + rating + "]";
	}
	

}
