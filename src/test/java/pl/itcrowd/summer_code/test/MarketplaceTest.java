package pl.itcrowd.summer_code.test;

import org.jboss.arquillian.drone.api.annotation.Drone;
import org.jboss.arquillian.graphene.spi.annotations.Page;
import org.jboss.arquillian.junit.Arquillian;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import static com.thoughtworks.selenium.SeleneseTestNgHelper.assertEquals;

@RunWith(Arquillian.class)
public class MarketplaceTest {

    @Drone
    WebDriver browser;

    @Page
    Marketplace marketplace;

    @Page
    LoginPage loginPage;

    @Before
    public void beforeTests()
    {

    }

     /**TERMS
     * Validates functionality of drop-down list called 'sort by'.
     * SCENARIO
     * Logged user has entered on a marketplace page. User chooses option 'sort by name A-Z' then clicks button 'sort by' .
     * EXPECTED
     * Thumbnails with product will be refreshed in ascending order by alphabet */
     @Test
     public void sortByAZtest(){
         //Given
         browser.navigate().to("https://itcrowd.pl/vop/login");
         loginPage.setEmailInput("customertest2@itcrowd.pl");
         loginPage.setPasswordInput("aaaaaa");
         loginPage.submitButtonClick();

         browser.navigate().to("https://itcrowd.pl/vop/shop");
         //When
         marketplace.sortAZClick();
         //Then
         assertEquals("123", marketplace.getThumbnail(0).getProductName());
         marketplace.clickLogout();

     }
     /**TERMS
     * Validates functionality of drop-down list called 'sort by'.
     * SCENARIO
     * Logged user has entered on a marketplace page. User chooses option 'sort by name Z-A' then clicks button 'sort by' .
     * EXPECTED
     * Thumbnails with product will be refreshed in descending order by alphabet */
     @Test
     public void sortByZAtest(){
         //Given
         browser.navigate().to("https://itcrowd.pl/vop/login");
         loginPage.setEmailInput("customertest2@itcrowd.pl");
         loginPage.setPasswordInput("aaaaaa");
         loginPage.submitButtonClick();

         browser.navigate().to("https://itcrowd.pl/vop/shop");
         //When
         marketplace.sortZAClick();
         //Then
         assertEquals("Test", marketplace.getThumbnail(0).getProductName());
         marketplace.clickLogout();
     }
     /**TERMS
     * Validates functionality of drop-down list called 'sort by'.
     * SCENARIO
     * Logged user has entered on a marketplace page. User chooses option 'sort by price lowest' then clicks button 'sort by' .
     * EXPECTED
     * Thumbnails with product will be refreshed in ascending order by price */
     @Test
     public void sortByPriceAscTest(){
         //Given
         browser.navigate().to("https://itcrowd.pl/vop/login");
         loginPage.setEmailInput("customertest2@itcrowd.pl");
         loginPage.setPasswordInput("aaaaaa");
         loginPage.submitButtonClick();

         browser.navigate().to("https://itcrowd.pl/vop/shop");
         //When
         marketplace.sortPriceLowestClick();
         //Then
         assertEquals("$2.00 USD", marketplace.getThumbnail(0).getProductPrice());
         marketplace.clickLogout();
     }
     /**TERMS
     * Validates functionality of drop-down list called 'sort by'.
     * SCENARIO
     * Logged user has entered on a marketplace page. User chooses option 'sort by price highest' then clicks button 'sort by' .
     * EXPECTED
     * Thumbnails with product will be refreshed in descending order by price */
     @Test
     public void sortByPriceDscTest(){
         //Given
         browser.navigate().to("https://itcrowd.pl/vop/login");
         loginPage.setEmailInput("customertest2@itcrowd.pl");
         loginPage.setPasswordInput("aaaaaa");
         loginPage.submitButtonClick();

         browser.navigate().to("https://itcrowd.pl/vop/shop");
         //When
         marketplace.sortPriceHighestClick();
         //Then
         assertEquals("$123.00 USD", marketplace.getThumbnail(0).getProductPrice());
         marketplace.clickLogout();
     }
     /**TERMS
     * Validates functionality of drop-down list called 'show'.
     * SCENARIO
     * Logged user has entered on a marketplace page. User chooses option 'show - 16' then clicks button 'show' .
     * EXPECTED
     * Marketplace page will be refreshed with maximum 16 thumbnails.  */
     @Test
     public void show16test(){
         //Given
         browser.navigate().to("https://itcrowd.pl/vop/login");
         loginPage.setEmailInput("customertest2@itcrowd.pl");
         loginPage.setPasswordInput("aaaaaa");
         loginPage.submitButtonClick();

         browser.navigate().to("https://itcrowd.pl/vop/shop");
         //When
         marketplace.show16Click();
         //Then
         assertEquals("16", marketplace.countThumbsOnTheSecondPage());
         marketplace.clickLogout();
     }
    /**TERMS
     * Validates functionality of drop-down list called 'show'.
     * SCENARIO
     * Logged user has entered on a marketplace page. User chooses option 'show - 20' then clicks button 'show' .
     * EXPECTED
     * Marketplace page will be refreshed with maximum 20 thumbnails.  */
     @Test
     public void show20test(){
         //Given
         browser.navigate().to("https://itcrowd.pl/vop/login");
         loginPage.setEmailInput("customertest2@itcrowd.pl");
         loginPage.setPasswordInput("aaaaaa");
         loginPage.submitButtonClick();

         browser.navigate().to("https://itcrowd.pl/vop/shop");
         //When
         marketplace.show20Click();
         //Then
         assertEquals("18", marketplace.countThumbsOnTheSecondPage());
         marketplace.clickLogout();
     }
    /**TERMS
     * Validates functionality of drop-down list called 'show'.
     * SCENARIO
     * Logged user has entered on a marketplace page. User chooses option 'show - 24' then clicks button 'show' .
     * EXPECTED
     * Marketplace page will be refreshed with maximum 24 thumbnails.  */
     @Test
     public void show24test(){
         //Given
         browser.navigate().to("https://itcrowd.pl/vop/login");
         loginPage.setEmailInput("customertest2@itcrowd.pl");
         loginPage.setPasswordInput("aaaaaa");
         loginPage.submitButtonClick();

         browser.navigate().to("https://itcrowd.pl/vop/shop");
         //When
         marketplace.show24Click();
         //Then
         assertEquals("18", marketplace.countThumbsOnTheSecondPage());
         marketplace.clickLogout();
     }
    /**TERMS
     * Validates a click of 'next page' button. For example 'Show by' option should by set at 16 and there is at least 17 products.
     * SCENARIO
     * Logged user has entered on a marketplace page. User clicks 'next page' button;
     * EXPECTED
     * Marketplace page will showed remaining products on next page */
    @Test
    public void nextPageTest(){
        //Given
        browser.navigate().to("https://itcrowd.pl/vop/login");
        loginPage.setEmailInput("customertest2@itcrowd.pl");
        loginPage.setPasswordInput("aaaaaa");
        loginPage.submitButtonClick();

        browser.navigate().to("https://itcrowd.pl/vop/shop");
        //When
        marketplace.show16Click();
        marketplace.nextPageButtonClick();
        //Then
        assertEquals("2",marketplace.countThumbsOnTheSecondPage());
        marketplace.clickLogout();
    }
    /**TERMS
     * Validates a click on 'number of page' button. For example 'Show by' option should by set at 16 and there is at least 17 products.
     * SCENARIO
     * Logged user has entered on a marketplace page. User clicks '2' button;
     * EXPECTED
     * Marketplace page will showed remaining products on page 2*/
    @Test
    public void numberOfpageTest(){
        //Given
        browser.navigate().to("https://itcrowd.pl/vop/login");
        loginPage.setEmailInput("customertest2@itcrowd.pl");
        loginPage.setPasswordInput("aaaaaa");
        loginPage.submitButtonClick();

        browser.navigate().to("https://itcrowd.pl/vop/shop");
        //When
        marketplace.show16Click();
        marketplace.clickSecondPageOfProductsLink();
        //Then
        assertEquals("2",marketplace.countThumbsOnTheSecondPage());
        marketplace.clickLogout();
    }
    /**TERMS
     * Validates a click on 'bath and beauty' button in 'categories' section.
     * SCENARIO
     * Logged user has entered on a marketplace page. User clicks on 'bath and beauty' button;
     * EXPECTED
     * Marketplace page will showed products  in category 'bath and beauty'*/
    @Test
    public void goTobBathAndBeautyTest(){
        //Given
        browser.navigate().to("https://itcrowd.pl/vop/login");
        loginPage.setEmailInput("customertest2@itcrowd.pl");
        loginPage.setPasswordInput("aaaaaa");
        loginPage.submitButtonClick();

        browser.navigate().to("https://itcrowd.pl/vop/shop");
        //When
        marketplace.bathAndBeautyCategoryLinkClick();
        //Then
        assertEquals("https://itcrowd.pl/vop/shop/3",browser.getCurrentUrl());
        marketplace.clickLogout();
    }
    /**TERMS
     * Validates a click on 'bath and body' button in 'categories' section.
     * SCENARIO
     * Logged user has entered on a marketplace page. User clicks on 'bath and body' button;
     * EXPECTED
     * Marketplace page will showed  products in category 'bath and body'*/
    @Test
    public void goToBathAndBodyTest(){
        //Given
        browser.navigate().to("https://itcrowd.pl/vop/login");
        loginPage.setEmailInput("customertest2@itcrowd.pl");
        loginPage.setPasswordInput("aaaaaa");
        loginPage.submitButtonClick();

        browser.navigate().to("https://itcrowd.pl/vop/shop");
        //When
        marketplace.bathBodySubcategoryLinkClick();
        //Then
        assertEquals("https://itcrowd.pl/vop/shop/6",browser.getCurrentUrl());
        marketplace.clickLogout();
    }
    /**TERMS
     * Validates a click on 'candles' button in 'categories' section.
     * SCENARIO
     * Logged user has entered on a marketplace page. User clicks on 'candles' button;
     * EXPECTED
     * Marketplace page will showed  products  in category 'candles'*/
    @Test
    public void goToCandlesClick(){
        //Given
        browser.navigate().to("https://itcrowd.pl/vop/login");
        loginPage.setEmailInput("customertest2@itcrowd.pl");
        loginPage.setPasswordInput("aaaaaa");
        loginPage.submitButtonClick();

        browser.navigate().to("https://itcrowd.pl/vop/shop");
        //When
        marketplace.candlesSubcategoryLinkClick();
        //Then
        assertEquals("https://itcrowd.pl/vop/shop/58",browser.getCurrentUrl());
        marketplace.clickLogout();
    }
    /**TERMS
     * Validates a click on 'accessories' button in 'categories' section.
     * SCENARIO
     * Logged user has entered on a marketplace page. User clicks on 'accessories' button;
     * EXPECTED
     * Marketplace page will showed products in category 'accessories'*/
    @Test
    public void goToAccessoriesTest(){
        //Given
        browser.navigate().to("https://itcrowd.pl/vop/login");
        loginPage.setEmailInput("customertest2@itcrowd.pl");
        loginPage.setPasswordInput("aaaaaa");
        loginPage.submitButtonClick();

        browser.navigate().to("https://itcrowd.pl/vop/shop");
        //When
        marketplace.accessoriesCategoryLinkClick();
        //Then
        assertEquals("https://itcrowd.pl/vop/shop/1",browser.getCurrentUrl());
        marketplace.clickLogout();
    }
    /**TERMS
     * Validates a click on 'jewelry' button in 'categories' section.
     * SCENARIO
     * Logged user has entered on a marketplace page. User clicks on 'jewelry' button;
     * EXPECTED
     * Marketplace page will showed products in category 'accessories'*/
    @Test
    public void goToJewelryTest(){
        //Given
        browser.navigate().to("https://itcrowd.pl/vop/login");
        loginPage.setEmailInput("customertest2@itcrowd.pl");
        loginPage.setPasswordInput("aaaaaa");
        loginPage.submitButtonClick();

        browser.navigate().to("https://itcrowd.pl/vop/shop");
        //When
        marketplace.jewelrySubcategoryLinkClick();
        //Then
        assertEquals("https://itcrowd.pl/vop/shop/4",browser.getCurrentUrl());
        marketplace.clickLogout();
    }
    /**TERMS
     * Validates a click on 'everything else' button in 'categories' section.
     * SCENARIO
     * Logged user has entered on a marketplace page. User clicks on 'everything else' button;
     * EXPECTED
     * Marketplace page will showed products in category 'everything else'*/
    @Test
    public void goToEverythingElseTest(){
        //Given
        browser.navigate().to("https://itcrowd.pl/vop/login");
        loginPage.setEmailInput("customertest2@itcrowd.pl");
        loginPage.setPasswordInput("aaaaaa");
        loginPage.submitButtonClick();

        browser.navigate().to("https://itcrowd.pl/vop/shop");
        //When
        marketplace.everythingElseCategoryLinkClick();
        //Then
        assertEquals("https://itcrowd.pl/vop/shop/2",browser.getCurrentUrl());
        marketplace.clickLogout();
    }
    /**TERMS
     * Validates a click on 'antique' button in 'categories' section.
     * SCENARIO
     * Logged user has entered on a marketplace page. User clicks on 'antique' button;
     * EXPECTED
     * Marketplace page will showed products in category 'antique'*/
    @Test
    public void goToAntiqueTest(){
        //Given
        browser.navigate().to("https://itcrowd.pl/vop/login");
        loginPage.setEmailInput("customertest2@itcrowd.pl");
        loginPage.setPasswordInput("aaaaaa");
        loginPage.submitButtonClick();

        browser.navigate().to("https://itcrowd.pl/vop/shop");
        //When
        marketplace.antiqueSubcategoryLinkClick();
        //Then
        assertEquals("https://itcrowd.pl/vop/shop/5",browser.getCurrentUrl());
        marketplace.clickLogout();
    }
    /**TERMS
     * Validates a click on 'books' button in 'categories' section.
     * SCENARIO
     * Logged user has entered on a marketplace page. User clicks on 'books' button;
     * EXPECTED
     * Marketplace page will showed products in category 'books'*/
    @Test
    public void goToBooksTest(){
        //Given
        browser.navigate().to("https://itcrowd.pl/vop/login");
        loginPage.setEmailInput("customertest2@itcrowd.pl");
        loginPage.setPasswordInput("aaaaaa");
        loginPage.submitButtonClick();

        browser.navigate().to("https://itcrowd.pl/vop/shop");
        //When
        marketplace.booksCategoryLinkClick();
        //Then
        assertEquals("https://itcrowd.pl/vop/shop/50",browser.getCurrentUrl());
        marketplace.clickLogout();
    }
    /**TERMS
     * Validates a click on 'e-books' button in 'categories' section.
     * SCENARIO
     * Logged user has entered on a marketplace page. User clicks on 'e-books' button;
     * EXPECTED
     * Marketplace page will showed products in category 'e-books'*/
    @Test
    public void goToEbooksTest(){
        //Given
        browser.navigate().to("https://itcrowd.pl/vop/login");
        loginPage.setEmailInput("customertest2@itcrowd.pl");
        loginPage.setPasswordInput("aaaaaa");
        loginPage.submitButtonClick();

        browser.navigate().to("https://itcrowd.pl/vop/shop");
        //When
        marketplace.eBooksSubcategoryLinkClick();
        //Then
        assertEquals("https://itcrowd.pl/vop/shop/53",browser.getCurrentUrl());
        marketplace.clickLogout();
    }
    /**TERMS
     * Validates a click on 'paper books' button in 'categories' section.
     * SCENARIO
     * Logged user has entered on a marketplace page. User clicks on 'paper books' button;
     * EXPECTED
     * Marketplace page will showed products in category 'paper books'*/
    @Test
    public void goToPaperBooksTest(){
        //Given
        browser.navigate().to("https://itcrowd.pl/vop/login");
        loginPage.setEmailInput("customertest2@itcrowd.pl");
        loginPage.setPasswordInput("aaaaaa");
        loginPage.submitButtonClick();

        browser.navigate().to("https://itcrowd.pl/vop/shop");
        //When
        marketplace.paperBooksSubcategoryLinkClick();
        //Then
        assertEquals("https://itcrowd.pl/vop/shop/54",browser.getCurrentUrl());
        marketplace.clickLogout();
    }
    /**TERMS
     * Validates a click on 'audio books' button in 'categories' section.
     * SCENARIO
     * Logged user has entered on a marketplace page. User clicks on 'audio books' button;
     * EXPECTED
     * Marketplace page will shown products in category 'audio books'*/
    @Test
    public void goToAudioBooksTest(){
        //Given
        browser.navigate().to("https://itcrowd.pl/vop/login");
        loginPage.setEmailInput("customertest2@itcrowd.pl");
        loginPage.setPasswordInput("aaaaaa");
        loginPage.submitButtonClick();

        browser.navigate().to("https://itcrowd.pl/vop/shop");
        //When
        marketplace.audioBooksSubcategoryLinkClick();
        //Then
        assertEquals("https://itcrowd.pl/vop/shop/55",browser.getCurrentUrl());
        marketplace.clickLogout();
    }
    /**TERMS
     * Validates a click on specified thumbnail icon.
     * SCENARIO
     * Logged user has entered on a marketplace page. User clicks on specified thumbnail icon.
     * EXPECTED
     * User will be redirected to page specified by thumbnail icon.*/
    @Test
    public void thumbnailTest(){
        //Given
        browser.navigate().to("https://itcrowd.pl/vop/login");
        loginPage.setEmailInput("customertest2@itcrowd.pl");
        loginPage.setPasswordInput("aaaaaa");
        loginPage.submitButtonClick();

        browser.navigate().to("https://itcrowd.pl/vop/shop");
        //When
        marketplace.getThumbnail(0).clickThumbnail();
        //Then
        assertEquals("https://itcrowd.pl/vop/product/60",browser.getCurrentUrl());
        marketplace.clickLogout();
    }
    /**TERMS
     * Validates a click on specified tag icon.
     * SCENARIO
     * Logged user has entered on a marketplace page. User clicks on specified tag icon.
     * EXPECTED
     * User will be redirected to page specified by tag.*/
    @Test
    public void tagTest(){
        //Given
        browser.navigate().to("https://itcrowd.pl/vop/login");
        loginPage.setEmailInput("customertest2@itcrowd.pl");
        loginPage.setPasswordInput("aaaaaa");
        loginPage.submitButtonClick();

        browser.navigate().to("https://itcrowd.pl/vop/shop");
        String [] urls = new String[8];
        //When
        marketplace.getTag(0).clickTag();
        urls[0] = browser.getCurrentUrl();
        browser.navigate().to("https://itcrowd.pl/vop/shop");

//        marketplace.getTag(1).clickTag();
//        urls[1] = browser.getCurrentUrl();
//        browser.navigate().to("https://itcrowd.pl/vop/shop");
//
//        marketplace.getTag(2).clickTag();
//        urls[2] = browser.getCurrentUrl();
//        browser.navigate().to("https://itcrowd.pl/vop/shop");
//
//        marketplace.getTag(3).clickTag();
//        urls[3] = browser.getCurrentUrl();
//        browser.navigate().to("https://itcrowd.pl/vop/shop");
//
//        marketplace.getTag(4).clickTag();
//        urls[4] = browser.getCurrentUrl();
//        browser.navigate().to("https://itcrowd.pl/vop/shop");
//
//        marketplace.getTag(5).clickTag();
//        urls[5] = browser.getCurrentUrl();
//        browser.navigate().to("https://itcrowd.pl/vop/shop");
//
//        marketplace.getTag(6).clickTag();
//        urls[6] = browser.getCurrentUrl();
//        browser.navigate().to("https://itcrowd.pl/vop/shop");
//
//        marketplace.getTag(7).clickTag();
//        urls[7] = browser.getCurrentUrl();
//        browser.navigate().to("https://itcrowd.pl/vop/shop");

        //Then
        assertEquals("https://itcrowd.pl/vop/shop?tagId=23", urls[0]);
//        assertEquals("https://itcrowd.pl/vop/shop?tagId=24", urls[1]);
//        assertEquals("https://itcrowd.pl/vop/shop?tagId=19", urls[2]);
//        assertEquals("https://itcrowd.pl/vop/shop?tagId=20", urls[3]);
//        assertEquals("https://itcrowd.pl/vop/shop?tagId=16", urls[4]);
//        assertEquals("https://itcrowd.pl/vop/shop?tagId=22", urls[5]);
//        assertEquals("https://itcrowd.pl/vop/shop?tagId=21", urls[6]);
//        assertEquals("https://itcrowd.pl/vop/shop?tagId=18", urls[7]);

        marketplace.clickLogout();
    }
}
