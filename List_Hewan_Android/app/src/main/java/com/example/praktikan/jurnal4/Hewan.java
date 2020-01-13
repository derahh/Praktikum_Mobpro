package com.example.praktikan.jurnal4;

public class Hewan {
    private String namaHewanWord, namaLatinWord;
    private int imageResId = -1;

    public Hewan(String namaHewanWord, String namaLatinWord) {
        this.namaHewanWord = namaHewanWord;
        this.namaLatinWord = namaLatinWord;
    }

    public Hewan(String namaHewanWord, String namaLatinWord, int imageResId) {
        this.namaHewanWord = namaHewanWord;
        this.namaLatinWord = namaLatinWord;
        this.imageResId = imageResId;
    }

    public String getNamaHewanWord() {
        return namaHewanWord;
    }

    public String getNamaLatinWord() {
        return namaLatinWord;
    }

    public int getImageResId() {
        return imageResId;
    }

    public boolean hasImage() {
        return imageResId != -1;
    }
}
