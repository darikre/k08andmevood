import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
 
//Student Class
 
class Student
{
    String name;
     
    int marks;
     
    public Student(String name, int marks) 
    {
        this.name = name;
         
        this.marks = marks;
    }
}
 
//nameCompare Class to compare the names
 
class nameCompare implements Comparator<Student>
{
    @Override
    public int compare(Student s1, Student s2)
    {
        return s1.name.compareTo(s2.name);
    }
}
 
//marksCompare Class to compare the marks
 
class marksCompare implements Comparator<Student>
{
    @Override
    public int compare(Student s1, Student s2)
    {
        return s2.marks - s1.marks;
    }
}
 
public class SortTextFile
{
    public static void main(String[] args)throws IOException
    {
        //Creating BufferedReader object to read the input text file
         
        BufferedReader reader = new BufferedReader(new FileReader("input.txt"));
         
        //Creating ArrayList to hold Student objects
         
        ArrayList<Student> studentRecords = new ArrayList<Student>();
         
        //Reading Student records one by one
         
        String currentLine = reader.readLine();
         
        while (currentLine != null)
        {
            String[] studentDetail = currentLine.split(" ");
             
            String name = studentDetail[0];
             
            int marks = Integer.valueOf(studentDetail[1]);
         
            //Creating Student object for every student record and adding it to ArrayList
             
            studentRecords.add(new Student(name, marks));
             
            currentLine = reader.readLine();
        }
         
        //Sorting ArrayList studentRecords based on marks
         
        Collections.sort(studentRecords, new marksCompare());
         
        //Creating BufferedWriter object to write into output text file
         
        BufferedWriter writer1 = new BufferedWriter(new FileWriter("outputByMarks.txt"));
         
        //Writing every studentRecords into output text file
         
        for (Student student : studentRecords) 
        {
            writer1.write(student.name);
             
            writer1.write(" "+student.marks);
             
            writer1.newLine();
        }
         
		 
		 //Sorting ArrayList studentRecords based on names
         
        Collections.sort(studentRecords,  new nameCompare());
         
        //Creating BufferedWriter object to write into output text file
         
        BufferedWriter writer2 = new BufferedWriter(new FileWriter("outputByName.txt"));
         
        //Writing every studentRecords into output2 text file
         
        for (Student student : studentRecords) 
        {
            writer2.write(student.name);
             
            writer2.write(" "+student.marks);
             
            writer2.newLine();
        }
        //Closing the resources
         
        reader.close();
         
        writer1.close();
		writer2.close();
    }
}
