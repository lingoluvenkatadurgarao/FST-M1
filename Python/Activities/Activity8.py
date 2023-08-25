Number_List = list(input("Please enter numbers separated by Comma :").split(","))
List_length = len(Number_List)
if Number_List[0] == Number_List[List_length-1]:
    print(True)
else:
    print(False)
