package stepDefination;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import base.Base;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
public class Interactions extends Base{
	
	WebDriver driver;
	List<WebElement> li_elements,grid_elements;
	List<WebElement> sort_elements;

	@Before(order=1)
	@Given("I open the chrome browser")
	public void i_open_the_chrome_browser()
	{
		loadProjectDataProperties();
		driver = initializeBrowser(prop.getProperty("browser"));
		 
		 
	 }

	@Before(order=2)
	 @When("I navigate to the JqueryUI Website")
	 public void openWebsite()
	 {
		 driver.get(prop.getProperty("url"));
	 }
	 
	 @Then("I click Selectable")
	 public void clickSelectible()
	 {
		 PageObjects PO = new PageObjects(driver);
		 PO.click_Selectable();
	 }
	 
	@And("I select items one by one")
	 public void I_select_items_one_by_one()
	 {
		 PageObjects PO = new PageObjects(driver);
		 driver.switchTo().frame(PO.iFrames);
		 li_elements = driver.findElements(By.tagName("li"));
		 for(WebElement ele : li_elements)
		 {
			 ele.click();
			 
		 }
	 }
	 
	 @Then("I select multiple elements")
	 public void I_select_multiple_elements()
	 {
		 li_elements = driver.findElements(By.tagName("li"));
		 WebElement draggable = li_elements.get(2);
	     WebElement droppable = li_elements.get(4);
	     new Actions(driver).dragAndDrop(draggable, droppable).perform();
		 
	 }
	 
	 @SuppressWarnings("deprecation")
	@When("I select Display as grid example")
	 public void I_select_Display_as_grid_example()
	 {
		 driver.switchTo().defaultContent();
		 PageObjects PO = new PageObjects(driver);
		 PO.gridButton();
		 driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	 }
	 
	 @SuppressWarnings("deprecation")
	@Then("I select all the elements in the grid")
	 public void Then_I_select_all_the_elements_in_the_grid()
	 {
		 PageObjects PO = new PageObjects(driver);
		 driver.switchTo().frame(PO.gridFrames);
		 driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		 grid_elements = driver.findElements(By.tagName("li"));
		 WebElement draggable = grid_elements.get(0);
	     WebElement droppable = grid_elements.get(11);
	     new Actions(driver).dragAndDrop(draggable, droppable).perform();
		 
	 }
	 
	 @When("I click on Draggable")
	 public void Then_I_click_on_Draggable()
	 {
		 driver.switchTo().defaultContent();
		 PageObjects PO = new PageObjects(driver);
		 PO.draggable();
	 }
	 
	 @Then("I Move around the element")
	 public void Then_I_Move_around_the_element() throws InterruptedException
	 {
		 PageObjects PO = new PageObjects(driver);
		 driver.switchTo().frame(PO.dragdefaultFrames);
		 new Actions(driver).clickAndHold(PO.draggableelement).build().perform();
		 new Actions(driver).moveByOffset(150, 60).build().perform();
		 new Actions(driver).moveByOffset(0, 60).build().perform();
		 new Actions(driver).moveByOffset(0, 20).build().perform();
		 new Actions(driver).moveByOffset(-60, 0).build().perform();
		 new Actions(driver).release().build().perform();
		 driver.switchTo().defaultContent();
		 
	 }
	 
	 /*@And("I click on Sortable")
	 public void I_click_on_Sortable() throws InterruptedException
	 {
		 driver.switchTo().defaultContent();
		 PageObjects PO = new PageObjects(driver);
		 PO.sortable();
		 
		 PO.gridButton();
		 Thread.sleep(2000);
	 }*/
	 
	 @When("I click on Droppable")
	 public void I_click_on_Droppable()
	 {
		 PageObjects PO = new PageObjects(driver);
		 PO.droppable();
	 }
	 
	 @Then("I click on Simple photo manager")
	 public void I_click_on_Simple_photo_manager()
	 {
		 PageObjects PO = new PageObjects(driver);
		 PO.simplephotomanager();
	 }
	 
	 @And("I drop 2 images to Trash")
	 public void I_drop_2_images_to_Trash() throws InterruptedException
	 {
		 PageObjects PO = new PageObjects(driver);
		 driver.switchTo().frame(PO.droppableFrames);
		 new Actions(driver).dragAndDrop(PO.image1, PO.trash).build().perform();
		 Thread.sleep(1000);
		 new Actions(driver).dragAndDrop(PO.image2, PO.trash).build().perform();
		 Thread.sleep(1000);
		 List<WebElement> ul_list = driver.findElements(By.xpath("//div[@id='trash']//li"));
		 /*Select select = new Select(PO.imagelist);
		 List<WebElement> imglist = select.getOptions();*/
		 System.out.println(ul_list.size()+" images are in the trash");
		 driver.switchTo().defaultContent();
	 }
	 
	 @And("I should select alternate items")
	 public void And_I_should_select_alternate_items()
	 {
		 PageObjects PO = new PageObjects(driver);
		 driver.switchTo().frame(PO.iFrames);
		 new Actions(driver).keyDown(Keys.CONTROL).perform();
		 li_elements = driver.findElements(By.tagName("li"));
		 for(int i = 0; i<=li_elements.size()-1; i++)
		 {
			 if(i%2 == 0)
				 li_elements.get(i).click();
			 
			 
		 }
		 new Actions(driver).keyUp(Keys.CONTROL).perform();
	 }
	 
	 @Then("I should select 3 elements")
	 public void Then_I_should_select_3_elements()
	 {
		 li_elements = driver.findElements(By.tagName("li"));
		 new Actions(driver).dragAndDrop(li_elements.get(0), li_elements.get(2)).build().perform();
		 new Actions(driver).keyDown(Keys.CONTROL).perform();
		 new Actions(driver).dragAndDrop(li_elements.get(4), li_elements.get(6)).build().perform();
		 new Actions(driver).keyUp(Keys.CONTROL).perform();
		 driver.switchTo().defaultContent();
	 }
	 
	 @When("I click on sortable")
	 public void I_click_on_Sortable() throws InterruptedException
	 {
		 PageObjects PO = new PageObjects(driver);
		 PO.sortable();
		 driver.switchTo().frame(PO.sortableFrames);
		 sort_elements = driver.findElements(By.tagName("li"));
		 //new Actions(driver).dragAndDrop(li_elements.get(0), li_elements.get(2)).build().perform();
		 
	 }
	 
	   @Then("I should take the input and sort it")
	   public void I_should_take_the_input() throws InterruptedException
	   {
		   new Actions(driver).keyDown(Keys.ARROW_DOWN).perform();
		   @SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		   System.out.println("Enter 7 sequence number");
		   for(int i = 1; i<=7; i++)
		   {
			   int n = sc.nextInt();
			   Thread.sleep(1000);
			   new Actions(driver).dragAndDrop(driver.findElement(By.xpath("//li[contains(.,'Item "+n+"')]")), driver.findElement(By.xpath("//li["+i+"]"))).build().perform();
		   }
		   driver.switchTo().defaultContent();
	   }
	   
	 @Then("I Swicth back to Main page")
	 public void swicthtomainpage() throws InterruptedException, IOException
	 {
		 PageObjects PO = new PageObjects(driver);
		 PO.Screenshot(driver);
		 PO.logoClick();
		 Thread.sleep(2000);
	 }
	 @After
	public void closebrowser()
	 {
		  driver.quit();
	 }
     
}

