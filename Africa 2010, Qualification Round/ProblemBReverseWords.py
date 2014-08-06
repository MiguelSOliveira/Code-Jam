'''
Created on 01/08/2014

@author: miguel
'''

if __name__ == '__main__':
    
    numberOfCases = int(input())
    file = open('output.txt', 'w')
    for i in range(numberOfCases):
        
        currentSentence = input().split()
        currentSentence = currentSentence[::-1]
        file.write("Case #"+str(i+1)+": " + " ".join(str(i) for i in currentSentence)+'\n')