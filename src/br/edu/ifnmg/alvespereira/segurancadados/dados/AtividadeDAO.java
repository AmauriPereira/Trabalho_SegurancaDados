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
    
    private static final String SQL_UPDATE_ANDAMENTO_ATIVIDADE
            = "UPDATE ATIVIDADE SET ATIVIDADE.CONCLUSAO = ?, ATIVIDADE.HORAS_TRABALHADAS = ? "
            + "WHERE ATIVIDADE.NOME = ?";
    
    private static final String SQL_TODAS_ATIVIDADE_POR_USUARIO = "SELECT NOME, ID_ATIVIDADE FROM ATIVIDADE "
            + "INNER JOIN USUARIO ON (USUARIO.ID_USUARIO =  ATIVIDADE.ID_USUARIO)"
            + " WHERE USUARIO.NOME = ? ";

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
    
    public void andamentoAtividade(Atividade atividade, String atividadeSelecionada) throws SQLException {
        Connection conexao = null;
        PreparedStatement comando = null;

        try {

            conexao = BancoDadosUtil.getConnection();
            comando = conexao.prepareStatement(SQL_UPDATE_ANDAMENTO_ATIVIDADE);

            comando.setFloat(1, atividade.getConlusao());
            comando.setFloat(2, atividade.getHorasTrabalhadas());
            comando.setString(3, atividadeSelecionada);

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
    public ArrayList<String> cbAtividades(String nomeUsuario) throws SQLException {
        ArrayList<String> Atividade = new ArrayList<>();

        Connection conexao = null;
        PreparedStatement comando = null;
        ResultSet resultado = null;

        try {

            conexao = BancoDadosUtil.getConnection();
            System.out.println(nomeUsuario);
            comando = conexao.prepareStatement(SQL_TODAS_ATIVIDADE_POR_USUARIO);
            System.out.println(nomeUsuario);
            comando.setString(1, nomeUsuario);

            resultado = comando.executeQuery();
            Atividade.removeAll(Atividade);

            while (resultado.next()) {
                Atividade.add(resultado.getString("NOME"));
                Atividade.add(resultado.getString("ID_ATIVIDADE"));
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
