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
		controlador.iniciarVista();
	}

}
