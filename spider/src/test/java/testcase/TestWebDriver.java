package testcase;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;

import javax.swing.text.AbstractDocument.BranchElement;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import cup.spider.util.SeleniumUtil;

public class TestWebDriver {
	@Test
	public void test1(){
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files (x86)\\Google\\Chrome\\Application\\chromedriver.exe");
		WebDriver webDriver = new ChromeDriver();
		//driver.get("http://www.google.com");
		webDriver.get("https://www.jd.com/");
		
		Actions action = new Actions(webDriver);
		WebElement element = webDriver.findElement(By.id("key"));
		element.sendKeys("坦克");
		WebElement ele2 = webDriver.findElement(By.id("search"));
		action.click(element);
		try {
			Thread.sleep(1000l);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String data = ele2.getText();
		System.out.println(data);
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter("E:\\ycsearch\\word\\jd.txt"));
			bw.write(data);
			bw.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		if(ele2.getText()==""||ele2.getText()==null){
			System.out.println("没得到值");
		}
		System.out.println(ele2.getText());
	}
	
}
