import sys

sys.stdin = open("input.txt", "r", encoding="utf-8")

n = int(input())
matrix = [list(map(int, input().split())) for _ in range(n)]
start = ((0, 0), (0, 1))

result = []


def dfs(pipeArr, status):
    y1, x1 = pipeArr[0][0], pipeArr[0][1]
    y2, x2 = pipeArr[1][0], pipeArr[1][1]

    if matrix[y1][x1] == 0 and matrix[y2][x2] == 0 and y2 == n-1 and x2 == n-1:
        result.append(1)
        return

    if status == 0 or status == 2:
        nY2 = y2
        nX2 = x2 + 1
        if 0 <= nY2 < n and 0 <= nX2 < n and matrix[nY2][nX2] == 0:
            temp = ((y2, x2), (nY2, nX2))
            dfs(temp, 0)
    if status == 1 or status == 2:
        nY2 = y2 + 1
        nX2 = x2
        if 0 <= nY2 < n and 0 <= nX2 < n and matrix[nY2][nX2] == 0:
            temp = ((y2, x2), (nY2, nX2))
            dfs(temp, 1)

    nY2 = y2 + 1
    nX2 = x2 + 1
    if (0 <= nY2 < n and 0 <= nX2 < n
            and matrix[nY2][nX2] == 0
            and matrix[nY2][x2] == 0
            and matrix[y2][nX2] == 0
        ):
        temp = ((y2, x2), (nY2, nX2))
        dfs(temp, 2)


dfs(start, 0)

print(sum(result))
