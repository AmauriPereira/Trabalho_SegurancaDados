package br.edu.ifnmg.alvespereira.segurancadados.negocio;

import br.edu.ifnmg.alvespereira.segurancadados.dados.SegurancaDadosDAO;
import br.edu.ifnmg.alvespereira.segurancadados.entidades.Usuario;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class UsuarioBO {

    public void criarUser(Usuario user) throws SQLException {
        SegurancaDadosDAO SDD = new SegurancaDadosDAO();

        Usuario userExistente = SDD.selectDiretor();

        if (userExistente == null) {
            SDD.criaUSER(user);
            JOptionPane.showMessageDialog(null, "Diretor Cadastrado com Sucesso !!!", "Cadastro de Diretor", JOptionPane.INFORMATION_MESSAGE);
        }
    }
}
