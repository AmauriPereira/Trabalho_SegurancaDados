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

public class CadastroAtividadeForm extends javax.swing.JInternalFrame {

    /**
     * Creates new form CadastroAtividadeForm
     */
    public CadastroAtividadeForm() {
        initComponents();
        this.popularCbProjeto();
        this.popularCbEncarregado();
    }

    //Metodo que add todos os projetos cadastrados na ComboBox
    public void popularCbProjeto() {
        ArrayList<String> Projetos = new ArrayList<>();
        ProjetoBO projetoBO = new ProjetoBO();

        try {
            Projetos = projetoBO.ComboBoxProjeto();
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

    //Metodo que add todos os projetos cadastrados na ComboBox
    public void popularCbEncarregado() {
        ArrayList<String> Encarregado = new ArrayList<>();
        UsuarioBO EncarregadoBO = new UsuarioBO();

        try {
            Encarregado = EncarregadoBO.ComboBoxEncarregado();
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

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelDadosAtividade = new javax.swing.JPanel();
        lblNome = new javax.swing.JLabel();
        lblDuracao = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        lblEncarregado = new javax.swing.JLabel();
        cmbEncarregado = new javax.swing.JComboBox();
        lblProjeto = new javax.swing.JLabel();
        cmbProjeto = new javax.swing.JComboBox();
        btnCadastrar = new javax.swing.JButton();
        txtDuracao = new javax.swing.JTextField();

        setClosable(true);
        setIconifiable(true);
        setTitle("Castrado de Atividade");
        setToolTipText("");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/br/edu/ifnmg/alvespereira/segurancadados/icones/11295_128x128.png"))); // NOI18N

        jPanelDadosAtividade.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Dados da Atividade", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.BELOW_TOP, new java.awt.Font("Tahoma", 1, 12), new java.awt.Color(0, 102, 102))); // NOI18N

        lblNome.setText("Nome:");

        lblDuracao.setText("Duração:");

        lblEncarregado.setText("Encarregado:");

        cmbEncarregado.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

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
                            .addComponent(cmbEncarregado, 0, 297, Short.MAX_VALUE)
                            .addComponent(cmbProjeto, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
            .addGroup(jPanelDadosAtividadeLayout.createSequentialGroup()
                .addGap(149, 149, 149)
                .addComponent(btnCadastrar)
                .addContainerGap(134, Short.MAX_VALUE))
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
                .addComponent(btnCadastrar, javax.swing.GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE))
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

        //Tela de Cadastro de Atividades
        String Nome = txtNome.getText();
        float Horas = Float.parseFloat(txtDuracao.getText());

        Float Duracao = Horas;

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
            AtividadeBO AtividadeBO = new AtividadeBO();
            AtividadeBO.criarAtividade(atividade);
            JOptionPane.showMessageDialog(null, "Atividade Cadastrada com Sucesso !!!",
                    "Cadastro de Atividade", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Cadastrar a Atividade",
                    "Cadastro de Atividade", JOptionPane.ERROR_MESSAGE);
        }


    }//GEN-LAST:event_btnCadastrarActionPerformed

    private void cmbProjetoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbProjetoActionPerformed
        //this.popularCbProjeto();
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
