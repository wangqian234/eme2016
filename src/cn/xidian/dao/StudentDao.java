package cn.xidian.dao;

import java.util.List;
import java.util.Set;
import cn.xidian.entity.StuEvaluateResult;
import cn.xidian.entity.Student;
import cn.xidian.entity.StudentCourse;

public interface StudentDao {

	boolean findBySchNumAndPwd(String stuSchNum, String stuPwd);

	Student findBySchNum(String stuSchNum);

	Student findByStuId(Integer stuId);

	boolean updateByStudent(Student student);

	boolean updateGoal(Student student);

	boolean addByAdmin(Student student);

	boolean deleteByAdmin(Student student);

	boolean updateByAdmin(Student student);

	Set<Student> findByName(String name);

	Set<Student> findByClazz(Integer clazzId);

	boolean deleteByAdmin(Integer id);

	List<Student> selectAllStus();

	boolean modifyPassword(String num, String pwd);

	List<StudentCourse> selectStuAllGradesById(Integer id);

	List<StudentCourse> findStuCoursesByStuId(Integer id, Integer begin, Integer limit);

	List<StuEvaluateResult> selectStuEvaluateResults(Integer stuId, String schoolYear);

	StudentCourse getEvaPer(Integer stuCursId);

}