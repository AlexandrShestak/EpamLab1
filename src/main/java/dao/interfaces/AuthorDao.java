package dao.interfaces;

import entities.Author;

/**
 * Created by alexandr on 3.7.15.
 */
public interface AuthorDao {

    public void addAuthor(Author author);
    public void deleteAuthor(Integer id);
    public void editAuthor(Author author,Integer id);
    public Author getAuthor(Integer id);
}
