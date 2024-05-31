package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import javabeans.Cliente;

@Named("daoClientes")
@RequestScoped
public class DaoClientesImpl implements DaoClientes {	

	private static final String url="jdbc:mysql://localhost:3306/libros";
	private static final String user="root";
	private static final String pwd="root";

	// CARGA DEL DRIVER
	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}	
	}	
	
	@Override
	public boolean autenticar(String userr, String pass) {
		boolean res=false;
	
//		Class.forName("com.mysql.jdbc.Driver");
		// ESTABLECEMOS LA CONEXION REMOTA CON LA BD.
//		Connection conexion = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "master", "master");
//		(Connection con=Datos.getConnection("reflibros"))
		try(Connection con=DriverManager.getConnection(url,user,pwd);){
			String sql="select * from clientes where usuario=? and password=?";
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, userr);
			ps.setString(2, pass);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				res=true;
			}			
		}
		catch(SQLException ex) {
			ex.printStackTrace();
		}
		return res;
	}

	@Override
	public void registrar(Cliente c) {
		try(Connection con=DriverManager.getConnection(url,user,pwd);) {                       
	           
            String sql="insert into clientes (usuario,password,email,telefono) ";
            sql+="values(?,?,?,?)";
            //creamos consulta preparada:
            PreparedStatement ps=con.prepareStatement(sql);
               //Sustituimos parametros por valores
               ps.setString(1, c.getUsuario());
               ps.setString(2, c.getPassword());
               ps.setString(3, c.getEmail());
               ps.setInt(4, c.getTelefono());
               //ejecutamos
             ps.execute();
            
        }  catch (SQLException ex) {
            ex.printStackTrace();
        }  
		
	}

}
