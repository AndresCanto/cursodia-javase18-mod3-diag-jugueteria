package sistemaJugueteria;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Iterator;

import javax.swing.JOptionPane;

import jugueteria.Juguete;
import jugueteria.JulioCepeda;

public class Controlador implements ActionListener
{
	JulioCepeda mod;
	Vista vis;
	Juguete toy;
	public Controlador(JulioCepeda mod,Vista vis)
	{
		this.mod = mod;
		this.vis = vis;
		ejecutar();
	}
	private void ejecutar()
	{
		vis.Lanzar();
		while(!vis.termino)
		{
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		vis.btnPrimero.addActionListener(this);
		vis.btnAnterior.addActionListener(this);
		vis.btnSiguiente.addActionListener(this);
		vis.btnUltimo.addActionListener(this);
		vis.btnNuevo.addActionListener(this);
		vis.btnGuardar.addActionListener(this);
		vis.btnModificar.addActionListener(this);
		vis.btnEliminar.addActionListener(this);
		vis.btnCancelar.addActionListener(this);
		vis.btnSalir.addActionListener(this);
		JulioCepeda.leerArchivoCrearLista(); //decia que lo quitara pero nose porque
		if(JulioCepeda.getInventarioSize()>0)
		{
			toy = JulioCepeda.getJuguetes(0);
			fillFields();
			for (Juguete j : JulioCepeda.listaJuguetes) 
			{
				System.out.println(j.toString());
			}
		}
		int close = vis.getDefaultCloseOperation();
		System.out.println(close);
//		if(vis.getDefaultCloseOperation()==0)
//		{
//			JulioCepeda.leerListaEscribirArchivo();
//			System.out.println("ola");
//		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		
//NAVEGATION BUTTONS
		if(e.getSource()==vis.btnPrimero)
		{
			int indexAct = JulioCepeda.getIndexOf(toy);
			if(JulioCepeda.getInventarioSize()>0)
			{
				if((indexAct-1)>-1)
				{
					toy = JulioCepeda.getJuguetes(0);
					fillFields();
				}
				else
				{
					JOptionPane.showMessageDialog(vis, "Estas en el primer registro");
				}
			}
		}
		if(e.getSource()==vis.btnAnterior)
		{
			int indexAct = JulioCepeda.getIndexOf(toy);
			if(JulioCepeda.getInventarioSize()>0)
			{
				if((indexAct-1)>-1)
				{
					toy = JulioCepeda.getJuguetes(indexAct-1);
					fillFields();
				}
				else
				{
					JOptionPane.showMessageDialog(vis, "Estas en el primer registro");
				}
			}
		}
		if(e.getSource()==vis.btnSiguiente)
		{
			int indexAct = JulioCepeda.getIndexOf(toy);
			if(JulioCepeda.getInventarioSize()>0)
			{
				if((indexAct+1)<JulioCepeda.getInventarioSize())
				{
					toy = JulioCepeda.getJuguetes(indexAct+1);
					fillFields();
				}
				else
				{
					JOptionPane.showMessageDialog(vis, "Estas en el ultimo registro");
				}
			}
		}
		if(e.getSource()==vis.btnUltimo)
		{
			int indexAct = JulioCepeda.getIndexOf(toy);
			if(JulioCepeda.getInventarioSize()>0)
			{
				if((indexAct+1)<JulioCepeda.getInventarioSize())
				{
					toy = JulioCepeda.getJuguetes(JulioCepeda.getInventarioSize()-1);
					fillFields();
				}
				else
				{
					JOptionPane.showMessageDialog(vis, "Estas en el ultimo registro");
				}
			}
		}
		
//CRUD BUTTONS
		if(e.getSource()==vis.btnNuevo)
		{
			clearFields();
			setEnabledNavBtns(false);
			setEnabledCrudBtns(false);
			vis.btnGuardar.setEnabled(true);
		}
		if(e.getSource()==vis.btnGuardar) //create action
		{
			setEditableFields(false);
			setEnabledNavBtns(true);
			setEnabledCrudBtns(true);
			readFields(); //read the fields
			JulioCepeda.listaJuguetes.add(toy); //add it to the arraylist
			for (Juguete j : JulioCepeda.listaJuguetes) 
			{
				System.out.println(j.toString());
			}
			fillFields();
		}
		if(e.getSource()==vis.btnModificar) //update action
		{
			setEditableFields(true);
			setEnabledNavBtns(false);
			setEnabledCrudBtns(false);
			vis.btnGuardar.setEnabled(true);
			vis.btnCancelar.setEnabled(true);
		}
		if(e.getSource()==vis.btnEliminar) // delete action
		{
			setEditableFields(false);
			setEnabledNavBtns(false);
			setEnabledCrudBtns(false);
//			readFields();
			JulioCepeda.listaJuguetes.remove(toy);
			fillFields();
		}
		
//EXTRA BUTTONS
		if(e.getSource()==vis.btnCancelar)
		{
			fillFields();
			setEnabledNavBtns(true);
			setEnabledCrudBtns(true);
		}
		if(e.getSource()==vis.btnSalir)
		{
			int op = JOptionPane.showConfirmDialog(vis, "Desea salir?");
			if(op==0)
			{
				JulioCepeda.leerListaEscribirArchivo();
				vis.dispose();
			}
		}
		//falta atrapar cuando se usa el default close operation
	}
	
//METODOS UTILES
	//read action
	private void readFields() 
	{
		int id = Integer.parseInt(vis.txtId.getText());
		String nom = vis.txtNom.getText();
		float pre = Float.parseFloat(vis.txtPre.getText());
		String marc = vis.txtMarc.getText();
		int cat = Integer.parseInt(vis.txtCat.getText());
		int stock = Integer.parseInt(vis.txtStock.getText());
		toy = new Juguete(id, nom, pre, marc, cat, stock);
	}
	
	private void fillFields() 
	{
		vis.txtId.setText(""+toy.getId_jug());
		vis.txtNom.setText(toy.getNom_jug());
		vis.txtPre.setText(""+toy.getPre_jug());
		vis.txtMarc.setText(toy.getMarc_jug());
		vis.txtCat.setText(""+toy.getCat_jug());
		vis.txtStock.setText(""+toy.getStock_jug());
		setEditableFields(false);
	}
	private void clearFields() 
	{
		vis.txtId.setText("");
		vis.txtNom.setText("");
		vis.txtPre.setText("");
		vis.txtMarc.setText("");
		vis.txtCat.setText("");
		vis.txtStock.setText("");
		setEditableFields(true);
	}
	private void setEditableFields(boolean en) 
	{
		vis.txtId.setEditable(en);
		vis.txtNom.setEditable(en);
		vis.txtPre.setEditable(en);
		vis.txtMarc.setEditable(en);
		vis.txtCat.setEditable(en);
		vis.txtStock.setEditable(en);
	}
	private void setEnabledNavBtns(boolean en) 
	{
		vis.btnPrimero.setEnabled(en);
		vis.btnAnterior.setEnabled(en);
		vis.btnSiguiente.setEnabled(en);
		vis.btnUltimo.setEnabled(en);
	}
	private void setEnabledCrudBtns(boolean en) 
	{
		vis.btnNuevo.setEnabled(en);
		vis.btnGuardar.setEnabled(en);
		vis.btnModificar.setEnabled(en);
		vis.btnEliminar.setEnabled(en);
	}
}
