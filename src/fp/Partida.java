package fp;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

import common.Player;
import fp.tipos.Rango;
import fp.tipos.TipoVictoria;
import fp.utiles.Checkers;

public class Partida implements Comparable <Partida>{
	private Long id_partida;
	private Boolean gana_azul;
	private Integer oro_equipo_azul;
	private Integer rivales_matados_azul;
	private Integer monstruos_matados_azul;
	private Integer oro_equipo_rojo;
	private Integer rivales_matados_rojo;
	private Integer monstruos_matados_rojo;
	private Double media_nivel_azul;
	private Double media_nivel_rojo;
	private LocalDate fecha_partida;
	private Player mejor_jugador;
	private Rango rango_partida;
	private List<String> personajes;
	

	public Partida(Long id_partida,Boolean gana_azul,Integer oro_equipo_azul,
			Integer rivales_matados_azul,Integer monstruos_matados_azul,
			Integer oro_equipo_rojo,Integer rivales_matados_rojo,
			Integer monstruos_matados_rojo,Double media_nivel_azul,
			Double media_nivel_rojo,LocalDate fecha_partida,
			Rango rango_partida,Player mejor_jugador,List<String> personajes) {
		
		checkId_partida(id_partida);
		checkMonstruos_matados(monstruos_matados_azul,monstruos_matados_rojo);
		checkAsesinato_player_partida(rivales_matados_azul,rivales_matados_rojo,mejor_jugador);
		checkFecha(fecha_partida);
		checkMedia_nivel(media_nivel_azul);
		checkMedia_nivel(media_nivel_rojo);

		this.id_partida=id_partida;
		this.gana_azul=gana_azul;
		this.oro_equipo_azul=oro_equipo_azul;
		this.rivales_matados_azul=rivales_matados_azul;
		this.monstruos_matados_azul=monstruos_matados_azul;
		this.oro_equipo_rojo=oro_equipo_rojo;
		this.rivales_matados_rojo=rivales_matados_rojo;
		this.monstruos_matados_rojo=monstruos_matados_rojo;
		this.media_nivel_azul=media_nivel_azul;
		this.media_nivel_rojo=media_nivel_rojo;
		this.fecha_partida=fecha_partida;
		this.rango_partida=rango_partida;
		this.mejor_jugador=mejor_jugador;
		this.personajes=new LinkedList<String>();
		
		
	}
	
	public Partida(Long id_partida,Boolean gana_azul,Integer oro_equipo_azul,Integer rivales_matados_azul,
			Integer oro_equipo_rojo,Integer rivales_matados_rojo,LocalDate fecha_partida,Rango rango_partida) {
		
		checkId_partida(id_partida);
		checkMonstruos_matados(monstruos_matados_azul,monstruos_matados_rojo);
		checkAsesinato_player_partida(rivales_matados_azul,rivales_matados_rojo,mejor_jugador);
		checkFecha(fecha_partida);
		checkMedia_nivel(media_nivel_azul);
		checkMedia_nivel(media_nivel_rojo);
		this.id_partida=id_partida;
		this.gana_azul=gana_azul;
		this.oro_equipo_azul=oro_equipo_azul;
		this.rivales_matados_azul=rivales_matados_azul;
		this.monstruos_matados_azul=null;
		this.oro_equipo_rojo=oro_equipo_rojo;
		this.rivales_matados_rojo=rivales_matados_rojo;
		this.monstruos_matados_rojo=null;
		this.media_nivel_azul=null;
		this.media_nivel_rojo=null;
		this.fecha_partida=fecha_partida;
		this.rango_partida=rango_partida;
		this.mejor_jugador=null;
		this.personajes=null;
		
		
	}
	public Partida(Long id_partida,Boolean gana_azul,LocalDate fecha_partida,Rango rango_partida) {
		checkId_partida(id_partida);
		checkMonstruos_matados(monstruos_matados_azul,monstruos_matados_rojo);
		checkAsesinato_player_partida(rivales_matados_azul,rivales_matados_rojo,mejor_jugador);
		checkFecha(fecha_partida);
		checkMedia_nivel(media_nivel_azul);
		checkMedia_nivel(media_nivel_rojo);
		this.id_partida=id_partida;
		this.gana_azul=gana_azul;
		this.oro_equipo_azul=null;
		this.rivales_matados_azul=null;
		this.monstruos_matados_azul=null;
		this.oro_equipo_rojo=null;
		this.rivales_matados_rojo=null;
		this.monstruos_matados_rojo=null;
		this.media_nivel_azul=null;
		this.media_nivel_rojo=null;
		this.fecha_partida=fecha_partida;
		this.rango_partida=rango_partida;
		this.mejor_jugador=null;
		this.personajes=null;
			
	}
	private void checkId_partida(Long id_partida) {
		
		Checkers.check("ID PARTIDA INCORRECTA INCORRECTA",(id_partida>=3300000000L && id_partida<3600000000L));		
		}
	private void checkMedia_nivel(Double media_nivel) {
		if(media_nivel!=null) {
			Checkers.check("MEDIA NIVEL INCORRECTA",(media_nivel>=0.0 && media_nivel<18.0));		
		}
		
	}
	
