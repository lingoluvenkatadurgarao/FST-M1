from selenium import webdriver
from selenium.webdriver import ActionChains
from selenium.webdriver.common.by import By
from selenium.webdriver.firefox.service import Service as FirefoxService
from webdriver_manager.firefox import GeckoDriverManager
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions

service = FirefoxService(GeckoDriverManager().install())
with webdriver.Firefox(service = service) as driver:
    driver.get("https://v1.training-support.net/selenium/popups")
    print("Tile is :" ,driver.title)
    hover = driver.find_element(By.CLASS_NAME,'orange')
    action = ActionChains(driver)
    action.move_to_element(hover).perform()
    print("Sign in tooltip is :" ,hover.get_attribute("data-tooltip"))
    wait =WebDriverWait(driver,10)
    hover.click()
    wait.until(expected_conditions.visibility_of_element_located((By.ID,'username')))
    driver.find_element(By.ID,'username').send_keys('admin')
    driver.find_element(By.ID,'password').send_keys('password')
    driver.find_element(By.XPATH,"//button[text() = 'Log in']").click()
    confirm = driver.find_element(By.ID,'action-confirmation').text
    print("Confirmation Message is :" + confirm)
    driver.close()
