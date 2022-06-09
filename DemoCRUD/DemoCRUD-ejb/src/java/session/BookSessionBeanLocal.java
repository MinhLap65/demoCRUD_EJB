/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entities.Book;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author MinhLap
 */
@Local
public interface BookSessionBeanLocal {
    List<Book> findAll();
    
    void insert(Book book);
    
    void delete(String bookid);
    
    void update(Book book);
    
    Book find(String bookid);
}
