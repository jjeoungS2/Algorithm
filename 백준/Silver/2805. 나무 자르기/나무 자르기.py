n,m = map(int,input().split())
arr = list(map(int,input().split()))

start = 0
end = max(arr)

while start <= end:
    target = (start+end) // 2
    s = 0

    for i in range(n):
        if target <= arr[i]:
            s += arr[i] - target

    if s >= m:
        start = target + 1
    else:
        end = target - 1

print(end)