
package Models;

/**
 *
 * @author dicle
 */
public class PersonalInfo {
    private String ad;
    private String soyad;
    private String email;
    private String adres;

    public PersonalInfo(String ad, String soyad, String email, String adres) {
        this.ad = ad;
        this.soyad = soyad;
        this.email = email;
        this.adres = adres;
    }

    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    public String getSoyad() {
        return soyad;
    }

    public void setSoyad(String soyad) {
        this.soyad = soyad;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAdres() {
        return adres;
    }

    public void setAdres(String adres) {
        this.adres = adres;
    }
    
}
