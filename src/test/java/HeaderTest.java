import org.jboss.arquillian.drone.api.annotation.Drone;
import org.jboss.arquillian.graphene.enricher.findby.FindBy;
import org.jboss.arquillian.junit.Arquillian;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertTrue;

/**
 * Created with IntelliJ IDEA.
 * User: Wybraniec
 * Date: 04.07.13
 * Time: 10:04
 * To change this template use File | Settings | File Templates.
 */
@RunWith(Arquillian.class)
public class HeaderTest {

    @FindBy(css = "#wrap")
    Header header;
    @Drone
    WebDriver browser;
    @Before
    public void beforeTests(){

    }

    @Test
    public void testVopLogoClick(){
        //Given
        //When
        browser.navigate().to("https://itcrowd.pl/vop/");
        header.vopLogoClick();
        //Then
        assertTrue(browser.getCurrentUrl().startsWith("https://itcrowd.pl/vop/"));
    }
    @Test
    public void testPsychicsButtonClick(){
        browser.navigate().to("https://itcrowd.pl/vop/");
        header.psychicsButtonClick();
        assertTrue(browser.getCurrentUrl().startsWith("https://itcrowd.pl/vop/psychics"));
    }
    @Test
    public void testMarketplaceButton(){
        browser.navigate().to("https://itcrowd.pl/vop/");
        header.marketplaceButtonClick();
        assertTrue(browser.getCurrentUrl().startsWith("https://itcrowd.pl/vop/shop"));
    }
    @Test
    public void testBlogButton(){
        browser.navigate().to("https://itcrowd.pl/vop/");
        header.blogButtonClick();
        assertTrue(browser.getCurrentUrl().startsWith("http://blog.voiceofpsychic.com/"));
    }
    @Test
    public void testMyaccountButton(){
        browser.navigate().to("https://itcrowd.pl/vop/");
        header.myaccountButtonClick();
        assertTrue(browser.getCurrentUrl().startsWith("https://itcrowd.pl/vop/private?p=MAILBOX"));
    }
    @Test
    public void testSearchInputField(){
        browser.navigate().to("https://itcrowd.pl/vop/");
        header.setSearchInput();
        header.searchConfirmButtonClick();
        assertTrue(browser.getCurrentUrl().startsWith("https://itcrowd.pl/vop/view/searchResult.jsf?find=psychic7"));
    }
    @Test
    public void testSearchConfirmButton(){
        browser.navigate().to("https://itcrowd.pl/vop/");
        header.searchConfirmButtonClick();
        assertTrue(browser.getCurrentUrl().startsWith("https://itcrowd.pl/vop/view/searchResult.jsf?find="));
    }
    @Test
    public void testLoginButton(){
        browser.navigate().to("https://itcrowd.pl/vop/");
        header.loginButtonClick();
        assertTrue(browser.getCurrentUrl().startsWith("https://itcrowd.pl/vop/login"));
    }
    @Test
    public void testSignUpButton(){
        browser.navigate().to("https://itcrowd.pl/vop/");
        header.signUpButtonClick();
        assertTrue(browser.getCurrentUrl().startsWith("https://itcrowd.pl/vop/register"));
    }
    @Test
    public void testShoppingCartClick(){
        browser.navigate().to("https://itcrowd.pl/vop/");
        header.shoppingCartButtonClick();
        assertTrue(browser.getCurrentUrl().startsWith("https://itcrowd.pl/vop/cart"));
    }
//    @Test
//    public void testEnglishMenuClick(){
//        browser.navigate().to("https://itcrowd.pl/vop/");
//        header.englishMenuClick();
//        assertEquals("Psychics",header.getPsychicsButton().getText());
//    }
//    @Test
//    public void testPolishMenuClick(){
//        browser.navigate().to("https://itcrowd.pl/vop/");
//        header.polishMenuClick();
//        assertEquals("Konsultanci",header.getPsychicsButton().getText());
//    }




}
