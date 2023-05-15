package fp.test;

import fp.FactoriaPartidas;
import fp.Partidas;
import fp.tipos.Equipo;
import fp.tipos.Rango;

public class TestPartidasStream {

	public static void main(String[] args) {
Partidas datos = FactoriaPartidas.leerPartidas2("data/MatchTimelinesFirst15(simplificado).csv");
		
		
		System.out.println("###############################################################################################################");
		System.out.println("TEST DE LA FUNCION existePartidaDondeRivalesMatadosDeUnEquipoSupere2\n");
		testExistePartidaDondeRivalesMatadosDeUnEquipoSupere2(datos,Equipo.AZUL, 15);
		testExistePartidaDondeRivalesMatadosDeUnEquipoSupere2(datos,Equipo.ROJO, 39);
		System.out.println("###############################################################################################################");
		System.out.println("TEST DE LA FUNCION mediaRivalesMatadosPorEquipoYRango2 \n");
		testMediaRivalesMatadosPorEquipoYRango2(datos,Rango.DIAMANTE_III,Equipo.AZUL );
		testMediaRivalesMatadosPorEquipoYRango2(datos,Rango.DIAMANTE_I,Equipo.ROJO );
		System.out.println("###############################################################################################################");
		System.out.println("TEST DE LA FUNCION partidasConRangoyGanador2\n");
		testPartidasConRangoyGanador2(datos,Rango.DIAMANTE_III,true );
		testPartidasConRangoyGanador2(datos,Rango.DIAMANTE_IV,false );
		System.out.println("###############################################################################################################");
		System.out.println("TEST DE LA FUNCION PartidaMayorcantidadOroEquipoPorRango \n");
		testPartidaMayorcantidadOroEquipoPorRango(datos,Rango.DIAMANTE_III,Equipo.AZUL );
		testPartidaMayorcantidadOroEquipoPorRango(datos,Rango.DIAMANTE_I,Equipo.ROJO );
		System.out.println("###############################################################################################################");
		System.out.println("TEST DE LA FUNCION PartidasOrdenadasPorFechaenelRango \n");
		testPartidasOrdenadasPorFechaenelRango(datos,Rango.DIAMANTE_III );
		testPartidasOrdenadasPorFechaenelRango(datos,Rango.DIAMANTE_I );
		System.out.println("###############################################################################################################");
		System.out.println("TEST DE LA FUNCION contarPartidasPorMeses\n");
		testContarPartidasPorMeses2(datos);
		
		System.out.println("###############################################################################################################");
		System.out.println("TEST DE LA FUNCION idPartidasDeCadaRango\n");
		testIdPartidasDeCadaRango(datos);
		
		System.out.println("###############################################################################################################");
		System.out.println("TEST DE LA FUNCION maxnMasRivalesMatadaosPorRango\n");
		testMaxnMasRivalesMatadaosPorRango(datos);
		
		System.out.println("###############################################################################################################");
		System.out.println("TEST DE LA FUNCION nPartidasConMasRivalesMatadosPorRango\n");
		testnPartidasConMasRivalesMatadosPorRango(datos,2);
;
		
		System.out.println("###############################################################################################################");
		System.out.println("TEST DE LA FUNCION PartidasConMasOroTotalPorRango\n");
		testPartidasConMasOroTotalPorRango(datos);
		
		
		
	}
	
	//1
	private static void testExistePartidaDondeRivalesMatadosDeUnEquipoSupere2(Partidas datos,Equipo equipo, Integer rivales_matados) {
		try {
			String msg =String.format("Existe una partida en donde el equipo %s supere %s rivales matados: %b",equipo, rivales_matados, datos.existePartidaDondeRivalesMatadosDeUnEquipoSupere2(equipo, rivales_matados));
			System.out.println(msg);
		} catch (Exception e) {
			System.err.println("Capturada excepción inesperada: " + e.getMessage());
		}		
	}
	//2
	private static void testMediaRivalesMatadosPorEquipoYRango2(Partidas datos,Rango rango,Equipo equipo ) {
		try {
			String msg =String.format("La media de rivales matados del equipo %s en las partidas con rango %s es: %f",equipo,rango, datos.mediaRivalesMatadosPorEquipoYRango2(rango,equipo ));
			System.out.println(msg);
		} catch (Exception e) {
			System.err.println("Capturada excepción inesperada: " + e.getMessage());
		}		
	}
	//3
	private static void testPartidasConRangoyGanador2(Partidas datos,Rango rango,Boolean gana_azul) { 
		try {
			String msg =String.format("Las partidas en donde el equipo azul gano es %b en el rango %s son: %s ",gana_azul,rango, datos.partidasConRangoyGanador2(rango, gana_azul));
			System.out.println(msg);
		} catch (Exception e) {
			System.err.println("Capturada excepción inesperada: " + e.getMessage());
		}		
	}
	//4
	private static void testPartidaMayorcantidadOroEquipoPorRango(Partidas datos,Rango rango,Equipo equipo) {
		try {
			String msg =String.format("La partida con mayor cantidad de oro del equipo %s en el rango %s: \n %s ",equipo,rango, datos.partidaMayorcantidadOroEquipoPorRango(rango,equipo));
			System.out.println(msg);
		} catch (Exception e) {
			System.err.println("Capturada excepción inesperada: " + e.getMessage());
		}		
	}
	//5
	private static void testPartidasOrdenadasPorFechaenelRango(Partidas datos,Rango rango) {
		try {
			String msg =String.format("Partidas ordenadas por fecha en el rango %s:\n %s",rango, datos.partidasOrdenadasPorFechaenelRango(rango));
			System.out.println(msg);
		} catch (Exception e) {
			System.err.println("Capturada excepción inesperada: " + e.getMessage());
		}		
	}
	//6
	private static void testContarPartidasPorMeses2(Partidas datos) {
		try {
			String msg =String.format("Cantidad de partidas por meses:\n%s ", datos.contarPartidasPorMeses2());
			System.out.println(msg);
		} catch (Exception e) {
			System.err.println("Capturada excepción inesperada: " + e.getMessage());
		}		
	}
	//7
	private static void testIdPartidasDeCadaRango(Partidas datos) {
		try {
			String msg =String.format("Id de partidas por rango :\n %s ", datos.idPartidasDeCadaRango());
			System.out.println(msg);
		} catch (Exception e) {
			System.err.println("Capturada excepción inesperada: " + e.getMessage());
		}		
	}
	//8
	private static void testMaxnMasRivalesMatadaosPorRango(Partidas datos) {
		try {
			String msg =String.format("Maximo número de rivales matados por rango:\n%s ", datos.maxnMasRivalesMatadaosPorRango());
			System.out.println(msg);
		} catch (Exception e) {
			System.err.println("Capturada excepción inesperada: " + e.getMessage());
		}		
	}
	//9
	private static void testnPartidasConMasRivalesMatadosPorRango(Partidas datos,Integer n) {
		try {
			String msg =String.format("Las %d partidas con mas rivales matados por rango: \n%s ",n, datos.nPartidasConMasRivalesMatadosPorRango(n));
			System.out.println(msg);
		} catch (Exception e) {
			System.err.println("Capturada excepción inesperada: " + e.getMessage());
		}		
	}
	//9
	private static void testPartidasConMasOroTotalPorRango(Partidas datos) {
		try {
			String msg =String.format("La partida con mas oro por rango:\n%s ", datos.PartidasConMasOroTotalPorRango());
			System.out.println(msg);
		} catch (Exception e) {
			System.err.println("Capturada excepción inesperada: " + e.getMessage());
		}		
	}



	}


