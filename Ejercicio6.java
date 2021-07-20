import java.util.Random;

import javax.swing.JOptionPane;

public class Ejercicio6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

				
				Pelicula peli = new Pelicula("Luna", 90, 18, "Jhon");
				Cine cine1 = new Cine (peli, 10);
				
				final int FILA = 8, COL = 9;
				
				// Sala 
				char[][] sala = new char[FILA][COL];
				int fila, col, total = FILA * COL; // total de asientos
				boolean generar;
				String usuario;
				
				// Llenamos la matriz con un caracter 
				llenarMatriz(sala);
				
				// Bucle para ir generando espectadores
				do {
					generar = false; 
					Espectador esp = new Espectador ("Roberto", edadRandom(), dineroRandom());
					
					
					if (esp.compraEntrada(cine1) && (esp.aptoEdad(peli))) {
						boolean puesto = false; 
						while (!puesto) {
							fila = asientoRandom(FILA); 
							col = asientoRandom(COL); 
							if (sala[fila][col] == 'o') { 
								sala[fila][col] = 'X'; 
								System.out.println("Asiento comprado"); 
								puesto = true; 
								total--; 
							}
						}
					}
					
					else {
						
						System.out.println("No puedes entrar:");
						System.out.println("Tu edad " + esp.getEdad() + " --> Edad minima " + peli.getEdadMinima());
						System.out.println("Tu dinero " + esp.getDinero() + " --> Precio del cine "+ cine1.getPrecioEntrada());
					}
					
					
					usuario = JOptionPane.showInputDialog("Generar mas espectadores? (si/no)").toLowerCase(); // Lo pasamos a lowerCase
					
					
					if (usuario.equals("si")) {
						generar = true; 
					}
					
				} while (generar && total != 0); 
				
				
				System.out.println("El cine ha quedado asi:");
				mostrarCine(sala);
				
			}
			
			public static void mostrarCine(char[][] sala) {
				final int CARACTER = 65; 
				int i, j, caracter, max = sala.length;
				for (i = 0; i < sala.length; i++, max--) {
					caracter = CARACTER; 
					for (j = 0; j < sala[i].length; j++, caracter++) {
						System.out.print(max + "" + (char)caracter + "" + sala[i][j] + " ");
					}
					System.out.println();
				}
			}
			
			
			public static int edadRandom () {
				Random rnd = new Random();
				return (int) (rnd.nextDouble()* 80 + 1);		
			}

			public static int dineroRandom () {
				Random rnd = new Random();
				return (int) (rnd.nextDouble()*50 + 1);		
			}
			
			
			public static int asientoRandom (int max) {
				Random rnd = new Random();
				return (int)(rnd.nextDouble() * max);
			}
			
			// iniciar la matriz a un caracter
			public static void llenarMatriz (char[][] sala) {
				int i, j;
				for (i = 0; i < sala.length; i++) {
					for (j = 0; j < sala[i].length; j++) {
						sala[i][j] = 'o';
					}
				}
			}


}
