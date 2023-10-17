package juego;

import java.awt.Image;

import entorno.Entorno;
import entorno.Herramientas;

public class Manzana {

	// Variables de instancia
		double x;
		double y;
		Image img;
		double ancho;
		double alto;
		double escala;
		
		
		
		
		
		public Manzana(double x, double y) {
			this.escala=0.5;
			this.x = x;
			this.y = y;
			
			img = Herramientas.cargarImagen("manzana.png");
			this.ancho=img.getWidth(null)*this.escala;
			this.alto=img.getHeight(null)*this.escala;
			
		}
	

		
		public void dibujarse(Entorno entorno)
		{
			entorno.dibujarImagen(img, this.x, this.y, 0, this.escala);
		}
		

		
		
}
