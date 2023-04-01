package fp.test;

import fp.FactoriaPartidas;
import fp.Partidas;

public class TestFactoriaPartidas {

	public static void main(String[] args) {
		
		testLeerPartidas("data/MatchTimelinesFirst15(simplificado).csv");
		}
	
		private static void testLeerPartidas(String fichero) {
			System.out.println("\nTestLeerPartidas =============");
			Partidas partidas = FactoriaPartidas.leerPartidas(fichero); 
			System.out.println("   Partidas: "+ partidas);
		}

	

}
