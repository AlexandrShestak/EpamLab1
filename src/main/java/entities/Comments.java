package entities;

import java.sql.Date;

/**
 * Created by alexandr on 4.7.15.
 */
public class Comments {
    private Integer commentId;
    private String commentText;
    private Date creationDate;
    private Integer newsId;

    public Integer getCommentId() {
        return commentId;
    }

    public void setCommentId(Integer commentId) {
        this.commentId = commentId;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Integer getNewsId() {
        return newsId;
    }

    public void setNewsId(Integer newsId) {
        this.newsId = newsId;
    }

    public String getCommentText() {
        return commentText;
    }

    public void setCommentText(String commentText) {
        this.commentText = commentText;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Comments comments = (Comments) o;

        if (commentId != null ? !commentId.equals(comments.commentId) : comments.commentId != null) return false;
        if (commentText != null ? !commentText.equals(comments.commentText) : comments.commentText != null)
            return false;
        if (creationDate != null ? !creationDate.equals(comments.creationDate) : comments.creationDate != null)
            return false;
        if (newsId != null ? !newsId.equals(comments.newsId) : comments.newsId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = commentId != null ? commentId.hashCode() : 0;
        result = 31 * result + (commentText != null ? commentText.hashCode() : 0);
        result = 31 * result + (creationDate != null ? creationDate.hashCode() : 0);
        result = 31 * result + (newsId != null ? newsId.hashCode() : 0);
        return result;
    }
}
