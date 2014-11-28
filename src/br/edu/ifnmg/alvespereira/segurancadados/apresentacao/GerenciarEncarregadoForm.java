/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.alvespereira.segurancadados.apresentacao;

import br.edu.ifnmg.alvespereira.segurancadados.entidades.Departamento;
import br.edu.ifnmg.alvespereira.segurancadados.entidades.Usuario;
import br.edu.ifnmg.alvespereira.segurancadados.negocio.DepartamentoBO;
import br.edu.ifnmg.alvespereira.segurancadados.negocio.UsuarioBO;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author Amauri
 */
public class GerenciarEncarregadoForm extends javax.swing.JInternalFrame {

    /**
     * Creates new form EditarUsuarioForm
     */
    Usuario userLogado = null;

    public GerenciarEncarregadoForm(Usuario usuarioLogado) {
        initComponents();

        userLogado = usuarioLogado;
        this.popularCmbDepartamento();
        this.popularCmbDepartamentoBuscar();

    }

    public void popularCmbDepartamentoBuscar() {
        ArrayList<String> Departamentos = new ArrayList<>();
        DepartamentoBO departamentoBO = new DepartamentoBO();

        try {
            Departamentos = departamentoBO.ComboBoxDepartamentos();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao popular o departamento",
                    "Departamento", JOptionPane.ERROR_MESSAGE);
        }

