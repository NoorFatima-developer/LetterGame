package com.example.letterplay;

public class TestResult {
    private int id;
    private String questions;
    private String selections;
    private String correctAnswers;

    private int score;

    public TestResult(int id, String questions, String selections, String correctAnswers,  int score) {
        this.id = id;
        this.questions = questions;
        this.selections = selections;
        this.correctAnswers = correctAnswers;
        this.score = score;
    }

    public int getId() {
        return id;
    }

    public String getQuestions() {
        return questions;
    }

    public String getSelections() {
        return selections;
    }

    public String getCorrectAnswers() {
        return correctAnswers;
    }

    public int getScore() {
        return score;
    }
}

