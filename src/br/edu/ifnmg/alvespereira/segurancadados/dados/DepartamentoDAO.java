package br.edu.ifnmg.alvespereira.segurancadados.dados;

import br.edu.ifnmg.alvespereira.segurancadados.entidades.Departamento;
import br.edu.ifnmg.alvespereira.segurancadados.excecoes.excecaoDeletarElemento;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class DepartamentoDAO {

    //CONSULTAS DE INSERT NO BANCO
    private static final String SQL_INSERT_DEPARTAMENTO = "INSERT INTO DEPARTAMENTO(NOME, COD_DEPARTAMENTO)VALUES (?,?)";

    private static final String SQL_SELECT_DEPARTAMENTO = "SELECT NOME, COD_DEPARTAMENTO FROM DEPARTAMENTO WHERE NOME = ? OR COD_DEPARTAMENTO = ?";
    private static final String SQL_SELECT_TODOS_DEPARTAMENTOS = "SELECT COD_DEPARTAMENTO as Código, NOME as Departamento FROM DEPARTAMENTO";
    private static final String SQL_SELECT_DEPARTAMENTO_POR_COD = "SELECT COD_DEPARTAMENTO, NOME FROM DEPARTAMENTO WHERE DEPARTAMENTO.COD_DEPARTAMENTO = ?";
    private static final String SQL_SELECT_DEPARTAMENTO_POR_NOME = "SELECT COD_DEPARTAMENTO, NOME FROM DEPARTAMENTO WHERE DEPARTAMENTO.NOME LIKE ?";
    private static final String SQL_DELETE_DEPARTAMENTO = "DELETE FROM DEPARTAMENTO WHERE  COD_DEPARTAMENTO = ?";

    // ABAIXO METODOS DE INSERÇÃO(INSERT), REMOÇÃO(DELETE), ATUALIZAÇÃO(UPDATE), RECUPERAÇÃO(SELECT)
    //INSERT DEPARTAMENTO
    public void criaDEP(Departamento Dep) throws SQLException {
        Connection conexao = null;
        PreparedStatement comando = null;

        try {

            conexao = BancoDadosUtil.getConnection();
            comando = conexao.prepareStatement(SQL_INSERT_DEPARTAMENTO);
            comando.setString(1, Dep.getNome());
            comando.setString(2, Dep.getCodigo());

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

    //SELECIONA UM DEPARTAMENTO, DE ACORDO OS PARAMETRO(NOME E CODDEP)
    public Departamento selecDepartamento(String NOME, String CODDEP) throws SQLException {
        Connection conexao = null;
        PreparedStatement comando = null;
        ResultSet resultado = null;
        Departamento DEP = null;

        try {

            conexao = BancoDadosUtil.getConnection();

            comando = conexao.prepareStatement(SQL_SELECT_DEPARTAMENTO);
            comando.setString(1, NOME);
            comando.setString(2, CODDEP);

            resultado = comando.executeQuery();

            if (resultado.next()) {
                DEP = new Departamento();

                DEP.setNome(resultado.getString("NOME"));
                DEP.setCodigo(resultado.getString("COD_DEPARTAMENTO"));

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
        return DEP;
    }

    public void DeleteDepartamento(String Cod_Departamento) throws SQLException, excecaoDeletarElemento {
        Connection conexao = null;
        PreparedStatement comando = null;

        try {

            conexao = BancoDadosUtil.getConnection();
            comando = conexao.prepareStatement(SQL_DELETE_DEPARTAMENTO);

            comando.setString(1, Cod_Departamento);

            comando.execute();
            conexao.commit();

        } catch (Exception e) {
            if (conexao != null) {
                conexao.rollback();

            }
            throw new excecaoDeletarElemento();
            //throw new RuntimeException(e);

        } finally {
            if (comando != null && !comando.isClosed()) {
                comando.close();
            }
            if (conexao != null && !conexao.isClosed()) {
                conexao.close();
            }
        }
    }

    //SELECIONA todos os DEPARTAMENTO
    public Departamento selectTodosDepartamentos() throws SQLException {
        Connection conexao = null;
        PreparedStatement comando = null;
        ResultSet resultado = null;
        Departamento DEP = null;

        try {

            conexao = BancoDadosUtil.getConnection();

            comando = conexao.prepareStatement(SQL_SELECT_TODOS_DEPARTAMENTOS);

            resultado = comando.executeQuery();

            if (resultado.next()) {
                DEP = new Departamento();

                DEP.setNome(resultado.getString("NOME"));
                DEP.setCodigo(resultado.getString("COD_DEPARTAMENTO"));

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
        return DEP;
    }

    public ResultSet PreencheTabelaDepartamentos() throws SQLException {
        Connection conexao = null;
        PreparedStatement comando = null;
        ResultSet resultado = null;
        Departamento DEP = null;

        try {

            conexao = BancoDadosUtil.getConnection();

            comando = conexao.prepareStatement(SQL_SELECT_TODOS_DEPARTAMENTOS);

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

    public ResultSet PesquisaNaTabelaDepartamentos(String NomeDepartamento) throws SQLException {
        Connection conexao = null;
        PreparedStatement comando = null;
        ResultSet resultado = null;
        Departamento DEP = null;

        try {

            conexao = BancoDadosUtil.getConnection();

            comando = conexao.prepareStatement(SQL_SELECT_DEPARTAMENTO_POR_NOME);
            comando.setString(1, NomeDepartamento + "%");

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

    //SELECIONA UM DEPARTAMENTO, DE ACORDO OS PARAMETRO(COD_DEPARTAMENTO)
    public Departamento selectDepartamentoPorCodigo(String COD_DEPARTAMENTO) throws SQLException {
        Connection conexao = null;
        PreparedStatement comando = null;
        ResultSet resultado = null;
        Departamento DEP = null;

        try {

            conexao = BancoDadosUtil.getConnection();

            comando = conexao.prepareStatement(SQL_SELECT_DEPARTAMENTO_POR_COD);
            comando.setString(1, COD_DEPARTAMENTO);

            resultado = comando.executeQuery();

            if (resultado.next()) {
                DEP = new Departamento();

                DEP.setNome(resultado.getString("NOME"));
                DEP.setCodigo(resultado.getString("COD_DEPARTAMENTO"));

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
        return DEP;
    }

    //SELECIONA UM DEPARTAMENTO, DE ACORDO OS PARAMETRO(NOME_DEPARTAMENTO)
    public Departamento selectDepartamentoPorNome(String NOME_DEPARTAMENTO) throws SQLException {
        Connection conexao = null;
        PreparedStatement comando = null;
        ResultSet resultado = null;
        Departamento DEP = null;

        try {

            conexao = BancoDadosUtil.getConnection();

            comando = conexao.prepareStatement(SQL_SELECT_DEPARTAMENTO_POR_NOME);
            comando.setString(1, NOME_DEPARTAMENTO);

            resultado = comando.executeQuery();

            if (resultado.next()) {
                DEP = new Departamento();

                DEP.setNome(resultado.getString("NOME"));
                DEP.setCodigo(resultado.getString("COD_DEPARTAMENTO"));

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
        return DEP;
    }

    //SELECIONA TODOS OS DEPARTAMENTO, E ARMAZENA EM UMA LISTA
    public ArrayList<String> cbDepartamentos() throws SQLException {
        ArrayList<String> Departamentos = new ArrayList<>();

        Connection conexao = null;
        PreparedStatement comando = null;
        ResultSet resultado = null;

        try {

            conexao = BancoDadosUtil.getConnection();
            comando = conexao.prepareStatement(SQL_SELECT_TODOS_DEPARTAMENTOS);

            resultado = comando.executeQuery();
            Departamentos.removeAll(Departamentos);

            while (resultado.next()) {
                Departamentos.add(resultado.getString("NOME"));
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
        return Departamentos;
    }

}
