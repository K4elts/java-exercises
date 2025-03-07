package saludo;

public class Unsaludo {

	
	public static void main(String[] args) {
		
		//run -> run configuration -> arguments
		if (args.length<1) {
			System.out.println("Se deben introducir parametros");
			System.exit(1);
		}
		for (int i = 0; i < 5; i++) {
			System.out.println((i+1)+" "+args[0]);
		}

		//System.out.println(args[0] + " "+args[1]+" "+args[2]);
		
	}

}
