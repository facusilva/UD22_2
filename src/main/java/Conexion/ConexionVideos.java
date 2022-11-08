package Conexion;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;

import models.ModeloClientes;
import views.Vista;

public class ConexionVideos {

	private Connection conexion;

	// Método para establecer conexión

	public void establecerCon() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conexion = DriverManager.getConnection("jdbc:mysql://192.168.1.38:3306?useTimezone=true&serverTimezone=UTC",
			"alberto","Z001349ebeadr@");
			//conexion = DriverManager.getConnection(
			//		"jdbc:mysql://192.168.1.172:3306?useTimezone=true&serverTimezone=UTC", "remote", "Kappa323232!");
			System.out.println(" Server connected ");
		} catch (SQLException | ClassNotFoundException ex) {
			System.out.println("No se ha podido conectar con mi base de datos");
			ex.printStackTrace();
			JOptionPane.showMessageDialog(null,"Hubo un error al conectar con el servidor");
		}
	}

	// Método para cerrar la conexión

	public void cerrarCon() {
		try {
			conexion.close();
			JOptionPane.showMessageDialog(null, "Se ha finalizado la conexión con el server");
		} catch (SQLException ex) {
			Logger.getLogger(ModeloClientes.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	// Método que elimina las bases de datos que les introducimos en caso de existir
	// y crea una con dicho nombre

	public void crearDB() {
		try {
			String Query = "DROP DATABASE IF EXISTS clientes;";
			String Query2 = "CREATE DATABASE clientes;";
			Statement st = conexion.createStatement();
			st.executeUpdate(Query);
			st.executeUpdate(Query2);
			System.out.println(" Server connected ");
		} catch (SQLException ex) {
			
			System.out.println(ex);
			System.out.println("No se ha podido conectar crear la BBDD o ya existe");
		}

	}

	// Método para crear las tablas

	public void crearTabla() {

		try {

			String Querydb = "USE clientes;";
			Statement stdb = conexion.createStatement();
			stdb.executeUpdate(Querydb);

			String Query = "CREATE TABLE cliente (\r\n" + "id int(11) NOT NULL AUTO_INCREMENT,\r\n"
					+ "nombre varchar(250) DEFAULT NULL,\r\n" + "apellido varchar(250) DEFAULT NULL,\r\n"
					+ "direccion varchar(250) DEFAULT NULL,\r\n" + "dni int(11) DEFAULT NULL,\r\n"
					+ "fecha date DEFAULT NULL,\r\n" + "PRIMARY KEY (id)\r\n" + ");";
			String Query2 = "CREATE TABLE videos (\r\n" + "id int(11) NOT NULL AUTO_INCREMENT,\r\n"
					+ "title varchar(100) DEFAULT NULL,\r\n" + "director varchar(100) DEFAULT NULL,\r\n"
					+ "cli_id int(11) NOT NULL,\r\n" + "PRIMARY KEY (id),\r\n"
							+ "FOREIGN KEY (cli_id) REFERENCES cliente(id) ON DELETE CASCADE ON UPDATE CASCADE);";

			Statement st = conexion.createStatement();
			st.executeUpdate(Query);
			st.executeUpdate(Query2);
			System.out.println("Tabla cliente creada correctamente");
			System.out.println("Tabla videos creada correctamente");
		} catch (Exception ex) {

			System.out.println(ex);
			System.out.println("No se ha podido crear la tabla o ya existe");

		}

	}
	
	//Método para hacer DELETE y poder borrar una fila de la tabla cliente dependiendo de la id que le pasamos.
	
	public void borrarTabla(int id) {
        try {
            String Querydb = "USE clientes";
            String Query = "DELETE FROM videos "
                    + " WHERE id = '" + id + "'; ";
            System.out.println(Query);
            Statement stdb = conexion.createStatement();
            stdb.executeUpdate(Querydb);
            stdb.executeUpdate(Query);
        } catch (Exception ex) {
        	System.out.println(ex);
        }
    }
	
	//Método para hacer INSERTS en la tabla videos.
	
	public void crearUsuario(String titulo, String director, int cli_id) {
		try {
            String Querydb = "USE clientes";
			String Query = "INSERT INTO videos (titulo, director, cli_id) VALUES ('" + titulo + "','"
					+ director + "','" + cli_id + "');";
			System.out.println(Query);
			Statement stdb = conexion.createStatement();
			stdb.executeUpdate(Querydb);
			stdb.executeUpdate(Query);
		} catch (Exception ex) {
			System.out.println(ex);
		}
	}
	
	//Método para hacer UPDATE de una fila de la tabla videos.
	
	public void editarUsuario(int id, String titulo, String director, int cli_id) {
        try {
            String Querydb = "USE clientes";
            String Query = "UPDATE videos SET titulo = '" + titulo + "', director =  '" + director + "', cli_id = '" + cli_id +"'"
                    + "WHERE id = '" + id + "'; ";
            System.out.println(Query);
            Statement stdb = conexion.createStatement();
            stdb.executeUpdate(Querydb);
            stdb.executeUpdate(Query);
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

	//Método para rellenar los campos con los valores de una fila en la tabla videos.
	
	public String leerUsuario(int id) {
		String datos="";
		try {
            String Querydb = "USE clientes";
			String Query = "SELECT * FROM videos WHERE id ='"+id+"'";
			Statement stmt = conexion.createStatement(
				      ResultSet.TYPE_FORWARD_ONLY,
				      ResultSet.CONCUR_READ_ONLY);
			stmt.executeUpdate(Querydb);			
			ResultSet rs = stmt.executeQuery(Query);
			while(rs.next()) {
				int id1 = rs.getInt("id");
				String titulo1 = rs.getString("titulo");
				String director1 = rs.getString("director");
				String cli_id1 = rs.getString("cli_id");
				datos=id1+"__"+titulo1+"__"+director1+"__"+cli_id1;
			}
		} catch (Exception ex) {
			System.out.println(ex);
		}
		return datos;
	}
}