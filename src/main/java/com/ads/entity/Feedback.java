package com.ads.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Timestamp;
import java.util.Objects;

/**
 * @author dfggking@hotmail.com
 * @version 1.0
 * @date 2017/12/15
 */
@Entity
public class Feedback {
    private String id;
    private String title;
    private String content;
    private Timestamp createdTime;
    private Timestamp updatedTime;
    
    @Id
    @Column(name = "id")
    public String getId() {
        return id;
    }
    
    public void setId(String id) {
        this.id = id;
    }
    
    @Basic
    @Column(name = "title")
    public String getTitle() {
        return title;
    }
    
    public void setTitle(String title) {
        this.title = title;
    }
    
    @Basic
    @Column(name = "content")
    public String getContent() {
        return content;
    }
    
    public void setContent(String content) {
        this.content = content;
    }
    
    @Basic
    @Column(name = "created_time")
    public Timestamp getCreatedTime() {
        return createdTime;
    }
    
    public void setCreatedTime(Timestamp createdTime) {
        this.createdTime = createdTime;
    }
    
    @Basic
    @Column(name = "updated_time")
    public Timestamp getUpdatedTime() {
        return updatedTime;
    }
    
    public void setUpdatedTime(Timestamp updatedTime) {
        this.updatedTime = updatedTime;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Feedback feedback = (Feedback) o;
        return Objects.equals(id, feedback.id) &&
                Objects.equals(title, feedback.title) &&
                Objects.equals(content, feedback.content) &&
                Objects.equals(createdTime, feedback.createdTime) &&
                Objects.equals(updatedTime, feedback.updatedTime);
    }
    
    @Override
    public int hashCode() {
        
        return Objects.hash(id, title, content, createdTime, updatedTime);
    }
}
