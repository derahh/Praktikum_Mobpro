package org.d3ifcool.bmi;

public class Word {
    private String saran, deskripsi;
    private int imageResId = -1;

    public Word(String saran, String deskripsi, int imageResId) {
        this.saran = saran;
        this.deskripsi = deskripsi;
        this.imageResId = imageResId;
    }

    public String getSaran() {
        return saran;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public int getImageResId() {
        return imageResId;
    }
}
