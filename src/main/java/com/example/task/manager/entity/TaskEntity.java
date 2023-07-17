package com.example.task.manager.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;
@Entity
@Table(name = "task")
public class TaskEntity extends BaseEntity {
    @Column(name = "title")
    private String Title;
    @Column(name = "content")
    private String Content;
    @Column(name = "deadline_start")
    private Date Deadline_Start;
    @Column(name = "deadline_end")
    private Date Deadline_End;
    @Column(name = "status")
    private String Status = "ready";
    @Column(name = "created_by")
    private String createdBy;
    @Column(name = "performer")
    private String Performer;

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }

    public Date getDeadline_Start() {
        return Deadline_Start;
    }

    public void setDeadline_Start(Date deadline_Start) {
        Deadline_Start = deadline_Start;
    }

    public Date getDeadline_End() {
        return Deadline_End;
    }

    public void setDeadline_End(Date deadline_End) {
        Deadline_End = deadline_End;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getPerformer() {
        return Performer;
    }

    public void setPerformer(String performer) {
        Performer = performer;
    }
}
