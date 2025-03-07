package sincroHilosCorredores;

public class ThCorredor extends Thread{

	
	int idHilo;
	Almacen almacen;
	public  ThCorredor(int idhilo,Almacen al) {
		this.idHilo= idhilo;
		this.almacen = al;
	
	}
	@Override
	public void run() {
		for(int i=0;i<10000000;i++);
		this.almacen.llegada(this.idHilo);
	}
}
