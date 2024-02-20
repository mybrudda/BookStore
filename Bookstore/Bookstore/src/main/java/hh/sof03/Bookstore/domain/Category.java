package hh.sof03.Bookstore.domain;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
 
@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    String name;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "category")
    private List<Book> books;
 
    
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

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }
 
}
