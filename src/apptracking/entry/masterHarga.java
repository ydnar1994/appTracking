/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apptracking.entry;

import apptracking.funct.functionCollection;
import apptracking.funct.koneksi;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Randy_Machfud
 */
public class masterHarga extends javax.swing.JPanel {

    private DefaultTableModel tabHarga;
    private Connection conn = new koneksi().connect();
    private functionCollection funct = new functionCollection();
    private String idOld = "";
    private String jnsOld = "";
    private String tujOld="";

    /**
     * Creates new form masterArmada
     */
    public masterHarga() {
        initComponents();
        grpTarif.add(rdJawa);
        grpTarif.add(rdNonJawa);
        Object[] baris = {"Type", "Jenis", "Tujuan","Tarif", "PTP", "DTP / PTD", "DTD"};
        tabHarga = new DefaultTableModel(null, baris);

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

        grpTarif = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        cmbType = new javax.swing.JComboBox();
        cmbJenis = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtTujuan = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtPTP = new javax.swing.JTextField();
        btnSimpan = new javax.swing.JButton();
        btnHapus = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblArmada = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        txtDTP = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtDTD = new javax.swing.JTextField();
        btnUlang = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        rdJawa = new javax.swing.JRadioButton();
        rdNonJawa = new javax.swing.JRadioButton();

        setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Lucida Bright", 1, 12)); // NOI18N
        jLabel1.setText("Tipe Kendaraan");

        cmbType.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Truk", "Container", "Kapal" }));
        cmbType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbTypeActionPerformed(evt);
            }
        });

        cmbJenis.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Engkel", "Engkel Double", "Tronton 8 Meter", "Tronton 9,5 Meter", "Fuso 6 Meter" }));

        jLabel2.setFont(new java.awt.Font("Lucida Bright", 1, 12)); // NOI18N
        jLabel2.setText("Jenis Kendaraan");

        jLabel3.setFont(new java.awt.Font("Lucida Bright", 1, 12)); // NOI18N
        jLabel3.setText("Tujuan");

        txtTujuan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTujuanActionPerformed(evt);
            }
        });
        txtTujuan.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTujuanKeyTyped(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Lucida Bright", 1, 12)); // NOI18N
        jLabel5.setText("Harga PTP");

        txtPTP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPTPActionPerformed(evt);
            }
        });
        txtPTP.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPTPKeyTyped(evt);
            }
        });

        btnSimpan.setBackground(new java.awt.Color(56, 86, 35));
        btnSimpan.setFont(new java.awt.Font("Lucida Bright", 1, 12)); // NOI18N
        btnSimpan.setForeground(new java.awt.Color(255, 255, 255));
        btnSimpan.setText("Simpan");
        btnSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSimpanActionPerformed(evt);
            }
        });

        btnHapus.setBackground(new java.awt.Color(56, 86, 35));
        btnHapus.setFont(new java.awt.Font("Lucida Bright", 1, 12)); // NOI18N
        btnHapus.setForeground(new java.awt.Color(255, 255, 255));
        btnHapus.setText("Hapus");
        btnHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHapusActionPerformed(evt);
            }
        });

        tblArmada.setModel(new javax.swing.table.DefaultTableModel(
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
        tblArmada.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblArmadaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblArmada);

        jLabel7.setFont(new java.awt.Font("Lucida Bright", 1, 12)); // NOI18N
        jLabel7.setText("Harga DTP / PTD");

        txtDTP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDTPActionPerformed(evt);
            }
        });
        txtDTP.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDTPKeyTyped(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Lucida Bright", 1, 12)); // NOI18N
        jLabel8.setText("Harga DTD");

        txtDTD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDTDActionPerformed(evt);
            }
        });
        txtDTD.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDTDKeyTyped(evt);
            }
        });

        btnUlang.setBackground(new java.awt.Color(56, 86, 35));
        btnUlang.setFont(new java.awt.Font("Lucida Bright", 1, 12)); // NOI18N
        btnUlang.setForeground(new java.awt.Color(255, 255, 255));
        btnUlang.setText("Ulang");
        btnUlang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUlangActionPerformed(evt);
            }
        });

        jLabel4.setText("Rp.");

        jLabel6.setText("Rp.");

        jLabel9.setText("Rp.");

        jLabel10.setFont(new java.awt.Font("Lucida Bright", 1, 12)); // NOI18N
        jLabel10.setText("Tarif");

        rdJawa.setFont(new java.awt.Font("Lucida Bright", 1, 12)); // NOI18N
        rdJawa.setText("Pulau Jawa");
        rdJawa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdJawaActionPerformed(evt);
            }
        });

        rdNonJawa.setFont(new java.awt.Font("Lucida Bright", 1, 12)); // NOI18N
        rdNonJawa.setText("Non Pulau Jawa");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnSimpan, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnHapus, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnUlang, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(39, 39, 39)
                        .addGap(4, 4, 4)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtPTP, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtDTD, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtDTP, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jLabel7)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1)
                            .addComponent(jLabel10))
                        .addGap(40, 40, 40)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(rdJawa)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(rdNonJawa))
                            .addComponent(txtTujuan, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(cmbType, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(cmbJenis, javax.swing.GroupLayout.Alignment.LEADING, 0, 150, Short.MAX_VALUE)))))
                .addContainerGap(39, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .addComponent(cmbType))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .addComponent(cmbJenis))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtTujuan, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(rdJawa)
                    .addComponent(rdNonJawa))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPTP, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDTP, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDTD, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSimpan, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnHapus, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnUlang, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtPTPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPTPActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPTPActionPerformed

    private void txtPTPKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPTPKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPTPKeyTyped

    private void cmbTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbTypeActionPerformed
        doLoadComboItemType();
    }//GEN-LAST:event_cmbTypeActionPerformed

    private void doLoadComboItemType() {
        if (cmbType.getSelectedItem() != null) {
            cmbJenis.removeAllItems();
            String type = (String) cmbType.getSelectedItem().toString();
            if (type.toUpperCase().equalsIgnoreCase("TRUK")) {
                cmbJenis.addItem("Engkel");
                cmbJenis.addItem("Engkel Double");
                cmbJenis.addItem("Tronton 8 Meter");
                cmbJenis.addItem("Tronton 9,5 Meter");
                cmbJenis.addItem("Fuso 6 Meter");
            } else if (type.toUpperCase().equalsIgnoreCase("KAPAL")) {
                cmbJenis.addItem("LCT 1000 DWT");
                cmbJenis.addItem("LCT 1200 DWT");
                cmbJenis.addItem("LCT 1500 DWT");
            } else {
                cmbJenis.addItem("Container 20FT");
                cmbJenis.addItem("Container 40FT");

            }

        }
    }

    private void btnSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpanActionPerformed
        String msg = "";
        if (validation()) {
            if (idOld.equalsIgnoreCase("") && jnsOld.equalsIgnoreCase("") && tujOld.equalsIgnoreCase("")) {
                msg = "Simpan";
            } else {
                msg = "Ubah";
            }
            int result = JOptionPane.showConfirmDialog(getParent(), "Yakin data akan di " + msg + " ?", "Konfimasi", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (result == JOptionPane.YES_OPTION) {
                if ((idOld == null || idOld.equalsIgnoreCase("")) && (jnsOld.equalsIgnoreCase("") || jnsOld == null) && (tujOld.equalsIgnoreCase("") || tujOld==null) ) {
                    String type = cmbType.getSelectedItem().toString().toUpperCase().equalsIgnoreCase("TRUK") ? "01"
                            : cmbType.getSelectedItem().toString().toUpperCase().equalsIgnoreCase("KAPAL") ? "03" : "02";
                    String jenis = cmbJenis.getSelectedItem().toString().toUpperCase().replaceAll(" ", "").equalsIgnoreCase("ENGKEL") ? "0101"
                            : cmbJenis.getSelectedItem().toString().toUpperCase().replaceAll(" ", "").equalsIgnoreCase("ENGKELDOUBLE") ? "0102"
                            : cmbJenis.getSelectedItem().toString().toUpperCase().replaceAll(" ", "").equalsIgnoreCase("TRONTON8METER") ? "0103"
                            : cmbJenis.getSelectedItem().toString().toUpperCase().replaceAll(" ", "").equalsIgnoreCase("TRONTON9,5METER") ? "0104"
                            : cmbJenis.getSelectedItem().toString().toUpperCase().replaceAll(" ", "").equalsIgnoreCase("FUSO6METER") ? "0105"
                            : cmbJenis.getSelectedItem().toString().toUpperCase().replaceAll(" ", "").equalsIgnoreCase("CONTAINER20FT") ? "0201"
                            : cmbJenis.getSelectedItem().toString().toUpperCase().replaceAll(" ", "").equalsIgnoreCase("CONTAINER40FT") ? "0202"
                            : cmbJenis.getSelectedItem().toString().toUpperCase().replaceAll(" ", "").equalsIgnoreCase("LCT1000DWT") ? "0301"
                            : cmbJenis.getSelectedItem().toString().toUpperCase().replaceAll(" ", "").equalsIgnoreCase("LCT1200DWT") ? "0302" : "0303";
                    String tujuan = txtTujuan.getText();
                    String PTP=txtPTP.getText();
                    String DTP=txtDTP.getText();
                    String DTD=txtDTD.getText();
                    
                   
                    try {
                        String sqlInsert = " insert into mst_harga (type,jenis,tujuan,PTP,DTP,DTD,usrcrt,dtcrt) "
                                + "        values ('" + type + "' , '" + jenis + "', '" + tujuan + "', '" + PTP + "' , '" + DTP + "' , '" + DTD + "' , '" + "test" + "' , '" + funct.setDateToString(new Date()) + "') ";
                        Statement stat = conn.createStatement();
                        stat.execute(sqlInsert);
                        doLoadDataTable();
                        doReset();
                        //tidakAktif();
                        JOptionPane.showMessageDialog(null, "Data berhasil di simpan.");
                    } catch (Exception e) {
                        System.out.println("Gagal Simpan Data Error " + e);
                        JOptionPane.showMessageDialog(null, "Data gagal di simpan." + e);
                    }
                } else {
                    String type = cmbType.getSelectedItem().toString().toUpperCase().equalsIgnoreCase("TRUK") ? "01"
                            : cmbType.getSelectedItem().toString().toUpperCase().equalsIgnoreCase("KAPAL") ? "03" : "02";
                    String jenis = cmbJenis.getSelectedItem().toString().toUpperCase().replaceAll(" ", "").equalsIgnoreCase("ENGKEL") ? "0101"
                            : cmbJenis.getSelectedItem().toString().toUpperCase().replaceAll(" ", "").equalsIgnoreCase("ENGKELDOUBLE") ? "0102"
                            : cmbJenis.getSelectedItem().toString().toUpperCase().replaceAll(" ", "").equalsIgnoreCase("TRONTON8METER") ? "0103"
                            : cmbJenis.getSelectedItem().toString().toUpperCase().replaceAll(" ", "").equalsIgnoreCase("TRONTON9,5METER") ? "0104"
                            : cmbJenis.getSelectedItem().toString().toUpperCase().replaceAll(" ", "").equalsIgnoreCase("FUSO6METER") ? "0105"
                            : cmbJenis.getSelectedItem().toString().toUpperCase().replaceAll(" ", "").equalsIgnoreCase("CONTAINER20FT") ? "0201"
                            : cmbJenis.getSelectedItem().toString().toUpperCase().replaceAll(" ", "").equalsIgnoreCase("CONTAINER40FT") ? "0202"
                            : cmbJenis.getSelectedItem().toString().toUpperCase().replaceAll(" ", "").equalsIgnoreCase("LCT1000DWT") ? "0301"
                            : cmbJenis.getSelectedItem().toString().toUpperCase().replaceAll(" ", "").equalsIgnoreCase("LCT1200DWT") ? "0302" : "0303";
                    String tujuan = txtTujuan.getText();
                    String PTP=txtPTP.getText();
                    String DTP=txtDTP.getText();
                    String DTD=txtDTD.getText();
                    System.out.println("Combo :" + cmbJenis.getSelectedItem().toString().toUpperCase().replaceAll(" ", ""));
                    System.out.println("type New " + type);
                    System.out.println("Jenis New " + jenis);
                    System.out.println("Tujuan New "+tujuan);
                    System.out.println("type OLD " + idOld);
                    System.out.println("Jenis OLD " + jnsOld);
                    System.out.println("Tujuan OLD"+tujOld);
                    try {
                        String sqlUpdate = " update mst_harga set type = '" + type + "' ,"
                                + "                          jenis = '" + jenis + "', "
                                + "                          tujuan = '" + tujuan + "', "
                                + "                          PTP = '" + PTP + "', "
                                 + "                          DTP = '" + DTP + "', "
                                 + "                          DTD = '" + DTD + "' "
                                + "        where type = '" + idOld + "' and jenis = '" + jnsOld + "' and tujuan='" + tujOld + "'";
                        Statement stat = conn.createStatement();
                        stat.execute(sqlUpdate);
                        doLoadDataTable();
                        doReset();
                        JOptionPane.showMessageDialog(null, "Data berhasil di Ubah.");
                    } catch (Exception e) {
                        System.out.println("Gagal Ubah Data Error " + e);
                        JOptionPane.showMessageDialog(null, "Data gagal di Ubah." + e);
                    }
                }
            } else {

            }
        }
    }//GEN-LAST:event_btnSimpanActionPerformed

    private void btnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusActionPerformed
        if (idOld != null && !idOld.equals("") && jnsOld != null && !jnsOld.equals("") && tujOld !=null && !tujOld.equals("")) {
            int result = JOptionPane.showConfirmDialog(getParent(), "Yakin data akan di hapus ?", "Konfimasi", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (result == JOptionPane.YES_OPTION) {
                try {
                    String sqlDelete = " delete from mst_harga where type = '" + idOld + "' and jenis='" + jnsOld + "' ";
                    Statement stat = conn.createStatement();
                    stat.execute(sqlDelete);
                    doLoadDataTable();
                    doReset();
                    //tidakAktif();
                    JOptionPane.showMessageDialog(null, "Data berhasil di hapus.");
                    //conn.close();
                } catch (Exception e) {
                    System.out.println("Gagal Hapus Data Error " + e);
                    JOptionPane.showMessageDialog(null, "Data gagal di hapus." + e);
                }
            }
        }
    }//GEN-LAST:event_btnHapusActionPerformed

    private void tblArmadaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblArmadaMouseClicked
        if (tabHarga.getColumnCount() > 0) {
            //aktif();
            String[] rowData = new String[tabHarga.getColumnCount()];
            for (int col = 0; col < tabHarga.getColumnCount(); col++) {
                rowData[col] = String.valueOf(tabHarga.getValueAt(tblArmada.rowAtPoint(evt.getPoint()), col));
            }
            idOld = rowData[0].toUpperCase().equalsIgnoreCase("TRUK") ? "01"
                    : rowData[0].toUpperCase().equalsIgnoreCase("KAPAL") ? "03" : "02";
            cmbType.setSelectedItem(rowData[0]);
            doLoadComboItemType();
            jnsOld = rowData[1].toUpperCase().replaceAll(" ", "").equalsIgnoreCase("ENGKEL") ? "0101"
                    : rowData[1].toUpperCase().replaceAll(" ", "").equalsIgnoreCase("ENGKELDOUBLE") ? "0102"
                    : rowData[1].toUpperCase().replaceAll(" ", "").equalsIgnoreCase("TRONTON8METER") ? "0103"
                    : rowData[1].toUpperCase().replaceAll(" ", "").equalsIgnoreCase("TRONTON9,5METER") ? "0104"
                    : rowData[1].toUpperCase().replaceAll(" ", "").equalsIgnoreCase("FUSO6METER") ? "0105"
                    : rowData[1].toUpperCase().replaceAll(" ", "").equalsIgnoreCase("CONTAINER20FT") ? "0201"
                    : rowData[1].toUpperCase().replaceAll(" ", "").equalsIgnoreCase("CONTAINER40FT") ? "0202"
                    : rowData[1].toUpperCase().replaceAll(" ", "").equalsIgnoreCase("LCT1000DWT") ? "0301"
                    : rowData[1].toUpperCase().replaceAll(" ", "").equalsIgnoreCase("LCT1200DWT") ? "0302" : "0303";
            cmbJenis.setSelectedItem(rowData[1]);
            tujOld=(rowData[2]);
            txtTujuan.setText(rowData[2]);
            txtPTP.setText(rowData[3]);
            txtDTP.setText(rowData[4]);
            txtDTD.setText(rowData[5]);

            btnSimpan.setLabel("Ubah");
            cmbType.requestFocus();
        }
    }//GEN-LAST:event_tblArmadaMouseClicked

    private void txtDTPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDTPActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDTPActionPerformed

    private void txtDTPKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDTPKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDTPKeyTyped

    private void txtDTDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDTDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDTDActionPerformed

    private void txtDTDKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDTDKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDTDKeyTyped

    private void txtTujuanKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTujuanKeyTyped

    }//GEN-LAST:event_txtTujuanKeyTyped

    private void txtTujuanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTujuanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTujuanActionPerformed

    private void btnUlangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUlangActionPerformed
        doReset();
    }//GEN-LAST:event_btnUlangActionPerformed

    private void rdJawaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdJawaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rdJawaActionPerformed

    protected boolean validation() {
        boolean isValid = true;
        if (isValid) {
            if (cmbType.getSelectedItem() == null) {
                isValid = false;
                JOptionPane.showMessageDialog(null, "Type Kendaraan tidak boleh kosong");
                cmbType.requestFocus();
            } else {
                if (cmbType.getSelectedIndex() < 0) {
                    isValid = false;
                    JOptionPane.showMessageDialog(null, "Type Kendaraan tidak boleh kosong");
                    cmbType.requestFocus();
                }
            }

            if (cmbJenis.getSelectedItem() == null) {
                isValid = false;
                JOptionPane.showMessageDialog(null, "Jenis Kendaraan tidak boleh kosong");
                cmbJenis.requestFocus();
            } else {
                if (cmbJenis.getSelectedIndex() < 0) {
                    isValid = false;
                    JOptionPane.showMessageDialog(null, "Jenis Kendaraan tidak boleh kosong");
                    cmbJenis.requestFocus();
                }
            }
            
             if (grpTarif.getSelection()==null) {
                isValid = false;
                JOptionPane.showMessageDialog(null, "Tarif harus dipilih");
                rdJawa.requestFocus();
            }

            if (txtTujuan.getText() == null) {
                isValid = false;
                JOptionPane.showMessageDialog(null, "Tujuan tidak boleh kosong");
                txtTujuan.requestFocus();
            } else {
                if (txtTujuan.getText().equalsIgnoreCase("")) {
                    isValid = false;
                    JOptionPane.showMessageDialog(null, "Tujuan tidak boleh kosong");
                    txtTujuan.requestFocus();
                }
            }

            if (txtPTP.getText() == null) {
                isValid = false;
                JOptionPane.showMessageDialog(null, "Harga PTP tidak boleh kosong");
                txtPTP.requestFocus();
            } else {
                if (txtPTP.getText().equalsIgnoreCase("")) {
                    isValid = false;
                    JOptionPane.showMessageDialog(null, "Harga PTP tidak boleh kosong");
                    txtPTP.requestFocus();
                }
            }

            if (txtDTP.getText() == null) {
                isValid = false;
                JOptionPane.showMessageDialog(null, "Harga DTP tidak boleh kosong");
                txtDTP.requestFocus();
            } else {
                if (txtPTP.getText().equalsIgnoreCase("")) {
                    isValid = false;
                    JOptionPane.showMessageDialog(null, "Harga DTP tidak boleh kosong");
                    txtDTP.requestFocus();
                }
            }
            
            if(txtDTD.getText()==null){
                isValid=false;
                JOptionPane.showMessageDialog(null,"Harga DTD tidak boleh kosong");
                txtDTD.requestFocus();
            }else{
                if(txtDTD.getText().equalsIgnoreCase("")){
                    isValid=false;
                    JOptionPane.showMessageDialog(null,"Harga DTD tidak boleh kosong");
                    txtDTD.requestFocus();
                }
            }

        }
        return isValid;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnHapus;
    private javax.swing.JButton btnSimpan;
    private javax.swing.JButton btnUlang;
    private javax.swing.JComboBox cmbJenis;
    private javax.swing.JComboBox cmbType;
    private javax.swing.ButtonGroup grpTarif;
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
    private javax.swing.JRadioButton rdJawa;
    private javax.swing.JRadioButton rdNonJawa;
    private javax.swing.JTable tblArmada;
    private javax.swing.JTextField txtDTD;
    private javax.swing.JTextField txtDTP;
    private javax.swing.JTextField txtPTP;
    private javax.swing.JTextField txtTujuan;
    // End of variables declaration//GEN-END:variables

    private void doLoadDataTable() {
        tblArmada.revalidate();
        tblArmada.repaint();
        tblArmada.setModel(tabHarga);
        if (tabHarga.getRowCount() > 0) {
            tabHarga.setRowCount(0);
        }
        String sql = "select * from mst_harga";
        try {
            Statement stat = conn.createStatement();
            ResultSet hasil = stat.executeQuery(sql);

            while (hasil.next()) {
                String type = hasil.getString("type").equalsIgnoreCase("01") ? "Truk"
                        : hasil.getString("type").equalsIgnoreCase("03") ? "Kapal" : "Container";
                String jenis = hasil.getString("jenis").equalsIgnoreCase("0101") ? "Engkel"
                        : hasil.getString("jenis").equalsIgnoreCase("0102") ? "Engkel Double"
                        : hasil.getString("jenis").equalsIgnoreCase("0103") ? "Tronton 8 Meter"
                        : hasil.getString("jenis").equalsIgnoreCase("0104") ? "Tronton 9,5 Meter"
                        : hasil.getString("jenis").equalsIgnoreCase("0105") ? "Fuso 6 Meter"
                        : hasil.getString("jenis").equalsIgnoreCase("0201") ? "Container 20FT"
                        : hasil.getString("jenis").equalsIgnoreCase("0202") ? "Container 40FT"
                        : hasil.getString("jenis").equalsIgnoreCase("0301") ? "LCT 1000 DWT"
                        : hasil.getString("jenis").equalsIgnoreCase("0302") ? "LCT 1200 DWT" : "LCT 1500 DWT";
                String tujuan = hasil.getString("tujuan");
                String flgTarif = hasil.getString("flgtarif")!=null && hasil.getString("flgtarif").equals("1")?"Pulau Jawa":"Non Pulau Jawa";
                String PTP = hasil.getString("PTP");
                String DTP = hasil.getString("DTP");
                String DTD = hasil.getString("DTD");
                String[] data = {type, jenis, tujuan,flgTarif, PTP, DTP, DTD};
                tabHarga.addRow(data);
            }
        } catch (Exception e) {
            System.out.println("Menampilkan Data Error " + e);
        }
    }

    private void doReset() {
        idOld = "";
        jnsOld = "";
        tujOld="";
        btnSimpan.setLabel("Simpan");
        cmbType.setSelectedIndex(0);
        cmbJenis.setSelectedIndex(0);
        grpTarif.clearSelection();
        txtTujuan.setText("");
        txtPTP.setText("");
        txtDTP.setText("");
        txtDTD.setText("");
        cmbType.requestFocus();
    }
}
