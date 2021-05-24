package com.data;

import java.util.List;

import com.model.Package;

public interface PackageDAO {
	
public List<Package> getPackage() throws Exception;
	
//	void addItem(HttpServletRequest request) throws Exception;
	
	
	
	public void deletePackage(int id) throws Exception;
	
	public List<Package> searchPackage(String packageName) throws Exception;
	
	public Package getPackage(int id) throws Exception;
	
	public void updatePackage(Package packages) throws Exception;


	void addPackage(Package packages) throws Exception;
}
