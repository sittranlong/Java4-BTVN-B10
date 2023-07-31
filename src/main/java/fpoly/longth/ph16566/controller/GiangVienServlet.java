package fpoly.longth.ph16566.controller;

import fpoly.longth.ph16566.entity.GiangVien;
import fpoly.longth.ph16566.entity.TaiKhoan;
import fpoly.longth.ph16566.repository.GiangVienRepository;
import fpoly.longth.ph16566.repository.TaiKhoanRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "GiangVienServlet",
        value = {
                "/giang-vien/hien-thi",
                "/giang-vien/search",
                "/giang-vien/giang-vien-nu",
                "/giang-vien/remove",
                "/giang-vien/detail",
                "/giang-vien/view-update",
                "/giang-vien/update",
                "/giang-vien/view-add",
                "/giang-vien/add",
                "/giang-vien/login"
        }
)
public class GiangVienServlet extends HttpServlet {
    private GiangVienRepository giangVienRepository = new GiangVienRepository();
    private TaiKhoanRepository taiKhoanRepository = new TaiKhoanRepository();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI();
        if (uri.contains("hien-thi")) {
            this.hienThiGiangVien(req, resp);
        } else if (uri.contains("search")) {
            this.searchGiangVien(req, resp);
        } else if (uri.contains("giang-vien-nu")) {
            this.giangVienNu(req, resp);
        } else if (uri.contains("remove")) {
            this.removeGiangVien(req, resp);
        } else if (uri.contains("detail")) {
            this.detailGiangVien(req, resp);
        } else if (uri.contains("view-update")) {
            this.viewUpdate(req, resp);
        } else if (uri.contains("view-add")) {
            this.viewAdd(req, resp);
        } else if (uri.contains("login")) {
            this.login(req, resp);
        }
    }

    private void login(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        String usernameParam = req.getParameter("username");
        String passwordParam = req.getParameter("password");

        TaiKhoan taiKhoan = taiKhoanRepository.login(usernameParam, passwordParam);
        if (taiKhoan != null) {
            resp.sendRedirect("/giang-vien/hien-thi");
            return; // Dòng này để kết thúc phương thức sau khi chuyển hướng thành công.
        } else {
            // Nếu đăng nhập thất bại, bạn có thể hiển thị thông báo lỗi ở đây hoặc chuyển hướng lại đến trang login với thông báo lỗi.
            req.setAttribute("errorMessage", "vui lòng nhập chính xác thông tin.");
            req.getRequestDispatcher("/view/login.jsp").forward(req, resp);
            resp.sendRedirect("/giang-vien/login");
        }
    }

    private void hienThiGiangVien(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<GiangVien> giangVienList = giangVienRepository.getAll();
        req.setAttribute("giangVien", giangVienList);
        req.getRequestDispatcher("/view/GiangVien.jsp").forward(req, resp);
    }

    private void searchGiangVien(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String tenParam = req.getParameter("nameSearch");
        List<GiangVien> giangVienList = giangVienRepository.filterByName(tenParam);
        req.setAttribute("giangVien", giangVienList);
        req.getRequestDispatcher("/view/GiangVien.jsp").forward(req, resp);
    }

    private void giangVienNu(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<GiangVien> giangVienList = giangVienRepository.filterByFemaleGender();
        req.setAttribute("giangVien", giangVienList);
        req.getRequestDispatcher("/view/GiangVien.jsp").forward(req, resp);
    }

    private void removeGiangVien(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String maParam = req.getParameter("DeleteMa");
        GiangVien giangVien = giangVienRepository.getOne(maParam);
        giangVienRepository.delete(giangVien);
        resp.sendRedirect("/giang-vien/hien-thi");
    }

    private void detailGiangVien(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String maParam = req.getParameter("DetailMa");
        GiangVien giangVien = giangVienRepository.getOne(maParam);
        req.setAttribute("gv", giangVien);
        req.getRequestDispatcher("/view/DetailGiangVien.jsp").forward(req, resp);
    }

    private void viewUpdate(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String maParam = req.getParameter("UpdateMa");
        GiangVien giangVien = giangVienRepository.getOne(maParam);
        req.setAttribute("gv", giangVien);
        req.getRequestDispatcher("/view/UpdateGiangVien.jsp").forward(req,resp);
    }

    private void viewAdd(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect("/view/AddGiangVien.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI();
        if (uri.contains("add")) {
            this.addGiangVien(req, resp);
        } else if (uri.contains("update")) {
            this.updateGiangVien(req, resp);
        }
    }

    private void addGiangVien(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String maParam = req.getParameter("ma");
        String tenParam = req.getParameter("ten");
        String tuoiParam = req.getParameter("tuoi");
        String gioiTinhParam = req.getParameter("gioiTinh");
        String diaChiParam = req.getParameter("diaChi");

        GiangVien giangVien = new GiangVien(maParam, tenParam, Integer.valueOf(tuoiParam), Boolean.valueOf(gioiTinhParam), diaChiParam);
        giangVienRepository.add(giangVien);
        resp.sendRedirect("/giang-vien/hien-thi");
    }

    private void updateGiangVien(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String idParam = req.getParameter("id");
        String maParam = req.getParameter("ma");
        String tenParam = req.getParameter("ten");
        String tuoiParam = req.getParameter("tuoi");
        String gioiTinhParam = req.getParameter("gioiTinh");
        String diaChiParam = req.getParameter("diaChi");


        GiangVien giangVien = GiangVien.builder()
                .id(Long.valueOf(idParam))
                .ma(maParam)
                .ten(tenParam)
                .tuoi(Integer.valueOf(tuoiParam))
                .gioiTinh(Boolean.valueOf(gioiTinhParam))
                .diaChi(diaChiParam)
                .build();
        giangVienRepository.update(giangVien);
        resp.sendRedirect("/giang-vien/hien-thi");
    }
}
