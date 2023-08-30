from selenium.webdriver.common.by import By
from selenium.webdriver.firefox.service import Service as FirefoxService
from webdriver_manager.firefox import GeckoDriverManager
from selenium import webdriver

service = FirefoxService(GeckoDriverManager().install())
with webdriver.Firefox(service=service) as driver:
    driver.get("https://v1.training-support.net/selenium/dynamic-controls")
    print("Tile is :"+driver.title)
    checkbox = driver.find_element(By.XPATH,"//input[@class = 'willDisappear']")
    checkbox.click()
    print("Check box selected :",checkbox.is_selected())
    checkbox.click()
    print("Check box is Unselected outcome as False :",checkbox.is_selected())
    driver.close()
