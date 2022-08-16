import sys
from collections import deque

sys.stdin = open(
    "C:/SSAFY/clone/Algorithm_SSAFY/0817/1949_input.txt", "r", encoding="utf-8")

moveList = [(0, 1), (0, -1), (1, 0), (-1, 0)]

T = int(input())
for test_case in range(1, T+1):
    n, k = map(int, input().split())
    matrix = [list(map(int, input().split())) for _ in range(n)]
    visited = [[False] * n for _ in range(n)]
    maxList = []
    result = []
    global temp
    temp = []
    maxValue = max(list(map(max, matrix)))

    for y in range(n):
        for x in range(n):
            if matrix[y][x] == maxValue:
                maxList.append((y, x))

    def dfs(y, x, move, flag, visited):
        visited[y][x] = True
        move.append(matrix[y][x])
        for dy, dx in moveList:
            nY = y + dy
            nX = x + dx
            if 0 <= nY < n and 0 <= nX < n:
                if matrix[nY][nX] < matrix[y][x]:
                    move = dfs(nY, nX, move, flag, visited)
                elif matrix[nY][nX] == matrix[y][x]:
                    if flag + 1 >= 2:
                        continue
                    move = dfs(nY, nX, move, flag + 1, visited)

        temp.append(move)
        return temp

    s = dfs(maxList[0][0], maxList[0][1], [], 0, visited)
    print(s)
