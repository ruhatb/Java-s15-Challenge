package com.Workintech.Library.Students;

public class Students {
    private int studentNo;
    private String name;
    private StudentType studentType;

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

    public String whoGet() {
        return name + " (" + studentType + ")";
    }
}
