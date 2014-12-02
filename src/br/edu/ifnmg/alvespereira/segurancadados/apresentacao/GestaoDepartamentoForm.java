package br.edu.ifnmg.alvespereira.segurancadados.apresentacao;

import br.edu.ifnmg.alvespereira.segurancadados.apresentacao.utilitarios.logSegurancaDados;
import br.edu.ifnmg.alvespereira.segurancadados.dados.DepartamentoDAO;
import br.edu.ifnmg.alvespereira.segurancadados.entidades.Departamento;
import br.edu.ifnmg.alvespereira.segurancadados.entidades.Usuario;
import br.edu.ifnmg.alvespereira.segurancadados.excecoes.excecaoDeletarElemento;
import br.edu.ifnmg.alvespereira.segurancadados.excecoes.excecaoDepartamento;
import br.edu.ifnmg.alvespereira.segurancadados.negocio.DepartamentoBO;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;

public class GestaoDepartamentoForm extends javax.swing.JInternalFrame {

    private static String CodDepartamentoAntigo = null;
    Usuario usuarioLogado = null;

    public GestaoDepartamentoForm(Usuario userLogado) {
        initComponents();
        this.usuarioLogado = userLogado;
        this.listarDepartamentos();
        this.btnExcluir.setEnabled(false);
        this.btnSalvarAlteracao.setEnabled(false);

    }

    public void listarDepartamentos() {
        DepartamentoDAO departamento = new DepartamentoDAO();

        try {
            tblDepartamentos.setModel(DbUtils.resultSetToTableModel(departamento.PreencheTabelaDepartamentos()));
        } catch (SQLException ex) {

        }

    }

    public void PESQUISADepartamentos() {
        DepartamentoDAO departamento = new DepartamentoDAO();

        try {
            tblDepartamentos.setModel(DbUtils.resultSetToTableModel(departamento.PesquisaNaTabelaDepartamentos(txtPesquisaDepartamento.getText())));
        } catch (SQLException ex) {

        }

    }

