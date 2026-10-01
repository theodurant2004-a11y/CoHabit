package be.diner2con.hello_world.DAO;

public abstract class DAO <T> {

    public abstract T get(int id);

    public abstract boolean update(T obj);
}
