package dao.mappers;

import entities.News;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by alexandr on 2.7.15.
 */
public class NewsMapper implements RowMapper<News> {
    @Override
    public News mapRow(ResultSet resultSet, int i) throws SQLException {
        News news = new News();
        news.setId(resultSet.getInt("news_id"));
        news.setCreationDate(resultSet.getDate("creation_date"));
        news.setFullText(resultSet.getString("full_text"));
        news.setModificationDate(resultSet.getDate("modification_date"));
        news.setShortText(resultSet.getString("short_text"));
        news.setTitle(resultSet.getString("title"));
        return news;
    }
}
