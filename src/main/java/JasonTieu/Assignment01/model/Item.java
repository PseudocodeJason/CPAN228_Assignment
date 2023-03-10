package JasonTieu.Assignment01.model;


import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String name;
    private Brand brandForm;
    @Min(2021)
    private int yearOfCreation;
    @DecimalMin(value = "1000", inclusive = true)
    private Double price;

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
}
