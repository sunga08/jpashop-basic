package jpabook.jpashop;

import jpabook.jpashop.domain.Book;
import jpabook.jpashop.domain.Member;
import jpabook.jpashop.domain.Order;
import jpabook.jpashop.domain.OrderItem;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {
            //양방향 연관관계일  때 (Order 엔티티를 조회할 때 orderItems를 바로 알고 싶으면 양방향 연관관계를 넣으면 됨)
            //Order order = new Order();
            //order.addOrderItem(new OrderItem());

            //단방향 연관관계일 때
            //Order order = new Order();
            //em.persist(order);

            //OrderItem orderItem  = new OrderItem();
            //orderItem.setOrder(order);

            Book book = new Book();
            book.setName("JPA");
            book.setAuthor("김영한");

            em.persist(book);

            tx.commit();
        } catch (Exception e){
            tx.rollback();
        } finally {
            em.close();
        }

        emf.close();
    }

}
