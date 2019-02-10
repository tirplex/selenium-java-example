package seleniumTests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;

public class Test {
	
	public static final String WEBDRIVER_PATH = "C:\\Users\\Study\\Downloads\\chromedriver_win32\\chromedriver.exe";
	public static final String DELIVERY_URL = "https://www.delivery-club.ru";
	public static final String ADDRESS_STR = "������������, ����� ������� ������, 11";
	
    public static void main(String[] args) throws InterruptedException {
    	
    	System.setProperty("webdriver.chrome.driver", WEBDRIVER_PATH);
        WebDriver driver = new ChromeDriver();
        
//        1. Open https://www.delivery-club.ru/
        driver.get(DELIVERY_URL);
        
//        2. Enter the address �������������, ����� ������� ������, 11� in the field �������� ����� �������Ȕ
        WebElement addrElement = driver.findElement(By.id("user-addr__input"));
        addrElement.click();
        addrElement.clear();
        addrElement.sendKeys(ADDRESS_STR);
        
//        3. Click the button ������ ����������
        WebElement addrButtonElement = driver.findElement(By.className("user-addr__label__btn"));
        addrButtonElement.click();       
        Thread.sleep(2000);
        
//        4. In the filter block, set the checkbox "�������� ����
//        I use "�������" cause "�������� ���� have different behavior after 22:00
        WebElement checkBoxElement = driver.findElement(By.xpath("//input[@value='�������']/.."));
        checkBoxElement.click();
        Thread.sleep(2000);
        
//        5. In the filter block, set the switch "����� to ��� 500
        WebElement radioButtonElement = driver.findElement(By.xpath("//input[@name='min_sum'][@value='500']/.."));
        radioButtonElement.click();
        Thread.sleep(2000);
        
//        6. Open the first filters search result
        WebElement cardElement = driver.findElement(By.xpath("//section[@class='vendor-item__card'][1]"));
        cardElement.click();  
//        Thread.sleep(2000);  
        
//        7. Click the �������� tab
        WebElement reviewsLinkElement = driver.findElement(By.xpath("//a[contains(text(), '������')]"));
        reviewsLinkElement.click();
        
//        8. Need to get the information about the first feedback - the text of the feedback
        WebElement listItemElement = driver.findElement(By.xpath("//li[@class='feedback-list__item'][1]//div[@class='feedback-list__item-text']"));
        System.out.println(listItemElement.getText());
        
        Thread.sleep(15000);
        driver.close();
    }
 }