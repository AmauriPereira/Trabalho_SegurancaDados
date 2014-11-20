package br.edu.ifnmg.alvespereira.segurancadados.apresentacao;

import br.edu.ifnmg.alvespereira.segurancadados.entidades.Usuario;
import br.edu.ifnmg.alvespereira.segurancadados.negocio.UsuarioBO;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;


/* ESSA TELA SÓ É INSTANCIADA CASO SEJA A PRIMEIRA VEZ QUE O PROGRAMA ESTAR SENDO EXECUTADO
 OU CASO NÃO TENHA SIDO CADASTRADO NENHUM DIRETOR */
public class CadastroDiretorForm extends javax.swing.JFrame {

    public CadastroDiretorForm() {
        initComponents();
        this.setLocationRelativeTo(null);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanelDados = new javax.swing.JPanel();
        lblNome = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        lblEmail = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        lblSenha = new javax.swing.JLabel();
        txtSenha = new javax.swing.JTextField();
        btnCadastrar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Cadastro Diretor");
        getContentPane().setLayout(new java.awt.GridBagLayout());

        jPanelDados.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Cadastro de Diretor", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.BELOW_TOP, new java.awt.Font("Tahoma", 1, 12), new java.awt.Color(0, 102, 102))); // NOI18N
        jPanelDados.setLayout(new java.awt.GridBagLayout());

        lblNome.setForeground(new java.awt.Color(0, 102, 102));
        lblNome.setText("Nome:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(32, 16, 0, 0);
        jPanelDados.add(lblNome, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 6;
        gridBagConstraints.ipadx = 324;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 16, 0, 16);
        jPanelDados.add(txtNome, gridBagConstraints);

        lblEmail.setForeground(new java.awt.Color(0, 102, 102));
        lblEmail.setText("E-mail:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(11, 16, 0, 0);
        jPanelDados.add(lblEmail, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.ipadx = 194;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 16, 0, 0);
        jPanelDados.add(txtEmail, gridBagConstraints);

        lblSenha.setForeground(new java.awt.Color(0, 102, 102));
        lblSenha.setText("Senha:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(11, 18, 0, 0);
        jPanelDados.add(lblSenha, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.ipadx = 106;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 18, 0, 16);
        jPanelDados.add(txtSenha, gridBagConstraints);

        btnCadastrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/edu/ifnmg/alvespereira/segurancadados/icones/8441_32x32.png"))); // NOI18N
        btnCadastrar.setText("Cadastrar");
        btnCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.ipady = -1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 16, 18, 0);
        jPanelDados.add(btnCadastrar, gridBagConstraints);

        getContentPane().add(jPanelDados, new java.awt.GridBagConstraints());

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // BOTÃO DE CADASTRO DE DIRETOR
    private void btnCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarActionPerformed

        //cria um usuario que sera cadastrado
        Usuario user = new Usuario();

        //variaveis recebem os dados do usuario cadastrados
        String Nome, Email, Senha;
        Nome = (txtNome.getText());
        Email = (txtEmail.getText());
        Senha = (txtSenha.getText());

        //codigo abaixo realiza a criptografia da senha
        MessageDigest cript;
        try {
            cript = MessageDigest.getInstance("SHA-256");
            byte messageDigest[] = cript.digest(Senha.getBytes("UTF-8"));

            StringBuilder hexString = new StringBuilder();
            for (byte b : messageDigest) {
                hexString.append(String.format("%02X", 0xFF & b));
            }
            Senha = hexString.toString();

        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(CadastroDiretorForm.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(CadastroDiretorForm.class.getName()).log(Level.SEVERE, null, ex);
        }

        //seta o usuario que sera cadastrado, 
        //Com os dados armazenados nas variaveis criadas acima
        user.setNome(Nome);
        user.setEmail(Email);
        user.setSenha(Senha);
        user.setTipo("Diretor");

        //Instacia um objeto do tipo usuarioBO 
        //E passa o usuario que será cadastrado no banco(user) como parametro 
        UsuarioBO userBO = new UsuarioBO();
        try {
            userBO.criarDiretor(user);
        } catch (SQLException ex) {
            Logger.getLogger(CadastroDiretorForm.class.getName()).log(Level.SEVERE, null, ex);
        }


    }//GEN-LAST:event_btnCadastrarActionPerformed

    public static void main(String args[]) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {

        //Altera o tipo de Designer do software para Ninbus 
        for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
            if ("Nimbus".equals(info.getName())) {
                UIManager.setLookAndFeel(info.getClassName());
                break;
            }
        }

        //Verifica se ja existe um diretor cadastrado no sistema
        Usuario user = new Usuario();
        UsuarioBO UserBO = new UsuarioBO();
        user = UserBO.selecionarDiretor();

        //Caso não exista nenhum diretor cadastrado 
        //Instancia uma tela de cadastro de diretor e seta como visible.
        if (user == null) {
            java.awt.EventQueue.invokeLater(new Runnable() {

                @Override

                public void run() {
                    new CadastroDiretorForm().setVisible(true);

                }

            });
        }

        //Caso exista um diretor cadastrado 
        //Instancia uma tela login e seta como visible.
        if (user != null) {
            java.awt.EventQueue.invokeLater(new Runnable() {
                @Override

                public void run() {
                    new Login().setVisible(true);

                }

            });

        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCadastrar;
    private javax.swing.JPanel jPanelDados;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblSenha;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtSenha;
    // End of variables declaration//GEN-END:variables
}
