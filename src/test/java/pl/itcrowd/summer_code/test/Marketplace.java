package pl.itcrowd.summer_code.test;

import org.jboss.arquillian.graphene.enricher.findby.FindBy;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.jboss.arquillian.graphene.Graphene.waitGui;

/**
 * Created with IntelliJ IDEA.
 * User: Wybraniec
 * Date: 11.07.13
 * Time: 10:23
 * To change this template use File | Settings | File Templates.
 */
public class Marketplace {

    @FindBy(css = "#panel a img")
    private List<Thumbnail> thumbnailsAmount;

    @FindBy(css = "#panel")
    private List<Thumbnail> thumbnails;

    @FindBy(css = ".tags")
    private List<Tag> tags;

    @FindBy(css = "body.marketplace form select:nth-of-type(1) option:nth-of-type(1)")
    private WebElement sortAZ;

    @FindBy(css = "body.marketplace form select:nth-of-type(1) option:nth-of-type(2)")
    private WebElement sortZA;

    @FindBy(css = "body.marketplace form select:nth-of-type(1) option:nth-of-type(3)")
    private WebElement sortPriceLowest;

    @FindBy(css = "body.marketplace form select:nth-of-type(1) option:nth-of-type(4)")
    private WebElement sortPriceHighest;

    @FindBy(css = "body.marketplace form select:nth-of-type(2) option:nth-of-type(1)")
    private WebElement show16;

    @FindBy(css = "body.marketplace form select:nth-of-type(2) option:nth-of-type(2)")
    private WebElement show20;

    @FindBy(css = "body.marketplace form select:nth-of-type(2) option:nth-of-type(3)")
    private WebElement show24;

    @FindBy(css = "i.icon-caret-right")
    private WebElement nextPageButton;

    @FindBy(css = ".scroller span a:nth-of-type(1)")
    private WebElement secondPageOfProductsLink;

    @FindBy(css = ".well ul li:nth-of-type(2) a")
    private WebElement bathAndBeautyCategoryLink;

    @FindBy(css = ".well ul li:nth-of-type(3) a")
    private WebElement bathBodySubcategoryLink;

    @FindBy(css = ".well ul li:nth-of-type(4) a")
    private WebElement candlesSubcategoryLink;

    @FindBy(css = ".well ul li:nth-of-type(5) a")
    private WebElement accessoriesCategoryLink;

    @FindBy(css = ".well ul li:nth-of-type(6) a")
    private WebElement jewelrySubcategoryLink;

    @FindBy(css = ".well ul li:nth-of-type(7) a")
    private WebElement everythingElseCategoryLink;

    @FindBy(css = ".well ul li:nth-of-type(8) a")
    private WebElement antiqueSubcategoryLink;

    @FindBy(css = ".well ul li:nth-of-type(9) a")
    private WebElement booksCategoryLink;

    @FindBy(css = ".well ul li:nth-of-type(10) a")
    private WebElement eBooksSubcategoryLink;

    @FindBy(css = "#.well ul li:nth-of-type(11) a")
    private WebElement paperBooksSubcategoryLink;

    @FindBy(css = ".well ul li:nth-of-type(12) a")
    private WebElement audioBooksSubcategoryLink;

    @FindBy(css = "div.span12 div:nth-of-type(1) ul.nav > li:nth-of-type(7)  a.logout")
    private WebElement logout;

    @FindBy(css = "#row_16 div:nth-of-type(2) div a img")
    private WebElement row_16_thumb;

    @FindBy(css = "#row_0 div div a img")
    private WebElement row_0_thumb;

    public void clickLogout(){
        logout.click();
    }

    public void clickSecondPageOfProductsLink(){
        secondPageOfProductsLink.click();
    }

    public void audioBooksSubcategoryLinkClick(){
        audioBooksSubcategoryLink.click();
    }

    public void paperBooksSubcategoryLinkClick(){
        paperBooksSubcategoryLink.click();
    }

    public void eBooksSubcategoryLinkClick(){
        eBooksSubcategoryLink.click();
    }

    public void booksCategoryLinkClick(){
        booksCategoryLink.click();
    }

    public void antiqueSubcategoryLinkClick(){
        antiqueSubcategoryLink.click();
    }

    public void everythingElseCategoryLinkClick(){
        everythingElseCategoryLink.click();
    }

    public void jewelrySubcategoryLinkClick(){
        jewelrySubcategoryLink.click();
    }

    public void accessoriesCategoryLinkClick(){
        accessoriesCategoryLink.click();
    }

    public void candlesSubcategoryLinkClick(){
        candlesSubcategoryLink.click();
    }

    public void bathBodySubcategoryLinkClick(){
        bathBodySubcategoryLink.click();
    }

    public void bathAndBeautyCategoryLinkClick(){
        bathAndBeautyCategoryLink.click();
    }

    public void secondPageOfProductsLinkClick(){
        secondPageOfProductsLink.click();
    }

    public void nextPageButtonClick(){
        nextPageButton.click();
    }

    public void show24Click(){
        show24.click();
    }

    public void show20Click(){
        show20.click();
    }

    public void show16Click(){
        show16.click();
    }

    public void sortPriceHighestClick(){
        sortPriceHighest.click();
    }

    public void sortPriceLowestClick(){
        sortPriceLowest.click();
    }

    public void sortZAClick(){
        sortZA.click();
    }

    public void sortAZClick(){
        sortAZ.click();
    }

    public Thumbnail getThumbnail(int thumbnailId){
        return thumbnails.get(thumbnailId);
    }

    public Integer countThumbnailsAmount(){
        waitGui().until().element(row_16_thumb).is().visible();
        return thumbnailsAmount.size();
    }

    public Integer countThumbsOnTheSecondPage(){
        waitGui().until().element(row_0_thumb).is().visible();
        return thumbnailsAmount.size();
    }

    public Tag getTag(Integer id){
        return tags.get(id);
    }

    public static class Tag{

        @FindBy(className = "clearfix")
        private WebElement tagSrc;

        public void clickTag(){
            tagSrc.click();
        }
    }
    public static class Thumbnail{

        @FindBy(tagName = "img")
        private WebElement image;

        @FindBy(className = "marketplaceProductName")
        private WebElement productName;

        @FindBy(css = "#row_0 div div div:nth-of-type(2) p:nth-of-type(2)")
        private WebElement productPrice;

        public String getProductName(){
            return productName.getText();
        }

        public String getProductPrice(){
            return productPrice.getText();
        }

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
