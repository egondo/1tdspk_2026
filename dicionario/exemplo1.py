atores = {}

atores['Leonardo DiCaprio'] = 'Titanic'
atores['Clint Eastwood'] = 'Curvas da Vida'
atores['Anne Hathaway'] = 'Diabo veste Prada 2'
atores['Jamie Foxx'] = 'Django Livre'

#print(atores)
ator = input("Digite um ator(atriz): ")

if ator in atores:
    filme = atores[ator]
    print(f"O {ator} participou do filme: {filme}")
else:
    print(f"O {ator} não foi encontrado no dicionário!")

for chave in atores:
    print(f"{chave} => {atores[chave]}")     