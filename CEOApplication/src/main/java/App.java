
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Hello world!
 *
 */
@SpringBootApplication(scanBasePackages = {"com.app.library.*"})
@EnableJpaRepositories(value = "com.app.library.repository.*" )
@EntityScan(value ="com.app.library.dao.*" )

public class App
{
    public static void main( String[] args )
    {
        SpringApplication.run(App.class,args);
    }
}
