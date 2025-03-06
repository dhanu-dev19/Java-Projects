package repository;

public interface IdExtractor<T>
{
    int getId(T entity);
}
