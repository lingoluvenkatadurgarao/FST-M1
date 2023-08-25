Numbers = tuple(input("Enter Integer Numbers separated by Comma :").split(","))

print("Elements that are divisible by 5:")
for i in Numbers:
    if int(i) % 5 == 0:
        print(i)