package ru.igor.crud.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Writer {
    private Long id;
    private String firstName;
    private String lastName;
    private List<Long> postIds = new ArrayList<>();
    private Status status = Status.ACTIVE;

    public Writer() {}

    public Writer(Long id, String firstName, String lastName, List<Long> postIds, Status status) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.postIds = (postIds == null) ? new ArrayList<>() : new ArrayList<>(postIds);
        this.status = (status == null) ? Status.ACTIVE : status;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }

    public List<Long> getPostIds() { return postIds; }
    public void setPostIds(List<Long> postIds) {
        this.postIds = (postIds == null) ? new ArrayList<>() : new ArrayList<>(postIds);
    }

    public Status getStatus() { return status; }
    public void setStatus(Status status) { this.status = (status == null) ? Status.ACTIVE : status; }

    @Override
    public String toString() {
        return "Writer{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", postIds=" + postIds +
                ", status=" + status +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Writer writer = (Writer) o;
        return Objects.equals(id, writer.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
