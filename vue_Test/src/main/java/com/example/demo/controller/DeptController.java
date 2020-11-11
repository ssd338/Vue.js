package com.example.demo.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.DeptDao;
import com.example.demo.vo.DeptVo;
import com.google.gson.Gson;

@RestController
public class DeptController {

	@Autowired
	private DeptDao dao;
	
	@GetMapping("/listDept.do")
	public List<DeptVo> listDept(){
		return dao.findAll();
	}
	
	/*
	@RequestMapping("/hello.do")
	//@RequestParam은 int no가 온다고 할 경우 
	// 자체적으로 integer.parseint를 하는 데 만약 값이 안온다면
	// 문제가 발생 -> 값이 안온다면 0으로 하겠다는것
	public void hello(@RequestParam(value="no",defaultValue = "0") int no) {
		
	}*/
	
	//등록
	@PostMapping("/insertDept.do")
		//vo로 받으니까 문제가 생겨서 map으로 받음
		//@RequestParam은 원래 생략이 가능하나 있으면 널 값이 오거나 할때도 해결 가능이니 사용
	public String insertDept(@RequestParam Map map) {
		System.out.println(map);
		Gson gson = new Gson();
		String data = (String)map.keySet().iterator().next();
		DeptVo d = gson.fromJson(data, DeptVo.class);
		int re = dao.insert(d); 
		return ""+re;
	}
	
	//수정
	@PostMapping("/updateDept.do")
	public String updateDept(@RequestParam Map map) {
		System.out.println("데이터 수정");
		System.out.println(map);
		Gson gson = new Gson();
		String data = (String)map.keySet().iterator().next();
		DeptVo d = gson.fromJson(data, DeptVo.class);
		int re = dao.update(d); 
		return ""+re;
	}
	
	//삭제
	@PostMapping("/deleteDept.do")
	public String deleteDept(@RequestParam Map map) {
		System.out.println("데이터 수정");
		System.out.println(map);
		Gson gson = new Gson();
		String data = (String)map.keySet().iterator().next();
		DeptVo d = gson.fromJson(data, DeptVo.class);
		int re = dao.delete(d.getDeptno()); 
		return ""+re;
	}
}













