package bg.softuni.models;

import bg.softuni.exceptions.DuplicateEntryInStructureException;
import bg.softuni.exceptions.InvalidStringException;
import bg.softuni.staticData.ExceptionMessages;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public class Student {
    private String userName;
    private LinkedHashMap<String, Course> enrolledCourses;
    private LinkedHashMap<String,Double> marksByCourseName;

    public Student(String userName) {
        setUserName(userName);
        this.enrolledCourses = new LinkedHashMap<>();
        this.marksByCourseName = new LinkedHashMap<>();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        if (userName == null || userName.trim().length() == 0){
            throw new InvalidStringException();
        }
        this.userName = userName;
    }

    public Map<String, Course> getEnrolledCourses() {
        return Collections.unmodifiableMap(this.enrolledCourses);
    }

    public Map<String, Double> getMarksByCourseName() {
        return Collections.unmodifiableMap(this.marksByCourseName);
    }

    public void enrollInCourse(Course course){
        if(this.enrolledCourses.containsKey(course.getName())){
            throw new DuplicateEntryInStructureException(getUserName(), course.getName());
        }

        this.enrolledCourses.put(course.getName(),course);
    }
    public void setMarkOnCourse(String courseName, int[] scores){
        if(!this.enrolledCourses.containsKey(courseName)){
            throw new  IllegalArgumentException(ExceptionMessages.NOT_ENROLLED_IN_COURSE);
        }

        if (scores.length> Course.NUMBER_OF_TASKS_ON_EXAM){
            throw new  IllegalArgumentException(ExceptionMessages.INVALID_NUMBER_OF_SCORES);
        }

        double mark = calculateMark(scores);
        this.marksByCourseName.put(courseName,mark);
    }

    private double calculateMark(int[] scores){
        double percantageOfSolvedExam = Arrays.stream(scores).sum()/
                (double) (Course.NUMBER_OF_TASKS_ON_EXAM* Course.MAX_SCORE_ON_EXAM_TASK);
        double mark = percantageOfSolvedExam*4+2;
        return mark;
    }
}



























