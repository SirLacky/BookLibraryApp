package com.github.sirlacky.BookLibraryApp;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

import static com.github.sirlacky.BookLibraryApp.AuthorRating.getRatingByAuthor;
import static com.github.sirlacky.BookLibraryApp.BookByCategory.getBookByCategorie;
import static com.github.sirlacky.BookLibraryApp.BookByISBN.getBookByISBN;

@Controller
public class BooksResource {

    private String temp;


    @GetMapping("/")
    public ModelAndView showForm() {
        return new ModelAndView("library-form", "form", new Form());
    }

    //ISBN Search

    @PostMapping("/isbn")
    public String submitIsbn(@ModelAttribute("form") Form form, Model model) {
        model.addAttribute("isbn", form.getIsbn());
        temp = form.getIsbn();
        return "redirect:isbnSearchResult";
    }

    @ResponseBody
    @RequestMapping("/isbnSearchResult")
    public BookByISBN getBooksByISBN() {
        return getBookByISBN(temp);
    }

    //Category Search

    @PostMapping("/category")
    public String submitCategory(@ModelAttribute("form") Form form, Model model) {
        model.addAttribute("category", form.getCategory());
        temp = form.getCategory();
        return "redirect:categorySearchResult";
    }

    @ResponseBody
    @RequestMapping("/categorySearchResult")
    public List<BookByCategory> getBooksByCategory() {

        return getBookByCategorie(temp);
    }

    //Rating Search

    @PostMapping("/rating")
    public String submitAuthor(@ModelAttribute("form") Form form, Model model) {
        model.addAttribute("author", form.getAuthor());
        temp = form.getAuthor();
        return "redirect:ratingSearchResult";
    }

    @ResponseBody
    @RequestMapping("/ratingSearchResult")
    public AuthorRating getAuthorRating() {

        return getRatingByAuthor(temp);

    }
}