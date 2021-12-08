package com.yatra.utils;

public class LocatorFetcher {

	public String myAccountButton(String indexValue, String value) {
		return "//*[@id='userLoginBlock']/a";
	}

	public String emailLogin(String indexValue, String value) {
		return "//*[@id='login-input']";
	}

	public String password(String indexValue, String value) {
		return "//*[@id='login-password']";
	}

	public String loginSubmitButton(String indexValue, String value) {
		return "//*[@id='login-submit-btn']";
	}

	public String errorMsg(String indexValue, String value) {
		return "//*[@id='login-error']";
	}

	public String continueButton(String indexValue, String value) {
		return "//*[@id='login-continue-btn']";
	}

	public String loginButton(String indexValue, String value) {
		return "//*[@id='signInBtn']";
	}

	public String mobileNo(String indexValue, String value) {
		return "//*[@id='signup-mobile-number']";
	}

	public String setPassword(String indexValue, String value) {
		return "//*[@id='signup-password']";
	}

	public String userDesignation(String indexValue, String value) {
		return "//*[@id='signup-user-designation']";
	}

	public String firstNameSignUp(String indexValue, String value) {
		return "//*[@id='signup-user-first-name']";
	}

	public String lastNameSignUp(String indexValue, String value) {
		return "//*[@id='signup-user-last-name']";
	}

	public String createAccountButton(String indexValue, String value) {
		return "//*[@id='signup-form-continue-btn']";
	}

	public String invalid_MobMsg(String indexValue, String value) {
		return "//*[@id='mobile-number-block']/p[2]";
	}

	public String invalid_PassMsg(String indexValue, String value) {
		return "//*[@id='password-block']/p[2]";
	}

	public String usingOTP(String indexValue, String value) {
		return "//*[@id='login-using-otp']";
	}

	public String inputOTP(String indexValue, String value) {
		return "//input[@id = 'otp-input']";
	}

	public String submitButtonOTP(String indexValue, String value) {
		return "//*[@id='verify-otp']";
	}

	public String invalid_OTP_Msg(String indexValue, String value) {
		return "//*[@id='otp-verification-status']";
	}

	public String signUpButton(String indexValue, String value) {
		return "//*[@id='SignUpBtn']";
	}

	public String multiCityButton(String indexValue, String value) {
		return "//*[@title = 'Multicity']";
	}

	public String roundTripButton(String indexValue, String value) {
		return "//a[@title = 'Round Trip']";
	}

	public String departCity(String indexValue, String value) {
		if (indexValue.length() == 0 || indexValue == null)
			return "//*[@id='BE_flight_origin_city']";
		else
			return "//*[@id='BE_flight_origin_city_" + indexValue + "']";
	}

	public String departDate(String indexValue, String value) {
		if (indexValue.length() == 0 || indexValue == null)
			return "//*[@id='BE_flight_origin_date']";
		else
			return "//input[@class = 'custom-date-input BE_flight_origin_date_" + indexValue + "']";
	}

	public String goingToCity(String indexValue, String value) {
		if (indexValue.length() == 0 || indexValue == null)
			return "//*[@id='BE_flight_arrival_city']";
		else
			return "//*[@id='BE_flight_arrival_city" + indexValue + "']";
	}

	public String searchFlight(String indexValue, String value) {
		return "//*[@id = 'BE_flight_flsearch_btn']";
	}

	public String travellersClass(String indexValue, String value) {
		return "//span[@class = 'txt-ellipses flight_passengerBox travellerPaxBox']";
	}

	public String addAdult(String indexValue, String value) {
		return "//*[@id=\"BE_flight_passengerBox\"]/div[1]/div[1]/div/div/span[2]";
	}

	public String checkBox(String indexValue, String value) {
		return "//div[@class = 'filter-list'] //*[@class = 'ico ico-checkbox']";
	}
	
	public String noFlights(String indexValue, String value) {
		return "//*[contains(text(),'Sorry, There were no flights found for this route and date combination.')]";
	}

	public String stops(String indexValue, String value) {
		if (indexValue.equals("0")) {
			return "//div[@class = 'container full-width i-b'] /label[1]";
		} else if (indexValue.equals("1")) {
			return "//div[@class = 'container full-width i-b'] /label[2]";
		} else if (indexValue.equals("2")) {
			return "//div[@class = 'container full-width i-b'] /label[3]";
		} else {
			return "";
		}

	}

	public String airlineCheckBox(String indexValue, String value) {

		return "//label[@class = 'fs-13 item pr-5 cursor-pointer'] //span[contains(text(),'" + value
				+ "')]/parent::label";
	}

