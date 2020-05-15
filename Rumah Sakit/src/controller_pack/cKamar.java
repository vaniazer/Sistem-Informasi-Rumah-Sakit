package controller_pack;
import view_pack.*;
import utama.*;

import javax.swing.*;
import java.awt.event.*;

public class cKamar {
    vKamar vKamar;
    Model model;
    int baris;
    String dataEdit;

    public cKamar(vKamar vKamar, Model model){
        this.vKamar = vKamar;
        this.model = model;

        if(model.getBanyakDokter() != 0 ){
            String kamar[][] = model.getKamar();
            vKamar.tabel.setModel((new JTable(kamar,vKamar.namaKolom)).getModel());
        } else {
            JOptionPane.showMessageDialog(null, "Data Pasien Tidak Ada");
            vKamar.btnEdit.setEnabled(false);
            vKamar.btnHapus.setEnabled(false);
        }

        vKamar.btnRefresh.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    updateKamar();
                } catch (Exception e1){
                    System.out.println("Gagal button refresh kamar");
                }
            }
        });

        vKamar.tfSearch.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                vKamar.tfSearch.setText("");
            }
        });

        vKamar.btnSearch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    String cari = vKamar.getSearch();
                    String kamar[][] = model.searchKamar(cari);
                    vKamar.tabel.setModel((new JTable(kamar,vKamar.namaKolom)).getModel());
                } catch (Exception e1){
                    System.out.println("Gagal button search Kamar");
                }
            }
        });

        vKamar.btnKembali.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    vKamar.dispose();
                } catch (Exception e1){
                    System.out.println("Gagal button kembali Kamar");
                }
            }
        });

        vKamar.tfHarga.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                try{
                    int harga = Integer.parseInt(vKamar.getHargaKamar());
                    vKamar.btnTambah.setEnabled(true);
                    vKamar.lValidharga.setText("");
                } catch (NumberFormatException numberFormatException){
                    vKamar.btnTambah.setEnabled(false);
                    vKamar.lValidharga.setText("invalid number");
                }
            }
        });

        vKamar.tabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                baris = vKamar.tabel.getSelectedRow();
                dataEdit = vKamar.tabel.getValueAt(baris,0).toString();
                if(dataEdit!=null){
                    vKamar.btnEdit.setEnabled(true);
                    vKamar.btnHapus.setEnabled(true);
                }
            }
        });

        vKamar.btnTambah.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    if(vKamar.getNamaKamar().equals("") || vKamar.getHargaKamar().equals("")){
                        JOptionPane.showMessageDialog(null, "Data masih ada yang kosong");
                    }
                    else{
                        String nama = vKamar.getNamaKamar();
                        int harga = Integer.parseInt(vKamar.getHargaKamar());
                        model.insertKamar(nama,harga);
                        updateKamar();
                        vKamar.tfNama.setText("");
                        vKamar.tfHarga.setText("");
                    }
                } catch (Exception e1){
                    System.out.println("Gagal button tambah Kamar");
                }
            }
        });

        vKamar.btnEdit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if(dataEdit!=null){
                        int id_ruang = Integer.parseInt(vKamar.tabel.getValueAt(baris,1).toString());
                        String namaA = vKamar.tabel.getValueAt(baris,2).toString();
                        String hargaA = vKamar.tabel.getValueAt(baris,3).toString();

                        vEditKamar vEditKamar = new vEditKamar();
                        vKamar.dispose();
                        vEditKamar.tfNama.setText(namaA);
                        vEditKamar.tfHarga.setText(hargaA);

                        vEditKamar.tfHarga.addKeyListener(new KeyAdapter() {
                            @Override
                            public void keyTyped(KeyEvent e) {
                                try{
                                    int harga =Integer.parseInt(vEditKamar.getHargaKamar());
                                    vEditKamar.btnSimpan.setEnabled(true);
                                }catch (NumberFormatException e1){
                                    vEditKamar.btnSimpan.setEnabled(false);
                                }
                            }
                        });

                        vEditKamar.btnSimpan.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                try{
                                    if(vEditKamar.getNamaKamar().equals("") || vEditKamar.getHargaKamar().equals("")){
                                        JOptionPane.showMessageDialog(null, "Data masih ada yang kosong");
                                    }
                                    else{
                                        String namaE = vEditKamar.getNamaKamar();
                                        int hargaE = Integer.parseInt(vEditKamar.getHargaKamar());
                                        model.updateKamar(id_ruang,namaE,hargaE);
                                        updateKamar();
                                        vEditKamar.dispose();
                                        vKamar vKamar1 = new vKamar();
                                        cKamar cKamar = new cKamar(vKamar1,model);
                                    }
                                } catch (Exception e1){
                                    System.out.println("Gagal button simpan Edit Kamar");
                                }
                            }
                        });

                        vEditKamar.btnKembali.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                try{
                                    vEditKamar.dispose();
                                } catch (Exception e1){
                                    System.out.println("Gagal button kembali Edit Dokter");
                                }
                            }
                        });
                    }
                } catch (Exception e1){
                    System.out.println("Gagal button edit kamar");
                }
            }
        });

        vKamar.btnHapus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    if(dataEdit!=null){
                        int no_kamar = Integer.parseInt(vKamar.tabel.getValueAt(baris,1).toString());
                        model.deleteKamar(no_kamar);
                        updateKamar();
                        vKamar.btnHapus.setEnabled(false);
                        vKamar.btnEdit.setEnabled(false);
                    }
                } catch (Exception e1){
                    System.out.println("Gagal button hapus Kamar");
                }
            }
        });

    }

    public void updateKamar(){
        String kamar[][] = model.getKamar();
        vKamar.tabel.setModel((new JTable(kamar,vKamar.namaKolom)).getModel());
    }
}
