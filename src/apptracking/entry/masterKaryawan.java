/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package apptracking.entry;

import apptracking.dialog.dlgFaktur;
import apptracking.dialog.dlgKaryawan;
import apptracking.funct.koneksi;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Randy_Machfud
 */
public class masterKaryawan extends javax.swing.JPanel {
    private DefaultTableModel tabKaryawan;
    private Connection conn= new koneksi().connect();

    /**
     * Creates new form masterKaryawan
     */
    public masterKaryawan() {
        initComponents();
        Object[] baris={"ID Karyawan","Nama","Jenis Kelamin","Jabatan","No.Telp","No.Ktp","Alamat"};
        tabKaryawan = new DefaultTableModel(null,baris);
        doLoadDataKaryawan();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnTambah = new javax.swing.JButton();
        txtCari = new javax.swing.JTextField();
        btnCari = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblKaryawan = new javax.swing.JTable();

        setBackground(new java.awt.Color(255, 255, 255));

        btnTambah.setBackground(new java.awt.Color(56, 86, 35));
        btnTambah.setFont(new java.awt.Font("Lucida Bright", 1, 12)); // NOI18N
        btnTambah.setForeground(new java.awt.Color(255, 255, 255));
        btnTambah.setText("Tambah Karyawan");
        btnTambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTambahActionPerformed(evt);
            }
        });

        btnCari.setFont(new java.awt.Font("Lucida Bright", 1, 12)); // NOI18N
        btnCari.setForeground(new java.awt.Color(56, 86, 35));
        btnCari.setText("Cari");
        btnCari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCariActionPerformed(evt);
            }
        });

        tblKaryawan.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tblKaryawan);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnTambah, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtCari, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnCari)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnTambah, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnCari, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .addComponent(txtCari))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnTambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTambahActionPerformed
        dlgKaryawan dlg = new dlgKaryawan();
        dlg.setExtendedState(JFrame.PROPERTIES);
        dlg.setVisible(true);
    }//GEN-LAST:event_btnTambahActionPerformed

    private void btnCariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCariActionPerformed
        if (txtCari.getText() != null && !txtCari.equals("")) {
            String keyPencarian = txtCari.getText();

            tabKaryawan.setRowCount(0);
            tblKaryawan.revalidate();
            tblKaryawan.repaint();
            tblKaryawan.setModel(tabKaryawan);
            String sql = "select * from mst_karyawan"
                    + "   where upper(id) like '%" + keyPencarian.toUpperCase() + "%' "
                    + "         or upper(nama) like '%" + keyPencarian.toUpperCase() + "%' "
                    + "         or upper(jabatan) like '%" + keyPencarian.toUpperCase() + "%' "
                    + "         or upper(no_telp) like '%" + keyPencarian.toUpperCase() + "%' "
                    + "         or upper(no_ktp) like '%" + keyPencarian.toUpperCase() + "%' "
                    + "         or upper(alamat) like '%" + keyPencarian.toUpperCase() + "%' ";
            try {
                Statement stat = conn.createStatement();
                ResultSet hasil = stat.executeQuery(sql);

                while (hasil.next()) {
                    String id = hasil.getString("id");
                    String nama = hasil.getString("nama");
                    Integer jenis = hasil.getInt("jenis_kelamin");
                    String jabatan = hasil.getString("jabatan");
                    String noTelp = hasil.getString("no_telp");
                    String noKtp = hasil.getString("no_ktp");
                    String alamat = hasil.getString("alamat");
                    String[] data = {id, nama, jenis.equals(1)?"Laki-laki":"Perempuan", jabatan, noTelp, noKtp, alamat};
                    tabKaryawan.addRow(data);
                }
            } catch (Exception e) {
                System.out.println("Menampilkan Data Error " + e);
            }
        }
    }//GEN-LAST:event_btnCariActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCari;
    private javax.swing.JButton btnTambah;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblKaryawan;
    private javax.swing.JTextField txtCari;
    // End of variables declaration//GEN-END:variables

    private void doLoadDataKaryawan() {
        tblKaryawan.revalidate();
        tblKaryawan.repaint();
        tblKaryawan.setModel(tabKaryawan);
        if (tabKaryawan.getRowCount() > 0) {
            tabKaryawan.setRowCount(0);
        }
        String sql = "select * from mst_karyawan";
        try {
            Statement stat = conn.createStatement();
            ResultSet hasil = stat.executeQuery(sql);

            while (hasil.next()) {
                String id=hasil.getString("id");
                String nama=hasil.getString("nama");
                Integer jenis=hasil.getInt("jenis_kelamin");
                String jabatan=hasil.getString("jabatan");
                String noTelp=hasil.getString("no_telp");
                String noKtp=hasil.getString("no_ktp");
                String alamat=hasil.getString("alamat");
                String[] data = {id,nama,jenis.equals(1)?"Laki-laki":"Perempuan",jabatan,noTelp,noKtp,alamat};
                tabKaryawan.addRow(data);
            }
        } catch (Exception e) {
            System.out.println("Menampilkan Data Error " + e);
        }
    }
}
