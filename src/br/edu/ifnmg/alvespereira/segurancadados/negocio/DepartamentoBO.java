package br.edu.ifnmg.alvespereira.segurancadados.negocio;

import br.edu.ifnmg.alvespereira.segurancadados.dados.SegurancaDadosDAO;
import br.edu.ifnmg.alvespereira.segurancadados.entidades.Departamento;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class DepartamentoBO {

    
    //ABAIXO UM METODO DE INSERT NO BANCO: VERIFICA SE EXISTE ALGUM DEP CADASTRADO COM NOME OU COD IGUAL 
    // AO DIGITADO PELO USUARIO DO SOFTWARE.
    
   
    public void criarDep(Departamento DEP) throws SQLException {
        
        SegurancaDadosDAO SDD = new SegurancaDadosDAO();

        Departamento DepExistente = SDD.selecDepartamento(DEP.getNome(), DEP.getCodigo());

        if (DepExistente == null) {
            SDD.criaDEP(DEP);
            JOptionPane.showMessageDialog(null, "Departamento Cadastrado com Sucesso !!!", "Cadastro de Departamento", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Ja existe um Departamento cadastrado\n  Com este nome ou código!!!", "Cadastro de Departamento", JOptionPane.ERROR_MESSAGE);

        }
    }

}
