import pytest


@pytest.mark.xfail
def test_greater():
    num = 100
    assert num > 200


@pytest.mark.xfail
@pytest.mark.great
def test_greater_equal():
    num = 300
    assert num >= 300


@pytest.mark.skip
@pytest.mark.others
def test_lesser():
    num = 10
    assert num < 11
