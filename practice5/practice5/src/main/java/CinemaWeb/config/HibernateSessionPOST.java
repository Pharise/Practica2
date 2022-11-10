package CinemaWeb.config;

import FurnitureWeb.entities.Furniture;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import javax.annotation.PostConstruct;

public class HibernateSessionPOST {
    private SessionFactory sessionFactory;

    @PostConstruct
    public void init(){
        Configuration configuration = new Configuration()
                .setProperty("hibernate.dialect", "org.hibernate.dialect.PostgresPlusDialect")
                .setProperty("hibernate.connection.url", "jdbc:postgresql://localhost:5432/postgres")
                .setProperty("hibernate.connection.username", "postgres")
                .setProperty("hibernate.connection.password", "postgres")
                .setProperty("show_sql", "false")
                .setProperty("hibernate.format_sql", "false")
                .setProperty("hibernate.use_sql_comments", "false")
                .setProperty("connection.driver_class", "org.postgresql.Driver")
                .setProperty("hibernate.format_sql", "false")
                .setProperty("hibernate.use_sql_comments", "false")
                .setProperty("hibernate.hbm2ddl.auto", "create")
                .setProperty("hibernate.hbm2ddl.auto", "update")
                .setProperty("hibernate.generate_statistics", "false");
        configuration.addAnnotatedClass(Cinema.class);
        StandardServiceRegistryBuilder builder = new
                StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
        this.sessionFactory = configuration.buildSessionFactory(builder.build());
    }

    public HibernateSessionPOST(){

    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
