package database;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SqlConn {
    private static final String url = "jdbc:mysql://127.0.0.1:3306/sistema_escolar";
    private static final String usuario = "root";
    private static final String senha = "Senai@134";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, usuario, senha);
    }

    public static void testarContection() {
        try (Connection conn = getConnection()) {
            System.out.println("Conectado" + conn);
        } catch (SQLException e) {
            System.out.println("ERRO ns conexão" + e);
            System.out.println("Verifique :");
            System.out.println("1. Mysql está rodando");
            System.out.println("2 O banco" + url + "Realmente existe");
            System.out.println("3 o Usuuario ou senha estao incorreto");
        }
    }
}