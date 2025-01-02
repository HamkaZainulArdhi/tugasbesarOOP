package TebakGambar;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class GameBase extends JFrame {
    protected int skor = 0;
    protected int nyawa = 6;
    protected JLabel skorLabel, nyawaLabel, gambarLabel;
    protected JButton[] pilihanButtons;
    protected List<Soal> soalList;
    protected int soalIndex = 0;
    

    public GameBase() {
        setTitle("Game Base");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        getContentPane().setBackground(new Color(153, 153, 255));
        
    }

    protected void updateNyawaLabel() {
        StringBuilder nyawaText = new StringBuilder();
        for (int i = 0; i < nyawa; i++) {
            nyawaText.append("\u2665 ");
        }
        nyawaLabel.setText(nyawaText.toString());
    }

    private void resetButtonColors() {
        for (JButton button : pilihanButtons) {
            button.setBackground(Color.WHITE);
            button.setForeground(Color.BLACK);
        }
    }

    protected class PilihanButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JButton source = (JButton) e.getSource();
            String jawaban = source.getText();
            Soal soal = soalList.get(soalIndex);

            if (jawaban.equals(soal.getJawabanBenar())) {
                skor += 10;
                skorLabel.setText("SKOR: " + skor);
                source.setBackground(Color.GREEN);

                Timer timer = new Timer(1000, ev -> {
                    soalIndex++;
                    resetButtonColors();
                    tampilkanSoal();
                });
                timer.setRepeats(false);
                timer.start();
            } else {
                nyawa--;
                updateNyawaLabel();
                source.setBackground(Color.RED);


                if (nyawa == 0) {
                    JOptionPane.showMessageDialog(GameBase.this, "Game Over! Skor akhir: " + skor);
                    System.exit(0);
                }
            }
        }
    }

    protected void tampilkanSoal() {
        resetButtonColors();
        if (soalIndex < soalList.size()) {
            Soal soal = soalList.get(soalIndex);
            gambarLabel.setIcon(new ImageIcon(soal.getGambarPath()));

            String[] pilihan = soal.getPilihanJawaban();
            for (int i = 0; i < 4; i++) {
                pilihanButtons[i].setText(pilihan[i]);
            }
        } else {
            int pilihan = JOptionPane.showOptionDialog(
                this,
                "Permainan selesai! Skor akhir: " + skor,
                "Permainan Selesai",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                new Object[]{"Kembali ke Beranda", "Keluar"},
                "Kembali ke Beranda"
            );

            if (pilihan == JOptionPane.YES_OPTION) {
                GameFrame beranda = new GameFrame();
                beranda.setVisible(true);
                this.dispose();
            } else if (pilihan == JOptionPane.NO_OPTION) {
                System.exit(0);
            }
        }
    }
    
}
