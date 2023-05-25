/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package apptracking.dialog;

import apptracking.funct.dataCallback;
import apptracking.funct.koneksi;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Randy_Machfud
 */
public class dlgViewTrx extends javax.swing.JFrame {
    private DefaultTableModel tabTrx;
    private Connection conn= new koneksi().connect();
    SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
    private String trxId;
    private dataCallback callback;

    public String getTrxId() {
        return trxId;
    }

    public void setTrxId(String trxId) {
        this.trxId = trxId;
    }

    /**
     * Creates new form dlgViewTrx
     */
    public dlgViewTrx(dataCallback callback) {
        initComponents();
        this.callback = callback;
        Object[] baris={"Tgl. Kirim","ID Transaksi","Pelanggan","Tujuan","Nama Barang","Invoice","No.SPK","PIC"};
        tabTrx = new DefaultTableModel(null,baris);
        
        doLoadDataTrx();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblTrx = new javax.swing.JTable();
        txtCari = new javax.swing.JTextField();
        btnCari = new javax.swing.JButton();
        btnKeluar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        tblTrx.setModel(new javax.swing.table.DefaultTableModel(
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
        tblTrx.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        tblTrx.setDragEnabled(true);
        tblTrx.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblTrxMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblTrx);

        btnCari.setBackground(new java.awt.Color(56, 86, 35));
        btnCari.setFont(new java.awt.Font("Lucida Bright", 1, 12)); // NOI18N
        btnCari.setForeground(new java.awt.Color(255, 255, 255));
        btnCari.setText("Cari");
        btnCari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCariActionPerformed(evt);
            }
        });

        btnKeluar.setBackground(new java.awt.Color(56, 86, 35));
        btnKeluar.setFont(new java.awt.Font("Lucida Bright", 1, 12)); // NOI18N
        btnKeluar.setForeground(new java.awt.Color(255, 255, 255));
        btnKeluar.setText("Keluar");
        btnKeluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKeluarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 611, Short.MAX_VALUE)
                    .addComponent(txtCari))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnCari, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnKeluar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCari)
                    .addComponent(btnCari, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnKeluar)))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnCariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCariActionPerformed
        if(txtCari.getText()!=null && !txtCari.equals("")){
            String keyPencarian=txtCari.getText();
            
            tabTrx.setRowCount(0);
            tblTrx.revalidate();
            tblTrx.repaint();
            tblTrx.setModel(tabTrx);
            String sql = "select * from mst_trx"
                    + "   where upper(nmplg) like '%"+keyPencarian.toUpperCase()+"%' "
                    + "         or upper(tujuan) like '%"+keyPencarian.toUpperCase()+"%' "
                    + "         or date(trxdate) = '"+keyPencarian.toUpperCase()+"' "
                    + "         or upper(invoice) like '%"+keyPencarian.toUpperCase()+"%' "
                    + "         or upper(spk) like '%"+keyPencarian.toUpperCase()+"%' "
                    + "         or upper(trxuser) like '%"+keyPencarian.toUpperCase()+"%' "
                    + "         or upper(nmbrg) = '"+keyPencarian.toUpperCase()+"' ";
            try {
                Statement stat= conn.createStatement();
                ResultSet hasil=stat.executeQuery(sql);

                while (hasil.next()) {
                    String tglTrx=sdf.format(hasil.getDate("trxdate"));
                    String namaPel=hasil.getString("nmplg");
                    String alamat=hasil.getString("tujuan");
                    String invoice=hasil.getString("invoice");
                    String spk=hasil.getString("spk");
                    String nmBarang=hasil.getString("nmbrg");
                    String pic=hasil.getString("trxuser");
                    String trx=hasil.getString("trxid");
                    String [] data={tglTrx,trx,namaPel,alamat,nmBarang,invoice,spk,pic};
                    tabTrx.addRow(data);
                }
            } catch (Exception e) {
                System.out.println("Menampilkan Data Error "+e);
            }
        }
    }//GEN-LAST:event_btnCariActionPerformed

    private void btnKeluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKeluarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnKeluarActionPerformed

    private void tblTrxMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblTrxMouseClicked

        if (tabTrx.getColumnCount() > 0) {
            //aktif();
            String[] rowData = new String[tabTrx.getColumnCount()];
            for (int col = 0; col < tabTrx.getColumnCount(); col++) {
                rowData[col] = String.valueOf(tabTrx.getValueAt(tblTrx.rowAtPoint(evt.getPoint()), col));
            }

            trxId = rowData[1];
            callback.onDataReceived(trxId);
            
            this.dispose();
        }

    }//GEN-LAST:event_tblTrxMouseClicked

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
            java.util.logging.Logger.getLogger(dlgViewTrx.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(dlgViewTrx.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(dlgViewTrx.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(dlgViewTrx.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            private dataCallback dataCallback;
            public void run() {
                new dlgViewTrx(dataCallback).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCari;
    private javax.swing.JButton btnKeluar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblTrx;
    private javax.swing.JTextField txtCari;
    // End of variables declaration//GEN-END:variables

    private void doLoadDataTrx() {
        tblTrx.revalidate();
        tblTrx.repaint();
        tblTrx.setModel(tabTrx);
        if(tabTrx.getRowCount()>0){
            tabTrx.setRowCount(0);  
        }
        String sql = "select * from mst_trx";
        try {
            Statement stat= conn.createStatement();
            ResultSet hasil=stat.executeQuery(sql);
            
            while (hasil.next()) {
                String tglTrx=sdf.format(hasil.getDate("trxdate"));
                String namaPel=hasil.getString("nmplg");
                String alamat=hasil.getString("tujuan");
                String invoice=hasil.getString("invoice");
                String spk=hasil.getString("spk");
                String nmBarang=hasil.getString("nmbrg");
                String pic=hasil.getString("trxuser");
                String trxId=hasil.getString("trxid");
                String [] data={tglTrx,trxId,namaPel,alamat,nmBarang,invoice,spk,pic};
                tabTrx.addRow(data);
            }
        } catch (Exception e) {
            System.out.println("Menampilkan Data Error "+e);
        }  
    }
}
