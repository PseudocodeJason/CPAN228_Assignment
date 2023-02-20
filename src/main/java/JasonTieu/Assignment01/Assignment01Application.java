package JasonTieu.Assignment01;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import JasonTieu.Assignment01.model.Item;
import JasonTieu.Assignment01.model.Item.Brand;
import JasonTieu.Assignment01.repository.ItemRepositroy;

@SpringBootApplication
public class Assignment01Application {

	public static void main(String[] args) {
		SpringApplication.run(Assignment01Application.class, args);
	}

	@Bean
	public CommandLineRunner dataLoader(ItemRepositroy repositroy){
		return args ->{
			repositroy.save(Item.builder()
			.name("Bag")
			.brandForm(Brand.GUCCI)
			.yearOfCreation(2022)
			.price(2500.00).build());
		};
	}

}
