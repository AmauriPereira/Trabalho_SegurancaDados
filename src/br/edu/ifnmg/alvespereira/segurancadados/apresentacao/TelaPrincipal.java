package br.edu.ifnmg.alvespereira.segurancadados.apresentacao;

import static br.edu.ifnmg.alvespereira.segurancadados.apresentacao.Login.getInstancia;
import br.edu.ifnmg.alvespereira.segurancadados.entidades.Departamento;
import br.edu.ifnmg.alvespereira.segurancadados.entidades.Projeto;
import br.edu.ifnmg.alvespereira.segurancadados.entidades.Usuario;
import br.edu.ifnmg.alvespereira.segurancadados.negocio.DepartamentoBO;
import br.edu.ifnmg.alvespereira.segurancadados.negocio.ProjetoBO;
import br.edu.ifnmg.alvespereira.segurancadados.negocio.UsuarioBO;
import java.awt.Dimension;
import static java.awt.Frame.MAXIMIZED_BOTH;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
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

        this.atividadesAtrasadas();

    }

    //Metodo que configura as insformações da barra de status do sistema
    //(UsuarioLogado, Deparatmento, Função) - hora e data
    private void configBarraStatus() {

        this.txtFuncao.setText(usuarioLogado.getTipo());
        this.txtNomeLogado.setText(usuarioLogado.getNome());

        if (usuarioLogado.getTipo().equals("Diretor")) {
            //Esse teste e feito pois diretor nao possui departamento
            this.txtDepartamento.setText("   -   ");
        } else {
            this.txtDepartamento.setText(usuarioLogado.getDepartamento().getCodigo());
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
        itmMnuProjeto = new javax.swing.JMenuItem();
        itmMnuAtividade = new javax.swing.JMenuItem();
        mnuAtualizar = new javax.swing.JMenu();
        itmMnu_Departamento = new javax.swing.JMenuItem();
        itmMnu_Gerente = new javax.swing.JMenuItem();
        itmMnu_Encarregado = new javax.swing.JMenuItem();
        MenuProjeto = new javax.swing.JMenuItem();
        itmMnu_Atividade = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        itmMnuLancarHoras = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        mnuOpcoes = new javax.swing.JMenu();
        jMenuItem9 = new javax.swing.JMenuItem();
        itmMnuSair = new javax.swing.JMenuItem();

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

        itmMnuProjeto.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F4, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        itmMnuProjeto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/edu/ifnmg/alvespereira/segurancadados/icones/liste-texte-vue-icone-4177-32.png"))); // NOI18N
        itmMnuProjeto.setText("       Projeto");
        itmMnuProjeto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itmMnuProjetoActionPerformed(evt);
            }
        });
        mnuCadastros.add(itmMnuProjeto);

        itmMnuAtividade.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F5, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        itmMnuAtividade.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/edu/ifnmg/alvespereira/segurancadados/icones/cabinet-dossiers-icone-8056-32.png"))); // NOI18N
        itmMnuAtividade.setText("       Atividade");
        itmMnuAtividade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itmMnuAtividadeActionPerformed(evt);
            }
        });
        mnuCadastros.add(itmMnuAtividade);

        jMenuBar1.add(mnuCadastros);

        mnuAtualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/edu/ifnmg/alvespereira/segurancadados/icones/tous-refresh-reload-onglets-icone-7131-32.png"))); // NOI18N
        mnuAtualizar.setText("Gestão de  Cadastros             ");

        itmMnu_Departamento.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F1, java.awt.event.InputEvent.ALT_MASK));
        itmMnu_Departamento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/edu/ifnmg/alvespereira/segurancadados/icones/0258.png"))); // NOI18N
        itmMnu_Departamento.setText("     Departamento        ");
        itmMnu_Departamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itmMnu_DepartamentoActionPerformed(evt);
            }
        });
        mnuAtualizar.add(itmMnu_Departamento);

        itmMnu_Gerente.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F2, java.awt.event.InputEvent.ALT_MASK));
        itmMnu_Gerente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/edu/ifnmg/alvespereira/segurancadados/icones/bill-homme-personne-utilisateur-icone-6596-32.png"))); // NOI18N
        itmMnu_Gerente.setText("     Gerente   ");
        itmMnu_Gerente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itmMnu_GerenteActionPerformed(evt);
            }
        });
        mnuAtualizar.add(itmMnu_Gerente);

        itmMnu_Encarregado.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F3, java.awt.event.InputEvent.ALT_MASK));
        itmMnu_Encarregado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/edu/ifnmg/alvespereira/segurancadados/icones/garcon-utilisateur-icone-7572-32.png"))); // NOI18N
        itmMnu_Encarregado.setText("     Encarregado");
        itmMnu_Encarregado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itmMnu_EncarregadoActionPerformed(evt);
            }
        });
        mnuAtualizar.add(itmMnu_Encarregado);

        MenuProjeto.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F4, java.awt.event.InputEvent.ALT_MASK));
        MenuProjeto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/edu/ifnmg/alvespereira/segurancadados/icones/liste-texte-vue-icone-4177-32.png"))); // NOI18N
        MenuProjeto.setText("     Projeto");
        MenuProjeto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuProjetoActionPerformed(evt);
            }
        });
        mnuAtualizar.add(MenuProjeto);

        itmMnu_Atividade.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F5, java.awt.event.InputEvent.ALT_MASK));
        itmMnu_Atividade.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/edu/ifnmg/alvespereira/segurancadados/icones/cabinet-dossiers-icone-8056-32.png"))); // NOI18N
        itmMnu_Atividade.setText("     Atividade");
        itmMnu_Atividade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itmMnu_AtividadeActionPerformed(evt);
            }
        });
        mnuAtualizar.add(itmMnu_Atividade);

        jMenuBar1.add(mnuAtualizar);

        jMenu1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/edu/ifnmg/alvespereira/segurancadados/icones/listes-icone-3873-32.png"))); // NOI18N
        jMenu1.setText("Controle de Atividades");

        itmMnuLancarHoras.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_L, java.awt.event.InputEvent.CTRL_MASK));
        itmMnuLancarHoras.setText("Lançar Horas");
        itmMnuLancarHoras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itmMnuLancarHorasActionPerformed(evt);
            }
        });
        jMenu1.add(itmMnuLancarHoras);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Relatórios");

        jMenuItem1.setText("Usuários");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem1);

        jMenuItem2.setText("Projetos");
        jMenu2.add(jMenuItem2);

        jMenuItem3.setText("Atividades de Projeto");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem3);

        jMenuItem4.setText("Departamentos");
        jMenu2.add(jMenuItem4);

        jMenuBar1.add(jMenu2);

        mnuOpcoes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/edu/ifnmg/alvespereira/segurancadados/icones/engrenages-package-systeme-roues-icone-8982-32.png"))); // NOI18N
        mnuOpcoes.setText("      Opções    ");

        jMenuItem9.setText("     Alterar Dados Pessoais");
        jMenuItem9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem9ActionPerformed(evt);
            }
        });
        mnuOpcoes.add(jMenuItem9);

        itmMnuSair.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F8, 0));
        itmMnuSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/edu/ifnmg/alvespereira/segurancadados/icones/halte-session-icone-4911-32.png"))); // NOI18N
        itmMnuSair.setText("     Sair           ");
        itmMnuSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itmMnuSairActionPerformed(evt);
            }
        });
        mnuOpcoes.add(itmMnuSair);

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

        try {
            DEPexistente = depBO.SelectDepartamentos();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao selecionar o departamento",
                    "Cadastro de Gerente", JOptionPane.ERROR_MESSAGE);
        }

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

        try {
            DEPexistente = depBO.SelectDepartamentos();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao selecionar o departamento",
                    "Cadastro de Gerente", JOptionPane.ERROR_MESSAGE);
        }

        if (DEPexistente == null) {
            JOptionPane.showMessageDialog(null, "Não existe departamentos cadastrados\n"
                    + "É necessário cadastrar no minimo um Departamento !!!", "Cadastro de Encarregado", JOptionPane.ERROR_MESSAGE);
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

    private void itmMnu_DepartamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itmMnu_DepartamentoActionPerformed
        if (usuarioLogado.getTipo().equals("Diretor")) {

            GestaoDepartamentoForm gestaoDepartamentoForm = null;
            gestaoDepartamentoForm = new GestaoDepartamentoForm();
            gestaoDepartamentoForm.setVisible(true);
            centralizaForm(gestaoDepartamentoForm);
            JDP1.add(gestaoDepartamentoForm);
        } else {
            JOptionPane.showMessageDialog(null, "Você não possui previlégios para acessar \n"
                    + "a Tela de Gestão de Departamentos!!!",
                    "Gestão de Departamentos", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_itmMnu_DepartamentoActionPerformed

    private void itmMnu_EncarregadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itmMnu_EncarregadoActionPerformed
        if ((usuarioLogado.getTipo().equals("Diretor")) || (usuarioLogado.getTipo().equals("Gerente"))) {
            GerenciarEncarregadoForm gerenciarEncarregadoForm = null;
            gerenciarEncarregadoForm = new GerenciarEncarregadoForm(usuarioLogado);
            gerenciarEncarregadoForm.setVisible(true);
            centralizaForm(gerenciarEncarregadoForm);
            JDP1.add(gerenciarEncarregadoForm);
        } else {
            JOptionPane.showMessageDialog(null, "Você não possui previlégios para acessar \n   "
                    + "a Tela de Gestão de Encarregado!!!",
                    "Gestão de Encarregado", JOptionPane.ERROR_MESSAGE);

        }


    }//GEN-LAST:event_itmMnu_EncarregadoActionPerformed

    private void jMenuItem9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem9ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem9ActionPerformed

    private void itmMnuProjetoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itmMnuProjetoActionPerformed
// Menu - Cadastro > ItemMenu - PROJETO 
        DepartamentoBO depBO = new DepartamentoBO();

        Departamento DEPexistente = null;

        try {
            DEPexistente = depBO.SelectDepartamentos();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao selecionar o departamento",
                    "Cadastro de Projetos", JOptionPane.ERROR_MESSAGE);
        }

        if (DEPexistente == null) {
            JOptionPane.showMessageDialog(null, "Não existe departamentos cadastrados\n"
                    + "É necessário cadastrar no minimo um Departamento !!!", "Cadastro de Projetos", JOptionPane.ERROR_MESSAGE);
        } else {
            //Instancia uma tela de cadastro de Projeto se o usuario que esta logado for Um Gerente;
            //caso não seja um Gerente é exibida uma mensagem ao usuario do sistema.
            //Obs: Somente Gerente pode cadastrar Projeto

            if (usuarioLogado.getTipo().equals("Gerente")) {

                CadastroProjetoForm cadastroProjetoForm = new CadastroProjetoForm();

                cadastroProjetoForm.setVisible(true);
                centralizaForm(cadastroProjetoForm);

                JDP1.add(cadastroProjetoForm);

            } else {
                JOptionPane.showMessageDialog(null, "Você não possui previlégios para acessar \n   "
                        + "a Tela de Cadastros de projeto!!!", "Cadastro de Projeto", JOptionPane.ERROR_MESSAGE);

            }
        }
    }//GEN-LAST:event_itmMnuProjetoActionPerformed

    private void itmMnuAtividadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itmMnuAtividadeActionPerformed
        // Menu - Cadastro > ItemMenu - Atividade 
        UsuarioBO userBO = new UsuarioBO();

        Usuario Encarregadoexistente = null;

        try {
            Encarregadoexistente = userBO.selectTodosEncarregado();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao selecionar o Encarregado",
                    "Cadastro de Atividade", JOptionPane.ERROR_MESSAGE);
        }

        if (Encarregadoexistente == null) {
            JOptionPane.showMessageDialog(null, "Não existe Encarregados cadastrados\n"
                    + "É necessário cadastrar no minimo um Encarregado !!!", "Cadastro de Atividade", JOptionPane.ERROR_MESSAGE);
        } else {

            Projeto projetExistente = null;

            ProjetoBO projetBO = new ProjetoBO();

            try {
                projetExistente = projetBO.selectTodosProjeto();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Erro ao selecionar o Projeto",
                        "Cadastro de Atividade", JOptionPane.ERROR_MESSAGE);
            }
            if (projetExistente == null) {
                JOptionPane.showMessageDialog(null, "Não existe Projetos cadastrados\n"
                        + "É necessário cadastrar no minimo um Projeto !!!", "Cadastro de Atividade", JOptionPane.ERROR_MESSAGE);
            } else {
                //Instancia uma tela de cadastro de Encarregado 
                //Se o usuario que esta logado for Um diretor ou um Gerente;
                //caso não seja um diretor nem Gerente é exibida uma mensagem ao usuario do sistema.
                //Obs: Somente diretor e gerente podem cadastrar Encarregados.
                if (usuarioLogado.getTipo().equals("Gerente")) {

                    CadastroAtividadeForm cadastroAtividadeForm = new CadastroAtividadeForm();

                    cadastroAtividadeForm.setVisible(true);
                    centralizaForm(cadastroAtividadeForm);

                    JDP1.add(cadastroAtividadeForm);

                } else {
                    JOptionPane.showMessageDialog(null, "Você não possui previlégios para acessar \n   "
                            + "a Tela de Cadastros de Atividades!!!", "Cadastro de Encarregado", JOptionPane.ERROR_MESSAGE);

                }
            }
        }


    }//GEN-LAST:event_itmMnuAtividadeActionPerformed

    private void MenuProjetoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuProjetoActionPerformed
        if (usuarioLogado.getTipo().equals("Gerente")) {
            GerenciaProjetos GP = null;
            GP = new GerenciaProjetos(usuarioLogado);
            GP.setVisible(true);
            centralizaForm(GP);
            JDP1.add(GP);
        } else {
            JOptionPane.showMessageDialog(null, "Você não possui previlégios para acessar \n   "
                    + "a Tela de Gestão de projeto!!!",
                    "Gestão de Projeto", JOptionPane.ERROR_MESSAGE);

        }


    }//GEN-LAST:event_MenuProjetoActionPerformed

    private void itmMnu_AtividadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itmMnu_AtividadeActionPerformed
        if (usuarioLogado.getTipo().equals("Gerente")) {
            GerenciarAtvidadeFom gerenciarAtvidadeFom = null;
            gerenciarAtvidadeFom = new GerenciarAtvidadeFom(usuarioLogado);
            gerenciarAtvidadeFom.setVisible(true);
            centralizaForm(gerenciarAtvidadeFom);
            JDP1.add(gerenciarAtvidadeFom);
        } else {
            JOptionPane.showMessageDialog(null, "Você não possui previlégios para acessar \n   "
                    + "a Tela de Gestão de Atividades!",
                    "Gestão de Atividades", JOptionPane.ERROR_MESSAGE);

        }

    }//GEN-LAST:event_itmMnu_AtividadeActionPerformed

    private void itmMnu_GerenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itmMnu_GerenteActionPerformed
        if (usuarioLogado.getTipo().equals("Diretor")) {
            GerenciarGerenteForm gerenciarGerenteForm = null;
            gerenciarGerenteForm = new GerenciarGerenteForm(usuarioLogado);
            gerenciarGerenteForm.setVisible(true);
            centralizaForm(gerenciarGerenteForm);
            JDP1.add(gerenciarGerenteForm);
        } else {
            JOptionPane.showMessageDialog(null, "Você não possui previlégios para acessar \n   "
                    + "a Tela de Gestão de Gerente!",
                    "Cadastro de Gerente", JOptionPane.ERROR_MESSAGE);

        }
    }//GEN-LAST:event_itmMnu_GerenteActionPerformed

    private void itmMnuLancarHorasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itmMnuLancarHorasActionPerformed
        if (usuarioLogado.getTipo().equals("Diretor")) {
            LancarHorasAtividadeForm lancarHorasAtividadeForm = null;
            lancarHorasAtividadeForm = new LancarHorasAtividadeForm(usuarioLogado);
            lancarHorasAtividadeForm.setVisible(true);
            centralizaForm(lancarHorasAtividadeForm);
            JDP1.add(lancarHorasAtividadeForm);
        } else {
            JOptionPane.showMessageDialog(null, "Você não possui previlégios para acessar \n   "
                    + "a Tela de Gestão de Gerente!",
                    "Cadastro de Gerente", JOptionPane.ERROR_MESSAGE);

        }
    }//GEN-LAST:event_itmMnuLancarHorasActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Data;
    private javax.swing.JLabel Hora;
    private javax.swing.JDesktopPane JDP1;
    private javax.swing.JMenuItem MenuProjeto;
    private javax.swing.JMenuItem itmMnuAtividade;
    private javax.swing.JMenuItem itmMnuDepartamento;
    private javax.swing.JMenuItem itmMnuEncarregado;
    private javax.swing.JMenuItem itmMnuGerente;
    private javax.swing.JMenuItem itmMnuLancarHoras;
    private javax.swing.JMenuItem itmMnuProjeto;
    private javax.swing.JMenuItem itmMnuSair;
    private javax.swing.JMenuItem itmMnu_Atividade;
    private javax.swing.JMenuItem itmMnu_Departamento;
    private javax.swing.JMenuItem itmMnu_Encarregado;
    private javax.swing.JMenuItem itmMnu_Gerente;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblData;
    private javax.swing.JLabel lblDepartamento;
    private javax.swing.JLabel lblFuncao;
    private javax.swing.JLabel lblHora;
    private javax.swing.JLabel lblUsuarioLogado;
    private javax.swing.JMenu mnuAtualizar;
    private javax.swing.JMenu mnuCadastros;
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

    // metodo de chamar tela de atividades em atraso
    private void atividadesAtrasadas() {
        if (usuarioLogado.getTipo().equals("Gerente")) {
            AtividadesAtrazadasForm atividadesAtrazadasForm = null;

            atividadesAtrazadasForm = new AtividadesAtrazadasForm(usuarioLogado);

            atividadesAtrazadasForm.setVisible(true);
            centralizaForm(atividadesAtrazadasForm);
            atividadesAtrazadasForm.toFront();
            JDP1.add(atividadesAtrazadasForm);
        }

    }
}
