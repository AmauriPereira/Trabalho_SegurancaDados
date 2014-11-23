package br.edu.ifnmg.alvespereira.segurancadados.dados;

import br.edu.ifnmg.alvespereira.segurancadados.entidades.Projeto;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProjetoDAO {

    private static final String SQL_INSERT_PROJETO
            = "INSERT INTO PROJETO(NOME, DESCRICAO, DATA_INCIO, DATA_TERMINO, COD_DEPARTAMENTO) "
            + "VALUES (?,?,?,?,?)";

    private static final String SQL_SELECT_TODOS_PROJETOS = "SELECT NOME, DESCRICAO, DATA_INCIO, DATA_TERMINO, COD_DEPARTAMENTO, ID_PROJETO FROM PROJETO";

    private static final String SQL_SELECT_UM_PROJETO = "SELECT NOME, DESCRICAO, DATA_INCIO, "
            + "DATA_TERMINO, COD_DEPARTAMENTO, ID_PROJETO FROM PROJETO WHERE  PROJETO.NOME = ?";

    public void criarProjeto(Projeto projeto) throws SQLException {
        Connection conexao = null;
        PreparedStatement comando = null;

        try {

            conexao = BancoDadosUtil.getConnection();
            comando = conexao.prepareStatement(SQL_INSERT_PROJETO);

            comando.setString(1, projeto.getNome());
            comando.setString(2, projeto.getDescricao());
            comando.setDate(3, (Date) projeto.getDataInicio());
            comando.setDate(4, (Date) projeto.getDataTermino());
            comando.setString(5, projeto.getDepartamento().getCodigo());

            comando.execute();
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
    }

    public Projeto selectUmProjeto(String Nome_projeto) throws SQLException {
        Connection conexao = null;
        PreparedStatement comando = null;
        ResultSet resultado = null;
        Projeto projet = null;

        try {

            conexao = BancoDadosUtil.getConnection();

            comando = conexao.prepareStatement(SQL_SELECT_UM_PROJETO);
            comando.setString(1, Nome_projeto);
            resultado = comando.executeQuery();

            if (resultado.next()) {
                projet = new Projeto();
                projet.setNome(resultado.getString("NOME"));
                projet.setDescricao(resultado.getString("DESCRICAO"));
                projet.setDataInicio(resultado.getDate("DATA_INCIO"));
                projet.setDataTermino(resultado.getDate("DATA_TERMINO"));

                DepartamentoDAO depDAO = new DepartamentoDAO();
                projet.setDepartamento(depDAO.selectDepartamentoPorCodigo(resultado.getString("COD_DEPARTAMENTO")));
                projet.setIdProjeto(resultado.getInt("ID_PROJETO"));
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
        return projet;
    }

    public Projeto selectTodosProjetos() throws SQLException {
        Connection conexao = null;
        PreparedStatement comando = null;
        ResultSet resultado = null;
        Projeto projet = null;

        try {

            conexao = BancoDadosUtil.getConnection();

            comando = conexao.prepareStatement(SQL_SELECT_TODOS_PROJETOS);

            resultado = comando.executeQuery();

            if (resultado.next()) {
                projet = new Projeto();
                projet.setNome(resultado.getString("NOME"));
                projet.setDescricao(resultado.getString("DESCRICAO"));
                projet.setDataInicio(resultado.getDate("DATA_INCIO"));
                projet.setDataTermino(resultado.getDate("DATA_TERMINO"));
                projet.setIdProjeto(resultado.getInt("ID_PROJETO"));

                DepartamentoDAO depDAO = new DepartamentoDAO();
                projet.setDepartamento(depDAO.selectDepartamentoPorCodigo(resultado.getString("COD_DEPARTAMENTO")));

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
        return projet;
    }

    //SELECIONA TODOS OS PROJETOS, E ARMAZENA EM UMA LISTA
    public ArrayList<String> cbProjetos() throws SQLException {
        ArrayList<String> Projeto = new ArrayList<>();
        
        Connection conexao = null;
        PreparedStatement comando = null;
        ResultSet resultado = null;

        try {

            conexao = BancoDadosUtil.getConnection();
            comando = conexao.prepareStatement(SQL_SELECT_TODOS_PROJETOS);

            resultado = comando.executeQuery();
            Projeto.removeAll(Projeto);

            while (resultado.next()) {
                Projeto.add(resultado.getString("NOME"));
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
        return Projeto;
    }
}
