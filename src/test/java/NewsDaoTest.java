import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.github.springtestdbunit.annotation.ExpectedDatabase;
import com.github.springtestdbunit.assertion.DatabaseAssertionMode;
import dao.impl.NewsDaoImpl;
import dao.interfaces.NewsDao;
import entities.News;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by alexandr on 2.7.15.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/testConfiguration/configuration.xml")
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class,
        DbUnitTestExecutionListener.class })
public class NewsDaoTest  {

    @Autowired
    private NewsDao newsDao;


    public void setNewsDao(NewsDao newsDao) {
            this.newsDao = newsDao;
    }

    @Test
    @DatabaseSetup("/newsTestData/newsData.xml")
    @ExpectedDatabase(value= "/newsTestData/newsGetNewsByIdExpectedData.xml",assertionMode=DatabaseAssertionMode.NON_STRICT)
    public void testGetNews() throws Exception {
            News news = newsDao.getNews(2);
            News expected = new News();
            expected.setId(2);
            expected.setShortText("short");
            expected.setFullText("full");
            expected.setTitle("title");
            expected.setCreationDate(java.sql.Date.valueOf("2015-10-12"));
            expected.setModificationDate(java.sql.Date.valueOf("2015-10-15"));
            Assert.assertEquals(expected,news);

    }

    @Test
    @DatabaseSetup("/newsTestData/newsData.xml")
    @ExpectedDatabase(value= "/newsTestData/newsAddNewsExpectedData.xml",assertionMode=DatabaseAssertionMode.NON_STRICT)
    public void testAddNews() throws Exception{

        News news = new News();
        news.setId(1);
        news.setShortText("short1");
        news.setFullText("full1");
        news.setTitle("title1");
        news.setCreationDate(java.sql.Date.valueOf("2015-10-12"));
        news.setModificationDate(java.sql.Date.valueOf("2015-10-15"));
        newsDao.addNews(news);
    }

    @Test
    @DatabaseSetup("/newsTestData/newsData.xml")
    @ExpectedDatabase(value= "/newsTestData/deleteNewsExpectedData.xml",assertionMode=DatabaseAssertionMode.NON_STRICT)
    public void testDeleteNews() throws Exception{

       newsDao.deleteNews(2);
    }

    @Test
    @DatabaseSetup("/newsTestData/newsData.xml")
    @ExpectedDatabase(value= "/newsTestData/editNewsExpectedData.xml",assertionMode=DatabaseAssertionMode.NON_STRICT)
    public void testEditNews() throws Exception{
        News news = new News();
        news.setId(2);
        news.setShortText("short1");
        news.setFullText("full1");
        news.setTitle("title1");
        news.setCreationDate(java.sql.Date.valueOf("2015-10-12"));
        news.setModificationDate(java.sql.Date.valueOf("2015-10-15"));
        newsDao.editNews(news,2);
    }

    @Test
    @DatabaseSetup("/newsTestData/newsData.xml")
    @ExpectedDatabase(value= "/newsTestData/newsData.xml",assertionMode=DatabaseAssertionMode.NON_STRICT)
    public void testGetAllNews() throws Exception{
        News news = new News();
        news.setId(2);
        news.setShortText("short");
        news.setFullText("full");
        news.setTitle("title");
        news.setCreationDate(java.sql.Date.valueOf("2015-10-12"));
        news.setModificationDate(java.sql.Date.valueOf("2015-10-15"));
        List<News> expected =  new LinkedList<News>();
        expected.add(news);

        List<News> actual = newsDao.readAllNews();
        Assert.assertEquals(expected,actual);
    }


}
