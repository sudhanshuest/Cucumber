from selenium.webdriver.common.by import By
from Config.config import TestData


class HomePage():
    Checkboxes = (By.XPATH, "//a[text()='Checkboxes']")
    Checkbox1 = (By.XPATH, "//*[@id='checkboxes']/text()[1]")
    Checkbox2 = (By.XPATH, "//*[@id='checkboxes']/text()[2]")
    CheckboxesText = (By.XPATH, "//h3[text()='Checkboxes']")
    CheckboxesLinkTest = (By.LINK_TEXT, "Checkboxes")

    def __init__(self, driver):
        super().__init__(driver)
        self.driver.get(TestData.BASEURL)

        def is_Checkbox2_checked(self):
            return self.is_checked(self.Checkbox2)

        def is_Checkbox1_not_checked(self):
            return self.is_checked(self.Checkbox1)

        def clickCheckbox(self):
            return self.do_click(self.Checkboxes)
