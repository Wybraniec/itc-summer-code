import org.jboss.arquillian.drone.api.annotation.Drone;
import org.jboss.arquillian.graphene.enricher.findby.FindBy;
import org.jboss.arquillian.junit.Arquillian;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import static com.thoughtworks.selenium.SeleneseTestBase.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created with IntelliJ IDEA.
 * User: Wybraniec
 * Date: 05.07.13
 * Time: 12:35
 * To change this template use File | Settings | File Templates.
 */
@RunWith(Arquillian.class)
public class HomePageTest {
    @FindBy(css = "#wrap")
    HomePage homePage;
    @Drone
    WebDriver browser;
    @Before
    public void beforeTests(){

    }

    @Test
    public void testRegisterToGet3Minutes(){
        browser.navigate().to("https://itcrowd.pl/vop/");
        homePage.registerToGet3MinutesClick();
        //assertTrue(browser.getCurrentUrl().startsWith("https://itcrowd.pl/vop/register"));
        assertEquals("https://itcrowd.pl/vop/register",browser.getCurrentUrl());
    }
    @Test
    public void testAreYouPsychicJoin(){
        browser.navigate().to("https://itcrowd.pl/vop/");
        homePage.areYouPsychicJoinClick();
        assertTrue(browser.getCurrentUrl().startsWith("https://itcrowd.pl/vop/view/registerPsychic.jsf"));
    }
}
