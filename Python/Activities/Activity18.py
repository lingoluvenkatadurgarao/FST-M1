import pandas

dataframe = pandas.read_csv("../resources/credentials.csv")
print("====Print DataFrame====")
print(dataframe)
print("====Print UserName column====")
print(dataframe["Usernames"])
print("====Print UserName & Password in 2nd Row====")
print(dataframe["Usernames"][1] +" "+ dataframe["Passwords"][1])
print("====Print UserName column in Ascending Order====")
print(dataframe.sort_values("Usernames"))
print("====Print Passwords column in Descending Order====")
print(dataframe.sort_values("Passwords",ascending=False))