/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entities.Book;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author MinhLap
 */
@Stateless
public class BookSessionBean implements BookSessionBeanLocal {

    @Override
    public List<Book> findAll() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("DemoCRUD-ejbPU");
        EntityManager em = factory.createEntityManager();
        
        Query q = em.createNamedQuery("Book.findAll", Book.class);
        
        return q.getResultList();
    }

    @Override
    public void insert(Book book) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("DemoCRUD-ejbPU");
        EntityManager em = factory.createEntityManager();
        
        em.getTransaction().begin();
        em.persist(book);
        em.getTransaction().commit();
    }

    @Override
    public void delete(String bookid) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("DemoCRUD-ejbPU");
        EntityManager em = factory.createEntityManager();
        
        Book book = em.find(Book.class, bookid);
        
        em.getTransaction().begin();
        em.remove(book);
        em.getTransaction().commit();
    }

    @Override
    public void update(Book book) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("DemoCRUD-ejbPU");
        EntityManager em = factory.createEntityManager();
              
        Book bookFind = em.find(Book.class, book.getBookid());
        
        em.getTransaction().begin();
        bookFind.setName(book.getName());
        bookFind.setNickname(book.getNickname());
        bookFind.setNxb(book.getNxb());
        bookFind.setPrice(book.getPrice());
        em.getTransaction().commit();
    }

    @Override
    public Book find(String bookid) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("DemoCRUD-ejbPU");
        EntityManager em = factory.createEntityManager();
        
        return em.find(Book.class, bookid);
    }
}
