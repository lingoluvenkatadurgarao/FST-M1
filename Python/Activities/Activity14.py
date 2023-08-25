def Feb_series(number):
    if (number == 0):
        return 0
    elif(number == 1):
        return 1
    else:
       return Feb_series(number-1)+Feb_series(number-2)


fib_num = int(input("Enter a number to generate how many Fibonacci Series you need to generate : "))
if fib_num < 0:
    print("Please enter Positive Number only")
else:
    for i in range(fib_num):
      print(Feb_series(i))