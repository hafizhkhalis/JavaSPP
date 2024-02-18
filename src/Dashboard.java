import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.table.DefaultTableModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import java.text.*;
import java.awt.print.*;
import javax.swing.JTable;

public class Dashboard extends javax.swing.JFrame {
    
    private Connection conn;
    
    private void openConnection() {
    try {
        conn = koneksi.getConnection();
    } catch (SQLException ex) {
        System.out.println("Failed to connect to the database!");
        ex.printStackTrace();
    }
}
   
    public Dashboard() {
        initComponents();
        openConnection();
        showDataInTable();
        JTextID.setEditable(false);
        fillComboJurusan();
        fillComboMetode();
    }
    
    private void showDataInTable() {
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT p.id, p.nama_siswa, p.kelas_siswa, jp.metode, jj.jurusan, p.jumlah " +
                                             "FROM pembayaran AS p " +
                                             "JOIN jenis_metode AS jp ON p.id_metode = jp.id " +
                                             "JOIN jenis_jurusan AS jj ON p.id_jurusan = jj.id");
                                 
            DefaultTableModel model = new DefaultTableModel();
            model.addColumn("ID");
            model.addColumn("Nama Siswa");
            model.addColumn("Kelas Siswa");
            model.addColumn("Metode");
            model.addColumn("Jurusan");
            model.addColumn("Jumlah");

            while (rs.next()) {
                Object[] row = new Object[6]; 
                row[0] = rs.getObject(1);
                row[1] = rs.getObject(2);
                row[2] = rs.getObject(3);
                row[3] = rs.getObject(4);
                row[4] = rs.getObject(5);
                row[5] = rs.getObject(6);

                model.addRow(row);
            }

