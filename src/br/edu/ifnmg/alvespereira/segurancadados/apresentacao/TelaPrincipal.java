package br.edu.ifnmg.alvespereira.segurancadados.apresentacao;

import static br.edu.ifnmg.alvespereira.segurancadados.apresentacao.Login.getInstancia;
import br.edu.ifnmg.alvespereira.segurancadados.entidades.Usuario;
import java.awt.Dimension;
import static java.awt.Frame.MAXIMIZED_BOTH;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.Timer;

public class TelaPrincipal extends javax.swing.JFrame {

    // metodo abaixo instancia um Painel de Area de Trabalho(JDP1)
    //O painel JDP1 é area onde os formularios internos vão ser instanciados
    public static JDesktopPane getPainel() {

        return getInstancia().JDP1;

    }

    //Variavel que recebe os dados do usuario que logou no sistema 
    private static Usuario usuarioLogado;

    public TelaPrincipal(Usuario userLogado) {
        initComponents();
        this.setExtendedState(MAXIMIZED_BOTH);
        this.setLocationRelativeTo(null);

        //recebe os dados do usuario que logou no sistema
        this.usuarioLogado = userLogado;

        //Chama o Metodo que configura as insformações da barra de status do sistema
        //(UsuarioLogado, DEparatmento, Função) - hora e data
        this.configBarraStatus();

    }

    //Metodo que configura as insformações da barra de status do sistema
    //(UsuarioLogado, DEparatmento, Função) - hora e data
    private void configBarraStatus() {

        this.txtFuncao.setText(usuarioLogado.getTipo());
        this.txtNomeLogado.setText(usuarioLogado.getNome());

        if (usuarioLogado.getTipo().equals("Diretor")) {
            //Esse teste e feito pois diretor nao possui departamento
            this.txtDEP.setText("   -   ");
        } else {
            this.txtDEP.setText(usuarioLogado.getDepartamento());
        }

    }

