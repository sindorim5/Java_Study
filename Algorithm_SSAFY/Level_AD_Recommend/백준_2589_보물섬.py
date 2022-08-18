import sys

sys.stdin = open("input.txt", "r", encoding="utf-8")
input = sys.stdin.readline

dy = [0, 0, 1, -1]
dx = [1, -1, 0, 0]


def dfs(y, x, depth):
    global maxDepth
    if maxDepth < depth:
        maxDepth = depth
    for i in range(4):
        nY = y + dy[i]
        nX = x + dx[i]
        if 0 <= nY < n and 0 <= nX < m and matrix[nY][nX] == "L" and visited[nY][nX] == False:
            visited[nY][nX] = True
            dfs(nY, nX, depth + 1)


n, m = map(int, input().split())
visited = [[False] * m for _ in range(n)]
matrix = [list(input().rstrip()) for _ in range(n)]
maxDepth = 0

for y in range(n):
    for x in range(m):
        if matrix[y][x] == "L":
            # visited[y][x] = True
            dfs(y, x, 0)
            # visited[y][x] = False

print(maxDepth)
