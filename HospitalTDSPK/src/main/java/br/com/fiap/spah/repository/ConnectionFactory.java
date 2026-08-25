package br.com.fiap.spah.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Map;

public class ConnectionFactory {

    public static void main(String[] args) {
        Map<String, String> variaveis = System.getenv();
        System.out.println("PATH => " + variaveis.get("PATH"));
        System.out.println(variaveis.get("ORACLE_USER"));
        System.out.println(variaveis.get("ORACLE_PWD"));
    }

    public Connection getConnection() {
        String url = "jdbc:oracle:thin:@oracle.fiap.com.br:1521:orcl";
        String user = "pf0313";
        String pwd = "professor#23";
        try {
            return DriverManager.getConnection(url, user, pwd);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
