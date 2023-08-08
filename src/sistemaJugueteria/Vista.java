package sistemaJugueteria;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

@SuppressWarnings("serial")
public class Vista extends JFrame {

	private JPanel contentPane;
	JTextField txtId;
	JTextField txtNom;
	JTextField txtPre;
	JTextField txtMarc;
	JTextField txtCat;
	JTextField txtStock;
	JButton btnPrimero;
	JButton btnAnterior;
	JButton btnSiguiente;
	JButton btnUltimo;
	JButton btnSalir;
	JButton btnNuevo;
	JButton btnGuardar;
	JButton btnModificar;
	JButton btnEliminar;
	JButton btnCancelar;
	boolean termino =false;
	/**
	 * Launch the application.
	 */
	public void Lanzar() {
		EventQueue.invokeLater(new Runnable() 
		{
			public void run() {
				try {
					crearGUI();
					setVisible(true);
					setLocationRelativeTo(null);
					termino=true;
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public void crearGUI() 
	{
		setTitle("Jugueteria Andres");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE); 
		
		setBounds(100, 100, 470, 345);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel pnlDatos = new JPanel();
		pnlDatos.setLayout(null);
		pnlDatos.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "DATOS", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		pnlDatos.setBounds(20, 11, 411, 122);
		contentPane.add(pnlDatos);
		
		JLabel lbId = new JLabel("Clave:");
		lbId.setHorizontalAlignment(SwingConstants.TRAILING);
		lbId.setBounds(6, 22, 63, 14);
		pnlDatos.add(lbId);
		
		txtId = new JTextField();
		txtId.setColumns(10);
		txtId.setBounds(79, 19, 86, 20);
		pnlDatos.add(txtId);
		
		JLabel lbNom = new JLabel("Nombre:");
		lbNom.setHorizontalAlignment(SwingConstants.TRAILING);
		lbNom.setBounds(6, 58, 63, 14);
		pnlDatos.add(lbNom);
		
		txtNom = new JTextField();
		txtNom.setColumns(10);
		txtNom.setBounds(79, 55, 153, 20);
		pnlDatos.add(txtNom);
		
		JLabel lbPre = new JLabel("Precio:");
		lbPre.setHorizontalAlignment(SwingConstants.TRAILING);
		lbPre.setBounds(6, 99, 63, 14);
		pnlDatos.add(lbPre);
		
		txtPre = new JTextField();
		txtPre.setColumns(10);
		txtPre.setBounds(79, 96, 86, 20);
		pnlDatos.add(txtPre);
		
		JLabel lbMarc = new JLabel("Marca:");
		lbMarc.setHorizontalAlignment(SwingConstants.TRAILING);
		lbMarc.setBounds(242, 19, 63, 14);
		pnlDatos.add(lbMarc);
		
		txtMarc = new JTextField();
		txtMarc.setColumns(10);
		txtMarc.setBounds(315, 16, 86, 20);
		pnlDatos.add(txtMarc);
		
		JLabel lbCat = new JLabel("Categoria:");
		lbCat.setHorizontalAlignment(SwingConstants.TRAILING);
		lbCat.setBounds(242, 55, 63, 14);
		pnlDatos.add(lbCat);
		
		txtCat = new JTextField();
		txtCat.setColumns(10);
		txtCat.setBounds(315, 52, 86, 20);
		pnlDatos.add(txtCat);
		
		JLabel lbStock = new JLabel("Stock:");
		lbStock.setHorizontalAlignment(SwingConstants.TRAILING);
		lbStock.setBounds(242, 96, 63, 14);
		pnlDatos.add(lbStock);
		
		txtStock = new JTextField();
		txtStock.setColumns(10);
		txtStock.setBounds(315, 93, 86, 20);
		pnlDatos.add(txtStock);
		
		JPanel panel_nav = new JPanel();
		panel_nav.setLayout(null);
		panel_nav.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "NAV", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_nav.setBounds(20, 144, 411, 45);
		contentPane.add(panel_nav);
		
		btnPrimero = new JButton("Primero");
		btnPrimero.setBounds(6, 16, 89, 23);
		panel_nav.add(btnPrimero);
		
		btnAnterior = new JButton("Anterior");
		btnAnterior.setBounds(110, 16, 89, 23);
		panel_nav.add(btnAnterior);
		
		btnSiguiente = new JButton("Siguiente");
		btnSiguiente.setBounds(214, 16, 89, 23);
		panel_nav.add(btnSiguiente);
		
		btnUltimo = new JButton("Ultimo");
		btnUltimo.setBounds(318, 16, 89, 23);
		panel_nav.add(btnUltimo);
		
		JPanel panel_crud = new JPanel();
		panel_crud.setLayout(null);
		panel_crud.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "CRUD", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_crud.setBounds(20, 205, 413, 79);
		contentPane.add(panel_crud);
		
		btnNuevo = new JButton("Nuevo");
		btnNuevo.setBounds(6, 16, 89, 23);
		panel_crud.add(btnNuevo);
		
		btnGuardar = new JButton("Guardar");
		btnGuardar.setBounds(110, 16, 89, 23);
		panel_crud.add(btnGuardar);
		
		btnModificar = new JButton("Modificar");
		btnModificar.setBounds(214, 16, 89, 23);
		panel_crud.add(btnModificar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setBounds(318, 16, 89, 23);
		panel_crud.add(btnEliminar);
		
		btnSalir = new JButton("Salir");
		btnSalir.setBounds(318, 50, 89, 23);
		panel_crud.add(btnSalir);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(6, 50, 89, 23);
		panel_crud.add(btnCancelar);
	}
}
