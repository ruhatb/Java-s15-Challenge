package com.Workintech.Library.Students;

import com.Workintech.Library.Books.Books;

import java.util.ArrayList;
import java.util.List;

public class Students implements StudentAble {
    private int studentNo;
    private String name;
    private StudentType studentType;

    private List<Books> books;

    public Students(int studentNo, String name, StudentType studentType) {
        this.studentNo = studentNo;
        this.name = name;
        this.studentType = studentType;
    }

    public int getStudentNo() {
        return studentNo;
    }

    public String getName() {
        return name;
    }

    public StudentType getStudentType() {
        return studentType;
    }

    public double calculateRentalFee(double baseFee) {
        return (studentType == StudentType.MASTER) ? 1.5 * baseFee : baseFee;
    }


}
