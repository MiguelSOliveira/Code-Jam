'''
Created on 04/08/2014

@author: miguel
'''

import re
if __name__ == '__main__':
    
    for case in range(1, int(input())+1):
        
        stringNumber = str((3+5**(1/2))**int(input()))
        print(stringNumber)
        patFinder = re.compile("\d{1,3}\\.")
        answer = "".join(str(i) for i in re.findall(patFinder, stringNumber))[:-1]
        if len(answer) == 1:
            answer = '00' + answer
        elif len(answer) == 2:
            answer = '0' + answer
        print("Case #%d: %s" % (case, answer))