package cn.xidian.service.impl;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import cn.xidian.dao.ClazzCoursePointDao;
import cn.xidian.dao.ClazzDao;
import cn.xidian.dao.CompositionRulesDao;
import cn.xidian.dao.ContributeTargetDao;
import cn.xidian.dao.CourseDao;
import cn.xidian.dao.IsEvaluateDao;
import cn.xidian.dao.StudentCourseDao;
import cn.xidian.dao.StudentDao;
import cn.xidian.dao.TeacherCourseDao;
import cn.xidian.dao.TeacherDao;
import cn.xidian.dao.TeachingTargetDao;
import cn.xidian.dao.TeachingTargetEvaluateDao;
import cn.xidian.entity.AverClazzCoursePoint;
import cn.xidian.entity.AverTeachingTargetEvaluate;
import cn.xidian.entity.Clazz;
import cn.xidian.entity.ClazzCoursePoint;
import cn.xidian.entity.CompositionRules;
import cn.xidian.entity.ContributeTarget;
import cn.xidian.entity.Course;
import cn.xidian.entity.IsEvaluate;
import cn.xidian.entity.Student;
import cn.xidian.entity.StudentCourse;
import cn.xidian.entity.Teacher;
import cn.xidian.entity.TeacherCourse;
import cn.xidian.entity.TeachingTarget;
import cn.xidian.entity.TeachingTargetEvaluate;
import cn.xidian.exception.ClazzNotExistException;
import cn.xidian.exception.CourseNotExistException;
import cn.xidian.exception.CursRulesNotExistException;
import cn.xidian.exception.StudentCourseNotExistsException;
import cn.xidian.exception.TchingTargetNotExistException;
import cn.xidian.exception.TeacherNotExistException;
import cn.xidian.service.TeacherService;
import cn.xidian.utils.ServiceUtils;

@Component
public class TeacherServiceImpl implements TeacherService {
	
	private TeacherCourseDao teacherCourseDao;

	@Resource(name = "teacherCourseDaoImpl")
	public void setTeacherCourseDao(TeacherCourseDao teacherCourseDao) {
		this.teacherCourseDao = teacherCourseDao;
	}

	private StudentDao studentDao;

	@Resource(name = "studentDaoImpl")
	public void setStudentDao(StudentDao studentDao) {
		this.studentDao = studentDao;
	}

	private StudentCourseDao studentCourseDao;

	@Resource(name = "studentCourseDaoImpl")
	public void setStudentCourseDao(StudentCourseDao studentCourseDao) {
		this.studentCourseDao = studentCourseDao;
	}

	private CompositionRulesDao compositionRulesDao;

	@Resource(name = "compositionRulesDaoImpl")
	public void setCompositionRulesDao(CompositionRulesDao compositionRulesDao) {
		this.compositionRulesDao = compositionRulesDao;
	}

	private TeachingTargetDao teachingTargetDao;

	@Resource(name = "teachingTargetDaoImpl")
	public void setTeachingTargetDao(TeachingTargetDao teachingTargetDao) {
		this.teachingTargetDao = teachingTargetDao;
	}

	private TeachingTargetEvaluateDao teachingTargetEvaluateDao;

	@Resource(name = "teachingTargetEvaluateDaoImpl")
	public void setTeachingTargetEvaluateDao(
			TeachingTargetEvaluateDao teachingTargetEvaluateDao) {
		this.teachingTargetEvaluateDao = teachingTargetEvaluateDao;
	}

	private CourseDao courseDao;

	@Resource(name = "courseDaoImpl")
	public void setCourseDao(CourseDao courseDao) {
		this.courseDao = courseDao;
	}

	private ClazzCoursePointDao clazzCoursePointDao;

	@Resource(name = "clazzCoursePointDaoImpl")
	public void setClazzCoursePointDao(ClazzCoursePointDao clazzCoursePointDao) {
		this.clazzCoursePointDao = clazzCoursePointDao;
	}

	private ClazzDao clazzDao;

	@Resource(name = "clazzDaoImpl")
	public void setClazzDao(ClazzDao clazzDao) {
		this.clazzDao = clazzDao;
	}

	private ContributeTargetDao contributeTargetDao;

	@Resource(name = "contributeTargetDaoImpl")
	public void setContributeTargetDao(ContributeTargetDao contributeTargetDao) {
		this.contributeTargetDao = contributeTargetDao;
	}

	private IsEvaluateDao isevaluateDao;

	@Resource(name = "isEvaluateDaoImpl")
	public void setIsevaluateDao(IsEvaluateDao isevaluateDao) {
		this.isevaluateDao = isevaluateDao;
	}

