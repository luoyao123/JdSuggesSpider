package cup.spider.util;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class SeleniumUtil {
	private WebDriver driver;
	private Actions action;
	/**
	 * note		: driver要放浏览器的安装目录
	 * download : google
	 * @param driverPath driver在系统中的位置
	 */
	public SeleniumUtil(String driverPath,String url){
		System.setProperty("webdriver.chrome.driver", driverPath);
		driver = new ChromeDriver();
		action = new Actions(driver);
		driver.get(url);
	}
	
	
	/**
	 * 
	 * <p>说明：
	 * <li></li>
	 * </p>
	 * @param inputId
	 * @param searchId
	 * @param keyword
	 * @return
	 * @date 2017年3月7日 下午2:27:52
	 * @since
	 */
	public String getSearchData(String inputId,String searchId,String keyword){
		try {
			WebElement input = driver.findElement(By.id(inputId));
			input.sendKeys(keyword);
			WebElement ele2 = driver.findElement(By.id(searchId));
			action.click();
			//线程睡眠一秒，让京东获得搜索的信息
			Thread.currentThread().sleep(1000l);
			return ele2.getText();
		} catch (InterruptedException e) {
			System.err.println(e.getMessage());
		}
		return null;
	}
	
	public void clear(String inputId){
		WebElement input = driver.findElement(By.id(inputId));
		input.clear();
	}
	
	public void close(){
		driver.close();
	}
}
