from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.firefox.service import Service as FirefoxService
from selenium.webdriver.remote.webelement import WebElement
from webdriver_manager.firefox import GeckoDriverManager

service = FirefoxService(GeckoDriverManager().install())
with webdriver.Firefox(service=service) as driver:
    driver.get("https://v1.training-support.net/selenium/tables")
    print("Title is :", driver.title)
    rows = driver.find_elements(By.XPATH,"//table[@class ='ui celled striped table']/tbody/tr")
    print("No.of Rows is :",len(rows))
    cols = driver.find_elements(By.XPATH,"//table[@class ='ui celled striped table']/tbody/tr[1]/td")
    print("No.of columns :",len(cols))
    Third_row_col = driver.find_elements(By.XPATH,"//table[@class ='ui celled striped table']/tbody/tr[3]/td")
    for cell in Third_row_col:
        print(cell.text)
    sec_col = driver.find_element(By.XPATH,"//table[@class ='ui celled striped table']/tbody/tr[2]/td[2]")
    print(sec_col.text)

driver.close()





