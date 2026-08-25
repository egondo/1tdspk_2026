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
        String sql = "INSERT INTO tb_paciente(nome, email, telefone, nascimento) values('%s', '%s', '%s', to_date('%s', 'YYYY-MM-DD'))";

        try {
            Connection con = DriverManager.getConnection(jdbc, user, pwd);
            String nome = JOptionPane.showInputDialog("Nome: ");
            String email = JOptionPane.showInputDialog("Email: ");
            String tel = JOptionPane.showInputDialog("Telefone: ");
            String nascimento = JOptionPane.showInputDialog("Nascimento (yyyy-mm-dd): ");

            String sqlCompleto = String.format(sql, nome, email, tel, nascimento);
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
