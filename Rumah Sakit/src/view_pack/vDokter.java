package view_pack;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class vDokter extends JFrame{
    String[] spesialis = {"Umum","Kandungan","Gigi","Bedah","Penyakit Dalam","Kulit","THT"};

    JLabel lJudulDaftar = new JLabel("Biodata Dokter Baru");
    JLabel lJudulData = new JLabel("Data Dokter Terdaftar");

    public JButton btnKembali = new JButton("Kembali");
    public JButton btnTambah = new JButton("Tambah");
    public JButton btnEdit = new JButton("Edit");
    public JButton btnHapus = new JButton("Hapus");
    public JButton btnSearch = new JButton("Cari");
    public JButton btnRefresh = new JButton("Refresh");

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

    public JTextField tfSearch = new JTextField("Pencarian (Nama)");

    public JTable tabel;
    DefaultTableModel tableModel;
    JScrollPane scrollPane;
    public Object namaKolom[] = {"No","No. Dokter","Nama","Spesialis","Telepon","Gender","Alamat","Harga"};
    Font font = new Font("Serif",Font.BOLD, 20);

    public vDokter(){
        tableModel = new DefaultTableModel(namaKolom,0);
        tabel = new JTable(tableModel);
        scrollPane = new JScrollPane(tabel);


        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setLayout(null);
        setSize(1000, 420);

        add(scrollPane);
        scrollPane.setBounds(370, 75, 600, 250);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        add(lJudulDaftar);
        lJudulDaftar.setFont(font);
        lJudulDaftar.setBounds(80, 5, 200, 30);
        add(lJudulData);
        lJudulData.setFont(font);
        lJudulData.setBounds(590, 5, 200, 30);

        add(tfSearch);
        tfSearch.setBounds(650, 50, 120, 20);
        add(btnSearch);
        btnSearch.setBounds(780,50,90,20);
        add(btnRefresh);
        btnRefresh.setBounds(880,50,90,20);

        add(lNama);
        lNama.setBounds(20, 50, 130, 20);
        add(tfNama);
        tfNama.setBounds(150, 50, 180, 30);

        add(lSpesialis);
        lSpesialis.setBounds(20, 95, 130, 20);
        add(tfSpesialis);
        tfSpesialis.setBounds(150, 95, 180, 30);

        add(lTelepon);
        lTelepon.setBounds(20, 140, 130, 20);
        add(tfTelepon);
        tfTelepon.setBounds(150, 140, 100, 30);
        add(lValidtlp);
        lValidtlp.setBounds(260,140,100,30);
        lValidtlp.setForeground(Color.red);

        add(lGender);
        lGender.setBounds(20, 185, 130, 20);
        add(gender1);
        gender1.setBounds(150, 185, 80, 20);
        add(gender2);
        gender2.setBounds(240, 185, 100, 20);
        gender1.setActionCommand("Laki-Laki");
        gender2.setActionCommand("Perempuan");
        tfGender.add(gender1);
        tfGender.add(gender2);

        add(lAlamat);
        lAlamat.setBounds(20, 230, 130, 20);
        add(tfAlamat);
        tfAlamat.setBounds(150, 230, 180, 30);

        add(lHarga);
        lHarga.setBounds(20, 270, 130, 20);
        add(tfHarga);
        tfHarga.setBounds(150, 270, 100, 30);
        add(lValidharga);
        lValidharga.setBounds(260,270,100,30);
        lValidharga.setForeground(Color.red);

        add(btnTambah);
        btnTambah.setBounds(10, 330, 90, 20);

        add(btnEdit);
        btnEdit.setBounds(110, 330, 90, 20);
        btnEdit.setEnabled(false);

        add(btnHapus);
        btnHapus.setBounds(210, 330, 90, 20);
        btnHapus.setEnabled(false);

        add(btnKembali);
        btnKembali.setBounds(850, 330, 90, 20);
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

    public String getSearch(){ return tfSearch.getText();}
}
