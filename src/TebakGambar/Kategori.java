/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TebakGambar;

/**
 *
 * @author hamka
 */
import java.util.ArrayList;

public class Kategori {
    private String namaKategori;
    private ArrayList<Pertanyaan> pertanyaanList;

    public Kategori(String namaKategori) {
        this.namaKategori = namaKategori;
        this.pertanyaanList = new ArrayList<>();
    }

    public void tambahPertanyaan(Pertanyaan p) {
        pertanyaanList.add(p);
    }

    public String tampilkanPertanyaan(int indeks) {
        return pertanyaanList.get(indeks);
    }

    public boolean cekJawaban(int indeks, String jawaban) {
        return pertanyaanList.get(indeks).cekJawaban(jawaban);
    }

    public int getJumlahPertanyaan() {
        return pertanyaanList.size();
    }

    public String getNamaKategori() {
        return namaKategori;
    }
}

