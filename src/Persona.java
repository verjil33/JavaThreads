
public class Persona {	
	private char[] letras = new char[25];	
	private int cantActual = 0;	
	private int cantRestante = 25;	
	private boolean fullMayus;	
	private boolean gano = false;	
	String nombre;		
	public Persona(String a) {
		nombre = a;	
	}	
	String getNombre() {
		return nombre;
	}	
	char[] getLetras() {
		return letras;
	}	
	boolean getEstado() {
		return gano;
	}	
	public void primerLetra(char a) {
		if(Character.isUpperCase(a)) {
			System.out.println(nombre + " tendra que conseguir el abecedario en mayuscula ");
			fullMayus = true;			
		}
		else {
			System.out.println(nombre + " tendra que conseguir el abecedario en minuscula ");			
			fullMayus = false;	
		}	
		addLetra(a);
	}	
	public char addLetra(char a){	
		System.out.println("La letra que recibe " + nombre + " es: " + a);		
		if(a == '1') {
			System.out.println("A " + nombre + " le salio el comodin uno");
			return numeroUno();			
		}
		else if(a == '2') {
			System.out.println("A " + nombre + " le salio el comodin dos");
			return numeroDos();
		}
		else if(a == '3') {
			System.out.println("A " + nombre + " le salio el comodin tres");
			return numeroTres();
		}		
		if(Character.isUpperCase(a)) {
			if(fullMayus) {
				for(int i = 0; i < letras.length; i++) {
					
					for(int j = 0; j < letras.length; j++) {	
						if(letras[j] == a) {					
							System.out.println(nombre + " ya tiene esa letra");
							return a;
						}
					}
					if(letras[i] == '\u0000') {						
						letras[i] = a;	
						if(cantActual == 25) {
							gano = true;
						}
						cantActual++;
						cantRestante--;
						System.out.println(nombre + " añadio la letra " + a + " a su grupo y le quedan: " + cantRestante);						
						return a;
					}								
				}							
			}			
			System.out.println("La letra que recibio " + nombre + " no es minuscula");	
			return '\u0000';			
		}
		else {
			if(!fullMayus) {
				for(int i = 0; i < letras.length; i++) {					
					for(int j = 0; j < letras.length; j++) {	
						if(letras[j] == a) {					
							System.out.println(nombre + " ya tiene esa letra");
							return a;
						}
					}
					if(letras[i] == '\u0000') {						
						letras[i] = a;	
						if(cantActual == 25) {
							gano = true;
						}
						cantActual++;
						cantRestante--;
						System.out.println(nombre + " añadio la letra " + a + " a su grupo y le quedan: " + cantRestante);
						return a;
					}
				}	
			}
			System.out.println("La letra que recibio " + nombre + " no es mayuscula");			
			return '\u0000';
		}
	}	
	private char numeroUno() {
		for(int i = 0; i < letras.length; i++) {
			letras[i] = '\u0000';
		}
		cantActual = 0;
		cantRestante = 25;
		fullMayus=!fullMayus;
		System.out.println("A " + nombre + " le salio el primer comodin, debera comenzar de nuevo con las otras letras");
		return '1';
		}
	private char numeroDos() {
		System.out.println(nombre + " tendra que esperar 10 segundos");
		return '2';		
	}
	private char numeroTres() {
		gano = true;
		fullLetras();
		System.out.println(nombre + " ha conseguido todas las letras");		
		return '3';
	}	
	private void fullLetras() {
		cantActual = 25;
		cantRestante = 0;
	}
}	