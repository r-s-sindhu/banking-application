package com.service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.model.User;

public class UserDao {
	public static int saveUser(User user)
	{
		Statement stmt=null;
		String sql=null;
		try
		{
			sql="insert into register (username,password,phno,address,email,amt,acctype) values('"+user.getUsername()+"','"+user.getPassword()+"','"+user.getPhno()+"','"+user.getAddress()+"','"+user.getEmail()+"','"+user.getAmount()+"','"+user.getAcctype()+"')";
			stmt=Util.getConnection().createStatement();
			return stmt.executeUpdate(sql);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return 0;
		}
	}
	public static User getUserByName(String name) {
		User u = new User();
		try {
			PreparedStatement ps = Util.getConnection().prepareStatement("select * from register where username=?");
			ps.setString(1, name);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				u.setAccno(rs.getInt(1));
				u.setUsername(rs.getString(2));
				u.setPassword(rs.getString(3));
				u.setPhno(rs.getString(4));
				u.setAddress(rs.getString(5));
				u.setEmail(rs.getString(6));
				u.setAmount(rs.getDouble(7));
				u.setAcctype(rs.getString(8));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return u;
	}
	public static int update(User u) {
		int status = 0;
		try {
			PreparedStatement ps = Util.getConnection().prepareStatement("update register set username=?,password=?,phno=?,address=?,email=?,acctype=? where username=?");
			ps.setString(1, u.getUsername());
			ps.setString(2, u.getPassword());
			ps.setString(3, u.getPhno());
			ps.setString(4, u.getAddress());
			ps.setString(5, u.getEmail());
			ps.setString(6, u.getAcctype());
			ps.setString(7, u.getUsername());	
			status = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}
	public static double balance(String name)
	{
		User u1=new User();
		try
		{
			PreparedStatement ps=Util.getConnection().prepareStatement("select * from register where username=?");
			ps.setString(1, name);
			ResultSet rs=ps.executeQuery();
			if(rs.next())
			{
				u1.setAmount(rs.getDouble(7));
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return u1.getAmount();
	}
}
