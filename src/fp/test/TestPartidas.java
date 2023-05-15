package fp.test;

import fp.FactoriaPartidas;
import fp.Partidas;
import fp.tipos.Equipo;
import fp.tipos.Rango;

public class TestPartidas {
	public static void main(String[] args) {
		
		Partidas datos = FactoriaPartidas.leerPartidas2("data/MatchTimelinesFirst15(simplificado).csv");
		
		
		System.out.println("###############################################################################################################");
		System.out.println("TEST DE LA FUNCION existePartidaDondeRivalesMatadosDeUnEquipoSupere\n");
		testExistePartidaDondeRivalesMatadosDeUnEquipoSupere(datos,Equipo.AZUL, 15);
		testExistePartidaDondeRivalesMatadosDeUnEquipoSupere(datos,Equipo.ROJO, 39);
		System.out.println("###############################################################################################################");
		System.out.println("TEST DE LA FUNCION mediaRivalesMatadosPorEquipoYRango \n");
		testMediaRivalesMatadosPorEquipoYRango(datos,Rango.DIAMANTE_III,Equipo.AZUL );
		testMediaRivalesMatadosPorEquipoYRango(datos,Rango.DIAMANTE_I,Equipo.ROJO );
		System.out.println("###############################################################################################################");
		System.out.println("TEST DE LA FUNCION partidasConRangoyGanador\n");
		testPartidasConRangoyGanador(datos,Rango.DIAMANTE_III,true );
		testPartidasConRangoyGanador(datos,Rango.DIAMANTE_IV,false );
		System.out.println("###############################################################################################################");
		System.out.println("TEST DE LA FUNCION agruparPartidasPorRango \n");
		testAgruparPartidasPorRango(datos);
		System.out.println("###############################################################################################################");
		System.out.println("TEST DE LA FUNCION contarPartidasPorMeses\n");
		testContarPartidasPorMeses(datos);
		
	}
	
	
	private static void testExistePartidaDondeRivalesMatadosDeUnEquipoSupere(Partidas datos,Equipo equipo, Integer rivales_matados) {
		try {
			String msg =String.format("Existe una partida en donde el equipo %s supere %s rivales matados: %b",equipo, rivales_matados, datos.existePartidaDondeRivalesMatadosDeUnEquipoSupere(equipo, rivales_matados));
			System.out.println(msg);
		} catch (Exception e) {
			System.err.println("Capturada excepción inesperada: " + e.getMessage());
		}		
	}
	private static void testMediaRivalesMatadosPorEquipoYRango(Partidas datos,Rango rango,Equipo equipo ) {
		try {
			String msg =String.format("La media de rivales matados del equipo %s en las partidas con rango %s es: %f",equipo,rango, datos.mediaRivalesMatadosPorEquipoYRango(rango,equipo ));
			System.out.println(msg);
		} catch (Exception e) {
			System.err.println("Capturada excepción inesperada: " + e.getMessage());
		}		
	}
	private static void testPartidasConRangoyGanador(Partidas datos,Rango rango,Boolean gana_azul) { 
		try {
			String msg =String.format("Las partidas en donde el equipo azul gano es %b en el rango %s son: %s ",gana_azul,rango, datos.partidasConRangoyGanador(rango, gana_azul));
			System.out.println(msg);
		} catch (Exception e) {
			System.err.println("Capturada excepción inesperada: " + e.getMessage());
		}		
	}
	private static void testAgruparPartidasPorRango(Partidas datos) {
		try {
			String msg =String.format("Las partidas por rango son:\n%s ", datos.agruparPartidasPorRango());
			System.out.println(msg);
		} catch (Exception e) {
			System.err.println("Capturada excepción inesperada: " + e.getMessage());
		}		
	}
	private static void testContarPartidasPorMeses(Partidas datos) {
		try {
			String msg =String.format("Cantidad de partidas por meses:\n%s ", datos.contarPartidasPorMeses());
			System.out.println(msg);
		} catch (Exception e) {
			System.err.println("Capturada excepción inesperada: " + e.getMessage());
		}		
	}

}
