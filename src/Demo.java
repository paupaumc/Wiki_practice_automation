import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Demo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.get("http://wikipedia.org/");
		System.out.println(driver.getTitle());
		driver.findElement(By.id("searchInput")).sendKeys("Taylor Swift");
		driver.findElement(By.id("searchInput")).submit();
		
		By studioAlbumsInput = By.xpath(
				"//table[@class='nowraplinks vcard hlist collapsible expanded navbox-inner mw-collapsible mw-made-collapsible']/tbody/tr[3]/td");
		WebElement studioAlbums = driver.findElement(studioAlbumsInput);
		System.out.println(studioAlbums.getText());
		
		

	}

}
