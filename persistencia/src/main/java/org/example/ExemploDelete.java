package org.example;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ExemploDelete {

    public static void main(String[] args) {
        String jdbc = "jdbc:oracle:thin:@oracle.fiap.com.br:1521:orcl";
        String user = "pf0313";
        String pwd = "professor#23";
        String sql = "DELETE FROM tb_paciente WHERE id = ";

        try {
            Connection con = DriverManager.getConnection(jdbc, user, pwd);
            String id = JOptionPane.showInputDialog("ID: ");

            String sqlCompleto = sql + id;
            System.out.println("SQL => " + sqlCompleto);
            Statement stmt = con.createStatement();
            int registrosAfetados = stmt.executeUpdate(sqlCompleto);
            System.out.println("Qtd de registros atualizados " + registrosAfetados);
            con.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }
}
