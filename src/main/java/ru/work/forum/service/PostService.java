package ru.work.forum.service;

import org.springframework.stereotype.Service;
import ru.work.forum.model.Post;
import ru.work.forum.persistence.PostStore;

import java.util.Collection;
import java.util.List;

@Service
public class PostService {

    private final PostStore postStore;

    public PostService(PostStore postStore) {
        this.postStore = postStore;
    }

    public void save(Post post){
        postStore.save(post);
    }

    public List<Post> findAll(){
        return postStore.findAll();
    }

    public Post findById(int id){
        return postStore.findById(id);
    }

    public void update(Post post){
        postStore.update(post);
    }

}
