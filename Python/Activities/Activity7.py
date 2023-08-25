Number_List = list(input("enter the numbers for sum seperated by comma :").split(","))
sum = 0
for i in Number_List:
    sum = sum+int(i)
print(sum)