        cmbBuscaFuncionario.removeAllItems();
        cmbBuscaFuncionario.addItem("Selecione");
        for (String item : Departamentos) {
            cmbBuscaFuncionario.addItem(item);
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelGerenciarUsuario = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbResultadoBusca = new javax.swing.JTable();
        jPanelBuscarUsuario = new javax.swing.JPanel();
        cmbBuscaFuncionario = new javax.swing.JComboBox();
        btnBuscar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        lbbTipoUsuario = new javax.swing.JLabel();
        lblNome = new javax.swing.JLabel();
        lblEmail = new javax.swing.JLabel();
        lblDepartamento = new javax.swing.JLabel();
        lblSenha = new javax.swing.JLabel();
        txtTipo = new javax.swing.JTextField();
        txtNome = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        txtSenha = new javax.swing.JTextField();
        cmbDepartamento = new javax.swing.JComboBox();
        lblCodigo = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        btnSalvarAlterações = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        btnOK = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setTitle("Gerênciar Encarregados");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/br/edu/ifnmg/alvespereira/segurancadados/icones/11295_128x128.png"))); // NOI18N

        tbResultadoBusca.setModel(new javax.swing.table.DefaultTableModel(
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
        tbResultadoBusca.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbResultadoBuscaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbResultadoBusca);

        jPanelBuscarUsuario.setBorder(javax.swing.BorderFactory.createTitledBorder(null, " Buscar usuário por departamento", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12), new java.awt.Color(0, 102, 102))); // NOI18N

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
                .addComponent(cmbBuscaFuncionario, 0, 344, Short.MAX_VALUE)
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

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, " Buscar usuário por departamento", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12), new java.awt.Color(0, 102, 102))); // NOI18N

        lbbTipoUsuario.setText("Tipo de Usuário:");

        lblNome.setText("Nome:");

        lblEmail.setText("Email:");

        lblDepartamento.setText("Departamento:");

        lblSenha.setText("Senha:");

        cmbDepartamento.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbDepartamento.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        cmbDepartamento.setOpaque(false);

        lblCodigo.setText("Código:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(lbbTipoUsuario)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtTipo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblCodigo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(lblDepartamento)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cmbDepartamento, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(lblNome)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtNome))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(lblEmail)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtEmail, javax.swing.GroupLayout.DEFAULT_SIZE, 248, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(lblSenha)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbbTipoUsuario)
                    .addComponent(txtTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCodigo)
                    .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNome)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEmail)
                    .addComponent(lblSenha)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDepartamento)
                    .addComponent(cmbDepartamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnSalvarAlterações.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/edu/ifnmg/alvespereira/segurancadados/icones/filesave-icone-8124-32.png"))); // NOI18N
        btnSalvarAlterações.setText("Salvar Alterações");
        btnSalvarAlterações.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarAlteraçõesActionPerformed(evt);
            }
        });

        btnExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/edu/ifnmg/alvespereira/segurancadados/icones/8443_32x32.png"))); // NOI18N
        btnExcluir.setText("Excluir");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelGerenciarUsuarioLayout = new javax.swing.GroupLayout(jPanelGerenciarUsuario);
        jPanelGerenciarUsuario.setLayout(jPanelGerenciarUsuarioLayout);
        jPanelGerenciarUsuarioLayout.setHorizontalGroup(
            jPanelGerenciarUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelGerenciarUsuarioLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelGerenciarUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 531, Short.MAX_VALUE)
                    .addComponent(jPanelBuscarUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelGerenciarUsuarioLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnSalvarAlterações)
                        .addGap(29, 29, 29)
                        .addComponent(btnExcluir)
                        .addGap(147, 147, 147)))
                .addContainerGap())
        );
        jPanelGerenciarUsuarioLayout.setVerticalGroup(
            jPanelGerenciarUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelGerenciarUsuarioLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelBuscarUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelGerenciarUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSalvarAlterações)
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
                .addComponent(jPanelGerenciarUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnOK, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelGerenciarUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnOK, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed

        String departamento = this.cmbBuscaFuncionario.getSelectedItem().toString();
        UsuarioBO encarregado = new UsuarioBO();
        //System.out.println(departamento.getNome());
        try {
            tbResultadoBusca.setModel(DbUtils.resultSetToTableModel(encarregado.preencheTabelaEncarregado(departamento)));
        } catch (SQLException ex) {

        }


    }//GEN-LAST:event_btnBuscarActionPerformed

    private void tbResultadoBuscaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbResultadoBuscaMouseClicked
        this.btnExcluir.setEnabled(true);
        this.btnSalvarAlterações.setEnabled(true);
        int seleciona = tbResultadoBusca.getSelectedRow();

        cmbDepartamento.setSelectedItem(tbResultadoBusca.getModel().getValueAt(seleciona, 3).toString());
        txtCodigo.setText(tbResultadoBusca.getModel().getValueAt(seleciona, 0).toString());
        txtNome.setText(tbResultadoBusca.getModel().getValueAt(seleciona, 1).toString());
        txtTipo.setText(tbResultadoBusca.getModel().getValueAt(seleciona, 2).toString());
        txtEmail.setText(tbResultadoBusca.getModel().getValueAt(seleciona, 4).toString());
    }//GEN-LAST:event_tbResultadoBuscaMouseClicked

    private void btnSalvarAlteraçõesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarAlteraçõesActionPerformed
        int idUsuario;
        String Nome;
        String Email;
        String Tipo;
        String Senha = null;
        Departamento Departamento = null;

        //Seta o departamento do encarregado
        try {
            DepartamentoBO depBO = new DepartamentoBO();
            Departamento = depBO.selectDepartamento(cmbDepartamento.getSelectedItem() + "");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao selecionar o departamento",
                    "Alteração de Dados", JOptionPane.ERROR_MESSAGE);
        }

        //Seta o Nome e a descrição projeto
        Nome = txtNome.getText();
        Email = txtEmail.getText();
        Tipo = txtTipo.getText();
        Senha = txtSenha.getText();
        idUsuario = Integer.parseInt(txtCodigo.getText());

        MessageDigest cript;
        try {
            cript = MessageDigest.getInstance("SHA-256");
            byte messageDigest[] = cript.digest(Senha.getBytes("UTF-8"));

            StringBuilder hexString = new StringBuilder();
            for (byte b : messageDigest) {
                hexString.append(String.format("%02X", 0xFF & b));
            }
            Senha = hexString.toString();

        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(CadastroDiretorForm.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(CadastroDiretorForm.class.getName()).log(Level.SEVERE, null, ex);
        }

        //Cria um novo projeto e seta todos os dados
        Usuario encarregado = new Usuario();
        encarregado.setIdUsuario(idUsuario);
        encarregado.setNome(Nome);
        encarregado.setEmail(Email);
        encarregado.setSenha(Senha);
        encarregado.setDepartamento(Departamento);
        encarregado.setTipo(Tipo);

        //Cria um novo objeto do tipo ProjetoBO e 
        //passa como parmetro o projeto que será cadastrado
        UsuarioBO usuarioBO = new UsuarioBO();

        try {
            usuarioBO.UpdateGerente(encarregado);
            JOptionPane.showMessageDialog(null, "Usuario Atualizado com Sucesso !!!",
                    "Gestão de Usuário", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Atualizado projeto",
                    "Gestão de Usuário", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnSalvarAlteraçõesActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        //Cria um novo projeto e seta o ID do  projetoque sera excluido
        Usuario usuario = new Usuario();

        int codGerente = Integer.parseInt(txtCodigo.getText());
        usuario.setIdUsuario(codGerente);
        usuario.setTipo("Encarregado");

        //Cria um novo objeto do tipo ProjetoBO e 
        //passa como parmetro o projeto que será Deletado
        UsuarioBO usuarioBO = new UsuarioBO();

        try {
            usuarioBO.DeleteEncarregado(usuario);
            JOptionPane.showMessageDialog(null, "Usuario Deletado com Sucesso !!!",
                    "Gestão de Usuário", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Usuário Deletado com Sucesso",
                    "Gestão de Usuário", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void btnOKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOKActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnOKActionPerformed

    private void cmbBuscaFuncionarioKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cmbBuscaFuncionarioKeyPressed


    }//GEN-LAST:event_cmbBuscaFuncionarioKeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnOK;
    private javax.swing.JButton btnSalvarAlterações;
    private javax.swing.JComboBox cmbBuscaFuncionario;
    private javax.swing.JComboBox cmbDepartamento;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanelBuscarUsuario;
    private javax.swing.JPanel jPanelGerenciarUsuario;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbbTipoUsuario;
    private javax.swing.JLabel lblCodigo;
    private javax.swing.JLabel lblDepartamento;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblSenha;
    private javax.swing.JTable tbResultadoBusca;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtSenha;
    private javax.swing.JTextField txtTipo;
    // End of variables declaration//GEN-END:variables

    //Metodo que add todos os departamentos cadastrados na ComboBox
    public void popularCmbDepartamento() {
        ArrayList<String> Departamentos = new ArrayList<>();
        DepartamentoBO depBO = new DepartamentoBO();

        try {
            Departamentos = depBO.ComboBoxDepartamentos();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao popular o departamento",
                    "Departamento", JOptionPane.ERROR_MESSAGE);
        }

        cmbDepartamento.removeAllItems();
        cmbDepartamento.addItem("Selecione");
        for (String item : Departamentos) {
            cmbDepartamento.addItem(item);
        }

    }
}
