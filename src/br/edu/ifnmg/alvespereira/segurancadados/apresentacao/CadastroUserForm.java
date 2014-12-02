package br.edu.ifnmg.alvespereira.segurancadados.apresentacao;

import br.edu.ifnmg.alvespereira.segurancadados.apresentacao.utilitarios.ValidacaoEmail;
import br.edu.ifnmg.alvespereira.segurancadados.apresentacao.utilitarios.criptografiaUtil;
import br.edu.ifnmg.alvespereira.segurancadados.entidades.Departamento;
import br.edu.ifnmg.alvespereira.segurancadados.entidades.Usuario;
import br.edu.ifnmg.alvespereira.segurancadados.excecoes.excecaoControleAcesso;
import br.edu.ifnmg.alvespereira.segurancadados.excecoes.excecaoEncarregadoExistente;
import br.edu.ifnmg.alvespereira.segurancadados.excecoes.excecaoGerenteExistente;
import br.edu.ifnmg.alvespereira.segurancadados.excecoes.excecaoGerentePorDepartamento;
import br.edu.ifnmg.alvespereira.segurancadados.negocio.DepartamentoBO;
import br.edu.ifnmg.alvespereira.segurancadados.negocio.UsuarioBO;
import java.awt.Dimension;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;

public final class CadastroUserForm extends javax.swing.JInternalFrame {

    private static Usuario usuarioLogado = new Usuario();

    //Tela de Cadastro de usuários(Encarregado e Gerente)
    public CadastroUserForm(String TipoUser, Usuario usurioLogado) {
        initComponents();
        //O usuario logado é quem estar cadastrando o Gerente ou Encarregado
        this.usuarioLogado = usurioLogado;
        //Chama método que add todos os departamento na ComboBox
        this.popularCB();
        //Seta o campo de Tipo de usuário de acordo o parametro recebido(TipoUser)
        this.txtTipoUser.setText(TipoUser);

    }

