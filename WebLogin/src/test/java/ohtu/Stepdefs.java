package ohtu;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import static org.junit.Assert.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class Stepdefs {
    //WebDriver driver = new ChromeDriver();
    WebDriver driver = new HtmlUnitDriver();
    String baseUrl = "http://localhost:4567";
    
    @Given("login is selected")
    public void loginIsSelected() {
        driver.get(baseUrl);
        WebElement element = driver.findElement(By.linkText("login"));       
        element.click();   
    }    
    
    @When("correct username {string} and password {string} are given")
    public void correctUsernameAndPasswordAreGiven(String username, String password) {
        logInWith(username, password);
    }    
    
    @Then("user is logged in")
    public void userIsLoggedIn() {
        pageHasContent("Ohtu Application main page");
    }    
 
    @When("correct username {string} and incorrect password {string} are given")
    public void correctUsernameAndIncorrectPasswordAreGiven(String username, String password) {
        logInWith(username, password);
    }    
    
    @Then("user is not logged in and error message is given")
    public void userIsNotLoggedInAndErrorMessageIsGiven() {
        pageHasContent("invalid username or password");
        pageHasContent("Give your credentials to login");
    }    
    
    @When("username {string} and password {string} are given")
    public void usernameAndPasswordAreGiven(String username, String password) throws Throwable {
        logInWith(username, password);
    }   
    
    @Then("system will respond {string}")
    public void systemWillRespond(String pageContent) throws Throwable {
        assertTrue(driver.getPageSource().contains(pageContent));
    }
    
    @When("nonexistent username {string} and password {string} are given")
    public void nonexistentUsernameAndPasswordAreGiven(String username, String password) {
        logInWith(username, password);
    }
    
    
    @Given("command new user is selected")
    public void commandNewUserIsSelected() {
        driver.get(baseUrl);
        WebElement element = driver.findElement(By.linkText("register new user"));       
        element.click();   
    }
    
    @When("a valid username {string} and password {string} and matching password confirmation are entered")
    public void aValidUsernameAndPasswordAndMatchingPasswordConfirmationAreEntered(String string, String string2) {
        signUpWith(string, string2, string2);
    }

    @Then("a new user is created")
    public void aNewUserIsCreated() {
        pageHasContent("Welcome to Ohtu Application!");
    }

    @When("a username {string} that is less than {int} characters and a password {string} and matching password confirmation are entered")
    public void aUsernameThatIsLessThanCharactersAndAPasswordAndMatchingPasswordConfirmationAreEntered(String string, Integer int1, String string2) {
        signUpWith(string, string2, string2);
    }

    @Then("user is not created and error username should have at least 3 characters is reported")
    public void userIsNotCreatedAndErrorIsReported() {
        pageHasContent("username should have at least 3 characters");
        pageHasContent("Create username and give password");
    }

    @When("a valid username {string} and a password {string} that is less than {int} characters and matching password confirmation are entered")
    public void aValidUsernameAndAPasswordThatIsLessThanCharactersAndMatchingPasswordConfirmationAreEntered(String string, String string2, Integer int1) {
        signUpWith(string, string2, string2);
    }
    
    @Then("user is not created and error password should have at least {int} characters is reported")
    public void userIsNotCreatedAndErrorPasswordShouldHaveAtLeastCharactersIsReported(Integer int1) {
        pageHasContent("password should have at least 8 characters");
        pageHasContent("Create username and give password");
    }

    @When("a valid username {string} and password {string} and not matching password confirmation {string} are entered")
    public void aValidUsernameAndPasswordAndNotMatchingPasswordConfirmationAreEntered(String string, String string2, String string3) {
        signUpWith(string, string2, string3);
    }

    @Then("user is not created and error password and password confirmation do not match is reported")
    public void userIsNotCreatedAndErrorPasswordAndPasswordConfirmationDoNotMatchIsReported() {
        pageHasContent("password and password confirmation do not match");
        pageHasContent("Create username and give password");
    }

    @Given("user with username {string} with password {string} is successfully created")
    public void userWithUsernameWithPasswordIsSuccessfullyCreated(String string, String string2) {
        driver.get(baseUrl);
        WebElement element = driver.findElement(By.linkText("register new user"));       
        element.click();
        signUpWith(string, string2, string2);
    }

    @When("the previous username {string} and password {string} are given")
    public void thePreviousUsernameAndPasswordAreGiven(String string, String string2) {
        driver.get(baseUrl);
        WebElement element = driver.findElement(By.linkText("login"));       
        element.click();
        logInWith(string, string2);
    }

    @Given("user with username {string} and password {string} is tried to be created")
    public void userWithUsernameAndPasswordIsTriedToBeCreated(String string, String string2) {
        driver.get(baseUrl);
        WebElement element = driver.findElement(By.linkText("register new user"));       
        element.click();
        signUpWith(string, string2, string2);
    }

    @When("the previous tried username {string} and password {string} are given")
    public void thePreviousTriedUsernameAndPasswordAreGiven(String string, String string2) {
        driver.get(baseUrl);
        WebElement element = driver.findElement(By.linkText("login"));       
        element.click();
        logInWith(string, string2);
    }

    
    
    
    @After
    public void tearDown(){
        driver.quit();
    }
        
    /* helper methods */
 
    private void pageHasContent(String content) {
        assertTrue(driver.getPageSource().contains(content));
    }
        
    private void logInWith(String username, String password) {
        assertTrue(driver.getPageSource().contains("Give your credentials to login"));
        WebElement element = driver.findElement(By.name("username"));
        element.sendKeys(username);
        element = driver.findElement(By.name("password"));
        element.sendKeys(password);
        element = driver.findElement(By.name("login"));
        element.submit();  
    }
    
    private void signUpWith(String username, String password, String passConf) {
        assertTrue(driver.getPageSource().contains("Create username and give password"));
        WebElement element = driver.findElement(By.name("username"));
        element.sendKeys(username);
        element = driver.findElement(By.name("password"));
        element.sendKeys(password);
        element = driver.findElement(By.name("passwordConfirmation"));
        element.sendKeys(passConf);
        element = driver.findElement(By.name("signup"));
        element.submit();
    }
}
