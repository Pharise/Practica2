package CinemaWeb.config;

import CinemaWeb.dao.CinemaDAO;
import CinemaWeb.dao.UserDAO;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.*;

@Configuration
@ComponentScan("CinemaWeb")
public class SpringConfig{
    @Bean
    public HibernateSessionPOST hibernateSession(){
        return new HibernateSessionPOST();
    }

    @Bean
    public UserDAO userDAO(){return new UserDAO();}

    @Bean
    public CinemaDAO cinemaDAO(){
        return new CinemaDAO();
    }

    @Bean
    public SessionFactory sessionFactory(){
        return hibernateSession().getSessionFactory();
    }
}