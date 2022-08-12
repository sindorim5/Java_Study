import sys
from collections import deque
sys.stdin = open("input.txt", "r", encoding="utf-8")

n = int(input())
matrix = [list(map(int, input().split())) for _ in range(n)]
q = deque()
zero = ((0, 0), (0, 1), 0)
cnt = 0

q.append(zero)
while q:
    start, end, status = q.popleft()
    y1, x1 = start[0], start[1]
    y2, x2 = end[0], end[1]

    if matrix[y1][x1] == 0 and matrix[y2][x2] == 0 and y2 == n-1 and x2 == n-1:
        cnt += 1
        continue

    if status == 0 or status == 2:
        nY2 = y2
        nX2 = x2 + 1
        if 0 <= nY2 < n and 0 <= nX2 < n and matrix[nY2][nX2] == 0:
            temp = ((y2, x2), (nY2, nX2), 0)
            q.append(temp)
    if status == 1 or status == 2:
        nY2 = y2 + 1
        nX2 = x2
        if 0 <= nY2 < n and 0 <= nX2 < n and matrix[nY2][nX2] == 0:
            temp = ((y2, x2), (nY2, nX2), 1)
            q.append(temp)

    nY2 = y2 + 1
    nX2 = x2 + 1
    if (0 <= nY2 < n and 0 <= nX2 < n
            and matrix[nY2][nX2] == 0
            and matrix[nY2][x2] == 0
            and matrix[y2][nX2] == 0
            ):
        temp = ((y2, x2), (nY2, nX2), 2)
        q.append(temp)

print(cnt)
