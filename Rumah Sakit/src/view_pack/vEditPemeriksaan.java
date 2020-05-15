package view_pack;

import javax.swing.*;
import java.awt.*;

public class vEditPemeriksaan extends JFrame {
    JLabel lJudulEdit = new JLabel("Edit Data Pemeriksaan");

    public JButton btnKembali = new JButton("Kembali");
    public JButton btnSimpan = new JButton("Simpan");


    JLabel lNama = new JLabel("Nama");
    JLabel lDokter = new JLabel("Dokter");
    JLabel lSakit = new JLabel("Ket. Sakit");
    JLabel lKamar = new JLabel("Kamar");
    JLabel lLama = new JLabel("Lama");
    JLabel lHari = new JLabel("Hari");
    JLabel lHarga = new JLabel("Harga");

    public JComboBox tfNama = new JComboBox();
    public JComboBox tfDokter = new JComboBox();
    public JTextField tfSakit = new JTextField();
    public JComboBox tfKamar = new JComboBox();
    public JTextField tfLama = new JTextField();
    public JLabel tfHarga = new JLabel();
    
    Font font = new Font("Serif",Font.BOLD, 20);


    public vEditPemeriksaan(){


        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setLayout(null);
        setSize(400, 480);

        add(lJudulEdit);
        lJudulEdit.setFont(font);
        lJudulEdit.setBounds(120, 40, 200, 30);
        add(lNama);
        lNama.setBounds(80, 100, 130, 20);
        add(tfNama);
        tfNama.setBounds(150, 100, 180, 30);
        add(lDokter);
        lDokter.setBounds(80, 145, 130, 20);
        add(tfDokter);
        tfDokter.setBounds(150, 145, 180, 30);
        add(lSakit);
        lSakit.setBounds(80, 190, 130, 20);
        add(tfSakit);
        tfSakit.setBounds(150, 190, 180, 30);

        add(lKamar);
        lKamar.setBounds(80, 235, 130, 20);
        add(tfKamar);
        tfKamar.setBounds(150, 235, 180, 30);

        add(lLama);
        lLama.setBounds(80, 280, 130, 20);
        add(tfLama);
        tfLama.setBounds(150, 280, 50, 30);
        add(lHari);
        lHari.setBounds(210, 280, 80, 30);

        add(lHarga);
        lHarga.setBounds(80, 325, 130, 20);
        add(tfHarga);
        tfHarga.setBounds(150, 325, 180, 30);

        add(btnSimpan);
        btnSimpan.setBounds(100, 380, 90, 30);

        add(btnKembali);
        btnKembali.setBounds(200, 380, 90, 30);
    }
    public String getNamaPasien(){
        return (String) tfNama.getSelectedItem();
    }
    public String getNamaDokter(){
        return (String) tfDokter.getSelectedItem();
    }
    public String getSakit(){
        return tfSakit.getText();
    }
    public String getKamar(){
        return (String) tfKamar.getSelectedItem();
    }
    public String getLama(){
        return tfLama.getText();
    }
    public String getHarga(){
        return tfHarga.getText();
    }


}
