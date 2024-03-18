from telnetlib import EC

import pytest
import self
from selenium.webdriver.support.wait import WebDriverWait

from Tests.test_base import BaseTest
from selenium import webdriver
from webdriver_manager.chrome import ChromeDriverManager
from selenium.webdriver.chrome.service import Service as ChromeService
from Pages.HomePage import HomePage
from Config.config import TestData
from selenium.webdriver.common.by import By


# class Home_Page(BaseTest):


# def test_HomePage(self):
#    driver = webdriver.Chrome(service=ChromeService(ChromeDriverManager().install()))
#    self.homePage = HomePage(self.driver)
#
#    self.homePage.do_click(self, TestData.Checkboxes)
#
#    self.homePage = HomePage(self.driver)
#    self.clickCheckbox()

checkboxElementValue="Checkboxes"
checkbox_locator1=(By.XPATH,"//*[@id='checkboxes']/input[2]")
checkbox_locator2=(By.XPATH,"//*[@id='checkboxes']/input[1]")

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
@pytest.fixture

def setup():
   print("Start Browser")
   global driver

   driver = webdriver.Chrome(service=ChromeService(ChromeDriverManager().install()))
   driver.maximize_window()
   yield
   driver.quit()




def test_1(setup):

   driver.get(TestData.BASE_URL)

   print("Browser opened")
   element = driver.find_element(By.LINK_TEXT, "Checkboxes")
   element.click()
   print("Checkbox clicked")

   element2=driver.find_element(By.XPATH, "//h3[text()='Checkboxes']").text
   assert TestData.checkboxElementValue==element2

   isCheckboxSelected = driver.find_element(By.XPATH, "//*[@id='checkboxes']/input[2]").is_selected()
   print (isCheckboxSelected)

   # print(is_checkbox_selected(driver,driver.checkbox_locator2))
   print(is_checkbox_selected(driver, checkbox_locator1))
   driver.back()

   element3 = driver.find_element(By.LINK_TEXT, "File Upload")
   element3.click()

   get_source = driver.page_source
   search_text = "File Uploader"
   print(search_text in get_source)

   driver.find_element(By.ID, "file-upload").send_keys("C://Users/Sudhanshu/OneDrive/Desktop/Superman.png")


   elementFileSubmit = driver.find_element(By.ID, "file-submit")
   elementFileSubmit.click()

