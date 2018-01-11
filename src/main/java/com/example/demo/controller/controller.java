package com.example.demo.controller;

import com.example.demo.dao.MybatisDemoMapper;
import com.example.demo.pojo.MybatisDemo;
import com.github.pagehelper.PageHelper;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

        RowBounds rowBounds=new RowBounds(2,3);
        List<MybatisDemo> mybatisDemos1=mybatisDemoMapper.selectByNameByLogic(rowBounds,"小三");

        Map<String,Object> map=new HashMap<String ,Object>();
        map.put("start",1);
        map.put("pagesize",2);
        map.put("name","小三");

        List<MybatisDemo> mybatisDemos2=mybatisDemoMapper.selectByNameByMysql(map);
        System.out.println(mybatisDemos2.get(1));
        return mybatisDemos2;


    }


}
