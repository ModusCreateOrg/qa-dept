import math
import pytest


@pytest.mark.great
def test_square_root():
    num = 25
    assert math.sqrt(num) == 5


@pytest.mark.first
def test_square():
    num = 7
    assert 7 * 7 == 42


@pytest.mark.second
def tes_equality():
    assert 10 == 10
