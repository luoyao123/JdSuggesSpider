package cup.spider.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;



import cpu.spider.dao.MybatisUtil;
import cpu.spider.domain.JdSuggest;


public class Task {
	private static final MybatisUtil mu= new MybatisUtil();
	private Map<Integer, List<String>> map = new HashMap<Integer, List<String>>();
	private int num;
	private String driverPath;
	private String search;
	private String url;
	private String input;
	
	/**
	 * 
	 *
	 * @param path 字典的位置
	 * @param num 启动的线程数
	 */
	public Task(String path,int num,String driverPath,String input,String search,String url){
		try {
			List<String> all = Files.readAllLines(Paths.get(path));
			this.num = num;
			this.driverPath = driverPath;
			this.search = search;
			this.url = url;
			this.input = input;
			fullResollution(all);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 
	 * <p>说明：
	 * <li></li>
	 * </p>
	 * @param data
	 * @date 2017年3月7日 下午4:12:53
	 * @since
	 */
	private void fullResollution(List<String> data){
		TreeSet<String> treeSet = new TreeSet<String>();
		//将data细分 去重
		for(String s:data){
			for(int i=1;i<s.length();i++){
				treeSet.add(s.substring(0, i));
			}
			treeSet.add(s);
		}
		//将treeset分割为num份
		System.out.println("treeset的大小"+treeSet.size());
		System.out.println("---------------------------------------------------------------------------");
		int tempsize = treeSet.size()/num;
		int size = tempsize;
		int allsize = treeSet.size();
		int index = 0;
		map.put(index,new ArrayList<String>());
		for(int j=0;j<allsize;j++){
			//当循环了j次,size*2 index++,index最多为num-1
			if(j == size && index != num-1){
				size = size+tempsize;
				map.put(++index, new ArrayList<String>());
				map.get(index).add(treeSet.pollFirst());
				continue;
			}
			map.get(index).add(treeSet.pollFirst());
		}
	}
	
	public void printMap(){
		for(int i=0;i<num;i++){
			System.out.println("第"+i+"组数据:");
			System.out.println("大小为："+map.get(i).size());
			System.out.println("---------------------------------------------------------------------------");
		}
	}
	
	/**
	 * 
	 * <p>说明：
	 * <li>根据num来创建线程数</li>
	 * </p>
	 * @date 2017年3月7日 下午4:17:47
	 * @since
	 */
	public void excute(){
		for(int i=0;i<num;i++){
			Excutor excutor = new Excutor(map.get(i));
			Thread thread = new Thread(excutor,"Thread-"+i);
			thread.start();
		}
	}
	
	private class Excutor implements Runnable{
		private List<String> excuteData;
		private SeleniumUtil seleniumUtil;
		private List<JdSuggest> jdSuggests;
		
		public Excutor(List<String> lists){
			excuteData = lists;
			seleniumUtil = new SeleniumUtil(driverPath,url);
			jdSuggests = new ArrayList<JdSuggest>();
		}
		
		public void run() {
			System.out.println(Thread.currentThread().getName());
			for(String key : excuteData){
				JdSuggest jdSuggest = new JdSuggest();
				jdSuggest.setKey(key);
				jdSuggest.setData(seleniumUtil.getSearchData(input, search, key));
				seleniumUtil.clear(input);
				jdSuggests.add(jdSuggest);
			}
			seleniumUtil.close();
			insertData(jdSuggests);
		}
		
		private void insertData(List<JdSuggest> jdSuggests){
			mu.insertInfo(jdSuggests);
		}
	}
}
