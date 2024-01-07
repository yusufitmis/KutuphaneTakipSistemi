/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package loginform;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author bonur
 */
public class OgretimUyesiFactory implements KullaniciFactory {
    @Override
    public void kullaniciEkle(String adSoyad, String kullaniciAdi, String sifre) {
        try {
            Connection connection = DatabaseConnection.getInstance().getConnection();
            String query = "INSERT INTO kullanicilar (AdSoyad, KullaniciAdi, Sifre, KullaniciTipi) VALUES (?, ?, ?, ?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setString(1, adSoyad);
                preparedStatement.setString(2, kullaniciAdi);
                preparedStatement.setString(3, sifre);
                preparedStatement.setString(4, "ogretimuyesi");

                int result = preparedStatement.executeUpdate();

                if (result > 0) {
                    System.out.println("Kayıt başarıyla eklendi.");
                } else {
                    System.out.println("Kayıt eklenirken bir hata oluştu.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
