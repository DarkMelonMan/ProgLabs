import java.util.ArrayList;
import java.util.Comparator;
import java.util.NoSuchElementException;

public class EntityManager<T extends LivingEntity>{
    public EntityManager(){
        entities = new ArrayList<>();
    }

    public void addEntity(T entity){
        entities.add(entity);
    }

    public void removeEntity(int i){
        entities.remove(i);
    }

    public T getEntity(int i){
        return entities.get(i);
    }

    ArrayList<T> entities;

    public void Print(){
        for (T entity : entities) {
            System.out.println(entity);
            System.out.println();
        }
    }
    public void sortByName(){
        entities.sort(Comparator.comparing(a -> a.name));
    }
    public void sortByHP(){
        entities.sort(Comparator.comparing(a -> a.healthPoints));
    }
    public void sortBySpeed(){
        entities.sort(Comparator.comparing(a -> a.movementSpeed));
    }

    public T find(String name) throws NoSuchElementException{
        for (T entity : entities) {
            if (entity.name.equals(name))
                return entity;
        }
        throw new NoSuchElementException("Entity not found by name");
    }
}
