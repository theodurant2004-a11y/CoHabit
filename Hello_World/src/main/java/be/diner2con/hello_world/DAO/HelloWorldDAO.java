package be.diner2con.hello_world.DAO;

import be.diner2con.hello_world.Models.HelloWorld;
import jakarta.persistence.EntityManager;

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
}
