import org.jboss.arquillian.graphene.enricher.findby.FindBy;
import org.openqa.selenium.WebElement;

import static org.jboss.arquillian.graphene.Graphene.guardHttp;

/**
 * Created with IntelliJ IDEA.
 * User: Wybraniec
 * Date: 04.07.13
 * Time: 09:11
 * To change this template use File | Settings | File Templates.
 */
public class Footer {

    @FindBy(css = "[id='footerContent'] a.row-bold")
    private WebElement helpButton;

    @FindBy(css = "[id='footerContent'] div:nth-of-type(1) div:nth-of-type(2) > small > a")
    private WebElement aboutUsButton;

    @FindBy(css = "[id='footerContent'] div:nth-of-type(1) div:nth-of-type(3) > strong > a")
    private WebElement howItWorksButton;

    @FindBy(css = "[id='footerContent'] div:nth-of-type(2) div:nth-of-type(1) > small > a")
    private WebElement aboutPsychicReadingsButton;

    @FindBy(css = "[id='footerContent'] div:nth-of-type(2) div:nth-of-type(2) > small > a")
    private WebElement contactUsButton;

    @FindBy(css = "[id='footerContent'] div:nth-of-type(3) small:nth-of-type(1) > small > a")
    private WebElement privacyPolicyButton;

    @FindBy(css = "[id='footerContent'] div:nth-of-type(3) small:nth-of-type(2) > small > a")
    private WebElement termsConditionsButton;

    @FindBy(css = "[id='footerContent'] div:nth-of-type(2) div:nth-of-type(4) div:nth-of-type(1) > a")
    private WebElement connectWithUsByFB;

    @FindBy(css = "[id='footerContent'] div:nth-of-type(2) div:nth-of-type(4) div:nth-of-type(2) > a")
    private WebElement connectWithUsByTwitter;
    ////*[@id="footerContent"]/div[2]/div[4]/div[3]/a
    @FindBy(css = "[id='footerContent'] div:nth-of-type(2) div:nth-of-type(4) div:nth-of-type(3)  a")
    private WebElement connectWithUsByPinterest;

    @FindBy(css = "[id='footerContent'] div:nth-of-type(2) div:nth-of-type(4) div:nth-of-type(4)  a  img")
    private WebElement connectWithUsByYT;

    public void helpButtonClick(){
        guardHttp(helpButton).click();
    }
    public void aboutUsButtonClick(){
        guardHttp(aboutUsButton).click();
    }
    public void howItWorksButtonClick(){
        guardHttp(howItWorksButton).click();
    }
    public void aboutPsychicReadingsButtonClick(){
        guardHttp(aboutPsychicReadingsButton).click();
    }
    public void contactUsButtonClick(){
        guardHttp(contactUsButton).click();
    }
    public void privacyPolicyButtonClick(){
        guardHttp(privacyPolicyButton).click();
    }
    public void termsConditionsButtonClick(){
        guardHttp(termsConditionsButton).click();
    }
    public void connectWithUsByFBClick(){
        guardHttp(connectWithUsByFB).click();
    }
    public void connectWithUsByTwitterClick(){
        guardHttp(connectWithUsByTwitter).click();
    }
    public void connectWithUsByPinterestClick(){
        guardHttp(connectWithUsByPinterest).click();
    }
    public void connectWithUsByYTClick(){
        guardHttp(connectWithUsByYT).click();
    }
    //Getters
    public WebElement getHelpButton() {
        return helpButton;
    }

    public WebElement getAboutUsButton() {
        return aboutUsButton;
    }

    public WebElement getHowItWorksButton() {
        return howItWorksButton;
    }

    public WebElement getAboutPsychicReadingsButton() {
        return aboutPsychicReadingsButton;
    }

    public WebElement getContactUsButton() {
        return contactUsButton;
    }

    public WebElement getPrivacyPolicyButton() {
        return privacyPolicyButton;
    }

    public WebElement getTermsConditionsButton() {
        return termsConditionsButton;
    }

    public WebElement getConnectWithUsByFB() {
        return connectWithUsByFB;
    }

    public WebElement getConnectWithUsByTwitter() {
        return connectWithUsByTwitter;
    }

    public WebElement getConnectWithUsByPinterest() {
        return connectWithUsByPinterest;
    }

    public WebElement getConnectWithUsByYT() {
        return connectWithUsByYT;
    }
}
