import java.util.*;
import java.sql.*;

public class BookDao {
	
//	creating a new connection with the SQL Server
	public static Connection getConnection() {
		Connection con = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library", "root", "");
		}catch(Exception e) {
			System.out.println(e);
		}		
		return con;
	}
	
	 public static int save(Book b){  
	        int status=0;  
	        try{  
	            Connection con=BookDao.getConnection();  
	            PreparedStatement ps=con.prepareStatement(  
	                         "insert into section_e(title, date, availability) values (?,?,?)");  
	            ps.setString(1,b.getTitle());  
	            ps.setString(2,b.getDate());  
	            ps.setString(3,Boolean.toString(b.getAvailability()));  
	            
	            status=ps.executeUpdate();  
	              
	            con.close();  
	        }catch(Exception ex){ex.printStackTrace();}  
	          
	        return status;  
	    } 
	 
	    public static int update(Book b){  
	        int status=0;  
	        try{  
	            Connection con=BookDao.getConnection();  
	            PreparedStatement ps=con.prepareStatement(  
	                         "update section_e set title=?,date=?,availability=? where id=?");  
	            ps.setString(1, b.getTitle());  
	            ps.setString(2, b.getDate());  
	            ps.setString(3, Boolean.toString(b.getAvailability()));  
	            ps.setInt(4, b.getId());  
	              
	            status=ps.executeUpdate();  
	              
	            con.close();  
	        }catch(Exception ex){ex.printStackTrace();}  
	          
	        return status;  
	    }
	
	    public static int delete(int id){  
	        int status=0;  
	        try{  
	            Connection con=BookDao.getConnection();  
	            PreparedStatement ps=con.prepareStatement("delete from section_e where id=?");  
	            ps.setInt(1,id);  
	            status=ps.executeUpdate();  
	              
	            con.close();  
	        }catch(Exception e){e.printStackTrace();}  
	          
	        return status;  
	    }  
	    
	    public static Book getBookById(int id){  
	        Book e = new Book();  
	          
	        try{  
	            Connection con=BookDao.getConnection();  
	            PreparedStatement ps=con.prepareStatement("select * from section_e where id=?");  
	            ps.setInt(1,id);  
	            ResultSet rs=ps.executeQuery();  
	            if(rs.next()){  
	                e.setId(rs.getInt(1));  
	                e.setTitle(rs.getString(2));  
	                e.setDate(rs.getString(3));  
	                e.setAvailability(Boolean.parseBoolean((rs.getString(4))));  
	            }  
	            con.close();  
	        }catch(Exception ex){ex.printStackTrace();}  
	          
	        return e;  
	    } 
	    
	    public static List<Book> getAllBooks(){  
	        List<Book> list=new ArrayList<Book>();  
	          
	        try{  
	            Connection con=BookDao.getConnection();  
	            PreparedStatement ps=con.prepareStatement("select * from section_e");  
	            ResultSet rs=ps.executeQuery();  
	            while(rs.next()){  
	                Book e=new Book();  
	                e.setId(rs.getInt(1));  
	                e.setTitle(rs.getString(2));  
	                e.setDate(rs.getString(3));  
	                e.setAvailability(Boolean.parseBoolean((rs.getString(4))));  
	                list.add(e);  
	            }  
	            con.close();  
	        }catch(Exception e){e.printStackTrace();}  
	          
	        return list;  
	    }  
}
