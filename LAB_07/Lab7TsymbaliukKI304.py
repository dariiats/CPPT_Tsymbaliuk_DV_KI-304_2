import sys

rows_num = int(input("Enter size of matrix: "))
filler = input("Enter symbol-filler: ")

lst = [[filler for _ in range(i + 1)] for i in range(rows_num)]

if len(filler) == 1: 
    sizeArr = rows_num // 2 if rows_num % 2 == 0 else (rows_num // 2 + 1)
    n = 2

    for i in range(sizeArr):
        for j in range(i + 1):
            print(lst[i][j], end='')
        for j in range(rows_num - n):
            print(" ", end='')
        n += 2
        for j in range(i + 1):
            if (j == sizeArr - 1 and rows_num % 2 != 0):
                break
            print(lst[i][j], end='')
        print()

    n = 2 if rows_num % 2 == 0 else 1
    start_i = sizeArr - 1 if n == 2 else sizeArr - 2

    for i in range(start_i, -1, -1):
        for j in range(i + 1):
            print(lst[i][j], end='')
        if i <= sizeArr - 2:
            for j in range(n):
                print(" ", end='')
            n += 2
        for j in range(i + 1):
            if (j == sizeArr - 1 and rows_num % 2 != 0):
                break
            print(lst[i][j], end='')
        print()

elif len(filler) == 0:
    print("You don't write filler-symbol!")
else:
    print("Too much symbols!")




