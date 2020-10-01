package portmanage;
import java.io.*;
import java.sql.*;
public class portmanage {
   Connection con;
   
   public portmanage() {
	   String Driver="";
	   String
	   url="jdbc:mysql://127.0.0.1:3306/madang";
	   String userid="madang";
	   String pwd="madang";
	   try {
		   Class.forName("com.mysql.cj.jdbc.Driver");
		   System.out.println("드라이버로드성공");
	   }catch (ClassNotFoundException e) {
		   e.printStackTrace();
	   }
      try {
    	  System.out.println("데이터베이스 연결 준비");
    	  con=DriverManager.getConnection(url,userid,pwd);
    	  System.out.println("데이터베이스 연결 성공");
      }catch(SQLException e) {
    	  e.printStackTrace();
      }
   }
   void sqlRun(){
	   String query="SELECT * FROM control_standard;";
	   try {
		   Statement stmt=con.createStatement();
		   ResultSet rs=stmt.executeQuery(query);
		   
		   System.out.println("total_ctr_no \ttotal_ctr");
		   while(rs.next()) {
			   System.out.print("\t+rs.getint(1)");
			   System.out.print("\t+rs.getString(2)");
			   System.out.print("\t\t+rs.getString(3)");
			   System.out.println("\t+rs.getInt(4)");
		   }
		   
	   con.close();
	   }catch(SQLException e) {
		   e.printStackTrace();
	   }
	   
   }
    
	/*public static void main(String args[]) {
		  portmanage so=new portmanage();
		  so.sqlRun();
	  
}*/
}
