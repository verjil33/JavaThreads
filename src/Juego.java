
public class Juego extends Thread {	
	private char[] letras = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','x','y','z','A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','P','R','S','T','U','V','X','Y','Z','1','2','3'};	
	private int turnos = 0;
	private Persona player;
	private Juego juego2;
	private Juego juego3;	
	boolean ganador = false;
	boolean perdedor = false;	
	public Juego(Persona jugador) {
		player = jugador;		
	}	
	public void oponentes(Juego oponente2, Juego oponente3 ) {
		juego2 = oponente2;
		juego3 = oponente3;
	}
	public void run() {		
		player.primerLetra(letras[(int)(Math.floor(Math.random()*50))]);
		turnos++;
		do {
			char a = letrasRandom();			
			if(a=='3') {
				juego2.perder();
				juego3.perder();
			}
			player.addLetra(a);
			if(a == '2') {
				try {
					sleep((int)(Math.random() * 10000));
			} catch (InterruptedException e) {}	
			}
			else {
				try {
					sleep((int)(Math.random() * 500));
			} catch (InterruptedException e) {}	
			}
			turnos++;			
		}while(!player.getEstado() && !perdedor);			
		if(perdedor == true) {
			System.out.println(getNombre() + " perdio");
		}
		else if(player.getEstado()) {
			ganador = true;
			System.out.println(player.getNombre() + " tardo " + turnos + " turnos para obtener el abecedario completo");
			juego2.perder();
			juego3.perder();
		}
		else {
			System.out.println("malio sal");
		}
	}
	public int getTurnos() {
		return turnos;
	}	
	public String getNombre() {
		return player.getNombre();
	}	
	public char letrasRandom() {
		return letras[(int)(Math.floor(Math.random()*53))];
	}
	public boolean getEstado() {
		return ganador;
	}
	public boolean perder() {
		perdedor= true;
		return perdedor;
	}
}
