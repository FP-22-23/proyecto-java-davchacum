package fp;


import java.time.Month;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.SortedMap;

import java.util.TreeMap;

import java.util.stream.Collectors;
import java.util.stream.Stream;
import fp.tipos.Equipo;
import fp.tipos.Rango;




public class PartidasImpl implements Partidas {
private List<Partida> partidas;
	
	public PartidasImpl() {
		this.partidas=new ArrayList<Partida>();
		
	}
	public PartidasImpl(Collection<Partida> Partidas) {
		this.partidas = new ArrayList<Partida>(Partidas);
	}
	public PartidasImpl(Stream<Partida> Partidas) {
		this.partidas = Partidas.collect(Collectors.toList());
	}
	@Override
	public List<Partida> getPartidas() {
		return partidas;
	}
	@Override
	public String toString() {
		return "Partidas [Partidas=" + partidas + ",NºPartidas ="+getNumeroPartidas()+"]";
	}
	
	
	
	@Override
	public int hashCode() {
		return Objects.hash(partidas);
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
		return Objects.equals(partidas, other.partidas);
	}
//	Obtener el número de elementos.
	@Override
	public Integer getNumeroPartidas() {
		return partidas.size();		
	}
//	Añadir un elemento.
	@Override
	public  void añadirPartida(Partida p){
		partidas.add(p);
		
	}
//	Añadir una colección de elementos.
	@Override
	public  void añadirCollecionPartida(Collection<Partida> p){
		partidas.addAll(p);
		
	}
//	Eliminar un elemento.
	@Override
	public  void eliminarPartida(Partida p){
		partidas.remove(p);
		
	}
	@Override
	public  void eliminarPartida(int n) {
		partidas.remove(n);
		
	}
	//2 parte de la entrega 2:
	
	
	//METODO EXISTE
	public Boolean existePartidaDondeRivalesMatadosDeUnEquipoSupere(Equipo equipo, Integer rivales_matados) {
		//Existe alguna partida donde los rivales matados del equipo introducido que superen los rivales matados dados como parametro
		//todos cumplen prop X?
		/**
		 * 
		 * @param equipo y rivales_matados
		 * @return true si el equipo supere los rivales matados en al menos un objeto del csv.
		 */
		Boolean res=false;
		for (Partida p:partidas) {
			if(p.getRivales_matados_azul()>=rivales_matados || p.getRivales_matados_rojo()>=rivales_matados ) {//propiedad
				res=true;
				break;
			}
		}
		return res;
	}
	//METODO MEDIA
	public Double mediaRivalesMatadosPorEquipoYRango(Rango rango,Equipo equipo ) {
		/**
		 * 
		 * @param equipo y rivales_matados
		 * @return media de los rivales matados dado un rango y un equipo.
		 */
		Double cont=0.0;
		Double suma=0.0;
		Double res=0.0;
		switch (equipo) {
		case AZUL:
			for (Partida p:partidas) {
				if(p.getRango_partida().equals(rango)) {//filtro por rango
					cont++;
					suma+=p.getRivales_matados_azul();
				}
			}
			
			break;
		case ROJO:
			for (Partida p:partidas) {
				if(p.getRango_partida().equals(rango)) {//filtro por rango
					cont++;
					suma+=p.getRivales_matados_rojo();
				}
			}
			
			break;
		}
		if (cont!=0.0) {
			res=suma/cont;
		}
		
		return res;
		
	}
	//METODO SELECCION DE FILTRADO
	public Integer cantidadOroEquipoConMasOroPorRango(Rango rango,Equipo equipo) {
		/**
		 * 
		 * @param equipo y rivales_matados
		 * @return la maxima cantidad de oro que ha obtenido en equipo en un rango.
		 */		
		Partida res=null;
		Integer valor=null;
		switch (equipo) {
		case AZUL:
			for (Partida p:partidas) {
				if(p.getRango_partida().equals(rango)) {//filtro por rango
					if(res==null || (p.getOro_equipo_azul().compareTo(res.getOro_equipo_azul())>0)) {
						res=p;
						}
				}
			}
			valor=res.getOro_equipo_azul();
			break;
		case ROJO:
			for (Partida p:partidas) {
				if(p.getRango_partida().equals(rango)) {//filtro por rango
					if(res==null || (p.getOro_equipo_rojo().compareTo(res.getOro_equipo_rojo())>0)) {
						res=p;
						}
				}
			}
			valor=res.getOro_equipo_rojo();
			break;
	
		}
		
		return valor;
		
	}
	//METODO MAP QUE TIENE DE VALOR UN LIST DE LA PROPIEDAD DE TIPO BASE
	public Map<Rango,List<Partida>> agruparPartidasPorRango(){
		/**
		 * 
		 * @return devuelve un Map en donde la clave es el rango y el valos las partidas de ese rango.
		 */
		Map<Rango,List<Partida>> res=new HashMap<>();
		for(Partida p:partidas) {
			Rango clave=p.getRango_partida();
			if(res.containsKey(clave)) {
				List<Partida> valor=res.get(clave);
				valor.add(p);
				res.put(clave, valor);
				
			}else {
				List<Partida> valor=new ArrayList<>();
				valor.add(p);
				res.put(clave, valor);
			}
		}
		return res;
		
	}
	//METODO DE ACUMULACION QUE DEVUELVE UN MAP
	public SortedMap<Month,Integer> contarPartidasPorMeses(){
		/**
		 * 
		 * @return devuelve un SortedMap en donde la clave son los meses y el valor el numero de partidas que se han jugado en ese mes.
		 */
		
		SortedMap<Month,Integer> res=new TreeMap<>();
		for (Partida p:partidas) {
			Month clave=p.getFecha_partida().getMonth();
			if(res.containsKey(clave)) {
				
				res.put(clave,res.get(clave) + 1 );
				
			}else {
				
				res.put(clave,1);
			}
		}
		
		return res;
		
			
	}
	
}

	
	


