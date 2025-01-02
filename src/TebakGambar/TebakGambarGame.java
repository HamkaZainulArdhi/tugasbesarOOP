package TebakGambar;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class TebakGambarGame extends GameBase {

    public TebakGambarGame() {
        super(); // Memanggil konstruktor GameBase

        // Inisialisasi data soal
        soalList = new ArrayList<>();
        soalList.add(new Soal(getClass().getResource("/TebakGambar/makanan/Bingke.jpg").getPath(), "Bingke", new String[]{"Kelepon", "Bingke", "Putri Ayu", "Onde-onde"}));
        soalList.add(new Soal(getClass().getResource("/TebakGambar/makanan/getuka.jpg").getPath(), "Getuk", new String[]{"Baso Goreng", "Getuk", "Lumpia", "Batagor"}));
        soalList.add(new Soal(getClass().getResource("/TebakGambar/makanan/Kelepon.jpg").getPath(), "Kelepon", new String[]{"Lapis Legit", "Kelepon", "Nagasari", "Putri Ayu"}));
        soalList.add(new Soal(getClass().getResource("/TebakGambar/makanan/KueLumpur.jpg").getPath(), "Kue Lumpur", new String[]{"Kue Lumpur", "Bika Ambon", "Onde-onde", "Lumpur Surga"}));
        soalList.add(new Soal(getClass().getResource("/TebakGambar/makanan/LapisLegit.jpg").getPath(), "Lapis Legit", new String[]{"Bingke", "Putri Ayu", "Lapis Legit", "Kue Lumpur"}));
        soalList.add(new Soal(getClass().getResource("/TebakGambar/makanan/LumpurSurga.jpg").getPath(), "Lumpur Surga", new String[]{"Onde-onde", "Lumpur Surga", "Bika Ambon", "Nagasari"}));
        soalList.add(new Soal(getClass().getResource("/TebakGambar/makanan/Ondeonde.jpg").getPath(), "Onde-onde", new String[]{"Onde-onde", "Kue Cucur", "Lapis Legit", "Lumpur Surga"}));
        soalList.add(new Soal(getClass().getResource("/TebakGambar/makanan/kuecucur.jpg").getPath(), "Kue Cucur", new String[]{"Kue Cucur", "Putri Ayu", "Bika Ambon", "Nagasari"}));
        soalList.add(new Soal(getClass().getResource("/TebakGambar/makanan/nagasari.jpg").getPath(), "Nagasari", new String[]{"Nagasari", "Bingke", "Lumpur Surga", "Onde-onde"}));
        soalList.add(new Soal(getClass().getResource("/TebakGambar/makanan/putuayu.jpg").getPath(), "Putu Ayu", new String[]{"Putu Ayu", "Kelepon", "Kue Lumpur", "Lapis Legit"}));

        

        // Label skor
        skorLabel = new JLabel("SKOR: 0");
        skorLabel.setBounds(20, 20, 100, 30);
        skorLabel.setFont(new Font("Arial", Font.BOLD, 14));
        add(skorLabel);

        // Label nyawa
        nyawaLabel = new JLabel();
        nyawaLabel.setBounds(610, 20, 220, 50);
        nyawaLabel.setFont(new Font("Arial", Font.BOLD, 30));
        nyawaLabel.setForeground(Color.RED);
        updateNyawaLabel(); // Memanggil metode dari GameBase
        add(nyawaLabel);

        // Label gambar
        gambarLabel = new JLabel();
        gambarLabel.setBounds(210, 20, 350, 300);
        gambarLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(gambarLabel);

        // Panel untuk pilihan jawaban
        JPanel pilihanPanel = new JPanel();
        pilihanPanel.setBounds(45, 350, 700, 150);
        pilihanPanel.setLayout(new GridLayout(1, 4, 10, 10));
        pilihanPanel.setOpaque(false);

        pilihanButtons = new JButton[4];
        for (int i = 0; i < 4; i++) {
            pilihanButtons[i] = new JButton();
            pilihanButtons[i].setFont(new Font("Poppins", Font.BOLD, 18));
            pilihanButtons[i].setBackground(Color.WHITE);
            pilihanButtons[i].setForeground(Color.BLACK);
            pilihanButtons[i].addActionListener(new PilihanButtonListener()); // Menggunakan listener dari GameBase
            pilihanPanel.add(pilihanButtons[i]);
        }

        add(pilihanPanel);

        // Tombol keluar
        JButton keluarButton = new JButton("Ganti Game");
        keluarButton.setBounds(320, 520, 150, 30);
        keluarButton.setFont(new Font("Arial", Font.BOLD, 14));
        keluarButton.setBackground(new Color(0, 102, 204));
        keluarButton.setForeground(Color.BLACK);
        keluarButton.addActionListener(e -> {
            GameFrame next = new GameFrame(); // Membuat frame baru
            next.setVisible(true);            // Menampilkan frame baru
            this.dispose();                   // Menutup frame aktif saat ini
        });
        add(keluarButton);

        tampilkanSoal(); // Memanggil metode dari GameBase
        setVisible(true);
    }

    public static void main(String[] args) {
        new TebakGambarGame();
    }
}
