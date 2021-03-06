/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Models.Database;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author dicle
 */
public class UyeIslemleri {
    private Connection con = null;
    private Statement statement = null;
    private PreparedStatement preparedStatement = null;
    public boolean girisYap(String kullanici_adi,String parola) {
        
        String sorgu =  "Select * From uyeler where kullaniciadi = ? and parola = ?";        
        try {
            preparedStatement = con.prepareStatement(sorgu);
            
            preparedStatement.setString(1,kullanici_adi);
            preparedStatement.setString(2,parola);
            
            ResultSet rs =  preparedStatement.executeQuery();
            
            return rs.next();
            
        } catch (SQLException ex) {
            Logger.getLogger(UyeIslemleri.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
                     
    }
    public void uyeEkle(String kullaniciadi,String parola,String linkedin,String kayittarihi) {
        
        String sorgu = "Insert Into uyeler (kullaniciadi,parola,linkedIn,kayittarihi) VALUES(?,?,?,?)";
        
        try {
            preparedStatement = con.prepareStatement(sorgu);
          
            preparedStatement.setString(1, kullaniciadi);
            preparedStatement.setString(2, parola);
            preparedStatement.setString(3, linkedin);
            preparedStatement.setString(4, kayittarihi);
            preparedStatement.executeUpdate();                    
        } catch (SQLException ex) {
            Logger.getLogger(UyeIslemleri.class.getName()).log(Level.SEVERE, null, ex);
        }               
    }   
    public UyeIslemleri() {   
        String url = "jdbc:mysql://" + Database.host + ":" + Database.port + "/" + Database.db_ismi+ "?useUnicode=true&characterEncoding=utf8";
 
        try {
            
            Class.forName("com.mysql.cj.jdbc.Driver");
            
        } catch (ClassNotFoundException ex) {
            System.out.println("Driver Bulunamad??....");
        }        
        try {
            con = DriverManager.getConnection(url, Database.kullanici_adi, Database.parola);   
            
        } catch (SQLException ex) {
            System.out.println("Ba??lant?? Ba??ar??s??z...");
            //ex.printStackTrace();
        }             
    }
}
