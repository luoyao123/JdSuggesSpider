package testcase;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import cpu.spider.dao.MybatisUtil;
import cpu.spider.domain.JdSuggest;

public class TestMybatis {
	@Test
	public void test(){
		JdSuggest jSuggest1 = new JdSuggest();
		jSuggest1.setKey("test1");
		jSuggest1.setData("test1");
		JdSuggest jSuggest2 = new JdSuggest();
		jSuggest2.setKey("test2");
		jSuggest2.setData("test2");
		List<JdSuggest> lists = new ArrayList<JdSuggest>();
		lists.add(jSuggest1);
		lists.add(jSuggest2);
		MybatisUtil mybatisUtil = new MybatisUtil();
		mybatisUtil.insertInfo(lists);
	}
	
	@Test
	public void test1(){
		MybatisUtil mybatisUtil = new MybatisUtil();
		System.out.println(mybatisUtil.findByid(5).toString());
	}
}
