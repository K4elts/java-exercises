package ordenar;

import java.util.*;

public class Main {

	public static void main(String[] args) {

		Set<Integer> n = new HashSet<Integer>();
		
		n.add(6);
		n.add(3);
		n.add(1);
		n.add(88);
		
		Iterator<Integer> iterador = n.iterator();
		while (iterador.hasNext()) {
			System.out.println(iterador.next());
		}
		
	}

}
