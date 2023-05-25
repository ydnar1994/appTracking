/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package apptracking.entry;

import apptracking.dialog.dlgFaktur;
import apptracking.funct.koneksi;
import apptracking.main.mainMenu;
import java.awt.Color;
import java.io.File;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Randy_Machfud
 */
public class masterFaktur extends javax.swing.JPanel {
    private Connection conn= new koneksi().connect();
    private DefaultTableModel tabFaktur;
    SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");

    /**
     * Creates new form masterTransaksi
     */
    public masterFaktur() {
        initComponents();
        Object[] baris={"Tgl.Faktur","Tgl.Transaksi","ID Transaksi","Pelanggan","Tujuan","Nama Barang","Invoice","No.SPK","PIC"};
        tabFaktur = new DefaultTableModel(null,baris);
        doLoadDataTable();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        btnFaktur = new javax.swing.JButton();
        txtCari = new javax.swing.JTextField();
        btnCari = new javax.swing.JButton();
        btnCetak = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblFaktur = new javax.swing.JTable();

        setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Lucida Bright", 1, 22)); // NOI18N
        jLabel1.setText("Faktur Pelanggan");

        btnFaktur.setBackground(new java.awt.Color(56, 86, 35));
        btnFaktur.setFont(new java.awt.Font("Lucida Bright", 1, 14)); // NOI18N
        btnFaktur.setForeground(new java.awt.Color(255, 255, 255));
        btnFaktur.setText("Buat Faktur");
        btnFaktur.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFakturActionPerformed(evt);
            }
        });

        btnCari.setBackground(new java.awt.Color(56, 86, 35));
        btnCari.setFont(new java.awt.Font("Lucida Bright", 1, 14)); // NOI18N
        btnCari.setForeground(new java.awt.Color(255, 255, 255));
        btnCari.setText("Cari");
        btnCari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCariActionPerformed(evt);
            }
        });

        btnCetak.setBackground(new java.awt.Color(56, 86, 35));
        btnCetak.setFont(new java.awt.Font("Lucida Bright", 1, 14)); // NOI18N
        btnCetak.setForeground(new java.awt.Color(255, 255, 255));
        btnCetak.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/excel.png"))); // NOI18N
        btnCetak.setText("Cetak Faktur");
        btnCetak.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCetakActionPerformed(evt);
            }
        });

        tblFaktur.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tblFaktur);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 746, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtCari)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCari))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(btnFaktur))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnCetak)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnFaktur)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCari, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCari))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCetak)
                .addContainerGap(143, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnFakturActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFakturActionPerformed
        dlgFaktur dlg = new dlgFaktur();
        dlg.setExtendedState(JFrame.PROPERTIES);
        dlg.setVisible(true);
    }//GEN-LAST:event_btnFakturActionPerformed

    private void btnCariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCariActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCariActionPerformed

    private void btnCetakActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCetakActionPerformed
        try {
                    String namaFile = "src/laporan/invoice.jasper";
                    Connection conn = new koneksi().connect();
                    HashMap parameter = new HashMap();
                    parameter.put("REPORT_DIR", getClass().getResource("/image/Logo.png").getPath().replaceAll("%20"," "));
                    File report_file = new File(namaFile);
                    JasperReport jasperReport = (JasperReport) JRLoader.loadObject(report_file.getPath());
                    JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameter, conn);
                    //JasperViewer.viewReport(jasperPrint, false);
                    // JasperViewer.setDefaultLookAndFeelDecorated(true);

                    JasperViewer jasperViewer = new JasperViewer(jasperPrint, false);
                    jasperViewer.setExtendedState(jasperViewer.getExtendedState() | javax.swing.JFrame.MAXIMIZED_BOTH);
                    jasperViewer.setVisible(true);
                } catch (Exception e1) {
                    System.out.println("Error : "+e1);
                    JOptionPane.showMessageDialog(null, "Gagal membuka Laporan", "Cetak laporan", JOptionPane.ERROR_MESSAGE);

                }
    }//GEN-LAST:event_btnCetakActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCari;
    private javax.swing.JButton btnCetak;
    private javax.swing.JButton btnFaktur;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblFaktur;
    private javax.swing.JTextField txtCari;
    // End of variables declaration//GEN-END:variables

    private void doLoadDataTable() {
        tblFaktur.revalidate();
        tblFaktur.repaint();
        tblFaktur.setModel(tabFaktur);
        if(tabFaktur.getRowCount()>0){
            tabFaktur.setRowCount(0);  
        }
        String sql = "select * from mst_faktur";
        try {
            Statement stat= conn.createStatement();
            ResultSet hasil=stat.executeQuery(sql);
            
            while (hasil.next()) {
                String tglFaktur=sdf.format(hasil.getDate("fakturdate"));
                String tglTrx=sdf.format(hasil.getDate("trxdate"));
                String namaPel=hasil.getString("nmplg");
                String alamat=hasil.getString("tujuan");
                String invoice=hasil.getString("invoice");
                String spk=hasil.getString("spk");
                String nmBarang=hasil.getString("nmbrg");
                String pic=hasil.getString("trxuser");
                String trxId=hasil.getString("trxid");
                String [] data={tglFaktur,tglTrx,trxId,namaPel,alamat,nmBarang,invoice,spk,pic};
                tabFaktur.addRow(data);
            }
        } catch (Exception e) {
            System.out.println("Menampilkan Data Error "+e);
        }  
    }
}
