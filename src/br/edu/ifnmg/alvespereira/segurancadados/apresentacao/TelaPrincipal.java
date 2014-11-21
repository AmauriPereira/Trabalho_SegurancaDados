package br.edu.ifnmg.alvespereira.segurancadados.apresentacao;

import static br.edu.ifnmg.alvespereira.segurancadados.apresentacao.Login.getInstancia;
import br.edu.ifnmg.alvespereira.segurancadados.entidades.Departamento;
import br.edu.ifnmg.alvespereira.segurancadados.entidades.Usuario;
import br.edu.ifnmg.alvespereira.segurancadados.negocio.DepartamentoBO;
import java.awt.Dimension;
import static java.awt.Frame.MAXIMIZED_BOTH;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.Timer;

public class TelaPrincipal extends javax.swing.JFrame {

    // metodo abaixo instancia um Painel de Area de Trabalho(JDP1)
    //O painel JDP1 é area onde os formularios internos vão ser instanciados
    public static JDesktopPane getPainel() {

        return getInstancia().JDP1;

    }

    //Variavel que recebe os dados do usuario que logou no sistema 
    private static Usuario usuarioLogado;

    public TelaPrincipal(Usuario userLogado) {
        initComponents();
        this.setExtendedState(MAXIMIZED_BOTH);
        this.setLocationRelativeTo(null);

        //recebe os dados do usuario que logou no sistema
        this.usuarioLogado = userLogado;

        //Chama o Metodo que configura as insformações da barra de status do sistema
        //(UsuarioLogado, DEparatmento, Função) - hora e data
        this.configBarraStatus();

    }

    //Metodo que configura as insformações da barra de status do sistema
    //(UsuarioLogado, DEparatmento, Função) - hora e data
    private void configBarraStatus() {

        this.txtFuncao.setText(usuarioLogado.getTipo());
        this.txtNomeLogado.setText(usuarioLogado.getNome());

        if (usuarioLogado.getTipo().equals("Diretor")) {
            //Esse teste e feito pois diretor nao possui departamento
            this.txtDepartamento.setText("   -   ");
        } else {
            this.txtDepartamento.setText(usuarioLogado.getDepartamento());
        }

    }

