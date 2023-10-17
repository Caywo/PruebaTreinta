package juego;

import java.awt.Color;

import entorno.Entorno;
import entorno.InterfaceJuego;

public class Juego extends InterfaceJuego {

	// El objeto Entorno que controla el tiempo y otros
	private Entorno entorno;
    Perra perra;
    Manzana[] manzanitas;
	
	public Juego() {
this.entorno = new Entorno(this, "Perrita", 800, 600);
		
		// Inicializar lo que haga falta para el juego
		// ...
		perra=new Perra(390,590);
		manzanitas = new Manzana [6];
		int posXManzana= 150;
		int posYManzana= 180;
		for(int i = 0; i<manzanitas.length; i++) {
			manzanitas[i] = new Manzana(posXManzana,posYManzana);
			if(posXManzana <= entorno.ancho()-150) {
				posXManzana += 250;
			}
			if(posXManzana > entorno.ancho()-150) {
				posXManzana = 150;
				posYManzana += 260;
			}
			
		}
		// Inicia el juego!
		this.entorno.iniciar();
	}
	
	
	public int colisionMultiple(Manzana[] m, Perra a) {
		for(int i= 0; i<m.length; i++) {
			if(colision(m[i],a) != 5) {
				return colision(m[i],a);
			}
		}
		return 5;
		
	}
	public int colision (Manzana m, Perra a) {
		double zona1 = m.x-(m.ancho/2);
		double zona3 = m.x+(m.ancho/2);
		double zona2 = m.y-(m.alto/2);
		double zona0 = m.y+(m.alto/2);
		
		
		if(a.y > zona2 && a.y < zona0 && a.x>zona1-60 && a.x<zona3) {
			return 1;
		}
		
		if(a.x > zona1 && a.x < zona3 && a.y>zona2-60 && a.y<zona0) {
			return 2;
		}
		if(a.x > zona1 && a.x < zona3 && a.y>zona2 && a.y<zona0+60) {
			return 0;
		}
		if(a.x > zona1 && a.x < zona3+60 && a.y>zona2 && a.y<zona0) {
			return 3;
		}
		return 5;
		//PRUEBA ASL,KMDLAÑSJDLSA JKLÑASJDLPÑÁSDÑLASJDÑLSAJKDLÑASSDA
		
	}
	//Funcion que no permite salir del entorno
	public int colisionEntorno(Perra a) {
		int bordeIzquierdo = entorno.ancho()-(entorno.ancho()-30);
		int bordeDerecho = entorno.ancho()-40;
		int bordeSuperior = entorno.alto() - (entorno.alto()-50);
		int bordeInferior = entorno.alto() - 10;
		if(bordeIzquierdo == a.x) {
			return 3;
		}
		if(bordeDerecho == a.x) {
			return 1;
		}
		if(bordeSuperior == a.y) {
			return 0;
		}
		if(bordeInferior == a.y) {
			return 2;
		}
		return 5;
	}
	
	public void dibujarManzanas(Manzana[] manzanas) {
		for(int i=0; i<manzanitas.length; i++) {
			manzanitas[i].dibujarse(this.entorno);
		}
	}
	

	/**
	 * Durante el juego, el método tick() será ejecutado en cada instante y 
	 * por lo tanto es el método más importante de esta clase. Aquí se debe 
	 * actualizar el estado interno del juego para simular el paso del tiempo 
	 * (ver el enunciado del TP para mayor detalle).
	 */
	public void tick() {
		// Procesamiento de un instante de tiempo
		// ...	
		
		if (entorno.estaPresionada(entorno.TECLA_DERECHA) && colisionMultiple(manzanitas,perra)!=1 && colisionEntorno(perra)!=1) {
			perra.mover(1);

		}
		if (entorno.estaPresionada(entorno.TECLA_ARRIBA) && colisionMultiple(manzanitas,perra)!=0 && colisionEntorno(perra)!=0) {
			perra.mover(0);

		}	
		
		if (entorno.estaPresionada(entorno.TECLA_ABAJO) && colisionMultiple(manzanitas,perra)!=2 && colisionEntorno(perra)!=2) {
			perra.mover(2);

		}
		
		if (entorno.estaPresionada(entorno.TECLA_IZQUIERDA) && colisionMultiple(manzanitas,perra)!=3 && colisionEntorno(perra)!=3) {
			perra.mover(3);

		}
		
		
		dibujarManzanas(manzanitas);
		perra.dibujarse(this.entorno);
		
		
		entorno.cambiarFont("Arial", 18, Color.white);
		
		entorno.escribirTexto("posicion en x:" + perra.x, 600, 50);
		entorno.escribirTexto("posicion en y:" + perra.y, 600, 100);
	}
	
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		Juego juego = new Juego();
	}

}
