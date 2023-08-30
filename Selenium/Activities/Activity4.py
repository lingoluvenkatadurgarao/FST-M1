from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.firefox.service import Service as FirefoxService
from webdriver_manager.firefox import GeckoDriverManager

WDService = webdriver.FirefoxService(GeckoDriverManager().install())
with webdriver.Firefox(service=WDService) as driver:
    driver.get("https://v1.training-support.net/selenium/target-practice")
    print("Home Page title is :",driver.title)
    ThirdHeadr =driver.find_element(By.XPATH,"//h3[@id = 'third-header']").text
    print("Thrird header is :" +ThirdHeadr)
    color = driver.find_element(By.XPATH,"//h5[text() = 'Fifth header']").value_of_css_property("color")
    print("Fifth header color is :" +color);
    violet_color = driver.find_element(By.XPATH,"//button[text()='Violet']").get_dom_attribute("class")
    print("Violet Color is :" +violet_color);
    Grey_Text = driver.find_element(By.XPATH,"//button[text() = 'Grey']").text
    print("Grey Text is :" +Grey_Text);
    driver.close()