	private TeacherDao teacherDao;

	@Resource(name = "teacherDaoImpl")
	public void setTeacherDao(TeacherDao teacherDao) {
		this.teacherDao = teacherDao;
	}

	@Override
	public boolean loginValidate(String tchrSchNum, String tchrPwd) {
		try {
			return teacherDao.findBySchNumAndPwd(tchrSchNum,
					ServiceUtils.md5(tchrPwd));
		} catch (NoSuchAlgorithmException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public Teacher selectInfBySchNum(String tchrSchNum) {
		return teacherDao.findBySchNum(tchrSchNum);
	}

	@Override
	public boolean updateInfBySchNum(Teacher teacher) {
		return teacherDao.updateByTeacher(teacher);
	}

	@Override
	public boolean modifyPassword(String tchrSchNum, String tchrPwd) {
		String passwordString = "";
		try {
			passwordString = ServiceUtils.md5(tchrPwd);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return teacherDao.modifyPassword(tchrSchNum, passwordString);
	}

	@Override
	public List<Course> selectTchCoursesByTchrNum(String tchrNum) {
		List<Course> courses = new LinkedList<Course>();
		List<TeacherCourse> tCourses = teacherCourseDao
				.findByNumAndTerm(tchrNum);
		for (int i = 0; i < tCourses.size(); i++) {
			courses.add(tCourses.get(i).getCourse());
		}
		return courses;
	}

	@Override
	public List<Course> selectChargeCoursesByTchrNum(String tchrNum) {
		return courseDao.selectTchChargeCursByTchrNum(tchrNum);
	}

	@Override
	public boolean caculateClazzTarget(String caculateClazzTarget, String gradeName, 
			String cursName, String claName, String tchrSchNum) {// 计算某班级某课程达成度
		// DecimalFormat df = new DecimalFormat("#.00");//
		// 用于格式化Double类型数据，保留两位小数

		// 找到班级和课程
		Course course = courseDao.findByNameAndTerm(cursName);
		if (course == null) {
			throw new CourseNotExistException("对不起，课程不存在！");
		}
		//判断所选是班级还是年级
		List<Clazz> clazzList = new ArrayList<Clazz>();
		List<StudentCourse> stuCurs = new LinkedList<StudentCourse>();
		Set<Student> students = new HashSet<Student>();

		if(caculateClazzTarget.equals("0")){
			clazzList.add(clazzDao.selectByName(claName));
			for(int x = 0; x < clazzList.size(); x++){
				Clazz clazz = clazzList.get(x);
				if (clazz == null) {
					throw new ClazzNotExistException("对不起，班级不存在！");
				}
			students = studentDao.findByClazz(clazzList.get(x).getClaId());
	
			Iterator<Student> it = students.iterator();
			while (it.hasNext()) {
				StudentCourse sc = new StudentCourse();
				Integer stuId = it.next().getStuId();
				sc = studentCourseDao.selectByCursIdAndStuId(course.getCursId(),
						stuId);
				if (sc != null) {
					stuCurs.add(sc);
				}
			}
			if(stuCurs.size()==0){
				throw new StudentCourseNotExistsException("请先上传成绩！");
			}
		}
		}	
		else{
			clazzList = clazzDao.selectByGrade(gradeName);
			for(int i=0;i<clazzList.size();i++){
				Set<Student> student = studentDao.findByClazz(clazzList.get(i).getClaId());
				students.addAll(student);
				Clazz clazz = clazzList.get(i);
				if (clazz == null) {
					throw new ClazzNotExistException("对不起，班级不存在！");
					
				}
			}
			//students = studentDao.findByClazz(clazzList.get(0).getClaId());
			Iterator<Student> it = students.iterator();
			while (it.hasNext()) {
				StudentCourse sc = new StudentCourse();
				Integer stuId = it.next().getStuId();
				sc = studentCourseDao.selectByCursIdAndStuId(course.getCursId(),
						stuId);
				if (sc != null) {
					stuCurs.add(sc);
				}
			}
			if(stuCurs.size()==0){
				throw new StudentCourseNotExistsException("请先上传成绩！");
			}
			
		}
		
		// 找到该课程的评分规则
		CompositionRules rules = compositionRulesDao.selectByCourse(course
				.getCursNum());
		if (rules == null) {
			throw new CursRulesNotExistException("未找到课程评分规则，请检查课程信息！");
		}

		Double midEvaPer = rules.getMidTermPer() / 100;// 期中成绩百分比
		Double finEvaPer = rules.getFinalExamPer() / 100;// 期末成绩百分比
		Double classEvaPer = rules.getClazzPer() / 100;// 课堂表现百分比
		Double workEvaPer = rules.getHomeworkResultPer() / 100;// 平时作业百分比
		Double expEvaPer = rules.getExpResultPer() / 100;// 实验成绩百分比

		Double classMidValueTotal = 0.0;
		Double classFinValueTotal = 0.0;
		Double classClazzValueTotal = 0.0;
		Double classWorkValueTotal = 0.0;
		Double classExpValueTotal = 0.0;

		// 计算班级总综合成绩
		for (int i = 0; i < stuCurs.size(); i++) {
			classMidValueTotal += stuCurs.get(i).getMidEvaValue();
			classFinValueTotal += stuCurs.get(i).getFinEvaValue();
			classClazzValueTotal += stuCurs.get(i).getClassEvaValue();
			classWorkValueTotal += stuCurs.get(i).getWorkEvaValue();
			classExpValueTotal += stuCurs.get(i).getExpEvaValue();
		}

		// 班级各分项值为各分项的平均值乘以所占百分比
		Double classMidValue = classMidValueTotal / stuCurs.size() * midEvaPer;// 班级期中成绩
		Double classFinValue = classFinValueTotal / stuCurs.size() * finEvaPer;// 班级期末成绩
		Double classClazzValue = classClazzValueTotal / stuCurs.size() * classEvaPer;// 班级课堂成绩
		Double classWorkValue = classWorkValueTotal / stuCurs.size() * workEvaPer;// 班级作业成绩
		Double classExpValue = classExpValueTotal / stuCurs.size() * expEvaPer;// 班级实验成绩

		List<TeachingTarget> tts = teachingTargetDao.selectByCursId(course.getCursId());
		if (tts.size() == 0) {
			throw new TchingTargetNotExistException("未找到课程目标，请检查课程信息！");
		}
		Double classMidTargetValue = 0.0;// 班级期中成绩目标值
		Double classFinTargetValue = 0.0;// 班级期末成绩目标值
		Double classClazzTargetValue = 0.0;// 班级课堂成绩目标值
		Double classWorkTargetValue = 0.0;// 班级作业成绩目标值
		Double classExpTargetValue = 0.0;// 班级实验成绩目标值

		for (int i = 0; i < tts.size(); i++) {
			classMidTargetValue += tts.get(i).getTchtargetMidTargetValue();
			classFinTargetValue += tts.get(i).getTchtargetFinTargetValue();
			classClazzTargetValue += tts.get(i).getTchtargetClassTargetValue();
			classWorkTargetValue += tts.get(i)
					.getTchtargetHomeworkTargetValue();
			classExpTargetValue += tts.get(i).getTchtargetExpTargetValue();
		}

		List<Double> b1s = new LinkedList<Double>();
		for (int i = 0; i < tts.size(); i++) {
			TeachingTargetEvaluate ttEvaluate = new TeachingTargetEvaluate();
			AverTeachingTargetEvaluate attEvaluate = new AverTeachingTargetEvaluate();
			Double classMidEvaValue = 0.0;// 班级期中成绩评价值
			Double classFinEvaValue = 0.0;// 班级期末成绩评价值
			Double classClazzEvaValue = 0.0;// 班级课堂成绩评价值
			Double classWorkEvaValue = 0.0;// 班级作业成绩评价值
			Double classExpEvaValue = 0.0;// 班级实验成绩评价值
			Double a1 = 0.0;
			Double b1 = 0.0;
			// 先分别计算每一行的值，再把每一行加到列表中

			if (classMidTargetValue == 0.0) {
				classMidEvaValue = 0.0;
			} else {
				classMidEvaValue = classMidValue
						* tts.get(i).getTchtargetMidTargetValue()
						/ classMidTargetValue;
			}
			if (classFinTargetValue == 0.0) {
				classFinEvaValue = 0.0;
			} else {
				classFinEvaValue = classFinValue
						* tts.get(i).getTchtargetFinTargetValue()
						/ classFinTargetValue;
			}
			if (classClazzTargetValue == 0.0) {
				classClazzEvaValue = 0.0;
			} else {
				classClazzEvaValue = classClazzValue
						* tts.get(i).getTchtargetClassTargetValue()
						/ classClazzTargetValue;
			}
			if (classWorkTargetValue == 0.0) {
				classWorkEvaValue = 0.0;
			} else {
				classWorkEvaValue = classWorkValue
						* tts.get(i).getTchtargetHomeworkTargetValue()
						/ classWorkTargetValue;
			}
			if (classExpTargetValue == 0.0) {
				classExpEvaValue = 0.0;
			} else {
				classExpEvaValue = classExpValue
						* tts.get(i).getTchtargetExpTargetValue()
						/ classExpTargetValue;
			}

			a1 = classMidEvaValue + classFinEvaValue + classClazzEvaValue
					+ classWorkEvaValue + classExpEvaValue;
			double denominator = (tts.get(i).getTchtargetMidTargetValue()
					+ tts.get(i).getTchtargetFinTargetValue()
					+ tts.get(i).getTchtargetClassTargetValue()
					+ tts.get(i).getTchtargetHomeworkTargetValue() + tts.get(i)
					.getTchtargetExpTargetValue());
			if (denominator == 0) {
				b1 = 0.0;
			} else {
				b1 = a1 / denominator;
			}
			if(caculateClazzTarget.equals("0")){
				ttEvaluate.setTchtargetMidEvaValue(classMidEvaValue);
				ttEvaluate.setTchtargetFinEvaValue(classFinEvaValue);
				ttEvaluate.setTchtargetClassEvaValue(classClazzEvaValue);
				ttEvaluate.setTchtargetWorkEvaValue(classWorkEvaValue);
				ttEvaluate.setTchtargetExpEvaValue(classExpEvaValue);
				ttEvaluate.setA1(a1);
				ttEvaluate.setB1(b1);
				b1s.add(b1);// 把b1存到一个list，一会计算a2、b2拿出来用
				ttEvaluate.setClazz(clazzList.get(0));
				ttEvaluate.setTeachingTarget(tts.get(i));
				TeachingTargetEvaluate tte = teachingTargetEvaluateDao
						.selectByClazzIdAndTargetId(clazzList.get(0).getClaId(), 
								tts.get(i).getTchTargetId());
				// 存在则更新，不存在则添加
				if (tte == null) {
					teachingTargetEvaluateDao.addTchingTargetEvaValue(ttEvaluate);// 写入数据库
				} else {
					teachingTargetEvaluateDao
							.updateTchingTargetEvaValue(ttEvaluate);
				}
				// 计算a2、b2
				/* 若已存在，则先删除。。。。。。。。。。。。待改进 */
				/*List<ClazzCoursePoint> existCursPoints = clazzCoursePointDao
						.selectByCursAndClazzId(course.getCursId(), clazz.getClaId());*/
				List<ClazzCoursePoint> existCursPoints = clazzCoursePointDao
						.selectByCursAndClazzId(course.getCursId(), clazzList.get(0).getClaId());
				if (existCursPoints.size() != 0) {
					for (int x = 0; x < existCursPoints.size(); x++) {
						clazzCoursePointDao.deleteById(existCursPoints.get(x));
					}
				}

			}
			else{
				attEvaluate.setTchtargetMidEvaValue(classMidEvaValue);
				attEvaluate.setTchtargetFinEvaValue(classFinEvaValue);
				attEvaluate.setTchtargetClassEvaValue(classClazzEvaValue);
				attEvaluate.setTchtargetWorkEvaValue(classWorkEvaValue);
				attEvaluate.setTchtargetExpEvaValue(classExpEvaValue);
				attEvaluate.setA1(a1);
				attEvaluate.setB1(b1);
				b1s.add(b1);// 把b1存到一个list，一会计算a2、b2拿出来用
				attEvaluate.setGrade(gradeName);
				attEvaluate.setTeachingTarget(tts.get(i));
				AverTeachingTargetEvaluate tte = teachingTargetEvaluateDao
						.selectByGradeAndTargetId(gradeName, tts.get(i).getTchTargetId());
				// 存在则更新，不存在则添加
				if (tte == null) {
					teachingTargetEvaluateDao.addTchingTargetEvaValue(attEvaluate);// 写入数据库
				} else {
					teachingTargetEvaluateDao
							.updateTchingTargetEvaValue(attEvaluate);
				}
				// 计算a2、b2
				/* 若已存在，则先删除。。。。。。。。。。。。待改进 */
				/*List<ClazzCoursePoint> existCursPoints = clazzCoursePointDao
						.selectByCursAndClazzId(course.getCursId(), clazz.getClaId());*/
				List<AverClazzCoursePoint> existCursPoints = clazzCoursePointDao
						.selectByCursAndGrade(course.getCursId(), gradeName);
				if (existCursPoints.size() != 0) {
					for (int x = 0; x < existCursPoints.size(); x++) {
						clazzCoursePointDao.deleteByAverId(existCursPoints.get(x));
					}
				}
				
		}
		}
		if(caculateClazzTarget.equals("0")){
			// 然后计算并写入
			List<ContributeTarget> cts = contributeTargetDao.selectByTarget(tts
					.get(0).getTchTargetId());
			int n = cts.size();
			if (n == 0) {
				throw new CursRulesNotExistException("评分规则不完整，请检查课程信息！");
			}
			Double[] a2 = new Double[n];
			Double[] b2 = new Double[n];
			Double[] targetTarValue = new Double[n];
			for (int x = 0; x < n; x++) {
				a2[x] = 0.0;
				b2[x] = 0.0;
				targetTarValue[x] = 0.0;
			}
			List<ContributeTarget> ct = new LinkedList<ContributeTarget>();
			for (int j = 0; j < tts.size(); j++) {
				ct = contributeTargetDao
						.selectByTarget(tts.get(j).getTchTargetId());
				for (int x = 0; x < ct.size(); x++) {
					Double ai = ct.get(x).getConTarValue() * b1s.get(j);
					targetTarValue[x] += ct.get(x).getConTarValue();
					a2[x] += ai;
				}
			}
			for (int x = 0; x < n; x++) {
				ClazzCoursePoint ccp = new ClazzCoursePoint();
				if (targetTarValue[x] == 0) {
					b2[x] = 0.0;
				} else {
					b2[x] = a2[x] / targetTarValue[x];
				}
				ccp.setTargetTarValue(targetTarValue[x]);
				ccp.setA2(a2[x]);
				ccp.setB2(b2[x]);
				ccp.setClazz(clazzList.get(0));
				ccp.setCourse(course);
				ccp.setIndPoint(cts.get(x).getIndicatorPoint());
				clazzCoursePointDao.add(ccp);
			}
			// 写入isevaluate表，有则update,无则insert
			Integer cursId = course.getCursId();
			//写入claId
			Integer claId = clazzList.get(0).getClaId();
			Teacher tchrTemp = teacherDao.findBySchNum(tchrSchNum);
			if (tchrTemp == null) {
				throw new TeacherNotExistException("工号为" + tchrSchNum + "的老师不存在！");
			}
			IsEvaluate isevalTemp = isevaluateDao.findByCursAndClazz(cursId, claId);
			if (isevalTemp != null) {
				isevalTemp.setTeacher(tchrTemp);
				isevalTemp.setEvaDate(new Date());
				isevaluateDao.updateIsevaluate(isevalTemp);
			} else {
				isevalTemp = new IsEvaluate();
				isevalTemp.setCourse(course);
				isevalTemp.setClazz(clazzList.get(0));
				isevalTemp.setTeacher(tchrTemp);
				isevalTemp.setEvaDate(new Date());
				isevaluateDao.addIsevaluate(isevalTemp);
			}
		}
		else{
			// 然后计算并写入
			List<ContributeTarget> cts = contributeTargetDao.selectByTarget(tts
					.get(0).getTchTargetId());
			int n = cts.size();
			if (n == 0) {
				throw new CursRulesNotExistException("评分规则不完整，请检查课程信息！");
			}
			Double[] a2 = new Double[n];
			Double[] b2 = new Double[n];
			Double[] targetTarValue = new Double[n];
			for (int x = 0; x < n; x++) {
				a2[x] = 0.0;
				b2[x] = 0.0;
				targetTarValue[x] = 0.0;
			}
			List<ContributeTarget> ct = new LinkedList<ContributeTarget>();
			for (int j = 0; j < tts.size(); j++) {
				ct = contributeTargetDao
						.selectByTarget(tts.get(j).getTchTargetId());
				for (int x = 0; x < ct.size(); x++) {
					Double ai = ct.get(x).getConTarValue() * b1s.get(j);
					targetTarValue[x] += ct.get(x).getConTarValue();
					a2[x] += ai;
				}
			}
			for (int x = 0; x < n; x++) {
				AverClazzCoursePoint accp = new AverClazzCoursePoint();
				if (targetTarValue[x] == 0) {
					b2[x] = 0.0;
				} else {
					b2[x] = a2[x] / targetTarValue[x];
				}
				accp.setTargetTarValue(targetTarValue[x]);
				accp.setA2(a2[x]);
				accp.setB2(b2[x]);
				accp.setGrade(gradeName);
				accp.setCourse(course);
				accp.setIndPoint(cts.get(x).getIndicatorPoint());
				clazzCoursePointDao.add(accp);
			}
		}
	
	return true;
}
}


