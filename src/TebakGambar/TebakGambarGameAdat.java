package TebakGambar;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class TebakGambarGameAdat extends GameBase {

    public TebakGambarGameAdat() {
        super(); // Memanggil konstruktor GameBase

        // Inisialisasi data soal
        soalList = new ArrayList<>();
        soalList.add(new Soal(getClass().getResource("/TebakGambar/bajuadat/Aceh.jpg").getPath(), "Baju Adat Aceh", new String[]{"Baju Adat Aceh", "Baju Adat Bali", "Baju Adat Jawa Timur", "Baju Adat Kalsel"}));
        soalList.add(new Soal(getClass().getResource("/TebakGambar/bajuadat/Bali.jpg").getPath(), "Baju Adat Bali", new String[]{"Baju Adat Kaltim", "Baju Adat Sulawesi", "Baju Adat Bali", "Baju Adat Aceh"}));
        soalList.add(new Soal(getClass().getResource("/TebakGambar/bajuadat/JawaTengah.jpg").getPath(), "Baju Adat Jawa Tengah", new String[]{"Baju Adat Papua Barat", "Baju Adat Jawa Tengah", "Baju Adat Jawa Timur", "Baju Adat NTB"}));
        soalList.add(new Soal(getClass().getResource("/TebakGambar/bajuadat/JawaTimur.jpg").getPath(), "Baju Adat Jawa Timur", new String[]{"Baju Adat Jawa Timur", "Baju Adat Maluku", "Baju Adat Bali", "Baju Adat Sulsel "}));
        soalList.add(new Soal(getClass().getResource("/TebakGambar/bajuadat/KalimantanSelatan.jpg").getPath(), "Baju Adat Kalsel", new String[]{"Baju Adat NTB", "Baju Adat Bali", "Baju Adat Kalsel", "Baju Adat Jawa Tengah"}));
        soalList.add(new Soal(getClass().getResource("/TebakGambar/bajuadat/KalimantanTimur.jpg").getPath(), "Baju Adat Kaltim", new String[]{"Baju Adat Maluku", "Baju Adat Kaltim", "Baju Adat Aceh", "Baju Adat Papua Barat"}));
        soalList.add(new Soal(getClass().getResource("/TebakGambar/bajuadat/Maluku.jpg").getPath(), "Baju Adat Maluku", new String[]{"Baju Adat Kalsel", "Baju Adat NTB", "Baju Adat Maluku", "Baju Adat Sulsel "}));
        soalList.add(new Soal(getClass().getResource("/TebakGambar/bajuadat/NusaTenggaraBarat.jpg").getPath(), "Baju Adat NTB", new String[]{"Baju Adat NTB", "Baju Adat Jawa Timur", "Baju Adat Bali", "Baju Adat Kaltim"}));
        soalList.add(new Soal(getClass().getResource("/TebakGambar/bajuadat/PapuaBarat.jpg").getPath(), "Baju Adat Papua Barat", new String[]{"Baju Adat SulSel", "Baju Adat Papua Barat", "Baju Adat Aceh", "Baju Adat Jawa Tengah"}));
        soalList.add(new Soal(getClass().getResource("/TebakGambar/bajuadat/SulawesiSelatan.jpg").getPath(), "Baju Adat Sulsel", new String[]{"Baju Adat Sulsel", "Baju Adat Kaltim", "Baju Adat Maluku", "Baju Adat NTB"}));


        

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
            pilihanButtons[i].setFont(new Font("Poppins", Font.BOLD, 11));
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
        new TebakGambarGameAdat();
    }
}
