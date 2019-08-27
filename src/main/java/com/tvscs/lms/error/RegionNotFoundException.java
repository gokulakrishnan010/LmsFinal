package com.tvscs.lms.error;

/**
 * @author 5030618
 *
 */
public class RegionNotFoundException extends RuntimeException{

	/**
	 * Should be thrown when user enters invalid region 
	 */
	private static final long serialVersionUID = -2196374669894469784L;
	
	public RegionNotFoundException(String region) {
		super("Requested Region "+region+" Not Found");
	}
    
	public RegionNotFoundException(String location, Long noOfemployees) {
		super(" Requested Location "+location+" Not found");
	}
}
