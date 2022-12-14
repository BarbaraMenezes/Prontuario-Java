/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package formulario;

import conexao.Conexao;
import conexao.Paciente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Alana
 */
public class CadastrarPaciente extends javax.swing.JFrame {

    Conexao conexao;
    Connection con;

    /**
     * Creates new form CadastrarPaciente
     */
    public CadastrarPaciente() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        sexo = new javax.swing.ButtonGroup();
        pesquisar = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        tfNomeP = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        tfEndereco = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        tfEmail = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        tfCelular = new javax.swing.JFormattedTextField();
        tfDataNasc = new javax.swing.JFormattedTextField();
        tfTelefone = new javax.swing.JFormattedTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabela = new javax.swing.JTable();
        buAlterar = new javax.swing.JButton();
        rbMasculino = new javax.swing.JRadioButton();
        rbFeminino = new javax.swing.JRadioButton();
        tfId = new javax.swing.JTextField();
        buInserir = new javax.swing.JButton();
        buExcluir = new javax.swing.JButton();
        buLimpar = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        buPesquisar = new javax.swing.JButton();
        rbID = new javax.swing.JRadioButton();
        rbNome = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel1.setText("Nome:");

        jLabel2.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel2.setText("Endere??o:");

        jLabel3.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel3.setText("Email:");

        jLabel4.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel4.setText("Telefone:");

        jLabel5.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel5.setText("Celular:");

        jLabel6.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel6.setText("Data de Nascimento:");

