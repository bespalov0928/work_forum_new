package ru.work.forum.persistence;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import ru.work.forum.model.Post;

import java.util.List;
import java.util.Optional;

@Repository
public class PostStore implements Store {
    private final SessionFactory sessionFactory;

    public PostStore(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public List<Post> findAll() {
        return tx(session -> {
            List<Post> rsl = session.createQuery("select p from Post p").list();
            return rsl;
        }, sessionFactory);
    }

    public Post findById(int id) {
//        return (Post) tx(session -> session.createQuery("from Post as p left join fetch Answer where p.id=:id ")
        return (Post) tx(session -> session.createQuery("select distinct p from Post p left join fetch p.answer a where p.id=:id ")
                .setParameter("id", id)
                .uniqueResult(), sessionFactory);
    }

    public Post save(Post post) {
        return tx(session -> {
            session.save(post);
            return post;
        }, sessionFactory);
    }

   public Post update(Post post) {
        return tx(session -> {
            session.update(post);
            return post;
        }, sessionFactory);
    }

}
