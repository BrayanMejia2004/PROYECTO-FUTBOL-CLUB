package com.proyecto.Crudfutbolclub;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

@SpringBootApplication
public class CrudfutbolclubApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudfutbolclubApplication.class, args);
	}

	@Component
    public class AppStartupRunner implements CommandLineRunner {

        @Override
        public void run(String... args) throws Exception {           
            Runtime.getRuntime().exec("cmd /c start http://localhost:8080/index");
        }
    }

}
