package br.edu.ifnmg.alvespereira.segurancadados.apresentacao;

import br.edu.ifnmg.alvespereira.segurancadados.entidades.Departamento;
import br.edu.ifnmg.alvespereira.segurancadados.entidades.Projeto;
import br.edu.ifnmg.alvespereira.segurancadados.entidades.Usuario;
import br.edu.ifnmg.alvespereira.segurancadados.excecoes.ExcecaoprojetoExistente;
import br.edu.ifnmg.alvespereira.segurancadados.excecoes.excecaoDeletarElemento;
import br.edu.ifnmg.alvespereira.segurancadados.negocio.DepartamentoBO;
import br.edu.ifnmg.alvespereira.segurancadados.negocio.ProjetoBO;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;

public class GerenciaProjetos extends javax.swing.JInternalFrame {

    private static Usuario usuarioLogado = new Usuario();

    public GerenciaProjetos(Usuario userLogado) {
        this.usuarioLogado = userLogado;
        initComponents();
        this.listarProjetos();
        this.popularCB();
        this.btnExcluir.setEnabled(false);
        // this.cbDepartamentos.setEditable(false);
        this.btnSalvarAlteracao.setEnabled(false);

    }

    public void listarProjetos() {
        ProjetoBO projet = new ProjetoBO();

        try {
            tbProjetos.setModel(DbUtils.resultSetToTableModel(projet.preencheTabela(usuarioLogado.getDepartamento().getCodigo())));
        } catch (SQLException ex) {

        }

    }

    public void listarPesqProjetos() {
        ProjetoBO projet = new ProjetoBO();

        try {

            tbProjetos.setModel(DbUtils.resultSetToTableModel(projet.pesquisa(txtPesquisaProjetos.getText(), usuarioLogado.getDepartamento().getCodigo())));

        } catch (SQLException ex) {

        }

    }

    public void popularCB() {
        ArrayList<String> Departamentos = new ArrayList<>();
        DepartamentoBO depBO = new DepartamentoBO();

        try {
            Departamentos = depBO.CMBDepartamento(usuarioLogado.getDepartamento().getCodigo());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao popular o departamento",
                    "Departamento", JOptionPane.ERROR_MESSAGE);
        }

