package view_pack;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class vPemeriksaan extends JFrame {
    JLabel lJudulPemeriksaan = new JLabel("Data Pemeriksaan Pasien Rawat Inap");

    public JLabel lValidlama = new JLabel();

    public JButton btnBatal = new JButton("Batal");
    public JButton btnSimpan = new JButton("Simpan");
    public JButton btnKembali = new JButton("Kembali");
    public JButton btnEdit = new JButton("Edit");
    public JButton btnHapus = new JButton("Hapus");
    public JButton btnObat = new JButton("Input Obat");

    JLabel lNama = new JLabel("Nama");
    JLabel lDokter = new JLabel("Dokter");
    JLabel lSakit = new JLabel("Ket. Sakit");
    JLabel lKamar = new JLabel("Kamar");
    JLabel lLama = new JLabel("Lama");
    JLabel lHari = new JLabel("Hari");
    JLabel lHarga = new JLabel("Harga (Rp)");


    public JComboBox tfNama = new JComboBox();
    public JComboBox tfDokter = new JComboBox();
    public JTextField tfSakit = new JTextField();
    public JComboBox tfKamar = new JComboBox();
    public JTextField tfLama = new JTextField();
    public JLabel tfHarga = new JLabel();

    public JTable tabel2;
    DefaultTableModel tableModel2;
    JScrollPane scrollPane2;
    public Object namaKolomData[] = {"No","ID","Pasien","Dokter","Kamar","Ket.Sakit","Lama Inap","Harga"};

    Font font = new Font("Serif",Font.BOLD, 20);

    public vPemeriksaan(){
        tableModel2 = new DefaultTableModel(namaKolomData,0);
        tabel2 = new JTable(tableModel2);
        scrollPane2 = new JScrollPane(tabel2);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setLayout(null);
        setSize(1000, 670);

        add(lJudulPemeriksaan);
        lJudulPemeriksaan.setFont(font);
        lJudulPemeriksaan.setBounds(350, 5, 800, 30);

        add(lNama);
        lNama.setBounds(130, 70, 70, 20);
        add(tfNama);
        tfNama.setBounds(210, 70, 240, 30);

        add(lDokter);
        lDokter.setBounds(130, 115, 70, 20);
        add(tfDokter);
        tfDokter.setBounds(210, 115, 240, 30);

        add(lSakit);
        lSakit.setBounds(130, 160, 70, 20);
        add(tfSakit);
        tfSakit.setBounds(210, 160, 240, 30);

        add(lKamar);
        lKamar.setBounds(530, 70, 70, 20);
        add(tfKamar);
        tfKamar.setBounds(610, 70, 240, 30);

        add(lLama);
        lLama.setBounds(530, 115, 70, 20);
        add(tfLama);
        tfLama.setBounds(610, 115, 50, 30);
        add(lHari);
        lHari.setBounds(670, 115, 30, 30);
        add(lValidlama);
        lValidlama.setBounds(710,115,100,30);
        lValidlama.setForeground(Color.red);

        add(lHarga);
        lHarga.setBounds(530, 160, 70, 20);
        add(tfHarga);
        tfHarga.setBounds(610, 160, 240, 30);

        add(btnSimpan);
        btnSimpan.setBounds(400, 230, 90, 20);

        add(btnBatal);
        btnBatal.setBounds(500, 230, 90, 20);

        add(scrollPane2);
        scrollPane2.setBounds(20, 260, 930, 310);
        scrollPane2.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        add(btnEdit);
        btnEdit.setBounds(160, 580, 90, 20);
        btnEdit.setEnabled(false);

        add(btnHapus);
        btnHapus.setBounds(260, 580, 90, 20);
        btnHapus.setEnabled(false);

        add(btnObat);
        btnObat.setBounds(20,580,130,20);
        btnObat.setEnabled(false);

        add(btnKembali);
        btnKembali.setBounds(850, 580, 90, 20);
    }

    public String getNamaPasien(){
        return (String) tfNama.getSelectedItem();
    }

    public String getNamaDoketr(){
        return (String) tfDokter.getSelectedItem();
    }

    public String getSakit(){
        return tfSakit.getText();
    }

    public String getKamar(){
        return (String) tfKamar.getSelectedItem();
    }

    public String getLamaInap(){
        return tfLama.getText();
    }

    public String getHarga(){
        return tfHarga.getText();
    }
}
