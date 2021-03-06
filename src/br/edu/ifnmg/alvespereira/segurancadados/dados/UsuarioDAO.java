package br.edu.ifnmg.alvespereira.segurancadados.dados;

import br.edu.ifnmg.alvespereira.segurancadados.entidades.Usuario;
import br.edu.ifnmg.alvespereira.segurancadados.excecoes.excecaoDeletarElemento;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UsuarioDAO {

    //CONSULTAS DE INSERT NO BANCO
    private static final String SQL_INSERT_USUARIO = "INSERT INTO USUARIO( NOME, TIPO, SENHA, EMAIL,COD_DEPARTAMENTO, STATUS)VALUES (?,?,?,?,?, 'ATIVO')";
    private static final String SQL_INSERT_DIRETOR = "INSERT INTO USUARIO( NOME, TIPO, SENHA, EMAIL, STATUS)VALUES (?,?,?,?, 'ATIVO')";

    //CONSULTAS DE SELECT NO BANCO
    private static final String SQL_SELECT_DIRETOR = "SELECT  NOME, TIPO, SENHA, EMAIL, ID_USUARIO FROM USUARIO WHERE TIPO LIKE ?";
    private static final String SQL_SELECT_GERENTE = "SELECT  NOME, TIPO, SENHA, EMAIL, COD_DEPARTAMENTO , ID_USUARIO FROM USUARIO WHERE NOME = ? AND TIPO = ? AND STATUS  = 'ATIVO'";
    private static final String SQL_SELECT_ENCARREGADO = "SELECT  NOME, TIPO, SENHA, EMAIL, COD_DEPARTAMENTO, ID_USUARIO FROM USUARIO WHERE NOME = ? AND TIPO = ? AND STATUS  = 'ATIVO'";
    private static final String SQL_SELECT_ENCARREGADO_POR_DEPARTAMENTO = "SELECT  NOME FROM USUARIO WHERE COD_DEPARTAMENTO = ? AND TIPO = 'Encarregado' AND STATUS  = 'ATIVO'";

    private static final String SQL_SELECT_TODOS_ENCARREGADO = "SELECT NOME, TIPO, SENHA, EMAIL, COD_DEPARTAMENTO, ID_USUARIO FROM USUARIO WHERE TIPO = ? AND STATUS  = 'ATIVO'";

    private static final String SQL_SELECT_TODOS_ENCARREGADOss = "SELECT ID_USUARIO AS Código, NOME ,TIPO AS Cargo,DEPARTAMENTO.NOME AS Departamento, EMAIL AS Email FROM USUARIO "
            + "inner join DEPARTAMENTO on (USUARIO.COD_DEPARTAMENTO =  DEPARTAMENTO.COD_DEPARTAMENTO)"
            + "WHERE TIPO = 'Encarregado' AND STATUS  = 'ATIVO'";

    private static final String SQL_SELECT_TODOS_funcionarios = "SELECT ID_USUARIO AS Código, NOME ,TIPO AS Cargo,DEPARTAMENTO.NOME AS Departamento, EMAIL AS Email FROM USUARIO "
            + "inner join DEPARTAMENTO on (USUARIO.COD_DEPARTAMENTO =  DEPARTAMENTO.COD_DEPARTAMENTO) WHERE STATUS  = 'ATIVO'";

    private static final String SQL_SELECT_TODOS_BUSCAR_funcionarios = "SELECT ID_USUARIO AS Código, NOME ,TIPO AS Cargo,DEPARTAMENTO.NOME AS Departamento, EMAIL AS Email FROM USUARIO "
            + "inner join DEPARTAMENTO on (USUARIO.COD_DEPARTAMENTO =  DEPARTAMENTO.COD_DEPARTAMENTO) WHERE DEPARTAMENTO.NOME = ? AND STATUS  = 'ATIVO'";

    private static final String SQL_SELECT_TODOS_GERENTE = "SELECT ID_USUARIO AS Código, NOME ,TIPO AS Cargo,DEPARTAMENTO.NOME AS Departamento, EMAIL AS Email FROM USUARIO "
            + "inner join DEPARTAMENTO on (USUARIO.COD_DEPARTAMENTO =  DEPARTAMENTO.COD_DEPARTAMENTO)"
            + "WHERE TIPO = 'Gerente' AND STATUS  = 'ATIVO'";

    private static final String SQL_SELECT_TODOS_ENCARREGADO_TABELA = "SELECT ID_USUARIO AS Código, NOME ,TIPO AS Cargo,DEPARTAMENTO.NOME AS Departamento, EMAIL AS Email FROM USUARIO "
            + "inner join DEPARTAMENTO on (USUARIO.COD_DEPARTAMENTO =  DEPARTAMENTO.COD_DEPARTAMENTO)"
            + "WHERE TIPO = 'Encarregado' AND DEPARTAMENTO.NOME = ? AND STATUS  = 'ATIVO'";

    private static final String SQL_SELECT_TODOS_ENCARREGADO_doDepartaemento = "SELECT ID_USUARIO AS Código, NOME ,TIPO AS Cargo,DEPARTAMENTO.NOME AS Departamento, EMAIL AS Email FROM USUARIO "
            + "inner join DEPARTAMENTO on (USUARIO.COD_DEPARTAMENTO =  DEPARTAMENTO.COD_DEPARTAMENTO)"
            + "WHERE TIPO = 'Encarregado'  AND DEPARTAMENTO.COD_DEPARTAMENTO = ?  AND STATUS  = 'ATIVO'";

    private static final String SQL_SELECT_TODOS_GERENTE_PESQUISA = "SELECT ID_USUARIO AS Código, NOME ,TIPO AS Cargo,DEPARTAMENTO.NOME AS Departamento, EMAIL AS Email  FROM USUARIO "
            + "inner join DEPARTAMENTO on (USUARIO.COD_DEPARTAMENTO =  DEPARTAMENTO.COD_DEPARTAMENTO)"
            + "WHERE NOME LIKE ? AND TIPO = 'Gerente' AND STATUS  = 'ATIVO'";

    private static final String SQL_SELECT_GERENTE_POR_DEPARTAMENTO = "SELECT  NOME, EMAIL, SENHA, TIPO, USUARIO.COD_DEPARTAMENTO, DEPARTAMENTO.NOME,  ID_USUARIO FROM USUARIO "
            + "inner join DEPARTAMENTO on (DEPARTAMENTO.COD_DEPARTAMENTO =  USUARIO.COD_DEPARTAMENTO)"
            + "WHERE USUARIO.TIPO =  ?  AND  USUARIO.COD_DEPARTAMENTO = ? AND STATUS  = 'ATIVO'";

    private static final String SQL_UPDATE_UM_GERENTE = "UPDATE USUARIO SET USUARIO.NOME = ?, "
            + "USUARIO.EMAIL = ?, USUARIO.SENHA =  ?, USUARIO.TIPO =  ? ,"
            + "USUARIO.COD_DEPARTAMENTO = ? WHERE USUARIO.ID_USUARIO = ? ";

    private static final String SQL_ALTERACAO_DADOS_PESSOAIS = "UPDATE USUARIO SET USUARIO.NOME = ?, "
            + "USUARIO.EMAIL = ?, USUARIO.SENHA =  ?"
            + " WHERE USUARIO.ID_USUARIO = ?";

    private static final String SQL_DELETE_UM_GERENTE = "UPDATE USUARIO SET STATUS  = 'DESATIVADO' WHERE ID_USUARIO = ?";

    private static final String SQL_DELETE_UM_ENCARREGADO = "UPDATE USUARIO SET STATUS  = 'DESATIVADO' WHERE ID_USUARIO = ?";

    private static final String SQL_DEMITI_UM_FUNCIONARIO = "UPDATE USUARIO SET STATUS  = 'DESATIVADO' WHERE ID_USUARIO = ?";

    private static final String SQL_SELECT_RELATORIO_CADASTRO_GERENTE = "SELECT ID_USUARIO, NOME, SENHA, EMAIL FROM USUARIO WHERE TIPO = 'Encarregado' AND STATUS  = 'ADMITIDO'";

    // ABAIXO METODOS DE INSERÇÃO(INSERT), REMOÇÃO(DELETE), ATUALIZAÇÃO(UPDATE), RECUPERAÇÃO(SELECT)
    //INSERT DEPARTAMENTO 
    //INSERT USUÁRIOS(ENCARREGADO, DIRETOR, GERENTE)
    public void criaUSER(Usuario user) throws SQLException {
        Connection conexao = null;
        PreparedStatement comando = null;

        try {

            conexao = BancoDadosUtil.getConnection();

            if ("Diretor".equals(user.getTipo())) {
                comando = conexao.prepareStatement(SQL_INSERT_DIRETOR);

            } else {
                comando = conexao.prepareStatement(SQL_INSERT_USUARIO);
                comando.setString(5, user.getDepartamento().getCodigo());
            }

            comando.setString(1, user.getNome());
            comando.setString(2, user.getTipo());
            comando.setString(3, user.getSenha());
            comando.setString(4, user.getEmail());

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
                user.setIdUsuario(resultado.getInt("ID_USUARIO"));

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
                user.setIdUsuario(resultado.getInt("ID_USUARIO"));

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
                user.setIdUsuario(resultado.getInt("ID_USUARIO"));

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
    public Usuario selectTodosEncarregado() throws SQLException {
        Connection conexao = null;
        PreparedStatement comando = null;
        ResultSet resultado = null;
        Usuario user = null;

        try {

            conexao = BancoDadosUtil.getConnection();

            comando = conexao.prepareStatement(SQL_SELECT_TODOS_ENCARREGADO);
            comando.setString(1, "Encarregado");

            resultado = comando.executeQuery();

            if (resultado.next()) {
                user = new Usuario();
                user.setNome(resultado.getString("NOME"));
                user.setTipo(resultado.getString("TIPO"));
                user.setSenha(resultado.getString("SENHA"));
                user.setEmail(resultado.getString("EMAIL"));
                user.setIdUsuario(resultado.getInt("ID_USUARIO"));

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
                user.setIdUsuario(resultado.getInt("ID_USUARIO"));

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

    public ResultSet preencherTabelaGerente() throws SQLException {

        Connection conexao = null;
        PreparedStatement comando = null;
        ResultSet resultado = null;

        try {

            conexao = BancoDadosUtil.getConnection();

            comando = conexao.prepareStatement(SQL_SELECT_TODOS_GERENTE);

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

    public ResultSet preencherTabelaEncarregado(String Departamento) throws SQLException {

        Connection conexao = null;
        PreparedStatement comando = null;
        ResultSet resultado = null;

        try {

            conexao = BancoDadosUtil.getConnection();

            comando = conexao.prepareStatement(SQL_SELECT_TODOS_ENCARREGADO_TABELA);
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

    public ResultSet preencherTabelaEncarregadOPordepartamento(String CodDepartamento) throws SQLException {

        Connection conexao = null;
        PreparedStatement comando = null;
        ResultSet resultado = null;

        try {

            conexao = BancoDadosUtil.getConnection();

            comando = conexao.prepareStatement(SQL_SELECT_TODOS_ENCARREGADO_doDepartaemento);
            comando.setString(1, CodDepartamento);

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

    public ResultSet preencherTabelaEncarregadOTodosdepartamento() throws SQLException {

        Connection conexao = null;
        PreparedStatement comando = null;
        ResultSet resultado = null;

        try {

            conexao = BancoDadosUtil.getConnection();

            comando = conexao.prepareStatement(SQL_SELECT_TODOS_ENCARREGADOss);

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

    //SELECIONA TODOS OS ENCARREGADOS, E ARMAZENA EM UMA LISTA
    public ArrayList<String> cbEncarregado() throws SQLException {
        ArrayList<String> Encaregado = new ArrayList<>();
        Connection conexao = null;
        PreparedStatement comando = null;
        ResultSet resultado = null;

        try {

            conexao = BancoDadosUtil.getConnection();
            comando = conexao.prepareStatement(SQL_SELECT_TODOS_ENCARREGADO);
            comando.setString(1, "Encarregado");

            resultado = comando.executeQuery();
            Encaregado.removeAll(Encaregado);

            while (resultado.next()) {
                Encaregado.add(resultado.getString("NOME"));
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
        return Encaregado;
    }

    public ArrayList<String> cmbEncarregadosPorDepartamento(String CodDepartamento) throws SQLException {
        ArrayList<String> Encaregado = new ArrayList<>();
        Connection conexao = null;
        PreparedStatement comando = null;
        ResultSet resultado = null;

        try {

            conexao = BancoDadosUtil.getConnection();
            comando = conexao.prepareStatement(SQL_SELECT_ENCARREGADO_POR_DEPARTAMENTO);
            comando.setString(1, CodDepartamento);

            resultado = comando.executeQuery();
            Encaregado.removeAll(Encaregado);
            while (resultado.next()) {
                Encaregado.add(resultado.getString("NOME"));
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
        return Encaregado;
    }

    public ResultSet pesquisaGerente(String NomeGerente) throws SQLException {

        Connection conexao = null;
        PreparedStatement comando = null;
        ResultSet resultado = null;

        try {

            conexao = BancoDadosUtil.getConnection();

            comando = conexao.prepareStatement(SQL_SELECT_TODOS_GERENTE_PESQUISA);
            comando.setString(1, NomeGerente + "%");

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

    public ResultSet Funcionarios() throws SQLException {

        Connection conexao = null;
        PreparedStatement comando = null;
        ResultSet resultado = null;

        try {

            conexao = BancoDadosUtil.getConnection();

            comando = conexao.prepareStatement(SQL_SELECT_TODOS_funcionarios);

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

    public ResultSet BuscarFuncionarios(String Departamento) throws SQLException {

        Connection conexao = null;
        PreparedStatement comando = null;
        ResultSet resultado = null;

        try {

            conexao = BancoDadosUtil.getConnection();

            comando = conexao.prepareStatement(SQL_SELECT_TODOS_BUSCAR_funcionarios);
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

    public void AtulizaUsuario(Usuario user) throws SQLException {
        Connection conexao = null;
        PreparedStatement comando = null;

        try {

            conexao = BancoDadosUtil.getConnection();
            comando = conexao.prepareStatement(SQL_UPDATE_UM_GERENTE);
            comando.setString(1, user.getNome());
            comando.setString(2, user.getEmail());
            comando.setString(3, user.getSenha());
            comando.setString(4, user.getTipo());
            comando.setString(5, user.getDepartamento().getCodigo());
            comando.setInt(6, user.getIdUsuario());

            comando.executeUpdate();
            conexao.commit();

        } catch (Exception e) {
            if (conexao != null) {
                conexao.rollback();
            }
            // throw new RuntimeException(e);

        } finally {
            if (comando != null && !comando.isClosed()) {
                comando.close();
            }
            if (conexao != null && !conexao.isClosed()) {
                conexao.close();
            }
        }
    }

    public void AlteracaoDadosPessoais(Usuario user) throws SQLException {
        Connection conexao = null;
        PreparedStatement comando = null;

        try {

            conexao = BancoDadosUtil.getConnection();
            comando = conexao.prepareStatement(SQL_ALTERACAO_DADOS_PESSOAIS);
            comando.setString(1, user.getNome());
            comando.setString(2, user.getEmail());
            comando.setString(3, user.getSenha());
            comando.setInt(4, user.getIdUsuario());

            comando.executeUpdate();
            conexao.commit();

        } catch (Exception e) {
            if (conexao != null) {
                conexao.rollback();
            }
            // throw new RuntimeException(e);

        } finally {
            if (comando != null && !comando.isClosed()) {
                comando.close();
            }
            if (conexao != null && !conexao.isClosed()) {
                conexao.close();
            }
        }
    }

    public void DeleteUsuario(Usuario usuario) throws SQLException, excecaoDeletarElemento {
        Connection conexao = null;
        PreparedStatement comando = null;

        try {

            conexao = BancoDadosUtil.getConnection();
            if ("Gerente".equals(usuario.getTipo())) {
                comando = conexao.prepareStatement(SQL_DELETE_UM_GERENTE);
                comando.setInt(1, usuario.getIdUsuario());

            } else if ("Encarregado".equals(usuario.getTipo())) {
                comando = conexao.prepareStatement(SQL_DELETE_UM_ENCARREGADO);
                comando.setInt(1, usuario.getIdUsuario());
            }

            comando.execute();
            conexao.commit();

        } catch (Exception e) {
            if (conexao != null) {
                conexao.rollback();
            }
            throw new excecaoDeletarElemento();

        } finally {
            if (comando != null && !comando.isClosed()) {
                comando.close();
            }
            if (conexao != null && !conexao.isClosed()) {
                conexao.close();
            }
        }
    }

    public void DEMITIUsuario(int CODUSUARIO) throws SQLException, excecaoDeletarElemento {
        Connection conexao = null;
        PreparedStatement comando = null;

        try {

            conexao = BancoDadosUtil.getConnection();

            comando = conexao.prepareStatement(SQL_DEMITI_UM_FUNCIONARIO);
            comando.setInt(1, CODUSUARIO);

            comando.execute();
            conexao.commit();

        } catch (Exception e) {
            if (conexao != null) {
                conexao.rollback();
            }
            throw new excecaoDeletarElemento();

        } finally {
            if (comando != null && !comando.isClosed()) {
                comando.close();
            }
            if (conexao != null && !conexao.isClosed()) {
                conexao.close();
            }
        }
    }

    //SELECIONA TODOS OS GERENTES, E ARMAZENA EM UMA LISTA
    public ArrayList<Usuario> listaUsuario() throws SQLException {
        ArrayList<Usuario> listaUsuarios = new ArrayList<>();
        //Usuario usuario = new Usuario();
        Usuario usuario = null;
        Connection conexao = null;
        PreparedStatement comando = null;
        ResultSet resultado = null;

        try {

            conexao = BancoDadosUtil.getConnection();
            comando = conexao.prepareStatement(SQL_SELECT_RELATORIO_CADASTRO_GERENTE);

            resultado = comando.executeQuery();
            listaUsuarios.removeAll(listaUsuarios);

            //percorrendo os registros encontrados  
            if (resultado.next()) {
                listaUsuarios = new ArrayList<Usuario>();
                do {
                    //instanciando objeto   
                    usuario = new Usuario();

                    /*setando atributos de acordo com os seus tipos primitivos*/
                    usuario.setIdUsuario(resultado.getInt("ID_USUARIO"));
                    usuario.setNome(resultado.getString("NOME"));
                    usuario.setEmail(resultado.getString("EMAIL"));

                    //add a lista de objetos encontrados e setados  
                    listaUsuarios.add(usuario);
                } while (resultado.next());
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
        return listaUsuarios;
    }

}
