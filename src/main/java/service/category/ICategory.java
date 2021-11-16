package service.category;

import model.Category;
import service.IService;

import java.util.List;

public interface ICategory extends IService {
    void save(Category category);

    List<Category> checkCategory(int id);
}
