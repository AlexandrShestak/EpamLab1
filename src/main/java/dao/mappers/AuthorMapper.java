package dao.mappers;

import entities.Author;
import entities.News;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by alexandr on 3.7.15.
 */
public class AuthorMapper implements RowMapper<Author> {
    @Override
    public Author mapRow(ResultSet resultSet, int i) throws SQLException {
        Author author = new Author();
        author.setAuthorId(resultSet.getInt("author_id"));
        author.setName(resultSet.getString("name"));

        return author;
    }
}
