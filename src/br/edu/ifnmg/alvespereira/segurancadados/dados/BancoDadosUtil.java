package br.edu.ifnmg.alvespereira.segurancadados.dados;

import java.sql.Connection;
import java.sql.DriverManager;

public class BancoDadosUtil {

    private static final String DRIVER = "org.hsqldb.jdbcDriver";
    private static final String URL = "jdbc:hsqldb:file:C:\\Users\\Familia\\Documents\\NetBeansProjects\\Trabalho_SegurancaDados\\bd\\BD_SegurancaDados;shutdown=true";
    private static final String USUARIO = "root";
    private static final String SENHA = "root";

    public static Connection getConnection() {

        Connection connection = null;

        try {
            Class.forName(DRIVER).newInstance();
            connection = DriverManager.getConnection(URL, USUARIO, SENHA);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return connection;

    }

}
