package fp;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import java.util.List;

import java.util.stream.Stream;

import fp.common.Player;
import fp.tipos.Equipo;
import fp.tipos.Rango;
import fp.utiles.Checkers;



public class FactoriaPartidas {

	public static Partidas leerPartidas(String rutaFichero) {
		
		
		Partidas res=null;
		try {
			Stream<Partida> sv=Files.lines(Paths.get(rutaFichero)).skip(1).map(FactoriaPartidas::parsearPartida);
			res= new PartidasImpl(sv);
		}
		catch(IOException e) {
			System.out.println("No se ha encontrado el fichero"+ rutaFichero);
		}
		return res;
		
	}
	
	public static Partida parsearPartida(String lineaCSV) {
//			Long id_partida,Boolean gana_azul,Integer oro_equipo_azul,
//			Integer rivales_matados_azul,Integer monstruos_matados_azul,
//			Integer oro_equipo_rojo,Integer rivales_matados_rojo,
//			Integer monstruos_matados_rojo,Double media_nivel_azul,
//			Double media_nivel_rojo,LocalDate fecha_partida,
//			Rango rango_partida,Player mejor_jugador,List<String> personajes
		
//			Long id_partida,Boolean gana_azul,Integer oro_equipo_azul,
//			Integer rivales_matados_azul,Integer monstruos_matados_azul,Double media_nivel_azul,
//			Integer oro_equipo_rojo,Integer rivales_matados_rojo,
//			Integer monstruos_matados_rojo,Double media_nivel_rojo,LocalDate fecha_partida,
//			Rango rango_partida,String server,Player mejor_jugador,List<String> personajes
		String[] trozos=lineaCSV.split(";");
		Checkers.check("Error en elementos Partida", trozos.length==19);
		Long id_partida=Long.valueOf(trozos[0].trim());
		Boolean gana_azul=Boolean.valueOf(trozos[1].trim());
		Integer oro_equipo_azul=Integer.valueOf(trozos[2].trim());
		Integer rivales_matados_azul=Integer.valueOf(trozos[3].trim());
		Integer monstruos_matados_azul=Integer.valueOf(trozos[4].trim());
		Double media_nivel_azul=Double.valueOf(trozos[5].trim());
		Integer oro_equipo_rojo=Integer.valueOf(trozos[6].trim());
		Integer rivales_matados_rojo=Integer.valueOf(trozos[7].trim());
		Integer monstruos_matados_rojo=Integer.valueOf(trozos[8].trim());
		Double media_nivel_rojo=Double.valueOf(trozos[9].trim());
		LocalDate fecha_partida=LocalDate.parse(trozos[10].trim(),DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		Rango rango_partida=Rango.valueOf(trozos[11].trim());
		String server=String.valueOf(trozos[12].trim());
		String nombre=String.valueOf(trozos[13].trim());
		Integer rivales_matados=Integer.valueOf(trozos[14].trim());
		Integer muertes=Integer.valueOf(trozos[15].trim());
		Integer asistencias=Integer.valueOf(trozos[16].trim());
		Equipo equipo=Equipo.valueOf(trozos[17].trim());
		Player mejor_jugador= new Player(nombre,rivales_matados,muertes,asistencias,equipo);
		List<String> personajes=parseLista(trozos[18]);
		
		return new Partida(id_partida,gana_azul,oro_equipo_azul,rivales_matados_azul,monstruos_matados_azul,
				media_nivel_azul,oro_equipo_rojo,rivales_matados_rojo,
				monstruos_matados_rojo,media_nivel_rojo,fecha_partida,
				rango_partida,server,mejor_jugador,personajes);
		
		
	}
	public static  List<String> parseLista(String cadena){

		String [] trozos=cadena.split(",");
		List<String> lista=new ArrayList<>();
		for(String t:trozos) {
			lista.add(t.trim());
			
			
		}
		
		return lista;
		
	}
	

}


