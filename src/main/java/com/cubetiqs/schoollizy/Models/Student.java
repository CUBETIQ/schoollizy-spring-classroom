package com.cubetiqs.schoollizy.Models;

public class Student {
    public Student(int Id, String Name, double Score) {
        this._id = Id;
        this._name = Name;
        this._score = Score;
    }

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public String get_name() {
        return _name;
    }

    public void set_name(String _name) {
        this._name = _name;
    }

    public double get_score() {
        return _score;
    }

    public void set_score(double _score) {
        this._score = _score;
    }

    private int _id;
    private String _name;
    private double _score;
}