        try {
            tfCelular.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##)#####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        try {
            tfDataNasc.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        try {
            tfTelefone.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##)#####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        tabela.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nome", "Sexo", "Data de Nascimento", "Endere??o", "Telefone", "Celular", "Email"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabela.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabela);

        buAlterar.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        buAlterar.setText("Alterar");
        buAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buAlterarActionPerformed(evt);
            }
        });

        rbMasculino.setBackground(new java.awt.Color(255, 255, 255));
        sexo.add(rbMasculino);
        rbMasculino.setText("Masculino");

        rbFeminino.setBackground(new java.awt.Color(255, 255, 255));
        sexo.add(rbFeminino);
        rbFeminino.setText("Feminino");

        buInserir.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        buInserir.setText("Inserir");
        buInserir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buInserirActionPerformed(evt);
            }
        });

        buExcluir.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        buExcluir.setText("Excluir");
        buExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buExcluirActionPerformed(evt);
            }
        });

        buLimpar.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        buLimpar.setText("Limpar");
        buLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buLimparActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Verdana", 1, 20)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Cadastrar Paciente");

        jLabel8.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel8.setText("ID:");

        jLabel9.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Pacientes Cadastrados");

        jLabel10.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel10.setText("Sexo:");

        buPesquisar.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        buPesquisar.setText("Pesquisar");
        buPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buPesquisarActionPerformed(evt);
            }
        });

        pesquisar.add(rbID);
        rbID.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        rbID.setText("ID");
        rbID.setBorder(null);

        pesquisar.add(rbNome);
        rbNome.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        rbNome.setText("Nome");
        rbNome.setBorder(null);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(tfNomeP))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(tfEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(tfEmail)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel4)
                                            .addComponent(jLabel5))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(tfTelefone, javax.swing.GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE)
                                            .addComponent(tfCelular)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel8)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(tfId, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel10)))
                                .addGap(18, 18, 18))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(buInserir)
                                .addGap(32, 32, 32)
                                .addComponent(buAlterar)
                                .addGap(40, 40, 40)
                                .addComponent(buExcluir)
                                .addGap(47, 47, 47)
                                .addComponent(buLimpar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(buPesquisar)
                                .addGap(33, 33, 33)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(tfDataNasc))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(rbFeminino)
                                        .addGap(3, 3, 3)
                                        .addComponent(rbMasculino)))
                                .addGap(0, 17, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(rbID)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(rbNome)
                                .addGap(36, 36, 36)))))
                .addContainerGap())
            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(jLabel7)
                .addGap(47, 47, 47)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(tfNomeP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(tfTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(4, 4, 4)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(tfEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(tfCelular, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfDataNasc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(tfEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(rbMasculino)
                    .addComponent(rbFeminino)
                    .addComponent(jLabel10))
                .addGap(44, 44, 44)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buAlterar)
                    .addComponent(buInserir)
                    .addComponent(buExcluir)
                    .addComponent(buLimpar)
                    .addComponent(buPesquisar)
                    .addComponent(rbID)
                    .addComponent(rbNome))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
public void PreencherTabela(String sql) {
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            if (sql.equals("select * from paciente where nome ilike ?")) {
                String nome = tfNomeP.getText();
                stmt.setString(1, "%" + nome + "%");
            } else {
                if (sql.equals("select * from paciente where idpaciente = ?")) {
                    int id = Integer.parseInt(tfId.getText());
                    stmt.setInt(1, id);
                }
            }

            ResultSet rs = stmt.executeQuery();

            DateFormat data = new SimpleDateFormat("dd/MM/yyyy");

            DefaultTableModel modelo = (DefaultTableModel) tabela.getModel();

            modelo.setNumRows(0);

            while (rs.next()) {
                modelo.addRow(new Object[]{
                    rs.getInt("idpaciente"),
                    rs.getString("nome"),
                    rs.getString("sexo"),
                    data.format(rs.getDate("datanascimento")),
                    rs.getString("endereco"),
                    rs.getString("telefone"),
                    rs.getString("numcelular"),
                    rs.getString("email")
                });
            }

            rs.close();
            stmt.close();

        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }

    }

    public void LimparCampos() {
        tfNomeP.setText("");
        tfTelefone.setText("");
        tfCelular.setText("");
        tfDataNasc.setText("");
        tfEndereco.setText("");
        tfEmail.setText("");
        rbMasculino.setSelected(true);
        rbFeminino.setSelected(false);

    }
    private void tabelaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaMouseClicked
        // TODO add your handling code here:
        int linha = tabela.getSelectedRow();

        tfNomeP.setText(tabela.getValueAt(linha, 1).toString());

        if (tabela.getValueAt(linha, 2).toString().equals("F")) {
            rbFeminino.setSelected(true);
        } else {
            rbMasculino.setSelected(true);
        }

        tfDataNasc.setText(tabela.getValueAt(linha, 3).toString());
        tfEndereco.setText(tabela.getValueAt(linha, 4).toString());
        tfTelefone.setText(tabela.getValueAt(linha, 5).toString());
        tfCelular.setText(tabela.getValueAt(linha, 6).toString());
        tfEmail.setText(tabela.getValueAt(linha, 7).toString());
        tfId.setText(tabela.getValueAt(linha, 0).toString());
    }//GEN-LAST:event_tabelaMouseClicked

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
        conexao = new Conexao();

        try {
            con = conexao.Conectar();
        } catch (NullPointerException ex) {
            System.out.println(ex.toString());

        }

        rbMasculino.setSelected(true);

        String sql = "select * from paciente";

        PreencherTabela(sql);
    }//GEN-LAST:event_formWindowOpened

    private void buInserirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buInserirActionPerformed
        // TODO add your handling code here:

        Paciente cliente = new Paciente();
        String sexo = null;
        boolean verificadorrb = false;
        if (rbMasculino.isSelected()) {
            sexo = "M";
            verificadorrb = true;
        } else {
            if (rbFeminino.isSelected()) {
                sexo = "F";
                verificadorrb = true;
            }
        }
        if (verificadorrb) {

            try {
                if (cliente.Inserir(con, tfNomeP.getText(), sexo, tfDataNasc.getText(), tfEndereco.getText(), tfTelefone.getText(), tfCelular.getText(), tfEmail.getText())) {
                    JOptionPane.showMessageDialog(null, "Cadastro Realizado com Sucesso", "Cadastro Realizado", 1);
                } else {
                    JOptionPane.showMessageDialog(null, "Cadastro N??o Realizado", "Cadastro N??o Realizado", 0);
                }
            } catch (SQLException ex) {
                Logger.getLogger(CadastrarPaciente.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ParseException ex) {
                Logger.getLogger(CadastrarPaciente.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else {
            JOptionPane.showMessageDialog(null, "Selecione o Sexo do Paciente", "Selecione o sexo", 0);
        }

        String sql = "select * from paciente";
        PreencherTabela(sql);


    }//GEN-LAST:event_buInserirActionPerformed

    private void buAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buAlterarActionPerformed
        // TODO add your handling code here:

        Paciente paciente = new Paciente();
        String sexo = null;

        if (rbMasculino.isSelected()) {
            sexo = "M";
        } else {
            sexo = "F";
        }

        if (!(paciente.Alterar(con, tfNomeP.getText(), sexo, tfDataNasc.getText(), tfEndereco.getText(),
                tfTelefone.getText(), tfCelular.getText(), tfEmail.getText(), Integer.parseInt(tfId.getText())))) {
            JOptionPane.showMessageDialog(null, "Erro Inesperado ao Tentar Alterar os Dados", "Erro ao Alterar os Dados", 0);
        }

        String sql = "select * from paciente";
        PreencherTabela(sql);

    }//GEN-LAST:event_buAlterarActionPerformed

    private void buExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buExcluirActionPerformed
        // TODO add your handling code here:
        Paciente paciente = new Paciente();
        try {
            paciente.Excluir(con, Integer.parseInt(tfId.getText()));
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Selecione um Paciente Para ser Exclu??do", "Opera????o N??o Realizada", 0);
        }

        String sql = "select * from paciente";
        PreencherTabela(sql);


    }//GEN-LAST:event_buExcluirActionPerformed

    private void buLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buLimparActionPerformed
        // TODO add your handling code here:
        LimparCampos();
    }//GEN-LAST:event_buLimparActionPerformed

    private void buPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buPesquisarActionPerformed
        // TODO add your handling code here:
        String sql;
        if (rbNome.isSelected()) {
            sql = "select * from paciente where nome ilike ?";
            PreencherTabela(sql);
        } else {
            if (rbID.isSelected()) {
                sql = "select * from paciente where idpaciente = ?";
                PreencherTabela(sql);

            } else {
                JOptionPane.showMessageDialog(null, "Selecione uma op????o para pesquisar", "Erro ao Pesquisar", 0);
            }
        }

    }//GEN-LAST:event_buPesquisarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;

                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CadastrarPaciente.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadastrarPaciente.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadastrarPaciente.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadastrarPaciente.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CadastrarPaciente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buAlterar;
    private javax.swing.JButton buExcluir;
    private javax.swing.JButton buInserir;
    private javax.swing.JButton buLimpar;
    private javax.swing.JButton buPesquisar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.ButtonGroup pesquisar;
    private javax.swing.JRadioButton rbFeminino;
    private javax.swing.JRadioButton rbID;
    private javax.swing.JRadioButton rbMasculino;
    private javax.swing.JRadioButton rbNome;
    private javax.swing.ButtonGroup sexo;
    private javax.swing.JTable tabela;
    private javax.swing.JFormattedTextField tfCelular;
    private javax.swing.JFormattedTextField tfDataNasc;
    private javax.swing.JTextField tfEmail;
    private javax.swing.JTextField tfEndereco;
    private javax.swing.JTextField tfId;
    private javax.swing.JTextField tfNomeP;
    private javax.swing.JFormattedTextField tfTelefone;
    // End of variables declaration//GEN-END:variables
}
