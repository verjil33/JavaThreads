import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		comenzarJuego();
	}
	static void comenzarJuego() {
		System.out.println("Nombre del jugador 1: Pepe");		
		Persona jugador1 = new Persona("Pepe");
		System.out.println("Nombre del jugador 2: Jorge");
		Persona jugador2 = new Persona("Jorge");
		System.out.println("Nombre del jugador 3: Carlitox");		
		Persona jugador3 = new Persona("Carlitos");		
		Juego juego1 = new Juego(jugador1);
		Juego juego2 = new Juego(jugador2);		
		Juego juego3 = new Juego(jugador3);	
		juego1.oponentes(juego2, juego3);
		juego2.oponentes(juego1, juego3);
		juego3.oponentes(juego1, juego2);		
		juego1.start();
		juego2.start();
		juego3.start();
	}
}
