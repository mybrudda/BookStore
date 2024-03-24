package hh.sof03.Bookstore;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import hh.sof03.Bookstore.web.BookController;
import hh.sof03.Bookstore.web.BookRestController;
import hh.sof03.Bookstore.web.CategoryController;

@SpringBootTest
class BookstoreApplicationTests {

    @Autowired
    private BookController controllerA;

    @Autowired
    private BookRestController controllerB;

    @Autowired
    private CategoryController controllerC;

    @Test
    void contextLoads() {
        assertThat(controllerA).isNotNull();
        assertThat(controllerB).isNotNull();
        assertThat(controllerC).isNotNull();
    }
}