            jTable2.setModel(model);
            rs.close();
            stmt.close();
        } catch (SQLException ex) {
            System.out.println("Failed to retrieve data from the database!");
            ex.printStackTrace();
        }
    }
    
    private void fillComboJurusan(){
        try{
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select jurusan from jenis_jurusan"); 
            DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>();
           
            while(rs.next()){
                model.addElement(rs.getString("jurusan"));
            }
            
            
            JComboJurusan.setModel(model);
            
            rs.close();
            stmt.close();
        }catch(SQLException ex){
            System.out.print("Failed");
        }
    }
    
    private void fillComboMetode(){
        try{
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select metode from jenis_metode");
            DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>();
            
            while(rs.next()){
                model.addElement(rs.getString("metode"));
            }
            
            JComboPembayaran.setModel(model);
            
            rs.close();
            stmt.close();
        }catch(SQLException ex){
            System.out.print("Failed");
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        JTitle = new javax.swing.JLabel();
        JTextID = new javax.swing.JTextField();
        JTextKelas = new javax.swing.JTextField();
        JComboPembayaran = new javax.swing.JComboBox<>();
        JTextName = new javax.swing.JTextField();
        JComboJurusan = new javax.swing.JComboBox<>();
        JTextJumlah = new javax.swing.JTextField();
        JButtonSave = new javax.swing.JButton();
        JButtonHapus = new javax.swing.JButton();
        JButtonUbah = new javax.swing.JButton();
        JButtonCetak = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });

        JTitle.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        JTitle.setText("SISTEM PEMBAYARAN SPP SMP JAKENAN");

        JComboPembayaran.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        JComboJurusan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        JButtonSave.setText("Save");
        JButtonSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JButtonSaveActionPerformed(evt);
            }
        });

        JButtonHapus.setText("Hapus");
        JButtonHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JButtonHapusActionPerformed(evt);
            }
        });

        JButtonUbah.setText("Ubah");
        JButtonUbah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JButtonUbahActionPerformed(evt);
            }
        });

        JButtonCetak.setText("Cetak");
        JButtonCetak.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JButtonCetakActionPerformed(evt);
            }
        });

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "id", "Nama Siswa", "Kelas", "Jurusan", "Metode Pembayaran", "Jumlah"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable2MouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jTable2MouseExited(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jTable2MouseReleased(evt);
            }
        });
        jScrollPane2.setViewportView(jTable2);
        if (jTable2.getColumnModel().getColumnCount() > 0) {
            jTable2.getColumnModel().getColumn(0).setResizable(false);
            jTable2.getColumnModel().getColumn(1).setResizable(false);
            jTable2.getColumnModel().getColumn(2).setResizable(false);
            jTable2.getColumnModel().getColumn(3).setResizable(false);
            jTable2.getColumnModel().getColumn(4).setResizable(false);
            jTable2.getColumnModel().getColumn(5).setResizable(false);
        }

        jLabel1.setText("ID Siswa :");

        jLabel2.setText("Kelas : ");

        jLabel3.setText("Pembayaran : ");

        jLabel4.setText("Nama Siswa :");

        jLabel5.setText("Jurusan :");

        jLabel6.setText("Jumlah : ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(222, 222, 222)
                .addComponent(JTitle)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addGap(72, 72, 72)
                                            .addComponent(jLabel3))
                                        .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING))
                                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(JTextKelas, javax.swing.GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE)
                                    .addComponent(JTextID)
                                    .addComponent(JComboPembayaran, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(82, 82, 82)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(JTextJumlah, javax.swing.GroupLayout.DEFAULT_SIZE, 173, Short.MAX_VALUE)
                                    .addComponent(JTextName)
                                    .addComponent(JComboJurusan, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(225, 225, 225)
                                .addComponent(JButtonSave)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(JButtonHapus)
                                .addGap(18, 18, 18)
                                .addComponent(JButtonUbah)
                                .addGap(18, 18, 18)
                                .addComponent(JButtonCetak)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(14, Short.MAX_VALUE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 817, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(JTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JTextID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JTextName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JTextKelas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JComboJurusan, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JComboPembayaran, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JTextJumlah, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JButtonSave)
                    .addComponent(JButtonHapus)
                    .addComponent(JButtonUbah)
                    .addComponent(JButtonCetak))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(33, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JButtonSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JButtonSaveActionPerformed
        try{
        Statement stmt = conn.createStatement();
        String sql;
            sql = "insert into pembayaran(nama_siswa, kelas_siswa, id_metode, id_jurusan, jumlah) " +
                    "select '" + JTextName.getText() + "', " +
                    JTextKelas.getText() + ", " +
                    "(select id from jenis_metode where metode='" + JComboPembayaran.getSelectedItem().toString() + "'), " +
                    "(select id from jenis_jurusan where jurusan='" + JComboJurusan.getSelectedItem().toString() + "'), " +
                    JTextJumlah.getText();
        stmt.executeUpdate(sql);
        JOptionPane.showMessageDialog(this, "Data berhasil disimpan", "Sukses", JOptionPane.INFORMATION_MESSAGE);
        resetTextField();
        }catch(SQLException ex){
             System.out.println("Failed: " + ex.getMessage());
             ex.printStackTrace();
        }
        
        showDataInTable();
    }//GEN-LAST:event_JButtonSaveActionPerformed

    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked
        // TODO add your handling code here:
        int selectedRow = jTable2.getSelectedRow();
        DefaultTableModel model = (DefaultTableModel)jTable2.getModel();
        JTextID.setText(model.getValueAt(selectedRow, 0).toString());
        JTextName.setText(model.getValueAt(selectedRow, 1).toString());
        JTextKelas.setText(model.getValueAt(selectedRow, 2).toString());
        JComboPembayaran.setSelectedItem(model.getValueAt(selectedRow, 3).toString());
        JComboJurusan.setSelectedItem(model.getValueAt(selectedRow, 4).toString());
        JTextJumlah.setText(model.getValueAt(selectedRow, 5).toString());

    }//GEN-LAST:event_jTable2MouseClicked

    private void jTable2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_jTable2MouseExited

    private void jTable2MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseReleased
        // TODO add your handling code here:
        resetTextField();
    }//GEN-LAST:event_jTable2MouseReleased

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_formMouseClicked

    private void JButtonHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JButtonHapusActionPerformed
        // TODO add your handling code here:
        if(!JTextID.getText().isEmpty()){
            try{
        Statement stmt = conn.createStatement();
        String sql = "DELETE from pembayaran where id="+ JTextID.getText();
        stmt.executeUpdate(sql);
        JOptionPane.showMessageDialog(this, "Data berhasil dihapus", "Sukses", JOptionPane.INFORMATION_MESSAGE);
        resetTextField();
        }catch(SQLException ex){
             System.out.println("Failed: " + ex.getMessage());
             ex.printStackTrace();
            }
        }else{
            JOptionPane.showMessageDialog(this, "Pilih data terlebih dahulu!", "Gagal", JOptionPane.INFORMATION_MESSAGE);
        }
        
        showDataInTable();
    }//GEN-LAST:event_JButtonHapusActionPerformed

    private void JButtonUbahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JButtonUbahActionPerformed
        // TODO add your handling code here:
        if(!JTextID.getText().isEmpty()){
            try{
        Statement stmt = conn.createStatement();
        String sql = "update pembayaran " +
                     "set nama_siswa='" + JTextName.getText() + "'," +
                         "kelas_siswa='" + JTextKelas.getText() + "'," +
                         "id_metode=(select id from jenis_metode where metode='" + JComboPembayaran.getSelectedItem().toString() + "')," +
                         "id_jurusan=(select id from jenis_jurusan where jurusan='" + JComboJurusan.getSelectedItem().toString() + "')," +
                         "jumlah='" + JTextJumlah.getText() + "'" +
                     "where id=" + JTextID.getText();
        stmt.executeUpdate(sql);
        JOptionPane.showMessageDialog(this, "Data berhasil diupdate", "Sukses", JOptionPane.INFORMATION_MESSAGE);
        resetTextField();
        }catch(SQLException ex){
             System.out.println("Failed: " + ex.getMessage());
             ex.printStackTrace();
            }
        }else{
            JOptionPane.showMessageDialog(this, "Pilih data terlebih dahulu!", "Gagal", JOptionPane.INFORMATION_MESSAGE);
        }
        
        showDataInTable();
    }//GEN-LAST:event_JButtonUbahActionPerformed

    private void JButtonCetakActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JButtonCetakActionPerformed
       MessageFormat header = new MessageFormat("Report Print");
       
       MessageFormat footer = new MessageFormat("Page {0,number,integer}");
       
       try{
          jTable2.print(JTable.PrintMode.NORMAL, header, footer);
       }catch(java.awt.print.PrinterException e){
           System.err.format("Cannot Print %s%n", e.getMessage());
       }
       
       
    }//GEN-LAST:event_JButtonCetakActionPerformed

    private void resetTextField(){
        JTextID.setText("");
        JTextName.setText("");
        JTextJumlah.setText("");
        JTextKelas.setText("");
        JComboJurusan.setSelectedIndex(0);
        JComboPembayaran.setSelectedIndex(0);
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
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
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new Dashboard().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton JButtonCetak;
    private javax.swing.JButton JButtonHapus;
    private javax.swing.JButton JButtonSave;
    private javax.swing.JButton JButtonUbah;
    private javax.swing.JComboBox<String> JComboJurusan;
    private javax.swing.JComboBox<String> JComboPembayaran;
    private javax.swing.JTextField JTextID;
    private javax.swing.JTextField JTextJumlah;
    private javax.swing.JTextField JTextKelas;
    private javax.swing.JTextField JTextName;
    private javax.swing.JLabel JTitle;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    // End of variables declaration//GEN-END:variables
}
