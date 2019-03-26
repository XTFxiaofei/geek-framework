package com.geekcattle.model.app;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.geekcattle.model.BaseEntity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class Comment extends BaseEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    private int commentId;
    private Integer fromId;
    private String fromNickname;
    private Integer toId;
    private String toNickename;
    private String commentType;
    private Integer targetId;
    private String commentContent;
    private Long createTime;
    private String commentPicture;
    private Integer flag;
    private User userByFromId;
    private String targetContent;
    @Transient
    @JsonIgnore
    private String sort = "";

    @Transient
    @JsonIgnore
    private String order = "";

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }
    @Id
    @Column(name = "comment_id", nullable = false)
    public int getCommentId() {
        return commentId;
    }

    public void setCommentId(int commentId) {
        this.commentId = commentId;
    }

    @Basic
    @Column(name = "from_id", nullable = true)
    public Integer getFromId() {
        return fromId;
    }

    public void setFromId(Integer fromId) {
        this.fromId = fromId;
    }

    @Basic
    @Column(name = "from_nickname", nullable = true, length = 100)
    public String getFromNickname() {
        return fromNickname;
    }

    public void setFromNickname(String fromNickname) {
        this.fromNickname = fromNickname;
    }

    @Basic
    @Column(name = "to_id", nullable = true)
    public Integer getToId() {
        return toId;
    }

    public void setToId(Integer toId) {
        this.toId = toId;
    }

    @Basic
    @Column(name = "to_nickename", nullable = true, length = 100)
    public String getToNickename() {
        return toNickename;
    }

    public void setToNickename(String toNickename) {
        this.toNickename = toNickename;
    }

    @Basic
    @Column(name = "comment_type", nullable = true, length = 100)
    public String getCommentType() {
        return commentType;
    }

    public void setCommentType(String commentType) {
        this.commentType = commentType;
    }

    @Basic
    @Column(name = "target_id", nullable = true)
    public Integer getTargetId() {
        return targetId;
    }

    public void setTargetId(Integer targetId) {
        this.targetId = targetId;
    }

    @Basic
    @Column(name = "comment_content", nullable = true, length = 255)
    public String getCommentContent() {
        return commentContent;
    }

    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent;
    }

    @Basic
    @Column(name = "create_time", nullable = true)
    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    @Basic
    @Column(name = "comment_picture", nullable = true, length = 255)
    public String getCommentPicture() {
        return commentPicture;
    }

    public void setCommentPicture(String commentPicture) {
        this.commentPicture = commentPicture;
    }

    @Basic
    @Column(name = "flag", nullable = true)
    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Comment comment = (Comment) o;
        return commentId == comment.commentId &&
                Objects.equals(fromId, comment.fromId) &&
                Objects.equals(fromNickname, comment.fromNickname) &&
                Objects.equals(toId, comment.toId) &&
                Objects.equals(toNickename, comment.toNickename) &&
                Objects.equals(commentType, comment.commentType) &&
                Objects.equals(targetId, comment.targetId) &&
                Objects.equals(commentContent, comment.commentContent) &&
                Objects.equals(createTime, comment.createTime) &&
                Objects.equals(commentPicture, comment.commentPicture) &&
                Objects.equals(flag, comment.flag);
    }

    @Override
    public int hashCode() {

        return Objects.hash(commentId, fromId, fromNickname, toId, toNickename, commentType, targetId, commentContent, createTime, commentPicture, flag);
    }

    @ManyToOne
    @JoinColumn(name = "from_id", referencedColumnName = "user_id", insertable = false, updatable = false)
    public User getUserByFromId() {
        return userByFromId;
    }

    public void setUserByFromId(User userByFromId) {
        this.userByFromId = userByFromId;
    }

    @Basic
    @Column(name = "target_content", nullable = true, length = 255)
    public String getTargetContent() {
        return targetContent;
    }

    public void setTargetContent(String targetContent) {
        this.targetContent = targetContent;
    }
}
