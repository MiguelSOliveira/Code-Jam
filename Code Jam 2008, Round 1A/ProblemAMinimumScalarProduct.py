'''
Created on 02/08/2014

@author: miguel
'''
import sys
if __name__ == '__main__':
    
    file = open("output.txt", 'w')
    def onePositionLess(v1):
        temp = v1[0]
        for i in range(len(v1)):
            if(i+1 == len(v1)):
                v1[i] = temp
                return v1
            else:
                v1[i] = v1[i+1]
    
    nCases = int(input())
    for i in range(nCases):
        input()
        v1 = list(map(int, input().split(' ')))
        v2 = list(map(int, input().split(' ')))
        v1.sort()
        v2.sort(reverse=True)
        answer = 'Case #' + str(i+1) + ": " + str((sum(v1[x]*v2[x] for x in range(len(v1)))))
        file.write('%s\n' % answer)
    file.close()