package lt.akademija;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import lt.akademija.model.entity.dto.ProductDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

import org.springframework.context.annotation.ImportResource;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import org.springframework.data.domain.Pageable;

import java.util.TimeZone;

@EnableSwagger2
@SpringBootApplication
/**
 *
 * Main app class
 */
@ImportResource("classpath:application-context.xml")
public class App extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(App.class);
    }

    /**
     * As defined in application.properties.
     */
    @Autowired
    DataSource dataSource;

    /**
     * Swagger builder.
     * @return -
     */
    @Bean
    public Docket swaggerDocket() {

        Docket docket = new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).select()
                .apis(RequestHandlerSelectors.basePackage("lt.akademija")).build();
        // docket.ignoredParameterTypes(Pageable.class, PagedResourcesAssembler.class);
        // Swagger shows additional fields without this
        docket.ignoredParameterTypes(Pageable.class);
        return docket;
    }

    /**
     * Swagger builder.
     */
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("Uberkomanda SAS REST Documentation").version("0.1-SNAPSHOT").build();
    }

     /**
     * Cross-origin resource sharing configurer. For authentication to work, one
     * still needs to disable same-origin policy in one's browser.
     * @return -
     */
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurerAdapter() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**").allowedMethods("*").allowedOrigins("*").allowedHeaders("*")
                        .allowCredentials(true);
            }

        };
    }

}