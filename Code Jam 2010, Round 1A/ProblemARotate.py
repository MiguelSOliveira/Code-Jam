'''
Created on 08/08/2014

@author: miguel
'''

if __name__ == '__main__':
    
    def checkLine(kColor, line, color):
        if kColor in line:
            return True
        return color
    
    def solve(boardSize, k):
        board = [[i for i in input()] for j in range(boardSize)]
        
        kBlue = k*'B'
        kRed = k*'R'
        blue = False
        red = False

        #Empurrar pecas para a direita
        for number, line in enumerate(board):
            x = boardSize-1
            for i in reversed(line):
                if(i != '.'):
                    line[x] = i
                    x-=1
            while(x >= 0):
                line[x] = '.'
                x-=1
            board[number] = line
            
        
        #Verificar lines horizontais e verticais
        for i in range(boardSize):
            line = "".join(board[i])
            blue = checkLine(kBlue, line, blue)
            red = checkLine(kRed, line, red)
            column = "".join(board[j][i] for j in range(boardSize))
            blue = checkLine(kBlue, column, blue)
            red = checkLine(kRed, column, red)
            
        #Verificar diagonais
        for i in range(boardSize):
            j = 0
            #Decrescente
            diagonal = "".join(board[i+d][j+d] for d in range(boardSize-i))
            blue = checkLine(kBlue, diagonal, blue)
            red = checkLine(kRed, diagonal, red)
            diagonal = "".join(board[j+d][i+d] for d in range(boardSize-i))
            blue = checkLine(kBlue, diagonal, blue)
            red = checkLine(kRed, diagonal, red)
            #Crescente
            diagonal = "".join(board[i-d][j+d] for d in range(i+1))
            blue = checkLine(kBlue, diagonal, blue)
            red = checkLine(kRed, diagonal, red)
            diagonal = "".join(board[boardSize-1-d][i+d] for d in range(boardSize-i))
            blue = checkLine(kBlue, diagonal, blue)
            red = checkLine(kRed, diagonal, red)
            
        if blue and red:
            return "Both"
        elif blue:
            return "Blue"
        elif red:
            return "Red"
        return "Neither"
    
    for i in range(1, int(input())+1):
        boardSize, k = map(int, input().split())
        print("Case #%d: %s" % (i, solve(boardSize, k)))
        