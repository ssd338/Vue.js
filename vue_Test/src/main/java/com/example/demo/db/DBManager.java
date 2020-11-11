package com.example.demo.db;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.example.demo.vo.DeptVo;


public class DBManager {
	
	public static SqlSessionFactory sqlSessionFactory;
	
	static {
		String resource = "com/example/demo/db/sqlMapConfig.xml";
		try {
		InputStream inputStream = Resources.getResourceAsStream(resource);		
		sqlSessionFactory =
		  new SqlSessionFactoryBuilder().build(inputStream);
		}catch (Exception e) {
			System.out.print("예외발생:"+e.getMessage());
		}
	}
	
	public static List<DeptVo> findAll(){
		List<DeptVo> list = null;
		SqlSession session = sqlSessionFactory.openSession();
		list = session.selectList("dept.selectAll");
		session.close();
		return list;
	}
	
	public static int insert(DeptVo d) {
		int re = -1;
		SqlSession session = sqlSessionFactory.openSession(true);
		re = session.insert("dept.insert", d);
		session.close();
		return re;
	}

	public static int update(DeptVo d) {
		int re = -1;
		SqlSession session = sqlSessionFactory.openSession(true);
		re = session.update("dept.update", d);
		session.close();
		return re;
	}

	public static int delete(int deptno) {
		int re = -1;
		SqlSession session = sqlSessionFactory.openSession(true);
		re = session.update("dept.delete", deptno);
		session.close();
		return re;
	}
	
	
	
	
	
}




















