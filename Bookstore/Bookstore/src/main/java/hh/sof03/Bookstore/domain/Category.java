package hh.sof03.Bookstore.domain;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
 
@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long categoryId;
    String name;
 
    // kontruktorit
    public Category(String name) {
        
        this.name = name;
    }
 
    // getterit
    public long getCategoryId() {
        return categoryId;
    }
 
    public void setCategoryId(long categoryId) {
        this.categoryId = categoryId;
    }
 
    // Setterit
    public String getName() {
        return name;
    }
 
    public void setName(String name) {
        this.name = name;
    }
 
    // toString
    @Override
    public String toString() {
        return "Category [categoryId=" + categoryId + ", name=" + name + "]";
    }
 
}
