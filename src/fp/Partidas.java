package fp;

import java.util.List;

public interface Partidas {

	List<Partida> getPartidas();

	String toString();

	int hashCode();

	boolean equals(Object obj);
	void añadirPartida(Partida p);

}