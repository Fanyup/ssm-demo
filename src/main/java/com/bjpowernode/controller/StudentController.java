package com.bjpowernode.controller;

import com.bjpowernode.domain.Student;
import com.bjpowernode.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;

//别忘了加controller注解，否则它只是一个普通类
@Controller
//合并前缀
@RequestMapping("/student")
public class StudentController {
    @Resource
    //声明service,自动注入创建接口实现类对象
    private StudentService service;
    //注册学生
    @RequestMapping("/addStudent.do")
    public ModelAndView addStudent(Student student){
        ModelAndView mv = new ModelAndView();
        String tips = "注册失败";
        //调用service处理student
        int nums = service.addStudent(student);
        if (nums >0) {
            //注册成功
            tips = "学生：" + student.getName() +"注册成功";
        }
        //指定结果页面：添加数据+视图
        mv.addObject("tips",tips);
        mv.setViewName("result");//逻辑名称
        return mv;
    }

    //处理查询，响应ajax
    @RequestMapping("/queryStudent.do")
    //不加就不是处理器而是普通类了
    @ResponseBody
    public List<Student> queryStudent(){
        //参数检查，简单的数据处理
        List<Student> students = service.findStudent();
        //该结果会被框架转成Json的数组
        return students;
    }
}
