package com.bjpowernode.service.impl;

import com.bjpowernode.dao.StudentDao;
import com.bjpowernode.domain.Student;
import com.bjpowernode.service.StudentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

//用注解快速创建Service对象
@Service
public class StudentServiceImpl implements StudentService {

    //引用类型【自动注入】@Autowired,@Resource等
    //就是对象类型属性注入，这样就能赋给service实现类调用的对象属性了
    //声明dao实现类对象
    @Resource
    //该接口的创建已在刚刚applicationContext.xml中bean声明创建了
    private StudentDao studentDao;

    @Override
    public int addStudent(Student student) {
        //调用dao实现类对象的方法
        int nums = studentDao.insertStudent(student);
        return nums;
    }

    @Override
    public List<Student> findStudent() {

        return studentDao.selectStudents();
    }
}
