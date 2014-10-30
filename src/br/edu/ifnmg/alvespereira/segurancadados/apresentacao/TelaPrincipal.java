package br.edu.ifnmg.alvespereira.segurancadados.apresentacao;

import static br.edu.ifnmg.alvespereira.segurancadados.apresentacao.Login.getInstancia;
import java.awt.Dimension;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;

public class TelaPrincipal extends javax.swing.JFrame {

    public static JDesktopPane getPainel() {

        return getInstancia().JDP1;

    }

    public TelaPrincipal() {
        initComponents();
        this.setExtendedState(MAXIMIZED_BOTH);
        this.setLocationRelativeTo(null);
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
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Gestão de Usuários");

        JDP1.setBackground(new java.awt.Color(240, 240, 240));

        javax.swing.GroupLayout JDP1Layout = new javax.swing.GroupLayout(JDP1);
        JDP1.setLayout(JDP1Layout);
        JDP1Layout.setHorizontalGroup(
            JDP1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        JDP1Layout.setVerticalGroup(
            JDP1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 298, Short.MAX_VALUE)
        );

        jMenuBar1.setPreferredSize(new java.awt.Dimension(56, 30));

        jMenu1.setText("Cadastros");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Opções");
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(JDP1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(JDP1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane JDP1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    // End of variables declaration//GEN-END:variables
}
