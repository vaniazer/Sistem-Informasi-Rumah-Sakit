package utama;

import javax.swing.*;
import java.sql.*;

public class Model {
    static final String driver = "com.mysql.jdbc.Driver";
    static final String dbURL = "jdbc:mysql://localhost/dbrumahsakit";
    static final String user = "root";
    static final String pass = "";
    Connection connection;
    Statement statement;

    public Model(){
        try{
            Class.forName(driver);
            connection = (Connection) DriverManager.getConnection(dbURL,user,pass);
            System.out.println("Koneksi Berhasil!!");
        } catch (SQLException ex){
            JOptionPane.showMessageDialog(null,"Gagal Koneksi Database!", "Hasil",
                    JOptionPane.ERROR_MESSAGE);
        } catch (ClassNotFoundException ex){
            JOptionPane.showMessageDialog(null,"Driver Tidak Ditemukan!", "Hasil",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    public String[] Login(String Karyawan, String Password){
        try{
            String datap[] = new String[7];
            String query = "SELECT * FROM `karyawan` WHERE no_karyawan='"+Karyawan+"' AND password='"+Password+"'";
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            if(resultSet.next()){
                datap[0] = resultSet.getString("no_karyawan");
                datap[1] = resultSet.getString("password");
                datap[2] = resultSet.getString("nama");
                datap[3] = resultSet.getString("telepon");
                datap[4] = resultSet.getString("gender");
                datap[5] = resultSet.getString("posisi");
                datap[6] = resultSet.getString("alamat");
                return datap;
            }
            else{
                JOptionPane.showMessageDialog(null,"Gagal Login! No.Karyawan/Password salah!",
                        "Hasil", JOptionPane.ERROR_MESSAGE);
                return null;
            }
        } catch(SQLException e){
            JOptionPane.showMessageDialog(null,"Gagal Login Model!",
                    "Hasil", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }

    public String[] dataKaryawan(String Karyawan){
        try{
            String datap[] = new String[7];
            String query = "SELECT * FROM `karyawan` WHERE no_karyawan='"+Karyawan+"'";
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            if(resultSet.next()){
                datap[0] = resultSet.getString("no_karyawan");
                datap[1] = resultSet.getString("password");
                datap[2] = resultSet.getString("nama");
                datap[3] = resultSet.getString("telepon");
                datap[4] = resultSet.getString("gender");
                datap[5] = resultSet.getString("posisi");
                datap[6] = resultSet.getString("alamat");
                return datap;
            }
            else{
                JOptionPane.showMessageDialog(null,"Gagal Login! No.Karyawan/Password salah!",
                        "Hasil", JOptionPane.ERROR_MESSAGE);
                return null;
            }
        } catch(SQLException e){
            JOptionPane.showMessageDialog(null,"Gagal Login Model!",
                    "Hasil", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }

    public void insertPasien(String Nama, String HP, int Umur, String Gender, String Pekerjaan, String Alamat){
        try{
            String query = "INSERT INTO `pasien` VALUES (NULL,'"+Nama+"','"+HP+"','"+Umur+"'" +
                    ",'"+Gender+"','"+Pekerjaan+"','"+Alamat+"')";
            statement = (Statement) connection.createStatement();
            statement.executeUpdate(query);
            JOptionPane.showMessageDialog(null,"Data Pasien Berhasil Disimpan!", "Hasil",
                    JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e){
            JOptionPane.showMessageDialog(null,"Data Pasien Gagal Disimpan!",
                    "Hasil", JOptionPane.ERROR_MESSAGE);
        }
    }

    public String[][] getPasien(){
        try{
            int banyakPasien=0;
            String Pasien[][] = new String[getBanyakPasien()][8];
            String query = "select * from `pasien`";
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                Pasien[banyakPasien][0] = String.valueOf(banyakPasien+1);
                Pasien[banyakPasien][1] = String.valueOf(resultSet.getInt("no_pasien"));
                Pasien[banyakPasien][2] = resultSet.getString("nama");
                Pasien[banyakPasien][3] = resultSet.getString("telepon");
                Pasien[banyakPasien][4] = String.valueOf(resultSet.getInt("umur"));
                Pasien[banyakPasien][5] = resultSet.getString("gender");
                Pasien[banyakPasien][6] = resultSet.getString("pekerjaan");
                Pasien[banyakPasien][7] = resultSet.getString("alamat");
                banyakPasien++;
            }
            return Pasien;
        } catch (SQLException e){
            JOptionPane.showMessageDialog(null,"Gagal Menampilkan Data Pasien!",
                    "Hasil", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }

    public int getBanyakPasien(){
        int jumlahPasien=0;
        try{
            String query = "select * from `pasien`";
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                jumlahPasien++;
            }
            return jumlahPasien;
        } catch (SQLException e){
            System.out.println("Banyak pasien gagal diambil");
            return 0;
        }
    }

    public void updatePasien(int no_pasien,String Nama, String HP, int Umur, String Gender, String Pekerjaan, String Alamat){
        try{
            String query = "update `pasien` set `nama` ='"+Nama+"',`telepon`='"+HP+"',`umur`='"+Umur+"'" +
                    ",`gender`='"+Gender+"',`pekerjaan`='"+Pekerjaan+"',`alamat`='"+Alamat+"' " +
                    "where no_pasien='"+no_pasien+"'";
            statement = (Statement) connection.createStatement();
            statement.executeUpdate(query);
            JOptionPane.showMessageDialog(null,"Update Data Pasien Berhasil!", "Hasil",
                    JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e){
            JOptionPane.showMessageDialog(null,"Update Data Pasien Gagal!",
                    "Hasil", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void deletePasien(int no_pasien){
        try {
            String query = "DELETE from `pasien` where no_pasien = '"+no_pasien+"'";
            statement = connection.createStatement();
            statement.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Data Pasien Berhasil Dihapus!");
        } catch (SQLException sqlException){
            JOptionPane.showMessageDialog(null, "Data Pasien Gagal Dihapus!");
        }
    }

    public String[][] searchPasien(String cari){
        try{
            int banyakPasien=0;
            String Pasien[][] = new String[getBanyakPasien()][8];
            String query = "select * from `pasien` where nama like '%"+cari+"' or nama like '%"+cari+"%' or nama like '"+cari+"%'";
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                Pasien[banyakPasien][0] = String.valueOf(banyakPasien+1);
                Pasien[banyakPasien][1] = String.valueOf(resultSet.getInt("no_pasien"));
                Pasien[banyakPasien][2] = resultSet.getString("nama");
                Pasien[banyakPasien][3] = resultSet.getString("telepon");
                Pasien[banyakPasien][4] = String.valueOf(resultSet.getInt("umur"));
                Pasien[banyakPasien][5] = resultSet.getString("gender");
                Pasien[banyakPasien][6] = resultSet.getString("pekerjaan");
                Pasien[banyakPasien][7] = resultSet.getString("alamat");
                banyakPasien++;
            }
            return Pasien;
        } catch (SQLException e){
            JOptionPane.showMessageDialog(null,"Gagal Menampilkan Data Pasien yang dicari!",
                    "Hasil", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }

    public void insertDokter(String Nama, String Spesialis,String telp, String Gender, String Alamat,int Harga){
        try{
            String query = "INSERT INTO `dokter` VALUES (NULL,'"+Nama+"','"+telp+"','"+Spesialis+"','"+Gender+"'," +
                    "'"+Alamat+"','"+Harga+"')";
            statement = connection.createStatement();
            statement.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Data Dokter Berhasil Disimpan!");
        } catch (SQLException sqlException){
            JOptionPane.showMessageDialog(null, "Data Dokter Gagal Disimpan!");
        }
    }

    public String[][] getDokter(){
        try{
            int banyakDokter=0;
            String Dokter[][] = new String[getBanyakDokter()][8];
            String query = "select * from `dokter`";
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                Dokter[banyakDokter][0] = String.valueOf(banyakDokter+1);
                Dokter[banyakDokter][1] = String.valueOf(resultSet.getInt("no_dokter"));
                Dokter[banyakDokter][2] = resultSet.getString("nama");
                Dokter[banyakDokter][3] = resultSet.getString("spesialis");
                Dokter[banyakDokter][4] = resultSet.getString("telepon");
                Dokter[banyakDokter][5] = resultSet.getString("gender");
                Dokter[banyakDokter][6] = resultSet.getString("alamat");
                Dokter[banyakDokter][7] = String.valueOf(resultSet.getInt("harga"));
                banyakDokter++;
            }
            return Dokter;
        } catch (SQLException e){
            JOptionPane.showMessageDialog(null,"Gagal Menampilkan Data Dokter!",
                    "Hasil", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }

    public int getBanyakDokter(){
        int jumlahDokter=0;
        try{
            String query = "select * from `dokter`";
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                jumlahDokter++;
            }
            return jumlahDokter;
        } catch (SQLException e){
            System.out.println("Banyak dokter gagal diambil");
            return 0;
        }
    }

    public void updateDokter(int no_dokter, String Nama, String Spesialis,String telp, String Gender, String Alamat,int Harga){
        try{
            String query = "UPDATE `dokter` SET nama='"+Nama+"',telepon='"+telp+"',spesialis='"+Spesialis+"'," +
                    "gender='"+Gender+"',alamat='"+Alamat+"',harga='"+Harga+"' WHERE no_dokter ='"+no_dokter+"' ";
            statement = connection.createStatement();
            statement.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Data Dokter Berhasil Diupdate!");
        } catch (SQLException sqlException){
            JOptionPane.showMessageDialog(null, "Data Dokter Gagal Diupdate!");
        }
    }

    public void deleteDokter(int no_dokter){
        try{
            String query = "delete from `dokter` where no_dokter='"+no_dokter+"'";
            statement = connection.createStatement();
            statement.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Data Dokter Berhasil Dihapus!");
        } catch (SQLException sqlException){
            JOptionPane.showMessageDialog(null, "Data Dokter Gagal Dihapus!");
        }
    }

    public String[][] searchDokter(String cari){
        try{
            int banyakDokter=0;
            String Dokter[][] = new String[getBanyakDokter()][8];
            String query = "select * from `dokter` where nama like '%"+cari+"' or nama like '%"+cari+"%' or nama like '"+cari+"%'";
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                Dokter[banyakDokter][0] = String.valueOf(banyakDokter+1);
                Dokter[banyakDokter][1] = String.valueOf(resultSet.getInt("no_dokter"));
                Dokter[banyakDokter][2] = resultSet.getString("nama");
                Dokter[banyakDokter][3] = resultSet.getString("telepon");
                Dokter[banyakDokter][4] = resultSet.getString("spesialis");
                Dokter[banyakDokter][5] = resultSet.getString("gender");
                Dokter[banyakDokter][6] = resultSet.getString("alamat");
                Dokter[banyakDokter][7] = String.valueOf(resultSet.getInt("harga"));
                banyakDokter++;
            }
            return Dokter;
        } catch (SQLException e){
            JOptionPane.showMessageDialog(null,"Gagal Menampilkan Data Dokter yang dicari!",
                    "Hasil", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }

    public int getBanyakKamar(){
        int jmlKamar=0;
        try{
            String query = "select * from `kamar`";
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                jmlKamar++;
            }
            return jmlKamar;
        } catch (SQLException e){
            System.out.println("Banyak kamar gagal diambil");
            return 0;
        }
    }

    public String[][] getKamar(){
        try{
            int banyakKamar=0;
            String Kamar[][] = new String[getBanyakKamar()][4];
            String query = "select * from `kamar`";
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                Kamar[banyakKamar][0] = String.valueOf(banyakKamar+1);
                Kamar[banyakKamar][1] = String.valueOf(resultSet.getInt("id_ruang"));
                Kamar[banyakKamar][2] = resultSet.getString("nama_ruang");
                Kamar[banyakKamar][3] = resultSet.getString("harga");
                banyakKamar++;
            }
            return Kamar;
        } catch (SQLException e){
            JOptionPane.showMessageDialog(null,"Gagal Menampilkan Data Dokter!",
                    "Hasil", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }

    public void insertKamar(String nama, int harga){
        try{
            String query = "insert into `kamar` values (NULL,'"+nama+"','"+harga+"')";
            statement = connection.createStatement();
            statement.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Data Kamar Berhasil Disimpan!");
        } catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Data Kamar Gagal Disimpan!");
        }
    }

    public void updateKamar(int no_kamar, String nama, int harga){
        try{
            String query = "update `kamar` set nama_ruang='"+nama+"', harga='"+harga+"' where id_ruang='"+no_kamar+"'";
            statement = connection.createStatement();
            statement.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Data Kamar Berhasil Diupdate!");
        } catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Data Kamar Gagal Diupdate!");
        }
    }

    public void deleteKamar(int no_kamar){
        try{
            String query = "delete from `kamar` where id_ruang='"+no_kamar+"'";
            statement = connection.createStatement();
            statement.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Data Kamar Berhasil Dihapus!");
        } catch (SQLException sqlException){
            JOptionPane.showMessageDialog(null, "Data Kamar Gagal Dihapus!");
        }
    }

    public String[][] searchKamar(String cari){
        try{
            int banyakKamar=0;
            String Kamar[][] = new String[getBanyakKamar()][4];
            String query = "select * from `kamar` where nama_ruang like '%"+cari+"' or nama_ruang like '%"+cari+"%' or nama_ruang like '"+cari+"%'";
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                Kamar[banyakKamar][0] = String.valueOf(banyakKamar+1);
                Kamar[banyakKamar][1] = String.valueOf(resultSet.getInt("id_ruang"));
                Kamar[banyakKamar][2] = resultSet.getString("nama_ruang");
                Kamar[banyakKamar][3] = resultSet.getString("harga");
                banyakKamar++;
            }
            return Kamar;
        } catch (SQLException e){
            JOptionPane.showMessageDialog(null,"Gagal Menampilkan Data Dokter!",
                    "Hasil", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }

    public int getBanyakObat(){
        int jmlObat=0;
        try{
            String query = "select * from `obat`";
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                jmlObat++;
            }
            return jmlObat;
        } catch (SQLException e){
            System.out.println("Banyak Obat gagal diambil");
            return 0;
        }
    }

    public String[][] getObat(){
        try{
            int banyakObat=0;
            String Obat[][] = new String[getBanyakObat()][5];
            String query = "select * from `obat`";
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                Obat[banyakObat][0] = String.valueOf(banyakObat+1);
                Obat[banyakObat][1] = String.valueOf(resultSet.getInt("id_obat"));
                Obat[banyakObat][2] = resultSet.getString("nama_obat");
                Obat[banyakObat][3] = String.valueOf(resultSet.getInt("harga"));
                Obat[banyakObat][4] = String.valueOf(resultSet.getInt("jumlah"));
                banyakObat++;
            }
            return Obat;
        } catch (SQLException e){
            JOptionPane.showMessageDialog(null,"Gagal Menampilkan Data Obat!",
                    "Hasil", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }

    public void insertObat(String nama, int harga, int jumlah){
        try{
            String query = "insert into `obat` values (NULL,'"+nama+"','"+harga+"','"+jumlah+"')";
            statement = connection.createStatement();
            statement.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Data Obat Berhasil Disimpan!");
        } catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Data Obat Gagal Disimpan!");
        }
    }

    public void updateObat(int no_obat,String nama, int harga, int jumlah){
        try{
            String query = "update `obat` set nama_obat='"+nama+"',harga='"+harga+"',jumlah='"+jumlah+"' where id_obat='"+no_obat+"'";
            statement = connection.createStatement();
            statement.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Data Obat Berhasil Diupdate!");
        } catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Data Obat Gagal Diupdate!");
        }
    }

    public void deleteObat(int no_obat){
        try{
            String query = "delete from `obat` where id_obat='"+no_obat+"'";
            statement = connection.createStatement();
            statement.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Data Obat Berhasil Dihapus!");
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Data Obat Gagal Dihapus!");
        }
    }

    public String[][] searchObat(String cari){
        try{
            int banyakObat=0;
            String Obat[][] = new String[getBanyakObat()][5];
            String query = "select * from `obat` where nama_obat like '%"+cari+"' or nama_obat like '%"+cari+"%' or nama_obat like '"+cari+"%'";
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                Obat[banyakObat][0] = String.valueOf(banyakObat+1);
                Obat[banyakObat][1] = String.valueOf(resultSet.getInt("id_obat"));
                Obat[banyakObat][2] = resultSet.getString("nama_obat");
                Obat[banyakObat][3] = String.valueOf(resultSet.getInt("harga"));
                Obat[banyakObat][4] = String.valueOf(resultSet.getInt("jumlah"));
                banyakObat++;
            }
            return Obat;
        } catch (SQLException e){
            JOptionPane.showMessageDialog(null,"Gagal Menampilkan Data Obat!",
                    "Hasil", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }

    public int getBanyakPeriksa(){
        int jmlPeriksa=0;
        try{
            String query = "select * from `pemeriksaan`";
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                jmlPeriksa++;
            }
            return jmlPeriksa;
        } catch (SQLException e){
            System.out.println("Banyak Pemeriksaan gagal diambil");
            return 0;
        }
    }

    public String[][] getPeriksa(){
        try{
            int banyakPeriksa=0;
            String Periksa[][] = new String[getBanyakPeriksa()][8];
            String query = " select id_pemeriksaan,p.nama as pasien,d.nama as dokter,nama_ruang,ket_sakit,lama_inap,tot_harga from pemeriksaan pr " +
                    "inner join pasien p on pr.no_pasien=p.no_pasien inner join dokter d on pr.no_dokter=d.no_dokter " +
                    "inner join kamar km on pr.id_ruang=km.id_ruang;";
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                Periksa[banyakPeriksa][0] = String.valueOf(banyakPeriksa+1);
                Periksa[banyakPeriksa][1] = String.valueOf(resultSet.getInt("id_pemeriksaan"));
                Periksa[banyakPeriksa][2] = resultSet.getString("pasien");
                Periksa[banyakPeriksa][3] = resultSet.getString("dokter");
                Periksa[banyakPeriksa][4] = resultSet.getString("nama_ruang");
                Periksa[banyakPeriksa][5] = resultSet.getString("ket_sakit");
                Periksa[banyakPeriksa][6] = String.valueOf(resultSet.getInt("lama_inap"));
                Periksa[banyakPeriksa][7] = String.valueOf(resultSet.getInt("tot_harga"));
                banyakPeriksa++;
            }
            return Periksa;
        } catch (SQLException e){
            JOptionPane.showMessageDialog(null,"Gagal Menampilkan Data Pemeriksaan!",
                    "Hasil", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }

    public void insertPeriksa(String karyawan, int pasien, int dokter, int kamar, String ket, int lama,int total){
        try{
            String query = "insert into `pemeriksaan` values (NULL,'"+karyawan+"','"+pasien+"','"+dokter+"'," +
                    "'"+kamar+"','"+ket+"','"+lama+"','"+total+"')";
            statement = connection.createStatement();
            statement.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Data Pemeriksaan Berhasil Disimpan!");
        } catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Data Pemeriksaan Gagal Disimpan!");
        }
    }

    public void updatePeriksa(int periksa, int pasien, int dokter, int kamar, String ket, int lama,long total){
        try{
            String query = "update `pemeriksaan` set no_pasien='"+pasien+"',no_dokter='"+dokter+"'," +
                    "id_ruang='"+kamar+"',ket_sakit='"+ket+"',lama_inap='"+lama+"',tot_harga='"+total+"'" +
                    "where id_pemeriksaan='"+periksa+"'";
            statement = connection.createStatement();
            statement.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Data Pemeriksaan Berhasil Diupdate!");
        } catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Data Pemeriksaan Gagal Diupdate!");
        }
    }

    public void deletePeriksa(int no_periksa){
        try{
            String query = "delete from `pemeriksaan` where id_pemeriksaan='"+no_periksa+"'";
            String query1 = "delete from `transaksi_obat` where id_pemeriksaan='"+no_periksa+"'";
            statement = connection.createStatement();
            statement.executeUpdate(query);
            statement.executeUpdate(query1);
            JOptionPane.showMessageDialog(null, "Data Pemeriksaan Berhasil Dihapus!");
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Data Pemeriksaan Gagal Dihapus!");
        }
    }

    public String[][] searchPeriksa(int periksa){
        try{
            int banyakPeriksa=0;
            String Periksa[][] = new String[getBanyakPeriksa()][8];
            String query = " select id_pemeriksaan,p.nama as pasien,d.nama as dokter,nama_ruang,ket_sakit,lama_inap,tot_harga from pemeriksaan pr " +
                    "inner join pasien p on pr.no_pasien=p.no_pasien inner join dokter d on pr.no_dokter=d.no_dokter " +
                    "inner join kamar km on pr.id_ruang=km.id_ruang where id_pemeriksaan='"+periksa+"'";
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                Periksa[banyakPeriksa][0] = String.valueOf(banyakPeriksa+1);
                Periksa[banyakPeriksa][1] = String.valueOf(resultSet.getInt("id_pemeriksaan"));
                Periksa[banyakPeriksa][2] = resultSet.getString("pasien");
                Periksa[banyakPeriksa][3] = resultSet.getString("dokter");
                Periksa[banyakPeriksa][4] = resultSet.getString("nama_ruang");
                Periksa[banyakPeriksa][5] = resultSet.getString("ket_sakit");
                Periksa[banyakPeriksa][6] = String.valueOf(resultSet.getInt("lama_inap"));
                Periksa[banyakPeriksa][7] = String.valueOf(resultSet.getInt("tot_harga"));
                banyakPeriksa++;
            }
            return Periksa;
        } catch (SQLException e){
            JOptionPane.showMessageDialog(null,"Gagal Menampilkan Data Pemeriksaan!",
                    "Hasil", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }

    public int getBanyakObatPeriksa(int periksa){
        try{
            int jmlPeriksa=0;
            String query = "select * from `transaksi_obat` where id_pemeriksaan='"+periksa+"'";
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                jmlPeriksa++;
            }
            return jmlPeriksa;
        } catch (SQLException e){
            System.out.println("Banyak Pemeriksaan gagal diambil");
            return 0;
        }
    }

    public String[][] getObatPeriksa(int periksa){
        try{
            int banyakObat=0;
            String Obat[][] = new String[getBanyakObatPeriksa(periksa)][4];
            String query = "select nama_obat,t.jumlah as jumlah,total_harga from `transaksi_obat` t inner join `obat` o on t.id_obat=o.id_obat where id_pemeriksaan='"+periksa+"'";
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                Obat[banyakObat][0] = String.valueOf(banyakObat+1);
                Obat[banyakObat][1] = resultSet.getString("nama_obat");
                Obat[banyakObat][2] = String.valueOf(resultSet.getInt("jumlah"));
                Obat[banyakObat][3] = String.valueOf(resultSet.getInt("total_harga"));
                banyakObat++;
            }
            return Obat;
        } catch (SQLException e){
            JOptionPane.showMessageDialog(null,"Gagal Menampilkan Data Obat!",
                    "Hasil", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }

    public void insertObatPeriksa(int no_periksa, int obat, int jumlah,long total_harga, long tot_periksa, int jumObat){
        try{
            String query = "insert into `transaksi_obat` values('"+no_periksa+"','"+obat+"','"+jumlah+"','"+total_harga+"')";
            String query1 = "update `pemeriksaan` set tot_harga = '"+tot_periksa+"' where id_pemeriksaan = '"+no_periksa+"'";
            String query2 = "update `obat` set jumlah ='"+jumObat+"' where id_obat='"+obat+"'";
            statement = connection.createStatement();
            statement.executeUpdate(query);
            statement.executeUpdate(query1);
            statement.executeUpdate(query2);
            JOptionPane.showMessageDialog(null, "Data Obat Berhasil Disimpan!");
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Data Obat Gagal Dihapus!");
        }
    }

    public void deleteObatPeriksa(int no_periksa, int obat, long totalPeriksa, int jumObat){
        try{
            String query = "delete from `transaksi_obat` where id_pemeriksaan='"+no_periksa+"' and id_obat='"+obat+"'";
            String query1 = "update `pemeriksaan` set tot_harga='"+totalPeriksa+"' where id_pemeriksaan='"+no_periksa+"'";
            statement = connection.createStatement();
            statement.executeUpdate(query);
            statement.executeUpdate(query1);
            JOptionPane.showMessageDialog(null, "Data Obat Berhasil Dihapus!");
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Data Obat Gagal Dihapus!");
        }
    }
}
