package com.survivingcodingbootcamp.blog.model;

import javax.persistence.*;
import java.util.Arrays;
import java.util.Collection;

@Entity
public class Post {
    @Id
    @GeneratedValue
    private Long id;
    private String author;
    private String title;
    @ManyToOne
    private Topic topic;
    @Lob
    private String content;
    @ManyToMany
    private Collection<Hashtag> hashtags;



    public Post(String author, String title, Topic topic, String content, Hashtag ...hashtags) {
        this.author = author;
        this.title = title;
        this.topic = topic;
        this.content = content;
        this.hashtags = Arrays.asList(hashtags);
    }
    public Post() {
    }
    public void addHashtag(Hashtag hashtag){
        hashtags.add(hashtag);
    }

    public Long getId() {
        return id;
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public Topic getTopic() {
        return topic;
    }

    public Collection<Hashtag> getHashtags() {
        return hashtags;
    }

    public String getContent() {
        return content;
    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", author='" + author + '\'' +
                ", title='" + title + '\'' +
                ", topic=" + topic +
                ", content='" + content + '\'' +
                ", hashtags=" + hashtags +
                '}';
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Post post = (Post) o;

        if (id != null ? !id.equals(post.id) : post.id != null) return false;
        if (title != null ? !title.equals(post.title) : post.title != null) return false;
        if (topic != null ? !topic.equals(post.topic) : post.topic != null) return false;
        return content != null ? content.equals(post.content) : post.content == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (topic != null ? topic.hashCode() : 0);
        result = 31 * result + (content != null ? content.hashCode() : 0);
        return result;
    }

    public void addPost(Post post) {
    }
}
