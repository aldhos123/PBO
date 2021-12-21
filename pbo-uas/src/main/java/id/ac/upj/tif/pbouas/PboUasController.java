package id.ac.upj.tif.pbouas;

import javafx.application.Platform;
import javafx.scene.control.Label;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class PboUasController implements Initializable{
    public Label idlabel;
    public TextField merek_text;
    public TextField processor_text;
    public TextField ram_text;
    public TextField storage_text;
    public TextField harga_text;
    public Label labelNotif;
    public Label waktu;
    public TextArea isiData;
    public volatile boolean stop = false;

    private Koneksi koneksi = new Koneksi();

    @FXML
    private TableView<ModelTable> table;
    @FXML
    private TableColumn<ModelTable, String> col_merek;
    @FXML
    private TableColumn<ModelTable, String> col_processor;
    @FXML
    private TableColumn<ModelTable, String> col_ram;
    @FXML
    private TableColumn<ModelTable, String> col_storage;
    @FXML
    private TableColumn<ModelTable, Integer> col_harga;

    ObservableList<ModelTable> oblist = FXCollections.observableArrayList();
    private ModelTable spesifikasi;

    // TAMPILKAN TABLE
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        showPesan();
        waktuSekarang();
    }

    // SELECT DATABASE TABEL
    public ObservableList<ModelTable> getOblist() {
        //QUERY SELECT
        ResultSet rs = null;
        try {
            rs = koneksi.bacaData("SELECT * from spesifikasi");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try
        {
            while (rs.next()){
                oblist.add(new ModelTable(rs.getString("id"), rs.getString("merek"),
                        rs.getString("processor"), rs.getString("ram"),
                        rs.getString("storage"), rs.getInt("harga")));
            }
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
        return oblist;
    }

    // VARIABLE TAMPIL PESAN
    public void showPesan(){
        oblist.clear();
        ObservableList<ModelTable> list = getOblist();

        col_merek.setCellValueFactory(new PropertyValueFactory<ModelTable, String>("merek"));
        col_processor.setCellValueFactory(new PropertyValueFactory<ModelTable, String>("processor"));
        col_ram.setCellValueFactory(new PropertyValueFactory<ModelTable, String>("ram"));
        col_storage.setCellValueFactory(new PropertyValueFactory<ModelTable, String>("storage"));
        col_harga.setCellValueFactory(new PropertyValueFactory<ModelTable, Integer>("harga"));
        table.setItems(list);
    }

    @FXML
    public void handleClick(MouseEvent event){
        ModelTable spesifikasi = table.getSelectionModel().getSelectedItem();
        idlabel.setText("" + spesifikasi.getId());
        merek_text.setText("" + spesifikasi.getMerek());
        processor_text.setText("" + spesifikasi.getProcessor());

        ResultSet rs = null;
        try {
            rs = koneksi.bacaData("SELECT * from spesifikasi where id='"+ spesifikasi.getId() +"'");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try
        {
            while (rs.next()){
                ram_text.setText(rs.getString("ram"));
                storage_text.setText(rs.getString("storage"));
                harga_text.setText(rs.getString("harga"));
            }
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
    }

    public void onClickButtonSimpan(ActionEvent actionEvent) {
        String teks_merek = merek_text.getText();
        String teks_processor = processor_text.getText();
        String teks_ram = ram_text.getText();
        String teks_storage = storage_text.getText();
        String teks_harga = harga_text.getText();
        labelNotif.setText("Data Berhasil Disimpan!!");
        isiData.setText("Merek       : " + teks_merek + "\n" +
                        "Processor  : " + teks_processor + "\n" +
                        "RAM          : " + teks_ram + " GB\n" +
                        "Storage     : " + teks_storage + " GB\n" +
                        "Harga        : Rp. " + teks_harga + "\n");

        if(!teks_merek.isEmpty()){
            String query = "INSERT INTO spesifikasi (merek, processor, ram, storage, harga) VALUES('"+ teks_merek +"', " +
                    "'"+ teks_processor +"', " + "'"+ teks_ram +"', " + "'"+ teks_storage +"', " + "'"+ teks_harga +"')";
            int hasil = koneksi.manipulasiData(query);
            if(hasil == 1) {
                System.out.println("Data Berhasil di Input!");
            }
        }
        showPesan();
    }

    public void onClickButtonUbah(ActionEvent actionEvent){
        String teks_id = idlabel.getText();
        String teks_merek = merek_text.getText();
        String teks_processor = processor_text.getText();
        String teks_ram = ram_text.getText();
        String teks_storage = storage_text.getText();
        String teks_harga = harga_text.getText();
        labelNotif.setText("Data Berhasil Diubah!!");
        isiData.setText("Merek       : " + teks_merek + "\n" +
                        "Processor  : " + teks_processor + "\n" +
                        "RAM          : " + teks_ram + " GB\n" +
                        "Storage     : " + teks_storage + " GB\n" +
                        "Harga        : Rp. " + teks_harga);

        if(!teks_merek.isEmpty()){
            String query = "UPDATE spesifikasi SET merek='"+ teks_merek +"', processor='"+ teks_processor +"', " +
                    "ram='"+ teks_ram +"', storage='"+ teks_storage +"', harga='"+ teks_harga +"' WHERE id='" + teks_id + "'";
            int hasil = koneksi.manipulasiData(query);
            if(hasil == 1) {
                System.out.println("Data Berhasil di Input!");
            }
        }
        showPesan();
    }

    public void onClickButtonReset(ActionEvent actionEvent) {
        merek_text.setText("");
        processor_text.setText("");
        ram_text.setText("");
        storage_text.setText("");
        harga_text.setText("");
        labelNotif.setText("Form Berhasil Direset!");
        isiData.setText("");
    }

    public void onClickButtonRefresh(ActionEvent actionEvent){
        showPesan();
    }


    public void onClickButtonHapus(ActionEvent actionEvent) {
        String idnya = idlabel.getText();
        String query = "DELETE FROM spesifikasi WHERE id= "+ idnya +"";
        int hasil = koneksi.manipulasiData(query);
        if(hasil == 1) {
            System.out.println("Data Berhasil di Dihapus!!");
        }
        showPesan();
    }

    public void waktuSekarang(){
        Thread thread = new Thread(() ->{
           SimpleDateFormat waktuFormat = new SimpleDateFormat("E, d MMMM yyyy hh:mm:ss");
           while(!stop){
                try{
                    Thread.sleep(1000);
                }catch(Exception e){
                    System.out.println(e);
                }
                final String waktusekarang = waktuFormat.format(new Date());
                Platform.runLater(() -> {
                    waktu.setText(waktusekarang);
                });
           }
        });
        thread.start();
    }

    @FXML
    public void exitApplication(ActionEvent event) throws IOException {
        stop = true;
        PboUasApplication m = new PboUasApplication();
        m.changeScene("Login.fxml");
    }

}