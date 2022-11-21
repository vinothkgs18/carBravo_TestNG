package PageObject;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import TestBase.Base;

public class POJO_CarBravo_Buying_and_Selling_Used_Cars_a_Brand_New_Way extends Base {
	
	public POJO_CarBravo_Buying_and_Selling_Used_Cars_a_Brand_New_Way() {
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath ="//button/div[1]")
	private WebElement menu;
	
	@FindBy(xpath = "//a[@style='max-width: 29.6rem;']")
	private WebElement banner;
	
	@FindBy(xpath="//a[contains(text(),'Sign In')]")
	private WebElement signinLink;
	
	
	@FindBy(xpath="//input[@id='logonIdentifier']")
	private WebElement userName;
	
	@FindBy(xpath="//input[@id='password']")
	private WebElement password;
	
	@FindBy(xpath="//button[@id='next']")
	private WebElement signButton;
	
	@FindBy(xpath="//header/div[1]/nav[1]/a[1]")
	private WebElement searchCar;
	
	@FindBy(xpath="//p[@class='tss-pew8se-typoColor MuiTypography-root MuiTypography-body-2-regular css-wwz3i7']")
	private List<WebElement>menuBars;
	
	@FindBy(xpath="//h6[@class='tss-pew8se-typoColor text-left MuiTypography-root MuiTypography-heading-6-bold css-w2ltlm']")
	private List<WebElement>listOfBodyTypes;
	
	@FindBy(xpath="//p[@class='tss-pew8se-typoColor MuiTypography-root MuiTypography-caption-bold css-1c04j9s']//preceding-sibling::p")
	private WebElement count;
	
	@FindBy(xpath="//p[text()='Clear']")
	private WebElement clearButton;
	
	@FindBy(xpath="//p[contains(text(),'Apply')]")
	private WebElement applyButton;
	
	@FindBy(xpath="//div/h6[@class='tss-pew8se-typoColor MuiTypography-root MuiTypography-heading-6-bold css-w2ltlm']")
	private WebElement totalVechileCount;
	
	
	@FindBy(xpath="//body/div[@id='__next']/div[1]/div[3]/div[1]/div[1]/main[1]/div[1]/div[1]/div[2]/div[2]/div[1]/span[1]/div[1]/p[1]")
	private WebElement filtersResultinBody;
	
	
	//Pricefiters
	
	@FindBy(xpath="//input[@name='price range']")
	private List<WebElement>priceRangeTextBox;
	
	@FindBy(xpath="//input[@aria-orientation='horizontal']")
	private List<WebElement>sliderIcons;
	

	@FindBy(xpath="//button[@class='tss-bzarop-root flex-1 stat-button-link MuiButton-root MuiButton-outlined MuiButton-outlinedPrimary MuiButton-sizeSmall MuiButton-outlinedSizeSmall MuiButton-disableElevation MuiButtonBase-root  css-14pvd']")
	private WebElement clearbuttonsforprice;
	
	//payment filters
	
	@FindBy(xpath="//h5[contains(text(),'Payment')]")
	private WebElement paymentTab;
	
	@FindBy(xpath="//input[@name='downpayment']")
	private WebElement downPaymentElementTextBox;
	
	@FindBy(xpath="//input[@aria-orientation='horizontal']")
	private List<WebElement>paymentSlidersIcon;
	
	@FindBy(xpath="//input[@name='monthly payment']")
	private WebElement monthlyPamentTextbox;
	
	@FindBy(xpath="//button[@class='tss-bzarop-root flex-1 stat-button-link MuiButton-root MuiButton-outlined MuiButton-outlinedPrimary MuiButton-sizeSmall MuiButton-outlinedSizeSmall MuiButton-disableElevation MuiButtonBase-root  css-14pvd']//p[@class='tss-wnuj9e-typoColor-typography MuiTypography-root MuiTypography-cta-small-bold css-w2ltlm']")
	private WebElement paymentClearButton;
	
	@FindBy(xpath="//body/div[@id='__next']/div[1]/div[3]/div[1]/div[1]/main[1]/div[1]/div[1]/div[2]/div[2]/div[2]/span[1]/div[1]/p[1]")
	private WebElement downpaymentresult;
	
	//Make and Model
	
	@FindBy(xpath="//div[@class='MuiInputAdornment-root MuiInputAdornment-positionStart MuiInputAdornment-outlined MuiInputAdornment-sizeMedium css-1a6giau']/following-sibling::input")
	private WebElement searchBar;
	
