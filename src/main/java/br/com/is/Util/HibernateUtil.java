package br.com.is.Util.DAO;

/**
 * @author Portella, Rodolfo <rodolfosportella@gmail.com>
 */
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

    private static SessionFactory sessionFactory;

    static {
        try {
            sessionFactory = new Configuration().configure().buildSessionFactory();
        } catch (Exception e) {
            e.printStackTrace();
            sessionFactory = null;
        }
    }

    public static Session getSession() {
        return sessionFactory.openSession();
    }
}
