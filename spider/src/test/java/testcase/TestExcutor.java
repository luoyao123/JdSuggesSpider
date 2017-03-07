package testcase;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.junit.Test;

public class TestExcutor {
	
	@Test
	public void test1(){
		ExecutorService service = Executors.newFixedThreadPool(5);
		
	}
	
	static class Task implements Runnable{

		public void run() {
			// TODO Auto-generated method stub
			
		}
		
	}
		
}
