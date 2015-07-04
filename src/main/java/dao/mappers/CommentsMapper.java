package dao.mappers;

import entities.Comments;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by alexandr on 4.7.15.
 */
public class CommentsMapper implements RowMapper<Comments> {
    @Override
    public Comments mapRow(ResultSet resultSet, int i) throws SQLException {
        Comments comments = new Comments();
        comments.setCommentId(resultSet.getInt("comment_id"));
        comments.setCreationDate(resultSet.getDate("creation_date"));
        comments.setCommentText(resultSet.getString("comment_text"));
        comments.setNewsId(resultSet.getInt("news_id"));

        return comments;
    }
}
