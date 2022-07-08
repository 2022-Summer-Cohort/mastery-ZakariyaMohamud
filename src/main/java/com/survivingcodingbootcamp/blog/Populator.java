package com.survivingcodingbootcamp.blog;

import com.survivingcodingbootcamp.blog.model.Hashtag;
import com.survivingcodingbootcamp.blog.model.Post;
import com.survivingcodingbootcamp.blog.model.Topic;
import com.survivingcodingbootcamp.blog.repository.HashtagRepository;
import com.survivingcodingbootcamp.blog.repository.PostRepository;
import com.survivingcodingbootcamp.blog.repository.TopicRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Populator implements CommandLineRunner {

    private TopicRepository topicRepo;
    private PostRepository postRepo;

    private HashtagRepository hashtagRepo;

    public Populator(TopicRepository topicRepo, PostRepository postRepo,HashtagRepository hashtagRepo) {

        this.topicRepo = topicRepo;
        this.postRepo = postRepo;
        this.hashtagRepo = hashtagRepo;
    }

    @Override
    public void run(String... args) throws Exception {
        Hashtag hashtag1 = new Hashtag("#Fun");
        hashtagRepo.save(hashtag1);
        Hashtag hashtag2 = new Hashtag("#Java");
        hashtagRepo.save(hashtag2);
        Hashtag hashtag3 =new Hashtag("#OOPs");
        hashtagRepo.save(hashtag3);
        Hashtag hashtag4 = new Hashtag("#Complex");
        hashtagRepo.save(hashtag4);


        Topic topic1 = new Topic("Learning TDD");
        topicRepo.save(topic1);

        Post post1 = new Post("Zakariya","Dedication and Determination", topic1  , "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore",hashtag3,hashtag1);
        postRepo.save(post1);

        Topic topic2 = new Topic("Battling Imposter Syndrome");
        topicRepo.save(topic2);
        Post post2 = new Post("Ahmed","Test the Fear Away", topic2,"Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt",hashtag1);
        postRepo.save(post2);

        Topic topic3 = new Topic("Introductory Java");
        topicRepo.save(topic3);
        Post post3 = new Post("Husky", "Unit Tests and You",topic3,"Lorem ipsum dolor sit amet, consectetur", hashtag3, hashtag2);
        postRepo.save(post3);

        Topic topic4 = new Topic("Object Oriented Programming and You");
        topicRepo.save(topic4);
        Post post4 =new Post("Ferie","Object Oriented Programming and You",topic4,"lorem ipsum ",hashtag4,hashtag2);
        postRepo.save(post4);

    }

}
