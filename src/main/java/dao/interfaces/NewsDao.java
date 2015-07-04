package dao.interfaces;

import entities.News;

import java.util.List;

/**
 * Created by alexandr on 2.7.15.
 */
public interface NewsDao {
    public void addNews(News news);
    public void deleteNews(Integer newsId);
    public void editNews(News news,Integer newsId);
    public List<News> readAllNews();
    public News getNews(Integer newsId);
}
