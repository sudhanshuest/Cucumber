from selenium.webdriver.common.by import By


class TestData:
    BASE_URL = "http://the-internet.herokuapp.com/"
    Checkboxes = (By.XPATH, "//a[text()='Checkboxes']")
    checkboxElementValue="Checkboxes"
    FileUploaderValue="File Uploader"
