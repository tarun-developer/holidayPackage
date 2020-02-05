
import java.io.*;
import java.sql.*;
import java.util.*;

public class DBHandler {

public Connection establishConnection(){
    
    // Fill you code Here
	
			Connection conn = null;
			try {
				FileInputStream f = new FileInputStream("src//db.properties");
				Properties p = new Properties();
				p.load(f);

				Class.forName(p.getProperty("db.classname"));
				conn = DriverManager.getConnection(p.getProperty("db.url"), p.getProperty("db.username"),
						p.getProperty("db.password"));
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}

			return conn;
   
}
}