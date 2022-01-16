/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

/**
 *
 * @author dicle
 */
public class Basvurular {
    private int id;
    private String kullaniciAdi;
    private int idIsIlani;
    private String departman;
    private String pozisyon;
    private String linkedIn;

    public String getDepartman() {
        return departman;
    }

    public void setDepartman(String departman) {
        this.departman = departman;
    }

    public String getPozisyon() {
        return pozisyon;
    }

    public void setPozisyon(String pozisyon) {
        this.pozisyon = pozisyon;
    }

    public Basvurular(int id, String kullaniciAdi, int idIsIlani, String departman, String pozisyon, String linkedIn) {
        this.id = id;
        this.kullaniciAdi = kullaniciAdi;
        this.idIsIlani = idIsIlani;
        this.departman = departman;
        this.pozisyon = pozisyon;
        this.linkedIn = linkedIn;
    }

    public String getLinkedIn() {
        return linkedIn;
    }

    public void setLinkedIn(String linkedIn) {
        this.linkedIn = linkedIn;
    }


    public Basvurular(int id, String kullaniciAdi, int idIsIlani) {
        this.id = id;
        this.kullaniciAdi = kullaniciAdi;
        this.idIsIlani = idIsIlani;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getKullaniciAdi() {
        return kullaniciAdi;
    }

    public void setKullaniciAdi(String kullaniciAdi) {
        this.kullaniciAdi = kullaniciAdi;
    }

    public int getIdIsIlani() {
        return idIsIlani;
    }

    public void setIdIsIlani(int idIsIlani) {
        this.idIsIlani = idIsIlani;
    }

}
