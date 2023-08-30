from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.firefox.service import Service as FirefoxService
from selenium.webdriver.support.ui import Select
from webdriver_manager.firefox import GeckoDriverManager

service = FirefoxService(GeckoDriverManager().install())
with webdriver.Firefox(service=service) as driver:
    driver.get("https://v1.training-support.net/selenium/selects")
    print("Title is :", driver.title)
    select_element = driver.find_element(By.ID,"single-select")
    dropdown = Select(select_element)
    dropdown.select_by_visible_text("Option 2")
    print("Select by Visible text Option is :", dropdown.first_selected_option.text)
    dropdown.select_by_index(3)
    print("Select by index Option is :", dropdown.first_selected_option.text)
    dropdown.select_by_value("4")
    print("Select by Value Option is :", dropdown.first_selected_option.text)
    list_elements = dropdown.options
    for lst in list_elements:
        print(lst.text)
    driver.quit()
