package pinpon;

public class EscribePingPong {

	public synchronized void escribePing() {
		System.out.println("Ping");
	}
	public synchronized void escribePong() {
		System.out.println("Pong");
	}
}
