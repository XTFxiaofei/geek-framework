package com.geekcattle.model.app;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.geekcattle.model.BaseEntity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.Objects;

@JsonIgnoreProperties(value= {"commentsByUserId","topicsByUserId"})
@Entity
public class User extends BaseEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    private int userId;
    private String account;
    private String password;
    private String nickname;
    private String email;
    private Long phone;
    private String icon;
    private Integer level;
    private Integer state;
    private Long createTime;
    private Long updateTime;
    private String studentCard;
    private String cardPassword;
    private String realName;
    private String role;
    private Integer sex;
    private Collection<Comment> commentsByUserId;
    private Collection<Topic> topicsByUserId;

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

    public void setLevel(int level) {
        this.level = level;
    }

    public void setState(int state) {
        this.state = state;
    }

    @Id
    @Column(name = "user_id", nullable = false)
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "account", nullable = false, length = 100)
    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    @Basic
    @Column(name = "password", nullable = false, length = 100)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "nickname", nullable = true, length = 100)
    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    @Basic
    @Column(name = "email", nullable = true, length = 100)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "phone", nullable = true)
    public Long getPhone() {
        return phone;
    }

    public void setPhone(Long phone) {
        this.phone = phone;
    }

    @Basic
    @Column(name = "icon", nullable = true, length = -1)
    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    @Basic
    @Column(name = "level", nullable = false)
    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    @Basic
    @Column(name = "state", nullable = false)
    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
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
    @Column(name = "update_time", nullable = true)
    public Long getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Long updateTime) {
        this.updateTime = updateTime;
    }

    @Basic
    @Column(name = "student_card", nullable = true, length = 100)
    public String getStudentCard() {
        return studentCard;
    }

    public void setStudentCard(String studentCard) {
        this.studentCard = studentCard;
    }

    @Basic
    @Column(name = "card_password", nullable = true, length = 100)
    public String getCardPassword() {
        return cardPassword;
    }

    public void setCardPassword(String cardPassword) {
        this.cardPassword = cardPassword;
    }

    @Basic
    @Column(name = "real_name", nullable = true, length = 100)
    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    @Basic
    @Column(name = "role", nullable = false, length = 100)
    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return userId == user.userId &&
                Objects.equals(account, user.account) &&
                Objects.equals(password, user.password) &&
                Objects.equals(nickname, user.nickname) &&
                Objects.equals(email, user.email) &&
                Objects.equals(phone, user.phone) &&
                Objects.equals(icon, user.icon) &&
                Objects.equals(level, user.level) &&
                Objects.equals(state, user.state) &&
                Objects.equals(createTime, user.createTime) &&
                Objects.equals(updateTime, user.updateTime) &&
                Objects.equals(studentCard, user.studentCard) &&
                Objects.equals(cardPassword, user.cardPassword) &&
                Objects.equals(realName, user.realName) &&
                Objects.equals(role, user.role);
    }

    @Override
    public int hashCode() {

        return Objects.hash(userId, account, password, nickname, email, phone, icon, level, state, createTime, updateTime, studentCard, cardPassword, realName, role);
    }

    @Basic
    @Column(name = "sex", nullable = true)
    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    @OneToMany(mappedBy = "userByFromId")
    public Collection<Comment> getCommentsByUserId() {
        return commentsByUserId;
    }

    public void setCommentsByUserId(Collection<Comment> commentsByUserId) {
        this.commentsByUserId = commentsByUserId;
    }

    @OneToMany(mappedBy = "userByUserId")
    public Collection<Topic> getTopicsByUserId() {
        return topicsByUserId;
    }

    public void setTopicsByUserId(Collection<Topic> topicsByUserId) {
        this.topicsByUserId = topicsByUserId;
    }
}
