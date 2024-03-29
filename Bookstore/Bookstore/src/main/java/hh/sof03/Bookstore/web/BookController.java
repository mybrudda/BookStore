package hh.sof03.Bookstore.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import hh.sof03.Bookstore.domain.Book;
import hh.sof03.Bookstore.domain.BookRepository;
import hh.sof03.Bookstore.domain.CategoryRepository;

@Controller
public class BookController {

    @Autowired
    private BookRepository repository;
    @Autowired
    private CategoryRepository categoryRepository;

    @GetMapping("/index")
    public String getIndex(){
        return "index";
    }

    @GetMapping("/booklist")
    public String BookList(Model model){

        model.addAttribute("books", repository.findAll());

        return "booklist";

    }



    
    @GetMapping("/delete/{id}")
    public String deleteBook(@PathVariable("id") Long id, Model model){
        repository.deleteById(id);
        return "redirect:/booklist";
    }

    @GetMapping("/addbook")
    public String addBook(Model model){
        model.addAttribute("book", new Book());
        model.addAttribute("categories", categoryRepository.findAll());
        return "addbook";
    }

    @PostMapping("/save")
    public String save(Book book){
        repository.save(book);
        return "redirect:booklist";
    }

    @RequestMapping("/login")
    public String login(){
        return "login";
    }
}
