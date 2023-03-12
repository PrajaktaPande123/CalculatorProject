package Pages;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class PageCal {
        WebDriver driver = new ChromeDriver();

        public PageCal(){}
        public void open()
        {
            WebDriverManager.chromedriver().setup();


            driver.manage().window().maximize();
            driver.get("https://www.calculator.net/");

        }

        public void enternumber(String arg0) {
            for (int i = 0; i < arg0.length(); i++) {
                if (!String.valueOf(arg0.charAt(i)).equals("-") ){
                    System.out.println("char="+arg0.charAt(i));
                    driver.findElement(By.xpath("//span[.=" + arg0.charAt(i) + "]")).click();

                } else {
                    driver.findElement(By.xpath("//span[@onclick=\"r('" + arg0.charAt(i) + "')\"]")).click();

                }
            }
        }
        public void enteroperator(String op) {
            driver.findElement(By.xpath("//span[@onclick=\"r('"+op+"')\"]")).click();
        }

        public void checkResult(String expected) {
            String actual=driver.findElement(By.xpath("//*[@id=\"sciOutPut\"]")).getText().trim();
        Assert.assertEquals(actual,expected);
            driver.findElement(By.xpath("//span[.='AC']")).click();
driver.close();

        }
    }


