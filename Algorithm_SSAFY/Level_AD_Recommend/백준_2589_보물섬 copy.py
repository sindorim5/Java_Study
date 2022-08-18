import sys
from collections import deque


sys.stdin = open("input.txt", "r", encoding="utf-8")
input = sys.stdin.readline

dy = [0, 0, 1, -1]
dx = [1, -1, 0, 0]


def bfs(y, x):
    visited = [[0] * m for _ in range(n)]
    q = deque([(y, x)])
    depth = 0
    while q:
        y, x = q.popleft()
        for i in range(4):
            nY = y + dy[i]
            nX = x + dx[i]
            if 0 <= nY < n and 0 <= nX < m and matrix[nY][nX] == "L" and visited[nY][nX] == 0:
                visited[nY][nX] = visited[y][x] + 1
                depth = max(visited[nY][nX], depth)
                q.append((nY, nX))
    return depth


n, m = map(int, input().split())
matrix = [list(input().rstrip()) for _ in range(n)]
maxDepth = 0
result = []

for y in range(n):
    for x in range(m):
        if matrix[y][x] == "L":
            depth = bfs(y, x)
            result.append(depth)
            if maxDepth < depth:
                maxDepth = depth

print(maxDepth)
print(result)
