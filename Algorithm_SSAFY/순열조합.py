def combination(arr, r):
    # 1.
    arr = sorted(arr)

    # 2.
    def generate(chosen):
        if len(chosen) == r:
            print(chosen)
            return

        # 3.
        start = arr.index(chosen[-1]) + 1 if chosen else 0
        for nxt in range(start, len(arr)):
            chosen.append(arr[nxt])
            generate(chosen)
            chosen.pop()
    generate([])


def combi(numList, targetNum):
    global result

    def combination(idx, nowCombi):
        if len(nowCombi) == targetNum:
            result.append(nowCombi)
            return
        for i in range(idx, len(numList)):
            combination(i + 1, nowCombi + [numList[i]])

    combination(0, [])

    return result

# 순열


def permutation(arr, r):
    # 1.
    arr = sorted(arr)
    used = [0 for _ in range(len(arr))]

    def generate(chosen, used):
        # 2.
        if len(chosen) == r:
            print(chosen)
            return

        # 3.
        for i in range(len(arr)):
            if not used[i]:
                chosen.append(arr[i])
                used[i] = 1
                generate(chosen, used)
                used[i] = 0
                chosen.pop()
    generate([], used)


def dfs(nums, depth, targetNum, temp):
    global result
    visited = [False for _ in range(len(nums))]
    if depth == targetNum:
        result.append(temp[:])
        return

    for i in range(len(nums)):
        if visited[i] == True:
            continue
        temp.append(nums[i])
        visited[i] = True
        dfs(depth + 1, temp)
        temp.pop()
        visited[i] = False
