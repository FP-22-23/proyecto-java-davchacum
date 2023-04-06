package fp.test;

import java.util.List;

import fp.FactoriaPartidas;
import fp.Partida;
import fp.Partidas;

public class TestFactoriaPartidas {

	public static void main(String[] args) {
		
		testLeerPartidas("data/MatchTimelinesFirst15(simplificado).csv");
		}
		private static void testLeerPartidas(String fichero) {
			System.out.println("\nTestLeerPartidas =============");
			List<Partida> partidas = FactoriaPartidas.leerPartidas(fichero); 
			System.out.println("   Partidas: "+ partidas);
		}
		private static void testLeerPartida2(String fichero) {
			System.out.println("\nTestLeerPartidas =============");
			Partidas partidas = FactoriaPartidas.leerPartidas2(fichero); 
			System.out.println("   Partidas: "+ partidas);
		}
		

	

}
