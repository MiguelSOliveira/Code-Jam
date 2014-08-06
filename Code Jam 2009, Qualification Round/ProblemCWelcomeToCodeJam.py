'''
Created on 05/08/2014

@author: miguel

3
elcomew elcome to code jam
wweellccoommee to code qps jam
welcome to codejam

'''
import functools
if __name__ == '__main__':
    
        w = "welcome to code jam"
        @functools.lru_cache(maxsize=128)
        def count(s, p=w):
            
            if len(p) == 1:
                return s.count(p)
            
            c, p = p[0], p[1:]
            res = 0
            for i, k in enumerate(s):
                if k != c:
                    continue
                res += count(s[i+1:], p)
                print(res)
            return res
        
        for case in range(1, int(input())+1):
            print(count(input()))
            
            
            
            
            
            
            
            
            
            
            
            
            