package controller_pack;
import view_pack.*;
import utama.*;

import javax.swing.*;
import java.awt.event.*;

public class Controller {
    vLogin vlogin;
    Model model;
    int baris, kolom;

    public Controller(vLogin vlogin,Model model){
        this.vlogin = vlogin;
        this.model = model;

        vlogin.btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    if(vlogin.getKaryawan().equals("") || vlogin.getPassword().equals("")){
                        JOptionPane.showMessageDialog(null, "Data masih ada yang kosong");
                    }
                    else{
                        String karyawan = vlogin.getKaryawan();
                        String password = vlogin.getPassword();
                        String pegawai[] = model.Login(karyawan,password);
                        if(pegawai[0].equals(karyawan) && pegawai[1].equals(password)){
                            vlogin.dispose();
                            vHomeK vHomeK = new vHomeK();
                            cHome cHome = new cHome(vHomeK,model,karyawan);
                        }
                    }
                }
                catch (Exception e1){
                    vlogin.tfPassword.setText("");
                    JOptionPane.showMessageDialog(null,"Gagal Login!",
                            "Hasil", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        vlogin.showPassword.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(vlogin.showPassword.isSelected()){
                    vlogin.tfPassword.setEchoChar((char)0);
                }
                else{
                    vlogin.tfPassword.setEchoChar('*');
                }
            }
        });
    }

}
