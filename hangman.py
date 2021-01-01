man = ["-----\n|   |\n|\n|\n|\n-----\n",
"-----\n|   |\n|   0\n|\n|\n-----\n",
"-----\n|   |\n|   0\n|   |\n|\n-----\n",
"-----\n|   |\n|   0\n|  ||\n|\n-----\n",
"-----\n|   |\n|   0\n|  |||\n|\n-----\n",
"-----\n|   |\n|   0\n|  |||\n|  /\n-----\n",
"-----\n|   |\n|   0\n|  |||\n|  / \\ \n-----\n"]

word = "word".lower()

usedLetter = []

development = 0

def fake_word(word, guessed):
    temp = ""
    for i in word:
        if i in guessed or i == ' ':
            temp = temp + "{} ".format(i)
        else :
            temp = temp + "_ "
    return temp

lose = False
win = False

while True:
    x = input("Guess a letter: ")
    right = False
    if len(x) != 1 or type(x) == int or ' ' == x:
        print("Guess one letter please")
        continue
    if x in usedLetter:
        print("You already guessed that letter")
    else:
        usedLetter.append(x)
        if x in word:
            print("You guessed right")
            right = True
        else:
            development += 1
            if development >= len(man)-1:
                lose = True
            print("You guessed wrong")
            right = False

        finalWord = fake_word(word, usedLetter)
        if "_" not in finalWord:
            win = True

        print(man[development])
        print()
        print(finalWord)

        if win:
            print("You Won")
            break
        if lose:
            print("You failed")
            break
