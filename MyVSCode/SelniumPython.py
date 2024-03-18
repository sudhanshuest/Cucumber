from selenium import webdriver
from selenium.webdriver.common.by import By
from webdriver_manager.chrome import ChromeDriverManager
from selenium.webdriver.chrome.service import Service as ChromeService
from selenium.webdriver.support.wait import WebDriverWait
from telnetlib import EC


checkboxElementValue="Checkboxes"
checkbox_locator1="//*[@id='checkboxes']/input[2]"
checkbox_locator2="//*[@id='checkboxes']/input[1]"

def is_checkbox_selected(driver, checkbox_locator):
   """
   Check if a checkbox is selected.

   Args:
       driver: WebDriver instance.
       checkbox_locator: Locator of the checkbox element.

   Returns:
       bool: True if the checkbox is selected, False otherwise.
   """
   try:
      checkbox = WebDriverWait(driver, 10).until(
         EC.presence_of_element_located(checkbox_locator)
      )
      return checkbox.is_selected()
   except:
      return False  # Return False if checkbox is not found or any error occurs

driver=None

def test_1():
 global driver

driver = webdriver.Chrome(service=ChromeService(ChromeDriverManager().install()))
driver.maximize_window()
driver.get("http://the-internet.herokuapp.com/")
element = driver.find_element(By.LINK_TEXT, "Checkboxes")
element.click()

expectedCheckbox = "Checkboxes"

element2=driver.find_element(By.XPATH, "//h3[text()='Checkboxes']").text
assert expectedCheckbox==element2

isCheckboxSelected = driver.find_element(By.XPATH, "//*[@id='checkboxes']/input[2]").is_selected()
print (isCheckboxSelected)

is_checkbox_selected(driver,checkbox_locator1);
# is_checkbox_selected(driver, checkbox_locator2);

driver.back()

element3 = driver.find_element(By.LINK_TEXT, "File Upload")
element3.click()

get_source = driver.page_source
search_text = "File Uploader"
print(search_text in get_source)

driver.find_element(By.ID, "file-upload").send_keys("C://Users/Sudhanshu/OneDrive/Desktop/Superman.png")


elementFileSubmit = driver.find_element(By.ID, "file-submit")
elementFileSubmit.click()
print("Run Success")



