package com.data;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.data.ConnectionFactory;
import com.data.PackageviewDAO;
import com.model.Packageview;

public class PackageviewDAOImpl implements PackageviewDAO{
	
	@Override
	public List<Packageview> getPackageview() throws Exception {
	List<Packageview> packageviewList = new ArrayList<Packageview>();
		
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
				
				
				Packageview packagesview = new Packageview(id, packageName, packagePrice, description, pricePerPerson);
				
				packageviewList.add(packagesview);
				
			}
		}
		finally {
			close(rs, ps, con);
		}
		
		return packageviewList;
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
	public void deletePackageview(int id) throws Exception {
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
	public List<Packageview> searchPackageview(String packageName) throws Exception {
		List<Packageview> searchList=new ArrayList<>();
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
		        
		        
		        
		        Packageview packagesview =new Packageview(id, PackageName, packagePrice, description, pricePerPerson);
		        
		        searchList.add(packagesview);
			}
		}
		finally {
			close(rs,ps,con);
		}
		return searchList;
	}

	@Override
	public Packageview getPackageview(int id) throws Exception {
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		Packageview packagesview = null;
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
		        
		        
		        packagesview  =new Packageview(id, packageName, packagePrice, description, pricePerPerson);
		        
			}
			else {
				throw new Exception("Package Not Found");
			}
		}
		finally {
			close(rs,ps,con);
		}
		return packagesview;
	}

	@Override
	public void updatePackageview(Packageview packagesview) throws Exception {
		Connection con=null;
		PreparedStatement ps=null;
		try
		{
			con=ConnectionFactory.getCon();
			ps=con.prepareStatement("update package set packageName=?,packagePrice=?,description=?,pricePerPerson=? where id=?");
			ps.setString(1, packagesview.getPackageName());
			ps.setDouble(2,packagesview.getPackagePrice());
			ps.setString(3, packagesview.getDescription());
			ps.setDouble(4, packagesview.getPricePerPerson());
			ps.setInt(5,packagesview.getId());
			
			ps.executeUpdate();
		}
		finally {
			close(null,ps,con);
		}
		
	}
		
	

	@Override
	public void addPackageview(Packageview packagesview) throws Exception {

		Connection con = null;
		PreparedStatement ps = null;
		
		

		try {
			con = ConnectionFactory.getCon();
			ps = con.prepareStatement("insert into package(packageName, packagePrice, description, pricePerPerson) values(?, ?, ?, ?)");
			
			ps.setString(1, packagesview.getPackageName());
			ps.setDouble(2, packagesview.getPackagePrice());
			ps.setString(3, packagesview.getDescription());
			ps.setDouble(4, packagesview.getPricePerPerson());
			
			
			ps.executeUpdate();
		}
		finally {
			close(null, ps, con);
		}
		
	}

}
