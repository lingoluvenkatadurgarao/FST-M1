from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.firefox.service import Service as FirefoxService
from selenium.webdriver import ActionChains
from webdriver_manager.firefox import GeckoDriverManager

service = FirefoxService(GeckoDriverManager().install())
with webdriver.Firefox(service= service) as driver:
    driver.get("https://v1.training-support.net/selenium/drag-drop")
    print("Title of the page : ",driver.title)
    actions = ActionChains(driver)
    ball = driver.find_element(By.ID,"draggable")
    DropZone1 = driver.find_element(By.ID,"droppable")
    DropZone2 = driver.find_element(By.ID,"dropzone2")
    actions.click_and_hold(ball).move_to_element(DropZone1).pause(5).release().perform()
    Zone1_Highlighed = DropZone1.text
    if(Zone1_Highlighed.find("Dropped!")):
        print("Dropzone 1 was activated!")
    #actions.click_and_hold(ball).move_to_element(DropZone2).pause(5).release().perform()
    actions.drag_and_drop(DropZone1,DropZone2).perform()
    Zone2_Highlighed = DropZone2.text
    if(Zone2_Highlighed.find("Dropped!")):
        print("Dropzone 2 was activated!")

    driver.close()




