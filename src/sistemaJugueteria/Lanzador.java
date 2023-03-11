package sistemaJugueteria;

import jugueteria.JulioCepeda;

public class Lanzador 
{
	public static void main(String[] args) 
	{
//		Modelo mod = new Modelo();
//		el modelo esta en la libreria
		JulioCepeda mod = new JulioCepeda();
		Vista vis = new Vista();
		Controlador con = new Controlador(mod,vis);
	}
}