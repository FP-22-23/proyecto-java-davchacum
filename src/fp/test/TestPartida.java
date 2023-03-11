package fp.test;

import java.time.LocalDate;
import java.util.List;

import fp.tipos.Equipo;
import fp.tipos.Rango;
import fp.Partida;
import fp.common.Player;


public class TestPartida {

	public static void main(String[] args) {
		System.out.println("Test Constructores:\n");
		
		Partida Prueba1=new Partida(3500000001L,true, LocalDate.of(2020, 2, 2),Rango.DIAMANTE_IV,"Europa");
		System.out.println(Prueba1);
		Partida Prueba2=new Partida(3500000002L, false, 21000, 15, 15000, 15, LocalDate.of(2020, 2, 2),Rango.DIAMANTE_IV,"Europa");
		System.out.println(Prueba2);
		Player Player1=new Player("sahsajhn", 14, 0, 1, Equipo.AZUL);
		Partida Prueba3=new Partida(3500000003L, true, 22000, 15, 3, 9.2, 15000, 15, 0, 9.0, LocalDate.of(2020, 2, 2),Rango.DIAMANTE_III,"Europa",Player1,List.of("Kalista","Jhin"));
		System.out.println(Prueba3);
		
		//Igual que la primera clase partida
		Partida Prueba4=new Partida(3500000001L,true, LocalDate.of(2020, 2, 2),Rango.DIAMANTE_IV,"Europa");
		
		Partida Prueba_VentajaAceptable=new Partida(3500000004L, false, 16000, 15, 15000, 15, LocalDate.of(2020, 2, 2),Rango.DIAMANTE_IV,"Europa");
		Partida Prueba_Igualada=new Partida(3500000005L, true, 18000, 15, 15000, 15, LocalDate.of(2020, 2, 2),Rango.DIAMANTE_IV,"Europa");

		
		
		System.out.println("\n\nTest propiedades derivadas 1 y 2:\n");
		
		System.out.println("La partida con id "+Prueba1.getId_partida()+" fue de tipo "+Prueba1.getTipoVictoria()+", ganada por parte del equipo "+Prueba1.getEquipo_ganador());
		System.out.println("La partida con id "+Prueba2.getId_partida()+" fue de tipo "+Prueba2.getTipoVictoria()+", ganada por parte del equipo "+Prueba2.getEquipo_ganador());
		System.out.println("La partida con id "+Prueba3.getId_partida()+" fue de tipo "+Prueba3.getTipoVictoria()+", ganada por parte del equipo "+Prueba3.getEquipo_ganador());
		System.out.println("La partida con id "+Prueba_VentajaAceptable.getId_partida()+" fue de tipo "+Prueba_VentajaAceptable.getTipoVictoria()+", ganada por parte del equipo "+Prueba_VentajaAceptable.getEquipo_ganador());
		System.out.println("La partida con id "+Prueba_Igualada.getId_partida()+" fue de tipo "+Prueba_Igualada.getTipoVictoria()+", ganada por parte del equipo "+Prueba_Igualada.getEquipo_ganador());
		
		
		System.out.println("\n\nTest criterio igualdad:");
		
		
		System.out.println("\nComparación de las Partidas Prueba1 y Prueba2:");
		parseEquals(Prueba1,Prueba2);
		
		System.out.println("\nComparación de las Partidas Prueba1 y Prueba3:");
		parseEquals(Prueba1,Prueba3);
		
		System.out.println("\nComparación de las Partidas Prueba1 y Prueba4:");
		parseEquals(Prueba1,Prueba4);

		
		System.out.println("\n\nTest criterio de orden natural:");
		
		
		System.out.println("\nLa primera clase es Prueba1 y la segunda clase es Prueba2:");
		parseCompareTo(Prueba1,Prueba2);
		
		System.out.println("\nLa primera clase es Prueba2 y la segunda clase es Prueba1:");
		parseCompareTo(Prueba2,Prueba1);
		
		System.out.println("\nLa primera clase es Prueba1 y la segunda clase es Prueba4:");
		parseCompareTo(Prueba1,Prueba4);
		
		

	}
	private static void parseCompareTo(Partida p1,Partida p2) {
		
		int res=p1.compareTo(p2);
		if(res==0) {
			System.out.println("La primera clase y la segunda clase son iguales.");
			
		}else if(res>0) {
			System.out.println("La primera clase ocurrió después que la segunda clase Partida.");
			
		}else if(res<0) {
			System.out.println("La primera clase ocurrió antes que la segunda clase Partida.");
			
		}
	}
	private static void parseEquals(Partida p1,Partida p2) {
		if(p1.equals(p2)) {
			System.out.println("En las partidas estuvieron las mismas personas");	
		}else {
			System.out.println("En las partidas estuvieron distintas personas");
		}
		
	
		
	}
	

}
