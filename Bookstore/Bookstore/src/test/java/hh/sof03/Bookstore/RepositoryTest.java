package hh.sof03.Bookstore;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import hh.sof03.Bookstore.domain.Book;
import hh.sof03.Bookstore.domain.BookRepository;
import hh.sof03.Bookstore.domain.Category;
import hh.sof03.Bookstore.domain.CategoryRepository;
import hh.sof03.Bookstore.domain.User;
import hh.sof03.Bookstore.domain.UserRepository;




@DataJpaTest
public class RepositoryTest {

     @Autowired
    private BookRepository BRepository;

    @Autowired
    private CategoryRepository CRepository;

    @Autowired
    private UserRepository URepository;



    @Test
    void testSaveBook() {
        
        Book a = new Book("Harry Potter", "JK Rowling", 2001, "AGD53B", 23.56, CRepository.findByName("Fiction").get(0));

        Book savedBook = BRepository.save(a);

        assertThat(savedBook).isNotNull();
        assertThat(savedBook.getId()).isNotNull();
    }

    @Test
    void testDeleteBook() {
        
        Book a = new Book("Harry Potter", "JK Rowling", 2001, "AGD53B", 23.56, CRepository.findByName("Fiction").get(0));
        Book savedBook = BRepository.save(a);

        
        BRepository.delete(a);

        
        Optional<Book> deletedBook = BRepository.findById(a.getId());
        assertTrue(deletedBook.isEmpty());
    }

    @Test
void testSearchBooksByTitle() {
    // Create categories
    Category fictionCategory = new Category("Fiction");
    CRepository.save(fictionCategory);

    // Create books
    Book harryPotter1 = new Book("Nameless", "JK Rowling", 2001, "AGD53B", 23.56, fictionCategory);
    Book harryPotter2 = new Book("Nameless", "JK Rowling", 2005, "BDF74C", 29.99, fictionCategory);
    Book simbad = new Book("Simbad", "Ahmad Khan", 2001, "GHJ675", 19.99, fictionCategory);
    BRepository.saveAll(List.of(harryPotter1, harryPotter2, simbad));

    // Search for books with title "Harry Potter"
    List<Book> foundBooks = BRepository.findByTitle("Nameless");

    // Assert that both Harry Potter books are found
    assertEquals(2, foundBooks.size());
    assertTrue(foundBooks.contains(harryPotter1));
    assertTrue(foundBooks.contains(harryPotter2));
}
  
    @Test
    void testSaveCategory() {
        Category category = new Category("Fiction");
        Category savedCategory = CRepository.save(category);

        assertThat(savedCategory.getId()).isNotNull();
    }

    
 @Test
void testDeleteCategory() {
    
    Category category = new Category("Fiction");
    
    Category savedCategory = CRepository.save(category);

    
    CRepository.deleteById(savedCategory.getId());

    // Retrieve all categories from the repository and convert to a list
    Iterable<Category> iterableCategories = CRepository.findAll();
    List<Category> categories = new ArrayList<>();
    iterableCategories.forEach(categories::add);

    // Assert that the deleted category is not present in the list of categories
    assertFalse(categories.contains(savedCategory));
}

    @Test
    void testFindByNameCategory() {
        Category category = new Category("Fiction");
        CRepository.save(category);

        List<Category> foundCategories = CRepository.findByName("Fiction");
        assertTrue(!foundCategories.isEmpty()); 
        assertEquals("Fiction", foundCategories.get(0).getName()); 
    }


    @Test
    void testSaveUser() {
        
        User user = new User("testuser", "password", "testuser@example.com", "USER");

        
        User savedUser = URepository.save(user);

        
        assertNotNull(savedUser);
        
        assertNotNull(savedUser.getId());
        
    }

    @Test
    void testDeleteUser() {
        
        User user = new User("testuser", "password", "testuser@example.com", "USER");
        
        User savedUser = URepository.save(user);

        
        URepository.delete(savedUser);

        assertFalse(URepository.existsById(savedUser.getId()));
        
    }

    @Test
    void testFindByUsername() {
        
        User user = new User("testuser", "password", "testuser@example.com", "USER");
        URepository.save(user);

        
        User foundUser = URepository.findByUsername("testuser");

        
        assertNotNull(foundUser);
        assertEquals("testuser", foundUser.getUsername());
    }





}
