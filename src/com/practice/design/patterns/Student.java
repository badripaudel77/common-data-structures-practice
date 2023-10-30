package com.practice.design.patterns;

/**
 * This is to illustrate Builder design Pattern
 */
public class Student {
    private int id;
    private int rollNo;
    private String fullname;
    private String address;

    // mandatory field constructor
    private Student(int id, int rollNo, String fullname) {
        this.id = id;
        this.rollNo = rollNo;
        this.fullname = fullname;
    }

    // Implement getters
    public int getId() {
        return id;
    }

    public int getRollNo() {
        return rollNo;
    }

    public String getFullname() {
        return fullname;
    }

    public String getAddress() {
        return address;
    }

    /**
     * Static inner class that has the same field as class above
     */
    public static class StudentBuilder {
        private int id;
        private int rollNo; // mandatory
        private String fullname; // mandatory
        private String address;

        // set mandatory field upon constructor initilaization.
        public StudentBuilder(int rollNo, String fullname) {
            this.rollNo = rollNo;
            this.fullname = fullname;
        }

        public StudentBuilder setId(int id) {
            if(id < 1) {
                throw new IllegalStateException("ID must be provided.");
            }
            this.id = id;
            return this;
        }

        public StudentBuilder setRollNo(int rollNo) {
            this.rollNo = rollNo;
            return this;
        }

        public StudentBuilder setFullname(String fullname) {
            this.fullname = fullname;
            return this;
        }

        public StudentBuilder setAddress(String address) {
            this.address = address;
            return this;
        }

        public Student build() {
            // perform some validation
            if(rollNo < 1 || fullname == null) {
                throw new IllegalStateException("Roll Number and Fullname can't be empty");
            }
            return new Student(id, rollNo, fullname);
        }
    }
}

class StudentApplication {
    // Build student object using builder pattern.
    public static void main(String[] args) {
        Student student = new Student.StudentBuilder(10_200, "Badri Paudel")
                .build();
        System.out.println("Student details : \n" + "ID = " + student.getId() + "\n"
                + "Roll number  = " + student.getRollNo() + "\n"
                + "Full name = " + student.getFullname() + "\n"
                + "Address = " + student.getAddress());

    }
}
