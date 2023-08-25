import pytest

@pytest.fixture
def Numbers_List():
    numbers = [0,1,2,3,4,5,6,7,8,9,10]
    return numbers

def test_sum(Numbers_List):
    result = 0
    for i in Numbers_List:
        result += i
    assert result == 55
