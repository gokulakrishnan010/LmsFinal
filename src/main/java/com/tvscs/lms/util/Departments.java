package com.tvscs.lms.util;

/**
 * Departments Enum
 * @author 5030618
 *
 */
public enum Departments {
    collections("Collections"), credit("Credit"),
    sales("Sales"), coll3w("Coll - 3W"),
    colluc("Coll - UC"), collrf("Coll - RF"),
    usercars("Used Cars"), sales3w("Sales - 3W"),
    userrf("Used - RF"), salesnc("Sales - NC");
	
	private String department;
	
	Departments(String department){
		this.department = department;
	}
	
	public String getDepartment() {
		return department;
	}
}
