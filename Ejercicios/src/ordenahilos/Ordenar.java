package ordenahilos;

public class Ordenar {

static void ordenar(int []v) {
		
		int aux;
		boolean ordenado = false;
		
		for (int i = 0; i < v.length-1 && !ordenado; i++) {
			ordenado = true;
			for (int j = 0; j < v.length-1; j++) {
				if(v[j]>v[j+1]) {
					ordenado = false;
					aux = v[j];
					v[j] = v[j+1];
					v[j+1] = aux;
				}
			}
		}
	}
	
}
