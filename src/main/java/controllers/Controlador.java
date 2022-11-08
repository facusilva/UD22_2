package controllers;

import java.awt.EventQueue;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import Conexion.ConexionClientes;
import Conexion.ConexionVideos;
import models.ModeloClientes;
import models.ModeloVideos;
import views.Vista;

public class Controlador implements ActionListener{
	
	private ModeloClientes modeloClientes;
	private ModeloVideos modeloVideos;
	private Vista vista;
	private ConexionClientes conexionClientes;
	private int id;
	private int id2;
	private String nombre;
	private String apellido;
	private String direccion;
	private int dni;
	private String fecha;
	private String titulo;
	private String director;
	private int cli_id;
	private String tabla;

	public Controlador(ModeloClientes modelo1, ModeloVideos modelo2, Vista vista) {
		this.modeloClientes = modelo1;
		this.modeloVideos = modelo2;
		this.vista = vista;
		this.vista.botonDelete.addActionListener(this);
		this.vista.botonCreate.addActionListener(this);
		this.vista.botonUpdate.addActionListener(this);
		this.vista.botonRead.addActionListener(this);
		this.conexionClientes = new ConexionClientes();
	}
	
	@Override
	public void actionPerformed(ActionEvent evento) {
		if(vista.botonDelete == evento.getSource()) {
			borrarUser();
		}else if(vista.botonCreate== evento.getSource()) {
			addUser();
		}else if(vista.botonRead== evento.getSource()) {
			readUser();
		}else if(vista.botonUpdate == evento.getSource()) {
			updateUser();
		}
	}
	
	public void addUser() {
		tabla = String.valueOf(vista.comboBox.getSelectedItem());
		if(tabla == "cliente") {
			nombre = vista.textNombreCliente.getText();
			apellido = vista.textApellidoCliente.getText();
			direccion = vista.textDireccionCliente.getText();
			dni = Integer.parseInt(vista.textDniCliente.getText());
			fecha = vista.textFechaCliente.getText();
			modeloClientes = new ModeloClientes(nombre, apellido, direccion, dni, fecha);
			modeloClientes.createUser();
		}else if(tabla == "videos") {
			titulo = vista.textTituloVideos.getText();
			director = vista.textDirectorVideos.getText();
			cli_id = Integer.parseInt(vista.textClienteId.getText());
			modeloVideos = new ModeloVideos(titulo, director, cli_id);
			modeloVideos.createUser();
		}
	}
	
	
	public void borrarUser() {
		tabla = String.valueOf(vista.comboBox.getSelectedItem());
		if(tabla == "cliente") {
			id = Integer.parseInt(vista.textIdCliente.getText());
			modeloClientes = new ModeloClientes(id);
			modeloClientes.borrarUsuario();
		}else if(tabla == "videos") {
			id2 = Integer.parseInt(vista.textIdVideos.getText());
			modeloVideos = new ModeloVideos(id2);
			modeloVideos.borrarUsuario();
		}
	}
	
	public void readUser() {
		tabla = String.valueOf(vista.comboBox.getSelectedItem());
		if(tabla == "cliente") {
			id = Integer.parseInt(vista.textIdCliente.getText());
			modeloClientes = new ModeloClientes(id,nombre, apellido, direccion, dni, fecha);
			String datos = modeloClientes.readUsuario();
			System.out.println(datos);
			String[] partes = datos.split("__");
			String id = partes[0];
			vista.textIdCliente.setText(id);
			String nombre = partes[1];
			vista.textNombreCliente.setText(nombre);
			String apellido = partes[2];
			vista.textApellidoCliente.setText(apellido);
			String direccion= partes[3];
			vista.textDireccionCliente.setText(direccion);
			String dni = partes[4];
			vista.textDniCliente.setText(dni);
			String fecha = partes[5];
			vista.textFechaCliente.setText(fecha);
		}else if(tabla == "videos") {
			id2 = Integer.parseInt(vista.textIdVideos.getText());
			modeloVideos = new ModeloVideos(id2, titulo, director, cli_id);
			String datos2 = modeloVideos.readUsuario();
			String[] partes = datos2.split("__");
			String id = partes[0];
			vista.textIdVideos.setText(id);
			String titulo = partes[1];
			vista.textTituloVideos.setText(titulo);
			String director = partes[2];
			vista.textDirectorVideos.setText(director);
			String cli_id= partes[3];
			vista.textClienteId.setText(cli_id);
			
		}
	}
	
	public void updateUser() {
		tabla = String.valueOf(vista.comboBox.getSelectedItem());
		if(tabla == "cliente") {
			id = Integer.parseInt(vista.textIdCliente.getText());
			nombre = vista.textNombreCliente.getText();
			apellido = vista.textApellidoCliente.getText();
			direccion = vista.textDireccionCliente.getText();
			dni = Integer.parseInt(vista.textDniCliente.getText());
			fecha = vista.textFechaCliente.getText();
			modeloClientes = new ModeloClientes(id,nombre, apellido, direccion, dni, fecha);
			modeloClientes.editarUsuario();
		}else if(tabla == "videos") {
			id2 = Integer.parseInt(vista.textIdVideos.getText());
			titulo = vista.textTituloVideos.getText();
			director = vista.textDirectorVideos.getText();
			cli_id = Integer.parseInt(vista.textClienteId.getText());
			modeloVideos = new ModeloVideos(id2, titulo, director, cli_id);
			modeloVideos.editarUsuario();
		}
	}
	
	public void cerrarCon() {
		conexionClientes.cerrarCon();
	}
	
	public void iniciarVista() {
		conexionClientes.establecerCon();
		conexionClientes.crearDB();
		conexionClientes.crearTabla();
		vista.setTitle("Conversor");
		vista.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		vista.setLocationRelativeTo(null);
		vista.setVisible(true);
		 
	}

}
