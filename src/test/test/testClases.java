package test;

import static org.junit.Assert.assertEquals;

import org.junit.*;

import main.*;
import test.*;

public class testClases {
	
	
	@Test
	public void tests() {
		
		Juridica juridica = new Juridica();
	
	
		Base base = new Base();
		
		juridica.addBase(base);
		
		
		
		Singleton.instance().ingresarEntero(1000);
		

		
		 assertEquals( Singleton.instance().getEntero() , 1000 );
		
		 
		 
		 

	}

}
