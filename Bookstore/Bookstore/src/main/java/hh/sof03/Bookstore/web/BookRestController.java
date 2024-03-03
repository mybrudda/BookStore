package hh.sof03.Bookstore.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import hh.sof03.Bookstore.domain.Book;
import hh.sof03.Bookstore.domain.BookRepository;

@CrossOrigin
@Controller
public class BookRestController {

    @Autowired
    private BookRepository bookRepository;

    @GetMapping("/allbooks")
    public @ResponseBody List<Book> bookListRest(){
        return (List<Book>) bookRepository.findAll();
    }

    @GetMapping("/book/{id}")
    public @ResponseBody Book findBookRest(@PathVariable("id") Long id){
    return bookRepository.findById(id).orElse(null);
}


}