	private void checkMonstruos_matados(Integer monstruos_matados_azul,Integer monstruos_matados_rojo) {
		if(!(monstruos_matados_azul==null || monstruos_matados_rojo==null)) {
			Checkers.check("TOTAL DE MONSTRUOS INCORRECTO",(monstruos_matados_azul+monstruos_matados_rojo<=3 && monstruos_matados_azul+monstruos_matados_rojo>=0));
		}
	}
	
	private void checkFecha(LocalDate fecha_partida) {
		
		Checkers.check("FECHA INCORRECTA",(fecha_partida.isAfter(LocalDate.of(2020, 1, 1)) && fecha_partida.isBefore(LocalDate.of(2020, 12, 31))));
	}
	
	private void checkAsesinato_player_partida(Integer rivales_matados_azul,Integer rivales_matados_rojo,Player mejor_jugador) {
		
		if(!(mejor_jugador==null)){
			switch(mejor_jugador.equipo()) {
				case AZUL:
					Checkers.check("VALOR INCORRECTO ENTRE LA PARTIDA Y EL JUGADOR EN LOS RIVALES MATADOS O ASISTENCIAS(EQUIPO AZUL)",mejor_jugador.rivales_matados()+mejor_jugador.asistencias()<=rivales_matados_azul);
					break;
				case ROJO:
					Checkers.check("VALOR INCORRECTO ENTRE LA PARTIDA Y EL JUGADOR EN LOS RIVALES MATADOS  O ASISTENCIAS(EQUIPO ROJO)",mejor_jugador.rivales_matados()+mejor_jugador.asistencias()<=rivales_matados_rojo);
					break;
			}
		}
	}
	public Long getId_partida() {
		return id_partida;
	}

	public void setId_partida(Long id_partida) {
		checkId_partida(getId_partida());

		this.id_partida = id_partida;
	}

	public Boolean getGana_azul() {
		return gana_azul;
	}

	public void setGana_azul(Boolean gana_azul) {
		this.gana_azul = gana_azul;
	}

	public Integer getOro_equipo_azul() {
		return oro_equipo_azul;
	}

	public void setOro_equipo_azul(Integer oro_equipo_azul) {
		this.oro_equipo_azul = oro_equipo_azul;
	}

	public Integer getRivales_matados_azul() {
		return rivales_matados_azul;
	}

	public void setRivales_matados_azul(Integer rivales_matados_azul) {
		checkAsesinato_player_partida(rivales_matados_azul,getRivales_matados_rojo(),getMejor_jugador());
		this.rivales_matados_azul = rivales_matados_azul;
	}

	public Integer getMonstruos_matados_azul() {
		return monstruos_matados_azul;
	}

	public void setMonstruos_matados_azul(Integer monstruos_matados_azul) {
		checkMonstruos_matados(monstruos_matados_azul,getMonstruos_matados_rojo());
		this.monstruos_matados_azul = monstruos_matados_azul;
	}

	public Integer getOro_equipo_rojo() {
		return oro_equipo_rojo;
	}

	public void setOro_equipo_rojo(Integer oro_equipo_rojo) {
		this.oro_equipo_rojo = oro_equipo_rojo;
	}

	public Integer getRivales_matados_rojo() {
		return rivales_matados_rojo;
	}

	public void setRivales_matados_rojo(Integer rivales_matados_rojo) {
		checkAsesinato_player_partida(getRivales_matados_azul(),rivales_matados_rojo,getMejor_jugador());

		this.rivales_matados_rojo = rivales_matados_rojo;
	}

	public Integer getMonstruos_matados_rojo() {
		return monstruos_matados_rojo;
	}

	public void setMonstruos_matados_rojo(Integer monstruos_matados_rojo) {
		checkMonstruos_matados(getMonstruos_matados_azul(),monstruos_matados_rojo);

		this.monstruos_matados_rojo = monstruos_matados_rojo;
	}

	public Double getMedia_nivel_azul() {
		return media_nivel_azul;
	}

	public void setMedia_nivel_azul(Double media_nivel_azul) {
		this.media_nivel_azul = media_nivel_azul;
	}

