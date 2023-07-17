package com.example.task.manager.dto;

import com.example.task.manager.dto.constant.StatusTask;

import java.util.Date;


public class TaskDTO extends BaseDTO {

    private String Title;

    private String Content;

    private Date Deadline_Start;

    private Date Deadline_End;

    private String Status = String.valueOf(StatusTask.ready);

    private String createdBy;

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
