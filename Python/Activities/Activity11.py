fruites_Prices = {}
dictionary_size = int(input("Please enter size of dictionary to store data in key value pair :"))
for i in range(dictionary_size):
    key = input("Enter fruit name:")
    value = input("Enter Price:")
    fruites_Prices[key] = value
print(fruites_Prices)

key_to_check = input("What are you looking for? ").lower()

#for k in fruites_Prices:
 #   if k == key_to_check:
  #     print("Required Fruit" +" "+ key_to_check + "  is available and its price is :"+ fruites_Prices[key_to_check])

if(key_to_check in fruites_Prices):
    print("Required Fruit" +" "+ key_to_check + "  is available and its price is :"+ fruites_Prices[key_to_check])
else:
    print("No matched fruit")