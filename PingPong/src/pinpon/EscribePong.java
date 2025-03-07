package pinpon;

public class EscribePong extends Thread{

	EscribePingPong EPP = new EscribePingPong();
	
	public EscribePong(EscribePingPong epp) {
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
		this.EPP.escribePong();

	}

}