    //Metodo configura a posição do formularios internos em relação ao painel(CENTRO)
    //ESSE METODO É CHAMADO SEMPRE QUE O USUARIO ABRE ALGUMA TELA DE FORMULARIO(Cadastro Gerente, Diretor e outras);
    private void centralizaForm(JInternalFrame frame) {

        Dimension desktopSize = JDP1.getSize();
        Dimension jInternalFrameSize = frame.getSize();

        frame.setLocation((desktopSize.width - jInternalFrameSize.width) / 2, (desktopSize.height - jInternalFrameSize.height) / 2);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JDP1 = new javax.swing.JDesktopPane();
        jPanel1 = new javax.swing.JPanel();
        txtFuncao = new javax.swing.JLabel();
        txtNomeLogado = new javax.swing.JLabel();
        Data = new javax.swing.JLabel();
        Hora = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtDEP = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem8 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Gestão de Usuários");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        JDP1.setBackground(new java.awt.Color(240, 240, 240));

        javax.swing.GroupLayout JDP1Layout = new javax.swing.GroupLayout(JDP1);
        JDP1.setLayout(JDP1Layout);
        JDP1Layout.setHorizontalGroup(
            JDP1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        JDP1Layout.setVerticalGroup(
            JDP1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 728, Short.MAX_VALUE)
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12), new java.awt.Color(0, 102, 102))); // NOI18N
        jPanel1.setPreferredSize(new java.awt.Dimension(1082, 35));

        txtFuncao.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        txtNomeLogado.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        Data.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        Hora.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/edu/ifnmg/alvespereira/segurancadados/icones/date.png"))); // NOI18N
        jLabel1.setText("Data:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/edu/ifnmg/alvespereira/segurancadados/icones/time.png"))); // NOI18N
        jLabel2.setText("Hora:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/edu/ifnmg/alvespereira/segurancadados/icones/user.png"))); // NOI18N
        jLabel3.setText("Usuário Logado:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("Função:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("Departamento :");

        txtDEP.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNomeLogado, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addComponent(txtDEP, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addComponent(txtFuncao, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Data, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Hora, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(txtNomeLogado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel3)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Data, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Hora, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)))
                    .addComponent(jLabel4)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(txtDEP, javax.swing.GroupLayout.Alignment.TRAILING))
                    .addComponent(txtFuncao, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {Data, Hora, jLabel1, jLabel2, jLabel3, jLabel4, jLabel5, txtDEP, txtFuncao, txtNomeLogado});

        jMenuBar1.setPreferredSize(new java.awt.Dimension(56, 30));

        jMenu1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/edu/ifnmg/alvespereira/segurancadados/icones/dossier-orange-icone-9020-32.png"))); // NOI18N
        jMenu1.setText("   Cadastros      ");

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F1, 0));
        jMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/edu/ifnmg/alvespereira/segurancadados/icones/add-chart-icone-4678-32.png"))); // NOI18N
        jMenuItem1.setText("       Departamento");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem5.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F2, 0));
        jMenuItem5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/edu/ifnmg/alvespereira/segurancadados/icones/bill-homme-personne-utilisateur-icone-6596-32.png"))); // NOI18N
        jMenuItem5.setText("       Gerente");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem5);

        jMenuItem8.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F3, 0));
        jMenuItem8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/edu/ifnmg/alvespereira/segurancadados/icones/garcon-utilisateur-icone-7572-32.png"))); // NOI18N
        jMenuItem8.setText("       Encarregado");
        jMenuItem8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem8ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem8);

        jMenuBar1.add(jMenu1);

        jMenu3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/edu/ifnmg/alvespereira/segurancadados/icones/tous-refresh-reload-onglets-icone-7131-32.png"))); // NOI18N
        jMenu3.setText("    Atualizar     ");

        jMenuItem2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F4, 0));
        jMenuItem2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/edu/ifnmg/alvespereira/segurancadados/icones/0258.png"))); // NOI18N
        jMenuItem2.setText("     Departamento");
        jMenu3.add(jMenuItem2);

        jMenuItem6.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F5, 0));
        jMenuItem6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/edu/ifnmg/alvespereira/segurancadados/icones/users.png"))); // NOI18N
        jMenuItem6.setText("     Usuários");
        jMenu3.add(jMenuItem6);

        jMenuBar1.add(jMenu3);

        jMenu2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/edu/ifnmg/alvespereira/segurancadados/icones/gtk-ltr-undelete-icone-3875-32.png"))); // NOI18N
        jMenu2.setText("    Excluir    ");

        jMenuItem3.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F6, 0));
        jMenuItem3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/edu/ifnmg/alvespereira/segurancadados/icones/35.png"))); // NOI18N
        jMenuItem3.setText("    Departamento");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem3);

        jMenuItem7.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F7, 0));
        jMenuItem7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/edu/ifnmg/alvespereira/segurancadados/icones/users.png"))); // NOI18N
        jMenuItem7.setText("    Usuários");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem7);

        jMenuBar1.add(jMenu2);

        jMenu4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/edu/ifnmg/alvespereira/segurancadados/icones/engrenages-package-systeme-roues-icone-8982-32.png"))); // NOI18N
        jMenu4.setText("      Opções    ");

        jMenuItem4.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F8, 0));
        jMenuItem4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/edu/ifnmg/alvespereira/segurancadados/icones/halte-session-icone-4911-32.png"))); // NOI18N
        jMenuItem4.setText("     Sair           ");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem4);

        jMenuBar1.add(jMenu4);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(JDP1)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(JDP1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed

    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        //metodo que seta a hora e data atual no sistema(Na barra de status)

        this.setExtendedState(MAXIMIZED_BOTH);

        Date DataSistema = new Date();
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        Data.setText(formato.format(DataSistema));

        Timer timer = new Timer(1000, new hora());
        timer.start();

    }//GEN-LAST:event_formWindowOpened

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // Menu - Cadastro > ItemMenu - Departamento 

        //Instancia uma tela de cadastro de Departamento se o usuario que esta logado for Um diretor;
        //caso não seja um diretor é exibida uma mensagem de ao usuario do sistema.
        //Obs: Somente diretor pode cadastrar departamento
        if (usuarioLogado.getTipo().equals("Diretor")) {

            CadastroDepInTform CDIT = null;

            CDIT = new CadastroDepInTform();
            CDIT.setVisible(true);
            centralizaForm(CDIT);
            CDIT.toFront();
            JDP1.add(CDIT);
        } else {
            JOptionPane.showMessageDialog(null, "Você não possui previlégios para acessar \n"
                    + "a Tela de Cadastros de Departamentos!!!", "Cadastro de Departamentos", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        // Menu - Cadastro > ItemMenu - Gerente 

        //Instancia uma tela de cadastro de Gerente se o usuario que esta logado for Um diretor;
        //caso não seja um diretor é exibida uma mensagem ao usuario do sistema.
        //Obs: Somente diretor pode cadastrar Gerente
        String Gerente = "Gerente";
        if (usuarioLogado.getTipo().equals("Diretor")) {

            CadastroUserForm CUF = null;

            try {
                //passa como parametro o tipo de cadastro que será realizado("Gerente")
                CUF = new CadastroUserForm(Gerente, usuarioLogado);
            } catch (SQLException ex) {
                Logger.getLogger(TelaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }
            CUF.setVisible(true);
            centralizaForm(CUF);
            CUF.toFront();
            JDP1.add(CUF);

        } else {
            JOptionPane.showMessageDialog(null, "Você não possui previlégios para acessar \n   "
                    + "a Tela de Cadastros de Gerente!!!", "Cadastro de Gerente", JOptionPane.ERROR_MESSAGE);

        }
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuItem8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem8ActionPerformed
        // Menu - Cadastro > ItemMenu - Encarregado 

        //Instancia uma tela de cadastro de Encarregado 
        //Se o usuario que esta logado for Um diretor ou um Gerente;
        //caso não seja um diretor nem Gerente é exibida uma mensagem ao usuario do sistema.
        //Obs: Somente diretor e gerente podem cadastrar Encarregados.
        String Encarregado = "Encarregado";
        if ((usuarioLogado.getTipo().equals("Diretor")) || (usuarioLogado.getTipo().equals("Gerente"))) {

            CadastroUserForm CUF = null;

            try {
                //passa como parametro o tipo de cadastro que será realizado("Encarregado")
                CUF = new CadastroUserForm(Encarregado, usuarioLogado);
            } catch (SQLException ex) {
                Logger.getLogger(TelaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }
            CUF.setVisible(true);
            centralizaForm(CUF);
            CUF.toFront();
            JDP1.add(CUF);

        } else {
            JOptionPane.showMessageDialog(null, "Você não possui previlégios para acessar \n   "
                    + "a Tela de Cadastros de Encarregado!!!", "Cadastro de Encarregado", JOptionPane.ERROR_MESSAGE);

        }
    }//GEN-LAST:event_jMenuItem8ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem7ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Data;
    private javax.swing.JLabel Hora;
    private javax.swing.JDesktopPane JDP1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel txtDEP;
    private javax.swing.JLabel txtFuncao;
    private javax.swing.JLabel txtNomeLogado;
    // End of variables declaration//GEN-END:variables

    class hora implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            Calendar now = Calendar.getInstance();
            Hora.setText(String.format("%1$tH:%1$tM:%1$tS", now));
        }

    }

}
