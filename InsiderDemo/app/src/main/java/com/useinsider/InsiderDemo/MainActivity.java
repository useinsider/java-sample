package com.useinsider.InsiderDemo;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.useinsider.insider.ContentOptimizerDataType;
import com.useinsider.insider.Insider;
import com.useinsider.insider.InsiderEvent;
import com.useinsider.insider.InsiderGender;
import com.useinsider.insider.InsiderIdentifiers;
import com.useinsider.insider.InsiderProduct;
import com.useinsider.insider.InsiderUser;
import com.useinsider.insider.MessageCenterData;
import com.useinsider.insider.RecommendationEngine;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.Date;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = (Button) findViewById(R.id.triggerButton);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                // --- USER --- //

                // You can crete Insider User and add attributes later on it.
                InsiderUser currentUser = Insider.Instance.getCurrentUser();

                // Setting User Attributes in chainable way.
                currentUser.setName("Insider")
                        .setSurname("Demo")
                        .setAge(23)
                        .setGender(InsiderGender.OTHER)
                        .setBirthday((new Date()))
                        .setEmailOptin(true)
                        .setSMSOptin(false)
                        .setPushOptin(true)
                        .setLocationOptin(true)
                        .setFacebookID("Facebook-ID")
                        .setTwitterID("Twitter-ID")
                        .setLanguage("TR")
                        .setLocale("tr_TR");

                // Setting User Identifiers.
                InsiderIdentifiers identifiers = new InsiderIdentifiers();
                identifiers.addEmail("mobile@useinsider.com")
                        .addPhoneNumber("+901234567")
                        .addUserID("CRM-ID");

                // Login and Logout
                currentUser.login(identifiers);
                currentUser.logout();

                // Setting custom attributes.
                // MARK: Your attribute key should be all lowercase and should not include any special or non Latin characters or any space, otherwise this attribute will be ignored. You can use underscore _.
                currentUser.setCustomAttributeWithString("string_attribute", "This is Insider.");
                currentUser.setCustomAttributeWithInt("int_attribute", 10);
                currentUser.setCustomAttributeWithDouble("double_attribute", 20.5);
                currentUser.setCustomAttributeWithBoolean("bool_attribute", true);
                currentUser.setCustomAttributeWithDate("date_attribute", new Date());

                // MARK: You can only call the method with array of string otherwise this event will be ignored.
                String[] arr = {"value1", "value2", "value3"};
                Insider.Instance.getCurrentUser().setCustomAttributeWithArray("key", arr);

                // --- EVENT --- //

                // You can create an event without parameters and call the build method
                Insider.Instance.tagEvent("first_event").build();

                // You can create an event then add parameters and call the build method
                Insider.Instance.tagEvent("second_event").addParameterWithInt("int_parameter", 10).build();

                // You can create an object and add the parameters later
                InsiderEvent insiderExampleEvent = Insider.Instance.tagEvent("third_event");

                insiderExampleEvent.addParameterWithString("string_parameter", "This is Insider.")
                        .addParameterWithInt("int_parameter", 10)
                        .addParameterWithDouble("double_parameter", 10.5)
                        .addParameterWithBoolean("bool_parameter", true)
                        .addParameterWithDate("date_parameter", new Date());

                // MARK: You can only call the method with array of string otherwise this event will be ignored.
                insiderExampleEvent.addParameterWithArray("array_parameter", arr);

                // Do not forget to call build method once you are done with parameters.
                // Otherwise your event will be ignored.
                insiderExampleEvent.build();

                // --- PRODUCT --- //

                // MARK: If any parameter which is passed to this method is nil / null or an empty string, it will return an empty and invalid Insider Product Object. Note that an invalid Insider Product object will be ignored for any product related operations.
                // You can crete Insider Product and add attributes later on it.

                String[] taxonomy = {"taxonomy1", "taxonomy2", "taxonomy3"};
                InsiderProduct insiderExampleProduct = Insider.Instance.createNewProduct("productID", "productName", taxonomy, "imageURL", 1000.5, "currency");

                // Setting Product Attributes in chainable way.
                insiderExampleProduct.setColor("color")
                        .setVoucherName("voucherName")
                        .setVoucherDiscount(10.5)
                        .setPromotionName("promotionName")
                        .setPromotionDiscount(10.5)
                        .setSize("size")
                        .setSalePrice(10.5)
                        .setShippingCost(10.5)
                        .setQuantity(10)
                        .setStock(10)
                        .setInStock(true);

                // Setting custom attributes.
                // MARK: Your attribute key should be all lowercase and should not include any special or non Latin characters or any space, otherwise this attribute will be ignored. You can use underscore _.
                insiderExampleProduct.setCustomAttributeWithString("string_parameter", "This is Insider.")
                        .setCustomAttributeWithInt("int_parameter", 10)
                        .setCustomAttributeWithDouble("double_parameter", 10.5)
                        .setCustomAttributeWithBoolean("bool_parameter", true)
                        .setCustomAttributeWithDate("date_parameter", new Date());

                // MARK: You can only call the method with array of string otherwise this event will be ignored.
                insiderExampleProduct.setCustomAttributeWithArray("array_parameter", arr);

                // --- REVENUE TRACKING --- //

                Insider.Instance.itemPurchased("uniqueSaleID", insiderExampleProduct);

                // --- CART REMINDER --- //

                // Adding item to cart.
                Insider.Instance.itemAddedToCart(insiderExampleProduct);

                // Removing item from the cart.
                Insider.Instance.itemRemovedFromCart("productID");

                // Removing all the items from the cart.
                // This method will automatically triggered when you call Revenue Tracking.
                Insider.Instance.cartCleared();

                // --- RECOMMENDATION ENGINE --- //

                // ID comes from your smart recommendation campaign.
                // Please follow the language code structure. For instance tr_TR.
                Insider.Instance.getSmartRecommendation(1, "tr_TR", "TRY", new RecommendationEngine.SmartRecommendation() {
                    @Override
                    public void loadRecommendationData(JSONObject recommendation) {
                        // Handle here
                        Log.d("[INSIDER]", "[getSmartRecommendation]: " + recommendation);
                    }
                });

                Insider.Instance.getSmartRecommendationWithProduct(insiderExampleProduct, 1, "tr:TR", new RecommendationEngine.SmartRecommendation() {
                    @Override
                    public void loadRecommendationData(JSONObject recommendation) {
                        // Handle here
                        Log.d("[INSIDER]", "[getSmartRecommendationWithProduct]: " + recommendation);
                    }
                });

                // --- SOCIAL PROOF --- //

                Insider.Instance.visitProductDetailPage(insiderExampleProduct);

                // --- PAGE VISITING --- //

                Insider.Instance.visitHomePage();
                Insider.Instance.visitListingPage(taxonomy);

                InsiderProduct[] insiderExampleProducts = {insiderExampleProduct, insiderExampleProduct};
                Insider.Instance.visitCartPage(insiderExampleProducts);

                // --- GDPR --- //

                // MARK: Please note that by default our SDK is collecting the data so you don't have to call this function if you are not asking users consents.

                // MARK: If you set false, the user will not share any data or receive any push until you set back true.
                Insider.Instance.setGDPRConsent(true);

                // --- MESSAGE CENTER --- //

                Insider.Instance.getMessageCenterData(20, new Date(1546300800), new Date(), new MessageCenterData() {
                    @Override
                    public void loadMessageCenterData(JSONArray messageCenterData) {
                        // Handle here
                        Log.d("[INSIDER]", "[getMessageCenterData]: " + messageCenterData);
                    }
                });

                // --- CONTENT OPTIMIZER --- //

                // String
                String contentOptimizerString = Insider.Instance.getContentStringWithName("string_variable_name", "defaultValue", ContentOptimizerDataType.ELEMENT);
                Log.d("[INSIDER]", "[getContentStringWithName]: " + contentOptimizerString);

                // Boolean
                boolean contentOptimizerBool = Insider.Instance.getContentBoolWithName("bool_variable_name", true, ContentOptimizerDataType.ELEMENT);
                Log.d("[INSIDER]", "[getContentBoolWithName]: " + contentOptimizerBool);

                // Integer
                int contentOptimizerInt = Insider.Instance.getContentIntWithName("int_variable_name", 10, ContentOptimizerDataType.ELEMENT);
                Log.d("[INSIDER]", "[getContentIntWithName]: " + contentOptimizerInt);
            }
        });
    }
}
