package ohtu;

import java.util.Random;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Tester {

    public static void main(String[] args) {
        Random random = new Random();
        WebDriver driver = new FirefoxDriver();

        driver.get("http://localhost:4567");
        
        sleep(1);
        
        WebElement element = driver.findElement(By.linkText("login"));
        
        /*element.click();

        sleep(2);
        
        element = driver.findElement(By.name("username"));
        element.sendKeys("pekka");
        element = driver.findElement(By.name("password"));
        element.sendKeys("pekka");
        element = driver.findElement(By.name("login"));
        
        sleep(2);
        element.submit();*/
        
        element = driver.findElement(By.linkText("register new user"));
        element.click();
        sleep(1);
        
        String usrnm = "pekka"+random.nextInt();
        
        element = driver.findElement(By.name("username"));
        element.sendKeys(usrnm);
        element = driver.findElement(By.name("password"));
        element.sendKeys("akkep");
        element = driver.findElement(By.name("passwordConfirmation"));
        element.sendKeys("akkep");
        
        element = driver.findElement(By.name("signup"));
        element.submit();
        sleep(1);
        
        element = driver.findElement(By.linkText("continue to application mainpage"));
        element.click();
        sleep(1);
        
        element = driver.findElement(By.linkText("logout"));
        element.click();
        sleep(2);
        

        driver.quit();
    }
    
    private static void sleep(int n){
        try{
            Thread.sleep(n*1000);
        } catch(Exception e){}
    }
}
