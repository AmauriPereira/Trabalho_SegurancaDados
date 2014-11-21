package br.edu.ifnmg.alvespereira.segurancadados.dados;

import br.edu.ifnmg.alvespereira.segurancadados.entidades.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuarioDAO {

    //CONSULTAS DE INSERT NO BANCO
    private static final String SQL_INSERT_USUARIO = "INSERT INTO USUARIO( NOME, TIPO, SENHA, EMAIL, COD_DEPARTAMENTO)VALUES (?,?,?,?,?)";

    //CONSULTAS DE SELECT NO BANCO
    private static final String SQL_SELECT_DIRETOR = "SELECT  NOME, TIPO, SENHA, EMAIL FROM USUARIO WHERE TIPO LIKE ?";
    private static final String SQL_SELECT_GERENTE = "SELECT  NOME, TIPO, SENHA, EMAIL, COD_DEPARTAMENTO FROM USUARIO WHERE NOME = ? AND TIPO = ?";
    private static final String SQL_SELECT_ENCARREGADO = "SELECT  NOME, TIPO, SENHA, EMAIL, COD_DEPARTAMENTO FROM USUARIO WHERE NOME = ? AND TIPO = ?";

    private static final String SQL_SELECT_GERENTE_POR_DEPARTAMENTO = "SELECT  NOME, EMAIL, SENHA, TIPO, USUARIO.COD_DEPARTAMENTO FROM USUARIO "
            + "WHERE USUARIO.TIPO =  ?  AND  USUARIO.COD_DEPARTAMENTO = ?";

    // ABAIXO METODOS DE INSERÇÃO(INSERT), REMOÇÃO(DELETE), ATUALIZAÇÃO(UPDATE), RECUPERAÇÃO(SELECT)
    //INSERT DEPARTAMENTO 
    //INSERT USUÁRIOS(ENCARREGADO, DIRETOR, GERENTE)
    public void criaUSER(Usuario user) throws SQLException {
        Connection conexao = null;
        PreparedStatement comando = null;

        try {

            conexao = BancoDadosUtil.getConnection();
            comando = conexao.prepareStatement(SQL_INSERT_USUARIO);

            comando.setString(1, user.getNome());
            comando.setString(2, user.getTipo());
            comando.setString(3, user.getSenha());
            comando.setString(4, user.getEmail());
            comando.setString(5, user.getDepartamento().getCodigo());

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

    //SELECIONA O DIRETOR CADASTRADO, CASO HAJA CADASTRO
    public Usuario selectDiretor() throws SQLException {
        Connection conexao = null;
        PreparedStatement comando = null;
        ResultSet resultado = null;
        Usuario user = null;

        try {

            conexao = BancoDadosUtil.getConnection();

            comando = conexao.prepareStatement(SQL_SELECT_DIRETOR);
            comando.setString(1, "Diretor");
            resultado = comando.executeQuery();

            if (resultado.next()) {
                user = new Usuario();
                user.setNome(resultado.getString("NOME"));
                user.setTipo(resultado.getString("TIPO"));
                user.setSenha(resultado.getString("SENHA"));
                user.setEmail(resultado.getString("EMAIL"));

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
        return user;
    }

    //SELECIONA O GERENTE CADASTRADO
    public Usuario selectGerente(String Nome, String Tipo) throws SQLException {
        Connection conexao = null;
        PreparedStatement comando = null;
        ResultSet resultado = null;
        Usuario user = null;

        try {

            conexao = BancoDadosUtil.getConnection();

            comando = conexao.prepareStatement(SQL_SELECT_GERENTE);
            comando.setString(1, Nome);
            comando.setString(2, Tipo);
            resultado = comando.executeQuery();

            if (resultado.next()) {
                user = new Usuario();
                user.setNome(resultado.getString("NOME"));
                user.setTipo(resultado.getString("TIPO"));
                user.setSenha(resultado.getString("SENHA"));
                user.setEmail(resultado.getString("EMAIL"));

                DepartamentoDAO depDAO = new DepartamentoDAO();
                user.setDepartamento(depDAO.selectDepartamentoPorCodigo(resultado.getString("COD_DEPARTAMENTO")));

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
        return user;
    }

    //SELECIONA O ENCARREGADO CADASTRADO
    public Usuario selectEncarregado(String Nome, String Tipo) throws SQLException {
        Connection conexao = null;
        PreparedStatement comando = null;
        ResultSet resultado = null;
        Usuario user = null;

        try {

            conexao = BancoDadosUtil.getConnection();

            comando = conexao.prepareStatement(SQL_SELECT_ENCARREGADO);
            comando.setString(1, Nome);
            comando.setString(2, Tipo);
            resultado = comando.executeQuery();

            if (resultado.next()) {
                user = new Usuario();
                user.setNome(resultado.getString("NOME"));
                user.setTipo(resultado.getString("TIPO"));
                user.setSenha(resultado.getString("SENHA"));
                user.setEmail(resultado.getString("EMAIL"));

                DepartamentoDAO depDAO = new DepartamentoDAO();
                user.setDepartamento(depDAO.selectDepartamentoPorCodigo(resultado.getString("COD_DEPARTAMENTO")));

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
        return user;
    }

    //SELECIONA OS GERENTES CADASTRADOS POR DEPARTAMENTO
    public Usuario selectGerentePorDepartamento(String CodDepartamento, String Tipo) throws SQLException {
        Connection conexao = null;
        PreparedStatement comando = null;
        ResultSet resultado = null;
        Usuario user = null;

        try {

            conexao = BancoDadosUtil.getConnection();

            comando = conexao.prepareStatement(SQL_SELECT_GERENTE_POR_DEPARTAMENTO);
            comando.setString(1, Tipo);
            comando.setString(2, CodDepartamento);
            resultado = comando.executeQuery();

            if (resultado.next()) {
                user = new Usuario();
                user.setNome(resultado.getString("NOME"));
                user.setTipo(resultado.getString("TIPO"));
                user.setSenha(resultado.getString("SENHA"));
                user.setEmail(resultado.getString("EMAIL"));

                DepartamentoDAO depDAO = new DepartamentoDAO();
                user.setDepartamento(depDAO.selectDepartamentoPorCodigo(resultado.getString("COD_DEPARTAMENTO")));

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
        return user;
    }

}
