package dao;

import dao.impl.AnswerDaoImpl;
import domain.Answer;
import domain.Homework;
import domain.User;

import java.util.List;

public interface AnswerDao {
    static AnswerDao getInstance(){ return AnswerDaoImpl.getInstance(); }

    int create(Answer answer);

    List<Answer> getByHomework(Homework homework);

    Answer getById(int id);

    Answer getByUserAndCourse(User user, Homework homework);

    void update(int id, Answer answer);
}
