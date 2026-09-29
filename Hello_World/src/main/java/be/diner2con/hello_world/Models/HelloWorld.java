package be.diner2con.hello_world.Models;

import be.diner2con.hello_world.DAO.DAO;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name = "HELLOWORLD")

public class HelloWorld implements Serializable {
    @Id
    @Column(name = "ID_HELLOWORLD")
    private int id;
    @Column(name = "TEXT")
    private String text;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public HelloWorld(){}

    public HelloWorld(int id, String text) {
        this.id = id;
        this.text = text;
    }

    public static HelloWorld getHelloWorld(int id, DAO<HelloWorld> hwDAO) {return hwDAO.get(id);}

}
