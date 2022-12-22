package CinemaWeb;

//import CinemaWeb.config.RabbitConfig;
import jdk.jfr.Enabled;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.jms.annotation.EnableJms;
import org.apache.log4j.BasicConfigurator;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
@EnableJms
//@Import(RabbitConfig.class)
public class Main {
    public static void main(String[] args){
        BasicConfigurator.configure();
        SpringApplication.run(Main.class, args);
    }
}