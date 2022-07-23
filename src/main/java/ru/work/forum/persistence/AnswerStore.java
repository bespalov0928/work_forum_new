package ru.work.forum.persistence;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import ru.work.forum.model.Answer;
import ru.work.forum.model.Post;

import java.util.List;

@Repository
public class AnswerStore implements Store {

    private final SessionFactory sessionFactory;

    public AnswerStore(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public List<Answer> findAll() {
        return tx(session -> {
            List<Answer> rsl = session.createQuery("select a from Answer a").list();
            return rsl;
        }, sessionFactory);
    }

    public Answer findById(int id) {
        return (Answer) tx(session -> session.createQuery("from Answer where id=:id")
                .setParameter("id", id)
                .uniqueResult(), sessionFactory);
    }

    public Answer save(Answer answer) {
        return tx(session -> {
            session.save(answer);
            return answer;
        }, sessionFactory);
    }


}
