package daos;

import java.sql.*;
import core.BDSQLServer;
import core.MeuResultSet;
import dbos.Student;

public class Students 
{
	public void insert (Student student) throws Exception
	{
		if(student==null)
			throw new Exception("Invalid Student!");
		
		try
		{
			String sql = "insert into Student values (?,?,?,?,?)";
			
			BDSQLServer.COMANDO.prepareStatement(sql);
			
			BDSQLServer.COMANDO.setInt(1, student.getRa());
			BDSQLServer.COMANDO.setString(2, student.getName());
			BDSQLServer.COMANDO.setInt(3, student.getCourseNumber());
			BDSQLServer.COMANDO.setString(4, student.getZipCode());
			BDSQLServer.COMANDO.setString(5, student.getComplement());
			BDSQLServer.COMANDO.setInt(6, student.getNumber());
			
			BDSQLServer.COMANDO.executeUpdate();
			BDSQLServer.COMANDO.commit();
		}
		catch(SQLException ex)
		{
			throw new Exception ("Student Insertion Error");
		}
	}
	public void update (Student student) throws Exception
	{
		if(student==null)
			throw new Exception("Invalid Student!");
		
		try
		{
			String sql = "update Student set sname = ? , course = ? , zip = ? , complement = ? , number = ? where ra = ?";
			
			BDSQLServer.COMANDO.prepareStatement(sql);
			
			BDSQLServer.COMANDO.setString(1, student.getName());
			BDSQLServer.COMANDO.setInt(2, student.getCourseNumber());
			BDSQLServer.COMANDO.setString(3, student.getZipCode());
			BDSQLServer.COMANDO.setString(4, student.getComplement());
			BDSQLServer.COMANDO.setInt(5, student.getNumber());
			BDSQLServer.COMANDO.setInt(6, student.getRa());
			
			BDSQLServer.COMANDO.executeUpdate();
			BDSQLServer.COMANDO.commit();
		}
		catch(SQLException ex)
		{
			throw new Exception ("Student Update Error");
		}
	}
	public void delete (int ra) throws Exception
	{
		if(ra < 0)
			throw new Exception("Invalid RA!");
		
		try
		{
			String sql = "delete from Student where ra = ?";
			
			BDSQLServer.COMANDO.prepareStatement(sql);
			
			BDSQLServer.COMANDO.setInt(1, ra);
			
			BDSQLServer.COMANDO.executeUpdate();
			BDSQLServer.COMANDO.commit();
		}
		catch(SQLException ex)
		{
			throw new Exception ("Student Deletion Error");
		}
	}
	public static Student getAluno(int ra) throws Exception 
	{
		Student student = null;
		
		try
		{
			String sql = "select * from Student where ra = ?";
			
			BDSQLServer.COMANDO.prepareStatement(sql);
			
			BDSQLServer.COMANDO.setInt(1, ra);
			
			MeuResultSet resultado = (MeuResultSet) BDSQLServer.COMANDO.executeQuery();
			
			if(!resultado.first())
				throw new Exception("RA Not Registered");
			
			student = new Student(ra, resultado.getString("sname"), resultado.getInt("course"), resultado.getString("zip"), resultado.getString("complement"), resultado.getInt("number"));
		}
		catch(SQLException ex)
		{
			throw new Exception("ERROR! Couldn't get the student");
		}
		
		return student;
	}
	public static MeuResultSet getAlunos() throws Exception
	{
		MeuResultSet resultado = null;
		
		try
		{
			String sql = "select * from Student";
			
			BDSQLServer.COMANDO.prepareStatement(sql);
			
			resultado = (MeuResultSet)BDSQLServer.COMANDO.executeQuery();
		}
		catch(SQLException ex)
		{
			throw new Exception ("Erro ao Acessar os alunos");
		}
		
		return resultado;
	}
}