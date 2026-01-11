package ru.igor.crud.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Post {
    private Long id;
    private String title;
    private String content;
    private List<Long> labelIds = new ArrayList<>();
    private Status status = Status.ACTIVE;

    public Post() {}

    public Post(Long id, String title, String content, List<Long> labelIds, Status status) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.labelIds = (labelIds == null) ? new ArrayList<>() : new ArrayList<>(labelIds);
        this.status = (status == null) ? Status.ACTIVE : status;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getContent() { return content; }
    public void setContent(String content) { this.content = content; }

    public List<Long> getLabelIds() { return labelIds; }
    public void setLabelIds(List<Long> labelIds) {
        this.labelIds = (labelIds == null) ? new ArrayList<>() : new ArrayList<>(labelIds);
    }

   
}
