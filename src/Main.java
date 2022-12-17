import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Teacher ayse = new Teacher();
        ayse.Teacher("Ayşe",123,"Matematik");
        Teacher fatma = new Teacher();
        fatma.Teacher("Fatma",555,"Fizik");
        Teacher ilkay = new Teacher();
        ilkay.Teacher("ilkay",888,"Kimya");
        Course mat = new Course();
        mat.Course("Matematik",111,"mat",0);
        mat.addTeacher("Matematik",ayse);
        Course fiz = new Course();
        fiz.Course("Fizik",222,"fiz",0);
        fiz.addTeacher("Fizik",fatma);
        Course kim = new Course();
        kim.Course("Kimya",333,"kim",0);
        fiz.addTeacher("Kimya",ilkay);
        //öğrenci 1
        Student bebeAli = new Student();
        bebeAli.Student("Ali",1999,5,mat,fiz,kim);
        System.out.print("Alinin matematik notunu giriniz");
        int alisnote = input.nextInt();
        bebeAli.addBulkExamNote(alisnote,mat);
        bebeAli.addBulkExamNote(75,fiz);
        bebeAli.addBulkExamNote(85,kim);
        bebeAli.addBulkSozluNote(55,mat);
        bebeAli.addBulkSozluNote(55,fiz);
        bebeAli.addBulkSozluNote(55,kim);
        bebeAli.calcCourseAverage(mat);
        bebeAli.calcCourseAverage(fiz);
        bebeAli.calcCourseAverage(kim);
        bebeAli.calcAvarage();
        bebeAli.isPass();
        System.out.println(bebeAli.name + " "+(bebeAli.isPass?"Geçti":"Kaldı"));
        //öğrenci2
        Student bebeAyse = new Student();
        bebeAyse.Student("Ayşe",2000,5,mat,fiz,kim);
        bebeAyse.addBulkExamNote(15,mat);
        bebeAyse.addBulkExamNote(25,fiz);
        bebeAyse.addBulkExamNote(40,kim);
        bebeAyse.addBulkSozluNote(55,mat);
        bebeAyse.addBulkSozluNote(55,fiz);
        bebeAyse.addBulkSozluNote(55,kim);
        bebeAyse.calcCourseAverage(mat);
        bebeAyse.calcCourseAverage(fiz);
        bebeAyse.calcCourseAverage(kim);
        bebeAyse.calcAvarage();
        bebeAyse.isPass();
        System.out.println(bebeAyse.name+" "+(bebeAyse.isPass?"Geçti":"Kaldı"));
        //öğrenci3
        Student bebeHasan = new Student();
        bebeHasan.Student("Hasan",2022,5,mat,fiz,kim);
        bebeHasan.addBulkExamNote(45,mat);
        bebeHasan.addBulkExamNote(45,fiz);
        bebeHasan.addBulkExamNote(45,kim);
        bebeHasan.addBulkSozluNote(55,mat);
        bebeHasan.addBulkSozluNote(55,fiz);
        bebeHasan.addBulkSozluNote(55,kim);
        bebeHasan.calcCourseAverage(mat);
        bebeHasan.calcCourseAverage(fiz);
        bebeHasan.calcCourseAverage(kim);
        bebeHasan.calcAvarage();
        bebeHasan.isPass();
        System.out.println(bebeHasan.name + " "+(bebeHasan.isPass?"Geçti":"Kaldı"));
    }
}
 class Course{
    String name;
    int code;
    String prefix;
    int note;
    int sozlu;
    double averagenote ;
    Teacher Teacher;
    void Course(String name,int code,String prefix,int note ){
        this.name=name;
        this.code=code;
        this.prefix = prefix;
        this.note = note;


    }
    void addTeacher(String name,Teacher Teacher){
        if (name == Teacher.branch){
            this.Teacher=Teacher;
        }else{
            System.out.println(Teacher.name + "Bu dersin hocası değildir");
        }
    }
    void printTeacher(){
        if(Teacher != null){
            System.out.print(this.name + " dersinin hocası " + Teacher.name);
        }else{
            System.out.print(this.name + " dersinin hocası yoktur.");
        }
    }

};
class Teacher{
  String name;
  int mpno;
  String branch;

  void Teacher(String name,int mpno,String branch){
      this.name=name;
      this.mpno = mpno;
      this.branch=branch;
  }
};
class Student{
    String name;
    int stuNo;
    int clases;
    Course course1;
    Course course2;
    Course course3;
    double avarage;
    boolean isPass;
    void  Student(String name,int stuNo,int clases,Course course1,Course course2,Course course3){
        this.name = name;
        this.stuNo = stuNo;
        this.clases = clases;
        this.course1=course1;
        this.course2=course2;
        this.course3 = course3;
    }
    void addBulkExamNote(int note,Course course){
            course.note = note;
    };
    void addBulkSozluNote(int sNote,Course course){
        course.sozlu = sNote;
    };
    void calcCourseAverage(Course course){
        if(course.prefix == "mat"){
            course.averagenote = (course.note*80)/100 + (course.sozlu*20)/100;
        }else if(course.prefix == "fiz"){
            course.averagenote = (course.note*70)/100 + (course.sozlu*30)/100;
        } else if (course.prefix =="kim") {
            course.averagenote = (course.note*60)/100 + (course.sozlu*40)/100;
        }
    }
    void calcAvarage(){
        if (course1.note ==0 || course2.note ==0 || course3.note ==0){
            System.out.println("Hatalı veya eksik girilen not mevcut");
        }else{
            this.avarage = (course1.averagenote+course2.averagenote+course3.averagenote)/3;
        }
    }
    void isPass(){
        if (this.avarage>=45){
            this.isPass=true;
        }else{
            this.isPass = false;
        }
    }
}
