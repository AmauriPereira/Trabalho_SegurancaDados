package br.edu.ifnmg.alvespereira.segurancadados.apresentacao;

import br.edu.ifnmg.alvespereira.segurancadados.apresentacao.utilitarios.ValidacaoEmail;
import br.edu.ifnmg.alvespereira.segurancadados.apresentacao.utilitarios.criptografiaUtil;
import br.edu.ifnmg.alvespereira.segurancadados.apresentacao.utilitarios.logSegurancaDados;
import br.edu.ifnmg.alvespereira.segurancadados.entidades.Departamento;
import br.edu.ifnmg.alvespereira.segurancadados.entidades.Usuario;
import br.edu.ifnmg.alvespereira.segurancadados.negocio.UsuarioBO;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class alterarDadosPessoais extends javax.swing.JInternalFrame {

    private static Usuario usuarioLogado = null;

    public alterarDadosPessoais(Usuario userLogado) {
        initComponents();
        this.usuarioLogado = userLogado;
        this.preencherDadosPessoais();
    }

    public void preencherDadosPessoais() {
        txtEmail.setText(usuarioLogado.getEmail());
        txtNome.setText(usuarioLogado.getNome());
        txtTipoUser.setText(usuarioLogado.getTipo());
        String CodUsuario = String.valueOf(usuarioLogado.getIdUsuario());
        txtCod.setText(CodUsuario);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        cargo = new javax.swing.JLabel();
        txtTipoUser = new javax.swing.JTextField();
        nome = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        email = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        senhaAtual = new javax.swing.JLabel();
        txtSenha = new javax.swing.JPasswordField();
        jButton1 = new javax.swing.JButton();
        cargo1 = new javax.swing.JLabel();
        txtCod = new javax.swing.JTextField();

        setClosable(true);
        setIconifiable(true);
        setTitle("Alteração de Dados Pessoais");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/br/edu/ifnmg/alvespereira/segurancadados/icones/11295_128x128.png"))); // NOI18N

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Dados Pessoais", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12), new java.awt.Color(0, 102, 102))); // NOI18N

        cargo.setText("Cargo:");

        txtTipoUser.setEditable(false);
        txtTipoUser.setBackground(new java.awt.Color(204, 204, 204));

        nome.setText("Nome:");

        email.setText("Email:");

        senhaAtual.setText("Nova Senha:");

        txtSenha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSenhaActionPerformed(evt);
            }
        });

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/edu/ifnmg/alvespereira/segurancadados/icones/filesave-icone-8124-32.png"))); // NOI18N
        jButton1.setText("Salvar Dados Pessoais");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        cargo1.setText("Código:");

        txtCod.setEditable(false);
        txtCod.setBackground(new java.awt.Color(204, 204, 204));
        txtCod.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtCod.setForeground(new java.awt.Color(0, 102, 102));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cargo1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cargo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(email, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(nome, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(senhaAtual, javax.swing.GroupLayout.DEFAULT_SIZE, 73, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtTipoUser, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtEmail, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNome, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(txtSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 127, Short.MAX_VALUE)))
                        .addGap(23, 23, 23))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton1)
                            .addComponent(txtCod, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {cargo, email, nome});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cargo1)
                    .addComponent(txtCod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cargo)
                    .addComponent(txtTipoUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nome)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(email)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(senhaAtual)
                    .addComponent(txtSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(16, 16, 16))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(17, 17, 17))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtSenhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSenhaActionPerformed

    }//GEN-LAST:event_txtSenhaActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (txtNome.getText().equals("")
                || txtEmail.getText().equals("")) {

            JOptionPane.showMessageDialog(null, "Não foi possivel Atualizar o cadastro \n Preencha todos os campos",
                    "Alteração de Dados Pessoais", JOptionPane.ERROR_MESSAGE);
        } else {

            boolean emailValidado;
            ValidacaoEmail validacao = new ValidacaoEmail();
            emailValidado = validacao.validaEmail(txtEmail.getText());

            if (emailValidado == true) {
                int idUsuario;
                String Nome;
                String Email;
                String Tipo;
                String Senha = null;
                Departamento Departamento = null;

                //Seta o Nome e a descrição projeto
                Nome = txtNome.getText();
                Email = txtEmail.getText();
                Tipo = txtTipoUser.getText();
                Senha = txtSenha.getText();

                //codigo abaixo chama mtodo q realiza a criptografia da senha
                criptografiaUtil criptografiaSenha = new criptografiaUtil();
                Senha = criptografiaSenha.criptografiaSenha(Senha);

                //Cria um novo projeto e seta todos os dados
                Usuario usuario = new Usuario();

                usuario.setNome(Nome);
                usuario.setEmail(Email);
                usuario.setSenha(Senha);

                usuario.setTipo(Tipo);

                //Cria um novo objeto do tipo ProjetoBO e 
                //passa como parmetro o projeto que será cadastrado
                UsuarioBO usuarioBO = new UsuarioBO();

                try {
                    usuarioBO.AlteracaoDadosPessoais(usuario);
                    JOptionPane.showMessageDialog(null, "Dados Atualizados com Sucesso !!!",
                            "Alteração de Dados", JOptionPane.INFORMATION_MESSAGE);

                    logSegurancaDados log = null;
                    log = new logSegurancaDados("INFO",
                            "Alteração de Dados Pessoais realizada com sucesso pelo "
                            + usuarioLogado.getTipo() + " : " + usuarioLogado.getNome());

                    txtNome.setText("");

                    txtEmail.setText("");
                    txtSenha.setText("");

                    txtTipoUser.setText("");
                    txtCod.setText("");
                    this.dispose();

                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Erro ao alterar Dados Pessoais",
                            "Alteração de Dados Pessoais", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Email Inválido !!!", "Alteração de Dados Pessoais", JOptionPane.ERROR_MESSAGE);

            }

        }


    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel cargo;
    private javax.swing.JLabel cargo1;
    private javax.swing.JLabel email;
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel nome;
    private javax.swing.JLabel senhaAtual;
    private javax.swing.JTextField txtCod;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtNome;
    private javax.swing.JPasswordField txtSenha;
    private javax.swing.JTextField txtTipoUser;
    // End of variables declaration//GEN-END:variables
}
