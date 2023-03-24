package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import db.DbException;
import model.dao.DepartmentDao;
import model.entities.Department;

public class DepartmentDaoJDBC implements DepartmentDao{
	
	private Connection conn; 
	
	public DepartmentDaoJDBC (Connection conn) {
		this.conn = conn; 
	}
	
	public DepartmentDaoJDBC() {
		
	}
	

	@Override
	public void insert(Department obj) {
		PreparedStatement st = null; 
		try {
			st = conn.prepareStatement(
				"INSERT INTO department "
				+ "(Id, Name) "
				+ "Values "
				+ "(?, ?)", 
				Statement.RETURN_GENERATED_KEYS);
			
			st.setInt(1, obj.getId());
			st.setString(2, obj.getName());
			
			int rowsAffected = st.executeUpdate();
			
			if(rowsAffected > 0) {
				ResultSet rs = st.getGeneratedKeys();
				if (rs.next()) {
					int id = rs.getInt(1); 
					obj.setId(null);
				}
			}
		}
		catch(SQLException e) {
			throw new DbException(e.getMessage());
		}
	}
		

	@Override
	public void update(Department obj) {
		PreparedStatement st = null;
		
		try {
			st = conn.prepareStatement(
					"UPDATE department SET Name = ? Where Id = ?", 
					Statement.RETURN_GENERATED_KEYS);
			
			st.setString(1, obj.getName());
			st.setInt(2, obj.getId());
			
			st.executeUpdate();
		}
		catch (SQLException e) {
			throw new DbException(e.getMessage());
		}
	}

	@Override
	public void deleteById(Integer id) {
		PreparedStatement st = null; 
		try {
			st = conn.prepareStatement(
					"DELETE FROM department WHERE ID = ?"); 
			st.setInt(1, id);
			st.executeUpdate();
			
		}
		catch (SQLException e) {
			throw new DbException(e.getMessage()); 
		}
		
	}

	@Override
	public Department findById(Integer id) {
		PreparedStatement st = null; 
		ResultSet rs = null;
		try {
			st = conn.prepareStatement(
					"Select * from department where id = ?"); 
			st.setInt(1, id);
			rs = st.executeQuery();
			if (rs.next()) {
			Department dep = instantantiateDepartment(rs); 
			return dep; 
			}
			return null; 
			
		}
		catch (SQLException e) {
			throw new DbException(e.getMessage()); 
		}
	}

	@Override
	public List<Department> findAll() {
		PreparedStatement st = null; 
		ResultSet rs = null; 
		
		try {
			st = conn.prepareStatement(
					"SELECT * FROM department ORDER BY Id"); 
			rs = st.executeQuery(); 
			
			List<Department> list = new ArrayList<>(); 
			 while (rs.next()) {
				 Department obj = instantantiateDepartment(rs); 
				 list.add(obj);
			 }
			 return list; 
		}
		catch (SQLException e) {
			throw new DbException(e.getMessage()); 
		}
		 
	}
	
	private Department instantantiateDepartment(ResultSet rs) throws SQLException {
		Department obj = new Department(); 
		obj.setId(rs.getInt("Id"));
		obj.setName(rs.getString("Name"));
		return obj; 
	}
	
}
