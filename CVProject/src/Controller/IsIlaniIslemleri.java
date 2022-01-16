/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Models.Basvurular;
import Models.Database;
import Models.IFunctions;
import Models.IsIlani;
import View.AdminEkrani;
import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author dicle
 */
public class IsIlaniIslemleri implements IFunctions{
    private Connection con = null;
    private Statement statement = null;
    private PreparedStatement preparedStatement = null;
    
    public ArrayList<IsIlani> isIlaniGetir() {
        
        ArrayList<IsIlani> cikti = new ArrayList<IsIlani>();
        
        try {
            statement =  con.createStatement();
            String sorgu =  "Select * From isilanlari";
            
            ResultSet rs =  statement.executeQuery(sorgu);
            
            while(rs.next()) {
                int id = rs.getInt("id");
                String departman = rs.getString("departman");
                String pozisyon = rs.getString("pozisyon");
                String konum  = rs.getString("konum");
                
                cikti.add(new IsIlani(id, departman, pozisyon, konum));
                
                
            }
            return cikti;
                        
        } catch (SQLException ex) {
            Logger.getLogger(IsIlaniIslemleri.class.getName()).log(Level.SEVERE, null, ex);
            return null;
            
        }                
    }
    public void isIlaniGuncelle(IsIlani isIlani) {
        String sorgu =  "Update isilanlari set departman = ? , pozisyon = ? , konum = ? where id = ?";
        
        try {
            preparedStatement = con.prepareStatement(sorgu);         
            preparedStatement.setString(1,isIlani.getDepartman());
            preparedStatement.setString(2,isIlani.getPozisyon());           
            preparedStatement.setString(3,isIlani.getKonum());            
            preparedStatement.setInt(4, isIlani.getId());           
            preparedStatement.executeUpdate();
                     
        } catch (SQLException ex) {
            Logger.getLogger(IsIlaniIslemleri.class.getName()).log(Level.SEVERE, null, ex);
        }           
    }
    public void isIlaniSil(int id) {
        
        String sorgu = "Delete from isilanlari where id = ?";
        
        try {
            preparedStatement = con.prepareStatement(sorgu);
            preparedStatement.setInt(1, id);
            
            preparedStatement.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(IsIlaniIslemleri.class.getName()).log(Level.SEVERE, null, ex);
        }
                 
    }
    public void profilGoruntule(String linkedin){
        String web=linkedin;
        Desktop d=Desktop.getDesktop();
        try {
            d.browse(new URI(web));
        } catch (URISyntaxException ex) {
            Logger.getLogger(IsIlaniIslemleri.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(IsIlaniIslemleri.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void isIlaniEkle(String departman,String pozisyon,String konum) {
        
        String sorgu = "Insert Into isilanlari (departman,pozisyon,konum) VALUES(?,?,?)";
        
        try {
            preparedStatement = con.prepareStatement(sorgu);
          
            preparedStatement.setString(1, departman);
            preparedStatement.setString(2, pozisyon);
            preparedStatement.setString(3, konum);         
            preparedStatement.executeUpdate();                    
        } catch (SQLException ex) {
            Logger.getLogger(IsIlaniIslemleri.class.getName()).log(Level.SEVERE, null, ex);
        }               
    }
    public void basvuruEkle(String kullaniciadi,int idisilani){
         String sorgu = "Insert Into basvurular (kullaniciadi,idisilani) VALUES(?,?)";       
        
            try {
            preparedStatement = con.prepareStatement(sorgu);
          
            preparedStatement.setString(1, kullaniciadi);
            preparedStatement.setInt(2, idisilani);        
            preparedStatement.executeUpdate();                    
        } catch (SQLException ex) {
            Logger.getLogger(IsIlaniIslemleri.class.getName()).log(Level.SEVERE, null, ex);
        }  
    }
    public ArrayList<Basvurular> basvuruGetir(){
                ArrayList<Basvurular> cikti = new ArrayList<Basvurular>();

        try {
            statement =  con.createStatement();
            String sorgu =  "select u.id, u.kullaniciadi, i.id, i.departman, i.pozisyon, u.linkedin  from uyeler as u, isilanlari as i, basvurular as b where u.kullaniciadi = b.kullaniciadi and i.id = b.idisilani";
            
            ResultSet rs =  statement.executeQuery(sorgu);
            
            while(rs.next()) {
                int id = rs.getInt("u.id");
                String kullaniciAdi = rs.getString("u.kullaniciadi");
                int idIsIlani = rs.getInt("i.id");         
                String departman=rs.getString("i.departman");
                String pozisyon=rs.getString("i.pozisyon");
                String linkedin=rs.getString("u.linkedin");
                cikti.add(new Basvurular(id, kullaniciAdi, idIsIlani, departman, pozisyon, linkedin));                
            }
            return cikti;
                        
        } catch (SQLException ex) {
            Logger.getLogger(IsIlaniIslemleri.class.getName()).log(Level.SEVERE, null, ex);
            return null;
            
        }  
    }
    public IsIlaniIslemleri() {
        
        String url = "jdbc:mysql://" + Database.host + ":" + Database.port + "/" + Database.db_ismi+ "?useUnicode=true&characterEncoding=utf8";
 
        try {
            
            Class.forName("com.mysql.cj.jdbc.Driver");
            
        } catch (ClassNotFoundException ex) {
            System.out.println("Driver Bulunamadı....");
        }        
        try {
            con = DriverManager.getConnection(url, Database.kullanici_adi, Database.parola);
            System.out.println("Bağlantı Başarılı...");       
            
        } catch (SQLException ex) {
            System.out.println("Bağlantı Başarısız...");
            //ex.printStackTrace();
        }             
    }

}