	@FindBy(xpath="//li[@role='menuitem']//p[@class='tss-1ctpi9q-typoColor MuiTypography-root MuiTypography-body-2-regular css-wwz3i7']")
	private List<WebElement> makelist;
	
	@FindBy(xpath="//input[@class='stat-checkbox css-1m9pwf3']")
	private List<WebElement> modelList;
	
	@FindBy(xpath="//p[@class='tss-pew8se-typoColor MuiTypography-root MuiTypography-caption-bold css-1c04j9s']/preceding-sibling::p")
	private WebElement countForModelMake;
	
	@FindBy(xpath="//p[text()='Select All']")
	private WebElement selectAll;
	
	//Filters_Performance
	@FindBy(xpath="//p[@class='max-w-[14.4rem] tss-1n5s3c0-typoColor-checkboxLabel MuiTypography-root MuiTypography-body-2-regular css-wwz3i7']")
	private List<WebElement> allValueForPerformanceFilters;
	
	@FindBy(xpath="//input[@aria-orientation='horizontal']")
	private List<WebElement> sliderFuelEcnomic;
	
	@FindBy(xpath="//div[@class='flex flex-wrap gap-2']//child::p[@class='tss-pew8se-typoColor MuiTypography-root MuiTypography-caption-regular css-1198906']")
	private List<WebElement> ResultsForPreformanceFilters;
	
	// Filters- Feature
	
	@FindBy(xpath="//p[@class='max-w-[14.4rem] tss-1n5s3c0-typoColor-checkboxLabel MuiTypography-root MuiTypography-body-2-regular css-wwz3i7']")
	private List<WebElement> allValueForFeatureFilters;
	
	@FindBy(xpath="//div[@class='flex flex-wrap gap-2']//p[@class='tss-pew8se-typoColor MuiTypography-root MuiTypography-caption-regular css-1198906']")
	private List<WebElement>ResultsFeatureFilters;

	//More-FIlters
	
	@FindBy(xpath="//p[@class='max-w-[14.4rem] tss-1n5s3c0-typoColor-checkboxLabel MuiTypography-root MuiTypography-body-2-regular css-wwz3i7']")
	private List<WebElement> allValuesforMoreFilters;
	
	@FindBy(xpath="//span/following-sibling::p[@class='tss-pew8se-typoColor MuiTypography-root MuiTypography-body-2-regular css-wwz3i7']")
	private List<WebElement> bodyColorsAll;
	
	@FindBy(xpath="//div[@class='flex items-center gap-1']//p[@class='tss-pew8se-typoColor MuiTypography-root MuiTypography-body-2-bold css-1no7151']")
	private WebElement searchByZipAndRadios;
	
	@FindBy(xpath="//input[@class='tss-1a83kqp-textInput MuiOutlinedInput-input MuiInputBase-input MuiInputBase-inputAdornedEnd css-w1jawv']")
	private WebElement zipCodeTextBox;
	
	@FindBy(xpath="//span[@class='tss-937v7o-thumb MuiSlider-thumbColorPrimary MuiSlider-thumbSizeMedium MuiSlider-thumb css-7cwun8']")
	private WebElement radiusSliderSource;
	
	@FindBy(xpath="//div[@class='w-full flex flex-col gap-2 animate-fade-slow max-w-full vehicleList_vehicleTile___MAFO automation-vehicle-tile-section stat-image-link tss-u7yb2h-boxStyle-animationWrapper MuiBox-root css-0']")
	private List<WebElement> cardResults;
	
	@FindBy(xpath="//button[@class='tss-qi0gte-root automation-vehicle-and-dealer-details-icon-btn stat-icon-link MuiButton-root MuiButton-- MuiButton--Primary MuiButton-sizeLarge MuiButton--SizeLarge MuiButton-disableElevation MuiButtonBase-root  css-77kbcq']//span")
	private List<WebElement> listOfHartButton;
	
	@FindBy(xpath="//p[@class='tss-584bd8-typoColor automation-vehicle-and-dealer-details-vin-text MuiTypography-root MuiTypography-caption-regular css-2pdw35']")
	private List<WebElement> vinList;
	
	@FindBy(xpath="//button[@class='tss-qi0gte-root stat-icon-link MuiButton-root MuiButton-- MuiButton--Primary MuiButton-sizeLarge MuiButton--SizeLarge MuiButton-disableElevation MuiButtonBase-root  css-77kbcq']//span")
	private WebElement headerWishListIcon;
	
