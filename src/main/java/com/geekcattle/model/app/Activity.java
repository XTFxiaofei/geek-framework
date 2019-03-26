package com.geekcattle.model.app;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.geekcattle.model.BaseEntity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class Activity extends BaseEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    private int activityId;
    private Integer userId;
    private String title;
    private String logoImage;
    private Long createTime;
    private String content;
    private String place;
    private String type;
    private String level;
    private String sponsor;
    private String target;
    private String typeNickname;
    private String activityTime;
    private String contentPicture;
    private Integer flag;
    private Long updateTime;
    private String activityName;
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
    @Column(name = "activity_id", nullable = false)
    public int getActivityId() {
        return activityId;
    }

    public void setActivityId(int activityId) {
        this.activityId = activityId;
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
    @Column(name = "logo_image", nullable = true, length = 255)
    public String getLogoImage() {
        return logoImage;
    }

    public void setLogoImage(String logoImage) {
        this.logoImage = logoImage;
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
    @Column(name = "content", nullable = true, length = -1)
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Basic
    @Column(name = "place", nullable = true, length = 100)
    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    @Basic
    @Column(name = "type", nullable = true, length = 100)
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Basic
    @Column(name = "level", nullable = true, length = 100)
    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    @Basic
    @Column(name = "sponsor", nullable = true, length = 100)
    public String getSponsor() {
        return sponsor;
    }

    public void setSponsor(String sponsor) {
        this.sponsor = sponsor;
    }

    @Basic
    @Column(name = "target", nullable = true, length = 100)
    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    @Basic
    @Column(name = "type_nickname", nullable = true, length = 100)
    public String getTypeNickname() {
        return typeNickname;
    }

    public void setTypeNickname(String typeNickname) {
        this.typeNickname = typeNickname;
    }

    @Basic
    @Column(name = "activity_time", nullable = true, length = 100)
    public String getActivityTime() {
        return activityTime;
    }

    public void setActivityTime(String activityTime) {
        this.activityTime = activityTime;
    }

    @Basic
    @Column(name = "content_picture", nullable = true, length = 255)
    public String getContentPicture() {
        return contentPicture;
    }

    public void setContentPicture(String contentPicture) {
        this.contentPicture = contentPicture;
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
    @Column(name = "update_time", nullable = true)
    public Long getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Long updateTime) {
        this.updateTime = updateTime;
    }

    @Basic
    @Column(name = "activity_name", nullable = true, length = 100)
    public String getActivityName() {
        return activityName;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Activity activity = (Activity) o;
        return activityId == activity.activityId &&
                Objects.equals(userId, activity.userId) &&
                Objects.equals(title, activity.title) &&
                Objects.equals(logoImage, activity.logoImage) &&
                Objects.equals(createTime, activity.createTime) &&
                Objects.equals(content, activity.content) &&
                Objects.equals(place, activity.place) &&
                Objects.equals(type, activity.type) &&
                Objects.equals(level, activity.level) &&
                Objects.equals(sponsor, activity.sponsor) &&
                Objects.equals(target, activity.target) &&
                Objects.equals(typeNickname, activity.typeNickname) &&
                Objects.equals(activityTime, activity.activityTime) &&
                Objects.equals(contentPicture, activity.contentPicture) &&
                Objects.equals(flag, activity.flag) &&
                Objects.equals(updateTime, activity.updateTime) &&
                Objects.equals(activityName, activity.activityName);
    }

    @Override
    public int hashCode() {

        return Objects.hash(activityId, userId, title, logoImage, createTime, content, place, type, level, sponsor, target, typeNickname, activityTime, contentPicture, flag, updateTime, activityName);
    }
}
