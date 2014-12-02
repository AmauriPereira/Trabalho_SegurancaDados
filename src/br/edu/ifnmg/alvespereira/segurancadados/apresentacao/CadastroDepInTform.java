package br.edu.ifnmg.alvespereira.segurancadados.apresentacao;

import br.edu.ifnmg.alvespereira.segurancadados.apresentacao.utilitarios.logSegurancaDados;
import br.edu.ifnmg.alvespereira.segurancadados.entidades.Departamento;
import br.edu.ifnmg.alvespereira.segurancadados.entidades.Usuario;
import br.edu.ifnmg.alvespereira.segurancadados.excecoes.excecaoCodDepartamentoInavlido;
import br.edu.ifnmg.alvespereira.segurancadados.excecoes.excecaoDepartamento;
import br.edu.ifnmg.alvespereira.segurancadados.negocio.DepartamentoBO;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class CadastroDepInTform extends javax.swing.JInternalFrame {

    private static Usuario usuarioLogado = new Usuario();

    public CadastroDepInTform(Usuario userLogado) {
        initComponents();
        this.usuarioLogado = userLogado;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnCadastrar = new javax.swing.JButton();
        txtNomeDep = new javax.swing.JTextField();
        txtCodDep = new javax.swing.JTextField();

        setClosable(true);
        setIconifiable(true);
        setTitle("Cadastro Departamento");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/br/edu/ifnmg/alvespereira/segurancadados/icones/11295_128x128.png"))); // NOI18N
        getContentPane().setLayout(new java.awt.GridLayout(1, 0));

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Dados do Departamento", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.BELOW_TOP, new java.awt.Font("Tahoma", 1, 12), new java.awt.Color(0, 102, 102))); // NOI18N

        jLabel1.setForeground(new java.awt.Color(0, 102, 102));
        jLabel1.setText("Cod:");

        jLabel2.setForeground(new java.awt.Color(0, 102, 102));
        jLabel2.setText("Nome:");

        btnCadastrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/edu/ifnmg/alvespereira/segurancadados/icones/8441_32x32.png"))); // NOI18N
        btnCadastrar.setText("Cadastrar");
        btnCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtCodDep, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNomeDep, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addComponent(btnCadastrar)))
                .addContainerGap(70, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCodDep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNomeDep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                .addComponent(btnCadastrar)
                .addContainerGap())
        );

        getContentPane().add(jPanel1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarActionPerformed
        //Tela de Cadastro de Departamento

        if (txtNomeDep.getText().equals("") || txtCodDep.getText().equals("")) {

            JOptionPane.showMessageDialog(null, " Preencha todos os campos!!!",
                    "Cadastro de Departamento", JOptionPane.ERROR_MESSAGE);
        } else {
            Departamento DEP = new Departamento();
            String Nome = txtNomeDep.getText();
            String CodDep = txtCodDep.getText();

            DEP.setNome(Nome);
            DEP.setCodigo(CodDep);

            DepartamentoBO depBO = new DepartamentoBO();
            logSegurancaDados log = null;
            try {
                depBO.criarDep(DEP);
                JOptionPane.showMessageDialog(null, "Departamento Cadastrado com Sucesso !!!",
                        "Cadastro de Departamento", JOptionPane.INFORMATION_MESSAGE);

                log = new logSegurancaDados("INFO",
                        "Cadastro de Departamento realizado com sucesso pelo "
                        + usuarioLogado.getTipo() + " : " + usuarioLogado.getNome());

                txtCodDep.setText("");
                txtNomeDep.setText("");

            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Erro ao Cadastrar o departamento",
                        "Cadastro de Departamento", JOptionPane.ERROR_MESSAGE);
            } catch (excecaoDepartamento ex) {
                JOptionPane.showMessageDialog(null, "Ja existe um Departamento cadastrado\n"
                        + "  Com este nome ou código!!!",
                        "Cadastro de Departamento", JOptionPane.ERROR_MESSAGE);
            } catch (excecaoCodDepartamentoInavlido ex) {
                JOptionPane.showMessageDialog(null, "É obrigatório digitar um codigo com 3 letras",
                        "Cadastro de Departamento", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnCadastrarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCadastrar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txtCodDep;
    private javax.swing.JTextField txtNomeDep;
    // End of variables declaration//GEN-END:variables
}
