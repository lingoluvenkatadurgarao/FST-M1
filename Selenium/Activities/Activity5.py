from selenium import webdriver
from selenium.webdriver import ActionChains
from selenium.webdriver.common.by import By
from selenium.webdriver.firefox.service import Service as FirefoxService;
from webdriver_manager.firefox import GeckoDriverManager

service =FirefoxService(GeckoDriverManager().install())
with webdriver.Firefox(service = service) as driver:
    driver.get("https://v1.training-support.net/selenium/input-events")
    print("home Page title is :",driver.title)
    action = ActionChains(driver)
    action.click().pause(2).perform()
    left_click_Text  = driver.find_element(By.CLASS_NAME,'active').text
    action.double_click().pause(2).perform()
    double_click_Text  = driver.find_element(By.CLASS_NAME,'active').text
    action.context_click().pause(2).perform()
    right_click_Text  = driver.find_element(By.CLASS_NAME,'active').text
    print("Left click is :" + left_click_Text);
    print("Double click is :" + right_click_Text);
    print("Right click is :" + double_click_Text);
    driver.close()



