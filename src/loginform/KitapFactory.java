/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package loginform;

/**
 *
 * @author bonur
 */
public class KitapFactory {
     public static KitapIslemleri createKitapIslemleri() {
        return new KitapIslemleri(DatabaseConnection.getInstance().getConnection());   
     
    }
}
