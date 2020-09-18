package main;

public class Singleton {
	
	int nume;
	
   private static final Singleton INSTANCE = new Singleton();

	   public  static Singleton instance() {
		   
		   return INSTANCE;
		   
	   }
		  
	  
	   // hacemos el constructor privado, para que nadie más lo puede llamar
	   private Singleton() {
		   
		this.nume=100;  
		   
	   }
	   
	   public void ingresarEntero(int d){
		   
		   this.nume=d;	   
		   
	   }
	   
	   public int getEntero(){
		   
		   return this.nume;  
		   
		   String f;
		   
		   StringUtils gg;
		   
		   gg.
		   
	   }
	   
	   
	   
		


}
