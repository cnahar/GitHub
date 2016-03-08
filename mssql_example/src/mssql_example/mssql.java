package mssql_example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class mssql
{
	public void getSize(ResultSet rs){
		int size = 0;
		try {
		    rs.last();
		    size = rs.getRow();
		    rs.beforeFirst();
		}
		catch(Exception ex) {
		    System.out.println(ex);;
		}
		System.out.println(size);
	}
	
	
	public void dbConnect(String db_connect_string)
   {
      try {
         Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
         Connection conn = DriverManager.getConnection(db_connect_string);
         System.out.println("connected");
         Statement statement = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, 
        		    ResultSet.CONCUR_READ_ONLY);
         String queryString = "select * from amos.part_reliability_data WHERE partno = '92410-15800-114'";
         ResultSet rs = statement.executeQuery(queryString);
         System.out.println(rs.first());
         getSize(rs);
         while (rs.next()) {
            System.out.println(rs.getString(1));
         }
      } catch (Exception e) {
         e.printStackTrace();
      }
   }

   public static void main(String[] args)
   {
      mssql connServer = new mssql();
      connServer.dbConnect("jdbc:sqlserver://NADCBISQL1;databaseName=CHCODS;integratedSecurity=true");
   }
}
	
