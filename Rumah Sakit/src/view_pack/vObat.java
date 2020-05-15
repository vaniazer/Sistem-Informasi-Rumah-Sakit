package view_pack;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class vObat extends JFrame {
    JLabel lJudulObat = new JLabel("Data Obat");

    public JButton btnKembali = new JButton("Kembali");
    public JButton btnTambah = new JButton("Tambah");
    public JButton btnEdit = new JButton("Edit");
    public JButton btnHapus = new JButton("Hapus");
    public JButton btnSearch = new JButton("Cari");
    public JButton btnRefresh = new JButton("Refresh");

    JLabel lNama = new JLabel("Nama Obat");
    JLabel lHarga = new JLabel("Harga");
    JLabel lJumlah = new JLabel("Jumlah");

    public JLabel lValidharga = new JLabel();
    public JLabel lValidjumlah = new JLabel();

    public JTextField tfSearch = new JTextField("Pencarian (Nama)");
    public JTextField tfNama = new JTextField();
    public JTextField tfHarga = new JTextField();
    public JTextField tfJumlah = new JTextField();

    public JTable tabel;
    DefaultTableModel tableModel;
    JScrollPane scrollPane;
    public Object namaKolom[] = {"No","No Obat","Nama Obat","Harga","Jumlah"};
    Font font = new Font("Serif",Font.BOLD, 20);

    public vObat(){
        tableModel = new DefaultTableModel(namaKolom,0);
        tabel = new JTable(tableModel);
        scrollPane = new JScrollPane(tabel);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setLayout(null);
        setSize(1000, 300);

        add(scrollPane);
        scrollPane.setBounds(370, 75, 600, 130);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        add(lJudulObat);
        lJudulObat.setFont(font);
        lJudulObat.setBounds(450, 5, 800, 30);

        add(lNama);
        lNama.setBounds(20, 50, 130, 20);
        add(tfNama);
        tfNama.setBounds(150, 50, 180, 30);

        add(lHarga);
        lHarga.setBounds(20, 95, 130, 20);
        add(tfHarga);
        tfHarga.setBounds(150, 95, 100, 30);
        add(lValidharga);
        lValidharga.setBounds(260,95,100,30);
        lValidharga.setForeground(Color.red);

        add(lJumlah);
        lJumlah.setBounds(20, 140, 130, 20);
        add(tfJumlah);
        tfJumlah.setBounds(150, 140, 100, 30);
        add(lValidjumlah);
        lValidjumlah.setBounds(260,140,100,30);
        lValidjumlah.setForeground(Color.red);

        add(tfSearch);
        tfSearch.setBounds(650, 50, 120, 20);
        add(btnSearch);
        btnSearch.setBounds(780,50,90,20);
        add(btnRefresh);
        btnRefresh.setBounds(880,50,90,20);

        add(btnTambah);
        btnTambah.setBounds(15, 195, 90, 20);

        add(btnEdit);
        btnEdit.setBounds(115, 195, 90, 20);
        btnEdit.setEnabled(false);

        add(btnHapus);
        btnHapus.setBounds(215, 195, 90, 20);
        btnHapus.setEnabled(false);

        add(btnKembali);
        btnKembali.setBounds(850, 210, 90, 20);
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

    public String getSearch(){ return tfSearch.getText();}

}
