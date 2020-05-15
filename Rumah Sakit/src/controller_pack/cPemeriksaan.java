package controller_pack;
import view_pack.*;
import utama.*;

import javax.swing.*;
import java.awt.event.*;

public class cPemeriksaan {
    vPemeriksaan vPemeriksaan;
    Model model;
    String Karyawan,dataEdit;
    int baris;

    public cPemeriksaan(vPemeriksaan vPemeriksaan, Model model, String Karyawan){
        this.vPemeriksaan = vPemeriksaan;
        this.model = model;
        this.Karyawan = Karyawan;

        if(model.getBanyakPeriksa() != 0 ){
            String periksa[][] = model.getPeriksa();
            vPemeriksaan.tabel2.setModel((new JTable(periksa,vPemeriksaan.namaKolomData)).getModel());
        } else {
            JOptionPane.showMessageDialog(null, "Data Pemeriksaan Tidak Ada");
            vPemeriksaan.btnEdit.setEnabled(false);
            vPemeriksaan.btnHapus.setEnabled(false);
        }

        if(model.getBanyakPasien()!=0){
            int banyakPasien = model.getBanyakPasien();
            for(int i=0; i<banyakPasien; i++){
                String pasien[][] = model.getPasien();
                vPemeriksaan.tfNama.addItem(pasien[i][2]);
            }
        }

        if(model.getBanyakDokter()!=0){
            int banyakDokter = model.getBanyakDokter();
            for(int i=0; i<banyakDokter; i++){
                String dokter[][] = model.getDokter();
                vPemeriksaan.tfDokter.addItem(dokter[i][2]);
            }
        }
        if(model.getBanyakKamar()!=0){
            int banyakKamar = model.getBanyakKamar();
            for(int i=0; i<banyakKamar; i++){
                String kamar[][] = model.getKamar();
                vPemeriksaan.tfKamar.addItem(kamar[i][2]);
            }
        }

        vPemeriksaan.tfLama.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                try{
                    int lama = Integer.parseInt(vPemeriksaan.tfLama.getText());
                    vPemeriksaan.lValidlama.setText("");
                    vPemeriksaan.btnSimpan.setEnabled(true);
                    String kamarnya = vPemeriksaan.getKamar();
                    String kamar[][] = model.searchKamar(kamarnya);
                    long harga = Integer.parseInt(kamar[0][3]);
                    long total = harga*lama;
                    vPemeriksaan.tfHarga.setText(String.valueOf(total));
                } catch (NumberFormatException numberFormatException){
                    vPemeriksaan.lValidlama.setText("invalid number");
                    vPemeriksaan.btnSimpan.setEnabled(false);
                }
            }
        });

        vPemeriksaan.btnKembali.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    vPemeriksaan.dispose();
                } catch (Exception e1){
                    System.out.println("Gagal button kembali Pemeriksaan");
                }
            }
        });

        vPemeriksaan.btnSimpan.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    if(vPemeriksaan.getNamaPasien().equals("") || vPemeriksaan.getKamar().equals("") ||
                            vPemeriksaan.getNamaDoketr().equals("") || vPemeriksaan.getLamaInap().equals("") ||
                            vPemeriksaan.getSakit().equals("")){
                        JOptionPane.showMessageDialog(null, "Data masih ada yang kosong");
                    }
                    else{
                        String pasien = vPemeriksaan.getNamaPasien();
                        String dokter = vPemeriksaan.getNamaDoketr();
                        String kamar = vPemeriksaan.getKamar();
                        String ket = vPemeriksaan.getSakit();
                        int lama = Integer.parseInt(vPemeriksaan.getLamaInap());
                        int harga = Integer.parseInt(vPemeriksaan.getHarga());

                        String cariPasien[][] = model.searchPasien(pasien);
                        int noPasien = Integer.parseInt(cariPasien[0][1]);
                        String cariDokter[][] = model.searchDokter(dokter);
                        int noDokter = Integer.parseInt(cariDokter[0][1]);
                        String cariKamar[][] = model.searchKamar(kamar);
                        int noKamar = Integer.parseInt(cariKamar[0][1]);

                        model.insertPeriksa(Karyawan,noPasien,noDokter,noKamar,ket,lama,harga);
                        updatePeriksa();
                        vPemeriksaan.tfLama.setText("");
                        vPemeriksaan.tfSakit.setText("");
                        vPemeriksaan.tfHarga.setText("");
                    }

                }catch (Exception e1){
                    System.out.println("Gagal button simpan pemeriksaan");
                }
            }
        });

        vPemeriksaan.tabel2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                baris = vPemeriksaan.tabel2.getSelectedRow();
                dataEdit = vPemeriksaan.tabel2.getValueAt(baris,0).toString();
                if(dataEdit!=null){
                    vPemeriksaan.btnHapus.setEnabled(true);
                    vPemeriksaan.btnEdit.setEnabled(true);
                    vPemeriksaan.btnObat.setEnabled(true);
                }
            }
        });

        vPemeriksaan.btnEdit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    if(dataEdit!=null){
                        int no_periksa = Integer.parseInt(vPemeriksaan.tabel2.getValueAt(baris,1).toString());
                        String pasien = vPemeriksaan.tabel2.getValueAt(baris,2).toString();
                        String dokter = vPemeriksaan.tabel2.getValueAt(baris,3).toString();
                        String kamar = vPemeriksaan.tabel2.getValueAt(baris,4).toString();
                        String ket = vPemeriksaan.tabel2.getValueAt(baris,5).toString();
                        String lama = vPemeriksaan.tabel2.getValueAt(baris,6).toString();
                        String harga = vPemeriksaan.tabel2.getValueAt(baris,7).toString();

                        vEditPemeriksaan vEditPemeriksaan = new vEditPemeriksaan();
                        vPemeriksaan.dispose();

                        int banyakPasien = model.getBanyakPasien();
                        for(int i=0; i<banyakPasien; i++){
                            String pasien1[][] = model.getPasien();
                            vEditPemeriksaan.tfNama.addItem(pasien1[i][2]);
                        }

                        int banyakDokter = model.getBanyakDokter();
                        for(int i=0; i<banyakDokter; i++){
                            String dokter1[][] = model.getDokter();
                            vEditPemeriksaan.tfDokter.addItem(dokter1[i][2]);
                        }

                        int banyakKamar = model.getBanyakKamar();
                        for(int i=0; i<banyakKamar; i++){
                            String kamar1[][] = model.getKamar();
                            vEditPemeriksaan.tfKamar.addItem(kamar1[i][2]);
                        }

                        vEditPemeriksaan.tfSakit.setText(ket);
                        vEditPemeriksaan.tfLama.setText(lama);
                        vEditPemeriksaan.tfHarga.setText(harga);

                        String Pasien[][] = model.getPasien();
                        for (int i=0; i<banyakPasien; i++){
                            if(pasien.equals(Pasien[i][2])){
                                vEditPemeriksaan.tfNama.setSelectedItem(Pasien[i][2]);
                            }
                        }

                        String Dokter[][] = model.getDokter();
                        for(int i=0; i<banyakDokter; i++){
                            if(dokter.equals(Dokter[i][2])){
                                vEditPemeriksaan.tfDokter.setSelectedItem(Dokter[i][2]);
                            }
                        }

                        String Kamar[][] = model.getKamar();
                        for(int i=0; i<banyakKamar; i++){
                            if(kamar.equals(Kamar[i][2])){
                                vEditPemeriksaan.tfKamar.setSelectedItem(Kamar[i][2]);
                            }
                        }

                        vEditPemeriksaan.tfLama.addMouseListener(new MouseAdapter() {
                            @Override
                            public void mouseClicked(MouseEvent e) {
                                vEditPemeriksaan.tfLama.setText("");
                            }
                        });

                        vEditPemeriksaan.tfLama.addKeyListener(new KeyAdapter() {
                            @Override
                            public void keyTyped(KeyEvent e) {
                                try{
                                    int lama = Integer.parseInt(vEditPemeriksaan.tfLama.getText());
                                    vPemeriksaan.lValidlama.setText("");
                                    vEditPemeriksaan.btnSimpan.setEnabled(true);
                                    String kamarnya = vEditPemeriksaan.getKamar();
                                    String kamar[][] = model.searchKamar(kamarnya);
                                    long harga = Integer.parseInt(kamar[0][3]);
                                    long total = harga*lama;
                                    vEditPemeriksaan.tfHarga.setText(String.valueOf(total));
                                } catch (NumberFormatException numberFormatException){
                                    vPemeriksaan.lValidlama.setText("invalid number");
                                    vEditPemeriksaan.btnSimpan.setEnabled(false);
                                }
                            }
                        });

                        vEditPemeriksaan.btnSimpan.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                try{
                                    if(vEditPemeriksaan.getNamaPasien().equals("") || vEditPemeriksaan.getKamar().equals("") ||
                                            vEditPemeriksaan.getNamaDokter().equals("") || vEditPemeriksaan.getLama().equals("") ||
                                            vEditPemeriksaan.getSakit().equals("")){
                                        JOptionPane.showMessageDialog(null, "Data masih ada yang kosong");
                                    }
                                    else{
                                        String pasienE = vEditPemeriksaan.getNamaPasien();
                                        String dokterE = vEditPemeriksaan.getNamaDokter();
                                        String kamarE = vEditPemeriksaan.getKamar();
                                        String ketE = vEditPemeriksaan.getSakit();
                                        int lamaE = Integer.parseInt(vEditPemeriksaan.getLama());
                                        long totE = Integer.parseInt(vEditPemeriksaan.getHarga());

                                        String cariPasien[][] = model.searchPasien(pasienE);
                                        int noPasien = Integer.parseInt(cariPasien[0][1]);
                                        String cariDokter[][] = model.searchDokter(dokterE);
                                        int noDokter = Integer.parseInt(cariDokter[0][1]);
                                        String cariKamar[][] = model.searchKamar(kamarE);
                                        int noKamar = Integer.parseInt(cariKamar[0][1]);
                                        String cariObat[][] = model.getObatPeriksa(no_periksa);
                                        int banyakObat = model.getBanyakObatPeriksa(no_periksa);
                                        int totalHarga=0;
                                        for(int i=0; i<banyakObat; i++){
                                            totalHarga=totalHarga+Integer.parseInt(cariObat[i][3]);
                                        }
                                        long totalBaru = totE+totalHarga;
                                        model.updatePeriksa(no_periksa,noPasien,noDokter,noKamar,ketE,lamaE,totalBaru);
                                        updatePeriksa();
                                        vEditPemeriksaan.dispose();
                                        vPemeriksaan vPemeriksaan1 = new vPemeriksaan();
                                        cPemeriksaan cPemeriksaan = new cPemeriksaan(vPemeriksaan1,model,Karyawan);
                                    }
                                } catch (Exception e1){
                                    System.out.println("Gagal button simpan edit pemeriksaan");
                                }
                            }
                        });

                        vEditPemeriksaan.btnKembali.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                try{
                                    vEditPemeriksaan.dispose();
                                } catch (Exception e1){
                                    System.out.println("Gagal button kembali Edit Pemeriksaan");
                                }
                            }
                        });
                    }
                } catch (Exception e1){
                    System.out.println("Gagal button edit pemeriksaan");
                }
            }
        });

        vPemeriksaan.btnHapus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    if(dataEdit!=null){
                        int no_periksa = Integer.parseInt(vPemeriksaan.tabel2.getValueAt(baris,1).toString());
                        model.deletePeriksa(no_periksa);
                        updatePeriksa();
                        vPemeriksaan.btnHapus.setEnabled(false);
                        vPemeriksaan.btnEdit.setEnabled(false);
                        vPemeriksaan.btnObat.setEnabled(false);
                    }
                } catch (Exception e1){
                    System.out.println("Gagal button Hapus pemeriksaan");
                }
            }
        });

        vPemeriksaan.btnObat.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    int no_pemeriksaan = Integer.parseInt(vPemeriksaan.tabel2.getValueAt(baris,1).toString());
                    vPemeriksaan.dispose();
                    vFormObat vFormObat = new vFormObat();
                    cFormObat cFormObat = new cFormObat(vFormObat,model,no_pemeriksaan);
                } catch (Exception e1){
                    System.out.println("Gagal button input Obat Pemeriksaan");
                }
            }
        });
    }

    public void updatePeriksa(){
        String periksa[][] = model.getPeriksa();
        vPemeriksaan.tabel2.setModel((new JTable(periksa,vPemeriksaan.namaKolomData)).getModel());
    }
}
