import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.github.springtestdbunit.annotation.DatabaseTearDown;
import com.github.springtestdbunit.annotation.ExpectedDatabase;
import com.github.springtestdbunit.assertion.DatabaseAssertionMode;
import dao.impl.NewsDaoImpl;
import dao.interfaces.AuthorDao;
import entities.Author;
import entities.News;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;

/**
 * Created by alexandr on 3.7.15.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/testConfiguration/configuration.xml")
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class,
        DbUnitTestExecutionListener.class })
public class AuthorDaoTest {

    @Autowired
    private AuthorDao authorDao;

    @Test
    @DatabaseTearDown("/authorTestData/authorData.xml")
   // @DatabaseSetup("/authorTestData/authorData.xml")
    @ExpectedDatabase(value= "/authorTestData/addAuthorExpectedData.xml",assertionMode= DatabaseAssertionMode.NON_STRICT)
    public void testAddAuthor() throws Exception {
        Author author = new Author();
        author.setName("George");
        author.setAuthorId(3);
        authorDao.addAuthor(author);
    }

    @Test
    @DatabaseTearDown("/authorTestData/authorData.xml")
    // @DatabaseSetup("/authorTestData/authorData.xml")
    @ExpectedDatabase(value= "/authorTestData/authorData.xml",assertionMode= DatabaseAssertionMode.NON_STRICT)
    public void testGetAuthor() throws Exception {
        Author expected = new Author();
        expected.setName("Mike");
        expected.setAuthorId(2);
        Author actual = authorDao.getAuthor(2);
        Assert.assertEquals(expected, actual);

    }



    @Test
    @DatabaseTearDown("/authorTestData/authorData.xml")
    // @DatabaseSetup("/authorTestData/authorData.xml")
    @ExpectedDatabase(value= "/authorTestData/deleteAuthorExpectedData.xml",assertionMode= DatabaseAssertionMode.NON_STRICT)
    public void testDeleteAuthor() throws Exception {

        authorDao.deleteAuthor(1);
    }

    @Test
    @DatabaseTearDown("/authorTestData/authorData.xml")
    @ExpectedDatabase(value= "/authorTestData/editAuthorExpectedData.xml",assertionMode= DatabaseAssertionMode.NON_STRICT)
    public void testEditAuthor() throws Exception {
        Author author = new Author();
        author.setAuthorId(2);
        author.setName("Mishel");
        authorDao.editAuthor(author,2);
    }


}
