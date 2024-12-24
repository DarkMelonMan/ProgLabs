import java.util.ArrayList;

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
}