    public void PreencherTabela() {
        int seleciona = tblDepartamentos.getSelectedRow();
        txtCodDepartamnento.setText(tblDepartamentos.getModel().getValueAt(seleciona, 0).toString());
        txtNomeDepartamento.setText(tblDepartamentos.getModel().getValueAt(seleciona, 1).toString());

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        txtCodDepartamnento = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtNomeDepartamento = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        txtPesquisaDepartamento = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDepartamentos = new javax.swing.JTable();
        btnExcluir = new javax.swing.JToggleButton();
        btnSalvarAlteracao = new javax.swing.JToggleButton();
        jToggleButton3 = new javax.swing.JToggleButton();

        setClosable(true);
        setIconifiable(true);
        setTitle("Gestão de Departamentos");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/br/edu/ifnmg/alvespereira/segurancadados/icones/11295_128x128.png"))); // NOI18N

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Atividades", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12), new java.awt.Color(0, 102, 102))); // NOI18N

        txtCodDepartamnento.setEditable(false);
        txtCodDepartamnento.setBackground(new java.awt.Color(204, 204, 204));
        txtCodDepartamnento.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtCodDepartamnento.setForeground(new java.awt.Color(0, 102, 102));
        txtCodDepartamnento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCodDepartamnentoActionPerformed(evt);
            }
        });

        jLabel2.setText("Codigo :");

        jLabel3.setText("Departamento:");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtCodDepartamnento, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNomeDepartamento, javax.swing.GroupLayout.PREFERRED_SIZE, 319, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCodDepartamnento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtNomeDepartamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Digite o nome do Departamento:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12), new java.awt.Color(0, 102, 102))); // NOI18N

        txtPesquisaDepartamento.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPesquisaDepartamentoKeyReleased(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/edu/ifnmg/alvespereira/segurancadados/icones/7181_16x16.png"))); // NOI18N

        tblDepartamentos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblDepartamentos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDepartamentosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblDepartamentos);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addComponent(txtPesquisaDepartamento, javax.swing.GroupLayout.PREFERRED_SIZE, 341, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel1))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 426, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(33, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPesquisaDepartamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        btnExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/edu/ifnmg/alvespereira/segurancadados/icones/8443_32x32.png"))); // NOI18N
        btnExcluir.setText("Excluir");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        btnSalvarAlteracao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/edu/ifnmg/alvespereira/segurancadados/icones/filesave-icone-8124-32.png"))); // NOI18N
        btnSalvarAlteracao.setText("Salvar Alterações");
        btnSalvarAlteracao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarAlteracaoActionPerformed(evt);
            }
        });

        jToggleButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/edu/ifnmg/alvespereira/segurancadados/icones/bullet-aller-icone-7275-32.png"))); // NOI18N
        jToggleButton3.setText("Ok");
        jToggleButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(75, 75, 75)
                .addComponent(btnSalvarAlteracao)
                .addGap(18, 18, 18)
                .addComponent(btnExcluir)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jToggleButton3)
                .addGap(87, 87, 87))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSalvarAlteracao)
                    .addComponent(btnExcluir))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jToggleButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtCodDepartamnentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodDepartamnentoActionPerformed

    }//GEN-LAST:event_txtCodDepartamnentoActionPerformed

    private void jToggleButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton3ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jToggleButton3ActionPerformed

    private void txtPesquisaDepartamentoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPesquisaDepartamentoKeyReleased
        this.PESQUISADepartamentos();
    }//GEN-LAST:event_txtPesquisaDepartamentoKeyReleased

    private void tblDepartamentosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDepartamentosMouseClicked
        this.PreencherTabela();
        this.CodDepartamentoAntigo = txtCodDepartamnento.getText();
        this.btnExcluir.setEnabled(true);
        this.btnSalvarAlteracao.setEnabled(true);

    }//GEN-LAST:event_tblDepartamentosMouseClicked

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        DepartamentoBO departamentoBO = new DepartamentoBO();
        try {
            departamentoBO.DeleteDepartamento(txtCodDepartamnento.getText());
            JOptionPane.showMessageDialog(null, "Departamento Deletado com Sucesso !!!",
                    "Gestão de Departamento", JOptionPane.INFORMATION_MESSAGE);

            logSegurancaDados log = null;
            log = new logSegurancaDados("INFO",
                    "Exclusão de Departamento realizada com sucesso pelo "
                    + usuarioLogado.getTipo() + " : " + usuarioLogado.getNome());

            txtCodDepartamnento.setText("");
            txtNomeDepartamento.setText("");
            this.listarDepartamentos();
            this.btnExcluir.setEnabled(false);
            this.btnSalvarAlteracao.setEnabled(false);

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao deletar o departamento\n"
                    + " Não é possivel deletar este Departamento",
                    "Gestão de Departamento", JOptionPane.ERROR_MESSAGE);
        } catch (excecaoDeletarElemento ex) {
            JOptionPane.showMessageDialog(null, "Erro ao deletar o departamento\n"
                    + " Não é possivel deletar este Departamento",
                    "Gestão de Departamento", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void btnSalvarAlteracaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarAlteracaoActionPerformed

        Departamento DEP = new Departamento();
        String Nome = txtNomeDepartamento.getText();
        String CodDep = txtCodDepartamnento.getText();

        DEP.setNome(Nome);
        DEP.setCodigo(CodDep);

        DepartamentoBO departamentoBO = new DepartamentoBO();
        try {
            departamentoBO.UpdateDep(DEP);

            JOptionPane.showMessageDialog(null, "Departamento Atuzalido com Sucesso !!!",
                    "Gestão de Departamento", JOptionPane.INFORMATION_MESSAGE);

            logSegurancaDados log = null;
            log = new logSegurancaDados("INFO",
                    "Atualização de Departamento realizada com sucesso pelo "
                    + usuarioLogado.getTipo() + " : " + usuarioLogado.getNome());

            txtCodDepartamnento.setText("");
            txtNomeDepartamento.setText("");
            this.listarDepartamentos();
            this.btnExcluir.setEnabled(false);
            this.btnSalvarAlteracao.setEnabled(false);

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Atualizar o departamento\n"
                    + " Não é possivel Atualizar este Departamento",
                    "Gestão de Departamento", JOptionPane.ERROR_MESSAGE);
        } catch (excecaoDepartamento ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Atualizar o departamento\n"
                    + " Ja Existe um departamento com este nome ou codigo. "
                    + "\n PorFavor Altere !!! ",
                    "Gestão de Departamento", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnSalvarAlteracaoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton btnExcluir;
    private javax.swing.JToggleButton btnSalvarAlteracao;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToggleButton jToggleButton3;
    private javax.swing.JTable tblDepartamentos;
    private javax.swing.JTextField txtCodDepartamnento;
    private javax.swing.JTextField txtNomeDepartamento;
    private javax.swing.JTextField txtPesquisaDepartamento;
    // End of variables declaration//GEN-END:variables
}
