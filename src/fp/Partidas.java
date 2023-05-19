package fp;

import java.time.Month;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;

import fp.tipos.Equipo;
import fp.tipos.Rango;

public interface Partidas {

	List<Partida> getPartidas();
 
	String toString();

	int hashCode();

	boolean equals(Object obj);

	//	Obtener el número de elementos.
	Integer getNumeroPartidas();

	//	Añadir un elemento.
	void añadirPartida(Partida p);

	//	Añadir una colección de elementos.
	void añadirCollecionPartida(Collection<Partida> p);

	//	Eliminar un elemento.
	void eliminarPartida(Partida p);

	void eliminarPartida(int n);
	//2 parte de la entrega 2:

	//METODO EXISTE
	Boolean existePartidaDondeRivalesMatadosDeUnEquipoSupere(Equipo equipo, Integer rivales_matados);

	//METODO MEDIA
	Double mediaRivalesMatadosPorEquipoYRango(Rango rango, Equipo equipo);
	//METODO SELECCION DE FILTRADO

	List<Partida> partidasConRangoyGanador(Rango rango, Boolean gana_azul);

	//METODO DE AGRUPACION QUE DEVUELVE UN MAP
	Map<Rango, List<Partida>> agruparPartidasPorRango();

	//METODO DE ACUMULACION QUE DEVUELVE UN MAP
	SortedMap<Month, Integer> contarPartidasPorMeses();
	// BLOQUE 1

	Boolean existePartidaDondeRivalesMatadosDeUnEquipoSupere2(Equipo equipo, Integer rivales_matados);
	//METODO MEDIA
	//2.A escoger uno de los tres siguientes: contador/suma/media (el mismo implementado en la entrega 2, pero con streams).

	Double mediaRivalesMatadosPorEquipoYRango2(Rango rango, Equipo equipo);

	//METODO SELECCION DE FILTRADO
	List<Partida> partidasConRangoyGanador2(Rango rango, Boolean gana_azul);

	//Maximo con filtrado
	Partida partidaMayorcantidadOroEquipoPorRango(Rango rango, Equipo equipo);

	List<Partida> partidasOrdenadasPorFechaenelRango(Rango rango);
	//BLOQUE 2

	SortedMap<Month, Integer> contarPartidasPorMeses2();
	//7.Un método en cuya implementación se use, o bien el Collector collectingAndThen, o bien el Collector mapping.

	Map<Rango, List<Long>> idPartidasDeCadaRango();

	//8.Un método que devuelva un Map en el que las claves sean un atributo o una función sobre un atributo, y los valores son máximos/mínimos de los elementos que tienen ese valor
	Map<Rango, Integer> maxnMasRivalesMatadaosPorRango();

	//9.Un método que devuelva un SortedMap en el que las claves sean un atributo o una función sobre un atributo, y los valores sean listas con los n mejores o peores elementos que comparten el valor de ese atributo (o función sobre el atributo).
	SortedMap<Rango, List<Partida>> nPartidasConMasRivalesMatadosPorRango(Integer n);
	List<Partida> aux(List<Partida> listPartidas, Integer n);
	
	//	10 .Un método que calcule un Map y devuelva la clave con el valor asociado (mayor o menor) de todo el Map.
	Rango PartidaConRangoConMasOroTotal();

	
	
	

}