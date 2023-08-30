from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.firefox.service import Service as FirefoxServices
from selenium.webdriver.remote import webelement
from selenium.webdriver.support.wait import WebDriverWait
from selenium.webdriver.support import expected_conditions
from webdriver_manager.firefox import GeckoDriverManager

service = FirefoxServices(GeckoDriverManager().install())
with webdriver.Firefox(service = service) as driver:
    wait = WebDriverWait(driver,10)
    driver.get("https://v1.training-support.net/selenium/dynamic-controls")
    print("Title of the page is :",driver.title)
    checkbox = driver.find_element(By.XPATH,"//div[@id ='dynamicCheckbox']//input")
    checkbox.click()
    print(checkbox.is_selected())
    driver.find_element(By.ID,"toggleCheckbox").click()
    print(wait.until(expected_conditions.invisibility_of_element_located(checkbox)))
    driver.find_element(By.XPATH,"//button[text() ='Add Checkbox']").click()
    wait.until(expected_conditions.element_located_to_be_selected((By.XPATH,"//div[@id ='dynamicCheckbox']//input")))
    print(checkbox.is_selected())
    driver.close()






