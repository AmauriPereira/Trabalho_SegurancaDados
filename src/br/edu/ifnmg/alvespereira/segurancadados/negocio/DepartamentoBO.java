package br.edu.ifnmg.alvespereira.segurancadados.negocio;

import br.edu.ifnmg.alvespereira.segurancadados.dados.DepartamentoDAO;
import br.edu.ifnmg.alvespereira.segurancadados.entidades.Departamento;
import br.edu.ifnmg.alvespereira.segurancadados.excecoes.excecaoDepartamento;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class DepartamentoBO {

    //ABAIXO UM METODO DE INSERT NO BANCO: VERIFICA SE EXISTE ALGUM DEP CADASTRADO COM NOME OU COD IGUAL 
    // AO DIGITADO PELO USUARIO DO SOFTWARE.
    public void criarDep(Departamento DEP) throws SQLException, excecaoDepartamento {

        DepartamentoDAO depDAO = new DepartamentoDAO();
        Departamento DepExistente = null;

        DepExistente = depDAO.selecDepartamento(DEP.getNome(), DEP.getCodigo());

        if (DepExistente == null) {

            depDAO.criaDEP(DEP);

        } else {
            throw new excecaoDepartamento();

        }
    }

    public Departamento SelectDepartamentos() throws SQLException {

        DepartamentoDAO depDAO = new DepartamentoDAO();
        Departamento DEPexistente = null;

        DEPexistente = depDAO.selectTodosDepartamentos();

        return DEPexistente;
    }

    public ArrayList<String> ComboBoxDepartamentos() throws SQLException {

        DepartamentoDAO depDAO = new DepartamentoDAO();
        ArrayList<String> Departamentos = new ArrayList<>();

        Departamentos = depDAO.cbDepartamentos();

        return Departamentos;

    }

    public Departamento selectDepartamento(String NomeDepartamento) throws SQLException {

        DepartamentoDAO depDAO = new DepartamentoDAO();
        Departamento departamento = new Departamento();

        departamento = depDAO.selectDepartamentoPorNome(NomeDepartamento);

        return departamento;

    }

}
