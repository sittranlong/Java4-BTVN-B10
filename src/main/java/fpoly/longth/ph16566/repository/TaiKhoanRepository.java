package fpoly.longth.ph16566.repository;

import fpoly.longth.ph16566.entity.TaiKhoan;
import fpoly.longth.ph16566.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.query.Query;

public class TaiKhoanRepository {
    public TaiKhoan login(String username, String password) {
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            // Truy vấn đối tượng TaiKhoan dựa trên username và password.
            Query<TaiKhoan> query = session.createQuery(
                    "FROM TaiKhoan WHERE username = :username AND password = :password", TaiKhoan.class
            );
            query.setParameter("username", username);
            query.setParameter("password", password);

            // Lấy kết quả truy vấn.
            TaiKhoan taiKhoan = query.uniqueResult();

            // Trả về đối tượng TaiKhoan nếu đăng nhập thành công hoặc null nếu đăng nhập thất bại.
            return taiKhoan;
        }

    }

}
