from selenium import webdriver
from selenium.webdriver.common.by import By
from webdriver_manager import ChromeDriverManager
driver=webdriver.Chrome(ChromeDriverManager().install())
driver.maximize_window()
driver.get("http://the-internet.herokuapp.com/")
element = driver.find_element(By.LINK_TEXT, "Checkboxes")
element.click()

actual=driver.find_element(By.XPATH, "//*[@id="content"]/div/h3")

expected="Checkboxes"

Assert.assertEquals(actual,expected)





def is_checkbox_selected(driver, checkbox_selector):
    """
    Check if a checkbox is selected.

    Parameters:
    - driver: Selenium WebDriver instance.
    - checkbox_selector: Locator for the checkbox (e.g., By.ID, By.XPATH, By.NAME, etc.).

    Returns:
    - True if the checkbox is selected, False otherwise.
    """
    try:
        checkbox = driver.find_element(checkbox_selector)
        return checkbox.is_selected()
    except Exception as e:
        print(f"An error occurred: {e}")
        return False

def validate_checkbox_selected(driver, checkbox_selector):
    """
    Validate if a checkbox is selected. Raises an AssertionError if not.

    Parameters:
    - driver: Selenium WebDriver instance.
    - checkbox_selector: Locator for the checkbox (e.g., By.ID, By.XPATH, By.NAME, etc.).

    Raises:
    - AssertionError if the checkbox is not selected.
    """
    assert is_checkbox_selected(driver, checkbox_selector), f"Checkbox {checkbox_selector} is not selected."

def validate_checkbox_not_selected(driver, checkbox_selector):
    """
    Validate if a checkbox is not selected. Raises an AssertionError if it is selected.

    Parameters:
    - driver: Selenium WebDriver instance.
    - checkbox_selector: Locator for the checkbox (e.g., By.ID, By.XPATH, By.NAME, etc.).

    Raises:
    - AssertionError if the checkbox is selected.
    """
    assert not is_checkbox_selected(driver, checkbox_selector), f"Checkbox {checkbox_selector} is selected."




# Checkbox selector (change it according to your HTML structure)
checkbox_selector = By.ID, " checkbox 2"

# Validate if the checkbox is selected
validate_checkbox_selected(driver, checkbox_selector)

# Perform some actions...

# Validate if the checkbox is not selected
validate_checkbox_not_selected(driver, checkbox_selector)


driver.navigate().back();

element = driver.find_element(By.LINK_TEXT, "File Upload")
element.click()

get_source = driver.page_source
search_text = "File Uploader"
print(search_text in get_source)

element = driver.find_element(By.ID, "file-upload")
element.click()

element = driver.find_element(By.ID, "file-submit")
element.click()




