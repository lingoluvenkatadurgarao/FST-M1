List1 = list(input("Enter combination of Even & Odd Numbers separated by Comma for list1:").split(","))
List2 = list(input("Enter combination of Even & Odd Numbers separated by Comma for list2:").split(","))
Even_List = []
Odd_List = []
for i in List1:
    if int(i) % 2 == 0:
        Even_List.append(i)
print("Even List is :" + str(Even_List))

for j in List2:
    if int(j) % 2 != 0:
        Odd_List.append(j)
print("Odd List is :" + str(Odd_List))
