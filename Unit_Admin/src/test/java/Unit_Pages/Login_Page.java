package Unit_Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.base.DriverPage;

public class Login_Page extends DriverPage {

	@Test(dataProvider = "TestData")
	public void Login(String username, String password) throws Exception {
		browsers();
		driver.get("https://staging-admin.avighnasteel.in/");
		
		
		//TEXT ON SIGN IN PAGE
		
		WebElement Header = driver.findElement(By.xpath("//*[text()=\"Start your journey with us.\"]"));
		System.out.println( Header.getText());
		
		System.out.println("===========");
		
		WebElement Welcome_Msg = driver.findElement(By.xpath("//*[@class=\"md:text-base xlg:text-lg font-normal mb-4\"]"));
		System.out.println(Welcome_Msg.getText());
		
		System.out.println("===========");
		
		WebElement text = driver.findElement(By.xpath("//*[@class=\"auth-right-child-container p-10 flex flex-col h-full\"]"));
        System.out.println(text.getText());
        
		driver.findElement(By.name("email")).sendKeys(username);
		driver.findElement(By.name("password")).sendKeys(password);
		driver.findElement(By.xpath("//*[text()=\"Sign in\"]")).click();
		
		WebElement Actual_Cstmr_Header = driver.findElement(By.xpath("//*[text()=\"Customer Management\"]"));
		System.out.println(" ===User Is Sucessefully on Customer Management Page=== ");
		String Actua_Header = Actual_Cstmr_Header.getText();
		String Expcted_Header = "Customer Management";
		Assert.assertEquals(Actua_Header, Expcted_Header );

		
		

//		String Actual_url = driver.getCurrentUrl();
//		String Expcted_url = "https://staging-admin.avighnasteel.in/";
//		Assert.assertEquals(Actual_url, Expcted_url);
//
//		WebElement img = driver.findElement(By.xpath("//img"));
//		System.out.println(img.isDisplayed() + " = Logo is displaying");

	}

	@DataProvider(parallel = false)
	public Object[][] TestData() {
		Object[][] data = new Object[][] { 
			    { "Admin@abainfotech.com", "Admin@1234" }, // valid
				{ "Admin@abainfotech.com", "admin"      }, 
				{ "Admin", "Admin@1234"                 }, 
				{ "", "Admin@1234"                      },
				{ "Admin@abainfotech.com", ""           }, 
				{ "", ""                                }, 
				{ "Admin@abainfotech.com", ""           }

		};
		return data;
	}

	@Test
	public void Velidate() {

		String actualURL = driver.getCurrentUrl();
		//String expectedURL = "https://staging-admin.avighnasteel.in/"; // Expected URL after login
		String expectedURL = "https://staging-admin.avighnasteel.in/customer-management"; // Expected URL after login
		Assert.assertEquals(actualURL, expectedURL, "Login successful.");

		WebElement img = driver.findElement(By.xpath("//img"));
		System.out.println(img.isDisplayed() + " = Logo is displaying");
		
		WebElement Actual_Cstmr_Header = driver.findElement(By.xpath("//*[text()=\"Customer Management\"]"));
		System.out.println(" ===User Is Sucessefully on Customer Management Page=== ");
		String Actua_Header = Actual_Cstmr_Header.getText();
		String Expcted_Header = "Customer Management";
		Assert.assertEquals(Actua_Header, Expcted_Header );


		
	}
//	@Test
	public void Text_On_page()
	{
		List<WebElement> text = driver.findElements(By.xpath("//*[@class=\"auth-right-child-container p-10 flex flex-col h-full\"]"));
		for (WebElement element : text) {
		    System.out.println(element.getText());
		}
	}

}
