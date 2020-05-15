package view_pack;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class vKamar extends JFrame {
    JLabel lJudulKamar = new JLabel("Data Kamar");

    public JButton btnKembali = new JButton("Kembali");
    public JButton btnTambah = new JButton("Tambah");
    public JButton btnEdit = new JButton("Edit");
    public JButton btnHapus = new JButton("Hapus");
    public JButton btnSearch = new JButton("Cari");
    public JButton btnRefresh = new JButton("Refresh");

    JLabel lNama = new JLabel("Nama Kamar");
    JLabel lHarga = new JLabel("Harga");


    public JTextField tfNama = new JTextField();
    public JTextField tfHarga = new JTextField();

    public JLabel lValidharga = new JLabel();

    public JTextField tfSearch = new JTextField("Pencarian (Nama)");

    public JTable tabel;
    DefaultTableModel tableModel;
    JScrollPane scrollPane;
    public Object namaKolom[] = {"No","Id Kamar","Nama Kamar","Harga"};
    Font font = new Font("Serif",Font.BOLD, 20);

    public vKamar(){
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

        add(lJudulKamar);
        lJudulKamar.setFont(font);
        lJudulKamar.setBounds(400, 5, 800, 30);

        add(tfSearch);
        tfSearch.setBounds(650, 50, 120, 20);
        add(btnSearch);
        btnSearch.setBounds(780,50,90,20);
        add(btnRefresh);
        btnRefresh.setBounds(880,50,90,20);

        add(lNama);
        lNama.setBounds(20, 75, 130, 20);
        add(tfNama);
        tfNama.setBounds(150, 75, 180, 30);

        add(lHarga);
        lHarga.setBounds(20, 120, 130, 20);
        add(tfHarga);
        tfHarga.setBounds(150, 120, 100, 30);
        add(lValidharga);
        lValidharga.setBounds(260,120,100,30);
        lValidharga.setForeground(Color.red);

        add(btnTambah);
        btnTambah.setBounds(15, 175, 90, 20);

        add(btnEdit);
        btnEdit.setBounds(115, 175, 90, 20);
        btnEdit.setEnabled(false);

        add(btnHapus);
        btnHapus.setBounds(215, 175, 90, 20);
        btnHapus.setEnabled(false);

        add(btnKembali);
        btnKembali.setBounds(850, 210, 90, 20);
    }
    public String getNamaKamar(){
        return tfNama.getText();
    }

    public String getHargaKamar(){
        return tfHarga.getText();
    }

    public String getSearch(){ return tfSearch.getText();}
}
