import sys
import itertools
import copy

sys.stdin = open("input.txt", "r", encoding="UTF-8")

T = int(input())

for test_case in range(1, T+1):
    n = int(input())
    checkList = []
    maxCount = -1
    minLine = 999999999
    dy = [0, 0, 1, -1]
    dx = [1, -1, 0, 0]

    matrix = [list(map(int, input().split())) for _ in range(n)]

    for y in range(1, n-1):
        for x in range(1, n-1):
            if matrix[y][x] == 1:
                checkList.append((y, x))

    coreCount = len(checkList)
    def drawLine(y, x, arr):
        nY, nX = y, x
        for i in range(4):
            while 0 <= nY < n and 0 <= nX < n:
                nY += dy[dir]
                nX += dx[dir]
                
    def check(count, ):


    print("#{} {}".format(test_case, minLine))