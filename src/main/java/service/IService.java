package service;

import java.util.List;

public interface IService <E> {
    List<E> findAll();
    E findByID(int id);
    void remove(int id);
}
