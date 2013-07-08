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
 * Date: 05.07.13
 * Time: 11:34
 * To change this template use File | Settings | File Templates.
 */
@RunWith(Arquillian.class)
public class FooterTest {
    @FindBy(css = "#footer")
    Footer footer;
    @Drone
    WebDriver browser;
    @Before
    public void beforeTests(){

    }
    @Test
    public void testHelpButton(){
        browser.navigate().to("https://itcrowd.pl/vop/view/help.jsf?content=LOGIN_SIGNUP_CUSTOMER&mode=CUSTOMER");
        footer.helpButtonClick();
        assertTrue(browser.getCurrentUrl().startsWith("https://itcrowd.pl/vop/view/help.jsf?content=LOGIN_SIGNUP_CUSTOMER&mode=CUSTOMER"));
    }
    @Test
    public void testAboutUsButton(){
        browser.navigate().to("https://itcrowd.pl/vop/page/ABOUT");
        footer.aboutUsButtonClick();
        assertTrue(browser.getCurrentUrl().startsWith("https://itcrowd.pl/vop/page/ABOUT"));
    }
    @Test
    public void testHowItWorksButton(){
        browser.navigate().to("https://itcrowd.pl/vop/view/help.jsf?content=LOGIN_SIGNUP_CUSTOMER&mode=CUSTOMER");
        footer.howItWorksButtonClick();
        assertTrue(browser.getCurrentUrl().startsWith("https://itcrowd.pl/vop/view/help.jsf?content=LOGIN_SIGNUP_CUSTOMER&mode=CUSTOMER"));
    }
    @Test
    public void testAboutPsychicReadingsButton(){
        browser.navigate().to("https://itcrowd.pl/vop/page/PSYCHIC_READING");
        footer.aboutPsychicReadingsButtonClick();
        assertTrue(browser.getCurrentUrl().startsWith("https://itcrowd.pl/vop/page/PSYCHIC_READING"));
    }
    @Test
    public void testContactUsButton(){
        browser.navigate().to("https://itcrowd.pl/vop/contact");
        footer.contactUsButtonClick();
        assertTrue(browser.getCurrentUrl().startsWith("https://itcrowd.pl/vop/contact"));
    }
    @Test
    public void testPrivacyPolicyButton(){
        browser.navigate().to("https://itcrowd.pl/vop/page/PRIVACY_POLICY");
        footer.privacyPolicyButtonClick();
        assertTrue(browser.getCurrentUrl().startsWith("https://itcrowd.pl/vop/page/PRIVACY_POLICY"));
    }
    @Test
    public void testTermsConditionsButton(){
        browser.navigate().to("https://itcrowd.pl/vop/page/TERMS");
        footer.termsConditionsButtonClick();
        assertTrue(browser.getCurrentUrl().startsWith("https://itcrowd.pl/vop/page/TERMS"));
    }
    @Test
    public void testConnectWithUsByFB(){
        browser.navigate().to("https://itcrowd.pl/vop/");
        footer.connectWithUsByFBClick();
        assertTrue(browser.getCurrentUrl().startsWith("https://www.facebook.com/PsychicMarketplace"));
    }
    @Test
    public void testConnectWithUsByTwitter(){
        browser.navigate().to("https://itcrowd.pl/vop/");
        footer.connectWithUsByTwitterClick();
        assertTrue(browser.getCurrentUrl().startsWith("https://twitter.com/voiceofpsychic"));
    }
    @Test
    public void testConnectWithUsByPinterest(){
        browser.navigate().to("https://itcrowd.pl/vop/");
        footer.connectWithUsByPinterestClick();
        assertTrue(browser.getCurrentUrl().startsWith("http://pinterest.com/voiceofpsychic/"));
    }
    @Test
    public void testConnectWithUsByYT(){
        browser.navigate().to("https://itcrowd.pl/vop/");
        footer.connectWithUsByYTClick();
        assertTrue(browser.getCurrentUrl().startsWith("https://www.youtube.com/voiceofpsychic"));
    }

}
