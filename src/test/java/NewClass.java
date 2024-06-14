
import com.app.coffee.Backend.Connect.ConnectionCoffee;
import java.sql.Connection;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Admin
 */
public class NewClass {
    public static void main(String[] args) {
        Connection connect = ConnectionCoffee.getConnection();
        System.out.println(connect);
        
        ConnectionCoffee.closeConnection(connect);
    }
}