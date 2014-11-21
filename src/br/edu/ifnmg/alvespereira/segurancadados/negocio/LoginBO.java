package br.edu.ifnmg.alvespereira.segurancadados.negocio;

import br.edu.ifnmg.alvespereira.segurancadados.dados.LoginDAO;
import br.edu.ifnmg.alvespereira.segurancadados.entidades.Usuario;
import java.sql.SQLException;

public class LoginBO {

    public Usuario Logar(String Email, String Senha) throws SQLException {

        Usuario userLogado = new Usuario();

        LoginDAO LoginDAO = new LoginDAO();

        userLogado = LoginDAO.selectLogin(Email, Senha);

        return userLogado;
    }
}
