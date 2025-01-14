import org.testng.annotations.Test;

public class FlipkartTest  extends BaseTest{
    @Test
    public void flipkartTest()
    {
        driver.get("https://www.flipkart.com/");
    }

}
