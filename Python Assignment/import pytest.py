import PYTEST_SDET
from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC

@pytest.fixture(scope="module")
def setup():
    # Initialize Chrome WebDriver
    driver = webdriver.Chrome(executable_path="path/to/chromedriver")
    # Maximize the browser window
    driver.maximize_window()
    yield driver
    # After the test, quit the WebDriver
    driver.quit()

def test_makemytrip_search(setup):
    # Navigate to the MakeMyTrip website
    setup.get("https://www.makemytrip.com/")

    # Wait until the Flights button is clickable
    flights_button = WebDriverWait(setup, 10).until(EC.element_to_be_clickable((By.XPATH, "//li[@data-cy='menu_Flights']")))
    # Click on the Flights button
    flights_button.click()

    # Wait until the Round Trip option is clickable
    round_trip_option = WebDriverWait(setup, 10).until(EC.element_to_be_clickable((By.XPATH, "//li[contains(@class, 'rc-dropdown__option') and text()='Round Trip']")))
    # Click on the Round Trip option
    round_trip_option.click()

    # Find and enter the FROM location
    from_input = setup.find_element(By.XPATH, "//input[@id='fromCity']")
    from_input.clear()
    from_input.send_keys("HYD")
    setup.find_element(By.XPATH, "//p[text()='Hyderabad, India']").click()

    # Find and enter the TO location
    to_input = setup.find_element(By.XPATH, "//input[@id='toCity']")
    to_input.clear()
    to_input.send_keys("MAA")
    setup.find_element(By.XPATH, "//p[text()='Chennai, India']").click()

    # Find and select the departure date
    departure_date_input = setup.find_element(By.XPATH, "//input[@id='departure']")
    departure_date_input.click()
    setup.find_element(By.XPATH, "//span[text()='30']").click()  # Assuming departure date is 30th of the current month

    # Find and select the return date
    return_date_input = setup.find_element(By.XPATH, "//input[@id='return']")
    return_date_input.click()
    setup.find_element(By.XPATH, "//span[text()='2']").click()  # Assuming return date is 2nd of the next month

    # Click on the Search button
    search_button = setup.find_element(By.XPATH, "//a[@class='primaryBtn font24 latoBold widgetSearchBtn ']")
    search_button.click()

    # Wait until the search page is loaded
    WebDriverWait(setup, 10).until(EC.url_contains("flights/search"))

    # Verify the search page is displayed as expected
    assert "Flights Search Results" in setup.title
