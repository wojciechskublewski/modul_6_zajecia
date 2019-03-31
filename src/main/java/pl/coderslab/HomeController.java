package pl.coderslab;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {

    @Autowired
    private BookDao bookDao;
    @RequestMapping("/addBook")
    @ResponseBody
    public String hello(){
        Book book  = new Book();
        book.setTitle("Thinking in Java");
                book.setAuthor("Bruce Eckel");
        bookDao.saveBook(book);
        return "Id dodanej ksiazki to:"
                +  book.getId(); }

    @RequestMapping("/showBook/{id}")
    @ResponseBody
    public String hello2(@PathVariable long id) {
        bookDao.findById(id);

        return bookDao.findById(id).getAuthor() + " " + bookDao.findById(id).getTitle();
    }

    @RequestMapping("/showAuthor/{id}")
    @ResponseBody
    public String hello3(@PathVariable long id) {
        authorDao.findById(id);

        return authorDao.findById(id).getFirstName() + " " + authorDao.findById(id).getLastName();
    }

    @RequestMapping("/updateAuthor/{id}/{firstName}/{lastName}")
    @ResponseBody
    public String hello4(@PathVariable long id, @PathVariable String firstName, @PathVariable String lastName) {
        Author author = authorDao.findById(id);
        author.setFirstName(firstName);
        author.setLastName(lastName);
        authorDao.update(author);

        return authorDao.findById(id).getFirstName() + " " + authorDao.findById(id).getLastName();
    }

    @RequestMapping("/updateBook/{id}/{author}/{title}")
    @ResponseBody
    public String hello5(@PathVariable long id, @PathVariable String author, @PathVariable String title) {

        Book book = bookDao.findById(id);
        book.setTitle(title);
        book.setAuthor(author);
        bookDao.update(book);

        return bookDao.findById(id).getTitle() + " " + bookDao.findById(id).getAuthor();
    }

    @RequestMapping("/removeAuthor/{id}")
    @ResponseBody
    public String hello6(@PathVariable long id) {
        Author author= authorDao.findById(id);

        authorDao.delete(author);

        return "autor " + id + " usuniety";
    }

    @RequestMapping("/removeBook/{id}")
    @ResponseBody
    public String hello7(@PathVariable long id) {
        Book book= bookDao.findById(id);

        bookDao.delete(book);

        return "book o " + id + " usuniety";
    }




    @Autowired
    private AuthorDao authorDao;
    @RequestMapping("/addAuthor")
    @ResponseBody
    public String helloAuthor(){
        Author author  = new Author();
        author.setFirstName("Wojtek");
        author.setLastName("Skublewski");
        authorDao.saveAuthor(author);
        return "Id autora to:"
                +  author.getId(); }


    @Autowired
    private PublisherDao publisherDao;
    @RequestMapping("/addPublisher")
    @ResponseBody
    public String hello7(){
        Publisher publisher  = new Publisher();
        publisher.setName("Ala Skublewska");
        publisherDao.savePublisher(publisher);
        return "Id publisher to:"
                +  publisher.getId(); }

    @RequestMapping("/removePublisher/{id}")
    @ResponseBody
    public String hello8(@PathVariable long id) {
        Publisher publisher= publisherDao.findById(id);

        publisherDao.delete(publisher);

        return "Publisher " + id + " usuniety";
    }

    @RequestMapping("/showPublisher/{id}")
    @ResponseBody
    public String hello9(@PathVariable long id) {
        publisherDao.findById(id);

        return publisherDao.findById(id).getName();
    }

    @RequestMapping("/updatePublisher/{id}/{name}")
    @ResponseBody
    public String hello10(@PathVariable long id, @PathVariable String name) {

        Publisher publisher = publisherDao.findById(id);
        publisher.setName(name);
        publisherDao.update(publisher);

        return publisherDao.findById(id).getName();
    }
}
