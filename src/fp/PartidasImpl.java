package fp;


import java.time.Month;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.SortedMap;

import java.util.TreeMap;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import fp.tipos.Equipo;
import fp.tipos.Rango;




public class PartidasImpl implements Partidas{
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
	@Override
	public Boolean existePartidaDondeRivalesMatadosDeUnEquipoSupere(Equipo equipo, Integer rivales_matados) {
		//Existe alguna partida donde los rivales matados del equipo introducido que superen los rivales matados dados como parametro
		//todos cumplen prop X?
		/**
		 * 
		 * @param equipo y rivales_matados
		 * @return true si el equipo supera los rivales matados dados como parámetros en al menos un objeto del csv.
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
	@Override
	public Double mediaRivalesMatadosPorEquipoYRango(Rango rango,Equipo equipo ) {
		/**
		 * 
		 * @param equipo y rivales_matados
		 * @return media de los rivales matados dado un rango y un equipo dados como parámetro.
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

	@Override
	public List<Partida> partidasConRangoyGanador(Rango rango,Boolean gana_azul) {
		/**
		 * 
		 * @param equipo y rivales_matados
		 * @return la maxima cantidad de oro que ha obtenido un equipo en un rango dados como parámetro.
		 */	
		List<Partida>res= new ArrayList<Partida>();
		for (Partida p:partidas) {
			if(p.getRango_partida().equals(rango) && p.getGana_azul().equals(gana_azul)) {//filtro por rango
				res.add(p);
		}
						
				
	
		}
		
		return res;
		
	}
	//METODO DE AGRUPACION QUE DEVUELVE UN MAP
	@Override
	public Map<Rango,List<Partida>> agruparPartidasPorRango(){
		/**
		 * 
		 * @return Map en donde la clave es el rango y el valor las partidas de ese rango.
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
	@Override
	public SortedMap<Month,Integer> contarPartidasPorMeses(){
		/**
		 * 
		 * @return SortedMap en donde la clave son los meses y el valor el numero de partidas que se han jugado en ese mes.
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
	// BLOQUE 1
	
	//METODO EXISTE
	//1.A escoger uno de los dos siguientes: existe / para todo (el mismo implementado en la entrega 2, pero con streams).

	@Override
	public Boolean existePartidaDondeRivalesMatadosDeUnEquipoSupere2( Equipo equipo,Integer rivales_matados) {
		return partidas.stream().anyMatch(p -> equipo.equals(Equipo.ROJO) ? p.getRivales_matados_rojo() > rivales_matados: p.getRivales_matados_azul() > rivales_matados);
		
	}
	//METODO MEDIA
	//2. A escoger uno de los tres siguientes: contador/suma/media (el mismo implementado en la entrega 2, pero con streams).

	@Override
	public Double mediaRivalesMatadosPorEquipoYRango2(Rango rango,Equipo equipo ) {

		return partidas.stream().filter(p->p.getRango_partida().equals(rango)).collect(Collectors.averagingInt(equipo.equals(Equipo.ROJO) ? Partida::getRivales_matados_rojo: Partida::getRivales_matados_azul));
//			return partidas.stream().filter(p->p.getRango_partida().equals(rango)).mapToInt(equipo.equals(Equipo.ROJO) ? Partida::getRivales_matados_rojo: Partida::getRivales_matados_azul).average().orElse(0.0);
		
	}
	//3. Una selección con filtrado (la misma implementada en la entrega 2, pero con streams).

	//METODO SELECCION DE FILTRADO
	@Override
	public List<Partida> partidasConRangoyGanador2(Rango rango,Boolean gana_azul) {
		return partidas.stream().filter(p->p.getRango_partida().equals(rango) && p.getGana_azul().equals(gana_azul)).collect(Collectors.toList());
	}
	
	//4. Un máximo con filtrado.

	//Maximo con filtrado
	@Override
	public Partida partidaMayorcantidadOroEquipoPorRango(Rango rango,Equipo equipo) {
		return partidas.stream().filter(p->p.getRango_partida().equals(rango)).max(Comparator.comparingInt(equipo.equals(Equipo.ROJO) ? Partida::getOro_equipo_rojo: Partida::getOro_equipo_azul)).orElse(null);
		
	}
	// 5. Una selección, con filtrado y ordenación.
	public List<Partida> partidasOrdenadasPorFechaenelRango(Rango rango){
		return partidas.stream().filter(p->p.getRango_partida().equals(rango)).sorted(Comparator.comparing(Partida::getFecha_partida)).collect(Collectors.toList());
	}
	//BLOQUE 2
	
	
	//METODO DE ACUMULACION QUE DEVUELVE UN MAP
	// 6.Uno de los métodos (4) o (5) implementados en la entrega 2, pero con streams.

	@Override
	public SortedMap<Month,Integer> contarPartidasPorMeses2(){
		return partidas.stream().collect(Collectors.groupingBy(p->p.getFecha_partida().getMonth(),TreeMap::new,Collectors.collectingAndThen(Collectors.counting(),Long::intValue)));				
	}
	//7.Un método en cuya implementación se use, o bien el Collector collectingAndThen, o bien el Collector mapping.

	@Override
	public Map<Rango,List<Long>>idPartidasDeCadaRango() {
		return partidas.stream().collect(Collectors.groupingBy(Partida::getRango_partida,Collectors.mapping(Partida::getId_partida, Collectors.toList())));
		
	}
	//8.Un método que devuelva un Map en el que las claves sean un atributo o una función sobre un atributo, y los valores son máximos/mínimos de los elementos que tienen ese valor
	@Override
	public Map<Rango,Integer>maxnMasRivalesMatadaosPorRango() {
		return partidas.stream().collect(Collectors.toMap(Partida::getRango_partida,p->p.getRivales_matados_azul()+p.getRivales_matados_rojo(),Integer::max));
	}
	//9.Un método que devuelva un SortedMap en el que las claves sean un atributo o una función sobre un atributo, y los valores sean listas con los n mejores o peores elementos que comparten el valor de ese atributo (o función sobre el atributo).
	@Override
	
//	public SortedMap<Rango,List<Partida>> nPartidasConMasRivalesMatadosPorRango(Integer n){
//		Comparator<Partida> c=Comparator.comparing(p->p.getRivales_matados_azul()+p.getRivales_matados_rojo());
//		SortedMap<Rango,List<Partida>> m= partidas.stream().collect(Collectors.groupingBy(Partida::getRango_partida,TreeMap::new,Collectors.toList()));
//		return m.entrySet().stream().collect(Collectors.toMap(p->p.getKey(), p->p.getValue().stream().sorted(c.reversed()).limit(n).collect(Collectors.toList()),(v1, v2) -> v1,//Eliminamos posibles valores repetidos, si no el codigo da error,para evitar  elementos duplicado escribimos (v1, v2) -> v1 
//				TreeMap::new));
//
//	}
	public SortedMap<Rango,List<Partida>> nPartidasConMasRivalesMatadosPorRango(Integer n){
			return partidas.stream().collect(Collectors.groupingBy(Partida::getRango_partida,TreeMap::new,Collectors.collectingAndThen(Collectors.toList(),
					lista->aux(lista, n))));
		}
	@Override
	public List<Partida> aux(List<Partida> listPartidas,Integer n) {
		Comparator<Partida> c=Comparator.comparing(p->p.getRivales_matados_azul()+p.getRivales_matados_rojo());
		return listPartidas.stream().sorted(c.reversed()).limit(n).collect(Collectors.toList());
	}

	
//	10 .Un método que calcule un Map y devuelva la clave con el valor asociado (mayor o menor) de todo el Map.
	public Rango PartidaConRangoConMasOroTotal(){

		Map<Rango, Integer>aux= partidas.stream().collect(Collectors.toMap(Partida::getRango_partida,p->p.getRivales_matados_azul()+p.getRivales_matados_rojo(),Integer::max));
		return aux.entrySet().stream().max(Map.Entry.comparingByValue(Comparator.reverseOrder())).map(k->k.getKey()).get();
	}













}	

	
	


