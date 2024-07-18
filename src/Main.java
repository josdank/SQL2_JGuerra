import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.Scanner;


//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/estudiantes1";
        String user = "root";
        String password = "123456";
        String sql = "select * from estudiantes1 limit 3";
        Connection conn = null;
        PreparedStatement ps = null;
        System.out.println("Hello and Welcome");

        //establecer Conexion
        /*try (Connection connection= DriverManager.getConnection(url,user,password)) {
            PreparedStatement Statement = connection.prepareStatement(sql);
            ResultSet resultSet = Statement.executeQuery();
            while (resultSet.next()) {
                System.out.println(resultSet.getString("nombre"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());;
        }*/
        try{
            conn=DriverManager.getConnection(url, user, password);
            // preparar la sentencia sql
            String sql1 = "UPDATE estudiantes1 SET b1 = ? WHERE cedula = ?";
            ps = conn.prepareStatement(sql1);
            //Seteamos los valores de la sentencia previa
            ps.setInt(1, 40);
            ps.setString(2, "0022342650");
            System.out.println(sql1);
            int n = ps.executeUpdate();
            System.out.println("Se modificaron: " + n + " Lineas");

        }catch (SQLException e){
            System.out.println(e.getMessage());
        }finally {
            //Cerramos la conexion
            try {
                if (ps != null) {
                    ps.close();
                }
                if (conn != null) {
                    conn.close();
                }
            }catch (SQLException e){
                System.out.println(e.getMessage());
            }
        }
    }
}