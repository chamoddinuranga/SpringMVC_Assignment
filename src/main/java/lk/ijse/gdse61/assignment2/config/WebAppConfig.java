package lk.ijse.gdse61.assignment2.config;

import lk.ijse.gdse61.assignment2.WebAppInitializer;
import lk.ijse.gdse61.assignment2.config.HibernateConfig;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
@ComponentScan(basePackageClasses = WebAppInitializer.class)
public class WebAppConfig {
    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }
}
