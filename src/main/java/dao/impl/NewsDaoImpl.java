package dao.impl;

import dao.interfaces.NewsDao;
import dao.mappers.NewsMapper;
import entities.News;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

/**
 * Created by alexandr on 2.7.15.
 */
@Repository("newsDao")
public class NewsDaoImpl implements NewsDao {


    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public void addNews(News news) {

        String sql = "insert into news (news_id, short_text,full_text,title,creation_date,modification_date) values (?,?,?,?,?,?)";
        jdbcTemplate.update(sql,news.getId(),news.getShortText(),news.getFullText(),
                news.getTitle(),news.getCreationDate(),news.getModificationDate());
        System.out.println("Created news");
    }

    @Override
    public void deleteNews(Integer newsId) {
        String sql = "delete from news where news_id = ?";
        jdbcTemplate.update(sql, newsId);
        System.out.println("Deleted news with ID = " + newsId );
    }

    @Override
    public void editNews(News news,Integer newsId) {
        String sql = "update news set news_id = ? , short_text = ? , full_text = ? , title = ? , creation_date = ? , modification_date = ? where news_id = ?";
        jdbcTemplate.update(sql , news.getId(),news.getShortText(),news.getFullText(),
                news.getTitle(),news.getCreationDate(),news.getModificationDate(), newsId);
        System.out.println("Updated news with ID = " + newsId );
        return;

    }

    @Override
    public List<News> readAllNews() {
        String SQL = "select * from news";
        List <News> news = jdbcTemplate.query(SQL,
                new NewsMapper());
       return news;
    }

    @Override
    public News getNews(Integer newsId) {
        String sql = "select * from news where NEWS_ID=?";
        News news = jdbcTemplate.queryForObject(sql, new Object[]{newsId}, new NewsMapper());
        return news;
    }
}
