import pytest

def capital_case(input):
    if not isinstance(input, str):
        raise TypeError('wrong input type')
    return input.capitalize()
    #except:    
    #    return 'wrong input type'

def test_capital_case():
    assert capital_case('abcd') == 'Abcd'

def test_raises_exception_on_non_string_arguments():
    with pytest.raises(TypeError):
        capital_case(9)