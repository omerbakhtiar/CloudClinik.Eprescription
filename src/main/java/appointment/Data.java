package appointment;

public class Data {

	private int emptySlots;
	private int seen;
	private int didNotAttend;
	private int total;

	public Data(int dt, int temp, int bpt, int pul) {
		emptySlots = dt;
		seen = temp;
		didNotAttend = bpt;
		total = pul;

	}

	public Data() {
		// TODO Auto-generated constructor stub
	}

	public int getEmptySlots() {
		return emptySlots;
	}

	public void setEmptySlots(int emptySlots) {
		this.emptySlots = emptySlots;
	}

	public int getSeen() {
		return seen;
	}

	public void setSeen(int seen) {
		this.seen = seen;
	}

	public int getDidNotAttend() {
		return didNotAttend;
	}

	public void setDidNotAttend(int didNotAttend) {
		this.didNotAttend = didNotAttend;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

}
