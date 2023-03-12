package Pages;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import static java.lang.Thread.sleep;

public class PageCal {
        WebDriver driver = new ChromeDriver();

        public PageCal(){}
        public void open()
        {
            WebDriverManager.chromedriver().setup();


            driver.manage().window().maximize();
            driver.get("https://www.calculator.net/");

        }

        public void enternumber(String arg0) throws InterruptedException {
            for (int i = 0; i < arg0.length(); i++) {
                if (!String.valueOf(arg0.charAt(i)).equals("-") ){
                    System.out.println("char="+arg0.charAt(i));
                    driver.findElement(By.xpath("//span[.=" + arg0.charAt(i) + "]")).click();
                    sleep(1000);
                } else {
                    driver.findElement(By.xpath("//span[@onclick=\"r('" + arg0.charAt(i) + "')\"]")).click();

                }
            }
        }
        public void enteroperator(String op) throws InterruptedException {
            driver.findElement(By.xpath("//span[@onclick=\"r('"+op+"')\"]")).click();
            sleep(1000);

        }

        public void checkResult(String expected) throws InterruptedException {
            String actual=driver.findElement(By.xpath("//*[@id=\"sciOutPut\"]")).getText().trim();
            Assert.assertEquals(actual,expected);
            Thread.sleep(1000);
            driver.findElement(By.xpath("//span[.='AC']")).click();
            driver.close();

        }
    }


