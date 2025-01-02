package TebakGambar;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class TebakGambarGamekota extends GameBase {

    public TebakGambarGamekota() {
        super(); // Memanggil konstruktor GameBase

        // Inisialisasi data soal
        soalList = new ArrayList<>();
        soalList.add(new Soal(getClass().getResource("/TebakGambar/tempat/GarudaWisnuKencana.jpg").getPath(), "Garuda Wisnu Kencana", new String[]{"Borobudur", "Garuda Wisnu Kencana", "Jam Gadang", "Gedung Sate"}));
        soalList.add(new Soal(getClass().getResource("/TebakGambar/tempat/GedungSate.jpg").getPath(), "Gedung Sate", new String[]{"Monumen Nasional", "Tugu Pahlawan", "Gedung Sate", "Jembatan Ampera"}));
        soalList.add(new Soal(getClass().getResource("/TebakGambar/tempat/JamGadang.jpg").getPath(), "Jam Gadang", new String[]{"Jam Gadang", "Monumen Nasional", "Gedung Sate", "Ulun Danu Beratan"}));
        soalList.add(new Soal(getClass().getResource("/TebakGambar/tempat/JembatanAmpera.jpg").getPath(), "Jembatan Ampera", new String[]{"Tugu Pahlawan", "Borobudur", "Monumen Simpang Lima", "Jembatan Ampera",}));
        soalList.add(new Soal(getClass().getResource("/TebakGambar/tempat/MasjidRayaBaiturrahman.jpg").getPath(), "Masjid Baiturrahman", new String[]{"Masjid Baiturrahman", "Ulun Danu Beratan", "Monumen Nasional", "Borobudur"}));
        soalList.add(new Soal(getClass().getResource("/TebakGambar/tempat/MonumenNasional.jpg").getPath(), "Monumen Nasional", new String[]{"Jam Gadang", "Gedung Sate","Monumen Nasional", "Garuda Wisnu Kencana"}));
        soalList.add(new Soal(getClass().getResource("/TebakGambar/tempat/MonumenSimpangLimaGumul.jpg").getPath(), "Monumen Gumul", new String[]{ "Tugu Pahlawan", "Gedung Sate","Monumen Gumul", "Jembatan Ampera"}));
        soalList.add(new Soal(getClass().getResource("/TebakGambar/tempat/TuguPahlawan.jpg").getPath(), "Tugu Pahlawan", new String[]{"Tugu Pahlawan", "Borobudur", "Jembatan Ampera", "Masjid Baiturrahman"}));
        soalList.add(new Soal(getClass().getResource("/TebakGambar/tempat/UlunDanuBeratan.jpg").getPath(), "Ulun Danu Beratan", new String[]{ "Borobudur", "Garuda Wisnu Kencana", "Ulun Danu Beratan", "Masjid Baiturrahman"}));
        soalList.add(new Soal(getClass().getResource("/TebakGambar/tempat/borobudur.jpg").getPath(), "Borobudur", new String[]{"Monumen Nasional", "Borobudur",  "Jembatan Ampera", "Garuda Wisnu Kencana"}));


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
        new TebakGambarGamekota();
    }
}
