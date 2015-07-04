package dao.interfaces;

import entities.Author;

import javax.xml.stream.events.Comment;

/**
 * Created by alexandr on 4.7.15.
 */
public interface CommentsDao {

    public void addComment(Comment author);
    public void deleteComment(Integer id);
    public void editComment(Comment author,Integer id);
    public Comment getComment(Integer id);
}
