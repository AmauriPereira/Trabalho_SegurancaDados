package br.edu.ifnmg.alvespereira.segurancadados.negocio;

import br.edu.ifnmg.alvespereira.segurancadados.dados.SegurancaDadosDAO;
import br.edu.ifnmg.alvespereira.segurancadados.entidades.Usuario;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LoginBO {

    public Usuario Logar(String Email, String Senha) {

        Usuario userLogado = new Usuario();

        SegurancaDadosDAO SDD = new SegurancaDadosDAO();
        try {
            userLogado = SDD.selectLogin(Email, Senha);
        } catch (SQLException ex) {
            Logger.getLogger(LoginBO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return userLogado;
    }
}
