package br.edu.ifnmg.alvespereira.segurancadados.apresentacao;

import br.edu.ifnmg.alvespereira.segurancadados.apresentacao.utilitarios.logSegurancaDados;
import br.edu.ifnmg.alvespereira.segurancadados.entidades.Atividade;
import br.edu.ifnmg.alvespereira.segurancadados.entidades.Usuario;
import br.edu.ifnmg.alvespereira.segurancadados.negocio.AtividadeBO;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class LancarHorasAtividadeForm extends javax.swing.JInternalFrame {

    private static Usuario usuarioLogado = new Usuario();

    public LancarHorasAtividadeForm(Usuario userLogado) {
        this.usuarioLogado = userLogado;
        initComponents();
        this.popularCmbAtividade();
    }

    public void popularCmbAtividade() {
        ArrayList<String> Atividade = new ArrayList<>();
        AtividadeBO atividadeBO = new AtividadeBO();

        String nomeUsuario = usuarioLogado.getNome();

        try {
            Atividade = atividadeBO.ComboBoxAtividades(nomeUsuario);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao popular o atividade",
                    "Atividade", JOptionPane.ERROR_MESSAGE);
        }

        cmbAtividade.removeAllItems();
        cmbAtividade.addItem("Selecione");
        for (String item : Atividade) {
            cmbAtividade.addItem(item);
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        cmbAtividade = new javax.swing.JComboBox();
        txtHoras = new javax.swing.JTextField();
        lblHoras = new javax.swing.JLabel();
        lblConclusao = new javax.swing.JLabel();
        txtConclusao = new javax.swing.JTextField();
        btnSalvar = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        jLabel2.setText("jLabel2");

        setClosable(true);
        setIconifiable(true);
        setTitle("Horas Trabalhadas");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/br/edu/ifnmg/alvespereira/segurancadados/icones/11295_128x128.png"))); // NOI18N

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Selecione a Atividade:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12), new java.awt.Color(0, 102, 102))); // NOI18N

        cmbAtividade.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        lblHoras.setText("Horas trabalhadas:");

        lblConclusao.setText("Conclusão (%):");

        btnSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/edu/ifnmg/alvespereira/segurancadados/icones/filesave-icone-8124-32.png"))); // NOI18N
        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/edu/ifnmg/alvespereira/segurancadados/icones/bullet-aller-icone-7275-32.png"))); // NOI18N
        jButton1.setText("Ok");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cmbAtividade, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(lblConclusao, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtConclusao, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                    .addComponent(lblHoras)
                                    .addGap(23, 23, 23)
                                    .addComponent(txtHoras, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(85, 85, 85)
                                .addComponent(btnSalvar)
                                .addGap(18, 18, 18)
                                .addComponent(jButton1)))
                        .addGap(0, 52, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(cmbAtividade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblHoras)
                    .addComponent(txtHoras, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblConclusao)
                    .addComponent(txtConclusao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addContainerGap())
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnSalvar, jButton1});

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        if (txtConclusao.getText().equals("")
                || txtHoras.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Erro ao realizar o Lançamento !!!  \n Por Favor Preencha os Campos",
                    "Lançamento de Atividade", JOptionPane.ERROR_MESSAGE);
        } else {
            if (cmbAtividade.getSelectedItem().equals("Selecione")) {
                JOptionPane.showMessageDialog(null, "Erro ao realizar o Lançamento !!!  \n Por Favor selecione a atividade",
                        "Lançamento de Atividade", JOptionPane.ERROR_MESSAGE);
            } else {
                try {
                    Float Conclusao = Float.parseFloat(txtConclusao.getText());
                    Float HorasTrabalhadas = Float.parseFloat(txtHoras.getText());

                    Atividade atividade = new Atividade();
                    atividade.setConlusao(Conclusao);
                    atividade.setHorasTrabalhadas(HorasTrabalhadas);

                    String AtividadeSelcionada = (String) this.cmbAtividade.getSelectedItem();

                    AtividadeBO atividadeBO = new AtividadeBO();

                    atividadeBO.andamentoAtividade(atividade, AtividadeSelcionada);
                    JOptionPane.showMessageDialog(null, "Lançamento realizado com Sucesso!",
                            "Lançamento de Atividade ", JOptionPane.INFORMATION_MESSAGE);

                    logSegurancaDados log = null;
                    log = new logSegurancaDados("INFO",
                            "Lançamento de Horas na Atividade: " + cmbAtividade.getSelectedItem()
                            + "realizada com sucesso pelo "
                            + usuarioLogado.getTipo() + " : " + usuarioLogado.getNome());

                    txtConclusao.setText("");
                    txtHoras.setText("");
                    cmbAtividade.setSelectedItem("Selecione");

                } catch (SQLException ex) {

                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Digite somente numeros nos campos !!! \n "
                            + "Formato aceitavel(Hrs.Min) - Ex(10.30)",
                            "Cadastro de Atividade", JOptionPane.ERROR_MESSAGE);
                }
            }
        }

    }//GEN-LAST:event_btnSalvarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSalvar;
    private javax.swing.JComboBox cmbAtividade;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblConclusao;
    private javax.swing.JLabel lblHoras;
    private javax.swing.JTextField txtConclusao;
    private javax.swing.JTextField txtHoras;
    // End of variables declaration//GEN-END:variables

}
