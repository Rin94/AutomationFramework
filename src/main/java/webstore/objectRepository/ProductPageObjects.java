package webstore.objectRepository;

public class ProductPageObjects {
	
	public static final String XPATH_TXT_PRODUCT_NAMES = "//div[contains(@class,'mb-3')]//b";
	public static final String XPATH_BTN_ADD_SHOPPING_CART = "//b[text()='replace']/parent::h5/parent::div//button//i[contains(@class,'shopping')]";
	public static final String XPATH_TXT_ADDED_TO_CART_MESSAGE = "//div[contains(text(),'Product Added To Cart')]";
	public static final String CSS_ADD_TO_CART = ".card-body button: last-of-type";
	

}
