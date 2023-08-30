from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.firefox.service import Service as FirefoxService
from webdriver_manager.firefox import GeckoDriverManager

service = FirefoxService(GeckoDriverManager().install())
with webdriver.Firefox(service=service) as driver:
    driver.get("https://v1.training-support.net/selenium/dynamic-attributes")
    print("Title is :",driver.title)
    driver.find_element(By.XPATH,"//input[contains(@class,'-username')]").send_keys("Ram")
    driver.find_element(By.XPATH,"//input[contains(@class,'-password')]").send_keys("laxman")
    driver.find_element(By.XPATH,"//label[contains(text(),'Confirm Password')]/following::input").send_keys("laxman")
    #confirm_password = driver.find_element_by_xpath("//label[text()='Confirm Password')]/following-sibling::input")
    driver.find_element(By.XPATH,"//input[contains(@class, 'email-')]").send_keys("sita@ram.com")
    driver.find_element(By.XPATH,"//button[text() = 'Sign Up']").click()
    confirm = driver.find_element(By.ID,"action-confirmation").text
    print("Confirmation for sign up :",confirm)
    driver.quit()