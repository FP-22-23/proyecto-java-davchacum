package common;

import java.util.Objects;

import fp.tipos.Equipo;

import fp.utiles.Checkers;

public record Player(String nombre,Integer rivales_matados,Integer muertes,Integer asistencias,Equipo equipo) {

	//CONSTRUCTOR CON RESTRICCIONES
	
	public Player{
		checkPositivo(rivales_matados);
		checkPositivo(muertes);
		checkPositivo(asistencias);
	}
	//RESTRICCION TODOS LOS VALORES >=0
	private void checkPositivo(Integer valor) {
			
		
		Checkers.check("ERROR VALOR NEGATIVO",valor>=0);
				
	}
	//REPRESENTACION COMO CADENA
	public String toString() {
		return "Player [nombre=" + nombre + ", rivales_matados=" + rivales_matados + ", muertes=" + muertes
				+ ", asistencias=" + asistencias + ", equipo=" + equipo + "]";
	}

	//CRITERIO DE IGUALDAD HASCODE Y EQUALS 
	
	//se considera el mismo jugador si tienen el mismo nombre
	public int hashCode() {
		return Objects.hash(nombre);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Player other = (Player) obj;
		return Objects.equals(nombre, other.nombre);
	}
	
	

}
