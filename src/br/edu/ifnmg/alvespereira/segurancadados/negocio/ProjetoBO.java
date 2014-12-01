package br.edu.ifnmg.alvespereira.segurancadados.negocio;

import br.edu.ifnmg.alvespereira.segurancadados.dados.ProjetoDAO;
import br.edu.ifnmg.alvespereira.segurancadados.entidades.Projeto;
import br.edu.ifnmg.alvespereira.segurancadados.excecoes.excecaoDeletarElemento;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProjetoBO {
    
    public void criarProjeto(Projeto projeto) throws SQLException {
        
        ProjetoDAO projetDAO = new ProjetoDAO();
        projetDAO.criarProjeto(projeto);
        
    }
    
    public void UpdateProjeto(Projeto projeto) throws SQLException {
        
        ProjetoDAO projetDAO = new ProjetoDAO();
        projetDAO.AtualizarProjeto(projeto);
        
    }
    
    public void DeleteProjeto(Projeto projeto) throws SQLException, excecaoDeletarElemento {
        
        ProjetoDAO projetDAO = new ProjetoDAO();
        projetDAO.DeleteProjeto(projeto);
        
    }
    
    public Projeto selectUmProjeto(String NomeProjeto) throws SQLException {
        
        ProjetoDAO projetDAO = new ProjetoDAO();
        Projeto projet = new Projeto();
        projet = projetDAO.selectUmProjeto(NomeProjeto);
        
        return projet;
        
    }
    
    public Projeto selectTodosProjeto() throws SQLException {
        
        ProjetoDAO projetDAO = new ProjetoDAO();
        Projeto projet = new Projeto();
        projet = projetDAO.selectTodosProjetos();
        
        return projet;
        
    }
    
    public ArrayList<String> ComboBoxProjeto() throws SQLException {
        
        ProjetoDAO projetoDAO = new ProjetoDAO();
        ArrayList<String> Projeto = new ArrayList<>();
        
        Projeto = projetoDAO.cbProjetos();
        
        return Projeto;
        
    }
    
    public ArrayList<String> CMBProjeto(String CodDepartamento) throws SQLException {
        
        ProjetoDAO projetoDAO = new ProjetoDAO();
        ArrayList<String> Projeto = new ArrayList<>();
        
        Projeto = projetoDAO.CMBProjetos(CodDepartamento);
                
        return Projeto;
        
    }
    
    public ResultSet preencheTabela(String Departamento) throws SQLException {
        ProjetoDAO projet = new ProjetoDAO();
        ResultSet resultPreencherTabela = projet.preencherTabela(Departamento);
        
        return resultPreencherTabela;
        
    }
    
    public ResultSet pesquisa(String NomeProjeto, String Departamento) throws SQLException {
        ProjetoDAO projet = new ProjetoDAO();
        ResultSet resultPesquisa = projet.pesquisa(NomeProjeto, Departamento);
        
        return resultPesquisa;
        
    }
    
}
