import sys
from collections import deque

sys.stdin = open("input.txt", "r", encoding="UTF-8")

N, L, R = map(int, input().split())

matrix = [list(map(int, input().split())) for _ in range(N)]

dy = [0, 0, 1, -1]
dx = [1, -1, 0, 0]

count = 0
changeList = []

def bfs(y, x):
    q = deque()
    changeList = [(y,x)]
    sumValue = 0
    q.append((y, x))
    visited = [[False] * N for _ in range(N)]
    visited[y][x] = True
    while q:
        nowY, nowX = q.popleft()
        sumValue += matrix[nowY][nowX]
        for i in range(4):
            nY = nowY + dy[i]
            nX = nowX + dx[i]
            if 0 <= nY < N and 0 <= nX < N:
                if not visited[nY][nX] and L <= abs(matrix[nY][nX] - matrix[nowY][nowX]) <= R:
                    visited[nY][nX] = True
                    changeList.append((nY, nX))
                    q.append((nY, nX))
    print(changeList)
    changeValue = sumValue // len(changeList)
    print(changeValue)
    for change in changeList:
        i, j = change
        matrix[i][j] = changeValue


while True:
    temp = 0
    for y in range(N - 1):
        for x in range(N - 1):
            if L <= abs(matrix[y][x] - matrix[y][x + 1]) <= R or L <= abs(matrix[y][x] - matrix[y + 1][x]) <= R:
                bfs(y, x)
                temp += 1

    if L <= abs(matrix[N-1][N-1] - matrix[N-1][N-2]) <= R or L <= abs(matrix[N-1][N-1] - matrix[N-2][N-1]) <= R:
        bfs(y, x)
        temp += 1
