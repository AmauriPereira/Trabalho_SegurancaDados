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

    private static final String SQL_SELECT_TODOS_PROJETOS = "SELECT ID_PROJETO AS Cod ,  NOME as Projeto , DESCRICAO as Descrição , DATA_INCIO as Inicio , DATA_TERMINO as Término , COD_DEPARTAMENTO as Departamento FROM PROJETO";

    //consulta prenche a tabela projeto
    private static final String SQL_TODOS_PROJETOS_TABELA = "SELECT ID_PROJETO AS Cod ,  NOME as Projeto ,"
            + "DESCRICAO as Descrição , DATA_INCIO as Inicio , DATA_TERMINO as Término , departamento.nome as Departamento "
            + "FROM PROJETO "
            + "inner join DEPARTAMENTO on (projeto.cod_departamento =  departamento.cod_departamento)"
            + " where departamento.cod_departamento = ? ";

    private static final String SQL_TODOS_PROJETOS_PESQUISA = "SELECT ID_PROJETO AS Cod ,  NOME as Projeto ,"
            + "DESCRICAO as Descrição , DATA_INCIO as Inicio , DATA_TERMINO as Término , departamento.nome as Departamento "
            + "FROM PROJETO "
            + "inner join DEPARTAMENTO on (projeto.cod_departamento =  departamento.cod_departamento)"
            + "where PROJETO.NOME like ? and departamento.cod_departamento = ? ";

    private static final String SQL_SELECT_UM_PROJETO = "SELECT NOME, DESCRICAO, DATA_INCIO, "
            + "DATA_TERMINO, COD_DEPARTAMENTO, ID_PROJETO FROM PROJETO WHERE  PROJETO.NOME = ?";

    private static final String SQL_UPDATE_UM_PROJETO = "UPDATE PROJETO SET PROJETO.NOME = ?, "
            + "PROJETO.DESCRICAO = ?, PROJETO.DATA_INCIO =  ? , PROJETO.DATA_TERMINO =  ?,"
            + "PROJETO.COD_DEPARTAMENTO = ? WHERE PROJETO.ID_PROJETO = ?";

    private static final String SQL_DELETE_UM_PROJETO = "DELETE FROM PROJETO WHERE ID_PROJETO = ?";

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

    public void AtualizarProjeto(Projeto projeto) throws SQLException {
        Connection conexao = null;
        PreparedStatement comando = null;

        try {

            conexao = BancoDadosUtil.getConnection();
            comando = conexao.prepareStatement(SQL_UPDATE_UM_PROJETO);

            comando.setString(1, projeto.getNome());
            comando.setString(2, projeto.getDescricao());
            comando.setDate(3, (Date) projeto.getDataInicio());
            comando.setDate(4, (Date) projeto.getDataTermino());
            comando.setString(5, projeto.getDepartamento().getCodigo());

            comando.setInt(6, projeto.getIdProjeto());

            comando.executeUpdate();
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

    public void DeleteProjeto(Projeto projeto) throws SQLException {
        Connection conexao = null;
        PreparedStatement comando = null;

        try {

            conexao = BancoDadosUtil.getConnection();
            comando = conexao.prepareStatement(SQL_DELETE_UM_PROJETO);

            comando.setInt(1, projeto.getIdProjeto());

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

            // comando.setString(1, codDepartamento);
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

    public ResultSet preencherTabela(String Departamento) throws SQLException {

        Connection conexao = null;
        PreparedStatement comando = null;
        ResultSet resultado = null;

        try {

            conexao = BancoDadosUtil.getConnection();

            comando = conexao.prepareStatement(SQL_TODOS_PROJETOS_TABELA);
            comando.setString(1, Departamento);

            resultado = comando.executeQuery();

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

        return resultado;

    }

    public ResultSet pesquisa(String NomeProjeto, String Departamento) throws SQLException {

        Connection conexao = null;
        PreparedStatement comando = null;
        ResultSet resultado = null;
        Projeto projet = null;

        try {

            conexao = BancoDadosUtil.getConnection();

            comando = conexao.prepareStatement(SQL_TODOS_PROJETOS_PESQUISA);
            comando.setString(1, NomeProjeto + "%");
            comando.setString(2, Departamento);

            resultado = comando.executeQuery();

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

        return resultado;

    }
}
