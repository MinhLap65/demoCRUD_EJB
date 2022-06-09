/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import entities.Book;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import session.BookSessionBeanLocal;

/**
 *
 * @author MinhLap
 */
@ManagedBean(name="bookBean")
public class BookBean implements Serializable{

    @EJB
    private BookSessionBeanLocal bookSessionBean;
    private Book book = new Book();
    
    public BookBean() {
        
    }
    public List<Book> getBookList() {
        return bookSessionBean.findAll();
    }
    public void delete(String bookid) {
        bookSessionBean.delete(bookid);
    }
    
    public String edit(String bookid) {
        book = bookSessionBean.find(bookid);
        return "editbook";
    }
    
    public Book getBook() {
        return book;
    }
    
    public String insert() {
        bookSessionBean.insert(book);
        return "index";
    }
    
    public String update() {
        bookSessionBean.update(book);
        return "index";
    }
}
