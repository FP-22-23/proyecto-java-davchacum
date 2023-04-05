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

	Boolean existePartidaDondeRivalesMatadosDeUnEquipoSupere(Equipo equipo, Integer rivales_matados);

	Integer cantidadOroEquipoConMasOroPorRango(Rango rango, Equipo equipo);

	Map<Rango, List<Partida>> agruparPartidasPorRango();

	SortedMap<Month,Integer> contarPartidasPorMeses();

	

	Double mediaRivalesMatadosPorEquipoYRango(Rango rango, Equipo equipo);

}