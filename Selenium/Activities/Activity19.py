import time

from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.firefox.service import Service as FirefoxService
from selenium.webdriver.common.alert import Alert
from webdriver_manager.firefox import GeckoDriverManager

service = FirefoxService(GeckoDriverManager().install())
with webdriver.Firefox(service=service) as driver:
    driver.get("https://v1.training-support.net/selenium/javascript-alerts")
    print("Title is :" ,driver.title)
    alert_element = driver.find_element(By.ID,"confirm")
    alert_element.click()
    confirm_alert = driver.switch_to.alert
    print("text in alert is :",confirm_alert.text)
    time.sleep(2)
    confirm_alert.accept()
    alert_element.click()
    time.sleep(2)
    confirm_alert.dismiss()
    driver.quit()