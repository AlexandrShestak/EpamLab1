package dao.impl;

import dao.interfaces.AuthorDao;
import dao.mappers.AuthorMapper;
import dao.mappers.NewsMapper;
import entities.Author;
import entities.News;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;

/**
 * Created by alexandr on 3.7.15.
 */
@Repository("authorDao")
public class AuthorDaoImpl implements AuthorDao {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource) {

        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }


    @Override
    public void addAuthor(Author author) {
        String sql = "insert into author (author_id, name ) values (?,?)";
        jdbcTemplate.update(sql, author.getAuthorId(), author.getName());

    }

    @Override
    public void deleteAuthor(Integer id) {
        String sql = "delete from author where author_id = ?";
        jdbcTemplate.update(sql, id);
    }

    @Override
    public void editAuthor(Author author, Integer id) {
        String sql = "update author set author_id = ? , name = ?  where AUTHOR_ID = ?";
        jdbcTemplate.update(sql ,author.getAuthorId(),author.getName(),id);
    }

    @Override
    public Author getAuthor(Integer id) {
        String sql = "select * from author where AUTHOR_ID=?";
        Author author = jdbcTemplate.queryForObject(sql,new Object[]{id},new AuthorMapper());
        return author;
    }
}
