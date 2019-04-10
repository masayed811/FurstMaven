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


    private String getCurrentDateTime() {
        DateFormat dateFormat = new SimpleDateFormat( "MMDDYYYYHHSS" );
        Date date = new Date();
        String date1 = dateFormat.format( date );
        System.out.println( "Current date and time is " + date1 );
        return date1;
    }

    @Before
    public void setUp() {
// Chorme web driver path set
        System.setProperty( "webdriver.chrome.driver", "src\\test\\java\\abc\\web\\chromedriver.exe" );
        driver = new ChromeDriver();
        driver.get( "https://demo.nopcommerce.com/" ); //asking driver for url

// implicit wait set
        driver.manage().timeouts().implicitlyWait( 50, TimeUnit.SECONDS );

    }

    @Test
    public void userShouldRegisterSuccessfully() {
// click on Register button to open registration page
        driver.findElement( By.xpath( "//a[@class=\"ico-register\"]" ) ).click();

        // Enter the first name
        driver.findElement( By.id( "FirstName" ) ).sendKeys( "Md" );
        // Enter The Last name
        driver.findElement( By.id( "LastName" ) ).sendKeys( "ASayed" );
        // enter User email Id for registration
        driver.findElement( By.id( "Email" ) ).sendKeys( "masayed@gmail.com" + getCurrentDateTime() );
         // set the password
        driver.findElement( By.id( "Password" ) ).sendKeys( "ssss1234" );
        // Confirm the set password
        driver.findElement( By.id( "ConfirmPassword" ) ).sendKeys( "ssss1234" );
        // Click on Register Buton for submit the registration form
        driver.findElement( By.id( "register-button" ) ).click();
        // checking  the successfull result
        String actualRegistrationSuccessMessege = driver.findElement( By.xpath( "//div[@class=\"result\"]" ) ).getText();
        Assert.assertEquals( "Your registration completed ", "actualRegistrationSuccessMessege" );

    }

    // feature - User should be able to navigate in notebook page

    @Test
    public void UsershouldBeAbleToNavigateToNootebookCatetoryPage() {
// click on computer
        driver.findElement( By.linkText( "Computers" ) ).click();
    // click on notebook
        driver.findElement( By.partialLinkText( "Notebooks" ) );
    // Result
        String AccualResult = driver.findElement( By.xpath( "//div[@class='page-title']" ) ).getText();
        Assert.assertEquals( "notebooks", "AccualResult" );




    }
    //Feature -User should be able to navigate cell phone page via Electronics>>Cellpohone

    @Test
    public void UserShouldBeAbleToNavigateCellPhonePageViaElectronics() {
  // Click on Electrinics
        driver.findElement( By.linkText( "Electronics" ) ).click();

      //click cell phone
        driver.findElement( By.partialLinkText( "Cell phones" ) ).click();
       // result
        String AccutalResult = driver.findElement( By.xpath( "//div[@class='page-title']" ) ).getText();
        Assert.assertEquals( "Cell phones", "AccutalResult" );

    }
// Feature- User should be able to login Successfully
    @Test
    public void UserShouldBeAbleToLoginSuccessfully() {
        // click log in

        driver.findElement( By.xpath( "//a[@class='ico-login']" ) ).click();

        // enter email address
        driver.findElement( By.xpath( "//input[@class='email']" ) ).sendKeys( "sayed@yahoo.com" );
        // Enter password
        driver.findElement( By.xpath( "//input[@class='password']" ) ).sendKeys( "ssss1234" );
        // Click Log in Button to log in
        driver.findElement( By.xpath( "//input[@class='button-1 login-button']" ) ).click();
        // For confirmation log in we ca see log out button
        String AcctualResult = driver.findElement( By.linkText( "Log out" ) ).getText();
        Assert.assertEquals( "Log out", "AcctualResult" );
        System.out.println( "User Able ToLog in Successfully " );


    }
// Feature - User should be able to add product to shopping cart

    @Test
    public void UserShouldBeAbleToAddProductToShoppingCart() {

        // click on book page
driver.findElement( By.linkText( "Books" ) ).click();
// click on pride and prejudie
driver.findElement( By.partialLinkText( "Pride and Prejudice" ) ).click();
// click add cart
driver.findElement( By.xpath( "//input[@id='add-to-cart-button-39']" ) ).click();

//result
String AcctualResult=driver.findElement(By.xpath( "//p[@class='content']" )  ).getText();
Assert.assertEquals( "The product has been added to your shopping cart","AcctualResult" );

    }

    @After
    public void tearDown() {

                driver.quit();
    }
}


