package br.edu.ifnmg.alvespereira.segurancadados.apresentacao;

import br.edu.ifnmg.alvespereira.segurancadados.entidades.Atividade;
import br.edu.ifnmg.alvespereira.segurancadados.entidades.Projeto;
import br.edu.ifnmg.alvespereira.segurancadados.entidades.Usuario;
import br.edu.ifnmg.alvespereira.segurancadados.excecoes.atividadeExistente;

import br.edu.ifnmg.alvespereira.segurancadados.negocio.AtividadeBO;
import br.edu.ifnmg.alvespereira.segurancadados.negocio.ProjetoBO;
import br.edu.ifnmg.alvespereira.segurancadados.negocio.UsuarioBO;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class CadastroAtividadeForm extends javax.swing.JInternalFrame {

    private static Usuario usuarioLogado = new Usuario();

    public CadastroAtividadeForm(Usuario userLogado) {
        initComponents();
        this.usuarioLogado = userLogado;
        this.popularCbProjeto();
        this.popularCbEncarregado();

    }

    //Metodo que add todos os projetos cadastrados na ComboBox
    public void popularCbProjeto() {
        ArrayList<String> Projetos = new ArrayList<>();
        ProjetoBO projetoBO = new ProjetoBO();

        try {
            Projetos = projetoBO.CMBProjeto(usuarioLogado.getDepartamento().getCodigo());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao popular o projetos",
                    "Projetos", JOptionPane.ERROR_MESSAGE);
        }

        cmbProjeto.removeAllItems();
        cmbProjeto.addItem("Selecione");
        for (String item : Projetos) {
            cmbProjeto.addItem(item);
        }

    }

    //Metodo que add todos os encarregados cadastrados de determinado departamento na ComboBox
    public void popularCbEncarregado() {
        ArrayList<String> Encarregado = new ArrayList<>();
        UsuarioBO EncarregadoBO = new UsuarioBO();

        try {
            Encarregado = EncarregadoBO.ComboBoxEncarregadoPorDepartamento(this.usuarioLogado.getDepartamento().getCodigo());
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

    public void limpar() {

        txtNome.setText("");
        txtDuracao.setText("");

        cmbProjeto.setSelectedItem("Selecione");
        cmbEncarregado.setSelectedItem("Selecione");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelDadosAtividade = new javax.swing.JPanel();
        lblNome = new javax.swing.JLabel();
        lblDuracao = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        lblEncarregado = new javax.swing.JLabel();
        lblProjeto = new javax.swing.JLabel();
        cmbProjeto = new javax.swing.JComboBox();
        btnCadastrar = new javax.swing.JButton();
        txtDuracao = new javax.swing.JTextField();
        cmbEncarregado = new javax.swing.JComboBox();

        setClosable(true);
        setIconifiable(true);
        setTitle("Castrado de Atividade");
        setToolTipText("");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/br/edu/ifnmg/alvespereira/segurancadados/icones/11295_128x128.png"))); // NOI18N

        jPanelDadosAtividade.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Dados da Atividade", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.BELOW_TOP, new java.awt.Font("Tahoma", 1, 12), new java.awt.Color(0, 102, 102))); // NOI18N

        lblNome.setText("Nome:");

        lblDuracao.setText("Duração(HH:mm):");

        lblEncarregado.setText("Encarregado:");

        lblProjeto.setText("Projeto:");

        cmbProjeto.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbProjeto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbProjetoActionPerformed(evt);
            }
        });

        btnCadastrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/edu/ifnmg/alvespereira/segurancadados/icones/8441_32x32.png"))); // NOI18N
        btnCadastrar.setText("Cadastrar");
        btnCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarActionPerformed(evt);
            }
        });

        cmbEncarregado.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout jPanelDadosAtividadeLayout = new javax.swing.GroupLayout(jPanelDadosAtividade);
        jPanelDadosAtividade.setLayout(jPanelDadosAtividadeLayout);
        jPanelDadosAtividadeLayout.setHorizontalGroup(
            jPanelDadosAtividadeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDadosAtividadeLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelDadosAtividadeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelDadosAtividadeLayout.createSequentialGroup()
                        .addGroup(jPanelDadosAtividadeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblDuracao)
                            .addComponent(lblNome))
                        .addGap(18, 18, 18)
                        .addGroup(jPanelDadosAtividadeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNome)
                            .addGroup(jPanelDadosAtividadeLayout.createSequentialGroup()
                                .addComponent(txtDuracao, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelDadosAtividadeLayout.createSequentialGroup()
                        .addGroup(jPanelDadosAtividadeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelDadosAtividadeLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(lblProjeto)
                                .addGap(18, 18, 18))
                            .addGroup(jPanelDadosAtividadeLayout.createSequentialGroup()
                                .addComponent(lblEncarregado)
                                .addGap(18, 18, 18)))
                        .addGroup(jPanelDadosAtividadeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cmbProjeto, 0, 297, Short.MAX_VALUE)
                            .addComponent(cmbEncarregado, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
            .addGroup(jPanelDadosAtividadeLayout.createSequentialGroup()
                .addGap(149, 149, 149)
                .addComponent(btnCadastrar)
                .addContainerGap(155, Short.MAX_VALUE))
        );

        jPanelDadosAtividadeLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {lblDuracao, lblEncarregado, lblNome, lblProjeto});

        jPanelDadosAtividadeLayout.setVerticalGroup(
            jPanelDadosAtividadeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDadosAtividadeLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanelDadosAtividadeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNome)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelDadosAtividadeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDuracao)
                    .addComponent(txtDuracao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelDadosAtividadeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblProjeto)
                    .addComponent(cmbProjeto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelDadosAtividadeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEncarregado)
                    .addComponent(cmbEncarregado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnCadastrar, javax.swing.GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanelDadosAtividadeLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {cmbProjeto, txtNome});

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelDadosAtividade, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelDadosAtividade, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarActionPerformed
        if (txtNome.getText().equals("") || txtDuracao.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Erro - Preencha todos os Campos",
                    "Gestão de Atividade", JOptionPane.ERROR_MESSAGE);
        } else {

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

                    Float Duracao = null;
                    boolean validacao = false;

                    try {
                        float Horas = Float.parseFloat(txtDuracao.getText());

                        Duracao = Horas;
                        validacao = true;

                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(null, "Digite somente numeros no campo Duracao!!! \n "
                                + "Formato aceitavel(Hrs.Min) - Ex(10.30)",
                                "Cadastro de Atividade", JOptionPane.ERROR_MESSAGE);
                    }

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

                    try {
                        if (validacao == true) {
                            AtividadeBO AtividadeBO = new AtividadeBO();
                            AtividadeBO.criarAtividade(atividade);

                            JOptionPane.showMessageDialog(null, "Atividade Cadastrada com Sucesso !!!",
                                    "Cadastro de Atividade", JOptionPane.INFORMATION_MESSAGE);
                            this.limpar();
                        }

                    } catch (SQLException ex) {

                        JOptionPane.showMessageDialog(null, "Erro ao Cadastrar a Atividade",
                                "Cadastro de Atividade", JOptionPane.ERROR_MESSAGE);

                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(null, "Digite somente numeros no campo Duracão!!! \n "
                                + "Formato aceitavel(Hrs.Min) - Ex(10.30)",
                                "Cadastro de Atividade", JOptionPane.ERROR_MESSAGE);
                    } catch (atividadeExistente ex) {
                        JOptionPane.showMessageDialog(null, "Ja existe uma Atividade com este Nome!!!",
                                "Cadastro de Atividade", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        }


    }//GEN-LAST:event_btnCadastrarActionPerformed

    private void cmbProjetoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbProjetoActionPerformed
    }//GEN-LAST:event_cmbProjetoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCadastrar;
    private javax.swing.JComboBox cmbEncarregado;
    private javax.swing.JComboBox cmbProjeto;
    private javax.swing.JPanel jPanelDadosAtividade;
    private javax.swing.JLabel lblDuracao;
    private javax.swing.JLabel lblEncarregado;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblProjeto;
    private javax.swing.JTextField txtDuracao;
    private javax.swing.JTextField txtNome;
    // End of variables declaration//GEN-END:variables

}
