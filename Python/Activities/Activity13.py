def sum():
    numbers = (input("Enter required list of numbers separated by comma :").split(","))
    sum_res = 0
    for i in range(len(numbers)+1):
        sum_res = int(i)+sum_res
    print(sum_res)
sum()

