package CinemaWeb.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import CinemaWeb.entities.Cinema;

import java.util.List;

public class CinemaDAO {
    private SessionFactory session;

    public void add(Cinema cinema) {
        Transaction addTrans = null;
        try (Session addSe = this.session.openSession()) {
            addTrans = addSe.beginTransaction();
            addSe.save(cinema);
            addTrans.commit();
            addSe.close();
        } catch (HibernateException hibernateException) {
            hibernateException.printStackTrace();
            if (addTrans != null) {
                addTrans.rollback();
            }
        }
    }

    public boolean delete(int id){
        Transaction deleteTran = null;
        Cinema cinema;
        try (Session deleteSe = this.session.openSession()) {
            deleteTran = deleteSe.beginTransaction();
            cinema = this.findById(id);
            if(cinema == null){
                deleteTran.commit();
                deleteSe.close();

                return false;
            }
            deleteSe.delete(cinema);
            deleteTran.commit();
            deleteSe.close();
        } catch (HibernateException hibernateException) {
            hibernateException.printStackTrace();
            if (deleteTran != null) {
                deleteTran.rollback();
            }
        }
        return true;
    }

    public Cinema findById(int id) {
        Transaction finIdTrans = null;
        Cinema cinema;
        try (Session findIdSe = this.session.openSession()) {
            finIdTrans = findIdSe.beginTransaction();
            cinema = findIdSe.get(Cinema.class, id);
            System.out.println(cinema);
            if(cinema == null){
                finIdTrans.commit();
                findIdSe.close();
                return null;
            }
            System.out.println(cinema.getModel());
            finIdTrans.commit();
            findIdSe.close();
            return cinema;
        } catch (HibernateException hibernateException) {
            hibernateException.printStackTrace();
            if (finIdTrans != null) {
                finIdTrans.rollback();
            }
            return null;
        }
    }
    public void update(Cinema cinema){
        Transaction updateTrans = null;
        try (Session updateSe = this.session.openSession()) {
            updateTrans = updateSe.beginTransaction();
            updateSe.update(cinema);
            updateTrans.commit();
            updateSe.close();
        } catch (HibernateException hibernateException) {
            hibernateException.printStackTrace();
            if (updateTrans != null) {
                updateTrans.rollback();
            }
        }
    }

    public List<Cinema> allCinema(){
        return this.session.openSession().createQuery("From Cinema ").list();
    }

    public SessionFactory getSession() {
        return session;
    }

    @Autowired
    public void setSession(SessionFactory session) {
        this.session = session;
    }
}