package models;

import javax.swing.JOptionPane;

import Conexion.ConexionClientes;
import views.Vista;

public class ModeloClientes {

	private ConexionClientes conexionClientes;
	private int id;
	private String nombre;
	private String apellido;
	private String direccion;
	private int DNI;
	private String fecha;

	// Constructores

	public ModeloClientes() {
		this.conexionClientes = new ConexionClientes();
	}

	public ModeloClientes(int id) {
		this.conexionClientes = new ConexionClientes();
		this.id = id;
	}

	public ModeloClientes(String nombre, String apellido, String direccion, int dni, String fecha) {
		this.conexionClientes = new ConexionClientes();
		this.nombre = nombre;
		this.apellido = apellido;
		this.direccion = direccion;
		this.DNI = dni;
		this.fecha = fecha;

	}

	public ModeloClientes(int id, String nombre, String apellido, String direccion, int dni, String fecha) {
		this.id = id;
		this.conexionClientes = new ConexionClientes();
		this.nombre = nombre;
		this.apellido = apellido;
		this.direccion = direccion;
		this.DNI = dni;
		this.fecha = fecha;
	}

	// Método para crear una nueva fila en la tabla.

	public void createUser() {
		conexionClientes.establecerCon();
		conexionClientes.crearUsuario(nombre, apellido, direccion, DNI, fecha);
	}

	// Método para borrar una fila en la tabla.

	public void borrarUsuario() {
		conexionClientes.establecerCon();
		conexionClientes.borrarTabla(id);
	}

	// Método para editar una fila en la tabla.

	public void editarUsuario() {
		conexionClientes.establecerCon();
		conexionClientes.editarUsuario(id, nombre, apellido, direccion, DNI, fecha);

	}

	// Método para leer los datos de fila en la tabla y retornar los datos al
	// controlador.

	public String readUsuario() {
		conexionClientes.establecerCon();
		String datos = "";
		datos = conexionClientes.leerUsuario(id);
		return datos;
	}

	// Getters y Setters.

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public int getDNI() {
		return DNI;
	}

	public void setDNI(int dNI) {
		DNI = dNI;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

}
