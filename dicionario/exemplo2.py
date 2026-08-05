#Vamos supor que queremos fazer uma Cinemateca:

filmes = []

movie = {}
movie['titulo'] = 'Harry Potter e a Pedra Filosofal'
movie['genero'] = "Aventura e Fantasia"
movie['diretor'] = 'Chris Columbus'
movie['atores'] = ['Daniel Radcliffe', 'Ruper Grint', 'Emma Watson']

filmes.append(movie)

movie = {}
movie['titulo'] = 'O Diabo veste Prada'
movie['genero'] = 'Drama e Comédia'
movie['diretor'] = 'David Frankel'
movie['atores'] = ['Anne Hathaway', 'Meryl Streep', "Stanley Tucci", 'Emily Blunt']

filmes.append(movie)

for filme in filmes:
    print(filme)

movie = {}
movie['titulo'] = 'O Diabo veste Prada 2'
movie['genero'] = 'Drama e Comédia'
movie['diretor'] = 'David Frankel'
movie['atores'] = ['Anne Hathaway', 'Meryl Streep', "Stanley Tucci", 'Emily Blunt']

filmes.append(movie)

