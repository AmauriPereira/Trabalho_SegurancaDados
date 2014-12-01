package br.edu.ifnmg.alvespereira.segurancadados.apresentacao;

import br.edu.ifnmg.alvespereira.segurancadados.entidades.Atividade;
import br.edu.ifnmg.alvespereira.segurancadados.entidades.Projeto;
import br.edu.ifnmg.alvespereira.segurancadados.entidades.Usuario;
import br.edu.ifnmg.alvespereira.segurancadados.negocio.AtividadeBO;
import br.edu.ifnmg.alvespereira.segurancadados.negocio.ProjetoBO;
import br.edu.ifnmg.alvespereira.segurancadados.negocio.UsuarioBO;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;

public class GerenciarAtvidadeFom extends javax.swing.JInternalFrame {

    private static Usuario UserLogado = null;

    public GerenciarAtvidadeFom(Usuario usuarioLogado) {
        initComponents();
        UserLogado = usuarioLogado;
        this.popularCbProjeto();
        this.popularCbEncarregado();
        this.listarAtividadesGETSAO();
        this.btnSalvarAlteracoes.setEnabled(false);
        this.btnExcluir.setEnabled(false);

    }

    public void popularCbProjeto() {
        ArrayList<String> Projetos = new ArrayList<>();
        ProjetoBO projetoBO = new ProjetoBO();

        try {
            Projetos = projetoBO.CMBProjeto(UserLogado.getDepartamento().getCodigo());

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao popular o projetos",
                    "Projetos", JOptionPane.ERROR_MESSAGE);
        }

        cmbProjeto.removeAllItems();
        cmbBuscarProjeto.removeAllItems();
        cmbProjeto.addItem("Selecione");
        cmbBuscarProjeto.addItem("Selecione");

