import sys
import copy
from collections import deque

sys.stdin = open(
    "C:/SSAFY/clone/Algorithm_SSAFY/0817/1949_input.txt", "r", encoding="utf-8")

moveList = [(0, 1), (0, -1), (1, 0), (-1, 0)]

T = int(input())
for test_case in range(1, T+1):
    n, k = map(int, input().split())
    matrix = [list(map(int, input().split())) for _ in range(n)]
    maxList = []
    maxValue = max(list(map(max, matrix)))

    for y in range(n):
        for x in range(n):
            if matrix[y][x] == maxValue:
                maxList.append((y, x))

    def pathFinder(y, x):
        result = []
        q = deque()
        visited = [[False]*n for _ in range(n)]
        flag = 0
        q.append((y, x, flag))
        result.append(matrix[y][x])
        while q:
            nowY, nowX, nowFlag = q.popleft()
            if nowFlag >= 2:
                continue
            visited[nowY][nowX] = True
            result.append(matrix[nowY][nowX])
            for dy, dx in moveList:
                nY = nowY + dy
                nX = nowX + dx
                if 0 <= nY < n and 0 <= nX < n and visited[nY][nX] == False:
                    if matrix[nY][nX] < matrix[y][x]:
                        q.append((nY, nX, nowFlag))
                    elif matrix[nY][nX] == matrix[y][x]:
                        q.append((nY, nX, nowFlag + 1))
            print(q)
        return result

    s = pathFinder(maxList[0][0], maxList[0][1])
    print(s)