	@FindBy(xpath="//p[@class='tss-584bd8-typoColor MuiTypography-root MuiTypography-caption-regular css-2pdw35']")
	private WebElement favVin;
	
	@FindBy(xpath="//div[@class='flex py-4 w-full justify-center']//button")
	private WebElement saveFavoritesButton;
	
	@FindBy(xpath="//p[@class='tss-584bd8-typoColor automation-vehicle-and-dealer-details-vin-text MuiTypography-root MuiTypography-caption-regular mui-2pdw35']")
	private List<WebElement>winListOfMyAccount;
	
	
	//-----------------------------------------------------------------------------------------------------------------------------

	public WebElement getMenu() {
		return menu;
	}

	public WebElement getBanner() {
		return banner;
	}

	public WebElement getSigninLink() {
		return signinLink;
	}

	public WebElement getUserName() {
		return userName;
	}

	public WebElement getPassword() {
		return password;
	}

	public WebElement getSignButton() {
		return signButton;
	}

	public WebElement getSearchCar() {
		return searchCar;
	}

	public List<WebElement> getMenuBars() {
		return menuBars;
	}

	public List<WebElement> getListOfBodyTypes() {
		return listOfBodyTypes;

	}

	public WebElement getCount() {
		return count;
	}

	public WebElement getClearButton() {
		return clearButton;
	}

	public WebElement getApplyButton() {
		return applyButton;
	}

	public WebElement getTotalVechileCount() {
		return totalVechileCount;
	}
	
	//Price and Payment filters

	public WebElement getfiltersResultinBody() {
		return filtersResultinBody;
	}

	public List<WebElement> getPriceRangeTextBox() {
		return priceRangeTextBox;
	}

	public List<WebElement> getSliderIcons() {
		return sliderIcons;
	}

	public WebElement getClearbuttonsforprice() {
		return clearbuttonsforprice;
	}

	public WebElement getFiltersResultinBody() {
		return filtersResultinBody;
	}

	public WebElement getPaymentTab() {
		return paymentTab;
	}

	public WebElement getDownPaymentElementTextBox() {
		return downPaymentElementTextBox;
	}

	public List<WebElement> getPaymentSlidersIcon() {
		return paymentSlidersIcon;
	}

	public WebElement getMonthlyPamentTextbox() {
		return monthlyPamentTextbox;
	}

	public WebElement getPaymentClearButton() {
		return paymentClearButton;
	}

	public WebElement getDownpaymentresult() {
		return downpaymentresult;
	}
	//Make and Model

	public WebElement getSearchBar() {
		return searchBar;
	}

	public List<WebElement> getMakelist() {
		return makelist;
	}

	public List<WebElement> getModelList() {
		return modelList;
	}

	public WebElement getCountForModelMake() {
		return countForModelMake;
	}

	public WebElement getSelectAll() {
		return selectAll;
	}

	public List<WebElement> getAllValueForPerformanceFilters() {
		return allValueForPerformanceFilters;
	}

	public List<WebElement> getSliderFuelEcnomic() {
		return sliderFuelEcnomic;
	}

	public List<WebElement> getResultsForPreformanceFilters() {
		return ResultsForPreformanceFilters;
	}

	// Filters- Feature
	public List<WebElement> getAllValueForFeatureFilters() {
		return allValueForFeatureFilters;
	}

	public List<WebElement> getResultsFeatureFilters() {
		return ResultsFeatureFilters;
	}

	public List<WebElement> getAllValuesforMoreFilters() {
		return allValuesforMoreFilters;
	}

	public List<WebElement> getBodyColorsAll() {
		return bodyColorsAll;
	}

	public WebElement getSearchByZipAndRadios() {
		return searchByZipAndRadios;
	}

	public WebElement getZipCodeTextBox() {
		return zipCodeTextBox;
	}

	public WebElement getRadiusSliderSource() {
		return radiusSliderSource;
	}

	public List<WebElement> getCardResults() {
		return cardResults;
	}

	public List<WebElement> getListOfHartButton() {
		return listOfHartButton;
	}

	public List<WebElement> getVinList() {
		return vinList;
	}

	public WebElement getHeaderWishListIcon() {
		return headerWishListIcon;
	}

	public WebElement getFavVin() {
		return favVin;
	}

	public WebElement getSaveFavoritesButton() {
		return saveFavoritesButton;
	}

	public List<WebElement> getWinListOfMyAccount() {
		return winListOfMyAccount;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
