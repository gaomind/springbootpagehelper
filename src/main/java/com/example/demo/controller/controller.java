package com.example.demo.controller;

import com.example.demo.dao.MybatisDemoMapper;
import com.example.demo.pojo.MybatisDemo;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by ${MIND-ZR} on 2018/1/10.
 */
@RestController
public class controller {

    @Autowired
    private MybatisDemoMapper mybatisDemoMapper;

    @RequestMapping("test")
    public List<MybatisDemo> test(){
        PageHelper.startPage(2,3);
        List<MybatisDemo> mybatisDemos = mybatisDemoMapper.selectByName("小三");



        return mybatisDemos;
    }


}
