import sys
from collections import deque
sys.stdin = open("0915/화학물질2.txt", "r", encoding="UTF-8")

for tc in range(1, int(input())+1):
    N = int(input())
    maps = [list(map(int, input().split())) for _ in range(N)]
    M_temp = []
    for i in range(N):
        for j in range(N):
            if maps[i][j] > 0:
                a, b = i, j
                while b < N and maps[i][b] > 0:
                    b += 1
                while a < N and maps[a][j] > 0:
                    a += 1
                M_temp.append([a - i, b - j])
                for m in range(i, a):
                    for n in range(j, b):
                        maps[m][n] = 0
    M = []
    for i in range(len(M_temp)):
        b = 0
        cur = M_temp[i]
        M.append(cur)
        while 1:
            found = 0
            for s in M_temp:
                if s[0] == cur[1]:
                    cur = s
                    M.append(s)
                    found = 1
                    break
            if len(M) == len(M_temp):
                b = 1
                break
            if found == 0:
                M.clear()
                break
        if b == 1:
            break

    size = len(M)

    d = []
    DP = [[0] * size for _ in range(size)]
    for m in M:
        d.append(m[0])
    d.append(M[-1][1])
    print(d)
    for diag in range(1, size):
        for i in range(size-diag):
            j = i + diag
            DP[i][j] = 2**43
            for k in range(i, j):
                DP[i][j] = min(DP[i][j], DP[i][k] + DP[k+1]
                               [j] + d[i-1]*d[k]*d[j])
    print(f'#{tc} {DP[0][size-1]}')
