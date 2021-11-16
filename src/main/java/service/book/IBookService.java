package service.book;

import model.Book;
import service.IService;

public interface IBookService extends IService<Book> {
    void save(Book book,int[] catagories);
    public void update(int id, Book book,int[] categories);
}
