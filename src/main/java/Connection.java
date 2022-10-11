
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
public class Connection {
	
	
	String insertQuery="insert into hclstd value(?,?)";
	String selectQuery="select * from hclstd where Password=? and Username=?";
	String updateQuery="update hclstd set Username=? where Password=? ";
	String deleteQuery="delete from hclstd where Password=?";
	int value=0;
	ResultSet rs=null;
	public int Login(Info i) throws SQLException
	{
		
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			java.sql.Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/sample1","root","vardhan");
			PreparedStatement stmt1=con.prepareStatement(selectQuery);
			stmt1.setString(2, i.getUsername());
			stmt1.setString(1, i.getPassword());
			rs=stmt1.executeQuery();
			if(rs.next())
				return 1;
			else
				return 0;
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return value;
	
		
	}
	
	
	
	public int Register(Info i) throws SQLException
	{
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			java.sql.Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/sample1","root","vardhan");
			PreparedStatement stmt2=con.prepareStatement(selectQuery);
			stmt2.setString(1, i.getPassword());
			stmt2.setString(2, i.getUsername());
			rs=stmt2.executeQuery();
			if(rs.next())
			{
					
				value=0;
			}
			else {
				rs=null;
				PreparedStatement stmt1=con.prepareStatement(insertQuery);
				stmt1.setString(1, i.getUsername());
				stmt1.setString(2, i.getPassword());
				value=stmt1.executeUpdate();
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return value;

	}
	
	public int Update(Info i) throws ClassNotFoundException
	{
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			java.sql.Connection con;
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sample1","root","vardhan");
			PreparedStatement stmt3=con.prepareStatement(updateQuery);
			stmt3.setString(1, i.getUsername());
			stmt3.setString(2, i.getPassword());
			value=stmt3.executeUpdate();
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return value;
	}
	
	public int Delete(Info i)throws ClassNotFoundException
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			java.sql.Connection con;
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sample1","root","vardhan");
			PreparedStatement stmt4=con.prepareStatement(deleteQuery);
			stmt4.setString(1, i.getPassword());
			value=stmt4.executeUpdate();

		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return value;
	}
	
	
	
	
}
