package repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public interface GenericRepository <T>
{
    void save(T entity);  //Create
    Optional<T> findById(int id); //Read
    List<T> findAll(); //ReadAll
    void update(int id, T updatedEntity); //Update
    void delete(int id); //Delete
}

