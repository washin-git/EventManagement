package com.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.data.ConnectionFactory;
import com.data.PackageDAO;
import com.model.Package;

public class PackageDAOImpl implements PackageDAO{

	@Override
	public List<Package> getPackage() throws Exception {
	List<Package> packageList = new ArrayList<Package>();
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			con = ConnectionFactory.getCon();
			ps = con.prepareStatement("select * from package order by id");
			rs = ps.executeQuery();
			
			while(rs.next()) {
				int id = rs.getInt("id");
				String packageName = rs.getString("packageName");
				double packagePrice = rs.getDouble("packagePrice");
				String description = rs.getString("description");
				double pricePerPerson = rs.getDouble("pricePerPerson");
				
				
				Package packages = new Package(id, packageName, packagePrice, description, pricePerPerson);
				
				packageList.add(packages);
				
			}
		}
		finally {
			close(rs, ps, con);
		}
		
		return packageList;
	}

private void close(ResultSet rs, PreparedStatement ps, Connection con) {
		
		try {
			
			if(rs != null) {
				rs.close();
			}
			if(ps != null) {
				ps.close();
			}
			if(con != null) {
				con.close();
			}
			
		}
		catch(Exception e) {
			e.getStackTrace();
		}
		
	}


	@Override
	public void deletePackage(int id) throws Exception {
		Connection con=null;
		PreparedStatement ps=null;
		try {
			con=ConnectionFactory.getCon();
			ps=con.prepareStatement("delete from package where id=?");
			ps.setInt(1,id);
			ps.executeUpdate();
		}
		finally {
			close(null,ps,con);
		}
		
	}

	@Override
	public List<Package> searchPackage(String packageName) throws Exception {
		List<Package> searchList=new ArrayList<>();
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		try {
			con=ConnectionFactory.getCon();
			ps=con.prepareStatement("select * from package where packageName=?");
			ps.setString(1, packageName);
			rs=ps.executeQuery();
			while(rs.next()) {
				int id=rs.getInt(1);
				String PackageName=rs.getString(2);
				double packagePrice=rs.getDouble(3);
		        String description =rs.getString(4);
		        double pricePerPerson =rs.getDouble(5);
		        
		        
		        
		        Package packages =new Package(id, PackageName, packagePrice, description, pricePerPerson);
		        
		        searchList.add(packages);
			}
		}
		finally {
			close(rs,ps,con);
		}
		return searchList;
	}

	@Override
	public Package getPackage(int id) throws Exception {
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		Package packages = null;
		try {
			con=ConnectionFactory.getCon();
			ps=con.prepareStatement("select * from package where id=?");
			ps.setInt(1, id);
			rs=ps.executeQuery();
			if(rs.next()) {
				String packageName=rs.getString(2);
				double packagePrice=rs.getDouble(3);
				String description =rs.getString(4);
		        double pricePerPerson=rs.getDouble(5);
		        
		        
		        packages  =new Package(id, packageName, packagePrice, description, pricePerPerson);
		        
			}
			else {
				throw new Exception("Package Not Found");
			}
		}
		finally {
			close(rs,ps,con);
		}
		return packages;
	}

	@Override
	public void updatePackage(Package packages) throws Exception {
		Connection con=null;
		PreparedStatement ps=null;
		try
		{
			con=ConnectionFactory.getCon();
			ps=con.prepareStatement("update package set packageName=?,packagePrice=?,description=?,pricePerPerson=? where id=?");
			ps.setString(1, packages.getPackageName());
			ps.setDouble(2,packages.getPackagePrice());
			ps.setString(3, packages.getDescription());
			ps.setDouble(4, packages.getPricePerPerson());
			ps.setInt(5,packages.getId());
			
			ps.executeUpdate();
		}
		finally {
			close(null,ps,con);
		}
		
	}
		
	

	@Override
	public void addPackage(Package packages) throws Exception {

		Connection con = null;
		PreparedStatement ps = null;
		
		

		try {
			con = ConnectionFactory.getCon();
			ps = con.prepareStatement("insert into package(packageName, packagePrice, description, pricePerPerson) values(?, ?, ?, ?)");
			
			ps.setString(1, packages.getPackageName());
			ps.setDouble(2, packages.getPackagePrice());
			ps.setString(3, packages.getDescription());
			ps.setDouble(4, packages.getPricePerPerson());
			
			
			ps.executeUpdate();
		}
		finally {
			close(null, ps, con);
		}
		
	}
	
}