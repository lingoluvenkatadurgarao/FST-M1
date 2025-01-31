from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.firefox.service import Service as FirefoxService
from webdriver_manager.firefox import GeckoDriverManager

service = FirefoxService(GeckoDriverManager().install())
with webdriver.Firefox(service=service) as driver:
    driver.get("https://v1.training-support.net/selenium/dynamic-attributes")
    print("Title is :",driver.title)
    driver.find_element(By.XPATH,"//input[starts-with(@class,'username-')]").send_keys("admin")
    driver.find_element(By.XPATH,"//input[starts-with(@class,'password-')]").send_keys("password")
    driver.find_element(By.XPATH,"//button[text() = 'Log in']").click()
    Confirmation = driver.find_element(By.ID,"action-confirmation").text
    print("Confirmation message is :" + Confirmation)
    driver.close()
