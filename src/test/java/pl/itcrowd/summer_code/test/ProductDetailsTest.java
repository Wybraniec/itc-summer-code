package pl.itcrowd.summer_code.test;

import org.jboss.arquillian.drone.api.annotation.Drone;
import org.jboss.arquillian.graphene.spi.annotations.Page;
import org.jboss.arquillian.junit.Arquillian;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import static junit.framework.Assert.*;


@RunWith(Arquillian.class)
public class ProductDetailsTest {

    @Drone
    WebDriver browser;

    @Page
    ProductDetails productDetails;

    @Page
    LoginPage loginPage;

    @Before
    public void beforeTests()
    {}

    /**TERMS
     * Test check if product name is displayed
     *
     * SCENARIO
     * 1.Open the product page (for example https://itcrowd.pl/vop/product/64)
     * EXPECTED
     *
     * Check if product name is displayed (for example "atest3")
     */
    @ Test
    public void productNameTest(){
        //Given
        browser.navigate().to("https://itcrowd.pl/vop/product/64");
        //When

        //Then
        assertEquals("atest3", productDetails.getName());
    }

    /**TERMS
     * Test check if product description is displayed
     *
     * SCENARIO
     * 1.Open the product page (for example https://itcrowd.pl/vop/product/64)
     * EXPECTED
     *
     * Check if product description is displayed (for example "123")
     */
    @ Test
    public void productDescriptionTest(){
        //Given
        browser.navigate().to("https://itcrowd.pl/vop/product/64");
        //When

        //Then
        assertEquals("atest3 atest3", productDetails.getDescription());
    }

    /**TERMS
     * Test check if image box is displayed after click on product image.
     *
     * SCENARIO
     * 1.Open the product page (for example https://itcrowd.pl/vop/product/64).
     * 2.Check if product image is displayed (some products don't have images).
     * 3.Click on product image.
     *
     * EXPECTED
     * Check if image box is displayed.
     */
    @ Test
    public void productImageClickTest(){
        //Given
        browser.navigate().to("https://itcrowd.pl/vop/product/64");
        //When
        String imgUrl = productDetails.getThumbnail(0).getImgUrl();
        //Then
        assertEquals("https://itcrowd.pl/vop/photo?id=27", imgUrl);
    }

    /**TERMS
     * Test check if click on thumbnail of product enlarges current thumbnail.
     *
     * SCENARIO
     * 1.Open the product page (for example https://itcrowd.pl/vop/product/56).
     * 2.Click on the second thumbnail in the list on the right side of large image.
     * EXPECTED
     *
     * Check if clicked thumbnail is enlarged.
     */
    @ Test
    public void productThumbnailClickTest(){
        //Given
        browser.navigate().to("https://itcrowd.pl/vop/product/65");
        //When
        productDetails.getThumbnail(1).clickThumbnail();
        String imgUrl = productDetails.getThumbnail(1).getImgUrl();
        //Then
        assertEquals("https://itcrowd.pl/vop/photo?id=29", imgUrl);
    }

    /**TERMS
     * Test checks if sellers nickname is displayed.
     *
     * SCENARIO
     * 1.Open the product page (for example https://itcrowd.pl/vop/product/64).
     *
     * EXPECTED
     * Check if sellers nickname is displayed (for example "Psychic4").
     */
    @ Test
    public void sellerNickNameTest(){
        //Given
        browser.navigate().to("https://itcrowd.pl/vop/product/64");
        //When
        String sellerName = productDetails.getName();
        String emptyString = "";
        //Then
        assertFalse(emptyString.equals(sellerName));
    }

    /**TERMS
     * Test checks if sellers status is correct.
     *
     * SCENARIO
     * 1.Set seller status as Online/Offline.
     * 2.Open Product Details page of the seller product.
     *
     * EXPECTED
     * Check if sellers status is displayed as Online/Offline.
     */
    @ Test
    public void sellerStatusTest(){
        //Given
        browser.navigate().to("https://itcrowd.pl/vop/product/64");
        boolean status =  productDetails.statusOnline();
        //When

        //Then
        assertFalse(status);
    }

    /**TERMS
     * Test checks if country of seller is displayed.
     *
     * SCENARIO
     * 1.Open the product page (for example https://itcrowd.pl/vop/product/64).
     *
     * EXPECTED
     * Check if country of seller is displayed.
     */
    @ Test
    public void sellerCountryTest(){
        //Given
        browser.navigate().to("https://itcrowd.pl/vop/product/64");
        //When
        String emptyString = "";
        //Then
        assertFalse(emptyString.equals(productDetails.getCountryOfSeller()));

    }

