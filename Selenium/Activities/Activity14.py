from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.firefox.service import Service as FirefoxService
from webdriver_manager.firefox import GeckoDriverManager

service = FirefoxService(GeckoDriverManager().install())
with webdriver.Firefox(service=service) as driver:
    driver.get("https://v1.training-support.net/selenium/tables")
    print("Title is :",driver.title)
    cols= driver.find_elements(By.XPATH,"//table[@id = 'sortableTable']/thead/tr/th")
    print("No.of Columns :",len(cols))
    rows = driver.find_elements(By.XPATH,"//table[@id = 'sortableTable']/tbody/tr")
    print("No.of Rows :",len(rows))
    second_row_cell =driver.find_element(By.XPATH,"//table[@id = 'sortableTable']/tbody/tr[2]/td[2]")
    print("2nd_row_2nd_cell_value is :" ,second_row_cell.text)
    driver.find_element(By.XPATH,"//table[@id = 'sortableTable']/thead/tr/th").click()
    second_row_cell_again =driver.find_element(By.XPATH,"//table[@id = 'sortableTable']/tbody/tr[2]/td[2]")
    print("2nd_row_2nd_cell_value is :" + second_row_cell_again.text)
    footer_cell = driver.find_elements(By.XPATH,"//table[@id = 'sortableTable']/tfoot/tr/th")
    print("Cell values of the footer: ")
    for fcell in footer_cell:
        print(fcell.text)
    driver.quit()


