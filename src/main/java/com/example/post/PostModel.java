package com.example.post;

import java.lang.reflect.Array;
import java.util.ArrayList;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "post")
public class PostModel {
    @Id
    @SequenceGenerator(
        name = "post_sequence",
        sequenceName = "post_sequence",
        allocationSize = 1
    )
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "post_sequence"
    )
    private Long postId;
    private Long creatorId;
    private String title;
    private String content;
    @ElementCollection
    private ArrayList<String> tags;
    

    public PostModel() {
    }

    public PostModel(Long postId, String title, String content, ArrayList<String> tags, Long creatorId) {
        this.postId = postId;
        this.title = title;
        this.content = content;
        this.tags = new ArrayList<String>();
        this.tags.addAll(tags);
        this.creatorId = creatorId;
    }

    public Long getId() {
        return postId;
    }

    public void setId(Long postId) {
        this.postId = postId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public ArrayList<String> getTags() {
        return tags;
    }

    public void setTags(ArrayList<String> tags) {
        this.tags.addAll(tags);
    }

    public void addTag(String tag) {
        this.tags.add(tag);
    }

    public void removeTags(ArrayList<String> remove) {
        this.tags.removeAll(remove);
    }

    public void removeTag(String remove) {
        this.tags.remove(remove);
    }

    public Long getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(Long creatorId) {
        this.creatorId = creatorId;
    }
}