	public String aircraftCheckBox(String indexValue, String value) {
		return "//label[@class = 'fs-13 item pr-5 cursor-pointer'] //span[contains(text(),'" + value
				+ "')]/parent::label";
	}

	public String secondFilter(String indexValue, String value) {
		return "//*[@id='Flight-APP']/section/section[1]/div/div[1]/div[2]/div/div[2]";
	}

	public String applyFiltersButton(String indexValue, String value) throws InterruptedException {
		Thread.sleep(1000);
		return "//*[@value = 'Apply Filters']";
	}

	public String applyFiltersButtonCheck(String indexValue, String value) {
		return "//*[contains(text(), 'No matching flights remains')]";
	}

	public String chooseFlight(String indexValue, String value) {
		return "//*[@id='Flight-APP']/section/section[2]/section[1]/div[2]/div[2]/div[" + indexValue
				+ "]/div[1]/div/div";
	}

	public String selectFlight1(String indexValue, String value) {
		return "//*[@id='Flight-APP']/section/section[2]/section[1]/div[2]/div[2]/div[1]/div[" + indexValue + "]/div";
	}

	public String selectFlight2(String indexValue, String value) {
		return "//*[@id='Flight-APP']/section/section[2]/section[1]/div[2]/div[2]/div[2]/div[" + indexValue + "]/div";
	}

	public String bookButton(String indexValue, String value) {
		return "//button[@autom = 'booknow']";
	}

	public String travelProtectionButton(String indexValue, String value) {
		return "//input[@value = 'Add Travel Protection & Continue']";
	}

	public String emailId(String indexValue, String value) {
		return "//*[@id='additionalContactEmail']";
	}

	public String mobileNumber(String indexValue, String value) {
		return "//*[@id='additionalContactMobile']";
	}

	public String titleDropDown(String indexValue, String value) {
		return "//*[@id='title" + indexValue + "']";
	}

	public String titleMr(String indexValue, String value) {
		return "//*[@id='title" + indexValue + "']/option[2]";
	}

	public String titleMrs(String indexValue, String value) {
		return "//*[@id='title" + indexValue + "']/option[3]";
	}

	public String titleMs(String indexValue, String value) {
		return "//*[@id='title" + indexValue + "']/option[4]";
	}

	public String firstName(String indexValue, String value) {
		return "//*[@id='travellerf" + indexValue + "']";
	}

	public String lastName(String indexValue, String value) {
		return "//*[@id='travellerl" + indexValue + "']";
	}

	public String addGstButton(String indexValue, String value) {
		return "//span[@autom = 'addGstBtn']";
	}

	public String gstNumber(String indexValue, String value) {
		return "//*[@id='elem1']";
	}

	public String gstCompanyName(String indexValue, String value) {
		return "//*[@id='elem2']";
	}

	public String moreFilters(String indexValue, String value) throws InterruptedException {
		Thread.sleep(3000);
		return "//span[contains(text(),'More Filters ')]";
	}

	public String departTime(String indexValue, String value) {
		if (value.equals("00-06"))
			return "//div[@class = ' pt-12 dtime font-lightgrey']/label[1]";
		else if (value.equals("06-12"))
			return "//div[@class = ' pt-12 dtime font-lightgrey']/label[2]";
		else if (value.equals("12-18"))
			return "//div[@class = ' pt-12 dtime font-lightgrey']/label[3]";
		else if (value.equals("18-00"))
			return "//div[@class = ' pt-12 dtime font-lightgrey']/label[4]";
		else
			return "//div[@class = ' pt-12 dtime font-lightgrey']/label[1]";
	}

	public String gstEmailId(String indexValue, String value) {
		return "//*[@id='elem3']";
	}

	public String gstMobileNumber(String indexValue, String value) {
		return "//*[@id='elem9']";
	}

	public String gstAddress(String indexValue, String value) {
		return "//*[@id='gstCompanyAddress']";
	}

	public String gstCity(String indexValue, String value) {
		return "//*[@id='gstCity']";
	}

	public String gstPinCode(String indexValue, String value) {
		return "//*[@id='gstPinCode']";
	}

	public String gstState(String indexValue, String value) {
		return "//*[@id='gstState']";
	}

	public String addGstSubmitButton(String indexValue, String value) {
		return "//*[@id='gstForm']/div[1]/div/div[2]/div/div[11]/button[1]";
	}

	public String proceedToPaymentButton(String indexValue, String value) {
		return "//button[@autom = 'proceedTopayment']";
	}

	public String citySearch(String indexValue, String value) {
		return "//*[contains(text(),'No match found for the search')]";
	}
		
}
