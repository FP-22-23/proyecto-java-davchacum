package fp;


import java.util.ArrayList;
import java.util.Collection;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;




public class PartidasImpl implements Partidas {
private List<Partida> Partidas;
	
	public PartidasImpl() {
		Partidas=new ArrayList<Partida>();
		
	}
	public PartidasImpl(Collection<Partida> Partidas) {
		this.Partidas = new ArrayList<Partida>(Partidas);
	}
	public PartidasImpl(Stream<Partida> Partidas) {
		this.Partidas = Partidas.collect(Collectors.toList());
	}
	@Override
	public List<Partida> getPartidas() {
		return Partidas;
	}
	@Override
	public String toString() {
		return "Partidas [Partidas=" + Partidas + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(Partidas);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PartidasImpl other = (PartidasImpl) obj;
		return Objects.equals(Partidas, other.Partidas);
	}

	
	

}
