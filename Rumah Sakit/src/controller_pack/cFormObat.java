package controller_pack;
import view_pack.*;
import utama.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class cFormObat {
    vFormObat vFormObat;
    Model model;
    int id_periksa, baris;
    String dataEdit;

    public cFormObat(vFormObat vFormObat, Model model, int id_periksa ){
        this.vFormObat = vFormObat;
        this.model = model;
        this.id_periksa = id_periksa;

        if(model.getBanyakObatPeriksa(id_periksa)!=0){
            String obat[][] = model.getObatPeriksa(id_periksa);
            vFormObat.tabel.setModel((new JTable(obat,vFormObat.namaKolom)).getModel());
        }else {
            JOptionPane.showMessageDialog(null, "Data Obat Tidak Ada");
            vFormObat.btnHapus.setEnabled(false);
        }

        if(model.getBanyakObat()!=0){
            int banyakObat = model.getBanyakObat();
            for(int i=0; i<banyakObat; i++){
                String obatnya[][] = model.getObat();
                vFormObat.tfNama.addItem(obatnya[i][2]);
            }
        }

        vFormObat.tabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                baris = vFormObat.tabel.getSelectedRow();
                dataEdit = vFormObat.tabel.getValueAt(baris,1).toString();
                if(dataEdit!=null){
                    vFormObat.btnHapus.setEnabled(true);
                }
            }
        });

        vFormObat.btnKembali.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    vFormObat.dispose();
                } catch (Exception e1){
                    System.out.println("Gagal button kembali form obat");
                }
            }
        });

        vFormObat.btnTambah.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    if(vFormObat.tfNama.equals("")){
                        JOptionPane.showMessageDialog(null, "Data masih ada yang kosong");
                    }
                    else{
                        String obat = vFormObat.getNamaObat();
                        int jumlah = Integer.parseInt(vFormObat.getJumlah());

                        String cariObat[][] = model.searchObat(obat);
                        int idObat = Integer.parseInt(cariObat[0][1]);
                        int jObat = Integer.parseInt(cariObat[0][4]);
                        int hargaObat = Integer.parseInt(cariObat[0][3]);
                        long totalHarga = hargaObat*jumlah;
                        String cariPeriksa[][] = model.searchPeriksa(id_periksa);
                        int totalPeriksa = Integer.parseInt(cariPeriksa[0][7]);
                        long totalPeriksaBaru = totalPeriksa+totalHarga;
                        int jumObatBaru = jObat-jumlah;
                        if(jumlah<jObat){
                            model.insertObatPeriksa(id_periksa,idObat,jumlah,totalHarga,totalPeriksaBaru,jumObatBaru);
                            updateObat();
                        }
                        else{
                            JOptionPane.showMessageDialog(null, "Jumlah obat melebihi Stock yang ada");
                        }
                    }
                } catch (Exception e1){
                    System.out.println("Gagal button tambah obat Pemeriksaan");
                }
            }
        });

        vFormObat.btnHapus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    if(dataEdit!=null){
                        String obat = vFormObat.tabel.getValueAt(baris,1).toString();
                        int total = Integer.parseInt(vFormObat.tabel.getValueAt(baris,3).toString());
                        int jumlah = Integer.parseInt(vFormObat.tabel.getValueAt(baris,4).toString());
                        String cariObat[][] = model.searchObat(obat);
                        int idObat = Integer.parseInt(cariObat[0][1]);
                        int jObat = Integer.parseInt(cariObat[0][4]);
                        String cariPeriksa[][] = model.searchPeriksa(id_periksa);
                        int totalPeriksa = Integer.parseInt(cariPeriksa[0][7]);
                        long totalBaru = totalPeriksa-total;
                        int jObatBaru = jObat+jumlah;
                        model.deleteObatPeriksa(id_periksa,idObat,totalBaru,jObatBaru);
                        updateObat();
                        vFormObat.btnHapus.setEnabled(false);
                    }
                } catch (Exception e1){
                    System.out.println("Gagal button hapus obat pemeriksaan");
                }
            }
        });
    }

    public void updateObat(){
        String obat[][] = model.getObatPeriksa(id_periksa);
        vFormObat.tabel.setModel((new JTable(obat,vFormObat.namaKolom)).getModel());
    }
}
