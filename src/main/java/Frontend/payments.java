package Frontend;

public class payments {
	int meterId;
	int amount;
	
	
	public int getMeterId() {
		return meterId;
	}

	public void setMeterId(int meterId) {
		this.meterId = meterId;
	}



	public void setAmount(int amount) {
		this.amount = amount;
	}

	public int getAmount() {
		return amount;
	}

	public payments(int meterId, int amount) {
		super();
		this.meterId = meterId;
		this.amount = amount;
	
	}

}