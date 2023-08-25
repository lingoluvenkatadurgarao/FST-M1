def calulateSum(n):
   if n:
         return n+(calulateSum(n-1))
   else:
       return 0

res = calulateSum(10)
print(res)
