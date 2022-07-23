package ru.work.forum.service;

import org.springframework.stereotype.Service;
import ru.work.forum.model.Answer;
import ru.work.forum.persistence.AnswerStore;

import java.util.List;

@Service
public class AnswerService {
    private final AnswerStore answerStore;

    public AnswerService(AnswerStore answerStore) {
        this.answerStore = answerStore;
    }

    public void save(Answer answer){
        answerStore.save(answer);
    }

    public List<Answer> findAll(){
        return answerStore.findAll();
    }
}
