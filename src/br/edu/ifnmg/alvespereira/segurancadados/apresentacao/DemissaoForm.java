package br.edu.ifnmg.alvespereira.segurancadados.apresentacao;

import br.edu.ifnmg.alvespereira.segurancadados.apresentacao.utilitarios.logSegurancaDados;
import br.edu.ifnmg.alvespereira.segurancadados.entidades.Usuario;
import br.edu.ifnmg.alvespereira.segurancadados.excecoes.excecaoDeletarElemento;
import br.edu.ifnmg.alvespereira.segurancadados.negocio.DepartamentoBO;
import br.edu.ifnmg.alvespereira.segurancadados.negocio.UsuarioBO;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;

public class DemissaoForm extends javax.swing.JInternalFrame {

    private static String CodFuncionario = new String();

    private static Usuario userLogado = null;

    public DemissaoForm(Usuario usuarioLogado) {
        initComponents();

        this.userLogado = usuarioLogado;
        this.listaTabela();
        this.popularCmbDepartamentoBuscar();
        this.BTNdemitir.setEnabled(false);

    }

    public void popularCmbDepartamentoBuscar() {
        ArrayList<String> Departamentos = new ArrayList<>();
        DepartamentoBO departamentoBO = new DepartamentoBO();

        if (userLogado.getTipo().equals("Diretor")) {
            try {
                Departamentos = departamentoBO.ComboBoxDepartamentos();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Erro ao popular o departamento",
                        "Departamento", JOptionPane.ERROR_MESSAGE);
            }
        } else {

            try {
                Departamentos = departamentoBO.CMBDepartamento(userLogado.getDepartamento().getCodigo());
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Erro ao popular o departamento",
                        "Departamento", JOptionPane.ERROR_MESSAGE);
            }

        }

        cmbBuscaFuncionario.removeAllItems();
        cmbBuscaFuncionario.addItem("Selecione");
        for (String item : Departamentos) {
            cmbBuscaFuncionario.addItem(item);
        }

    }

    public void listaTabela() {

        UsuarioBO funcionarios = new UsuarioBO();
        if (userLogado.getTipo().equals("Diretor")) {
            try {

                tbResultadoBusca.setModel(DbUtils.resultSetToTableModel(funcionarios.tabeleaFuncionarios()));

            } catch (SQLException ex) {

            }
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelBuscarUsuario = new javax.swing.JPanel();
        cmbBuscaFuncionario = new javax.swing.JComboBox();
        btnBuscar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbResultadoBusca = new javax.swing.JTable();
        BTNdemitir = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setTitle("Demissão de Funcionário");
        setToolTipText("");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/br/edu/ifnmg/alvespereira/segurancadados/icones/11295_128x128.png"))); // NOI18N

        jPanelBuscarUsuario.setBorder(javax.swing.BorderFactory.createTitledBorder(null, " Buscar Funcionario por departamento", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12), new java.awt.Color(0, 102, 102))); // NOI18N

        cmbBuscaFuncionario.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbBuscaFuncionario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cmbBuscaFuncionarioKeyPressed(evt);
            }
        });

        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/edu/ifnmg/alvespereira/segurancadados/icones/7181_16x16.png"))); // NOI18N
        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelBuscarUsuarioLayout = new javax.swing.GroupLayout(jPanelBuscarUsuario);
        jPanelBuscarUsuario.setLayout(jPanelBuscarUsuarioLayout);
        jPanelBuscarUsuarioLayout.setHorizontalGroup(
            jPanelBuscarUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelBuscarUsuarioLayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(cmbBuscaFuncionario, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );
        jPanelBuscarUsuarioLayout.setVerticalGroup(
            jPanelBuscarUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelBuscarUsuarioLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelBuscarUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbBuscaFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tbResultadoBusca.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tbResultadoBusca.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbResultadoBuscaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbResultadoBusca);

        BTNdemitir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/edu/ifnmg/alvespereira/segurancadados/icones/bouton-erreur-icone-3840-32.png"))); // NOI18N
        BTNdemitir.setText("Demitir");
        BTNdemitir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTNdemitirActionPerformed(evt);
            }
        });

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/edu/ifnmg/alvespereira/segurancadados/icones/bullet-aller-icone-7275-32.png"))); // NOI18N
        jButton2.setText("Ok");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(73, 73, 73)
                .addComponent(BTNdemitir)
                .addGap(18, 18, 18)
                .addComponent(jButton2)
                .addContainerGap(303, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 556, Short.MAX_VALUE)
                        .addComponent(jPanelBuscarUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addContainerGap()))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(316, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BTNdemitir)
                    .addComponent(jButton2))
                .addGap(33, 33, 33))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(17, 17, 17)
                    .addComponent(jPanelBuscarUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(87, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cmbBuscaFuncionarioKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cmbBuscaFuncionarioKeyPressed

    }//GEN-LAST:event_cmbBuscaFuncionarioKeyPressed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        if (cmbBuscaFuncionario.getSelectedItem().equals("Selecione")) {
            JOptionPane.showMessageDialog(null, "Erro selecione o departamento",
                    "Departamento", JOptionPane.ERROR_MESSAGE);

        } else {
            String departamento = this.cmbBuscaFuncionario.getSelectedItem().toString();
            UsuarioBO encarregado = new UsuarioBO();

            try {
                tbResultadoBusca.setModel(DbUtils.resultSetToTableModel(encarregado.preencheTabelaEncarregado(departamento)));
            } catch (SQLException ex) {

            }
        }

    }//GEN-LAST:event_btnBuscarActionPerformed

    private void tbResultadoBuscaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbResultadoBuscaMouseClicked

        int seleciona = tbResultadoBusca.getSelectedRow();

        CodFuncionario = (tbResultadoBusca.getModel().getValueAt(seleciona, 0).toString());
        this.BTNdemitir.setEnabled(true);

    }//GEN-LAST:event_tbResultadoBuscaMouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.dispose();

    }//GEN-LAST:event_jButton2ActionPerformed

    private void BTNdemitirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTNdemitirActionPerformed

        int CodFuncionario = Integer.parseInt(this.CodFuncionario);

        Usuario usuario = new Usuario();
        UsuarioBO usuarioBO = new UsuarioBO();

        try {
            usuarioBO.demitirFuncionario(CodFuncionario);
            JOptionPane.showMessageDialog(null, "Funcionario demitido com Sucesso !!!",
                    "Gestão de Usuário", JOptionPane.INFORMATION_MESSAGE);

            logSegurancaDados log = null;
            log = new logSegurancaDados("INFO",
                    "Demissao de funcionario realizada com sucesso pelo "
                    + userLogado.getTipo() + " : " + userLogado.getNome());

            cmbBuscaFuncionario.setSelectedItem("Selecione");

            this.listaTabela();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao demitit  funcionario",
                    "Gestão de Encarregado", JOptionPane.ERROR_MESSAGE);
        } catch (excecaoDeletarElemento ex) {
            JOptionPane.showMessageDialog(null, "Erro ao demitir  funcionario",
                    "Gestão de Encarregado", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_BTNdemitirActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BTNdemitir;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JComboBox cmbBuscaFuncionario;
    private javax.swing.JButton jButton2;
    private javax.swing.JPanel jPanelBuscarUsuario;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbResultadoBusca;
    // End of variables declaration//GEN-END:variables
}
