package com.ricardo.anderson.zupblog;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import com.ricardo.anderson.zupblog.client.ViaCEPClient;
import com.ricardo.anderson.zupblog.vo.Endereco;

@EnableFeignClients
@SpringBootApplication
public class ZupBlogApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZupBlogApplication.class, args);
		
	}
	
	@Bean
    public CommandLineRunner run(ViaCEPClient client){
        return args -> {
            if (args.length > 0) {
                String cep = "57018543";
 
                Endereco endereco = client.buscaEnderecoPor(cep);
 
                System.out.println(endereco);
            }
        };
    }

}
