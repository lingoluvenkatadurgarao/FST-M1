import pandas
dataframe = pandas.read_excel("../resources/PersonsData.xlsx","PData")
print("===Print the rows and columns Data===")
print(dataframe)
print("===Print the number of rows and columns===")
print(dataframe.shape)
print("===Print the data in the emails column only===")
print(dataframe["Email"])
print("Sort the data based on FirstName in ascending order and print the data")
print(dataframe.sort_values("FirstName"))
