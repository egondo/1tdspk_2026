palavra = input("Digite a palavra: ").lower()

dic = {}

for letra in palavra:
    if not letra in dic:
        dic[letra] = 1
    else:
        valor = dic[letra]
        dic[letra] = valor + 1

for l in dic:
    print(f"{l} => {dic[l]}" )