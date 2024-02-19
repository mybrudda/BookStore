package hh.sof03.Bookstore.domain;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
 
@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    String name;
 
    
    public Category(){

    }
    
    public Category(String name) {
        
        this.name = name;
    }
 
    // getterit
    public long getId() {
        return id;
    }
 
    public void setId(long categoryId) {
        this.id = categoryId;
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
        return "Category [categoryId=" + id + ", name=" + name + "]";
    }
 
}
