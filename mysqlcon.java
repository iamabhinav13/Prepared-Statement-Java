import java.util.*;
import java.sql.*;
public class mysqlcon
{
	public static void main(String args[])
	{
		Scanner s=new Scanner(System.in);
	try{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/college","root","mysql");
		Statement stmt=con.createStatement();
		PreparedStatement pst=con.prepareStatement("insert into stud values(?,?)");
		System.out.println("Enter the id:");
		int b=s.nextInt();
		pst.setInt(1,b);
		System.out.println("Enter the name:");
		String a=s.next();
		pst.setString(2,a);
		int i=pst.executeUpdate();
		ResultSet rs=stmt.executeQuery("select * from stud");
		while(rs.next())
		{
			System.out.println(rs.getInt(1)+" "+rs.getString(2));
		}
		con.close();
	}
	catch(Exception e)
	{
		System.out.println(e);
	}
	}
}