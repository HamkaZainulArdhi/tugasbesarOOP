package TebakGambar;

public class Soal {
    private String gambarPath;       // Path untuk gambar soal
    private String jawabanBenar;     // Jawaban yang benar
    private String[] pilihanJawaban; // Pilihan jawaban (maksimal 4)

    // Constructor
    public Soal(String gambarPath, String jawabanBenar, String[] pilihanJawaban) {
        this.gambarPath = gambarPath;
        this.jawabanBenar = jawabanBenar;
        this.pilihanJawaban = pilihanJawaban;
    }

    // Getter untuk path gambar
    public String getGambarPath() {
        return gambarPath;
    }

    // Getter untuk jawaban benar
    public String getJawabanBenar() {
        return jawabanBenar;
    }

    // Getter untuk pilihan jawaban
    public String[] getPilihanJawaban() {
        return pilihanJawaban;
    }
}
