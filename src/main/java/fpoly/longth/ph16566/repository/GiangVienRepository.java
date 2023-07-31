package fpoly.longth.ph16566.repository;

import fpoly.longth.ph16566.util.HibernateUtil;
import fpoly.longth.ph16566.entity.GiangVien;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class GiangVienRepository {
    public List<GiangVien> getAll() {
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            Query<GiangVien> query = session.createQuery("FROM GiangVien", GiangVien.class);
            return query.list();
        }
    }

    public List<GiangVien> filterByName(String tenParam) {
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            Query<GiangVien> query = session.createQuery("FROM GiangVien WHERE ten LIKE: tenSearch", GiangVien.class);
            query.setParameter("tenSearch", "%" + tenParam + "%");
            return query.list();
        }
    }

    public List<GiangVien> filterByFemaleGender() {
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            Query<GiangVien> query = session.createQuery("FROM GiangVien WHERE gioiTinh = False", GiangVien.class);
            return query.list();
        }
    }

    public Boolean add(GiangVien giangvien) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.persist(giangvien);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return false;
    }

    public Boolean update(GiangVien giangvien) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.merge(giangvien);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return false;
    }

    public Boolean delete(GiangVien giangVien) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.delete(giangVien);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public GiangVien getOne(String maParam){
        GiangVien giangVien = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            jakarta.persistence.Query query = session.createQuery("FROM GiangVien WHERE ma =: maGetOne", GiangVien.class);
            query.setParameter("maGetOne", maParam);
            giangVien = (GiangVien) query.getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return giangVien;
    }
}
