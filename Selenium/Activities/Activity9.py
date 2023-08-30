from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.firefox.service import Service as FirefoxService
from webdriver_manager.firefox import GeckoDriverManager
from selenium.webdriver.support.wait import WebDriverWait
from selenium.webdriver.support import expected_conditions

service = FirefoxService(GeckoDriverManager().install())
with webdriver.Firefox(service=service) as driver:
    wait = WebDriverWait(driver,10)
    driver.get("https://v1.training-support.net/selenium/ajax")
    print("Title of the page :",driver.title)
    driver.find_element(By.CSS_SELECTOR,"button.violet").click()
    print("Hello_Text is :" +driver.find_element(By.TAG_NAME,"h1").text)
    print("Is Late text Visible :")
    print(wait.until(expected_conditions.text_to_be_present_in_element((By.TAG_NAME,'h3'),"I'm late!")))
    print("Late Text is :" + driver.find_element(By.TAG_NAME,'h3').text)
    driver.close()

