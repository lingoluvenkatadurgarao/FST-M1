from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.firefox.service import Service as FirefoxService
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions
from webdriver_manager.firefox import GeckoDriverManager

service = FirefoxService(GeckoDriverManager().install())
with webdriver.Firefox(service=service) as driver:
    wait = WebDriverWait(driver,10)
    driver.get("https://v1.training-support.net/selenium/tab-opener")
    print("Home Page title is :",driver.title)
    content = driver.find_element(By.CLASS_NAME,"content")
    print("1st window content is :",content.text)
    print("Parent window Handler is :",driver.current_window_handle)
    driver.find_element(By.ID,'launcher').click()
    wait.until(expected_conditions.number_of_windows_to_be(2))
    print("No.of Windows opened :",driver.window_handles)
    for win in driver.window_handles:
        driver.switch_to.window(win)
    print("Title of 2nd Window is :",driver.title)
    wait.until(expected_conditions.visibility_of_element_located((By.CLASS_NAME,'content')))
    content = driver.find_element(By.CLASS_NAME,'content')
    print("2nd Window Content is :",content.text)
    wait.until(expected_conditions.element_to_be_clickable((By.ID,'actionButton')))
    driver.find_element(By.ID,'actionButton').click()
    wait.until(expected_conditions.number_of_windows_to_be(3))
    print("No.of Windows opened :",driver.window_handles)
    '''for handle in driver.window_handles:
        driver.switch_to.window(handle)'''
    driver.switch_to.window(driver.window_handles[2])
    print("Title of 3rd Window is :",driver.title)
    wait.until(expected_conditions.visibility_of_element_located((By.CLASS_NAME,'content')))
    content = driver.find_element(By.CLASS_NAME,'content')
    print("3rd Window Content is :",content.text)
    driver.quit()

