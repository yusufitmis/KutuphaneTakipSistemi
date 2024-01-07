/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package loginform;
import com.mysql.cj.xdevapi.Statement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author bonur
 */
public class KitapIslemleri extends  AbstractPersonelKitapIslemleri {

    public KitapIslemleri(Connection connection) 
    {
        this.connection = connection;
    }
    private Connection connection = null;
    private Statement statement = null;
    private PreparedStatement preparedStatement = null;
    

    @Override
    public void kitapSil(String isbn) {
        String sorgu = "Delete from kitaplar where isbn = ?";

        try {
            preparedStatement = connection.prepareStatement(sorgu);
            preparedStatement.setString(1, isbn);

            preparedStatement.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(KitapIslemleri.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void kitapEkle(String isbn, String kitapAdi, String yazar, String durum) {
        String sorgu = "INSERT INTO kitaplar (isbn, kitapAdi, yazar, durum) VALUES (?, ?, ?, ?)";

        try {
        preparedStatement = connection.prepareStatement(sorgu);

        preparedStatement.setString(1, isbn);
        preparedStatement.setString(2, kitapAdi);
        preparedStatement.setString(3, yazar);
        preparedStatement.setString(4, durum); 

        preparedStatement.executeUpdate();

    } catch (SQLException ex) {
        Logger.getLogger(KitapIslemleri.class.getName()).log(Level.SEVERE, null, ex);
    }

    }
   

    @Override
public void kitapGuncelle(String yeniisbn, String yenikitapAdi, String yeniyazar, String yenidurum) {
    String sorgu = "UPDATE kitaplar SET kitapAdi = ?, yazar = ?, durum = ? WHERE isbn = ?";

    try {
        preparedStatement = connection.prepareStatement(sorgu);

        preparedStatement.setString(1, yenikitapAdi);
        preparedStatement.setString(2, yeniyazar);
        preparedStatement.setString(3, yenidurum);
        preparedStatement.setString(4, yeniisbn);

        preparedStatement.executeUpdate();
    } catch (SQLException ex) {
        Logger.getLogger(KitapIslemleri.class.getName()).log(Level.SEVERE, null, ex);
    }
}
 } 

