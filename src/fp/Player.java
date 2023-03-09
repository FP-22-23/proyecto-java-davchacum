package fp;

import fp.tipos.Equipo;

import fp.utiles.Checkers;

public record Player(String nombre,Integer rivales_matados,Integer muertes,Integer asistencias,Equipo equipo) {
	public Player{
		checkPositivo(rivales_matados);
		checkPositivo(muertes);
		checkPositivo(asistencias);
	}
	
	private void checkPositivo(Integer valor) {
			
		
		Checkers.check("ERROR VALOR NEGATIVO",valor>=0);
		
				
			
	}
	

}
