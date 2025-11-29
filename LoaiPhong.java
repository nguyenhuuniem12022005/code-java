import java.util.StringTokenizer;

public class LoaiPhong implements Comparable<LoaiPhong> {
    private final String kyHieu;
    private final String ten;
    private final int donGiaNgay;
    private final double phiPhucVu;

    public LoaiPhong(String line) {
        StringTokenizer st = new StringTokenizer(line);
        this.kyHieu = st.nextToken();
        this.ten = st.nextToken();
        this.donGiaNgay = Integer.parseInt(st.nextToken());
        this.phiPhucVu = Double.parseDouble(st.nextToken());
    }

    @Override
    public int compareTo(LoaiPhong other) {
        return this.ten.compareTo(other.ten);
    }

    @Override
    public String toString() {
        return String.format("%s %s %d %.2f", kyHieu, ten, donGiaNgay, phiPhucVu);
    }
}