    //Metodo que add todos os departamentos cadastrados na ComboBox
    public void popularCB() {
        ArrayList<String> Departamentos = new ArrayList<>();
        DepartamentoBO depBO = new DepartamentoBO();

        if (usuarioLogado.getTipo().equals("Diretor")) {
            try {
                Departamentos = depBO.ComboBoxDepartamentos();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Erro ao popular o departamento",
                        "Departamento", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            try {
                Departamentos = depBO.CMBDepartamento(usuarioLogado.getDepartamento().getCodigo());
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Erro ao popular o departamento",
                        "Departamento", JOptionPane.ERROR_MESSAGE);
            }
        }

        cbDepartamentos.removeAllItems();
        cbDepartamentos.addItem("Selecione");
        for (String item : Departamentos) {
            cbDepartamentos.addItem(item);
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelCadastroUsuario = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        txtSenha = new javax.swing.JPasswordField();
        jLabel5 = new javax.swing.JLabel();
        cbDepartamentos = new javax.swing.JComboBox();
        btnCadastrar = new javax.swing.JButton();
        txtTipoUser = new javax.swing.JTextField();

        setClosable(true);
        setIconifiable(true);
        setTitle("Cadastro de Usuário");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/br/edu/ifnmg/alvespereira/segurancadados/icones/11295_128x128.png"))); // NOI18N

        jPanelCadastroUsuario.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Dados do Usuário", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.BELOW_TOP, new java.awt.Font("Tahoma", 1, 12), new java.awt.Color(0, 102, 102))); // NOI18N

        jLabel1.setText("Tipo de Usuário:");

        jLabel2.setText("Nome:");

        jLabel3.setText("Email:");

        jLabel4.setText("Senha:");

        jLabel5.setText("Departamento:");

        cbDepartamentos.setModel(new javax.swing.DefaultComboBoxModel(new String[] {  }));
        cbDepartamentos.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                cbDepartamentosFocusGained(evt);
            }
        });

        btnCadastrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/edu/ifnmg/alvespereira/segurancadados/icones/8441_32x32.png"))); // NOI18N
        btnCadastrar.setText("Cadastrar");
        btnCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarActionPerformed(evt);
            }
        });

        txtTipoUser.setEditable(false);
        txtTipoUser.setBackground(new java.awt.Color(204, 204, 204));

        javax.swing.GroupLayout jPanelCadastroUsuarioLayout = new javax.swing.GroupLayout(jPanelCadastroUsuario);
        jPanelCadastroUsuario.setLayout(jPanelCadastroUsuarioLayout);
        jPanelCadastroUsuarioLayout.setHorizontalGroup(
            jPanelCadastroUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelCadastroUsuarioLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelCadastroUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelCadastroUsuarioLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtTipoUser))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelCadastroUsuarioLayout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cbDepartamentos, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanelCadastroUsuarioLayout.createSequentialGroup()
                        .addGroup(jPanelCadastroUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanelCadastroUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtEmail)
                            .addComponent(txtNome)
                            .addGroup(jPanelCadastroUsuarioLayout.createSequentialGroup()
                                .addComponent(txtSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 125, Short.MAX_VALUE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelCadastroUsuarioLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnCadastrar)
                        .addGap(107, 107, 107)))
                .addContainerGap())
        );
        jPanelCadastroUsuarioLayout.setVerticalGroup(
            jPanelCadastroUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelCadastroUsuarioLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanelCadastroUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtTipoUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanelCadastroUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanelCadastroUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanelCadastroUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanelCadastroUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(cbDepartamentos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addComponent(btnCadastrar)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelCadastroUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelCadastroUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cbDepartamentosFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cbDepartamentosFocusGained
        this.popularCB();
    }//GEN-LAST:event_cbDepartamentosFocusGained

    // BOTÃO DE CADASTRO DE usuarios(GERENTE E ENCARREGADO)
    private void btnCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarActionPerformed
        if (txtNome.getText().equals("") || txtSenha.getText().equals("")
                || txtEmail.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Não foi possivel realizar o cadastro \n Preencha todos os campos",
                    "Cadastro de Gerente", JOptionPane.ERROR_MESSAGE);
        } else {
            if (cbDepartamentos.getSelectedItem().equals("Selecione")) {
                JOptionPane.showMessageDialog(null, "Não foi possivel realizar o cadastro \n Selecione um Departamento",
                        "Cadastro de Gerente", JOptionPane.ERROR_MESSAGE);
            } else {
                boolean emailValidado;
                ValidacaoEmail validacao = new ValidacaoEmail();
                emailValidado = validacao.validaEmail(txtEmail.getText());

                if (emailValidado == true) {
                    String TipoUser = txtTipoUser.getText();
                    String Email = txtEmail.getText();
                    String Nome = txtNome.getText();
                    String Senha = txtSenha.getText();

                    Departamento departamento = new Departamento();
                    DepartamentoBO depBO = new DepartamentoBO();

                    try {
                        departamento = depBO.selectDepartamento(cbDepartamentos.getSelectedItem() + "");
                    } catch (SQLException ex) {
                        JOptionPane.showMessageDialog(null, "Erro ao selecionar o departamento",
                                "Cadastro de usuários", JOptionPane.ERROR_MESSAGE);
                    }

                    //codigo abaixo chama mtodo q realiza a criptografia da senha
                    criptografiaUtil criptografiaSenha = new criptografiaUtil();
                    Senha = criptografiaSenha.criptografiaSenha(Senha);

                    Usuario userCadastro = new Usuario();
                    //seta o usuario que sera cadastrado, 
                    //Com os dados armazenados nas variaveis criadas acima
                    userCadastro.setNome(Nome);
                    userCadastro.setEmail(Email);
                    userCadastro.setSenha(Senha);
                    userCadastro.setTipo(TipoUser);
                    userCadastro.setDepartamento(departamento);

                    UsuarioBO UsuarioBO = new UsuarioBO();

                    if (txtTipoUser.getText().equals("Gerente")) {
                        try {
                            UsuarioBO.criarGerente(userCadastro);
                            JOptionPane.showMessageDialog(null, "Gerente Cadastrado com Sucesso !!!",
                                    "Cadastro de Gerente", JOptionPane.INFORMATION_MESSAGE);
                            txtNome.setText("");

                            txtEmail.setText("");
                            txtSenha.setText("");

                            cbDepartamentos.setSelectedItem("Selecione");
                        } catch (SQLException ex) {

                        } catch (excecaoGerenteExistente ex) {
                            JOptionPane.showMessageDialog(null, "Não foi possivel cadastrar Gerente, \n"
                                    + " Ja existe um gerente cadastrado com este Nome",
                                    "Cadastro de Gerente", JOptionPane.ERROR_MESSAGE);

                        } catch (excecaoGerentePorDepartamento ex) {
                            JOptionPane.showMessageDialog(null, "Não foi possivel cadastrar Gerente, \n "
                                    + "Ja existe um gerente cadastrado para este DEPARTAMENTO !!!",
                                    "Cadastro de Gerente", JOptionPane.ERROR_MESSAGE);
                        }
                    }

                    if (txtTipoUser.getText().equals("Encarregado")) {
                        try {

                            UsuarioBO.criarEncarregado(userCadastro, usuarioLogado);
                            JOptionPane.showMessageDialog(null, "Encarregado Cadastrado com Sucesso !!!",
                                    "Encarregado de Gerente", JOptionPane.INFORMATION_MESSAGE);
                            txtNome.setText("");

                            txtEmail.setText("");
                            txtSenha.setText("");

                            cbDepartamentos.setSelectedItem("Selecione");

                        } catch (SQLException ex) {

                        } catch (excecaoEncarregadoExistente ex) {
                            JOptionPane.showMessageDialog(null, "Não foi possivel cadastrar Encarregado, \n "
                                    + "Ja existe um Encarregado cadastrado com este Nome",
                                    "Cadastro de Encarregado", JOptionPane.ERROR_MESSAGE);
                        } catch (excecaoControleAcesso ex) {
                            JOptionPane.showMessageDialog(null, "Não foi possivel cadastrar Encarregado, \n "
                                    + "Você não possui previlégios para cadastrar Encarregados",
                                    "Cadastro de Encarregado", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Email Inválido !!!", "Cadastro de Usuario", JOptionPane.ERROR_MESSAGE);

                }
            }
        }

    }//GEN-LAST:event_btnCadastrarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCadastrar;
    private javax.swing.JComboBox cbDepartamentos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanelCadastroUsuario;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtNome;
    private javax.swing.JPasswordField txtSenha;
    private javax.swing.JTextField txtTipoUser;
    // End of variables declaration//GEN-END:variables
}
