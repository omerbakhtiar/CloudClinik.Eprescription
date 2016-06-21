package prescription;

public class VitalData {
	
	private String date;
	private String temprature;
	private String bp;
	private String pulse;
	private String rr;
	private String height;
	private String weight;
	private String bmi;
	private String notes;
	private String BSL;
	
	public VitalData(String dt,String temp,String bpt,String pul,String r,String he,String wei,String bm,String not,String bsl){
		date=dt;
		temprature=temp;
		bp=bpt;
		pulse=pul;
		rr=r;
		height=he;
		weight=wei;
		bmi=bm;
	    notes=not;
	    BSL=bsl;
	}
	
	public VitalData() {
		// TODO Auto-generated constructor stub
	}


	public String getDate(){
		return date;
	}
	public void setDate(String dat){
		date= dat;
	}
	
	public String getTemprature(){
		return temprature;
	}
	
	public void setTemprature(String temp){
		temprature=temp;
	}
	
	public String getbpt(){
		return bp;
	}
	
	public void setBpt(String bpt){
		bp=bpt;
	}
	
	public String getPulse(){
		return pulse;
	}
	
	public String getRR(){
		return rr;
	}
	
	public String getHeight(){
		return height;
	}
	
	public String getNotes(){
		return notes;
	}
	
	public  String getWeight(){
		return weight;
	}
     
	public String getBMI(){
		return bmi;
	}
	
	public String getBSL(){
		return BSL;
	}
}
