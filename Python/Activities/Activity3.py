user1_Name = input("Enter player1 Name")
user2_Name = input("Enter player2 Name")
user1_input = input("Enter player1 Input for Rock-Paper-Scissor Game").lower()
user2_input = input("Enter player2 Input for Rock-Paper-Scissor Game").lower()

if user1_input == user2_input:
    print("Game is tie")
elif user1_input == "rock":
    if user2_input == "scissor":
        print(user1_Name + " " +  "is winner")
        print("Rock Wins")
    else:
           print(user2_Name + " " + "is winner")
           print("Paper Wins")
elif user1_input == "scissor":
    if user2_input == "paper":
        print(user1_Name + " " + "is winner")
        print("Scissor Wins")
    else:
        print(user2_Name + " " + "is winner")
        print("Rock Wins")
elif user1_input == "paper":
    if user2_input == "rock":
        print(user1_Name + " " + "is winner")
        print("Paper Wins")
    else:
        print(user2_Name + " " + "is winner")
        print("Scissor Wins")
else:
    print("Invalid Input you have entered,Please try Again")





