package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import db.DB;
import db.DbException;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class SellerDaoJDBC implements SellerDao{
	
	private Connection conn; 
	
	public SellerDaoJDBC(Connection conn) {
		this.conn = conn; 
	}
	

	@Override
	public void insert(Seller obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Seller obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	//Método para retornar um vendedor por ID; 
	public Seller findById(Integer id) {
		PreparedStatement st = null; 
		ResultSet rs = null; 
		try { 
			st = conn.prepareStatement(
					" SELECT seller.*,department.Name as DepName "
					+ " FROM seller INNER JOIN department "
					+ " ON seller.DepartmentId = department.Id "
					+ " WHERE seller.Id = ?");
			
			st.setInt(1, id);
			rs = st.executeQuery();
			if (rs.next()) { //O RS "ResultSet" Next(); é para ver se tem info no banco. Pois se não tiver, ele retorna false
				Department dep = new Department(); //Instanciamos um novo Departamento 
				dep.setId(rs.getInt("DepartmentId")); //Aqui primeiro pegamos um ID do departamento
				dep.setName(rs.getString("DepName")); //Aqui pegamos o nome do departamento
				Seller obj = new Seller();  //Estamos instanciando um novo vendedor
				obj.setId(rs.getInt("Id"));
				obj.setName(rs.getString("Name"));
				obj.setEmail(rs.getString("Email"));
				obj.setBaseSalary(rs.getDouble("BaseSalary"));
				obj.setBirthDate(rs.getDate("BirthDate"));
				obj.setDepartment(dep); //Como ele tem na tabela a FK da de departamento e seu nome, por isso que fizemos o obj dep
				return obj; //retornando o objeto gerado. 
			}
			return null; 	
		}
		catch (SQLException e) {
			throw new DbException(e.getMessage()); 
		}
		finally {
			DB.closeStatement(st);
			DB.closeResultSet(rs);
		}	
	}

	@Override
	public List<Seller> findAll() {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