    /**TERMS
     * Test checks if click on "Click to Psychic profile" redirect to seller profile page.
     *
     * SCENARIO
     * 1.Open the product page (for example https://itcrowd.pl/vop/product/64).
     *
     * EXPECTED
     * Check if current url points to seller profile page.
     */
    @ Test
    public void ClickToPsychicProfileCLickTest(){
        //Given
        //User must be logout
        browser.navigate().to("https://itcrowd.pl/vop/product/64");
        //When
        productDetails.clickPsychicProfile();
        //Then
        assertEquals("https://itcrowd.pl/vop/atest3", browser.getCurrentUrl());
    }

    /**TERMS
     * Test checks if click on Email button redirect to page where user can write an email to seller.
     *
     * SCENARIO
     * 1.Open the product page (for example https://itcrowd.pl/vop/product/64).
     * 2.Click on the Email button.
     *
     * EXPECTED
     * Check if current url points to https://itcrowd.pl/vop/private/createMessage?userId=<USER_ID>.
     */
    @ Test
    public void emailCLickTest(){
        //Given
        browser.navigate().to("https://itcrowd.pl/vop/product/64");
        //When
        productDetails.emailClick();
        //Then
        assertTrue(browser.getCurrentUrl().startsWith("https://itcrowd.pl/vop/private/createMessage"));
    }

    /**TERMS
     * Test checks if click on Chat button by not logged user redirect to login page
     *
     * SCENARIO
     * 1.Open the product page (for example https://itcrowd.pl/vop/product/64).
     * 2.Click on the Chat button.
     *
     * EXPECTED
     * Check if current url points to login page.
     */
    @ Test
    public void ChatClickByNotLoggedUserTest(){
        //Given
        browser.navigate().to("https://itcrowd.pl/vop/product/64");
        //When
        productDetails.chatClick();
        //Then
        assertTrue(browser.getCurrentUrl().startsWith("https://itcrowd.pl/vop/login"));
    }

    /**TERMS
     * Test checks if click on Chat button by logged user opens Dialog Box.
     *
     * SCENARIO
     * 1.Log in as some user (for example testacc@itcrowd.pl:testacc).
     * 2.Open the product page (for example https://itcrowd.pl/vop/product/64).
     * 3.Click on the Chat button.
     *
     * EXPECTED
     * Check if Dialog Box is displayed.
     */
    @ Test
    public void ChatClickBytLoggedUserTest(){
        //Given
        browser.navigate().to("https://itcrowd.pl/vop/login");
        loginPage.setEmailInput("customertest2@itcrowd.pl");
        loginPage.setPasswordInput("aaaaaa");
        loginPage.submitButtonClick();

        browser.navigate().to("https://itcrowd.pl/vop/product/64");
        //When
        productDetails.chatClick();
        //Then
        assertTrue(productDetails.isPopUpVisible());
    }

    /**TERMS
     * Test if user can click on Chat for free in Chat Dialog Box.
     *
     * SCENARIO
     * 1.Log in as user (for example testacc@itcrowd.pl:testacc).
     * 2.Open the product page (for example https://itcrowd.pl/vop/product/64).
     * 3.Click on the Chat button.
     * 4.Click on "Chat for free" button.
     * 5.Accept chat from invited account.
     *
     * EXPECTED
     * Check if Chat box is displayed.
     */
    @ Test
    public void chatForFreeTest(){    //TODO
        //Given
        browser.navigate().to("https://itcrowd.pl/vop/login");
        loginPage.setEmailInput("customertest2@itcrowd.pl");
        loginPage.setPasswordInput("aaaaaa");
        loginPage.submitButtonClick();

        browser.navigate().to("https://itcrowd.pl/vop/product/1");
        //When
        productDetails.chatClick();
        productDetails.clickChatForFreeButton();
        //Then
        assertTrue(productDetails.isPendingModalVisible());
    }

    /**TERMS
     * Test checks if click "Buy credits" in Chat Dialog Box redirect to Buy Credits page.
     *
     * SCENARIO
     * 1.Log in as some user (for example testacc@itcrowd.pl:testacc).
     * 2.Open the product page (for example https://itcrowd.pl/vop/product/64).
     * 3.Click on the Chat button.
     * 4.Click on "Buy credits"
     *
     * EXPECTED
     * Check if current url is https://itcrowd.pl/vop/private/buyCredits.
     */
    @ Test
    public void ChatBuyCreditsTest(){
        //Given
        browser.navigate().to("https://itcrowd.pl/vop/login");

        loginPage.setEmailInput("customerTest1@itcrowd.pl");
        loginPage.setPasswordInput("aaaaaa");
        loginPage.submitButtonClick();

        browser.navigate().to("https://itcrowd.pl/vop/product/1");
        //When
        productDetails.chatClick();
        productDetails.clickBuyMoreCreditsBtn();
        //Then
        assertEquals("https://itcrowd.pl/vop/private/buyCredits", browser.getCurrentUrl());
    }

