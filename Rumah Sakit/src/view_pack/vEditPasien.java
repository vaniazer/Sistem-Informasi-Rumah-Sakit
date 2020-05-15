package view_pack;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class vEditPasien extends JFrame{
    String[] pekerjaan = {"Tidak Bekerja","Ibu Rumah Tangga","Pelajar/Mahasiswa","Pensiun","Aparat Negara","PNS","Tenaga Medis"};

    JLabel lJudulEdit = new JLabel("Edit Data Pasien");

    public JButton btnKembali = new JButton("Kembali");
    public JButton btnSimpan = new JButton("Simpan");


    JLabel lNama = new JLabel("Nama");
    JLabel lTelepon = new JLabel("Telepon");
    JLabel lUmur = new JLabel("Umur");
    JLabel lGender = new JLabel("Gender");
    JLabel lPekerjaan = new JLabel("Pekerjaan");
    JLabel lAlamat = new JLabel("Alamat");

    public JLabel lValidtlp = new JLabel();
    public JLabel lValidumur = new JLabel();

    public JTextField tfNama = new JTextField();
    public JTextField tfTelepon = new JTextField();
    public JTextField tfUmur = new JTextField();
    public JRadioButton gender1 = new JRadioButton("Laki-Laki");
    public JRadioButton gender2 = new JRadioButton("Perempuan");
    ButtonGroup tfGender = new ButtonGroup();
    public JComboBox tfPekerjaan = new JComboBox(pekerjaan);
    public JTextField tfAlamat = new JTextField();

    Font font = new Font("Serif",Font.BOLD, 20);

    public vEditPasien(){
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

        add(lTelepon);
        lTelepon.setBounds(80, 145, 130, 20);
        add(tfTelepon);
        tfTelepon.setBounds(150, 145, 100, 30);
        add(lValidtlp);
        lValidtlp.setBounds(260,145,100,30);
        lValidtlp.setForeground(Color.red);

        add(lUmur);
        lUmur.setBounds(80, 190, 130, 20);
        add(tfUmur);
        tfUmur.setBounds(150, 190, 100, 30);
        add(lValidumur);
        lValidumur.setBounds(260,190,100,30);
        lValidumur.setForeground(Color.red);

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

        add(lPekerjaan);
        lPekerjaan.setBounds(80, 280, 130, 20);
        add(tfPekerjaan);
        tfPekerjaan.setBounds(150, 280, 180, 30);

        add(lAlamat);
        lAlamat.setBounds(80, 325, 130, 20);
        add(tfAlamat);
        tfAlamat.setBounds(150, 325, 180, 30);

        add(btnSimpan);
        btnSimpan.setBounds(100, 380, 90, 30);

        add(btnKembali);
        btnKembali.setBounds(200, 380, 90, 30);
    }
    public String getNamaPasien(){
        return tfNama.getText();
    }

    public String getTeleponPasien(){
        return tfTelepon.getText();
    }

    public String getUmurPasien(){
        return tfUmur.getText();
    }

    public String getGenderPasien(){
        return tfGender.getSelection().getActionCommand();
    }

    public String getPekerjaan(){
        return (String) tfPekerjaan.getSelectedItem();
    }

    public String getAlamatPasien(){
        return tfAlamat.getText();
    }

}
