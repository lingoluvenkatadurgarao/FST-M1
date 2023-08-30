from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.firefox.service import Service as FirefoxService
from webdriver_manager.firefox import GeckoDriverManager

service = FirefoxService(GeckoDriverManager().install())
with webdriver.Firefox(service=service) as driver:
    driver.get("https://v1.training-support.net/selenium/dynamic-controls")
    print("Title is :" + driver.title)
    text_field = driver.find_element(By.ID,"input-text")
    print("Is Text field Enabled :",text_field.is_enabled())
    driver.find_element(By.ID,"toggleInput").click()
    print("Is Text field Enabled :",text_field.is_enabled())
    text_field.send_keys("I am Enabled")
    print("input Text is :",text_field.get_attribute('value'))
    driver.close()




