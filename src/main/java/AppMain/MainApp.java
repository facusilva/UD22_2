package AppMain;

import controllers.Controlador;
import models.ModeloClientes;
import models.ModeloVideos;
import views.Vista;

public class MainApp {
	
	public static void main (String[] args) {
		ModeloClientes modelo1 = new ModeloClientes();
		ModeloVideos modelo2 = new ModeloVideos();
		Vista vista = new Vista();
		Controlador controlador = new Controlador(modelo1, modelo2,vista);
		
		//IniciarVista nos va a establecer la conexión, crear la base de datos, la tabla y darle visibilidad a la interfaz vista.
		
		controlador.iniciarVista();
	}

}