    /**TERMS
     * Test checks if product price is displayed.
     *
     * SCENARIO
     * 1.Open the product page (for example https://itcrowd.pl/vop/product/64).
     *
     * EXPECTED
     * Check if product price is displayed.
     */
    @ Test
    public void productPriceTest(){
        //Given
        browser.navigate().to("https://itcrowd.pl/vop/product/64");
        //When
        String emptyString = "";
        //Then
        assertFalse(emptyString.equals(productDetails.getPrice()));
    }

    /**TERMS
     * Test checks if product is available.
     *
     * SCENARIO
     * 1.Open the product page (for example https://itcrowd.pl/vop/product/56).
     *
     * EXPECTED
     * Check if there is 5 pieces available (there can be different value for other products).
     */
    @ Test
    public void productAvailabilityTest(){
        //Given
        browser.navigate().to("https://itcrowd.pl/vop/product/56");
        //When

        //Then
        assertEquals("2 available", productDetails.getNumberOfavailableProduct());
    }

    /**TERMS
     * Test checks if there is popup info displayed when click on Add to cart button without value set in input.
     *
     * SCENARIO
     * 1.Open the product page (for example https://itcrowd.pl/vop/product/56).
     * 2.Clean quantity input
     * 3.Click Add to cart button
     *
     * EXPECTED
     * Check if there is popup info with text "Wrong quantity value!" displayed.
     */
    @ Test
    public void addToCartNoQuantityTest(){
        //Given
        browser.navigate().to("https://itcrowd.pl/vop/product/56");
        //When
        productDetails.setInput("");
        productDetails.addToCartClick();
        //Then
        assertEquals("Wrong quantity value!", productDetails.getWrongQuantityModal());
    }

    /**TERMS
     * Test checks if there is popup info displayed when click on Add to cart button with to many pieces set.
     *
     * SCENARIO
     * 1.Open the product page (for example https://itcrowd.pl/vop/product/56).
     * 2.Get number of available items
     * 2.Input high value into Quantity input (for example 1000000)
     * 3.Click Add to cart button
     *
     * EXPECTED
     * Check if there is popup info with text "Desired quantity is greater than actual product quantity! You can buy max <available_items>." displayed.
     */
    @ Test
    public void addToCartToMuchQuantityTest(){
        //Given
        browser.navigate().to("https://itcrowd.pl/vop/product/56");
        //When
        Integer numberOfItems = Integer.parseInt(productDetails.getNumberOfavailableProduct().substring(0,1));
        numberOfItems++;
        productDetails.setInput(numberOfItems.toString());
        productDetails.addToCartClick();
        //Then
        assertEquals("Desired quantity is greater than actual product quantity! You can buy max 2.", productDetails.getWrongQuantityModal());
    }

    /**TERMS
     * Test checks if there is popup info displayed when click on Add to cart button with valid number of items.
     *
     * SCENARIO
     * 1.Open the product page (for example https://itcrowd.pl/vop/product/56).
     * 2.Get number of available items
     * 2.Input value <= available items into Quantity input
     * 3.Click Add to cart button
     *
     * EXPECTED
     * Check if Cart is displayed.
     */
    @ Test
    public void addToCartValidQuantityTest(){
        //Given
        browser.navigate().to("https://itcrowd.pl/vop/product/56");
        //When
        Integer numberOfItems = Integer.parseInt(productDetails.getNumberOfavailableProduct().substring(0,1));
        productDetails.setInput(numberOfItems.toString());
        productDetails.addToCartClick();
        //Then
        assertEquals("https://itcrowd.pl/vop/product/56", browser.getCurrentUrl());
    }

    /**TERMS
     * Test checks if click on Read more link opens Return Policy box
     *
     * SCENARIO
     * 1.Open the product page (for example https://itcrowd.pl/vop/product/56).
     * 2.Click on "Read more" link
     *
     * EXPECTED
     * Check if there is Return Policy box displayed.
     */
    @ Test
    public void readMoreClickTest(){
        //Given
        browser.navigate().to("https://itcrowd.pl/vop/product/56");
        //When
        productDetails.readMoreClick();
        String modalText = productDetails.getModalPolicyText();
        //Then
        assertFalse(modalText.isEmpty());
    }

    /**TERMS
     * Test checks if click close (X) Button hide Return Policy box
     *
     * SCENARIO
     * 1.Open the product page (for example https://itcrowd.pl/vop/product/56).
     * 2.Click on "Read more" link
     * 3.Click X button for close box.
     *
     * EXPECTED
     * Check if there is not Return Policy box displayed.
     */
    @ Test
    public void ReturnPolicyCloseTest(){
        //Given
        browser.navigate().to("https://itcrowd.pl/vop/product/56");
        //When
        productDetails.readMoreClick();
        productDetails.clickQuitPolicyModal();
        //Then
        assertTrue(productDetails.isPolicyModalVisible());
    }

}