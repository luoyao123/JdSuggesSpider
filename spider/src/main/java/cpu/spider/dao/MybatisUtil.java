package cpu.spider.dao;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import cpu.spider.domain.JdSuggest;

public class MybatisUtil {
	private final String statement = "cpu.spider.JDsuggest.";
	private static SqlSessionFactory sqlSessionFactory;
	static{
		try {
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(new FileReader(new File("E:\\ycsearch\\spider\\src\\main\\resources\\mybatis-config.xml")));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public SqlSessionFactory get(){
		return sqlSessionFactory;
	}
	
	public void insertInfo(List<JdSuggest> suggests){
		SqlSession sqlSession = get().openSession();
		sqlSession.insert(statement+"batchInsert", suggests);
		sqlSession.commit();
	}
	
	public JdSuggest findByid(long id){
		return get().openSession().selectOne(statement+"findbyid", id);
	}
}
