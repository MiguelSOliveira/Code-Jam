'''
Created on 01/08/2014

@author: miguel
'''

if __name__ == '__main__':

    def solve(itemPrices):
        for j in range(len(itemPrices)):
            for n in range(j, len(itemPrices)):
                if itemPrices[j] + itemPrices[n] == availableCredit and j != n:
                    return " " + str(j+1) + " " + str(n+1)

    
    numberOfCases = int(input())
    f = open("output.txt", 'w')
    for i in range(numberOfCases):
        
        availableCredit = int(input())
        input()
        itemPrices = map(int, input().split(" "))
        itemPrices = list(itemPrices)
        answer = "Case #"+str(i+1)+":"+solve(itemPrices)+'\n'
        f.write('%s\n' % answer)
    f.close()