package pinpon;

public class Main {

	public static void main(String[] args) {
		
		EscribePingPong escribePingPong = new EscribePingPong();
		Thread thPing = new Thread(new EscribePing(escribePingPong));
		Thread thPong = new Thread(new EscribePong(escribePingPong));
		thPong.start();
		thPing.start();
	}

}
