import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeTest;

public class Trendyol<MobileElement> {
    private AppiumDriver<MobileElement> driver;

    @BeforeTest
    public void setup() throws Exception {
        // DesiredCapabilities ayarlarını yap
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("deviceName", "Android Emulator");
        caps.setCapability("platformName", "Android");
        caps.setCapability("appPackage", "com.trendyol");
        caps.setCapability("appActivity", "com.trendyol.ui.splash.SplashActivity");
        caps.setCapability("noReset", true);

        // AppiumDriver'ı başlat
        driver = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"), caps);
    }

    @Test
    public void test() throws Exception {
        // Ürünü sepete ekle
        MobileElement searchField = driver.findElementById("search_top_bar_text");
        searchField.sendKeys("iPhone X");
        searchField.submit();

        MobileElement addToCartButton = driver.findElementById("img");
        addToCartButton.click();

        // Ödeme sayfasına git
        MobileElement goToPaymentPageButton = driver.findElementById("payment_button");
        goToPaymentPageButton.click();

        // Adres ve kart bilgilerini gir
        MobileElement addressField = driver.findElementById("address_field");
        addressField.sendKeys("123 Main St");

        MobileElement cardNumberField = driver.findElementById("card_number_field");
        cardNumberField.sendKeys("1234 5678 9012 3456");

        // Çıkış yap
        MobileElement logoutButton = driver.findElementById("logout_button");
        logoutButton.click();
    }

    @AfterTest
    public void teardown() {
        // AppiumDriver'ı kapat
        driver.quit();
}
