package fr.emn.examination.model;

import fr.emn.examination.model.examen.Examen.Enonce.Exercice.Question;

public abstract class QuestionStudent extends Question {

    /**
     * 
     */
    private static final long serialVersionUID = 4567682866855167718L;

    public abstract double evaluer();

}
