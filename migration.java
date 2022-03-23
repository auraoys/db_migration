import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Migration {
	
	Connection Oracon = null;
	Connection Mycon = null;
	
	PreparedStatement Opstmt = null;
	ResultSet Ors = null;
	
	PreparedStatement Mpstmt = null;
	ResultSet Mrs = null;
	
	
	public Connection getOraCon() throws Exception {
		
		
		
		Connection con = null;
		String dburl = "##";
		String dbid = "##";
		String dbpw = "##";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

			con = DriverManager.getConnection(dburl, dbid, dbpw);	
			System.out.println("Connect Oracon!");

		} catch (Exception ie) {
			System.out.println("Database connection error : " + ie.getMessage());
			throw ie;
		}
		return con;

	}

	public boolean closeOraCon(Connection con) {
		

		try {
			if (con != null) {
				con.close();
				con = null;
				System.out.println("Disconnect Oracon!");
			}
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	///////////////////////////////// Second connection

	public Connection getMyCon() throws Exception {
		Connection con = null;
		String dburl = null;
		String dbid = null;
		String dbpw = null;

		try {
			Class.forName("###");
			try {
				dburl = "jdbc:mysql://#;
				dbid = "##";
				dbpw = "##";
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			con = DriverManager.getConnection(dburl, dbid, dbpw);
			System.out.println("Connect Myacon!");
		} catch (Exception ie) {
			System.out.println("Database connection error : " + ie.getMessage());
			throw ie;
		}
		return con;

	}

	public boolean closeMyCon(Connection con) {

		try {
			if (con != null) {
				con.close();
				con = null;
				System.out.println("Disconnect Mycon!");
			}
		} catch (Exception e) {
			return false;
		}
		return true;
	}
	
	public void CustomerMig() {
		
		System.out.println("Customer Migration Start...");
		
		String sql = "select * from ## order by register_dt desc";
		String sql2 = "insert into ## value (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		
		try {
			Oracon = getOraCon();				
			Opstmt = Oracon.prepareStatement(sql, Ors.TYPE_SCROLL_INSENSITIVE, Ors.CONCUR_UPDATABLE);
			Ors = Opstmt.executeQuery();
			
			Mycon = getMyCon();				
			Mpstmt = Mycon.prepareStatement(sql2, Mrs.TYPE_SCROLL_INSENSITIVE, Mrs.CONCUR_UPDATABLE);
			int r = 0;
			int seq = 1;
						
			while(Ors.next()) {
				System.out.println(seq++ + " ===>" + Ors.getString("ACTIVE_YN") + " = " + Ors.getString("MAIL_ADDRESS") + " = " + Ors.getString("SERVICE_CD1") + " = " + Ors.getString("SERVICE_CD2") + " = " + Ors.getString("SERVICE_CD3") + " = " + Ors.getString("SERVICE_CD4") + " = " + Ors.getString("PERMISSION_EMAIL_YN") + " = " + Ors.getString("CUSTOMER_TYPE_CD") + " = " + Ors.getString("PERMISSION_SMS_YN") + " = " + Ors.getString("SPECIAL_CARE_YN") + " = " + Ors.getString("CUSTOMER_NM") + " = " + Ors.getString("MAIN_CUSTOMER_REGIDENT_ID4") + " = " + Ors.getString("MAIN_CUSTOMER_ID") + " = " + Ors.getString("WEDDING_DT") + " = " + Ors.getString("RELATION_NM") + " = " + Ors.getString("WEDDING_DT_CD") + " = " + Ors.getString("COMPANY_ADDRESS_DTL4") + " = " + Ors.getString("COMPANY_ADDRESS") + " = " + Ors.getString("COMPANY_ZIP") + " = " + Ors.getString("EMAIL") + " = " + Ors.getString("REPRE_CELLPHONE") + " = " + Ors.getString("CELLPHONE4") + " = " + Ors.getString("FAX_NO") + " = " + Ors.getString("COMPANY_PHONE") + " = " + Ors.getString("HOME_PHONE") + " = " + Ors.getString("JOB_CD") + " = " + Ors.getString("USER_PW4") + " = " + Ors.getString("BIRTH_DT") + " = " + Ors.getString("CUSTOMER_GRADE") + " = " + Ors.getString("REGIDENT_ID4") + " = " + Ors.getString("USER_ID") + " = " + Ors.getString("CUSTOMER_ID") + " = " + Ors.getString("REMARKS") + " = " + Ors.getString("BIRTH_DT_CD") + " = " + Ors.getString("COMPANY_NM") + " = " + Ors.getString("HOME_ZIP") + " = " + Ors.getString("HOME_ADDRESS") + " = " + Ors.getString("HOME_ADDRESS_DTL4") + " = " + Ors.getString("PERMISSION_MAIL_YN") + " = " + Ors.getString("ROOT_ACCOUNT_NO") + " = " + Ors.getString("SECESSION_CD") + " = " + Ors.getString("RECOMMEND_NM") + " = " + Ors.getString("RECOMMENT_REGIDENT_NO4") + " = " + Ors.getString("GROUP_CD") + " = " + Ors.getString("CONTACT_CD") + " = " + Ors.getString("CONTACT_DTL") + " = " + Ors.getString("PM_NO") + " = " + Ors.getString("REGISTER_DT") + " = " + Ors.getString("REGISTER_ID") + " = " + Ors.getString("FORUM_YN") + " = " + Ors.getString("KOSCOM_CUSTOMER_ID") + " = " + Ors.getString("REASON") + " = " + Ors.getString("UPDATE_DT") + " = " + Ors.getString("GUBUN") + " = " + Ors.getString("NEWS_YN") + " = " + Ors.getString("HOME_ADDRESS_DTL") + " = " + Ors.getString("CELLPHONE") + " = " + Ors.getString("USER_PW") + " = " + Ors.getString("REGIDENT_ID") + " = " + Ors.getString("MAIN_CUSTOMER_REGIDENT_ID") + " = " + Ors.getString("RECOMMENT_REGIDENT_NO") + " = " + Ors.getString("COMPANY_ADDRESS_DTL") + " = " + Ors.getString("ITALK_YN") + " = " + Ors.getString("SERVICE_CD6") + " = " + Ors.getString("CONFIRM1") + " = " + Ors.getString("CONFIRM2") + " = " + Ors.getString("CONFIRM3") + " = " + Ors.getString("CONFIRM4") + " = " + Ors.getString("CONFIRM5") + " = " + Ors.getString("CONFIRM6") + " = " + Ors.getString("AGREE_UPDATE") + " = " + Ors.getString("CHECK_CNT") + " = " + Ors.getString("WEBLOGIN_DT") + " = " + Ors.getString("BIRTH") + " = " + Ors.getString("DISCRHASH") + " = " + Ors.getString("CIVERSION") + " = " + Ors.getString("CISCRHASH") + " = " + Ors.getString("JOIN_GB") + " = " + Ors.getString("DEL_DT") + " = " + Ors.getString("PERMISSION_EMAIL_DATE") + " = " + Ors.getString("PERMISSION_SMS_DATE") + " = " + Ors.getString("NEWS_YN_DATE"));
//				Mpstmt.setString(1, Ors.getString("ACTIVE_YN"));
				
				Mpstmt.setString(1  , Ors.getString("
Mpstmt.setString(2  , Ors.getString("
Mpstmt.setString(3  , Ors.getString("
Mpstmt.setString(4  , Ors.getString("
Mpstmt.setString(5  , Ors.getString("
Mpstmt.setString(6  , Ors.getString("
Mpstmt.setString(7  , Ors.getString("
Mpstmt.setString(8  , Ors.getString("
Mpstmt.setString(9  , Ors.getString("
Mpstmt.setString(10  , Ors.getString(
Mpstmt.setString(11  , Ors.getString(
Mpstmt.setString(12  , Ors.getString(
Mpstmt.setString(13  , Ors.getString(
Mpstmt.setString(14  , Ors.getString(
Mpstmt.setString(15  , Ors.getString(
Mpstmt.setString(16  , Ors.getString(
Mpstmt.setString(17  , Ors.getString(
Mpstmt.setString(18  , Ors.getString(
Mpstmt.setString(19  , Ors.getString(
Mpstmt.setString(20  , Ors.getString(
Mpstmt.setString(21  , Ors.getString(
Mpstmt.setString(22  , Ors.getString(
Mpstmt.setString(23  , Ors.getString(
Mpstmt.setString(24  , Ors.getString(
Mpstmt.setString(25  , Ors.getString(
Mpstmt.setString(26  , Ors.getString(
Mpstmt.setString(27  , Ors.getString(
Mpstmt.setString(28  , Ors.getString(
Mpstmt.setString(29  , Ors.getString(
Mpstmt.setString(30  , Ors.getString(
Mpstmt.setString(31  , Ors.getString(
Mpstmt.setString(32  , Ors.getString(
Mpstmt.setString(33  , Ors.getString(
Mpstmt.setString(34  , Ors.getString(
Mpstmt.setString(35  , Ors.getString(
Mpstmt.setString(36  , Ors.getString(
Mpstmt.setString(37  , Ors.getString(
Mpstmt.setString(38  , Ors.getString(
Mpstmt.setString(39  , Ors.getString(
Mpstmt.setString(40  , Ors.getString(
Mpstmt.setString(41  , Ors.getString(
Mpstmt.setString(42  , Ors.getString(
Mpstmt.setString(43  , Ors.getString(
Mpstmt.setString(44  , Ors.getString(
Mpstmt.setString(45  , Ors.getString(
Mpstmt.setString(46  , Ors.getString(
Mpstmt.setString(47  , Ors.getString(
Mpstmt.setString(48  , Ors.getString(
Mpstmt.setString(49  , Ors.getString(
Mpstmt.setString(50  , Ors.getString(
Mpstmt.setString(51  , Ors.getString(
Mpstmt.setString(52  , Ors.getString(
Mpstmt.setString(53  , Ors.getString(
Mpstmt.setString(54  , Ors.getString(
Mpstmt.setString(55  , Ors.getString(
Mpstmt.setString(56  , Ors.getString(
Mpstmt.setString(57  , Ors.getString(
Mpstmt.setString(58  , Ors.getString(
Mpstmt.setString(59  , Ors.getString(
Mpstmt.setString(60  , Ors.getString(
Mpstmt.setString(61  , Ors.getString(
Mpstmt.setString(62  , Ors.getString(
Mpstmt.setString(63  , Ors.getString(
Mpstmt.setString(64  , Ors.getString(
Mpstmt.setString(65  , Ors.getString(
Mpstmt.setString(66  , Ors.getString(
Mpstmt.setString(67  , Ors.getString(
Mpstmt.setString(68  , Ors.getString(
Mpstmt.setString(69  , Ors.getString(
Mpstmt.setString(70  , Ors.getString(
Mpstmt.setString(71  , Ors.getString(
Mpstmt.setString(72  , Ors.getString(
Mpstmt.setString(73  , Ors.getString(
Mpstmt.setString(74  , Ors.getString(
Mpstmt.setString(75  , Ors.getString(
Mpstmt.setString(76  , Ors.getString(
Mpstmt.setString(77  , Ors.getString(
Mpstmt.setString(78  , Ors.getString(
Mpstmt.setString(79  , Ors.getString(
Mpstmt.setString(80  , Ors.getString(
Mpstmt.setString(81  , Ors.getString(
Mpstmt.setString(82  , Ors.getString(
				
				r = Mpstmt.executeUpdate();			

			}					
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeOraCon(Oracon);
			closeMyCon(Mycon);
		}
		
		System.out.println("Customer Migration Done Succesfully...");
	}
	
public void CounsellMig() {
	
		System.out.println("Counselling Migration Start...");
		
		String sql = "select ##T from ##order by register_dt desc";
		String sql2 = "insert into ##  value (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		
		try {
			Oracon = getOraCon();				
			Opstmt = Oracon.prepareStatement(sql, Ors.TYPE_SCROLL_INSENSITIVE, Ors.CONCUR_UPDATABLE);
			Ors = Opstmt.executeQuery();
			
			Mycon = getMyCon();				
			Mpstmt = Mycon.prepareStatement(sql2, Mrs.TYPE_SCROLL_INSENSITIVE, Mrs.CONCUR_UPDATABLE);
			int r = 0;
			int seq = 1;
						
			while(Ors.next()) {
									
				Mpstmt.setString( 1 , Ors.getString(
Mpstmt.setString( 2 , Ors.getString(
Mpstmt.setString( 3 , Ors.getString(
Mpstmt.setString( 4 , Ors.getString(
Mpstmt.setString( 5 , Ors.getString(
Mpstmt.setString( 6 , "migration" );
Mpstmt.setString( 7 , Ors.getString(
Mpstmt.setString( 8 , Ors.getString(
Mpstmt.setString( 9 , Ors.getString(
Mpstmt.setString( 10 , Ors.getString
Mpstmt.setString( 11 , Ors.getString
Mpstmt.setString( 12 , Ors.getString
Mpstmt.setString( 13 , Ors.getString
Mpstmt.setString( 14 , Ors.getString
Mpstmt.setString( 15 , Ors.getString
Mpstmt.setString( 16 , Ors.getString
Mpstmt.setString( 17 , Ors.getString
Mpstmt.setString( 18 , Ors.getString
Mpstmt.setString( 19 , Ors.getString
Mpstmt.setString( 20 , Ors.getString
Mpstmt.setString( 21 , Ors.getString
Mpstmt.setString( 22 , Ors.getString
Mpstmt.setString( 23 , Ors.getString
Mpstmt.setString( 24 , Ors.getString
Mpstmt.setString( 25 , Ors.getString
Mpstmt.setString( 26 , Ors.getString
Mpstmt.setString( 27 , Ors.getString
Mpstmt.setString( 28 , Ors.getString
Mpstmt.setString( 29 , Ors.getString
Mpstmt.setString( 30 , Ors.getString
Mpstmt.setString( 31 , Ors.getString
Mpstmt.setString( 32 , Ors.getString
Mpstmt.setString( 33 , Ors.getString
Mpstmt.setString( 34 , Ors.getString
Mpstmt.setString( 35 , Ors.getString
Mpstmt.setString( 36 , Ors.getString
Mpstmt.setString( 37 , Ors.getString
Mpstmt.setString( 38 , Ors.getString
				
				r = Mpstmt.executeUpdate();			

			}					
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeOraCon(Oracon);
			closeMyCon(Mycon);
		}	
		
		System.out.println("Counselling Migration Done Succesfully...");
	}

public void Counselling_Cate_Mig() {
	
	System.out.println("Counselling_Cate Migration Start...");
	
	String sql = "select * from a# order by COUNSEL_DT desc, COUNSEL_SEQ desc";
	String sql2 = "insert into # value (?,?,?,?,?,?,?)";
	
	try {
		Oracon = getOraCon();				
		Opstmt = Oracon.prepareStatement(sql, Ors.TYPE_SCROLL_INSENSITIVE, Ors.CONCUR_UPDATABLE);
		Ors = Opstmt.executeQuery();
		
		Mycon = getMyCon();				
		Mpstmt = Mycon.prepareStatement(sql2, Mrs.TYPE_SCROLL_INSENSITIVE, Mrs.CONCUR_UPDATABLE);
		int r = 0;
		int seq = 1;
					
		while(Ors.next()) {
			Mpstmt.setString(1, Ors.getString("#"));
			
			Mpstmt.setString(1  , Ors.getString("#") );
			Mpstmt.setString(2  , Ors.getString("#") );
			Mpstmt.setString(3  , Ors.getString("#") );
			Mpstmt.setString(4  , Ors.getString("#") );
			Mpstmt.setString(5  , Ors.getString("#") );
			Mpstmt.setString(6  , Ors.getString("#") );
			Mpstmt.setString(7  , Ors.getString("#") );			
			
			r = Mpstmt.executeUpdate();			

		}					
		
	} catch (Exception e) {
		e.printStackTrace();
	} finally {
		closeOraCon(Oracon);
		closeMyCon(Mycon);
	}
	
	System.out.println("Counselling_cate Migration Done Succesfully...");
}

	public static void main(String[] args) {
		
		System.out.println("Let's Go");			
		
		
		Migration o = new Migration();
		
//		o.CustomerMig();
//		o.CounsellMig();
		
		o.Counselling_Cate_Mig();
		
		
		
		System.out.println("Done");
		
	}
}