package controller_pack;
import utama.*;
import view_pack.*;

import javax.swing.*;
import java.awt.event.*;

public class cDokter {
    vDokter vDokter;
    Model model;
    int baris;
    String dataEdit;

    public cDokter(vDokter vDokter, Model model){
        this.vDokter = vDokter;
        this.model = model;

        if(model.getBanyakDokter() != 0 ){
            String dokter[][] = model.getDokter();
            vDokter.tabel.setModel((new JTable(dokter,vDokter.namaKolom)).getModel());
        } else {
            JOptionPane.showMessageDialog(null, "Data Dokter Tidak Ada");
            vDokter.btnEdit.setEnabled(false);
            vDokter.btnHapus.setEnabled(false);
        }

        vDokter.btnRefresh.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    updateDokter();
                } catch (Exception e1){
                    System.out.println("Gagal button refresh Dokter");
                }
            }
        });

        vDokter.tfSearch.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                vDokter.tfSearch.setText("");
            }
        });

        vDokter.btnSearch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    String cari = vDokter.getSearch();
                    String dokter[][] = model.searchDokter(cari);
                    vDokter.tabel.setModel((new JTable(dokter,vDokter.namaKolom)).getModel());
                } catch (Exception e1){
                    System.out.println("Gagal button Search Dokter");
                }
            }
        });

        vDokter.btnKembali.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    vDokter.dispose();
                } catch (Exception e1){
                    System.out.println("Gagal button Kembali Dokter");
                }
            }
        });

        vDokter.tfTelepon.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                try{
                    int hp = Integer.parseInt(vDokter.getTeleponDokter());
                    vDokter.lValidtlp.setText("");
                    vDokter.btnTambah.setEnabled(true);
                }catch (NumberFormatException e1){
                    vDokter.lValidtlp.setText("invalid number");
                    vDokter.btnTambah.setEnabled(false);
                }
            }
        });

        vDokter.tfHarga.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                try{
                    int harga = Integer.parseInt(vDokter.getHargaDokter());
                    vDokter.lValidharga.setText("");
                    vDokter.btnTambah.setEnabled(true);
                }catch (NumberFormatException e1){
                    vDokter.lValidharga.setText("invalid number");
                    vDokter.btnTambah.setEnabled(false);
                }
            }
        });

        vDokter.tabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                baris = vDokter.tabel.getSelectedRow();
                dataEdit = vDokter.tabel.getValueAt(baris,0).toString();
                if(dataEdit!=null){
                    vDokter.btnEdit.setEnabled(true);
                    vDokter.btnHapus.setEnabled(true);
                }
            }
        });

        vDokter.btnTambah.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    if(vDokter.getNamaDokter().equals("") || vDokter.getTeleponDokter().equals("") ||
                            vDokter.getSpesialis().equals("") || vDokter.getGenderDokter().equals("") ||
                            vDokter.getAlamatDokter().equals("") || vDokter.getHargaDokter().equals("")){
                        JOptionPane.showMessageDialog(null, "Data masih ada yang kosong");
                    }
                    else{
                        String nama = vDokter.getNamaDokter();
                        String telp = vDokter.getTeleponDokter();
                        String spesialis = vDokter.getSpesialis();
                        String gender = vDokter.getGenderDokter();
                        String alamat = vDokter.getAlamatDokter();
                        int harga = Integer.parseInt(vDokter.getHargaDokter());
                        if(telp.length()>=9 && telp.length()<=13){
                            model.insertDokter(nama,spesialis,telp,gender,alamat,harga);
                            updateDokter();
                            vDokter.tfNama.setText("");
                            vDokter.tfTelepon.setText("");
                            vDokter.tfAlamat.setText("");
                            vDokter.tfHarga.setText("");
                            vDokter.tfSpesialis.setSelectedItem("Umum");
                            vDokter.tfGender.clearSelection();
                        }
                    }
                } catch (Exception e1){
                    System.out.println("Gagal button tambah dokter");
                }
            }
        });

        vDokter.btnEdit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    if(dataEdit!=null){
                        int no_dokter = Integer.parseInt(vDokter.tabel.getValueAt(baris,1).toString());
                        String namaA = vDokter.tabel.getValueAt(baris,2).toString();
                        String spesialisA = vDokter.tabel.getValueAt(baris,3).toString();
                        String telpA = vDokter.tabel.getValueAt(baris,4).toString();
                        String genderA = vDokter.tabel.getValueAt(baris,5).toString();
                        String alamatA = vDokter.tabel.getValueAt(baris,6).toString();
                        String hargaA = vDokter.tabel.getValueAt(baris,7).toString();
                        String[] spesialis = {"Umum","Kandungan","Gigi","Bedah","Penyakit Dalam","Kulit","THT"};

                        vEditDokter vEditDokter = new vEditDokter();
                        vDokter.dispose();
                        vEditDokter.tfNama.setText(namaA);
                        for(int i=0; i<7; i++){
                            if(spesialisA.equals(spesialis[i])){
                                vEditDokter.tfSpesialis.setSelectedItem(spesialis[i]);
                            }
                        }
                        vEditDokter.tfTelepon.setText(telpA);
                        if(genderA.equals("Laki-Laki")){
                            vEditDokter.gender1.setSelected(true);
                        }
                        else{
                            vEditDokter.gender2.setSelected(true);
                        }
                        vEditDokter.tfAlamat.setText(alamatA);
                        vEditDokter.tfHarga.setText(hargaA);

                        vEditDokter.tfTelepon.addKeyListener(new KeyAdapter() {
                            @Override
                            public void keyTyped(KeyEvent e) {
                                try{
                                    int hp = Integer.parseInt(vEditDokter.getTeleponDokter());
                                    vEditDokter.btnSimpan.setEnabled(true);
                                }catch (NumberFormatException e1){
                                    vEditDokter.btnSimpan.setEnabled(false);
                                }
                            }
                        });

                        vEditDokter.tfHarga.addKeyListener(new KeyAdapter() {
                            @Override
                            public void keyTyped(KeyEvent e) {
                                try{
                                    int harga = Integer.parseInt(vEditDokter.getHargaDokter());
                                    vEditDokter.btnSimpan.setEnabled(true);
                                }catch (NumberFormatException e1){
                                    vEditDokter.btnSimpan.setEnabled(false);
                                }
                            }
                        });

                        vEditDokter.btnSimpan.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                try{
                                    if(vEditDokter.getNamaDokter().equals("") || vEditDokter.getTeleponDokter().equals("") ||
                                            vEditDokter.getSpesialis().equals("") || vEditDokter.getGenderDokter().equals("") ||
                                            vEditDokter.getAlamatDokter().equals("") || vEditDokter.getHargaDokter().equals("")){
                                        JOptionPane.showMessageDialog(null, "Data masih ada yang kosong");
                                    }
                                    else{
                                        String namaE = vEditDokter.getNamaDokter();
                                        String telpE = vEditDokter.getTeleponDokter();
                                        String spesialisE = vEditDokter.getSpesialis();
                                        String genderE = vEditDokter.getGenderDokter();
                                        String alamatE = vEditDokter.getAlamatDokter();
                                        int hargaE = Integer.parseInt(vEditDokter.getHargaDokter());

                                        model.updateDokter(no_dokter,namaE,spesialisE,telpE,genderE,alamatE,hargaE);
                                        vEditDokter.dispose();
                                        vDokter vDokter1 = new vDokter();
                                        cDokter cDokter = new cDokter(vDokter1,model);
                                    }
                                } catch (Exception e1){
                                    System.out.println("Gagal button simpan Edit Dokter");
                                }
                            }
                        });

                        vEditDokter.btnKembali.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                try{
                                    vEditDokter.dispose();
                                } catch (Exception e1){
                                    System.out.println("Gagal button kembali Edit Dokter");
                                }
                            }
                        });
                    }
                } catch (Exception e1){
                    System.out.println("Gagal button Edit Dokter");
                }
            }
        });

        vDokter.btnHapus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    if(dataEdit!=null){
                        int no_dokter = Integer.parseInt(vDokter.tabel.getValueAt(baris,1).toString());
                        model.deleteDokter(no_dokter);
                        updateDokter();
                        vDokter.btnEdit.setEnabled(false);
                        vDokter.btnHapus.setEnabled(false);
                    }
                } catch (Exception e1){
                    System.out.println("Gagal button Hapus Dokter");
                }
            }
        });
    }

    public void updateDokter(){
        String dokter[][] = model.getDokter();
        vDokter.tabel.setModel((new JTable(dokter,vDokter.namaKolom)).getModel());
    }
}
