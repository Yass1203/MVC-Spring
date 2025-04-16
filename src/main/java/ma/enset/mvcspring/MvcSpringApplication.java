package ma.enset.mvcspring;

import ma.enset.mvcspring.entities.Product;
import ma.enset.mvcspring.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MvcSpringApplication {

    public static void main(String[] args) {

        SpringApplication.run(MvcSpringApplication.class, args);
    }
        @Bean
    CommandLineRunner commandLineRunner( ProductRepository productRepository){
        return args -> {
            Product product = Product.builder()
                    .name("Phone").price(1000.0).quantity(10)
                    .build();
            productRepository.save(product);
            productRepository.save(Product.builder().name("Casque").price(1800.0).quantity(70).build());

            // Pour afficher les information sur les produits
            productRepository.findAll().forEach( p-> {
                    System.out.println(p.toString());
            });
            // Appel de Constructeur
            // productRepository.save(new Product(null,"Laptop",1000.0,10));
        };
    }


}
