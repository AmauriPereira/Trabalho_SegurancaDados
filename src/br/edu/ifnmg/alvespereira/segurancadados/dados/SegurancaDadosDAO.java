package br.edu.ifnmg.alvespereira.segurancadados.dados;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SegurancaDadosDAO {

    private static final String SQL_INSERT_DEP = "INSERT INTO DEP(NOME)VALUES (?)";

    public static void criaDEP() throws SQLException {
        Connection conexao = null;
        PreparedStatement comando = null;

        try {

            conexao = BancoDadosUtil.getConnection();
            comando = conexao.prepareStatement(SQL_INSERT_DEP);
            comando.setString(1, "TESTE NOME");
            comando.execute();
            conexao.commit();

        } catch (Exception e) {
            if (conexao != null) {
                conexao.rollback();
            }
            throw new RuntimeException(e);

        } finally {
            if (comando != null && !comando.isClosed()) {
                comando.close();
            }
            if (conexao != null && !conexao.isClosed()) {
                conexao.close();
            }
        }
    }

}
