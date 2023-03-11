package crudActionsWithCSV;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

//En este proyecto usan archivos csv
//inicio: se lee el archivo y se pasa a un arraylist
//durante: al hacer acciones a los valores se hacen en el arraylist
//final: se reescribe el archivo con el arraylist

//ME FALTA programar el caso cuando no se encuentra el archivo y su creacion

public class Rectoria 
{
	public static List<alumno> lista = new ArrayList<>();
	public static final String p = "Files/saludo.txt";
	
	public static void main(String[] args) 
	{
		checkPath();
		menu();
	}
	
	private static void menu() 
	{
		String menu="6";
		do
		{
			menu = JOptionPane.showInputDialog("1.nuevo\n2.leer\n3.actualizar\n4.eliminar\n5.Salir\nopcion: ");
			
//			menu es null cuando se usa la tacha para cerrar la ventana
			if(menu==null)
			{
				menu = "5";
			}
			if(menu.isBlank())
			{
				menu = " ";
			}
			
			switch (menu.trim())
			{
				case "1":{
					create();  break; //create
				}
				case "2":{
					read();  break; // read
				}
				case "3": {
					update(); break; // update
				}
				case "4": {
					delete(); break; // delete
				}
				case "5": {
					leerListaEscribirArchivo(); break;
				}
				default: {
					JOptionPane.showMessageDialog(null, "valor invalido: "+menu); break;
				}
			}
		}while (menu.isBlank()||!menu.equals("5"));
		JOptionPane.showMessageDialog(null, "Fin");
		System.out.println("Fin");
	}
	
//	FUNCIONES ARCHIVOS
	private static void checkPath() 
	{
		Path ruta = Paths.get(p);
		if(Files.exists(ruta))
		{
			System.out.println("ruta correcta");
			leerArchivoCrearLista();
		}
		else 
		{
			System.out.println("Error! el archivo o ruta no existen");
//			crear archivo
		}
	}
	
	private static void leerArchivoCrearLista() 
	{
		try 
		{
			BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(p), "utf-8"));
			String linea = null;
			while ((linea = br.readLine())!=null) 
			{
				String [] a = linea.split(",");
				String nom = a[0];
				int edad = Integer.parseInt(a[1]);
				int mat = Integer.parseInt(a[2]);
				lista.add(new alumno(nom,edad, mat));
			}
			br.close();
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}
	
	private static void leerListaEscribirArchivo()
	{
		try {
			Writer wt = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(p), "utf-8"));
			
			for (alumno h : lista) 
			{
				wt.write(h.toString()+"\n");
			}
			
			wt.close();
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}
	
//	FUNCIONES CRUD action with the ArrayList
	private static void create() 
	{
		String nom = JOptionPane.showInputDialog("nombre: ");
		int edad = Integer.parseInt(JOptionPane.showInputDialog("edad: "));
		int mat = Integer.parseInt(JOptionPane.showInputDialog("matricula: "));
		
		alumno h = new alumno(nom, edad, mat);
		lista.add(h);
	}	
	
	private static void read() 
	{
		System.out.println("\nNombre,Edad,Matricula");
		for (alumno h: lista) 
		{
			System.out.println(h.toString());
		}
		System.out.println();
	}
	
	// update arraylist obj by index
	private static void update() 
	{
		read();
		int index = Integer.parseInt(JOptionPane.showInputDialog("indice de la lista que desea actualizar: ").trim());
		alumno h = lista.get(index);
		
		String nom = JOptionPane.showInputDialog("nombre: ",h.getNom()).trim();
		int edad = Integer.parseInt(JOptionPane.showInputDialog("edad: ",h.getEdad()).trim());		
		int mat = Integer.parseInt(JOptionPane.showInputDialog("matricula: ",h.getEdad()).trim());
		
		lista.set(index,new alumno(nom,edad,mat));
	}
	
	// delete arraylist obj by the index
	private static void delete() 
	{
		int index = Integer.parseInt(JOptionPane.showInputDialog("indice de la lista que desea eliminar: ").trim());
		lista.remove(index);
	}

//	FUNCIONES UTILES
}
