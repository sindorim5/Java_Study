import sys

sys.stdin = open("./input.txt", "r", encoding="utf-8")

n = int(input())
switchList = list(map(int, input().split()))

# 위치 맞추기
switchList.insert(0, 0)

student = int(input())
setList = []
for _ in range(student):
    setList.append(list(map(int, input().split())))

for s in setList:
    gender, number = s[0], s[1]

    if gender == 1:
        while number < len(switchList):
            if switchList[number] == 0:
                switchList[number] = 1
            else:
                switchList[number] = 0
            number += number
    else:
