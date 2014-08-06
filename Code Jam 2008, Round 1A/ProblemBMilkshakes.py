'''
Created on 02/08/2014

@author: miguel
'''

if __name__ == '__main__':
    
    file = open("output.txt", 'w')
    for case in range(1, int(input())+1): # Check all cases
        flavorsAvailable = int(input()) * [0] # Create all unmalted to start with
        customers = []  # Empty client list
        
        for i in range(int(input())): # Check all customers
            custList = list(map(int, input().split()))
            customer = []
            for j in range(custList.pop(0)):
                flavor = custList.pop(0)-1
                malt = custList.pop(0)
                customer.append((flavor, malt))
            customers.append(customer)

        impossible = False
        solved = False
        while not impossible and not solved:
            redo = False
            for customer in customers:
                unsatisfied = []
                for flavor, malt in customer:
                    if flavorsAvailable[flavor] == malt:
                        unsatisfied = []
                        break
                    else:
                        unsatisfied.append((flavor, malt))
                
                for flavor, malt in unsatisfied:
                    if flavorsAvailable[flavor] == 0 and malt == 1:
                        flavorsAvailable[flavor] = 1
                        redo = True
                        break
                if redo:
                    break
                if len(unsatisfied) > 0:
                    impossible = True
                    break
            if not redo:
                solved = True
        result = "IMPOSSIBLE" if impossible else " ".join(str(i) for i in flavorsAvailable)
        file.write("Case #%d: %s\n" % (case, result))
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                