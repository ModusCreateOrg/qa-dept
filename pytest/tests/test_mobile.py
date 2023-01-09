import pytest
import os
from appium import webdriver
from appium.webdriver.common.appiumby import By

class DriverSetup:
    def __init__(self, wd: webdriver):
        self.wd = wd

    def goto(self) -> 'DriverSetup':
        desired_caps = {}
        desired_caps['platformName'] = 'Android'
        desired_caps['platformVersion'] = '8.0'
        desired_caps['deviceName'] = 'Pixel'
        desired_caps['app'] = os.path.abspath(os.path.join(os.path.dirname(__file__),'apps/testApp.apk'))
        desired_caps['appPackage'] = 'com.example.testapp'
        desired_caps['appActivity'] = 'com.example.testapp.MainActivity'
        self.wd.driver = webdriver.Remote('http://localhost:4723/wd/hub', desired_caps)
        return self.wd.driver

@pytest.fixture
def setup():
        return DriverSetup(webdriver).goto()

def test_app(setup: DriverSetup):
        element = setup.find_element(By.ID , "com.example.testapp:id/fab")
        element.click()