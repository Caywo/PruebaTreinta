package juego;

import java.awt.Image;

import entorno.Entorno;
import entorno.Herramientas;

public class Perra {
		
		// Variables de instancia
		double x;
		double y;
		int direccion;
		Image[] img;
		
		
		
		//constructor
		
		public Perra(double x, double y) {


			this.x = x;
			this.y = y;
			this.direccion = 0;
			this.img = new Image[4];
			
			for (int i=0; i < img.length ; i++) {
				
				img[i] = Herramientas.cargarImagen("imagen"+i+".png");
				
			}
			
		}
		
		public void dibujarse(Entorno entorno)
		{
			entorno.dibujarImagen(img[this.direccion], this.x, this.y, 0, 0.5);
		}
		
		
		public void mover(int d)
		{
			
			this.direccion=d;
			
			if (direccion ==0)
			{
				y-=3;	
			}
			if (direccion ==1)
			{
				x+=3;	
			}
			if (direccion ==2)
			{
				y+=3;	
			}
			if (direccion ==3)
			{
				x-=3;	
			}
		}
		

}
