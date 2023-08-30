from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.support.ui import Select
from selenium.webdriver.firefox.service import Service as FirefoxService
from webdriver_manager.firefox import GeckoDriverManager

service = FirefoxService(GeckoDriverManager().install())
with webdriver.Firefox(service=service) as driver:
    driver.get("https://v1.training-support.net/selenium/selects")
    print("Title is :",driver.title)
    select_element = driver.find_element(By.ID,"multi-select")
    multi_drpdwn = Select(select_element)
    multi_drpdwn.select_by_visible_text("Javascript")
    print("First selected Option is :",multi_drpdwn.first_selected_option.text)
    for i in range(4,7):
        multi_drpdwn.select_by_index(i)
    multi_drpdwn.select_by_value("node")
    lst1 = multi_drpdwn.all_selected_options
    print("All the selected options :")
    for l1 in lst1:
        print(l1.text)
    multi_drpdwn.deselect_by_index(5)
    lst2 = multi_drpdwn.all_selected_options
    print("All the selected options post deselect:")
    for l2 in lst2:
        print(l2.text)
    driver.close()

