/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package consultorio;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MyConnection {
  private static Connection connection=null;
  public static Connection getConnection(){
      if(connection==null){
          try{
          connection= (Connection) DriverManager.getConnection("jdbc:mysql://localhost/consultorio","root","AL@ifal");
      } catch(SQLException e){
          e.printStackTrace();
      }
  }
      return connection;
}
}
