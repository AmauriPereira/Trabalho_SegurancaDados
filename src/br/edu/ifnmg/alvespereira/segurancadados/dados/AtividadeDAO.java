package br.edu.ifnmg.alvespereira.segurancadados.dados;

import br.edu.ifnmg.alvespereira.segurancadados.entidades.Atividade;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class AtividadeDAO {

    private static final String SQL_INSERT_ATIVIDADE
            = "INSERT INTO ATIVIDADE (NOME,DURACAO, ID_PROJETO, ID_USUARIO) "
            + "VALUES (?,?,?,?)";

    private static final String SQL_TODAS_ATIVIDADE_POR_USUARIO = "SELECT NOME, ID_ATIVIDADE FROM ATIVIDADE "
            + "INNER JOIN USUARIO ON (USUARIO.ID_USUARIO =  ATIVIDADE.ID_USUARIO)"
            + " where ATIVIDADE.ID_USUARIO = ? ";

    public void criarAtividade(Atividade atividade) throws SQLException {
        Connection conexao = null;
        PreparedStatement comando = null;

        try {

            conexao = BancoDadosUtil.getConnection();
            comando = conexao.prepareStatement(SQL_INSERT_ATIVIDADE);

            comando.setString(1, atividade.getNome());
            comando.setFloat(2, atividade.getDuracao());
            comando.setInt(3, atividade.getProjeto().getIdProjeto());
            comando.setInt(4, atividade.getEncarregado().getIdUsuario());

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

    //SELECIONA TODOS OS PROJETOS, E ARMAZENA EM UMA LISTA
    public ArrayList<String> cbAtividades(String usuario) throws SQLException {
        ArrayList<String> Atividade = new ArrayList<>();

        Connection conexao = null;
        PreparedStatement comando = null;
        ResultSet resultado = null;

        try {

            conexao = BancoDadosUtil.getConnection();
            comando = conexao.prepareStatement(SQL_TODAS_ATIVIDADE_POR_USUARIO);
            comando.setString(1, usuario);

            resultado = comando.executeQuery();
            Atividade.removeAll(Atividade);

            while (resultado.next()) {
                Atividade.add(resultado.getString("NOME"));
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
        return Atividade;
    }

}
