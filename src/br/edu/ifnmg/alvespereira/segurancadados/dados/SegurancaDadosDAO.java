
package br.edu.ifnmg.alvespereira.segurancadados.dados;

import br.edu.ifnmg.alvespereira.segurancadados.entidades.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;



/**
 *
 * @author Amauri
 */
public class SegurancaDadosDAO {

    private static final String SQL_INSERT = "INSERT INTO USER( SENHA,NOME )VALUES (?,?)";

    public void criaUsuario(Usuario usuario) throws SQLException {
        Connection conexao = null;
        PreparedStatement comando = null;

        try {
            //recupera  a conexão com o banco de dados
            conexao = BancoDadosUtil.getConnection();
            
            //Comando para enserie dados no banco de dados
            comando = conexao.prepareStatement(SQL_INSERT);
            
            //atribui os parametros
            comando.setString(2, usuario.getNome());
            comando.setString(3, usuario.getEmail());
            comando.setString(4, usuario.getSenha());
            
            //Executa o comando 
            comando.execute();
            
            //Persiste o comando no banco de dados 
            conexao.commit();
        } catch (Exception e) {
            /*Caso aconteça alguma exeção é feito um rollback para o banco de
             dados retornar ao seu estado anterior. */
            if (conexao != null) {
                conexao.rollback();
            }
            //Lança a exceção do tipo sem verificação 
            throw new RuntimeException(e);
        } finally {
            //Todo objeto que referencie o banco de dados deve ser fechado 
            if (comando != null && !comando.isClosed()) {
                comando.close();
            }
            if (conexao != null && !conexao.isClosed()) {
                conexao.close();
            }
        }
    }

}
