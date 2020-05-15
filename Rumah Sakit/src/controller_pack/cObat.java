package controller_pack;
import view_pack.*;
import utama.*;

import javax.swing.*;
import java.awt.event.*;

public class cObat {
    vObat vObat;
    Model model;
    int baris;
    String dataEdit;

    public cObat(vObat vObat, Model model){
        this.vObat = vObat;
        this.model = model;

        if(model.getBanyakObat() != 0 ){
            String obat[][] = model.getObat();
            vObat.tabel.setModel((new JTable(obat,vObat.namaKolom)).getModel());
        } else {
            JOptionPane.showMessageDialog(null, "Data Obat Tidak Ada");
            vObat.btnEdit.setEnabled(false);
            vObat.btnHapus.setEnabled(false);
        }

        vObat.btnRefresh.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    updateObat();
                } catch (Exception e1){
                    System.out.println("Gagal button refresh obat");
                }
            }
        });

        vObat.tfSearch.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                vObat.tfSearch.setText("");
            }
        });

        vObat.btnSearch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    String cari = vObat.getSearch();
                    String obat[][] = model.searchObat(cari);
                    vObat.tabel.setModel((new JTable(obat,vObat.namaKolom)).getModel());
                } catch (Exception e1){
                    System.out.println("Gagal button search Obat");
                }
            }
        });

        vObat.btnKembali.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    vObat.dispose();
                } catch (Exception e1){
                    System.out.println("Gagal button kembali Obat");
                }
            }
        });

        vObat.tfHarga.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                try{
                    int harga = Integer.parseInt(vObat.getHargaObat());
                    vObat.btnTambah.setEnabled(true);
                    vObat.lValidharga.setText("");
                } catch (NumberFormatException numberFormatException){
                    vObat.btnTambah.setEnabled(false);
                    vObat.lValidharga.setText("invalid number");
                }
            }
        });

        vObat.tfJumlah.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                try{
                    int jumlah = Integer.parseInt(vObat.getHargaObat());
                    vObat.btnTambah.setEnabled(true);
                    vObat.lValidjumlah.setText("");
                } catch (NumberFormatException numberFormatException){
                    vObat.btnTambah.setEnabled(false);
                    vObat.lValidjumlah.setText("invalid number");
                }
            }
        });

        vObat.tabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                baris = vObat.tabel.getSelectedRow();
                dataEdit = vObat.tabel.getValueAt(baris,0).toString();
                if(dataEdit!=null){
                    vObat.btnHapus.setEnabled(true);
                    vObat.btnEdit.setEnabled(true);
                }
            }
        });

        vObat.btnTambah.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    if(vObat.tfNama.equals("") || vObat.tfJumlah.equals("") || vObat.tfHarga.equals("")){
                        JOptionPane.showMessageDialog(null, "Data masih ada yang kosong");
                    }
                    else{
                        String nama = vObat.getNamaObat();
                        int jumlah = Integer.parseInt(vObat.getJumlahObat());
                        int harga = Integer.parseInt(vObat.getHargaObat());
                        model.insertObat(nama,harga,jumlah);
                        updateObat();
                        vObat.tfNama.setText("");
                        vObat.tfHarga.setText("");
                        vObat.tfJumlah.setText("");
                    }
                } catch (Exception e1){
                    System.out.println("Gagal button tambah Obat");
                }
            }
        });

        vObat.btnEdit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    if(dataEdit!=null){
                        int no_obat = Integer.parseInt(vObat.tabel.getValueAt(baris,1).toString());
                        String namaA = vObat.tabel.getValueAt(baris,2).toString();
                        String hargaA = vObat.tabel.getValueAt(baris,3).toString();
                        String jumlahA = vObat.tabel.getValueAt(baris,4).toString();

                        vEditObat vEditObat = new vEditObat();
                        vObat.dispose();

                        vEditObat.tfNama.setText(namaA);
                        vEditObat.tfHarga.setText(hargaA);
                        vEditObat.tfJumlah.setText(jumlahA);

                        vEditObat.tfHarga.addKeyListener(new KeyAdapter() {
                            @Override
                            public void keyTyped(KeyEvent e) {
                                try{
                                    int harga = Integer.parseInt(vEditObat.getHargaObat());
                                    vEditObat.btnSimpan.setEnabled(true);
                                } catch (NumberFormatException numberFormatException){
                                    vEditObat.btnSimpan.setEnabled(false);
                                }
                            }
                        });

                        vEditObat.tfJumlah.addKeyListener(new KeyAdapter() {
                            @Override
                            public void keyTyped(KeyEvent e) {
                                try{
                                    int jumlah = Integer.parseInt(vEditObat.getJumlahObat());
                                    vEditObat.btnSimpan.setEnabled(true);
                                } catch (NumberFormatException numberFormatException){
                                    vEditObat.btnSimpan.setEnabled(false);
                                }
                            }
                        });

                        vEditObat.btnSimpan.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                try{
                                    if(vEditObat.tfNama.equals("") || vEditObat.tfJumlah.equals("") || vEditObat.tfHarga.equals("")){
                                        JOptionPane.showMessageDialog(null, "Data masih ada yang kosong");
                                    }
                                    else{
                                        String namaE = vEditObat.getNamaObat();
                                        int jumlahE = Integer.parseInt(vEditObat.getJumlahObat());
                                        int hargaE = Integer.parseInt(vEditObat.getHargaObat());
                                        model.updateObat(no_obat,namaE,hargaE,jumlahE);
                                        vEditObat.dispose();
                                        vObat vObat1 = new vObat();
                                        cObat cObat = new cObat(vObat1,model);
                                    }
                                } catch (Exception e1){
                                    System.out.println("Gagal button simpan Edit Obat");
                                }
                            }
                        });
                        vEditObat.btnKembali.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                try{
                                    vEditObat.dispose();
                                } catch (Exception e1){
                                    System.out.println("Gagal button kembali Obat");
                                }
                            }
                        });
                    }
                } catch (Exception e1){
                    System.out.println("Gagal button edit obat");
                }
            }
        });

        vObat.btnHapus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    if(dataEdit!=null){
                        int no_obat = Integer.parseInt(vObat.tabel.getValueAt(baris,1).toString());
                        model.deleteObat(no_obat);
                        updateObat();
                        vObat.btnHapus.setEnabled(false);
                        vObat.btnEdit.setEnabled(false);
                    }
                } catch (Exception e1){
                    System.out.println("Gagal button hapus Obat");
                }
            }
        });

    }

    public void updateObat(){
        String obat[][] = model.getObat();
        vObat.tabel.setModel((new JTable(obat,vObat.namaKolom)).getModel());
    }
}
