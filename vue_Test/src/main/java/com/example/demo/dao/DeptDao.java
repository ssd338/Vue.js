package com.example.demo.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.db.DBManager;
import com.example.demo.vo.DeptVo;

@Repository
public class DeptDao {
	
	public List<DeptVo> findAll(){
		return DBManager.findAll();
	}
	
	public int insert(DeptVo d) {
		return DBManager.insert(d);
	}

	public int update(DeptVo d) {
		return DBManager.update(d);
	}

	public int delete(int deptno) {
		return DBManager.delete(deptno);
	}
}
