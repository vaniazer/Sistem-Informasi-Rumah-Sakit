package view_pack;

import javax.swing.*;
import java.awt.*;

public class vLogin extends JFrame {
    JLabel lJudul = new JLabel("Sistem Informasi Rumah Sakit");
    JLabel lKaryawan = new JLabel("No Karyawan");
    JLabel lPassword = new JLabel("Password");

    public JTextField tfKaryawan = new JTextField();
    public JPasswordField tfPassword = new JPasswordField();
    public JCheckBox showPassword = new JCheckBox("Show Password");

    JLabel lLogo = new JLabel();
    String path = new String("logors.png");
    ImageIcon imageIcon = new ImageIcon(path);
    Image image = imageIcon.getImage();
    Image newImage = image.getScaledInstance(120,100,Image.SCALE_SMOOTH);
    ImageIcon logo = new ImageIcon(newImage);
    Font font = new Font("Serif",Font.BOLD, 20);
    Font font1 = new Font("Monospaced", Font.CENTER_BASELINE,12);

    public JButton btnLogin = new JButton("Login");

    public vLogin(){
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("SI Rumah Sakit");
        setVisible(true);
        setLayout(null);
        setSize(400,400);
        setResizable(true);
        setLocationRelativeTo(null);

        add(lLogo);
        lLogo.setBounds(130,10,130,160);
        lLogo.setIcon(logo);

        add(lJudul);
        lJudul.setFont(font);
        lJudul.setBounds(63,150,300,40);

        add(lKaryawan);
        lKaryawan.setBounds(105,200,80,23);
        add(tfKaryawan);
        tfKaryawan.setBounds(195,200,100,23);
        tfKaryawan.setToolTipText("Masukkan No Karyawan Anda");

        add(lPassword);
        lPassword.setBounds(105,230,80,23);
        add(tfPassword);
        tfPassword.setBounds(195,230,100,23);
        tfPassword.setEchoChar('*');
        tfPassword.setToolTipText("Masukkan Password Anda");

        add(showPassword);
        showPassword.setFont(font1);
        showPassword.setBounds(195,255,200,20);

        add(btnLogin);
        btnLogin.setBounds(145,290,80,20);
        btnLogin.getRootPane().setDefaultButton(btnLogin);
    }
    public String getKaryawan(){
        return tfKaryawan.getText();
    }
    public String getPassword(){
        String password = String.valueOf(tfPassword.getPassword());
        return password;
    }
}
