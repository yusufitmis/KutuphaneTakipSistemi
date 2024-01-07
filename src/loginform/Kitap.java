/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package loginform;

/**
 *
 * @author bonur
 */
public class Kitap {
     private int kitapID;
    private String kitapAdi;
    private String yazar;
    private String isbn; 
    private String durum;
    
    public Kitap(int kitapID, String kitapAdi, String yazar, String isbn,String durum) {
        this.kitapID = kitapID;
        this.kitapAdi = kitapAdi;
        this.yazar = yazar;
        this. isbn =  isbn;
        this.durum = "RAFTA";
    }

    /**
     * @return the kitapID
     */
    public int getKitapID() {
        return kitapID;
    }

    /**
     * @param kitapID the kitapID to set
     */
    public void setKitapID(int kitapID) {
        this.kitapID = kitapID;
    }

    /**
     * @return the kitapAdi
     */
    public String getKitapAdi() {
        return kitapAdi;
    }

    /**
     * @param kitapAdi the kitapAdi to set
     */
    public void setKitapAdi(String kitapAdi) {
        this.kitapAdi = kitapAdi;
    }

    /**
     * @return the yazar
     */
    public String getYazar() {
        return yazar;
    }

    /**
     * @param yazar the yazar to set
     */
    public void setYazar(String yazar) {
        this.yazar = yazar;
    }

    /**
     * @return the isbn
     */
    public String getIsbn() {
        return isbn;
    }

    /**
     * @param isbn the isbn to set
     */
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    /**
     * @return the durum
     */
    public String getDurum() {
        return durum;
    }

    /**
     * @param durum the durum to set
     */
    public void setDurum(String durum) {
        this.durum = durum;
    }
    
    
    
}
