package com.geekcattle.model.app;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.geekcattle.model.BaseEntity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class Topic extends BaseEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    private int topicId;
    private Integer userId;
    private String title;
    private String theme;
    private String content;
    private Long createTime;
    private String viewAccountJson;
    private Integer sticky;
    private String praiseAccountJson;
    private Integer flag;
    private String contentPictureJson;
    private Integer commentNumber;
    private Integer viewNumber;
    private User userByUserId;
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
    @Column(name = "topic_id", nullable = false)
    public int getTopicId() {
        return topicId;
    }

    public void setTopicId(int topicId) {
        this.topicId = topicId;
    }

    @Basic
    @Column(name = "user_id", nullable = true)
    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "title", nullable = true, length = 100)
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Basic
    @Column(name = "theme", nullable = true, length = 100)
    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    @Basic
    @Column(name = "content", nullable = true, length = -1)
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
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
    @Column(name = "view_account_json", nullable = true, length = 255)
    public String getViewAccountJson() {
        return viewAccountJson;
    }

    public void setViewAccountJson(String viewAccountJson) {
        this.viewAccountJson = viewAccountJson;
    }

    @Basic
    @Column(name = "sticky", nullable = true)
    public Integer getSticky() {
        return sticky;
    }

    public void setSticky(Integer sticky) {
        this.sticky = sticky;
    }

    @Basic
    @Column(name = "praise_account_json", nullable = true, length = 255)
    public String getPraiseAccountJson() {
        return praiseAccountJson;
    }

    public void setPraiseAccountJson(String praiseAccountJson) {
        this.praiseAccountJson = praiseAccountJson;
    }

    @Basic
    @Column(name = "flag", nullable = true)
    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }

    @Basic
    @Column(name = "content_picture_json", nullable = true, length = -1)
    public String getContentPictureJson() {
        return contentPictureJson;
    }

    public void setContentPictureJson(String contentPictureJson) {
        this.contentPictureJson = contentPictureJson;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Topic topic = (Topic) o;
        return topicId == topic.topicId &&
                Objects.equals(userId, topic.userId) &&
                Objects.equals(title, topic.title) &&
                Objects.equals(theme, topic.theme) &&
                Objects.equals(content, topic.content) &&
                Objects.equals(createTime, topic.createTime) &&
                Objects.equals(viewAccountJson, topic.viewAccountJson) &&
                Objects.equals(sticky, topic.sticky) &&
                Objects.equals(praiseAccountJson, topic.praiseAccountJson) &&
                Objects.equals(flag, topic.flag) &&
                Objects.equals(contentPictureJson, topic.contentPictureJson);
    }

    @Override
    public int hashCode() {

        return Objects.hash(topicId, userId, title, theme, content, createTime, viewAccountJson, sticky, praiseAccountJson, flag, contentPictureJson);
    }

    @Basic
    @Column(name = "comment_number", nullable = true)
    public Integer getCommentNumber() {
        return commentNumber;
    }

    public void setCommentNumber(Integer commentNumber) {
        this.commentNumber = commentNumber;
    }

    @Basic
    @Column(name = "view_number", nullable = true)
    public Integer getViewNumber() {
        return viewNumber;
    }

    public void setViewNumber(Integer viewNumber) {
        this.viewNumber = viewNumber;
    }

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "user_id", insertable = false, updatable = false)
    public User getUserByUserId() {
        return userByUserId;
    }

    public void setUserByUserId(User userByUserId) {
        this.userByUserId = userByUserId;
    }
}
