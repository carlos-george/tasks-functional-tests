package br.com.til.tasks.functional.tests;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TasksTest {

	
	private static final String SUCCESS_MESSAGE = "Success!";
	
	private static final String ERROR_MESSAGE_DESC_TASK_VAZIO = "Fill the task description";

	private static final String ERROR_MESSAGE_DUEDATE_PAST = "Due date must not be in past";

	private static final String ERROR_MESSAGE_DUEDATE_VAZIO = "Fill the due date";
	
	 public WebDriver acessarApp() {
		System.setProperty("webdriver.chrome.driver", "/Volumes/Macintosh HD/Projetos/Devops/chromedriver");
		WebDriver webDriver = new ChromeDriver();
		
		webDriver.navigate().to("http:/localhost:8001/tasks");
		
		webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		return webDriver;
	 }

	@Test
	public void deveSalvarTarefaComSucesso() {

		WebDriver webDriver = acessarApp();
		
		try {
			
			WebElement element = webDriver.findElement(By.id("addTodo"));
			
			element.click();
			
			WebElement elementInput = webDriver.findElement(By.id("task"));
			
			elementInput.sendKeys("Test with selenium");
			
			WebElement elementInputDueDate = webDriver.findElement(By.id("dueDate"));
			
			elementInputDueDate.sendKeys("15/10/2021");
			
			WebElement elementSave = webDriver.findElement(By.id("saveButton"));
			
			elementSave.click();
			
			WebElement elementMessage = webDriver.findElement(By.id("message"));
			
			System.out.println(elementMessage.getText());
			
			String message = elementMessage.getText();
			
			assertEquals(SUCCESS_MESSAGE, message);
			
		} finally {
			
			webDriver.quit();
		}
		
		
	}
	
	@Test
	public void naoDeveSalvarTarefaTaskVazio() {
		
		WebDriver webDriver = acessarApp();
		
		try {
			
			WebElement element = webDriver.findElement(By.id("addTodo"));
			
			element.click();
			
			WebElement elementInput = webDriver.findElement(By.id("task"));
			
			elementInput.sendKeys("");
			
			WebElement elementInputDueDate = webDriver.findElement(By.id("dueDate"));
			
			elementInputDueDate.sendKeys("15/10/2021");
			
			WebElement elementSave = webDriver.findElement(By.id("saveButton"));
			
			elementSave.click();
			
			WebElement elementMessage = webDriver.findElement(By.id("message"));
			
			System.out.println(elementMessage.getText());
			
			String message = elementMessage.getText();
			
			assertEquals(ERROR_MESSAGE_DESC_TASK_VAZIO, message);
			
		} finally {
			
			webDriver.quit();
		}
		
		
	}
	
	@Test
	public void naoDeveSalvarTarefaDataPast() {
		
		WebDriver webDriver = acessarApp();
		
		try {
			
			WebElement element = webDriver.findElement(By.id("addTodo"));
			
			element.click();
			
			WebElement elementInput = webDriver.findElement(By.id("task"));
			
			elementInput.sendKeys("Test with Selenium");
			
			WebElement elementInputDueDate = webDriver.findElement(By.id("dueDate"));
			
			elementInputDueDate.sendKeys("15/10/2020");
			
			WebElement elementSave = webDriver.findElement(By.id("saveButton"));
			
			elementSave.click();
			
			WebElement elementMessage = webDriver.findElement(By.id("message"));
			
			System.out.println(elementMessage.getText());
			
			String message = elementMessage.getText();
			
			assertEquals(ERROR_MESSAGE_DUEDATE_PAST, message);
			
		} finally {
			webDriver.quit();
			
		}
		
		
	}
	
	@Test
	public void naoDeveSalvarTarefaDataVazia() {
		
		WebDriver webDriver = acessarApp();
		
		try {
			
			WebElement element = webDriver.findElement(By.id("addTodo"));
			
			element.click();
			
			WebElement elementInput = webDriver.findElement(By.id("task"));
			
			elementInput.sendKeys("Test with Selenium");
			
			WebElement elementInputDueDate = webDriver.findElement(By.id("dueDate"));
			
			elementInputDueDate.sendKeys("");
			
			WebElement elementSave = webDriver.findElement(By.id("saveButton"));
			
			elementSave.click();
			
			WebElement elementMessage = webDriver.findElement(By.id("message"));
			
			System.out.println(elementMessage.getText());
			
			String message = elementMessage.getText();
			
			assertEquals(ERROR_MESSAGE_DUEDATE_VAZIO, message);
			
		} finally {
			
			webDriver.quit();
		}
		
		
	}
}
