import pandas

data = {"FirstName" : ["Satvik","Avinash","Lahri"],
        "LastName" : ["Shah","Kati","Rath"],
        "Email" : ["satshah@example.com","avinashk@example.com","lahri.rath@example.com"],
        "PhoneNumber" : ["4537829158","5892184058","4528727830"]}
dataframe = pandas.DataFrame(data)
print(dataframe)
dataframe.to_excel("../resources/PersonsData.xlsx",sheet_name="PData",index=False)
