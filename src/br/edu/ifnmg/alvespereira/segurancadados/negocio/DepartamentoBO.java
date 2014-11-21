package br.edu.ifnmg.alvespereira.segurancadados.negocio;

import br.edu.ifnmg.alvespereira.segurancadados.dados.DepartamentoDAO;
import br.edu.ifnmg.alvespereira.segurancadados.entidades.Departamento;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class DepartamentoBO {

    //ABAIXO UM METODO DE INSERT NO BANCO: VERIFICA SE EXISTE ALGUM DEP CADASTRADO COM NOME OU COD IGUAL 
    // AO DIGITADO PELO USUARIO DO SOFTWARE.
    public void criarDep(Departamento DEP) {

        DepartamentoDAO depDAO = new DepartamentoDAO();
        Departamento DepExistente = null;

        try {
            DepExistente = depDAO.selecDepartamento(DEP.getNome(), DEP.getCodigo());
        } catch (SQLException ex) {
            Logger.getLogger(DepartamentoBO.class.getName()).log(Level.SEVERE, null, ex);
        }

        if (DepExistente == null) {
            try {
                depDAO.criaDEP(DEP);
            } catch (SQLException ex) {
                Logger.getLogger(DepartamentoBO.class.getName()).log(Level.SEVERE, null, ex);
            }
            JOptionPane.showMessageDialog(null, "Departamento Cadastrado com Sucesso !!!", "Cadastro de Departamento", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Ja existe um Departamento cadastrado\n  Com este nome ou código!!!", "Cadastro de Departamento", JOptionPane.ERROR_MESSAGE);

        }
    }

    public Departamento SelectDepartamentos() {

        DepartamentoDAO depDAO = new DepartamentoDAO();
        Departamento DEPexistente = null;

        try {
            DEPexistente = depDAO.selectTodosDepartamentos();
        } catch (SQLException ex) {
            Logger.getLogger(DepartamentoBO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return DEPexistente;
    }

    public ArrayList<String> ComboBoxDepartamentos() {

        DepartamentoDAO depDAO = new DepartamentoDAO();
        ArrayList<String> Departamentos = new ArrayList<>();

        try {
            Departamentos = depDAO.cbDepartamentos();
        } catch (SQLException ex) {
            Logger.getLogger(DepartamentoBO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return Departamentos;

    }

    public Departamento selectDepartamento(String NomeDepartamento) {

        DepartamentoDAO depDAO = new DepartamentoDAO();
        Departamento departamento = new Departamento();

        try {
            departamento = depDAO.selectDepartamentoPorNome(NomeDepartamento);
        } catch (SQLException ex) {
            Logger.getLogger(DepartamentoBO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return departamento;

    }

}
