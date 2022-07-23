package ru.work.forum.persistence;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import ru.work.forum.model.User;

@Repository
public class UserStore implements Store {

    private final SessionFactory sf;

    public UserStore(SessionFactory sf) {
        this.sf = sf;
    }

    public User save(User user) {
        return tx(session -> {
            session.save(user);
            return user;
        }, sf);
    }

    public User findById(int id) {
        return (User) tx(session -> session.createQuery("select u from User u where id=:id")
                .setParameter("id", id)
                .uniqueResult(), sf);
    }

    public User findByUsername(String username) {
        return (User) tx(session -> session.createQuery("select u from User u where username=:name")
                .setParameter("name", username)
                .uniqueResult(), sf);
    }


}
