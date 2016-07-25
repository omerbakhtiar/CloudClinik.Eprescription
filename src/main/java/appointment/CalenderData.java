package appointment;

public class CalenderData {
	private int available;
	private int reserved;
	private int confirmed;
	private int arrived;
	private int notShow;
	private int seen;
	private int urgent;
	private int inclinic;

	public CalenderData(int av, int res, int con, int arr, int notS, int see,
			int ur, int incli) {
		available = av;
		reserved = res;
		confirmed = con;
		arrived = arr;
		notShow = notS;
		seen = see;
		urgent = ur;
		inclinic = incli;

	}

	public int getAvailable() {
		return available;
	}

	public void setAvailable(int available) {
		this.available = available;
	}

	public int getReserved() {
		return reserved;
	}

	public void setReserved(int reserved) {
		this.reserved = reserved;
	}

	public int getConfirmed() {
		return confirmed;
	}

	public void setConfirmed(int confirmed) {
		this.confirmed = confirmed;
	}

	public int getArrived() {
		return arrived;
	}

	public void setArrived(int arrived) {
		this.arrived = arrived;
	}

	public int getNotShow() {
		return notShow;
	}

	public void setNotShow(int notShow) {
		this.notShow = notShow;
	}

	public int getSeen() {
		return seen;
	}

	public void setSeen(int seen) {
		this.seen = seen;
	}

	public int getUrgent() {
		return urgent;
	}

	public void setUrgent(int urgent) {
		this.urgent = urgent;
	}

	public int getInclinic() {
		return inclinic;
	}

	public void setInclinic(int inclinic) {
		this.inclinic = inclinic;
	}

}
