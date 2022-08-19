import sys

sys.stdin = open("input.txt", "r", encoding="utf-8")

t = int(input())
for test_case in range(t):
    memorySize, codeSize, inputSize = map(int, input().split())
    codeList = list(input())
    inputList = list(input())

    pointer = 0

    print(codeList)
    print(inputList)

    for code in codeList:
        if code == "+":

        elif code == "-":

        elif code == "<":

        elif code == ">":

        elif code == "[":

        elif code == "]":

        elif code == ".":

        elif code == ",":
