package Prelim.Mod2.Exercise1;

    // Example of a Reference Class
    public class Student {
        private String firstName = "";
        private String midName = "";
        private String lastName = "";
        private int age;
        private double gPA;

        /**
         * Constructs a student named Adel Man Tamano, 39 years old and with 95.0 grade point average.
         */

        public Student() {
            firstName = "Adel";
            midName = "Man";
            lastName = "Tamano";
            age = 39;
            gPA = 95.0;
        }

        /**
         * Constructs a student with first name f, middle name m, last name
         l, age a and grade point average gpa.
         */

        public Student(String f, String m, String l, int a, double gpa) {
            firstName = f;
            midName = m;
            lastName = l;
            age = a;
            gPA = gpa;
        }

        /**
         * Returns the first name of the student
         */

        public String getFirstName() {
            return firstName;
        }

        /**
         * Returns the last name of the student
         */

        public String getLastName() {
            return lastName;
        }

        /**
         * Returns the middle name of the student
         */

        public String getMidName() {
            return midName;
        }

        /**
         * Returns the age of the student
         */

        public int getAge() {
            return age;
        }

        /**
         * Returns the grade point average of the student
         */

        public double getGPA() {
            return gPA;
        }

        /**
         * Sets the first name of the student to fName
         */

        public void setFirstName(String fName) {

            firstName = fName;
        }

        /**
         * Sets the last name of the student to lName
         */

        public void setLastName(String lName) {

            lastName = lName;
        }

        /**
         * Sets the middle name of the student to mName
         */

        public void setMidName(String mName) {

            midName = mName;
        }

        /**
         * Sets the age of the student to a
         */

        public void setAge(int a) {
            age = a;
        }

        /**
         * Sets the grade point average of a student to g
         */

        public void setGPA(double g) {
            gPA = g;
        }

        /**
         * Returns a string showing the name, age and grade point average of
         a student
         */

        public String toString() {
            return (firstName + " " + midName + " " + lastName + "," + age + "," + gPA);
        }

        /**
         * Returns true if this student is the same as student other else it
         returns false.
         **/

        public boolean equals(Student other) {
            boolean r = false;
            r = (firstName.equalsIgnoreCase(other.getFirstName())); // improve this part
            r = (midName.equalsIgnoreCase(other.getMidName()));
            r = (lastName.equalsIgnoreCase(other.getLastName()));
            r = (age != other.getAge());
            r = (gPA != other.getGPA());
            return r;
        }
    }
