package br.edu.ifnmg.alvespereira.segurancadados.dados;

import br.edu.ifnmg.alvespereira.segurancadados.entidades.Departamento;
import br.edu.ifnmg.alvespereira.segurancadados.entidades.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class SegurancaDadosDAO {

    //CONSULTAS DE INSERT NO BANCO
    private static final String SQL_INSERT_DEP = "INSERT INTO DEP(NOME, CODDEP)VALUES (?,?)";
    private static final String SQL_INSERT_USER = "INSERT INTO USER( NOME, TIPO, SENHA, EMAIL, CODDEP )VALUES (?,?,?,?,?)";

    //CONSULTAS DE SELECT NO BANCO
    private static final String SQL_SELECT_DIRETOR = "SELECT  NOME, TIPO, SENHA, EMAIL FROM USER WHERE TIPO LIKE ?";
    private static final String SQL_SELECT_GERENTE = "SELECT  NOME, TIPO, SENHA, EMAIL, CODDEP FROM USER WHERE NOME = ? AND TIPO = ?";
    private static final String SQL_SELECT_ENCARREGADO = "SELECT  NOME, TIPO, SENHA, EMAIL, CODDEP FROM USER WHERE NOME = ? AND TIPO = ?";

    private static final String SQL_SELECT_GERENTE_POR_DEPARTAMENTO = "select  NOME, EMAIL, SENHA, TIPO, USER.CODDEP from USER "
            + "WHERE USER.TIPO =  ?  AND  USER.CODDEP = ?";

    private static final String SQL_SELECT_LOGIN = "SELECT NOME, TIPO, SENHA, EMAIL, CODDEP FROM USER WHERE EMAIL LIKE ? AND SENHA LIKE ?";
    private static final String SQL_SELECT_DEPARTAMENTO = "SELECT NOME, CODDEP FROM DEP WHERE NOME = ? OR CODDEP = ?";
    private static final String SQL_SELECT_DEPARTAMENTOs = "SELECT NOME FROM DEP";
    private static final String SQL_SELECT_CODDEPARTAMENTO = "SELECT CODDEP, NOME FROM DEP WHERE DEP.NOME = ?";

    // ABAIXO METODOS DE INSERÇÃO(INSERT), REMOÇÃO(DELETE), ATUALIZAÇÃO(UPDATE), RECUPERAÇÃO(SELECT)
    //INSERT DEPARTAMENTO
    public void criaDEP(Departamento Dep) throws SQLException {
        Connection conexao = null;
        PreparedStatement comando = null;

        try {

            conexao = BancoDadosUtil.getConnection();
            comando = conexao.prepareStatement(SQL_INSERT_DEP);
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

    //INSERT USUÁRIOS(ENCARREGADO, DIRETOR, GERENTE)
    public void criaUSER(Usuario user) throws SQLException {
        Connection conexao = null;
        PreparedStatement comando = null;

        try {

            conexao = BancoDadosUtil.getConnection();
            comando = conexao.prepareStatement(SQL_INSERT_USER);

            comando.setString(1, user.getNome());
            comando.setString(2, user.getTipo());
            comando.setString(3, user.getSenha());
            comando.setString(4, user.getEmail());
            comando.setString(5, user.getDepartamento());

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
                user.setDepartamento(resultado.getString("CODDEP"));

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
                user.setDepartamento(resultado.getString("CODDEP"));

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
                user.setDepartamento(resultado.getString("CODDEP"));

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
                DEP.setCodigo(resultado.getString("CODDEP"));

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

    //SELECIONA UM COD DE UM DEPARTAMENTO, DE ACORDO OS PARAMETRO(NOME)
    public Departamento selectCODdepartamento(String NOME) throws SQLException {
        Connection conexao = null;
        PreparedStatement comando = null;
        ResultSet resultado = null;
        Departamento DEP = null;

        try {

            conexao = BancoDadosUtil.getConnection();

            comando = conexao.prepareStatement(SQL_SELECT_CODDEPARTAMENTO);
            comando.setString(1, NOME);

            resultado = comando.executeQuery();

            if (resultado.next()) {
                DEP = new Departamento();

                DEP.setNome(resultado.getString("NOME"));
                DEP.setCodigo(resultado.getString("CODDEP"));

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

    //SELECIONA O USUARIO QUE POSSUI LOGIN IGUAL AOS PARAMETROS(LOGIN E SENHA)
    public Usuario selectLogin(String login, String Senha) throws SQLException {
        Connection conexao = null;
        PreparedStatement comando = null;
        ResultSet resultado = null;
        Usuario user = null;

        try {

            conexao = BancoDadosUtil.getConnection();

            comando = conexao.prepareStatement(SQL_SELECT_LOGIN);
            comando.setString(1, login);
            comando.setString(2, Senha);

            resultado = comando.executeQuery();

            if (resultado.next()) {
                user = new Usuario();

                user.setNome(resultado.getString("NOME"));
                user.setTipo(resultado.getString("TIPO"));
                user.setSenha(resultado.getString("SENHA"));
                user.setEmail(resultado.getString("EMAIL"));
                user.setDepartamento(resultado.getString("CODDEP"));

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

    //SELECIONA TODOS OS DEPARTAMENTO, E ARMAZENA EM UMA LISTA
    public ArrayList<String> cbDepartamentos() throws SQLException {
        ArrayList<String> Departamentos = new ArrayList<>();

        Connection conexao = null;
        PreparedStatement comando = null;
        ResultSet resultado = null;

        try {

            conexao = BancoDadosUtil.getConnection();
            comando = conexao.prepareStatement(SQL_SELECT_DEPARTAMENTOs);

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
