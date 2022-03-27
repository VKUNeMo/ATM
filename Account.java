package EndofTerm;

public class Account {
	private String ma_the;
	private int ma_PIN;
	private long tien_du;
	private String chu_tk;
	private String ten_ngan_hang;
	public Account () {
	
	}
	public Account (String ma_the, int ma_PIN, long tien_du, String chu_tk, String ten_ngan_hang) {
		this.ma_the=ma_the;
		this.ma_PIN=ma_PIN;
		this.tien_du=tien_du;
		this.chu_tk=chu_tk;
		this.ten_ngan_hang=ten_ngan_hang;
	}
	public String getMa_the() {
		return ma_the;
	}
	public void setMa_the(String ma_the) {
		this.ma_the = ma_the;
	}
	public int getMa_PIN() {
		return ma_PIN;
	}
	public void setMa_PIN(int ma_PIN) {
		this.ma_PIN = ma_PIN;
	}
	public long getTien_du() {
		return tien_du;
	}
	public void setTien_du(long tien_du) {
		this.tien_du = tien_du;
	}
	public String getChu_tk() {
		return chu_tk;
	}
	public void setChu_tk(String chu_tk) {
		this.chu_tk = chu_tk;
	}
	public String getTen_ngan_hang() {
		return ten_ngan_hang;
	}
	public void setTen_ngan_hang(String ten_ngan_hang) {
		this.ten_ngan_hang = ten_ngan_hang;
	}
	
}
