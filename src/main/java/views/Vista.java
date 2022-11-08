package views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JList;
import javax.swing.JComboBox;

public class Vista extends JFrame {

	private JPanel contentPane;
	public JTextField textIdCliente;
	public JTextField textNombreCliente;
	public JTextField textApellidoCliente;
	public JTextField textDireccionCliente;
	public JTextField textDniCliente;
	public JTextField textFechaCliente;
	public JButton botonCreate;
	public JButton botonUpdate;
	public JButton botonDelete;
	public JButton botonRead;
	public JComboBox comboBox;
	public JTextField textIdVideos;
	public JTextField textDirectorVideos;
	public JTextField textTituloVideos;
	public JTextField textClienteId;


	
	public Vista() {
		setTitle("CRUD Ejercicio 1");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 714, 297);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		botonCreate = new JButton("Create");
		botonCreate.setBounds(25, 72, 85, 21);
		contentPane.add(botonCreate);
		
		botonUpdate = new JButton("Update");
		botonUpdate.setBounds(25, 115, 85, 21);
		contentPane.add(botonUpdate);
		
		botonDelete = new JButton("Delete");
		botonDelete.setBounds(25, 162, 85, 21);
		contentPane.add(botonDelete);
		
		botonRead = new JButton("Read");
		botonRead.setBounds(25, 205, 85, 21);
		contentPane.add(botonRead);
		
		textIdCliente = new JTextField();
		textIdCliente.setBounds(139, 73, 177, 19);
		contentPane.add(textIdCliente);
		textIdCliente.setColumns(10);
		
		textNombreCliente = new JTextField();
		textNombreCliente.setColumns(10);
		textNombreCliente.setBounds(139, 102, 177, 19);
		contentPane.add(textNombreCliente);
		
		textApellidoCliente = new JTextField();
		textApellidoCliente.setColumns(10);
		textApellidoCliente.setBounds(139, 131, 177, 19);
		contentPane.add(textApellidoCliente);
		
		textDireccionCliente = new JTextField();
		textDireccionCliente.setColumns(10);
		textDireccionCliente.setBounds(139, 163, 177, 19);
		contentPane.add(textDireccionCliente);
		
		textDniCliente = new JTextField();
		textDniCliente.setColumns(10);
		textDniCliente.setBounds(139, 192, 177, 19);
		contentPane.add(textDniCliente);
		
		textFechaCliente = new JTextField();
		textFechaCliente.setColumns(10);
		textFechaCliente.setBounds(139, 221, 177, 19);
		contentPane.add(textFechaCliente);
		
		JLabel lblNewLabel = new JLabel("id");
		lblNewLabel.setBounds(326, 79, 45, 13);
		contentPane.add(lblNewLabel);
		
		JLabel lblNombre = new JLabel("nombre");
		lblNombre.setBounds(326, 108, 45, 13);
		contentPane.add(lblNombre);
		
		JLabel lblApellido = new JLabel("apellido");
		lblApellido.setBounds(326, 137, 57, 13);
		contentPane.add(lblApellido);
		
		JLabel lblDireccion = new JLabel("direccion");
		lblDireccion.setBounds(326, 169, 57, 13);
		contentPane.add(lblDireccion);
		
		JLabel lblDni = new JLabel("dni");
		lblDni.setBounds(328, 198, 45, 13);
		contentPane.add(lblDni);
		
		JLabel lblFecha = new JLabel("fecha");
		lblFecha.setBounds(328, 227, 45, 13);
		contentPane.add(lblFecha);
		
		JLabel lblNewLabel_1 = new JLabel("Tabla usada:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel_1.setBounds(176, 10, 164, 31);
		contentPane.add(lblNewLabel_1);
		
		comboBox = new JComboBox();
		comboBox.setBounds(350, 21, 170, 21);
		contentPane.add(comboBox);
		comboBox.addItem("cliente");
		comboBox.addItem("videos");
		
		textIdVideos = new JTextField();
		textIdVideos.setColumns(10);
		textIdVideos.setBounds(406, 72, 177, 19);
		contentPane.add(textIdVideos);
		
		textTituloVideos = new JTextField();
		textTituloVideos.setColumns(10);
		textTituloVideos.setBounds(406, 101, 177, 19);
		contentPane.add(textTituloVideos);
		
		textDirectorVideos = new JTextField();
		textDirectorVideos.setColumns(10);
		textDirectorVideos.setBounds(406, 130, 177, 19);
		contentPane.add(textDirectorVideos);
		
		textClienteId = new JTextField();
		textClienteId.setColumns(10);
		textClienteId.setBounds(406, 162, 177, 19);
		contentPane.add(textClienteId);
		
		JLabel lblNewLabel_2 = new JLabel("id");
		lblNewLabel_2.setBounds(593, 78, 45, 13);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblTtulo = new JLabel("título");
		lblTtulo.setBounds(593, 107, 45, 13);
		contentPane.add(lblTtulo);
		
		JLabel lblDirector = new JLabel("director");
		lblDirector.setBounds(593, 136, 76, 13);
		contentPane.add(lblDirector);
		
		JLabel lblIdCliente = new JLabel("id cliente");
		lblIdCliente.setBounds(593, 168, 57, 13);
		contentPane.add(lblIdCliente);
		

	}
}
