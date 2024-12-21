/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TebakGambar;

/**
 *
 * @author hamka
 */
public class Pertanyaan {
    private String namaGambar; // Nama budaya
    private String jawabanBenar; // Jawaban yang benar
    private String[] opsiGambar; // Path gambar opsi

    public Pertanyaan(String namaGambar, String jawabanBenar, String[] opsiGambar) {
        this.namaGambar = namaGambar;
        this.jawabanBenar = jawabanBenar;
        this.opsiGambar = opsiGambar;
    }

    public String getNamaGambar() {
        return namaGambar;
    }

    public String getJawabanBenar() {
        return jawabanBenar;
    }

    public String[] getOpsiGambar() {
        return opsiGambar;
    }

    public boolean cekJawaban(String jawaban) {
        return jawaban.equals(jawabanBenar);
    }
}

