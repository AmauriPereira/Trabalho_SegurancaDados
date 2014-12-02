package br.edu.ifnmg.alvespereira.segurancadados.negocio;

import br.edu.ifnmg.alvespereira.segurancadados.dados.DepartamentoDAO;
import br.edu.ifnmg.alvespereira.segurancadados.dados.UsuarioDAO;
import br.edu.ifnmg.alvespereira.segurancadados.entidades.Usuario;
import br.edu.ifnmg.alvespereira.segurancadados.excecoes.excecaoControleAcesso;
import br.edu.ifnmg.alvespereira.segurancadados.excecoes.excecaoDeletarElemento;
import br.edu.ifnmg.alvespereira.segurancadados.excecoes.excecaoEncarregadoExistente;
import br.edu.ifnmg.alvespereira.segurancadados.excecoes.excecaoGerenteExistente;
import br.edu.ifnmg.alvespereira.segurancadados.excecoes.excecaoGerentePorDepartamento;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UsuarioBO {

    //SELECT DIRETOR
    public Usuario selecionarDiretor() throws SQLException {

        UsuarioDAO userDAO = new UsuarioDAO();
        Usuario user = userDAO.selectDiretor();

        return user;

    }

    // ABAIXO METODOS DE INSERT NO BANCO DE USUÁRIOS
    //INSERT DIRETOR: VERIFICA SE HÁ ALGUM DIRETOR CADASTRADO, CASO NÃO HAJA REALIZA O CADASTRO
    // obs:(SÓ PODE HAVER UM DIRETOR CADASTRADO).
    public void criarDiretor(Usuario Diretor) throws SQLException {
        UsuarioDAO userDAO = new UsuarioDAO();

        Usuario userExistente = userDAO.selectDiretor();

        if (userExistente == null) {
            userDAO.criaUSER(Diretor);

        }
    }

    //INSERT GERENTE: VERIFICA SE HA ALGUM GERENTE CADASTRADO COM O MESMO NOME, CASO HAJA 
    //INFORMA AO USUARIO DO SISTEMA, CASO NÃO HAJA VERIFICA SE JA EXISTE UM GERENTE CADASTRADO
    //PARA O DEPARTAMENTO SELECIONADO
    public void criarGerente(Usuario Gerente) throws SQLException, excecaoGerenteExistente, excecaoGerentePorDepartamento {
        UsuarioDAO userDAO = new UsuarioDAO();
        Usuario GerenteExistente = userDAO.selectGerente(Gerente.getNome(), Gerente.getTipo());

        //VERIFICA SE HA ALGUM GERENTE CADASTRADO COM O MESMO NOME
        if (GerenteExistente == null) {
            Usuario gerentePorDepartmento = userDAO.selectGerentePorDepartamento(Gerente.getDepartamento().getCodigo(), Gerente.getTipo());
            //VERIFICA SE JA EXISTE UM GERENTE CADASTRADO PARA O DEPARTAMENTO SELECIONADO
            if (gerentePorDepartmento == null) {
                userDAO.criaUSER(Gerente);
            } else {
                throw new excecaoGerentePorDepartamento();
            }

        } else {
            throw new excecaoGerenteExistente();
        }

    }

    //INSERT ENCARREGADO: VERIFICA SE HA ALGUM ENCARREGADO CADASTRADO COM O MESMO NOME, CASO HAJA 
    //INFORMA AO USUARIO DO SISTEMA, VERIFICA SE O GERENTE ESTAR CADASTRANDO O ENCARREGADO 
    //NO SEU DEPARTAMENTO, Obs: GERENTE SÓ PODE CADASTRAR ENCARREGADOS EM SEU DEPARTAMENTO
    public void criarEncarregado(Usuario Encarregado, Usuario userLogado) throws SQLException, excecaoEncarregadoExistente, excecaoControleAcesso {
        UsuarioDAO userDAO = new UsuarioDAO();
        DepartamentoDAO DepDAO = new DepartamentoDAO();

        Usuario EncarregadoExistente = userDAO.selectEncarregado(Encarregado.getNome(), Encarregado.getTipo());

        //VERIFICA SE HA ALGUM ENCARREGADO CADASTRADO COM O MESMO NOME
        if (EncarregadoExistente == null) {
            //VERIFICA SE O GERENTE ESTAR CADASTRANDO ENCARREGADOS SOMENTE EM SE DEPARTAMENTO
            if (userLogado.getTipo().equals("Gerente") || userLogado.getTipo().equals("Diretor")) {

                if (userLogado.getTipo().equals("Gerente")) {

                    if (Encarregado.getDepartamento().getCodigo().equals(userLogado.getDepartamento().getCodigo())) {
                        userDAO.criaUSER(Encarregado);

                    }

                }

                if (userLogado.getTipo().equals("Diretor")) {
                    userDAO.criaUSER(Encarregado);
                }

            } else {
                throw new excecaoControleAcesso();
            }
        } else {
            throw new excecaoEncarregadoExistente();
        }
    }

    public Usuario selectUmEncarregado(String Nome, String Tipo) throws SQLException {
        UsuarioDAO EncarregadoDAO = new UsuarioDAO();
        Usuario Encarregado = new Usuario();

        Encarregado = EncarregadoDAO.selectEncarregado(Nome, Tipo);

        return Encarregado;

    }

    public Usuario selectTodosEncarregado() throws SQLException {
        UsuarioDAO EncarregadoDAO = new UsuarioDAO();
        Usuario Encarregado = new Usuario();

        Encarregado = EncarregadoDAO.selectTodosEncarregado();

        return Encarregado;

    }

    public ArrayList<String> ComboBoxEncarregado() throws SQLException {

        UsuarioDAO usuarioDAO = new UsuarioDAO();
        ArrayList<String> Encarregado = new ArrayList<>();

        Encarregado = usuarioDAO.cbEncarregado();

        return Encarregado;

    }

    public ArrayList<String> ComboBoxEncarregadoPorDepartamento(String CodDepartamento) throws SQLException {

        UsuarioDAO usuarioDAO = new UsuarioDAO();
        ArrayList<String> Encarregado = new ArrayList<>();

        Encarregado = usuarioDAO.cmbEncarregadosPorDepartamento(CodDepartamento);

        return Encarregado;

    }

    public ResultSet preencheTabelaGerente() throws SQLException {
        UsuarioDAO Gerente = new UsuarioDAO();
        ResultSet resultPreencherTabela = Gerente.preencherTabelaGerente();

        return resultPreencherTabela;

    }

    public ResultSet preencheTabelaEncarregado(String Departamento) throws SQLException {
        UsuarioDAO Encarregado = new UsuarioDAO();
        ResultSet resultPreencherTabela = Encarregado.preencherTabelaEncarregado(Departamento);

        return resultPreencherTabela;

    }

    public ResultSet preencheTabelaEncarregadoPorDepartamento(String CodDepartamento) throws SQLException {
        UsuarioDAO Encarregado = new UsuarioDAO();
        ResultSet resultPreencherTabela = Encarregado.preencherTabelaEncarregadOPordepartamento(CodDepartamento);

        return resultPreencherTabela;

    }

    public ResultSet preencheTabelaEncarregadoStODOS() throws SQLException {
        UsuarioDAO Encarregado = new UsuarioDAO();
        ResultSet resultPreencherTabela = Encarregado.preencherTabelaEncarregadOTodosdepartamento();

        return resultPreencherTabela;

    }

    public ResultSet pesquisaGerente(String NomeGerente) throws SQLException {
        UsuarioDAO Gerente = new UsuarioDAO();
        ResultSet resultPesquisa = Gerente.pesquisaGerente(NomeGerente);

        return resultPesquisa;

    }

    public void UpdateUsuario(Usuario user) throws SQLException {

        UsuarioDAO usuarioDAO = new UsuarioDAO();
        usuarioDAO.AtulizaUsuario(user);

    }

    public void AlteracaoDadosPessoais(Usuario user) throws SQLException {

        UsuarioDAO usuarioDAO = new UsuarioDAO();
        usuarioDAO.AlteracaoDadosPessoais(user);

    }

    public void DeleteGerente(Usuario usuario) throws SQLException, excecaoDeletarElemento {

        UsuarioDAO usuarioDAO = new UsuarioDAO();
        usuarioDAO.DeleteUsuario(usuario);

    }

    public void DeleteEncarregado(Usuario usuario) throws SQLException, excecaoDeletarElemento {

        UsuarioDAO usuarioDAO = new UsuarioDAO();
        usuarioDAO.DeleteUsuario(usuario);

    }

}
