package testcase;

import org.junit.Test;

import cup.spider.util.Task;

public class TestTask {
	/*@Test
	public void test(){
		Task task = new Task("E:\\ycsearch\\word\\analyze_title_double.txt", 1, "C:\\Program Files (x86)\\Google\\Chrome\\Application\\chromedriver.exe", "key", "search", "https://www.jd.com/");
		task.excute();
	}*/
	public static void main(String[] args) {
		//Task task = new Task("E:\\ycsearch\\word\\办公用品\\analyze2.txt", 10, "C:\\Program Files (x86)\\Google\\Chrome\\Application\\chromedriver.exe", "key", "search", "https://www.jd.com/");
		//Task task = new Task("E:\\ycsearch\\word\\办公用品\\analyze2.txt", 15, "", "key", "shelper", "https://www.jd.com/");
		//Task task = new Task("E:\\ycsearch\\word\\办公用品\\analyze2.txt", 15, "", "keyInput", "searchTextList", "http://www.staples.cn/");
		//task.printMap();
		//task.excuteHtml();
		Task task = new Task("E:\\ycsearch\\word\\办公用品\\analyze2.txt", 10, "C:\\Program Files (x86)\\Google\\Chrome\\Application\\chromedriver.exe", "keyInput", "searchTextList", "http://www.staples.cn/");
		task.excute();
	}
}
