package JasonTieu.Assignment01.model;

import org.springframework.data.annotation.Id;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Item {
    @Id
    private Long id;
    @NotBlank
    private String name;
    private Brand brandForm;
    @Min(2021)
    private int yearOfCreation;
    @DecimalMin(value = "1000", inclusive = true)
    private Double price;


    public Item(Long id, String name, Brand brandForm, int yearOfCreation, Double price) {
        this.id = id;
        this.name = name;
        this.brandForm = brandForm;
        this.yearOfCreation = yearOfCreation;
        this.price = price;
    }

    public enum Brand{
        DIOR("Dior"), 
        BALENCIAGA("Balenciaga"), 
        STONEISLAND("Stone Island"), 
        LOUISVUITTON("Louis Vuitton"),
        HERMES("Hermes"),
        GUCCI("Gucci"),
        TIFFINYCO("Tiffany & Co");

        private String brand;

        private Brand(String brand){
            this.brand = brand;
        }

        public String getBrand(){
            return brand;
        }
    }

    // if (price > 1000 || yearOfCreation > 2021 ){

    //     if (!Arrays.asList(Brand.values()).contains(brandForm)){
    
    //         throw new IllegalArgumentException("Brand Must On the List Since it is over 1000 Dollars or newer than 2021");
    
    //     }
        
    // }
}
