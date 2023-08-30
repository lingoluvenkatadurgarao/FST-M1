from selenium import webdriver
from selenium.webdriver.firefox.service import Service as FirefoxService
from selenium.webdriver import ActionChains, Keys
from webdriver_manager.firefox import GeckoDriverManager

service = FirefoxService(GeckoDriverManager().install())
with (webdriver.Firefox(service= service) as driver):
    driver.get("https://v1.training-support.net/selenium/input-events")
    print("Home Page title is :",driver.title)
    action = ActionChains(driver)
    action.send_keys("V").key_down(Keys.CONTROL).send_keys("A").send_keys("C").key_up(Keys.CONTROL).pause(5).perform()
    driver.close()
