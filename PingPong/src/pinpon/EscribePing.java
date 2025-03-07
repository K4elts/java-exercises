package pinpon;

public class EscribePing extends Thread{

	EscribePingPong EPP = new EscribePingPong();
	
	public EscribePing(EscribePingPong epp) {
		this.EPP = epp;
	}
	
	@Override
	public void run() {
		try {
			sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.EPP.escribePing();
	}

}
