package TebakGambar;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class TebakGambarGamePahlawan extends GameBase {

    public TebakGambarGamePahlawan() {
        super(); // Memanggil konstruktor GameBase

        // Inisialisasi data soal
        soalList = new ArrayList<>();
        soalList.add(new Soal(getClass().getResource("/TebakGambar/pahlwan/BungTomo.jpg").getPath(), "Bung Tomo", new String[]{"Dr. Soetomo", "RA Kartini", "Ir. Soekarno", "Bung Tomo"}));
        soalList.add(new Soal(getClass().getResource("/TebakGambar/pahlwan/DrSoetomo.jpg").getPath(), "Dr. Soetomo", new String[]{"Dr. Soetomo", "Ki Hajar Dewantara", "Teuku Umar", "Sultan Hasanudin"}));
        soalList.add(new Soal(getClass().getResource("/TebakGambar/pahlwan/IrSoekarno.jpg").getPath(), "Ir. Soekarno", new String[]{"M Husni Thamrin", "Ir. Soekarno", "Pangeran Antasari", "Jenderal Soedirman"}));
        soalList.add(new Soal(getClass().getResource("/TebakGambar/pahlwan/KiHajarDewantara.jpg").getPath(), "Ki Hajar Dewantara", new String[]{"Ki Hajar Dewantara", "RA Kartini", "Sultan Hasanudin", "Dr. Soetomo"}));
        soalList.add(new Soal(getClass().getResource("/TebakGambar/pahlwan/MuhammadHusniThamrin.jpg").getPath(), "M Husni Thamrin", new String[]{"Teuku Umar", "Pangeran Antasari", "M Husni Thamrin", "Bung Tomo"}));
        soalList.add(new Soal(getClass().getResource("/TebakGambar/pahlwan/RAKartini.jpg").getPath(), "RA Kartini", new String[]{"RA Kartini", "Sultan Hasanudin", "Ki Hajar Dewantara", "Ir. Soekarno"}));
        soalList.add(new Soal(getClass().getResource("/TebakGambar/pahlwan/SultanHasanudin.jpg").getPath(), "Sultan Hasanudin", new String[]{"Teuku Umar", "Pangeran Antasari", "Jenderal Soedirman", "Sultan Hasanudin"}));
        soalList.add(new Soal(getClass().getResource("/TebakGambar/pahlwan/JenderalSoedirman.jpg").getPath(), "Jenderal Soedirman", new String[]{"M Husni Thamrin", "Jenderal Soedirman", "Ki Hajar Dewantara", "Bung Tomo"}));
        soalList.add(new Soal(getClass().getResource("/TebakGambar/pahlwan/PangeranAntasari.jpg").getPath(), "Pangeran Antasari", new String[]{"Pangeran Antasari", "RA Kartini", "Dr. Soetomo", "Ir. Soekarno"}));
        soalList.add(new Soal(getClass().getResource("/TebakGambar/pahlwan/TeukuUmar.jpg").getPath(), "Teuku Umar", new String[]{"Bung Tomo", "Teuku Umar", "M Husni Thamrin", "Sultan Hasanudin"}));



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
            pilihanButtons[i].setFont(new Font("Poppins", Font.BOLD, 12));
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
        new TebakGambarGamePahlawan();
    }
}