	public Double getMedia_nivel_rojo() {
		return media_nivel_rojo;
	}

	public void setMedia_nivel_rojo(Double media_nivel_rojo) {
		this.media_nivel_rojo = media_nivel_rojo;
	}

	public LocalDate getFecha_partida() {
		return fecha_partida;
	}

	public void setFecha_partida(LocalDate fecha_partida) {
		checkFecha(getFecha_partida());
		this.fecha_partida = fecha_partida;
	}
	public Rango getRango_partida() {
		return rango_partida;
	}
	public void setRango_partida(Rango rango_partida) {
		this.rango_partida = rango_partida;
	}
	
	public Player getMejor_jugador() {
		return mejor_jugador;
	}

	public void setMejor_jugador(Player mejor_jugador) {
		this.mejor_jugador = mejor_jugador;
	}
	public List<String> getPersonajes() {
		return personajes;
	}
	public void setPersonajes(List<String> personajes) {
		this.personajes = personajes;
	}
	public String getEquipo_ganador() {
		String res="ROJO";
		if(gana_azul==true) {
			res="AZUL";	
		}
		return res;
		
	}
	public TipoVictoria getTipoVictoria() {
		//	REMONTADA,IGUALADA,MUCHA_VENTAJA,VENTAJA_ACEPTABLE;
		TipoVictoria res=TipoVictoria.NO_DATA;
		if(oro_equipo_azul==null || oro_equipo_rojo==null) {
			res=TipoVictoria.NO_DATA;
		}
		else if(gana_azul==true) {
			res=parseaTipoVictoria(getOro_equipo_azul(),getOro_equipo_rojo());
		}
		else if(gana_azul==false) {
			res=parseaTipoVictoria(getOro_equipo_rojo(),getOro_equipo_azul());
		}
		return res;
	}
	
	public TipoVictoria parseaTipoVictoria(Integer oro_equipo_ganador,Integer oro_equipo_perdedor) {
		
		
		//La diff entre el equipo ganador y el perdedor tiene que ser
		//mayor que -2000 y menor que 2000 para ser considerada una victoria igualada
		
		TipoVictoria res=TipoVictoria.IGUALADA;
		
		
		if(oro_equipo_ganador-oro_equipo_perdedor>5000) {
			
			//La diff entre el equipo ganador y el perdedor tiene que ser
			//mayor que 5000 para ser considerada una victoria con mucha ventaja
			
			res=TipoVictoria.MUCHA_VENTAJA;
			
		}else if(oro_equipo_ganador-oro_equipo_perdedor>2000) {
			
			//La diff entre el equipo ganador y el perdedor tiene que ser
			//mayor que 2000 y menor que 5000 para ser considerada una victoria con ventaja aceptable
			
			res=TipoVictoria.VENTAJA_ACEPTABLE;
		}
		else if(oro_equipo_ganador-oro_equipo_perdedor<-2000) {
			
			//La diff entre el equipo ganador y el perdedor tiene que ser
			//menor que -2000 para ser considerada una victoria en la que se ha producido una remontada
			//del equipo rival significando que iban perdiendo pero han logrado ganar la partida
			
			res=TipoVictoria.REMONTADA;
		}
		return res;
	}
	public String toString() {
		return "Partida [id_partida=" + getId_partida() + ", gana_azul=" + getGana_azul() + ", oro_equipo_azul="
				+ getOro_equipo_azul() + ", rivales_matados_azul=" + getRivales_matados_azul() + ", monstruos_matados_azul="
				+ getMonstruos_matados_azul() + ", oro_equipo_rojo=" + getOro_equipo_rojo() + ", rivales_matados_rojo="
				+ getRivales_matados_rojo() + ", monstruos_matados_rojo=" + getMonstruos_matados_rojo() + ", media_nivel_azul="
				+ getMedia_nivel_azul() + ", media_nivel_rojo=" + getMedia_nivel_rojo() + ", fecha_partida=" + getFecha_partida()
				+ ", rango_partida"+getRango_partida()+", mejor_jugador=" + getMejor_jugador() +", personajes="+getPersonajes()+"]";
	}

	public int hashCode() {
		return Objects.hash(gana_azul, fecha_partida);
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Partida other = (Partida) obj;
		return Objects.equals(fecha_partida, other.fecha_partida) && rango_partida == other.rango_partida;
	}

	public int compareTo(Partida p) {
		int res=getFecha_partida().compareTo(p.getFecha_partida());
		if(res==0) {
			res=getId_partida().compareTo(p.getId_partida());
			
		}
		return res;
		
	}
	
	
	

}
