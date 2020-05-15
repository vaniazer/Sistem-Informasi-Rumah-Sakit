package view_pack;

import javax.swing.*;
import java.awt.*;

public class vEditObat extends JFrame {
    JLabel lJudulEdit = new JLabel("Edit Data Obat");

    public JButton btnKembali = new JButton("Kembali");
    public JButton btnSimpan = new JButton("Simpan");


    JLabel lNama = new JLabel("Nama Obat");
    JLabel lHarga = new JLabel("Harga");
    JLabel lJumlah = new JLabel("Jumlah");

    public JLabel lValidharga = new JLabel();
    public JLabel lValidjumlah = new JLabel();


    public JTextField tfNama = new JTextField();
    public JTextField tfHarga = new JTextField();
    public JTextField tfJumlah = new JTextField();

    Font font = new Font("Serif",Font.BOLD, 20);

    public vEditObat(){
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setLayout(null);
        setSize(400, 350);

        add(lJudulEdit);
        lJudulEdit.setFont(font);
        lJudulEdit.setBounds(120, 40, 200, 30);
        add(lNama);
        lNama.setBounds(80, 100, 130, 20);
        add(tfNama);
        tfNama.setBounds(150, 100, 180, 30);
        add(lHarga);
        lHarga.setBounds(80, 145, 130, 20);
        add(tfHarga);
        tfHarga.setBounds(150, 145, 100, 30);
        add(lValidharga);
        lValidharga.setBounds(260,145,100,30);
        lValidharga.setForeground(Color.red);

        add(lJumlah);
        lJumlah.setBounds(80, 190, 130, 20);
        add(tfJumlah);
        tfJumlah.setBounds(150, 190, 100, 30);
        add(lValidjumlah);
        lValidjumlah.setBounds(260,190,100,30);
        lValidjumlah.setForeground(Color.red);

        add(btnSimpan);
        btnSimpan.setBounds(100, 245, 90, 30);

        add(btnKembali);
        btnKembali.setBounds(200, 245, 90, 30);
    }
    public String getNamaObat(){
        return tfNama.getText();
    }

    public String getHargaObat(){
        return tfHarga.getText();
    }

    public String getJumlahObat(){
        return tfJumlah.getText();
    }
}