        cbDepartamentos.removeAllItems();
        cbDepartamentos.addItem("Selecione");
        for (String item : Departamentos) {
            cbDepartamentos.addItem(item);
        }

    }

    public void preencher() throws Exception {
        int seleciona = tbProjetos.getSelectedRow();

        txtCod.setText(tbProjetos.getModel().getValueAt(seleciona, 0).toString());
        txtNomeProjeto.setText(tbProjetos.getModel().getValueAt(seleciona, 1).toString());
        txtDescricaoProjeto.setText(tbProjetos.getModel().getValueAt(seleciona, 2).toString());

        String data = tbProjetos.getModel().getValueAt(seleciona, 3).toString();
        String DataInicio = formataData(data);
        txtDataInicio.setText(DataInicio);

        data = tbProjetos.getModel().getValueAt(seleciona, 4).toString();
        String DataTermino = formataData(data);
        txtDataTermino.setText(DataTermino);

        cbDepartamentos.setSelectedItem(tbProjetos.getModel().getValueAt(seleciona, 5).toString());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelBusca = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tbProjetos = new javax.swing.JTable();
        txtPesquisaProjetos = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanelDadosProjetos = new javax.swing.JPanel();
        lblNome = new javax.swing.JLabel();
        txtNomeProjeto = new javax.swing.JTextField();
        lblDescricao = new javax.swing.JLabel();
        txtDescricao = new javax.swing.JScrollPane();
        txtDescricaoProjeto = new javax.swing.JTextArea();
        lblDataInicio = new javax.swing.JLabel();
        lblDataTermino = new javax.swing.JLabel();
        cbDepartamentos = new javax.swing.JComboBox();
        lblDepartamento = new javax.swing.JLabel();
        btnSalvarAlteracao = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txtCod = new javax.swing.JTextField();
        txtDataInicio = new javax.swing.JFormattedTextField();
        txtDataTermino = new javax.swing.JFormattedTextField();
        btnOK = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setTitle("Gerenciar Projeto");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/br/edu/ifnmg/alvespereira/segurancadados/icones/11295_128x128.png"))); // NOI18N

        jPanelBusca.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Busca de Projeto", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12), new java.awt.Color(0, 102, 102))); // NOI18N

        tbProjetos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
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
        tbProjetos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbProjetosMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tbProjetos);

        txtPesquisaProjetos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPesquisaProjetosKeyReleased(evt);
            }
        });

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/edu/ifnmg/alvespereira/segurancadados/icones/7181_16x16.png"))); // NOI18N

        jLabel3.setText("Nome do Projeto:");

        javax.swing.GroupLayout jPanelBuscaLayout = new javax.swing.GroupLayout(jPanelBusca);
        jPanelBusca.setLayout(jPanelBuscaLayout);
        jPanelBuscaLayout.setHorizontalGroup(
            jPanelBuscaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelBuscaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelBuscaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelBuscaLayout.createSequentialGroup()
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 547, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelBuscaLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanelBuscaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addGroup(jPanelBuscaLayout.createSequentialGroup()
                                .addComponent(txtPesquisaProjetos, javax.swing.GroupLayout.PREFERRED_SIZE, 353, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel2)))
                        .addGap(136, 136, 136))))
        );
        jPanelBuscaLayout.setVerticalGroup(
            jPanelBuscaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelBuscaLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanelBuscaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPesquisaProjetos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanelBuscaLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jLabel2, txtPesquisaProjetos});

        jPanelDadosProjetos.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Dados do Projeto", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12), new java.awt.Color(0, 102, 102))); // NOI18N

        lblNome.setText("Nome:");

        lblDescricao.setText("Descrição:");

        txtDescricaoProjeto.setColumns(20);
        txtDescricaoProjeto.setRows(5);
        txtDescricao.setViewportView(txtDescricaoProjeto);

        lblDataInicio.setText("Data Início:");

        lblDataTermino.setText("Data Término:");

        cbDepartamentos.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        cbDepartamentos.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbDepartamentos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbDepartamentosActionPerformed(evt);
            }
        });
        cbDepartamentos.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                cbDepartamentosFocusGained(evt);
            }
        });

        lblDepartamento.setText("Departamento:");

        btnSalvarAlteracao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/edu/ifnmg/alvespereira/segurancadados/icones/filesave-icone-8124-32.png"))); // NOI18N
        btnSalvarAlteracao.setText("Salvar Alterações");
        btnSalvarAlteracao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarAlteracaoActionPerformed(evt);
            }
        });

        btnExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/edu/ifnmg/alvespereira/segurancadados/icones/8443_32x32.png"))); // NOI18N
        btnExcluir.setText("Excluir");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        jLabel1.setText("Cod:");

        txtCod.setEditable(false);
        txtCod.setBackground(new java.awt.Color(204, 204, 204));
        txtCod.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtCod.setForeground(new java.awt.Color(0, 102, 102));

        try {
            txtDataInicio.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        try {
            txtDataTermino.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        javax.swing.GroupLayout jPanelDadosProjetosLayout = new javax.swing.GroupLayout(jPanelDadosProjetos);
        jPanelDadosProjetos.setLayout(jPanelDadosProjetosLayout);
        jPanelDadosProjetosLayout.setHorizontalGroup(
            jPanelDadosProjetosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDadosProjetosLayout.createSequentialGroup()
                .addGap(155, 155, 155)
                .addComponent(btnSalvarAlteracao)
                .addGap(34, 34, 34)
                .addComponent(btnExcluir)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelDadosProjetosLayout.createSequentialGroup()
                .addContainerGap(21, Short.MAX_VALUE)
                .addGroup(jPanelDadosProjetosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelDadosProjetosLayout.createSequentialGroup()
                        .addGroup(jPanelDadosProjetosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanelDadosProjetosLayout.createSequentialGroup()
                                .addGroup(jPanelDadosProjetosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblDepartamento, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblDataInicio))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanelDadosProjetosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(cbDepartamentos, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelDadosProjetosLayout.createSequentialGroup()
                                        .addGap(4, 4, 4)
                                        .addComponent(txtDataInicio)
                                        .addGap(18, 18, 18)
                                        .addComponent(lblDataTermino)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtDataTermino, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(137, 137, 137))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelDadosProjetosLayout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtCod, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblNome)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtNomeProjeto, javax.swing.GroupLayout.PREFERRED_SIZE, 387, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelDadosProjetosLayout.createSequentialGroup()
                        .addComponent(txtDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, 536, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        jPanelDadosProjetosLayout.setVerticalGroup(
            jPanelDadosProjetosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDadosProjetosLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanelDadosProjetosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNome)
                    .addComponent(txtNomeProjeto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelDadosProjetosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDataInicio)
                    .addComponent(lblDataTermino)
                    .addComponent(txtDataInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDataTermino, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelDadosProjetosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbDepartamentos, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
                    .addComponent(lblDepartamento))
                .addGap(18, 18, 18)
                .addGroup(jPanelDadosProjetosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSalvarAlteracao)
                    .addComponent(btnExcluir))
                .addContainerGap())
        );

        btnOK.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/edu/ifnmg/alvespereira/segurancadados/icones/bullet-aller-icone-7275-32.png"))); // NOI18N
        btnOK.setText("Ok");
        btnOK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOKActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanelDadosProjetos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanelBusca, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnOK, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jPanelBusca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19)
                .addComponent(jPanelDadosProjetos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnOK, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtPesquisaProjetosKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPesquisaProjetosKeyReleased
        listarPesqProjetos();
    }//GEN-LAST:event_txtPesquisaProjetosKeyReleased

    private void tbProjetosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbProjetosMouseClicked
        this.btnExcluir.setEnabled(true);
        this.btnSalvarAlteracao.setEnabled(true);

        try {
            preencher();
        } catch (Exception ex) {

        }


    }//GEN-LAST:event_tbProjetosMouseClicked

    private void cbDepartamentosFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cbDepartamentosFocusGained
        this.popularCB();
    }//GEN-LAST:event_cbDepartamentosFocusGained

    private void btnSalvarAlteracaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarAlteracaoActionPerformed
        if (txtNomeProjeto.getText().equals("") || txtDescricaoProjeto.getText().equals("")
                || txtDataInicio.getText().equals("  /  /    ")
                || txtDataTermino.getText().equals("  /  /    ")) {

            JOptionPane.showMessageDialog(null, "Prencha todos os Campos !!!",
                    "Cadastro de Projeto", JOptionPane.ERROR_MESSAGE);

        } else {

            if (cbDepartamentos.getSelectedItem().equals("Selecione")) {

                JOptionPane.showMessageDialog(null, "Selecione um Departamento!!!",
                        "Cadastro de Projeto", JOptionPane.ERROR_MESSAGE);
            } else {

                String nome, Descricao;
                Date DataInicio = null, DataTermino = null;
                Departamento departamento = null;

                //Seta o departamento do projeto
                try {
                    DepartamentoBO depBO = new DepartamentoBO();
                    departamento = depBO.selectDepartamento(cbDepartamentos.getSelectedItem() + "");
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Erro ao selecionar o departamento",
                            "Cadastro de usuários", JOptionPane.ERROR_MESSAGE);
                }

                //Seta o Nome e a descrição projeto
                nome = txtNomeProjeto.getText();
                Descricao = txtDescricaoProjeto.getText();
                int CodProjeto = Integer.parseInt(txtCod.getText());

                try {
                    //Converte e seta a data inicio e termino

                    DataInicio = ConverteData(txtDataInicio.getText());
                    DataTermino = ConverteData(txtDataTermino.getText());
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Erro na Data de  Inicio ou Término do projeto",
                            "Cadastro de Projeto", JOptionPane.ERROR_MESSAGE);
                }

                //Cria um novo projeto e seta todos os dados
                Projeto projeto = new Projeto();
                projeto.setNome(nome);
                projeto.setDescricao(Descricao);
                projeto.setDataInicio(DataInicio);
                projeto.setDataTermino(DataTermino);
                projeto.setDepartamento(departamento);
                projeto.setIdProjeto(CodProjeto);

                //Cria um novo objeto do tipo ProjetoBO e 
                //passa como parmetro o projeto que será cadastrado
                ProjetoBO projetBO = new ProjetoBO();

                try {
                    projetBO.UpdateProjeto(projeto);
                    JOptionPane.showMessageDialog(null, "Projeto Atualizado com Sucesso !!!",
                            "Gestão de Projeto", JOptionPane.INFORMATION_MESSAGE);

                    txtNomeProjeto.setText("");
                    txtDescricaoProjeto.setText("");
                    txtDataTermino.setText("");
                    txtDataInicio.setText("");
                    cbDepartamentos.setSelectedItem("Selecione");
                    this.listarProjetos();
                    this.btnExcluir.setEnabled(false);
                    this.btnSalvarAlteracao.setEnabled(false);

                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Erro ao Atualizar projeto",
                            "Gestão de Projeto", JOptionPane.ERROR_MESSAGE);
                } catch (ExcecaoprojetoExistente ex) {
                    JOptionPane.showMessageDialog(null, "Ja existe um projeto com este Nome !!!",
                            "Cadastro de Projeto", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }//GEN-LAST:event_btnSalvarAlteracaoActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        //Cria um novo projeto e seta o ID do  projetoque sera excluido
        Projeto projeto = new Projeto();

        int CodProjeto = Integer.parseInt(txtCod.getText());
        projeto.setIdProjeto(CodProjeto);

        //Cria um novo objeto do tipo ProjetoBO e 
        //passa como parmetro o projeto que será Deletado
        ProjetoBO projetBO = new ProjetoBO();

        try {
            projetBO.DeleteProjeto(projeto);
            JOptionPane.showMessageDialog(null, "Projeto Deletado com Sucesso !!!",
                    "Gestão de Projeto", JOptionPane.INFORMATION_MESSAGE);

            txtNomeProjeto.setText("");
            txtCod.setText("");
            txtDescricaoProjeto.setText("");
            txtDataTermino.setText("");
            txtDataInicio.setText("");
            cbDepartamentos.setSelectedItem("Selecione");
            this.listarProjetos();
            this.btnExcluir.setEnabled(false);
            this.btnSalvarAlteracao.setEnabled(false);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Deletado projeto",
                    "Gestão de Projeto", JOptionPane.ERROR_MESSAGE);
        } catch (excecaoDeletarElemento ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Deletar projeto",
                    "Gestão de Projeto", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void cbDepartamentosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbDepartamentosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbDepartamentosActionPerformed

    private void btnOKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOKActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnOKActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnOK;
    private javax.swing.JButton btnSalvarAlteracao;
    private javax.swing.JComboBox cbDepartamentos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanelBusca;
    private javax.swing.JPanel jPanelDadosProjetos;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JLabel lblDataInicio;
    private javax.swing.JLabel lblDataTermino;
    private javax.swing.JLabel lblDepartamento;
    private javax.swing.JLabel lblDescricao;
    private javax.swing.JLabel lblNome;
    private javax.swing.JTable tbProjetos;
    private javax.swing.JTextField txtCod;
    private javax.swing.JFormattedTextField txtDataInicio;
    private javax.swing.JFormattedTextField txtDataTermino;
    private javax.swing.JScrollPane txtDescricao;
    private javax.swing.JTextArea txtDescricaoProjeto;
    private javax.swing.JTextField txtNomeProjeto;
    private javax.swing.JTextField txtPesquisaProjetos;
    // End of variables declaration//GEN-END:variables
 public static String formataData(String dataString) throws Exception {
        String ano = (dataString.substring(0, 4));
        String mes = (dataString.substring(5, 7));
        String dia = (dataString.substring(8, 10));

        String DataCompleta = (dia + "/" + mes + "/" + ano);
        return DataCompleta;
    }

    /**
     * Converte uma String para um objeto Date. Caso a String seja vazia ou
     * nula, retorna null - para facilitar em casos onde formulários podem ter
     * campos de datas vazios.
     *
     * @param dataString
     * @return Date Objeto Date ou null caso receba uma String vazia ou nula
     * @throws Exception Caso a String esteja no formato errado
     */
    public static Date ConverteData(String dataString) throws Exception {
        if (dataString == null || dataString.equals("")) {
            return null;
        }

        DateFormat fmt = new SimpleDateFormat("dd/MM/yyyy");
        java.sql.Date data = new java.sql.Date(fmt.parse(dataString).getTime());

        return data;
    }

}
