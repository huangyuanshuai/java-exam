package cn.lynu.lyq.java_exam.dao;

import java.util.List;

import cn.lynu.lyq.java_exam.entity.Exam;
import cn.lynu.lyq.java_exam.entity.Student;
import cn.lynu.lyq.java_exam.entity.StudentExamScore;

public interface StudentExamScoreDao {
	
	List<StudentExamScore> findByStudent(Student s);
	List<StudentExamScore> findByExamPhase(String examPhase);
	List<StudentExamScore> findByStudentAndExamPhase(Student s, String examPhase);
	List<StudentExamScore> findByStudentAndExam(Student s, Exam e);
	
	StudentExamScore findById(int id);
	List<StudentExamScore> findAll();
	void save(StudentExamScore ses);
	void update(StudentExamScore ses);
	void delete(StudentExamScore ses);
}