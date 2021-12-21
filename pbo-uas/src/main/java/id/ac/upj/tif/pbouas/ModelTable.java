package id.ac.upj.tif.pbouas;

import java.text.DecimalFormat;

public class ModelTable {
    DecimalFormat df = new DecimalFormat("#,###,##0.00");

    String id;
    String merek;
    String processor;
    String ram;
    String storage;
    int harga;

    public ModelTable(String id, String merek, String processor, String ram, String storage, int harga) {
        this.id = id;
        this.merek = merek;
        this.processor = processor;
        this.ram = ram;
        this.storage = storage;
        this.harga = harga;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMerek() {
        return merek;
    }

    public void setMerek(String merek) {
        this.merek = merek;
    }

    public String getProcessor() {
        return processor;
    }

    public void setProcessor(String processor) {
        this.processor = processor;
    }

    public String getRam() {
        return ram + " GB";
    }

    public void setRam(String ram) {
        this.ram = ram;
    }

    public String getStorage() {
        return storage + " GB";
    }

    public void setStorage(String storage) {
        this.storage = storage;
    }

    public String getHarga() {
        String hargaCurrency = df.format(harga);
        return "Rp. " + hargaCurrency;
    }

    public void setHarga(int harga) {
        this.harga = harga;
    }
}
