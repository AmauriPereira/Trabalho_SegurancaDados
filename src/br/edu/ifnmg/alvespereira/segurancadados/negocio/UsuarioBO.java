package br.edu.ifnmg.alvespereira.segurancadados.negocio;

import br.edu.ifnmg.alvespereira.segurancadados.dados.SegurancaDadosDAO;
import br.edu.ifnmg.alvespereira.segurancadados.entidades.Usuario;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class UsuarioBO {

    // ABAIXO METODOS DE INSERT NO BANCO DE USUÁRIOS
    //INSERT DIRETOR: VERIFICA SE HÁ ALGUM DIRETOR CADASTRADO, CASO NÃO HAJA REALIZA O CADASTRO
    // obs:(SÓ PODE HAVER UM DIRETOR CADASTRADO).
    public void criarDiretor(Usuario Diretor) throws SQLException {
        SegurancaDadosDAO SDD = new SegurancaDadosDAO();

        Usuario userExistente = SDD.selectDiretor();

        if (userExistente == null) {
            SDD.criaUSER(Diretor);
            JOptionPane.showMessageDialog(null, "Diretor Cadastrado com Sucesso !!!",
                    "Cadastro de Diretor", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    //INSERT GERENTE: VERIFICA SE HA ALGUM GERENTE CADASTRADO COM O MESMO NOME, CASO HAJA 
    //INFORMA AO USUARIO DO SISTEMA, CASO NÃO HAJA VERIFICA SE JA EXISTE UM GERENTE CADASTRADO
    //PARA O DEPARTAMENTO SELECIONADO
    public void criarGerente(Usuario Gerente) throws SQLException {
        SegurancaDadosDAO SDD = new SegurancaDadosDAO();
        Usuario GerenteExistente = SDD.selectGerente(Gerente.getNome(), Gerente.getTipo());

        //VERIFICA SE HA ALGUM GERENTE CADASTRADO COM O MESMO NOME
        if (GerenteExistente == null) {
            Usuario gerentePorDepartmento = SDD.selectGerentePorDepartamento(Gerente.getDepartamento(), Gerente.getTipo());
            //VERIFICA SE JA EXISTE UM GERENTE CADASTRADO PARA O DEPARTAMENTO SELECIONADO
            if (gerentePorDepartmento == null) {
                SDD.criaUSER(Gerente);
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
        SegurancaDadosDAO SDD = new SegurancaDadosDAO();
        Usuario EncarregadoExistente = SDD.selectEncarregado(Encarregado.getNome(), Encarregado.getTipo());

        //VERIFICA SE HA ALGUM ENCARREGADO CADASTRADO COM O MESMO NOME
        if (EncarregadoExistente == null) {
            //VERIFICA SE O GERENTE ESTAR CADASTRANDO ENCARREGADOS SOMENTE EM SE DEPARTAMENTO
            if (Encarregado.getDepartamento().equals(userLogado.getDepartamento()) || userLogado.getTipo().equals("Diretor")) {
                SDD.criaUSER(Encarregado);
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

}
