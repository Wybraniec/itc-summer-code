package pl.itcrowd.summer_code.test;

import org.jboss.arquillian.graphene.enricher.findby.FindBy;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.jboss.arquillian.graphene.Graphene.guardHttp;
import static org.jboss.arquillian.graphene.Graphene.guardXhr;
import static org.jboss.arquillian.graphene.Graphene.waitGui;

public class ProductDetails {
    @FindBy(css = "div.span2 li .thumbnail a")
    private List<Thumbnail> thumbnails;

    @FindBy(css = "div.span3 div.span12 .pull-right input:nth-of-type(2)")
    private WebElement chat;

    @FindBy(css = "div.span3 div.span12 .btn-info")
    private WebElement email;

    @FindBy(css = "div.span10 .well")
    private WebElement description;

    @FindBy(css = "div.well > div > a")
    private WebElement readMore;

    @FindBy(css = ".well div:nth-of-type(2) div div:nth-of-type(2) div a")
    private WebElement psychicProfile;

    @FindBy(css ="#returnPolicyModal div button")
    private WebElement policyBoxCloseButton;

    @FindBy(css = "div.span3 .addToCart")
    private WebElement addToCart;

    @FindBy(css = "div.span3 .quantity")
    private WebElement quantity;

    @FindBy(id = "offlineModal")
    private WebElement popUp;

    @FindBy(css = ".rf-ntf-sum")
    private WebElement wrongQuantityModal;

    @FindBy(css = "div.span3 .paddingTop10")
    private WebElement availableProducts;

    @FindBy(css = "div.span3 div.row-fluid h4")
    private WebElement price;

    @FindBy(css= "div.span3 div.span12 p")
    private WebElement countryOfSeller;

    @FindBy(css= "div.span3 .status")
    private WebElement status;

    @FindBy(css = "div.span3 div.span12 .heading")
    private WebElement name;

    @FindBy(id = "returnPolicyModal")
    private WebElement returnPolicyModal;

    @FindBy(id = "btnagree")
    private WebElement agreeFreeChatBtn;

    @FindBy(id = "btndisagree")
    private WebElement disagreeFreeChatBtn;

    @FindBy(css= "#returnPolicyModal div:nth-of-type(1) h3")
    private WebElement policyModalHeader;

    @FindBy(css = "#returnPolicyModal button.close")
    private WebElement quitPolicyModal;

    @FindBy(css ="#pendingModal div h3")
    private WebElement chatForFreeClicked;

    @FindBy(id ="pendingModal")
    private WebElement pendingModal;

    @FindBy(css = "#outOfCreditsModal div:nth-of-type(3) form input:nth-of-type(2)")
    private WebElement buyMoreCreditsBtn;

    @FindBy(css = "#chargingInfoModal div:nth-of-type(3) form input:nth-of-type(2)")
    private WebElement chatForFreeButton;

    @FindBy(id = "chargingInfoModal")
    private WebElement chargingInfoModal;

    public boolean isPendingModalVisible(){
        return pendingModal.isDisplayed();
    }
    public void clickChatForFreeButton(){
        waitGui().until().element(chatForFreeButton).is().visible();
        guardXhr(chatForFreeButton).click();
    }
    public String getCharForFreeClickedText(){
        waitGui().until().element(pendingModal).is().visible();
        return chatForFreeClicked.getText();
    }

    public String getWrongQuantityModal(){
        return wrongQuantityModal.getText();
    }
    public void clickBuyMoreCreditsBtn(){
        waitGui().until().element(buyMoreCreditsBtn).is().visible();
        buyMoreCreditsBtn.click();
    }
    public String getPolicyModalHeader(){
        return policyModalHeader.getText();
    }

    public boolean isPolicyModalVisible(){
        return returnPolicyModal.isEnabled();
    }

    public String getModalPolicyText(){
        return returnPolicyModal.getText();
    }
    public void clickQuitPolicyModal(){
       waitGui().until().element(quitPolicyModal).is().visible();
       quitPolicyModal.click();
    }

    public WebElement getAgreeFreeChatBtn(){
        return agreeFreeChatBtn;
    }

    public void clickPsychicProfile(){
        guardHttp(psychicProfile).click();
    }

    public boolean isPopUpVisible(){
        if(popUp.getText() != "")
            return true;
        else
            return false;
    }

    String getCountryOfSeller(){
        return countryOfSeller.getText();
    }

    public boolean statusOnline()
    {
        String actualStatus = status.getText();

        if(actualStatus.equals("Online"))
            return true;
        else
            return false;
    }
    public String getPrice()
    {
        return price.getText();
    }
    public void readMoreClick()
    {
        guardXhr(readMore).click();
    }
    public void emailClick()
    {
        guardHttp(email).click();
    }
    public void chatClick()
    {
        waitGui().until().element(chat).is().visible();
        chat.click();
    }
    public int getThumbnailsSize()
    {
        return thumbnails.size();
    }
    public String getName()
    {
        return name.getText();
    }
    public String getNumberOfavailableProduct(){
        return availableProducts.getText();
    }
    public String getPopUpMessage()
    {
        return popUp.getText();
    }
    public void setInput(String string)
    {
        quantity.clear();
        quantity.sendKeys(string);
    }
    public void addToCartClick()
    {
        guardHttp(addToCart).click();
    }
    public String getDescription()
    {
        return description.getText();
    }
    public void policyBoxCloseButtonClick()
    {
        guardHttp(policyBoxCloseButton).click();
    }

    public Thumbnail getThumbnail(int thumbnailId){
        return thumbnails.get(thumbnailId);
    }


    public static class Thumbnail{

        @FindBy(tagName = "img")
        private WebElement image;

        public String getImgUrl()
        {
            return image.getAttribute("src");
        }

        public String getUrl()
        {
            return image.getAttribute("href");
        }

        public void clickThumbnail()
        {
            image.click();
        }
    }

}
