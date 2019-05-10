package com.example.errorcorrection;

public class Word {
    private int Id;
    private String right, wrong;

    public Word() {
    }

    public Word(int id, String right, String wrong) {
        Id = id;
        this.right = right;
        this.wrong = wrong;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getRight() {
        return right;
    }

    public void setRight(String right) {
        this.right = right;
    }

    public String getWrong() {
        return wrong;
    }

    public void setWrong(String wrong) {
        this.wrong = wrong;
    }
}
