/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package loginform;

/**
 *
 * @author bonur
 */
public abstract class AbstractPersonelKitapIslemleri {
     public abstract void kitapSil(String isbn);
   
    public abstract void kitapEkle(String isbn, String kitapAdi, String yazar, String durum);

    public abstract void kitapGuncelle(String isbn, String kitapAdi, String yazar, String durum);
    
    
}
