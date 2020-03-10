/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Date;
import java.util.ArrayList;

/**
 *
 * @author vietvkhe130358
 */
public class Classroom {

    int id;
    String name;
    Date start_date;
    Date end_date;
    String price;
    ArrayList<Teacher> listTeach = new ArrayList<>();
    ArrayList<Course> listCourse = new ArrayList<>();
    ArrayList<Center> listCenter = new ArrayList<>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getStart_date() {
        return start_date;
    }

    public void setStart_date(Date start_date) {
        this.start_date = start_date;
    }

    public Date getEnd_date() {
        return end_date;
    }

    public void setEnd_date(Date end_date) {
        this.end_date = end_date;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public ArrayList<Teacher> getListTeach() {
        return listTeach;
    }

    public void setListTeach(ArrayList<Teacher> listTeach) {
        this.listTeach = listTeach;
    }

    public ArrayList<Course> getListCourse() {
        return listCourse;
    }

    public void setListCourse(ArrayList<Course> listCourse) {
        this.listCourse = listCourse;
    }

    public ArrayList<Center> getListCenter() {
        return listCenter;
    }

    public void setListCenter(ArrayList<Center> listCenter) {
        this.listCenter = listCenter;
    }

}