        for (String item : Projetos) {
            cmbProjeto.addItem(item);
            cmbBuscarProjeto.addItem(item);

        }

    }

    public void popularCbEncarregado() {
        ArrayList<String> Encarregado = new ArrayList<>();
        UsuarioBO EncarregadoBO = new UsuarioBO();

        try {
            Encarregado = EncarregadoBO.ComboBoxEncarregadoPorDepartamento(UserLogado.getDepartamento().getCodigo());

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao popular os Encarregados",
                    "Projetos", JOptionPane.ERROR_MESSAGE);
        }

        cmbEncarregado.removeAllItems();
        cmbEncarregado.addItem("Selecione");
        for (String item : Encarregado) {
            cmbEncarregado.addItem(item);
        }

    }

    public void listarAtividadesGETSAO() {
        AtividadeBO atividade = new AtividadeBO();

        try {
            tblAtividades.setModel(DbUtils.resultSetToTableModel(atividade.preencherTabelaAtividadeGESTAO(UserLogado.getDepartamento().getCodigo())));
        } catch (SQLException ex) {

        }

    }

    public void listarAtividadesPesquisadasGETSAO() {
        AtividadeBO atividade = new AtividadeBO();

        try {
            tblAtividades.setModel(DbUtils.resultSetToTableModel(atividade.preencherTabelaAtividadesPesquisadasGESTAO(cmbBuscarProjeto.getSelectedItem() + "",
                    UserLogado.getDepartamento().getCodigo())));
        } catch (SQLException ex) {

        }

    }

    public void preencher() {
        int seleciona = tblAtividades.getSelectedRow();

        txtIDatividade.setText(tblAtividades.getModel().getValueAt(seleciona, 0).toString());
        txtNome.setText(tblAtividades.getModel().getValueAt(seleciona, 1).toString());
        txtDuracao.setText(tblAtividades.getModel().getValueAt(seleciona, 4).toString());

        cmbProjeto.setSelectedItem(tblAtividades.getModel().getValueAt(seleciona, 2).toString());
        cmbEncarregado.setSelectedItem(tblAtividades.getModel().getValueAt(seleciona, 3).toString());
    }

    public void limpar() {

        txtIDatividade.setText("");
        txtNome.setText("");
        txtDuracao.setText("");

        cmbProjeto.setSelectedItem("Selecione");
        cmbEncarregado.setSelectedItem("Selecione");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField3 = new javax.swing.JTextField();
        jPanelGerenciarAtividades = new javax.swing.JPanel();
        jPanelBusca = new javax.swing.JPanel();
        cmbBuscarProjeto = new javax.swing.JComboBox();
        btnBuscar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblAtividades = new javax.swing.JTable();
        jPanelDadosAtividades = new javax.swing.JPanel();
        lblNome = new javax.swing.JLabel();
        lblDuracao = new javax.swing.JLabel();
        lblProjeto = new javax.swing.JLabel();
        lblEncarregado = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        txtDuracao = new javax.swing.JTextField();
        cmbProjeto = new javax.swing.JComboBox();
        cmbEncarregado = new javax.swing.JComboBox();
        btnExcluir = new javax.swing.JButton();
        btnSalvarAlteracoes = new javax.swing.JButton();
        txtIDatividade = new javax.swing.JTextField();
        lblDuracao1 = new javax.swing.JLabel();
        btnOk = new javax.swing.JButton();

        jTextField3.setText("jTextField3");

        setClosable(true);
        setIconifiable(true);
        setTitle("Gerênciar Atividades");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/br/edu/ifnmg/alvespereira/segurancadados/icones/11295_128x128.png"))); // NOI18N

        jPanelBusca.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Buscar por projeto", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12), new java.awt.Color(0, 102, 102))); // NOI18N

        cmbBuscarProjeto.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/edu/ifnmg/alvespereira/segurancadados/icones/7181_16x16.png"))); // NOI18N
        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelBuscaLayout = new javax.swing.GroupLayout(jPanelBusca);
        jPanelBusca.setLayout(jPanelBuscaLayout);
        jPanelBuscaLayout.setHorizontalGroup(
            jPanelBuscaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelBuscaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cmbBuscarProjeto, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(btnBuscar)
                .addContainerGap())
        );
        jPanelBuscaLayout.setVerticalGroup(
            jPanelBuscaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelBuscaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelBuscaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbBuscarProjeto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tblAtividades.setModel(new javax.swing.table.DefaultTableModel(
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
        tblAtividades.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblAtividadesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblAtividades);

        jPanelDadosAtividades.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Dados da atividade selecionada", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12), new java.awt.Color(0, 102, 102))); // NOI18N

        lblNome.setText("Nome:");

        lblDuracao.setText("Duração (HH.mm):");

        lblProjeto.setText("Projeto:");

        lblEncarregado.setText("Encarregado:");

        txtDuracao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDuracaoActionPerformed(evt);
            }
        });

        cmbProjeto.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cmbEncarregado.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btnExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/edu/ifnmg/alvespereira/segurancadados/icones/8443_32x32.png"))); // NOI18N
        btnExcluir.setText("Excluir");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        btnSalvarAlteracoes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/edu/ifnmg/alvespereira/segurancadados/icones/filesave-icone-8124-32.png"))); // NOI18N
        btnSalvarAlteracoes.setText("Salvar Alterações");
        btnSalvarAlteracoes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarAlteracoesActionPerformed(evt);
            }
        });

        txtIDatividade.setEditable(false);
        txtIDatividade.setBackground(new java.awt.Color(204, 204, 204));
        txtIDatividade.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtIDatividade.setForeground(new java.awt.Color(0, 102, 102));
        txtIDatividade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIDatividadeActionPerformed(evt);
            }
        });

        lblDuracao1.setText("Código:");

        javax.swing.GroupLayout jPanelDadosAtividadesLayout = new javax.swing.GroupLayout(jPanelDadosAtividades);
        jPanelDadosAtividades.setLayout(jPanelDadosAtividadesLayout);
        jPanelDadosAtividadesLayout.setHorizontalGroup(
            jPanelDadosAtividadesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelDadosAtividadesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelDadosAtividadesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblDuracao)
                    .addComponent(lblProjeto)
                    .addComponent(lblEncarregado)
                    .addComponent(lblDuracao1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanelDadosAtividadesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanelDadosAtividadesLayout.createSequentialGroup()
                        .addComponent(txtIDatividade)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblNome)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanelDadosAtividadesLayout.createSequentialGroup()
                        .addComponent(btnSalvarAlteracoes)
                        .addGap(18, 18, 18)
                        .addComponent(btnExcluir))
                    .addComponent(cmbProjeto, 0, 335, Short.MAX_VALUE)
                    .addComponent(txtDuracao, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbEncarregado, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanelDadosAtividadesLayout.setVerticalGroup(
            jPanelDadosAtividadesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDadosAtividadesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelDadosAtividadesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNome)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtIDatividade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblDuracao1))
                .addGap(18, 18, 18)
                .addGroup(jPanelDadosAtividadesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDuracao)
                    .addComponent(txtDuracao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanelDadosAtividadesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblProjeto)
                    .addComponent(cmbProjeto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(jPanelDadosAtividadesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEncarregado)
                    .addComponent(cmbEncarregado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanelDadosAtividadesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnExcluir)
                    .addComponent(btnSalvarAlteracoes))
                .addContainerGap())
        );

        jPanelDadosAtividadesLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnExcluir, btnSalvarAlteracoes});

        btnOk.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/edu/ifnmg/alvespereira/segurancadados/icones/bullet-aller-icone-7275-32.png"))); // NOI18N
        btnOk.setText("Ok");
        btnOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOkActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelGerenciarAtividadesLayout = new javax.swing.GroupLayout(jPanelGerenciarAtividades);
        jPanelGerenciarAtividades.setLayout(jPanelGerenciarAtividadesLayout);
        jPanelGerenciarAtividadesLayout.setHorizontalGroup(
            jPanelGerenciarAtividadesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelGerenciarAtividadesLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnOk)
                .addGap(32, 32, 32))
            .addGroup(jPanelGerenciarAtividadesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelGerenciarAtividadesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanelBusca, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanelDadosAtividades, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(jPanelGerenciarAtividadesLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelGerenciarAtividadesLayout.setVerticalGroup(
            jPanelGerenciarAtividadesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelGerenciarAtividadesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelBusca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(jPanelDadosAtividades, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnOk, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelGerenciarAtividades, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelGerenciarAtividades, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOkActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnOkActionPerformed

    private void txtDuracaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDuracaoActionPerformed

    }//GEN-LAST:event_txtDuracaoActionPerformed

    private void btnSalvarAlteracoesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarAlteracoesActionPerformed
        if (cmbProjeto.getSelectedItem().equals("Selecione")) {
            JOptionPane.showMessageDialog(null, "Erro selecione o Projeto",
                    "Gestão de Atividade", JOptionPane.ERROR_MESSAGE);
        } else {

            if (cmbEncarregado.getSelectedItem().equals("Selecione")) {
                JOptionPane.showMessageDialog(null, "Erro selecione o Encarregado",
                        "Gestão de Atividade", JOptionPane.ERROR_MESSAGE);
            } else {

                //Tela de Cadastro de Atividades
                String Nome = txtNome.getText();
                float Horas = Float.parseFloat(txtDuracao.getText());

                Float Duracao = Horas;
                int CodAtividade = Integer.parseInt(txtIDatividade.getText());

                ///Busca o Encarregado referente ao nome selecionado na combobox encarregado
                //e armazena os dados na variavel encarregado
                Usuario encarregado = null;

                try {
                    UsuarioBO EncarregadoBO = new UsuarioBO();
                    encarregado = EncarregadoBO.selectUmEncarregado(cmbEncarregado.getSelectedItem() + "", "Encarregado");
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Erro ao selecionar o Encarregado",
                            "Cadastro de Atividade", JOptionPane.ERROR_MESSAGE);
                }

                //Busca o projeto referente ao nome selecionado na combobox projeto
                //e armazena os dados na variavel projet
                Projeto projet = null;

                try {
                    ProjetoBO projetBO = new ProjetoBO();
                    projet = projetBO.selectUmProjeto(cmbProjeto.getSelectedItem() + "");
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Erro ao selecionar o Projeto",
                            "Cadastro de Atividade", JOptionPane.ERROR_MESSAGE);
                }

                //Cria a variavel do tipo atividade e seta os dados na mesma
                Atividade atividade = new Atividade();
                atividade.setNome(Nome);
                atividade.setDuracao(Duracao);
                atividade.setEncarregado(encarregado);
                atividade.setProjeto(projet);
                atividade.setIdAtividade(CodAtividade);

                try {
                    AtividadeBO AtividadeBO = new AtividadeBO();
                    AtividadeBO.UpdateAtividade(atividade);
                    JOptionPane.showMessageDialog(null, "Atividade Atualizada com Sucesso !!!",
                            "Gestao de Atividade", JOptionPane.INFORMATION_MESSAGE);
                    this.listarAtividadesGETSAO();
                    this.btnSalvarAlteracoes.setEnabled(false);
                    this.btnExcluir.setEnabled(false);
                    this.limpar();
                } catch (SQLException ex) {

                }

            }

        }
    }//GEN-LAST:event_btnSalvarAlteracoesActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        if (cmbBuscarProjeto.getSelectedItem().equals("Selecione")) {
            JOptionPane.showMessageDialog(null, "Erro selecione o Projeto",
                    "Gestão de Atividade", JOptionPane.ERROR_MESSAGE);

        } else {
            this.listarAtividadesPesquisadasGETSAO();
        }
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void tblAtividadesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblAtividadesMouseClicked
        this.preencher();
        this.btnSalvarAlteracoes.setEnabled(true);
        this.btnExcluir.setEnabled(true);

    }//GEN-LAST:event_tblAtividadesMouseClicked

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        if (cmbProjeto.getSelectedItem().equals("Selecione")) {
            JOptionPane.showMessageDialog(null, "Erro selecione o Projeto",
                    "Gestão de Atividade", JOptionPane.ERROR_MESSAGE);
        } else {

            if (cmbEncarregado.getSelectedItem().equals("Selecione")) {
                JOptionPane.showMessageDialog(null, "Erro selecione o Encarregado",
                        "Gestão de Atividade", JOptionPane.ERROR_MESSAGE);
            } else {
                AtividadeBO atividadeBO = new AtividadeBO();
                int IDatividade = Integer.parseInt(txtIDatividade.getText());

                try {
                    atividadeBO.deleteAtividade(IDatividade);
                    JOptionPane.showMessageDialog(null, "Atividade Deletada com Sucesso !!!",
                            "Gestao de Atividade", JOptionPane.INFORMATION_MESSAGE);
                    this.listarAtividadesGETSAO();
                    this.btnSalvarAlteracoes.setEnabled(false);
                    this.btnExcluir.setEnabled(false);
                    this.limpar();
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Erro ao deletar atividade !!!",
                            "Gestao de Atividade", JOptionPane.INFORMATION_MESSAGE);
                }

            }

        }
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void txtIDatividadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIDatividadeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIDatividadeActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnOk;
    private javax.swing.JButton btnSalvarAlteracoes;
    private javax.swing.JComboBox cmbBuscarProjeto;
    private javax.swing.JComboBox cmbEncarregado;
    private javax.swing.JComboBox cmbProjeto;
    private javax.swing.JPanel jPanelBusca;
    private javax.swing.JPanel jPanelDadosAtividades;
    private javax.swing.JPanel jPanelGerenciarAtividades;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JLabel lblDuracao;
    private javax.swing.JLabel lblDuracao1;
    private javax.swing.JLabel lblEncarregado;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblProjeto;
    private javax.swing.JTable tblAtividades;
    private javax.swing.JTextField txtDuracao;
    private javax.swing.JTextField txtIDatividade;
    private javax.swing.JTextField txtNome;
    // End of variables declaration//GEN-END:variables
}
