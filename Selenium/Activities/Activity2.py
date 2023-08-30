import time
from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.firefox.service import Service as FirefoxService
from webdriver_manager.firefox import GeckoDriverManager

service = FirefoxService(GeckoDriverManager().install())
with webdriver.Firefox(service = service) as driver:
    driver.get("https://v1.training-support.net/selenium/login-form")
    print("Home Page Title is :",driver.title)
    driver.find_element(By.ID,"username").send_keys("admin")
    driver.find_element(By.ID,"password").send_keys("password")
    #driver.find_element(By.XPATH,"//button[text() = 'Log in']").click()
    login = driver.find_element(By.CSS_SELECTOR, "button:nth-child(4)")
    login.click()
    confirmation_msg = driver.find_element(By.ID,"action-confirmation").text
    print("confirmation_msg is :"+confirmation_msg)

    time.sleep(5)
    driver.close()







