package view_pack;

import javax.swing.*;
import java.awt.*;

public class vHomeK extends JFrame {
    public JLabel lWelcome = new JLabel();

    public JButton btnLogout = new JButton("Logout");
    public JButton btnPasien = new JButton("Data Pasien");
    public JButton btnDokter = new JButton("Data Dokter");
    public JButton btnKamar = new JButton("Data Kamar");
    public JButton btnObat = new JButton("Data Obat");
    public JButton btnPeriksa = new JButton("Data Pemeriksaan");

    JLabel lLogo = new JLabel();
    String path = new String("logors.png");
    ImageIcon imageIcon = new ImageIcon(path);
    Image image = imageIcon.getImage();
    Image newImage = image.getScaledInstance(120,100,Image.SCALE_SMOOTH);
    ImageIcon logo = new ImageIcon(newImage);
    Font font = new Font("Serif",Font.BOLD, 20);
    Font font1 = new Font("Monospaced", Font.CENTER_BASELINE,12);

    public vHomeK(){
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("SI Rumah Sakit");
        setVisible(true);
        setLayout(null);
        setSize(400,450);
        setResizable(true);
        setLocationRelativeTo(null);

        add(lWelcome);
        lWelcome.setBounds(10,10,200,20);
        add(btnLogout);
        btnLogout.setBounds(280,10,80,20);

        add(lLogo);
        lLogo.setBounds(130,40,130,160);
        lLogo.setIcon(logo);

        add(btnPasien);
        btnPasien.setBounds(115,210,150,20);
        add(btnDokter);
        btnDokter.setBounds(115,240,150,20);
        add(btnKamar);
        btnKamar.setBounds(115,270,150,20);
        add(btnObat);
        btnObat.setBounds(115,300,150,20);
        add(btnPeriksa);
        btnPeriksa.setBounds(115,330,150,20);

//        btnLogout.getRootPane().setDefaultButton(btnLogout);
//        btnPasien.getRootPane().setDefaultButton(btnPasien);
//        btnDokter.getRootPane().setDefaultButton(btnDokter);
//        btnKamar.getRootPane().setDefaultButton(btnKamar);
//        btnObat.getRootPane().setDefaultButton(btnObat);
//        btnPeriksa.getRootPane().setDefaultButton(btnPeriksa);
    }
}
