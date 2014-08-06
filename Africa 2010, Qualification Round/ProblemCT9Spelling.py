'''
Created on 02/08/2014

@author: miguel
'''

if __name__ == '__main__':
    
    myKeyboard = {'a': 2, 'b': 22, 'c': 222, 'd': 3, 'e': 33, 'f': 333, 'g': 4, 'h': 44, 'i': 444, 'j': 5, 'k': 55, 'l': 555, 'm': 6, 'n': 66, 'o': 666, 'p': 7, 'q': 77, 'r': 777, 's': 7777,'t': 8, 'u': 88, 'v': 888, 'w': 9, 'x':99, 'y': 999, 'z': 9999}

    numberOfCases = int(input())
    f = open("output.txt", 'w')
    for i in range(numberOfCases):
        answer = "Case #"+str(i+1)+": "
        message = list(input())
        for j in message:
            if not j in myKeyboard:
                if(answer.endswith('0')):
                    answer += ' 0'
                else:
                    answer += '0'
            else:
                if(answer.endswith(str(myKeyboard[j])[:1])): # Se answer acaba com a primeira letra de myKeyboard[j]
                    answer += ' ' + str(myKeyboard[j])
                else:
                    answer += str(myKeyboard[j])
        f.write(answer+'\n')