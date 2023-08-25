num1 = 10
num2 = 5
print("===Sum of two numbers===")
def test_sum():
    sum = num1 + num2
    assert sum == 15

print("===Difference of two numbers===")
def test_difference():
    sub = num1 - num2
    assert sub == 5

print("===Product of two numbers===")
def test_product():
    mul = num1*num2
    assert mul == 50

print("===Quotient of two numbers===")
def test_division():
    div = num1/num2
    assert div == 2