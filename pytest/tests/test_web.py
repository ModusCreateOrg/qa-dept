import pytest
from pylenium.driver import Pylenium
from pylenium.element import Element

class LoginPage:
    def __init__(self, py: Pylenium):
        self.py = py


    def goto(self) -> 'LoginPage':
        self.py.visit('https://www.saucedemo.com/')
        return self

    def getUserName(self) -> Element:
        return self.py.get('#user-name')

    def getPassword(self) -> Element:
        return self.py.get('#password')

    def getLoginBtn(self) -> Element:
        return self.py.get('#login-button')

@pytest.fixture
def page(py: Pylenium):
    return LoginPage(py).goto()

def test_login_with_valid_creds(py: Pylenium , page: LoginPage):
    page.getUserName().type('standard_user')
    page.getPassword().type('secret_sauce')
    page.getLoginBtn().submit()
    assert py.contains('Products')

def test_login_with_empty_username(py: Pylenium , page: LoginPage):
    page.getPassword().type('secret_sauce')
    page.getLoginBtn().submit()
    assert py.contains('Username is required')

def test_login_with_empty_pass(py: Pylenium , page: LoginPage):
    page.getUserName().type('standard_user')
    page.getLoginBtn().submit()
    assert py.contains('Password is required')

def test_login_with_wrong_pass(py: Pylenium , page: LoginPage):
    page.getUserName().type('standard_user')
    page.getPassword().type('secret_saucde')
    page.getLoginBtn().submit()
    assert py.contains('Username and password do not match any user in this service')