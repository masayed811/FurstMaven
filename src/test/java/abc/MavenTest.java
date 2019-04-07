package abc;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class MavenTest {


        protected static WebDriver driver;


        private String getCurrentDateTime()
        {
            DateFormat dateFormat = new SimpleDateFormat( "MMDDYYYYHHSS" );
            Date date = new Date();
            String date1 = dateFormat.format( date );
            System.out.println( "Current date and time is " + date1 );
            return date1;
        }
       @Before
       public void setUp() {

          System.setProperty( "webdriver.chrome.driver", "src\\test\\java\\abc\\web\\chromedriver.exe" );
           driver = new ChromeDriver();
           driver.get( "https://demo.nopcommerce.com/" );

            //asking for url
           driver.manage().timeouts().implicitlyWait( 50, TimeUnit.SECONDS );

       }
@Test
        public void userShouldRegisterSuccessfully(){

            driver.findElement( By.xpath("//a[@class=\"ico-register\"]") ).click();
       // driver.findElement( By.xpath( "//div[forcheckbox for=\"gender-male\"]"  ) ).click(); //click gender male
            driver.findElement( By.id( "First name" )).sendKeys( "Ma" );
            driver.findElement( By.id( "Last name" ) ).sendKeys( "Sayed" );
            driver.findElement( By.id( "Email" ) ).sendKeys( "test"+getCurrentDateTime() );
            driver.findElement( By.id( "Password" ) ).sendKeys( "ssss1234" );
            driver.findElement( By.id( "ConfirmPassword" ) ).sendKeys( "ssss1234" );
            driver.findElement( By.id( "register button" ) ).click();
            // String actualRegistrationSuccessMessege=driver.findElement( By.xpath(" //div[@\"//div[@class=\"result\"]");
            Assert.assertEquals("Your registration completed ","Your registration completed");

        }

        @Test
        public void verfyCurrency(){

        }
        @Test
        public void userShouldAbleToNavigateToJavaPage()
        {

        }
        @After
    public void tearDown(){
            driver.quit();
        }
}

