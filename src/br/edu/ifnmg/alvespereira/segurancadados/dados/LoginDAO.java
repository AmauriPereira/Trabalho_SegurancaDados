package br.edu.ifnmg.alvespereira.segurancadados.dados;

import br.edu.ifnmg.alvespereira.segurancadados.entidades.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDAO {

    private static final String SQL_SELECT_LOGIN = "SELECT NOME, TIPO, SENHA, EMAIL, COD_DEPARTAMENTO FROM USUARIO WHERE EMAIL LIKE ? AND SENHA LIKE ?";

    //SELECIONA O USUARIO QUE POSSUI LOGIN IGUAL AOS PARAMETROS(LOGIN E SENHA)
    public Usuario selectLogin(String login, String Senha) throws SQLException {
        Connection conexao = null;
        PreparedStatement comando = null;
        ResultSet resultado = null;
        Usuario user = null;

        try {

            conexao = BancoDadosUtil.getConnection();

            comando = conexao.prepareStatement(SQL_SELECT_LOGIN);
            comando.setString(1, login);
            comando.setString(2, Senha);

            resultado = comando.executeQuery();

            if (resultado.next()) {
                user = new Usuario();

                user.setNome(resultado.getString("NOME"));
                user.setTipo(resultado.getString("TIPO"));
                user.setSenha(resultado.getString("SENHA"));
                user.setEmail(resultado.getString("EMAIL"));

                DepartamentoDAO depDAO = new DepartamentoDAO();
                user.setDepartamento(depDAO.selectDepartamentoPorCodigo(resultado.getString("COD_DEPARTAMENTO")));

            }

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
        return user;

    }

}
