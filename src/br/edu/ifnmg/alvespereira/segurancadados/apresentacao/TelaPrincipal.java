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

    public static JDesktopPane getPainel() {

        return getInstancia().JDP1;

    }
    private static String TipoLogado;

    public TelaPrincipal(Usuario userLogado) {
        initComponents();
        this.setExtendedState(MAXIMIZED_BOTH);
        this.setLocationRelativeTo(null);
        TipoLogado = userLogado.getTipo();
        this.LabelTipo.setText(userLogado.getTipo() + " :");
        this.txtNomeLogado.setText(userLogado.getNome());

    }

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
        LabelTipo = new javax.swing.JLabel();
        txtNomeLogado = new javax.swing.JLabel();
        Data = new javax.swing.JLabel();
        Hora = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
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

        LabelTipo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        LabelTipo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/edu/ifnmg/alvespereira/segurancadados/icones/user.png"))); // NOI18N
        LabelTipo.setText("User:");

        txtNomeLogado.setFont(new java.awt.Font("Tahoma", 2, 12)); // NOI18N

        Data.setFont(new java.awt.Font("Tahoma", 2, 12)); // NOI18N

        Hora.setFont(new java.awt.Font("Tahoma", 2, 12)); // NOI18N

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/edu/ifnmg/alvespereira/segurancadados/icones/date.png"))); // NOI18N
        jLabel1.setText("Data:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/edu/ifnmg/alvespereira/segurancadados/icones/time.png"))); // NOI18N
        jLabel2.setText("Hora:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(LabelTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNomeLogado, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 353, Short.MAX_VALUE)
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
                    .addComponent(Data, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Hora, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LabelTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNomeLogado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {Data, Hora, LabelTipo, jLabel1, jLabel2, txtNomeLogado});

        jMenuBar1.setPreferredSize(new java.awt.Dimension(56, 30));

        jMenu1.setText("   Cadastros      ");

        jMenuItem1.setText("Departamento");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem5.setText("Gerente");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem5);

        jMenuItem8.setText("Encarregado");
        jMenuItem8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem8ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem8);

        jMenuBar1.add(jMenu1);

        jMenu3.setText("    Atualizar     ");

        jMenuItem2.setText("Departamento");
        jMenu3.add(jMenuItem2);

        jMenuItem6.setText("Usuários");
        jMenu3.add(jMenuItem6);

        jMenuBar1.add(jMenu3);

        jMenu2.setText("    Excluir    ");

        jMenuItem3.setText("Departamento");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem3);

        jMenuItem7.setText("Usuários");
        jMenu2.add(jMenuItem7);

        jMenuBar1.add(jMenu2);

        jMenu4.setText("      Opções    ");

        jMenuItem4.setText("Sair");
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
        this.setExtendedState(MAXIMIZED_BOTH);

        Date DataSistema = new Date();
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        Data.setText(formato.format(DataSistema));

        Timer timer = new Timer(1000, new hora());
        timer.start();

    }//GEN-LAST:event_formWindowOpened

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        if (TipoLogado.equals("Diretor")) {

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
        String Gerente = "Gerente";

        if (TipoLogado.equals("Diretor")) {

            CadastroUserForm CUF = null;

            try {
                CUF = new CadastroUserForm(Gerente);
            } catch (SQLException ex) {
                Logger.getLogger(TelaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }
            CUF.setVisible(true);
            centralizaForm(CUF);
            CUF.toFront();
            JDP1.add(CUF);

        } else {
            JOptionPane.showMessageDialog(null, "Você não possui previlégios para acessar \n   "
                    + "a Tela de Cadastros de Departamentos!!!", "Cadastro de Departamentos", JOptionPane.ERROR_MESSAGE);

        }
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuItem8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem8ActionPerformed
        String Encarregado = "Encarregado";

        if ((TipoLogado.equals("Diretor")) || (TipoLogado.equals("Gerente"))) {

            CadastroUserForm CUF = null;

            try {
                CUF = new CadastroUserForm(Encarregado);
            } catch (SQLException ex) {
                Logger.getLogger(TelaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }
            CUF.setVisible(true);
            centralizaForm(CUF);
            CUF.toFront();
            JDP1.add(CUF);

        } else {
            JOptionPane.showMessageDialog(null, "Você não possui previlégios para acessar \n   "
                    + "a Tela de Cadastros de Departamentos!!!", "Cadastro de Departamentos", JOptionPane.ERROR_MESSAGE);

        }
    }//GEN-LAST:event_jMenuItem8ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Data;
    private javax.swing.JLabel Hora;
    private javax.swing.JDesktopPane JDP1;
    private javax.swing.JLabel LabelTipo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
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
