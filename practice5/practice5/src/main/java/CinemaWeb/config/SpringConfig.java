package CinemaWeb.config;

import FurnitureWeb.dao.FurnitureDAO;
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
    public CinemaDAO cinemaDAO(){
        return new CinemaDAO();
    }

    @Bean
    public SessionFactory sessionFactory(){
        return hibernateSession().getSessionFactory();
    }
}