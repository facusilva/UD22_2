package models;
import Conexion.ConexionClientes;
import Conexion.ConexionVideos;
import views.Vista;

public class ModeloVideos {

	private ConexionVideos conexionVideos;
	private int id;
	private String titulo;
	private String director;
	private int cli_id;

	// Constructores

	public ModeloVideos() {
		this.conexionVideos =  new ConexionVideos();
	}
	
	public ModeloVideos(int id) {
		this.conexionVideos =  new ConexionVideos();
		this.id = id;
	}


	public ModeloVideos(String titulo, String director, int cli_id) {
		this.conexionVideos =  new ConexionVideos();
		this.titulo = titulo;
		this.director = director;
		this.cli_id = cli_id;
	}
	
	public ModeloVideos(int id, String titulo, String director, int cli_id) {
		this.conexionVideos =  new ConexionVideos();
		this.id = id;
		this.titulo = titulo;
		this.director = director;
		this.cli_id = cli_id;
	}

	// Método para crear una nueva fila en la tabla.

		
	public void createUser() {
		conexionVideos.establecerCon();
		conexionVideos.crearUsuario(titulo, director, cli_id);
	}
	
	// Método para borrar una fila en la tabla.
	
	public void borrarUsuario() {
		conexionVideos.establecerCon();
		conexionVideos.borrarTabla(id);
	}
	
	// Método para editar una fila en la tabla.
	
	public void editarUsuario(){
		conexionVideos.establecerCon();
		conexionVideos.editarUsuario(id,titulo, director, cli_id);
	}
	
	// Método para leer los datos de fila en la tabla y retornar los datos al
	// controlador.
	
	public String readUsuario() {
		conexionVideos.establecerCon();
		String datos ="";
		datos = conexionVideos.leerUsuario(id);
		return datos;
	}
	
	// Getters y Setters.
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	public int getClienteId() {
		return cli_id;
	}
	public void setClienteId(int cli_id) {
		this.cli_id = cli_id;
	}
	
	
	
}
