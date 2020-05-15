package view_pack;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class vFormObat extends JFrame {
    JLabel lJudulData = new JLabel("Data Obat Untuk Pasien");

    public JButton btnKembali = new JButton("Kembali");
    public JButton btnTambah = new JButton("Tambah");
    public JButton btnHapus = new JButton("Hapus");

    JLabel lNama = new JLabel("Nama Obat");
    JLabel lJumlah = new JLabel("Jumlah");

    public JComboBox tfNama = new JComboBox();
    public JSpinner jJumlah = new JSpinner(new SpinnerNumberModel(1, 1, 20, 1));

    public JTable tabel;
    DefaultTableModel tableModel;
    JScrollPane scrollPane;
    public Object namaKolom[] = {"No","Nama Obat","Jumlah","Total Harga"};
    Font font = new Font("Serif",Font.BOLD, 20);

    public vFormObat(){
        tableModel = new DefaultTableModel(namaKolom,0);
        tabel = new JTable(tableModel);
        scrollPane = new JScrollPane(tabel);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setLayout(null);
        setSize(1000, 320);

        add(scrollPane);
        scrollPane.setBounds(370, 50, 600, 180);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        add(lJudulData);
        lJudulData.setFont(font);
        lJudulData.setBounds(390, 5, 270, 30);

        add(lNama);
        lNama.setBounds(20, 50, 130, 20);
        add(tfNama);
        tfNama.setBounds(150, 50, 180, 30);

        add(lJumlah);
        lJumlah.setBounds(20, 95, 130, 20);
        add(jJumlah);
        jJumlah.setBounds(150, 95, 50, 30);

        add(btnTambah);
        btnTambah.setBounds(150, 150, 90, 20);

        add(btnHapus);
        btnHapus.setBounds(750, 240, 90, 20);
        btnHapus.setEnabled(false);

        add(btnKembali);
        btnKembali.setBounds(850, 240, 90, 20);

    }

    public String getNamaObat(){
        return (String) tfNama.getSelectedItem();
    }
    public String getJumlah(){ return String.valueOf(jJumlah.getValue()); }
}