    //Metodo configura a posição do formularios internos em relação ao painel(CENTRO)
    //ESSE METODO É CHAMADO SEMPRE QUE O USUARIO ABRE ALGUMA TELA DE FORMULARIO(Cadastro Gerente, Diretor e outras);
    private void centralizaForm(JInternalFrame frame) {

        Dimension desktopSize = JDP1.getSize();
        Dimension jInternalFrameSize = frame.getSize();

        frame.setLocation((desktopSize.width - jInternalFrameSize.width) / 2, (desktopSize.height - jInternalFrameSize.height) / 2);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JDP1 = new javax.swing.JDesktopPane();
        jPanel1 = new javax.swing.JPanel();
        txtFuncao = new javax.swing.JLabel();
        txtNomeLogado = new javax.swing.JLabel();
        Data = new javax.swing.JLabel();
        Hora = new javax.swing.JLabel();
        lblData = new javax.swing.JLabel();
        lblHora = new javax.swing.JLabel();
        lblUsuarioLogado = new javax.swing.JLabel();
        lblFuncao = new javax.swing.JLabel();
        lblDepartamento = new javax.swing.JLabel();
        txtDepartamento = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        mnuCadastros = new javax.swing.JMenu();
        itmMnuDepartamento = new javax.swing.JMenuItem();
        itmMnuGerente = new javax.swing.JMenuItem();
        itmMnuEncarregado = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        mnuAtualizar = new javax.swing.JMenu();
        itmMnu_Departamento = new javax.swing.JMenuItem();
        itmMnu_Usuarios = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        mnuExcluir = new javax.swing.JMenu();
        itmMnu_Ex_Departamento = new javax.swing.JMenuItem();
        itmMnu_Ex_Usuarios = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenuItem8 = new javax.swing.JMenuItem();
        mnuOpcoes = new javax.swing.JMenu();
        itmMnuSair = new javax.swing.JMenuItem();
        jMenuItem9 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Gestão de Usuários");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        JDP1.setBackground(new java.awt.Color(240, 240, 240));

        javax.swing.GroupLayout JDP1Layout = new javax.swing.GroupLayout(JDP1);
        JDP1.setLayout(JDP1Layout);
        JDP1Layout.setHorizontalGroup(
            JDP1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1082, Short.MAX_VALUE)
        );
        JDP1Layout.setVerticalGroup(
            JDP1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 728, Short.MAX_VALUE)
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12), new java.awt.Color(0, 102, 102))); // NOI18N
        jPanel1.setPreferredSize(new java.awt.Dimension(1082, 35));

        txtFuncao.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        txtNomeLogado.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        Data.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        Hora.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        lblData.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblData.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/edu/ifnmg/alvespereira/segurancadados/icones/date.png"))); // NOI18N
        lblData.setText("Data:");

        lblHora.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblHora.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/edu/ifnmg/alvespereira/segurancadados/icones/time.png"))); // NOI18N
        lblHora.setText("Hora:");

        lblUsuarioLogado.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblUsuarioLogado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/edu/ifnmg/alvespereira/segurancadados/icones/user.png"))); // NOI18N
        lblUsuarioLogado.setText("Usuário Logado:");

        lblFuncao.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblFuncao.setText("Função:");

        lblDepartamento.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblDepartamento.setText("Departamento :");

        txtDepartamento.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblUsuarioLogado)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNomeLogado, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblDepartamento)
                .addGap(18, 18, 18)
                .addComponent(txtDepartamento, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblFuncao)
                .addGap(18, 18, 18)
                .addComponent(txtFuncao, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
                .addComponent(lblData)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Data, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblHora)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Hora, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(txtNomeLogado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblUsuarioLogado)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Data, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Hora, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblData)
                            .addComponent(lblHora)))
                    .addComponent(lblFuncao)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(lblDepartamento, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(txtDepartamento, javax.swing.GroupLayout.Alignment.TRAILING))
                    .addComponent(txtFuncao, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {Data, Hora, lblData, lblDepartamento, lblFuncao, lblHora, lblUsuarioLogado, txtDepartamento, txtFuncao, txtNomeLogado});

        jMenuBar1.setPreferredSize(new java.awt.Dimension(56, 30));

        mnuCadastros.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/edu/ifnmg/alvespereira/segurancadados/icones/dossier-orange-icone-9020-32.png"))); // NOI18N
        mnuCadastros.setText("   Cadastros      ");

        itmMnuDepartamento.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F1, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        itmMnuDepartamento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/edu/ifnmg/alvespereira/segurancadados/icones/add-chart-icone-4678-32.png"))); // NOI18N
        itmMnuDepartamento.setText("       Departamento      ");
        itmMnuDepartamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itmMnuDepartamentoActionPerformed(evt);
            }
        });
        mnuCadastros.add(itmMnuDepartamento);

        itmMnuGerente.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F2, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        itmMnuGerente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/edu/ifnmg/alvespereira/segurancadados/icones/bill-homme-personne-utilisateur-icone-6596-32.png"))); // NOI18N
        itmMnuGerente.setText("       Gerente   ");
        itmMnuGerente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itmMnuGerenteActionPerformed(evt);
            }
        });
        mnuCadastros.add(itmMnuGerente);

        itmMnuEncarregado.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F3, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        itmMnuEncarregado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/edu/ifnmg/alvespereira/segurancadados/icones/garcon-utilisateur-icone-7572-32.png"))); // NOI18N
        itmMnuEncarregado.setText("       Encarregado   ");
        itmMnuEncarregado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itmMnuEncarregadoActionPerformed(evt);
            }
        });
        mnuCadastros.add(itmMnuEncarregado);

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F4, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/edu/ifnmg/alvespereira/segurancadados/icones/liste-texte-vue-icone-4177-32.png"))); // NOI18N
        jMenuItem1.setText("       Projeto");
        mnuCadastros.add(jMenuItem1);

        jMenuItem2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F5, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/edu/ifnmg/alvespereira/segurancadados/icones/cabinet-dossiers-icone-8056-32.png"))); // NOI18N
        jMenuItem2.setText("       Atividade");
        mnuCadastros.add(jMenuItem2);

        jMenuBar1.add(mnuCadastros);

        mnuAtualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/edu/ifnmg/alvespereira/segurancadados/icones/tous-refresh-reload-onglets-icone-7131-32.png"))); // NOI18N
        mnuAtualizar.setText("    Atualizar     ");

        itmMnu_Departamento.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F1, java.awt.event.InputEvent.ALT_MASK));
        itmMnu_Departamento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/edu/ifnmg/alvespereira/segurancadados/icones/0258.png"))); // NOI18N
        itmMnu_Departamento.setText("     Departamento        ");
        itmMnu_Departamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itmMnu_DepartamentoActionPerformed(evt);
            }
        });
        mnuAtualizar.add(itmMnu_Departamento);

        itmMnu_Usuarios.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F2, java.awt.event.InputEvent.ALT_MASK));
        itmMnu_Usuarios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/edu/ifnmg/alvespereira/segurancadados/icones/bill-homme-personne-utilisateur-icone-6596-32.png"))); // NOI18N
        itmMnu_Usuarios.setText("     Gerente   ");
        mnuAtualizar.add(itmMnu_Usuarios);

        jMenuItem3.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F3, java.awt.event.InputEvent.ALT_MASK));
        jMenuItem3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/edu/ifnmg/alvespereira/segurancadados/icones/garcon-utilisateur-icone-7572-32.png"))); // NOI18N
        jMenuItem3.setText("     Encarregado");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        mnuAtualizar.add(jMenuItem3);

        jMenuItem4.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F4, java.awt.event.InputEvent.ALT_MASK));
        jMenuItem4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/edu/ifnmg/alvespereira/segurancadados/icones/liste-texte-vue-icone-4177-32.png"))); // NOI18N
        jMenuItem4.setText("     Projeto");
        mnuAtualizar.add(jMenuItem4);

        jMenuItem5.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F5, java.awt.event.InputEvent.ALT_MASK));
        jMenuItem5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/edu/ifnmg/alvespereira/segurancadados/icones/cabinet-dossiers-icone-8056-32.png"))); // NOI18N
        jMenuItem5.setText("     Atividade");
        mnuAtualizar.add(jMenuItem5);

        jMenuBar1.add(mnuAtualizar);

        mnuExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/edu/ifnmg/alvespereira/segurancadados/icones/gtk-ltr-undelete-icone-3875-32.png"))); // NOI18N
        mnuExcluir.setText("    Excluir    ");

        itmMnu_Ex_Departamento.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F1, 0));
        itmMnu_Ex_Departamento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/edu/ifnmg/alvespereira/segurancadados/icones/35.png"))); // NOI18N
        itmMnu_Ex_Departamento.setText("     Departamento");
        itmMnu_Ex_Departamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itmMnu_Ex_DepartamentoActionPerformed(evt);
            }
        });
        mnuExcluir.add(itmMnu_Ex_Departamento);

        itmMnu_Ex_Usuarios.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F2, 0));
        itmMnu_Ex_Usuarios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/edu/ifnmg/alvespereira/segurancadados/icones/bill-homme-personne-utilisateur-icone-6596-32.png"))); // NOI18N
        itmMnu_Ex_Usuarios.setText("     Gerente");
        itmMnu_Ex_Usuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itmMnu_Ex_UsuariosActionPerformed(evt);
            }
        });
        mnuExcluir.add(itmMnu_Ex_Usuarios);

        jMenuItem6.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F3, 0));
        jMenuItem6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/edu/ifnmg/alvespereira/segurancadados/icones/garcon-utilisateur-icone-7572-32.png"))); // NOI18N
        jMenuItem6.setText("     Encarregado");
        mnuExcluir.add(jMenuItem6);

        jMenuItem7.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F4, 0));
        jMenuItem7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/edu/ifnmg/alvespereira/segurancadados/icones/liste-texte-vue-icone-4177-32.png"))); // NOI18N
        jMenuItem7.setText("     Projeto");
        mnuExcluir.add(jMenuItem7);

        jMenuItem8.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F5, 0));
        jMenuItem8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/edu/ifnmg/alvespereira/segurancadados/icones/cabinet-dossiers-icone-8056-32.png"))); // NOI18N
        jMenuItem8.setText("     Atividade");
        mnuExcluir.add(jMenuItem8);

        jMenuBar1.add(mnuExcluir);

        mnuOpcoes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/edu/ifnmg/alvespereira/segurancadados/icones/engrenages-package-systeme-roues-icone-8982-32.png"))); // NOI18N
        mnuOpcoes.setText("      Opções    ");

        itmMnuSair.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F8, 0));
        itmMnuSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/edu/ifnmg/alvespereira/segurancadados/icones/halte-session-icone-4911-32.png"))); // NOI18N
        itmMnuSair.setText("     Sair           ");
        itmMnuSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itmMnuSairActionPerformed(evt);
            }
        });
        mnuOpcoes.add(itmMnuSair);

        jMenuItem9.setText("     Alterar Dados Pessoais");
        jMenuItem9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem9ActionPerformed(evt);
            }
        });
        mnuOpcoes.add(jMenuItem9);

        jMenuBar1.add(mnuOpcoes);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(JDP1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(JDP1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void itmMnu_Ex_DepartamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itmMnu_Ex_DepartamentoActionPerformed

    }//GEN-LAST:event_itmMnu_Ex_DepartamentoActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        //metodo que seta a hora e data atual no sistema(Na barra de status)

        this.setExtendedState(MAXIMIZED_BOTH);

        Date DataSistema = new Date();
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        Data.setText(formato.format(DataSistema));

        Timer timer = new Timer(1000, new hora());
        timer.start();

    }//GEN-LAST:event_formWindowOpened

    private void itmMnuDepartamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itmMnuDepartamentoActionPerformed
        // Menu - Cadastro > ItemMenu - Departamento 

        //Instancia uma tela de cadastro de Departamento se o usuario que esta logado for Um diretor;
        //caso não seja um diretor é exibida uma mensagem de ao usuario do sistema.
        //Obs: Somente diretor pode cadastrar departamento
        if (usuarioLogado.getTipo().equals("Diretor")) {

            CadastroDepInTform cadastroDepInTform = null;

            cadastroDepInTform = new CadastroDepInTform();
            cadastroDepInTform.setVisible(true);
            centralizaForm(cadastroDepInTform);
            cadastroDepInTform.toFront();
            JDP1.add(cadastroDepInTform);
        } else {
            JOptionPane.showMessageDialog(null, "Você não possui previlégios para acessar \n"
                    + "a Tela de Cadastros de Departamentos!!!", "Cadastro de Departamentos", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_itmMnuDepartamentoActionPerformed

    private void itmMnuGerenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itmMnuGerenteActionPerformed

// Menu - Cadastro > ItemMenu - Gerente 
        DepartamentoBO depBO = new DepartamentoBO();

        Departamento DEPexistente = null;

        DEPexistente = depBO.SelectDepartamentos();

        if (DEPexistente == null) {
            JOptionPane.showMessageDialog(null, "Não existe departamentos cadastrados\n"
                    + "É necessário cadastrar no minimo um Departamento !!!", "Cadastro de Usuários", JOptionPane.ERROR_MESSAGE);
        } else {
            //Instancia uma tela de cadastro de Gerente se o usuario que esta logado for Um diretor;
            //caso não seja um diretor é exibida uma mensagem ao usuario do sistema.
            //Obs: Somente diretor pode cadastrar Gerente
            String Gerente = "Gerente";
            if (usuarioLogado.getTipo().equals("Diretor")) {

                CadastroUserForm cadastroUserForm = null;
                cadastroUserForm = new CadastroUserForm(Gerente, usuarioLogado);
                cadastroUserForm.setVisible(true);
                centralizaForm(cadastroUserForm);
                cadastroUserForm.toFront();
                JDP1.add(cadastroUserForm);

            } else {
                JOptionPane.showMessageDialog(null, "Você não possui previlégios para acessar \n   "
                        + "a Tela de Cadastros de Gerente!!!", "Cadastro de Gerente", JOptionPane.ERROR_MESSAGE);

            }
        }

    }//GEN-LAST:event_itmMnuGerenteActionPerformed

    private void itmMnuEncarregadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itmMnuEncarregadoActionPerformed
        // Menu - Cadastro > ItemMenu - Encarregado 
        DepartamentoBO depBO = new DepartamentoBO();

        Departamento DEPexistente = null;

        DEPexistente = depBO.SelectDepartamentos();

        if (DEPexistente == null) {
            JOptionPane.showMessageDialog(null, "Não existe departamentos cadastrados\n"
                    + "É necessário cadastrar no minimo um Departamento !!!", "Cadastro de Usuários", JOptionPane.ERROR_MESSAGE);
        } else {
            //Instancia uma tela de cadastro de Encarregado 
            //Se o usuario que esta logado for Um diretor ou um Gerente;
            //caso não seja um diretor nem Gerente é exibida uma mensagem ao usuario do sistema.
            //Obs: Somente diretor e gerente podem cadastrar Encarregados.
            String Encarregado = "Encarregado";
            if ((usuarioLogado.getTipo().equals("Diretor")) || (usuarioLogado.getTipo().equals("Gerente"))) {

                CadastroUserForm cadastroUserForm = null;
                cadastroUserForm = new CadastroUserForm(Encarregado, usuarioLogado);
                cadastroUserForm.setVisible(true);
                centralizaForm(cadastroUserForm);
                cadastroUserForm.toFront();
                JDP1.add(cadastroUserForm);

            } else {
                JOptionPane.showMessageDialog(null, "Você não possui previlégios para acessar \n   "
                        + "a Tela de Cadastros de Encarregado!!!", "Cadastro de Encarregado", JOptionPane.ERROR_MESSAGE);

            }
        }
    }//GEN-LAST:event_itmMnuEncarregadoActionPerformed

    private void itmMnuSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itmMnuSairActionPerformed
        this.dispose();
    }//GEN-LAST:event_itmMnuSairActionPerformed

    private void itmMnu_Ex_UsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itmMnu_Ex_UsuariosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_itmMnu_Ex_UsuariosActionPerformed

    private void itmMnu_DepartamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itmMnu_DepartamentoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_itmMnu_DepartamentoActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem9ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem9ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Data;
    private javax.swing.JLabel Hora;
    private javax.swing.JDesktopPane JDP1;
    private javax.swing.JMenuItem itmMnuDepartamento;
    private javax.swing.JMenuItem itmMnuEncarregado;
    private javax.swing.JMenuItem itmMnuGerente;
    private javax.swing.JMenuItem itmMnuSair;
    private javax.swing.JMenuItem itmMnu_Departamento;
    private javax.swing.JMenuItem itmMnu_Ex_Departamento;
    private javax.swing.JMenuItem itmMnu_Ex_Usuarios;
    private javax.swing.JMenuItem itmMnu_Usuarios;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblData;
    private javax.swing.JLabel lblDepartamento;
    private javax.swing.JLabel lblFuncao;
    private javax.swing.JLabel lblHora;
    private javax.swing.JLabel lblUsuarioLogado;
    private javax.swing.JMenu mnuAtualizar;
    private javax.swing.JMenu mnuCadastros;
    private javax.swing.JMenu mnuExcluir;
    private javax.swing.JMenu mnuOpcoes;
    private javax.swing.JLabel txtDepartamento;
    private javax.swing.JLabel txtFuncao;
    private javax.swing.JLabel txtNomeLogado;
    // End of variables declaration//GEN-END:variables

    class hora implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            Calendar now = Calendar.getInstance();
            Hora.setText(String.format("%1$tH:%1$tM:%1$tS", now));
        }

    }

}
