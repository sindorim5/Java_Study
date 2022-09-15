from itertools import permutations
import sys

sys.stdin = open("0915/금속막대.txt", "r", encoding="UTF-8")

T = int(input())

def check(picked):
    count = 1
    for i in range(n-1):
        if picked[i][1] == picked[i+1][0]:
            count += 1
        else:
            break
    return count


for test_case in range(1,T+1):
    n = int(input())
    inputList = list(map(int, input().split()))
    screwList = []
    maxConnect = -999999999
    maxScrew = []
    for i in range(0,len(inputList),2):
        screwList.append([inputList[i], inputList[i+1]])

    visited = [False for _ in range(n)]

    permuteList = list(permutations(screwList))

    for pick in permuteList:
        temp = check(pick)
        if temp > maxConnect:
            maxConnect = temp
            maxScrew = list(pick)
        if temp == n:
            break

    print("#{}".format(test_case), end=" ")
    for screw in maxScrew:
        for s in screw:
            print(s, end=" ")
    print()
