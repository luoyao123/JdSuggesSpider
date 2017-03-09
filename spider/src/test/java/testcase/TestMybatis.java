package testcase;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import cpu.spider.dao.MybatisUtil;
import cpu.spider.domain.JdSuggest;
import cpu.spider.domain.JdSuggestExtend;

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
		JdSuggest jSuggest2=mybatisUtil.findByid(1);
		if(jSuggest2.getData().replace(" ", "x") == ""){
			System.out.println("空");
		}
		System.out.println(mybatisUtil.findByid(1).toString());
	}
	
	@Test
	public void test2(){
		
		System.out.println();
	}
}
