package java;

import java.util.ArrayList;
import java.util.List;

public class Juridica extends Entidad {
	
	
	List<Base> bases = new ArrayList<Base>();
	
	public Juridica() {

		this.tipoEntidad = TipoEntidad.JURIDICA;
		
	}
	
	public void addBase(Base base){
		
		bases.add(base);
		
	}
	

}
