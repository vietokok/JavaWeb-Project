/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author vietvkhe130358
 */
public class Course {

    int id;
    ArrayList<Subject> listSub = new ArrayList<>();
    ArrayList<Category> listCate = new ArrayList<>();
    String lesson;
    String description;
    String term;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ArrayList<Subject> getListSub() {
        return listSub;
    }

    public void setListSub(ArrayList<Subject> listSub) {
        this.listSub = listSub;
    }

    public ArrayList<Category> getListCate() {
        return listCate;
    }

    public void setListCate(ArrayList<Category> listCate) {
        this.listCate = listCate;
    }

    public String getLesson() {
        return lesson;
    }

    public void setLesson(String lesson) {
        this.lesson = lesson;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
    }

}
