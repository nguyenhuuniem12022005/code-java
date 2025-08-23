import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

class VanDongVien {
    private String ma;
    private String hoTen;
    private Duration thanhTichThucTe;
    private Duration uuTien;
    private Duration thanhTichXepHang;
    private int hang;

    public VanDongVien(String ma, String hoTen, String ngaySinhStr, String xuatPhatStr, String denDichStr) {
        this.ma = ma;
        this.hoTen = hoTen;

        DateTimeFormatter dinhDangThoiGian = DateTimeFormatter.ofPattern("HH:mm:ss");
        DateTimeFormatter dinhDangNgay = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        LocalTime thoiGianXuatPhat = LocalTime.parse(xuatPhatStr, dinhDangThoiGian);
        LocalTime thoiGianDenDich = LocalTime.parse(denDichStr, dinhDangThoiGian);
        LocalDate ngaySinh = LocalDate.parse(ngaySinhStr, dinhDangNgay);

        int tuoi = 2021 - ngaySinh.getYear();
        int giayUuTien;
        if (tuoi < 18) {
            giayUuTien = 0;
        } else if (tuoi < 25) {
            giayUuTien = 1;
        } else if (tuoi < 32) {
            giayUuTien = 2;
        } else {
            giayUuTien = 3;
        }
        this.uuTien = Duration.ofSeconds(giayUuTien);

        this.thanhTichThucTe = Duration.between(thoiGianXuatPhat, thoiGianDenDich);
        this.thanhTichXepHang = this.thanhTichThucTe.minus(this.uuTien);
    }

    public Duration getThanhTichXepHang() {
        return thanhTichXepHang;
    }

    public void setHang(int hang) {
        this.hang = hang;
    }

    public int getHang() {
        return hang;
    }

    private static String dinhDangDuration(Duration duration) {
        long tongSoGiay = duration.getSeconds();
        long gio = tongSoGiay / 3600;
        long phut = (tongSoGiay % 3600) / 60;
        long giay = tongSoGiay % 60;
        return String.format("%02d:%02d:%02d", gio, phut, giay);
    }

    @Override
    public String toString() {
        return ma + " " + hoTen + " " +
                dinhDangDuration(thanhTichThucTe) + " " +
                dinhDangDuration(uuTien) + " " +
                dinhDangDuration(thanhTichXepHang) + " " +
                hang;
    }
}

public class XepHangVanDongVien_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int soLuongVanDongVien = Integer.parseInt(scanner.nextLine());

        List<VanDongVien> danhSachGoc = new ArrayList<>();

        for (int i = 0; i < soLuongVanDongVien; i++) {
            String hoTen = scanner.nextLine();
            String ngaySinh = scanner.nextLine();
            String xuatPhat = scanner.nextLine();
            String denDich = scanner.nextLine();
            String ma = String.format("VDV%02d", i + 1);
            danhSachGoc.add(new VanDongVien(ma, hoTen, ngaySinh, xuatPhat, denDich));
        }

        List<VanDongVien> danhSachDaSapXep = new ArrayList<>(danhSachGoc);
        danhSachDaSapXep.sort(Comparator.comparing(VanDongVien::getThanhTichXepHang));

        if (!danhSachDaSapXep.isEmpty()) {
            danhSachDaSapXep.get(0).setHang(1);
            for (int i = 1; i < danhSachDaSapXep.size(); i++) {
                VanDongVien hienTai = danhSachDaSapXep.get(i);
                VanDongVien truocDo = danhSachDaSapXep.get(i - 1);

                if (hienTai.getThanhTichXepHang().equals(truocDo.getThanhTichXepHang())) {
                    hienTai.setHang(truocDo.getHang());
                } else {
                    hienTai.setHang(i + 1);
                }
            }
        }

        for (VanDongVien vdv : danhSachGoc) {
            System.out.println(vdv);
        }

        scanner.close();
    }
}