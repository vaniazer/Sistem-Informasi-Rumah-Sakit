package view_pack;

import javax.swing.*;
import java.awt.*;

public class vEditKamar extends JFrame {
    JLabel lJudulEdit = new JLabel("Edit Data Kamar");

    public JButton btnKembali = new JButton("Kembali");
    public JButton btnSimpan = new JButton("Simpan");


    JLabel lNama = new JLabel("Nama");
    JLabel lHarga = new JLabel("Harga");

    public JLabel lValidharga = new JLabel();

    public JTextField tfNama = new JTextField();
    public JTextField tfHarga = new JTextField();

    Font font = new Font("Serif",Font.BOLD, 20);
    public vEditKamar(){
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setLayout(null);
        setSize(400, 300);

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

        add(btnSimpan);
        btnSimpan.setBounds(100, 200, 90, 30);

        add(btnKembali);
        btnKembali.setBounds(200, 200, 90, 30);
    }
    public String getNamaKamar(){
        return tfNama.getText();
    }

    public String getHargaKamar(){
        return tfHarga.getText();
    }

}
