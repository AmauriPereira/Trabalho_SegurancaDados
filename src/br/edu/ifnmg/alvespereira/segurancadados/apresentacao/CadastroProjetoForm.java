package br.edu.ifnmg.alvespereira.segurancadados.apresentacao;

import br.edu.ifnmg.alvespereira.segurancadados.entidades.Departamento;
import br.edu.ifnmg.alvespereira.segurancadados.entidades.Projeto;
import br.edu.ifnmg.alvespereira.segurancadados.negocio.DepartamentoBO;
import br.edu.ifnmg.alvespereira.segurancadados.negocio.ProjetoBO;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;

public class CadastroProjetoForm extends javax.swing.JInternalFrame {

    public CadastroProjetoForm() {
        initComponents();
        this.popularCB();
    }

    //Metodo que add todos os departamentos cadastrados na ComboBox
    public void popularCB() {
        ArrayList<String> Departamentos = new ArrayList<>();
        DepartamentoBO depBO = new DepartamentoBO();

        try {
            Departamentos = depBO.ComboBoxDepartamentos();
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

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelProjeto = new javax.swing.JPanel();
        lblNome = new javax.swing.JLabel();
        lblDescriscao = new javax.swing.JLabel();
        btnCadastrar = new javax.swing.JButton();
        txtNome = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtDescricao = new javax.swing.JTextArea();
        lblDataInicio = new javax.swing.JLabel();
        lblDataTermino = new javax.swing.JLabel();
        txtDataInicio = new javax.swing.JFormattedTextField();
        txtDataFim = new javax.swing.JFormattedTextField();
        jLabel1 = new javax.swing.JLabel();
        cbDepartamentos = new javax.swing.JComboBox();

        setClosable(true);
        setIconifiable(true);
        setTitle("Cadastro de Projeto");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/br/edu/ifnmg/alvespereira/segurancadados/icones/11295_128x128.png"))); // NOI18N

        jPanelProjeto.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Dados do Projeto", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.BELOW_TOP, new java.awt.Font("Tahoma", 1, 12), new java.awt.Color(0, 102, 102))); // NOI18N

        lblNome.setText("Nome:");

        lblDescriscao.setText("Descrição:");

        btnCadastrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/edu/ifnmg/alvespereira/segurancadados/icones/8441_32x32.png"))); // NOI18N
        btnCadastrar.setText("Cadastrar");
        btnCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarActionPerformed(evt);
            }
        });

        txtNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNomeActionPerformed(evt);
            }
        });

        txtDescricao.setColumns(20);
        txtDescricao.setRows(5);
        jScrollPane1.setViewportView(txtDescricao);

        lblDataInicio.setText("Data Início:");

        lblDataTermino.setText("Data Término: ");

        try {
            txtDataInicio.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        try {
            txtDataFim.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabel1.setText("Departamento:");

        cbDepartamentos.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbDepartamentos.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                cbDepartamentosFocusGained(evt);
            }
        });

        javax.swing.GroupLayout jPanelProjetoLayout = new javax.swing.GroupLayout(jPanelProjeto);
        jPanelProjeto.setLayout(jPanelProjetoLayout);
        jPanelProjetoLayout.setHorizontalGroup(
            jPanelProjetoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelProjetoLayout.createSequentialGroup()
                .addGroup(jPanelProjetoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelProjetoLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanelProjetoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelProjetoLayout.createSequentialGroup()
                                .addComponent(lblNome)
                                .addGap(18, 18, 18)
                                .addComponent(txtNome))
                            .addComponent(jScrollPane1)
                            .addGroup(jPanelProjetoLayout.createSequentialGroup()
                                .addGroup(jPanelProjetoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblDescriscao)
                                    .addGroup(jPanelProjetoLayout.createSequentialGroup()
                                        .addComponent(lblDataInicio)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtDataInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(12, 12, 12)
                                        .addComponent(lblDataTermino)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtDataFim, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(jPanelProjetoLayout.createSequentialGroup()
                        .addGap(119, 119, 119)
                        .addComponent(btnCadastrar)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanelProjetoLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cbDepartamentos, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanelProjetoLayout.setVerticalGroup(
            jPanelProjetoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelProjetoLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanelProjetoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNome)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblDescriscao)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21)
                .addGroup(jPanelProjetoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDataInicio)
                    .addComponent(lblDataTermino)
                    .addComponent(txtDataInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDataFim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelProjetoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cbDepartamentos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 35, Short.MAX_VALUE)
                .addComponent(btnCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanelProjetoLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jLabel1, lblDataInicio});

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelProjeto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(13, 13, 13))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelProjeto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(14, 14, 14))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNomeActionPerformed

    }//GEN-LAST:event_txtNomeActionPerformed

    private void btnCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarActionPerformed
        String Nome, Descricao;
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
        Nome = txtNome.getText();
        Descricao = txtDescricao.getText();

        try {
            //Converte e seta a data inicio e termino

            DataInicio = formataData(txtDataInicio.getText());
            DataTermino = formataData(txtDataFim.getText());
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro na Data de  Inicio e Término do projeto",
                    "Cadastro de Projeto", JOptionPane.ERROR_MESSAGE);
        }

        //Cria um novo projeto e seta todos os dados
        Projeto projeto = new Projeto();
        projeto.setNome(Nome);
        projeto.setDescricao(Descricao);
        projeto.setDataInicio(DataInicio);
        projeto.setDataTermino(DataTermino);
        projeto.setDepartamento(departamento);

        //Cria um novo objeto do tipo ProjetoBO e 
        //passa como parmetro o projeto que será cadastrado
        ProjetoBO projetBO = new ProjetoBO();
        try {
            projetBO.criarProjeto(projeto);
            JOptionPane.showMessageDialog(null, "Projeto Cadastrado com Sucesso !!!",
                    "Cadastro de Projeto", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Cadastrar projeto",
                    "Cadastro de Projeto", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_btnCadastrarActionPerformed

    private void cbDepartamentosFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cbDepartamentosFocusGained
        this.popularCB();
    }//GEN-LAST:event_cbDepartamentosFocusGained


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCadastrar;
    private javax.swing.JComboBox cbDepartamentos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanelProjeto;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblDataInicio;
    private javax.swing.JLabel lblDataTermino;
    private javax.swing.JLabel lblDescriscao;
    private javax.swing.JLabel lblNome;
    private javax.swing.JFormattedTextField txtDataFim;
    private javax.swing.JFormattedTextField txtDataInicio;
    private javax.swing.JTextArea txtDescricao;
    private javax.swing.JTextField txtNome;
    // End of variables declaration//GEN-END:variables

    /**
     * Converte uma String para um objeto Date. Caso a String seja vazia ou
     * nula, retorna null - para facilitar em casos onde formulários podem ter
     * campos de datas vazios.
     *
     * @param dataString
     * @return Date Objeto Date ou null caso receba uma String vazia ou nula
     * @throws Exception Caso a String esteja no formato errado
     */
    public static Date formataData(String dataString) throws Exception {
        if (dataString == null || dataString.equals("")) {
            return null;
        }

        DateFormat fmt = new SimpleDateFormat("dd/MM/yyyy");
        java.sql.Date data = new java.sql.Date(fmt.parse(dataString).getTime());

        return data;
    }
}
