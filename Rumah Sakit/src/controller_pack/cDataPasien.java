package controller_pack;
import view_pack.*;
import utama.*;

import javax.swing.*;
import java.awt.event.*;
import java.sql.SQLOutput;

public class cDataPasien {
    vPasien vPasien;
    Model model;
    String dataEdit = null;
    int baris, kolom;

    public cDataPasien(vPasien vPasien, Model model){
        this.vPasien = vPasien;
        this.model = model;

        if(model.getBanyakPasien() != 0 ){
            String pasien[][] = model.getPasien();
            vPasien.tabel.setModel((new JTable(pasien, vPasien.namaKolom)).getModel());
        } else {
            JOptionPane.showMessageDialog(null, "Data Pasien Tidak Ada");
        }

        vPasien.btnRefresh.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    updatePasien();
                } catch (Exception e1){
                    System.out.println("Gagal button refresh pasien");
                }
            }
        });

        vPasien.tfSearch.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                vPasien.tfSearch.setText("");
            }
        });

        vPasien.btnSearch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    String cari = vPasien.getSearch();
                    String pasien[][] = model.searchPasien(cari);
                    vPasien.tabel.setModel((new JTable(pasien, vPasien.namaKolom)).getModel());
                } catch (Exception e1){
                    System.out.println("Gagal button Search Pasien");
                }
            }
        });

        vPasien.btnKembali.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    vPasien.dispose();
                } catch (Exception e1){
                    System.out.println("Gagal button Back Pasien!!");
                }
            }
        });

        vPasien.btnTambah.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    if(vPasien.getNamaPasien().equals("") ||
                            vPasien.getTeleponPasien().equals("") ||
                            vPasien.getUmurPasien().equals("") ||
                            vPasien.getGenderPasien().equals("") ||
                            vPasien.getPekerjaan().equals("") ||
                            vPasien.getAlamatPasien().equals("")) {
                        JOptionPane.showMessageDialog(null, "Data masih ada yang kosong");
                    }
                    else{
                        String Nama = vPasien.getNamaPasien();
                        String HP = vPasien.getTeleponPasien();
                        int Umur =  Integer.parseInt(vPasien.getUmurPasien());
                        String Gender = vPasien.getGenderPasien();
                        String Pekerjaan = vPasien.getPekerjaan();
                        String Alamat = vPasien.getAlamatPasien();
                        if(HP.length()>=9 && HP.length()<=13){
                            model.insertPasien(Nama,HP,Umur,Gender,Pekerjaan,Alamat);
                            updatePasien();
                            vPasien.tfNama.setText("");
                            vPasien.tfTelepon.setText("");
                            vPasien.tfUmur.setText("");
                            vPasien.tfGender.clearSelection();
                            vPasien.tfPekerjaan.setSelectedItem("Tidak Bekerja");
                            vPasien.tfAlamat.setText("");
                        }
                    }
                } catch (Exception e1){
                    System.out.println("Gagal Button Tambah!!");
                }
            }
        });

        vPasien.tfTelepon.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                try{
                    int hp =Integer.parseInt(vPasien.getTeleponPasien());
                    vPasien.lValidtlp.setText("");
                    vPasien.btnTambah.setEnabled(true);
                }catch (NumberFormatException e1){
                    vPasien.lValidtlp.setText("invalid number");
                    vPasien.btnTambah.setEnabled(false);
                }
            }
        });
        vPasien.tfUmur.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                try{
                    int umur = Integer.parseInt(vPasien.getUmurPasien());
                    vPasien.lValidumur.setText("");
                    vPasien.btnTambah.setEnabled(true);
                } catch (NumberFormatException e1){
                    vPasien.lValidumur.setText("invalid number");
                    vPasien.btnTambah.setEnabled(false);
                }
            }
        });

        vPasien.tabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                baris = vPasien.tabel.getSelectedRow();
                kolom = vPasien.tabel.getSelectedColumn();
                dataEdit = vPasien.tabel.getValueAt(baris,0).toString();
                if(dataEdit!=null){
                    vPasien.btnEdit.setEnabled(true);
                    vPasien.btnHapus.setEnabled(true);
                }
            }
        });

        vPasien.btnEdit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    if(dataEdit!=null){
                        int no_pasien = Integer.parseInt(String.valueOf(vPasien.tabel.getValueAt(baris,1)));
                        String namaA =vPasien.tabel.getValueAt(baris,2).toString();
                        String telpA =vPasien.tabel.getValueAt(baris,3).toString();
                        String umurA =vPasien.tabel.getValueAt(baris,4).toString();
                        String genderA =vPasien.tabel.getValueAt(baris,5).toString();
                        String kerjaA =vPasien.tabel.getValueAt(baris,6).toString();
                        String alamatA =vPasien.tabel.getValueAt(baris,7).toString();
                        String[] pekerjaan = {"Tidak Bekerja","Ibu Rumah Tangga","Pelajar/Mahasiswa","Pensiun","Aparat Negara","PNS","Tenaga Medis"};

                        vEditPasien vEditPasien = new vEditPasien();
                        vPasien.dispose();
                        vEditPasien.tfNama.setText(namaA);
                        vEditPasien.tfTelepon.setText(telpA);
                        vEditPasien.tfUmur.setText(umurA);
                        if(genderA.equals("Laki-Laki")){
                            vEditPasien.gender1.setSelected(true);
                        }
                        else{
                            vEditPasien.gender2.setSelected(true);
                        }
                        for(int i=0; i<7; i++){
                            if(kerjaA.equals(pekerjaan[i])){
                                vEditPasien.tfPekerjaan.setSelectedItem(pekerjaan[i]);
                            }
                        }
                        vEditPasien.tfAlamat.setText(alamatA);

                        vEditPasien.tfTelepon.addKeyListener(new KeyAdapter() {
                            @Override
                            public void keyTyped(KeyEvent e) {
                                try{
                                    int hp =Integer.parseInt(vEditPasien.getTeleponPasien());
                                    vEditPasien.btnSimpan.setEnabled(true);
                                }catch (NumberFormatException e1){
                                    vEditPasien.btnSimpan.setEnabled(false);
                                }
                            }
                        });

                        vEditPasien.tfUmur.addKeyListener(new KeyAdapter() {
                            @Override
                            public void keyTyped(KeyEvent e) {
                                try{
                                    int umur =Integer.parseInt(vEditPasien.getUmurPasien());
                                    vEditPasien.btnSimpan.setEnabled(true);
                                }catch (NumberFormatException e1){
                                    vEditPasien.btnSimpan.setEnabled(false);
                                }
                            }
                        });

                        vEditPasien.btnSimpan.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                try{
                                    if(vEditPasien.getNamaPasien().equals("") ||
                                            vEditPasien.getTeleponPasien().equals("") ||
                                            vEditPasien.getUmurPasien().equals("") ||
                                            vEditPasien.getGenderPasien().equals("") ||
                                            vEditPasien.getPekerjaan().equals("") ||
                                            vEditPasien.getAlamatPasien().equals("")) {
                                        JOptionPane.showMessageDialog(null, "Data masih ada yang kosong");
                                    }
                                    else{
                                        String namaE = vEditPasien.getNamaPasien();
                                        String telpE = vEditPasien.getTeleponPasien();
                                        int umurE = Integer.parseInt(vEditPasien.getUmurPasien());
                                        String genderE = vEditPasien.getGenderPasien();
                                        String kerjaE = vEditPasien.getPekerjaan();
                                        String alamatE = vEditPasien.getAlamatPasien();
                                        model.updatePasien(no_pasien,namaE,telpE,umurE,genderE,kerjaE,alamatE);

                                        vEditPasien.dispose();
                                        vPasien vPasien1 = new vPasien();
                                        cDataPasien cDataPasien = new cDataPasien(vPasien1,model);
                                    }
                                } catch (Exception e1){
                                    System.out.println("Gagal button Simpan Edit Pasien");
                                }
                            }
                        });

                        vEditPasien.btnKembali.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                try{
                                    vEditPasien.dispose();
                                } catch (Exception e1){
                                    System.out.println("Gagal button kembali Edit Pasien");
                                }
                            }
                        });
                    }
                } catch (Exception e1){
                    System.out.println("Gagal button Edit Pasien");
                }
            }
        });

        vPasien.btnHapus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    if(dataEdit!=null){
                        int no_pasien = Integer.parseInt(String.valueOf(vPasien.tabel.getValueAt(baris,1)));
                        model.deletePasien(no_pasien);
                        updatePasien();
                        vPasien.btnHapus.setEnabled(false);
                        vPasien.btnEdit.setEnabled(false);
                    }
                } catch (Exception e1){
                    System.out.println("Gagal button Delete Pasien");
                }
            }
        });
    }

    public void updatePasien(){
        String contact[][] = model.getPasien();
        vPasien.tabel.setModel((new JTable(contact, vPasien.namaKolom)).getModel());
    }
}
