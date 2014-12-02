package br.edu.ifnmg.alvespereira.segurancadados.negocio;

import br.edu.ifnmg.alvespereira.segurancadados.dados.DepartamentoDAO;
import br.edu.ifnmg.alvespereira.segurancadados.entidades.Departamento;
import br.edu.ifnmg.alvespereira.segurancadados.excecoes.excecaoCodDepartamentoInavlido;
import br.edu.ifnmg.alvespereira.segurancadados.excecoes.excecaoDeletarElemento;
import br.edu.ifnmg.alvespereira.segurancadados.excecoes.excecaoDepartamento;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DepartamentoBO {

    //ABAIXO UM METODO DE INSERT NO BANCO: VERIFICA SE EXISTE ALGUM DEP CADASTRADO COM NOME OU COD IGUAL 
    // AO DIGITADO PELO USUARIO DO SOFTWARE.
    public void criarDep(Departamento DEP) throws SQLException, excecaoDepartamento, excecaoCodDepartamentoInavlido {

        DepartamentoDAO depDAO = new DepartamentoDAO();
        Departamento DepExistente = null;

        DepExistente = depDAO.selecDepartamento(DEP.getNome(), DEP.getCodigo());

        if (DepExistente == null) {
            if (DEP.getCodigo().length() == 3) {

                depDAO.criaDEP(DEP);
            } else {
                throw new excecaoCodDepartamentoInavlido();
            }

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

    public ArrayList<String> CMBDepartamento(String CodDepartamento) throws SQLException {

        DepartamentoDAO depDAO = new DepartamentoDAO();
        ArrayList<String> Departamentos = new ArrayList<>();

        Departamentos = depDAO.CMBDepartamento(CodDepartamento);

        return Departamentos;

    }

    public Departamento selectDepartamento(String NomeDepartamento) throws SQLException {

        DepartamentoDAO depDAO = new DepartamentoDAO();
        Departamento departamento = new Departamento();

        departamento = depDAO.selectDepartamentoPorNome(NomeDepartamento);

        return departamento;

    }

    public ResultSet preencheTabela() throws SQLException {
        DepartamentoDAO departamentoDAO = new DepartamentoDAO();
        ResultSet resultPreencheTabela = departamentoDAO.PreencheTabelaDepartamentos();

        return resultPreencheTabela;
    }

    public ResultSet pesquisaNaTabelaDepartamento(String NomeDepartamento) throws SQLException {

        DepartamentoDAO departamentoDAO = new DepartamentoDAO();
        ResultSet resultPreencheTabela = departamentoDAO.PesquisaNaTabelaDepartamentos(NomeDepartamento);

        return resultPreencheTabela;
    }

    public void DeleteDepartamento(String Cod_Departamento) throws SQLException, excecaoDeletarElemento {
        DepartamentoDAO departamentoDAO = new DepartamentoDAO();
        departamentoDAO.DeleteDepartamento(Cod_Departamento);

    }

    public void UpdateDep(Departamento DEP) throws SQLException, excecaoDepartamento {

        DepartamentoDAO depDAO = new DepartamentoDAO();
        Departamento DepExistente = null;

        DepExistente = depDAO.selectDepartamentoPorNome(DEP.getNome());

        if (DepExistente == null) {

            depDAO.UpdateDepartamento(DEP, DEP.getCodigo());

        } else {
            throw new excecaoDepartamento();

        }
    }

}
