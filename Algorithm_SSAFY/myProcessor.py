import sys

sys.stdin = open("input.txt", "r", encoding="UTF-8")

T = int(input())

for test_case in range(1, T+1):
    n = int(input())
    coreList = []
    maxCount = -1
    minLine = 999999999
    dy = [1, -1, 0, 0]  # 상 하 좌 우
    dx = [0, 0, 1, -1]

    matrix = [list(map(int, input().split())) for _ in range(n)]

    for y in range(1, n-1):
        for x in range(1, n-1):
            if matrix[y][x] == 1:
                coreList.append((y, x))

    coreCount = len(coreList)

    def lineCheck(y, x):
        direction = [0, 0, 0, 0]
        for i in range(4):
            nY, nX = y, x
            length = 0
            while 0 < nY < n - 1 and 0 < nX < n - 1:
                length += 1
                nY += dy[i]
                nX += dx[i]
                if matrix[nY][nX]:
                    break
            else:
                direction[i] = length
        return direction

    def check(depth, nowLine, nowConnected):
        y, x = coreList[depth][0], coreList[depth][1]

    print("#{} {}".format(test_case, minLine))
