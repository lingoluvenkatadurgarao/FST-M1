from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.firefox.service import Service as FireFoxService
from webdriver_manager.firefox import GeckoDriverManager

service = FireFoxService(GeckoDriverManager().install())
with webdriver.Firefox(service = service) as driver:
    driver.get("https://v1.training-support.net")
    print("Home Page Title is: ",driver.title)
    driver.find_element(By.XPATH,"//a[@id = 'about-link']").click()
    print("New page Title is :",driver.title)
    driver.get("https://v1.training-support.net/selenium/login-form")
    print("Logon page Title is :",driver.title)
    driver.find_element(By.XPATH,"//input[@id = 'username']").send_keys("admin")
    driver.find_element(By.XPATH,"//input[@id = 'password']").send_keys("password")
    driver.find_element(By.XPATH,"//button[text() = 'Log in']").click()
    confirmation_msg = driver.find_element(By.XPATH,"//div[@id = 'action-confirmation']").text
    print("confirmation_msg is :"+confirmation_msg)
    driver.quit()



