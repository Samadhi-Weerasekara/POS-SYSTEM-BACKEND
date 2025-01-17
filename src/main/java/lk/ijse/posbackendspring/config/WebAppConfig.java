package lk.ijse.posbackendspring.config;

import jakarta.servlet.annotation.MultipartConfig;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@ComponentScan(basePackages = "lk.ijse.posbackendspring")
@EnableWebMvc
@EnableJpaRepositories(basePackages = "lk.ijse.posbackendspring")
@EnableTransactionManagement
@MultipartConfig(
        fileSizeThreshold = 1024 * 1024 * 10, //2MB
        maxFileSize = 1024 * 1024 * 10, // 10MB
        maxRequestSize = 1024 * 1024 * 10 // 50MB
)
public class WebAppConfig {

}
