package EndofTerm; 
import java.sql.*;
import java.util.*;
public class ATM_Control {
	private Connection conn;
	private PreparedStatement ps,ps1;
	private ResultSet rs;
	private Statement ps4;
	private List<Account> account = new ArrayList<>();
	public List<Account> getData()  {
		ConnectDB c= new ConnectDB();
		this.conn= c.getConnect();
		try {
			this.ps=this.conn.prepareStatement("SELECT * FROM Account");
			this.rs=this.ps.executeQuery();
			while(rs.next()) {
				Account a= new Account(rs.getString(1),rs.getInt(2),rs.getLong(3),rs.getString(4),rs.getString(5));
				this.account.add(a);
			}
			return this.account;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return this.account;	
	}
	public String so_du(String ma_the) {
		String sql ="Select tien_du from Account where ma_the="+ma_the;
		try {
			this.ps= this.conn.prepareStatement(sql);
			this.rs=this.ps.executeQuery();
			if(rs.next()) {
				return String.valueOf(rs.getLong("tien_du"));
			}else {
				return null;
			}
		}catch(Exception e) {
			e.printStackTrace();
			
		}
		return null;
	}
	public boolean change_pin(String ma_the, int pin_new)
	{
		int record =0;
		String sql= "Update Account set ma_pin = "+pin_new + "where ma_the="+ma_the;
		try {
			this.ps4= this.conn.createStatement();
			record = this.ps4.executeUpdate(sql);
			if(record > 0) {
				return true;
			}else {
				return false;
			}
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	//chức năng rút tiền
	public boolean RutTien(String ma_the, long money){ 
		long tien_du =Integer.valueOf(so_du(ma_the));
		// tài khoản phải >=50000 mới có thể thực hiện chức năng 
		if ((money +50000) <= tien_du) {
        String sql1 = "UPDATE Account set tien_du=tien_du-" + money + " WHERE ma_the=" + ma_the;
        try {
            this.ps = this.conn.prepareStatement(sql1);
            if(ps.executeUpdate()>0 ){
                return true;
            }else{
                return false;
            }
            
        } catch (Exception e) {
            e.printStackTrace();
          return false;
        }
		}else {
			return false;
		}
    }
	// chức năng chuyển khoản
	public boolean CK(String ma_the1, String ma_the2, long money) {
		long tien_du =Integer.valueOf(so_du(ma_the1));
		// tài khoản phải >=50000 mới có thể thực hiện chức năng 
		if ((money +50000) <= tien_du) {
        String sql1 = "UPDATE Account set tien_du=tien_du-" + money + " WHERE ma_the=" + ma_the1;
        String sql2= "UPDATE Account set tien_du=tien_du+" + money + " WHERE ma_the=" + ma_the2;
        try {
            this.ps = this.conn.prepareStatement(sql1);
            this.ps1 = this.conn.prepareStatement(sql2);
            if(this.ps.executeUpdate()>0 && this.ps1.executeUpdate() >0 ){
                return true;
            }else{
                return false;
            }
            
        } catch (Exception e) {
            e.printStackTrace();
          return false;
        }
		}else {
			return false;
		}
	}
	public List<Account> getAccount() {
		return account;
	}
	public void setAccount(ArrayList<Account> account) {
		this.account = account;
	}
}

	

