package productSource.model;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Size(min = 2, max = 20)
    private String name;

    @Positive
    private Double price;

    @Positive
    private Integer quantity;

    private String dateCreate;

    @Size(min = 10)
    private String description;

    @ManyToOne
    private ProductCategory productCategory;

    public Product(){

    }

    public Product(String name, Double price, Integer quantity, String dateCreate, String description) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.dateCreate = dateCreate;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getDateCreate() {
        return dateCreate;
    }

    public void setDateCreate(String dateCreate) {
        this.dateCreate = dateCreate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ProductCategory getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(ProductCategory productCategory) {
        this.productCategory = productCategory;
    }
}
