package br.edu.ifnmg.alvespereira.segurancadados.negocio;

import br.edu.ifnmg.alvespereira.segurancadados.dados.DepartamentoDAO;
import br.edu.ifnmg.alvespereira.segurancadados.dados.UsuarioDAO;
import br.edu.ifnmg.alvespereira.segurancadados.entidades.Departamento;
import br.edu.ifnmg.alvespereira.segurancadados.entidades.Usuario;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

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
    public void criarGerente(Usuario Gerente) throws SQLException {
        UsuarioDAO userDAO = new UsuarioDAO();
        Usuario GerenteExistente = userDAO.selectGerente(Gerente.getNome(), Gerente.getTipo());

        //VERIFICA SE HA ALGUM GERENTE CADASTRADO COM O MESMO NOME
        if (GerenteExistente == null) {
            Usuario gerentePorDepartmento = userDAO.selectGerentePorDepartamento(Gerente.getDepartamento().getCodigo(), Gerente.getTipo());
            //VERIFICA SE JA EXISTE UM GERENTE CADASTRADO PARA O DEPARTAMENTO SELECIONADO
            if (gerentePorDepartmento == null) {
                userDAO.criaUSER(Gerente);
                JOptionPane.showMessageDialog(null, "Gerente Cadastrado com Sucesso !!!",
                        "Cadastro de Gerente", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Não foi possivel cadastrar Gerente, \n "
                        + "Ja existe um gerente cadastrado para este DEPARTAMENTO !!!",
                        "Cadastro de Gerente", JOptionPane.ERROR_MESSAGE);
            }

        } else {
            JOptionPane.showMessageDialog(null, "Não foi possivel cadastrar Gerente, \n"
                    + " Ja existe um gerente cadastrado com este Nome",
                    "Cadastro de Gerente", JOptionPane.ERROR_MESSAGE);
        }

    }

    //INSERT ENCARREGADO: VERIFICA SE HA ALGUM ENCARREGADO CADASTRADO COM O MESMO NOME, CASO HAJA 
    //INFORMA AO USUARIO DO SISTEMA, VERIFICA SE O GERENTE ESTAR CADASTRANDO O ENCARREGADO 
    //NO SEU DEPARTAMENTO, Obs: GERENTE SÓ PODE CADASTRAR ENCARREGADOS EM SEU DEPARTAMENTO
    public void criarEncarregado(Usuario Encarregado, Usuario userLogado) throws SQLException {
        UsuarioDAO userDAO = new UsuarioDAO();
        DepartamentoDAO DepDAO = new DepartamentoDAO();

        Usuario EncarregadoExistente = userDAO.selectEncarregado(Encarregado.getNome(), Encarregado.getTipo());
        Departamento DEPexistente = DepDAO.selectTodosDepartamentos(); // variavel não está sendo usada..

        //VERIFICA SE HA ALGUM ENCARREGADO CADASTRADO COM O MESMO NOME
        if (EncarregadoExistente == null) {
            //VERIFICA SE O GERENTE ESTAR CADASTRANDO ENCARREGADOS SOMENTE EM SE DEPARTAMENTO
            if (Encarregado.getDepartamento().equals(userLogado.getDepartamento()) || userLogado.getTipo().equals("Diretor")) {
                userDAO.criaUSER(Encarregado);
                JOptionPane.showMessageDialog(null, "Encarregado Cadastrado com Sucesso !!!",
                        "Encarregado de Gerente", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Não foi possivel cadastrar Encarregado, \n "
                        + "Você não possui previlégios para cadastrar Encarregados nesse Departamento", "Cadastro de Encarregado", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Não foi possivel cadastrar Encarregado, \n "
                    + "Ja existe um Encarregado cadastrado com este Nome", "Cadastro de Encarregado", JOptionPane.ERROR_MESSAGE);
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

}
