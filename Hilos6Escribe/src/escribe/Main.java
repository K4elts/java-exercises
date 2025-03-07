package escribe;

public class Main {

	public static void main(String[] args) {
		
		Almacen almacen = new Almacen();
		
		System.out.println("Lanzando hilos");
		Th123 []th = new Th123[3];
		th[0] = new Th123(almacen,1);
		th[1] = new Th123(almacen,2);
		th[2] = new Th123(almacen,3);
		th[0].start();
		th[1].start();
		th[2].start();
		
		/*
		ThUno uno = new ThUno(almacen);
		ThDos dos = new ThDos(almacen);
		ThTres tres = new ThTres(almacen);
		uno.start();
		dos.start();
		tres.start();
		*/
	}

}
