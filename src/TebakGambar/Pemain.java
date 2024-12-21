/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TebakGambar;

/**
 *
 * @author hamka
 */
public class Pemain {
    private String nama;
    private int skor;

    public Pemain(String nama) {
        this.nama = nama;
        this.skor = 0;
    }

    public void tambahSkor(int poin) {
        skor += poin;
    }

    public int getSkor() {
        return skor;
    }

    public String getNama() {
        return nama;
    }
}
