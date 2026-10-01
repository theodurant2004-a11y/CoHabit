package be.diner2con.hello_world.DAO;

import be.diner2con.hello_world.Models.HelloWorld;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class HelloWorldDAO extends DAO<HelloWorld> {

    @Override
    public HelloWorld get(int id) {
        EntityManager em = JpaUtil.createEntityManager();

        try{
            return em.find(HelloWorld.class, id);
        } finally{
            em.close();
        }
    }

    @Override
    public boolean update(HelloWorld hw) {
        EntityManager em = JpaUtil.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            HelloWorld existing = em.find(HelloWorld.class, hw.getId());
            if (existing == null) {
                tx.rollback();
                return false;
            }
            existing.setText(hw.getText());
            tx.commit();
            return true;
        } catch (RuntimeException e) {
            if (tx.isActive()) {
                tx.rollback();
            }
            throw e;
        } finally {
            em.close();
        }
    }
}
