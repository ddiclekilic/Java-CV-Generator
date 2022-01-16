
package Models;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author dicle
 */
public class CVIslemleri {
    private Connection con = null;
    private Statement statement = null;
    private PreparedStatement preparedStatement = null;
    
    public void kisiselBilgiEkle(String kullaniciadi,String ad, String soyad, String email, String adres){
         String sorgu = "Insert Into kisiselbilgiler (kullaniciadi, ad, soyad, email, adres) VALUES(?,?,?,?,?)";       
        
            try {
            preparedStatement = con.prepareStatement(sorgu);
            preparedStatement.setString(1, kullaniciadi);
            preparedStatement.setString(2, ad);
            preparedStatement.setString(3, soyad);  
            preparedStatement.setString(4, email);
            preparedStatement.setString(5, adres);
            preparedStatement.executeUpdate();                    
        } catch (SQLException ex) {
            Logger.getLogger(CVIslemleri.class.getName()).log(Level.SEVERE, null, ex);
        }  
    }
    public void egitimEkle(String kullaniciAdi,String universite,String bolumu,String fakultesi, double ortalama, String derecesi){
         String sorgu = "Insert Into egitimler (kullaniciadi,universite, bolum,fakulte, gpa, derece) VALUES(?,?,?,?,?,?)";       
        
            try {
            preparedStatement = con.prepareStatement(sorgu);
          
            preparedStatement.setString(1, kullaniciAdi);
            preparedStatement.setString(2, universite);
            preparedStatement.setString(3, bolumu);
            preparedStatement.setString(4, fakultesi);
            preparedStatement.setDouble(5, ortalama);  
            preparedStatement.setString(6, derecesi);
            preparedStatement.executeUpdate();                    
        } catch (SQLException ex) {
            Logger.getLogger(CVIslemleri.class.getName()).log(Level.SEVERE, null, ex);
        }  
    }
    public void deneyimEkle(String kullaniciAdi, String firmasi,String pozisyonu,String aciklama){
         String sorgu = "Insert Into deneyimler (kullaniciadi,firma, pozisyon, aciklama) VALUES(?,?,?,?)";       
        
            try {
            preparedStatement = con.prepareStatement(sorgu);
          
            preparedStatement.setString(1, kullaniciAdi);
            preparedStatement.setString(2, firmasi);
            preparedStatement.setString(3, pozisyonu);
            preparedStatement.setString(4, aciklama);
            preparedStatement.executeUpdate();                    
        } catch (SQLException ex) {
            Logger.getLogger(CVIslemleri.class.getName()).log(Level.SEVERE, null, ex);
        }  
    }
       
    
        public CVIslemleri() {
        
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
