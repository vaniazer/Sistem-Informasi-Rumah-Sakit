package controller_pack;
import view_pack.*;
import utama.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class cHome {
    vHomeK vHomeK;
    Model model;
    String Karyawan;

    public cHome(vHomeK vHomeK, Model model, String Karyawan){
        this.vHomeK = vHomeK;
        this.model = model;
        this.Karyawan = Karyawan;

        String pegawai[] = model.dataKaryawan(Karyawan);
        vHomeK.lWelcome.setText(pegawai[2]+", Selamat Datang");

        vHomeK.btnLogout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    vHomeK.dispose();
                    MVC mvc = new MVC();
                } catch (Exception e1) {
                    System.out.println("Gagal button Logout!!");
                }
            }
        });

        vHomeK.btnPasien.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    vPasien vPasien = new vPasien();
                    cDataPasien cDataPasien = new cDataPasien(vPasien,model);
                } catch (Exception e1){
                    System.out.println("Gagal button Data Pasien!!");
                }
            }
        });

        vHomeK.btnDokter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    vDokter vDokter = new vDokter();
                    cDokter cDokter = new cDokter(vDokter,model);
                } catch (Exception e1){
                    System.out.println("Gagal button Data Dokter");
                }
            }
        });

        vHomeK.btnKamar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    vKamar vKamar = new vKamar();
                    cKamar cKamar = new cKamar(vKamar,model);
                } catch (Exception e1){
                    System.out.println("Gagal button Kamar Home");
                }
            }
        });

        vHomeK.btnObat.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    vObat vObat = new vObat();
                    cObat cObat = new cObat(vObat,model);
                } catch (Exception e1){
                    System.out.println("Gagal button Obat Home");
                }
            }
        });

        vHomeK.btnPeriksa.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    vPemeriksaan vPemeriksaan = new vPemeriksaan();
                    cPemeriksaan cPemeriksaan = new cPemeriksaan(vPemeriksaan,model,Karyawan);
                } catch (Exception e1){
                    System.out.println("Gagal button Pemeriksaan Home");
                }
            }
        });

    }
}
