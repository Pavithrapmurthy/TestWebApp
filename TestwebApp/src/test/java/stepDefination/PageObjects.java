package stepDefination;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageObjects {
	public PageObjects(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText="Selectable")
	private WebElement Selectable;
	
	public void click_Selectable()
	{
		Selectable.click();
	}

	@FindBy(xpath="//iframe[@class='demo-frame']")
	WebElement iFrames;
	
	@FindBy(xpath="//iframe[@src='/resources/demos/selectable/display-grid.html']")
	WebElement gridFrames;
	
	@FindBy(linkText="Display as grid")
	private WebElement gridButton;
	
	public void gridButton()
	{
		gridButton.click();
	}
	
	@FindBy(linkText="jQuery UI")
	WebElement logo;
	public void logoClick()
	{
		logo.click();
	}
	
	@FindBy(linkText="Draggable")
	WebElement draggable;
	public void draggable()
	{
		draggable.click();
	}
	
	@FindBy(linkText="Sortable")
	WebElement sortable;
	
	public void sortable()
	{
		sortable.click();
	
	}
	
	@FindBy(xpath="//iframe[@src='/resources/demos/draggable/default.html']")
	WebElement dragdefaultFrames;
	
	@FindBy(id="draggable")
	WebElement draggableelement;
	
	@FindBy(linkText="Droppable")
	WebElement droppable;
	
	public void droppable()
	{
		droppable.click();
	}
	
	@FindBy(linkText="Simple photo manager")
	WebElement simplephotomanager;
	
	public void simplephotomanager()
	{
		simplephotomanager.click();
	}
	
	@FindBy(xpath="//iframe[@src='/resources/demos/droppable/photo-manager.html']")
	WebElement droppableFrames;
	
	@FindBy(id="trash")
	WebElement trash;
	
	@FindBy(xpath="//img[@src='images/high_tatras_min.jpg']")
	WebElement image1;
	
	@FindBy(xpath="//img[@src='images/high_tatras2_min.jpg']")
	WebElement image2;
	
	@FindBy(xpath="//iframe[@src='/resources/demos/sortable/default.html']")
	WebElement sortableFrames;
	
	public void Screenshot(WebDriver driver) throws IOException
	{
		TakesScreenshot screenshot = (TakesScreenshot)driver;			//takes screenshot
		File source = screenshot.getScreenshotAs(OutputType.FILE);		//saving the screenshot
		FileUtils.copyFile(source, new File(System.getProperty("user.dir")+"./SeleniumScreenshots/Screen.png"));
		
	}
	
}

