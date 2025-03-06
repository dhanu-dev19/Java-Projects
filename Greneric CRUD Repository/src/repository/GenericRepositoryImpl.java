package repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class GenericRepositoryImpl<T> implements  GenericRepository<T>
{
    private final List<T> entites = new ArrayList<>();
    private final IdExtractor<T> idExtractor;

    public GenericRepositoryImpl(IdExtractor<T> idExtractor)
    {
        this.idExtractor = idExtractor;
    }

    @Override
    public void save(T entity) {
        entites.add(entity);
        System.out.println("Saved: "+entity);
    }

    @Override
    public Optional<T> findById(int id) {
        return entites.stream()
                .filter(e -> idExtractor.getId(e) == id)
                .findFirst();
    }

    @Override
    public List<T> findAll() {
        return entites;
    }

    @Override
    public void update(int id, T updatedEntity)
    {
        for (int i = 0; i < entites.size(); i++)
        {
            if(idExtractor.getId(entites.get(i)) == id)
            {
                entites.set(i, updatedEntity);
                System.out.println("Updated: "+updatedEntity);
                return;
            }

        }
        System.out.println("Entity with Id"+id+"not found");
    }

    @Override
    public void delete(int id)
    {
        entites.removeIf(e -> idExtractor.getId(e) == id);
        System.out.println("Deleted entity with Id"+ id);
    }
}


