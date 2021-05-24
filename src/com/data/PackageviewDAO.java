package com.data;
import java.util.List;
import com.model.Packageview;
public interface PackageviewDAO {
	
public List<Packageview> getPackageview() throws Exception;
	
//	void addItem(HttpServletRequest request) throws Exception;
	
	
	
	public void deletePackageview(int id) throws Exception;
	
	public List<Packageview> searchPackageview(String packageName) throws Exception;
	
	public Packageview getPackageview(int id) throws Exception;
	
	public void updatePackageview(Packageview packagesview) throws Exception;

	void addPackageview(Packageview packagesview) throws Exception;

}
