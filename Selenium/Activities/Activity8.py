from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.firefox.service import Service as FirefoxServices
from selenium.webdriver.remote import webelement
from selenium.webdriver.support import expected_conditions
from selenium.webdriver.support.wait import WebDriverWait
from webdriver_manager.firefox import GeckoDriverManager;

service = FirefoxServices(GeckoDriverManager().install())
with webdriver.Firefox(service=service) as driver:
    driver.get("https://v1.training-support.net/selenium/dynamic-controls")
    print("Page Title is ",driver.title)
    wait = WebDriverWait(driver,10)
    checkbox = driver.find_element(By.XPATH,"//input[@class ='willDisappear']")
    driver.find_element(By.XPATH,"//button[text()='Remove checkbox']").click()
    wait.until(expected_conditions.invisibility_of_element_located(checkbox))
    print(checkbox.is_displayed())
    driver.find_element(By.XPATH,"//button[text() = 'Add Checkbox']").click()
    checkbox.click()
    driver.close()

