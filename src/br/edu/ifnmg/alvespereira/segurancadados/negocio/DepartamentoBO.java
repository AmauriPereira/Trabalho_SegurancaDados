package br.edu.ifnmg.alvespereira.segurancadados.negocio;

import br.edu.ifnmg.alvespereira.segurancadados.dados.SegurancaDadosDAO;
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

        SegurancaDadosDAO SDD = new SegurancaDadosDAO();

        Departamento DepExistente = null;
        try {
            DepExistente = SDD.selecDepartamento(DEP.getNome(), DEP.getCodigo());
        } catch (SQLException ex) {
            Logger.getLogger(DepartamentoBO.class.getName()).log(Level.SEVERE, null, ex);
        }

        if (DepExistente == null) {
            try {
                SDD.criaDEP(DEP);
            } catch (SQLException ex) {
                Logger.getLogger(DepartamentoBO.class.getName()).log(Level.SEVERE, null, ex);
            }
            JOptionPane.showMessageDialog(null, "Departamento Cadastrado com Sucesso !!!", "Cadastro de Departamento", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Ja existe um Departamento cadastrado\n  Com este nome ou código!!!", "Cadastro de Departamento", JOptionPane.ERROR_MESSAGE);

        }
    }

    public Departamento SelectDepartamentos() {

        SegurancaDadosDAO SDD = new SegurancaDadosDAO();
        Departamento DEPexistente = null;

        try {
            DEPexistente = SDD.selectTodosDepartamentos();
        } catch (SQLException ex) {
            Logger.getLogger(DepartamentoBO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return DEPexistente;
    }

    public ArrayList<String> ComboBoxDepartamentos() {

        SegurancaDadosDAO segurancaDadosDAO = new SegurancaDadosDAO();
        ArrayList<String> Departamentos = new ArrayList<>();

        try {
            Departamentos = segurancaDadosDAO.cbDepartamentos();
        } catch (SQLException ex) {
            Logger.getLogger(DepartamentoBO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return Departamentos;

    }

    public Departamento selectCodDepartamento(String NomeDepartamento) {

        SegurancaDadosDAO segurancaDadosDAO = new SegurancaDadosDAO();
        Departamento departamento = new Departamento();

        try {
            departamento = segurancaDadosDAO.selectCODdepartamento(NomeDepartamento);
        } catch (SQLException ex) {
            Logger.getLogger(DepartamentoBO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return departamento;

    }

}
