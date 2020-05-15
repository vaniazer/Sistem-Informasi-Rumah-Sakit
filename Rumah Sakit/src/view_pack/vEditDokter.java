package view_pack;

import javax.swing.*;
import java.awt.*;

public class vEditDokter extends JFrame {
    String[] spesialis = {"Umum","Kandungan","Gigi","Bedah","Penyakit Dalam","Kulit","THT"};

    JLabel lJudulEdit = new JLabel("Edit Data Dokter");

    public JButton btnKembali = new JButton("Kembali");
    public JButton btnSimpan = new JButton("Simpan");


    JLabel lNama = new JLabel("Nama");
    JLabel lSpesialis = new JLabel("Spesialis");
    JLabel lTelepon = new JLabel("Telepon");
    JLabel lGender = new JLabel("Gender");
    JLabel lAlamat = new JLabel("Alamat");
    JLabel lHarga = new JLabel("Harga");

    public JLabel lValidtlp = new JLabel();
    public JLabel lValidharga = new JLabel();

    public JTextField tfNama = new JTextField();
    public JComboBox tfSpesialis = new JComboBox(spesialis);
    public JTextField tfTelepon = new JTextField();
    public JRadioButton gender1 = new JRadioButton("Laki-Laki");
    public JRadioButton gender2 = new JRadioButton("Perempuan");
    public ButtonGroup tfGender = new ButtonGroup();
    public JTextField tfAlamat = new JTextField();
    public JTextField tfHarga = new JTextField();

    Font font = new Font("Serif",Font.BOLD, 20);

    public vEditDokter(){
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
        add(lSpesialis);
        lSpesialis.setBounds(80, 145, 130, 20);
        add(tfSpesialis);
        tfSpesialis.setBounds(150, 145, 180, 30);
        add(lTelepon);
        lTelepon.setBounds(80, 190, 130, 20);
        add(tfTelepon);
        tfTelepon.setBounds(150, 190, 100, 30);
        add(lValidtlp);
        lValidtlp.setBounds(260,190,100,30);
        lValidtlp.setForeground(Color.red);

        add(lGender);
        lGender.setBounds(80, 235, 130, 20);
        add(gender1);
        gender1.setBounds(150, 235, 80, 20);
        add(gender2);
        gender2.setBounds(240, 235, 100, 20);
        gender1.setActionCommand("Laki-Laki");
        gender2.setActionCommand("Perempuan");
        tfGender.add(gender1);
        tfGender.add(gender2);

        add(lAlamat);
        lAlamat.setBounds(80, 280, 130, 20);
        add(tfAlamat);
        tfAlamat.setBounds(150, 280, 180, 30);

        add(lHarga);
        lHarga.setBounds(80, 325, 130, 20);
        add(tfHarga);
        tfHarga.setBounds(150, 325, 100, 30);
        add(lValidharga);
        lValidharga.setBounds(260,325,100,30);
        lValidharga.setForeground(Color.red);

        add(btnSimpan);
        btnSimpan.setBounds(100, 380, 90, 30);

        add(btnKembali);
        btnKembali.setBounds(200, 380, 90, 30);
    }
    public String getNamaDokter(){
        return tfNama.getText();
    }

    public String getSpesialis(){
        return (String) tfSpesialis.getSelectedItem();
    }

    public String getTeleponDokter(){
        return tfTelepon.getText();
    }

    public String getGenderDokter(){
        return tfGender.getSelection().getActionCommand();
    }

    public String getAlamatDokter(){
        return tfAlamat.getText();
    }

    public String getHargaDokter(){
        return tfHarga.getText();
    }


}
