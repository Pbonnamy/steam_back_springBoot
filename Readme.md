Pour l'application 

Déjà il faut créer une bdd et aussi
back_end_db et aussi modifier l'uri dans application.properties qui est dans ressources

Et créer dans cette bdd une collection roles et y mettre 
````json
{
  "_id": {
    "$oid": "63adb6aa3c7fbbb5d9f62074"
  },
  "name": "ROLE_USER"
}
````
C'est le seul role autoriser pour le jwt que nous avons créer 
les endpoints

Post http://localhost:8080/api/auth/signup

Body
 ````json
{
    "username": "test",
    "email": "aristide.ff@gmail.com",
    "roles": [
        "ROLE_USER"
    ],
    "password": "testt"
    
}
````
Response

```json
{
    "message": "User registered successfully!"
}
```

Post http://localhost:8080/api/auth/signin

Body
````json
{
    "username": "test",
    "password":"testt"
}
````

Response

```json
{
    "id": "63adbc3b2fddf2119c08c92b",
    "username": "test",
    "email": "aristide.ff@gmail.com",
    "roles": [
        "ROLE_USER"
    ],
    "accessToken": "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ0ZXN0IiwiaWF0IjoxNjcyMzMwMzQzLCJleHAiOjE2NzI0MTY3NDN9.QhEdkjsNa-Tb0Wqta2S2yrwwdnN_t_8ADMKvOKhPKdD2KWG-pvqYKggmiVuoeuPYdr7S7uzx6EtiHd_vgKQ_KA",
    "tokenType": "Bearer"
}
```

POST  http://localhost:8080/api/auth/lost

Body
````json
{
    "email": "aristide.ff@gmail.com"
}
````

Reponse

````json
{
    "message": "Password change default"
}
````
Pour simplifier le tout à chaque fois le mot de passe par défaut au moment
du changement est Apple. 
On peut le changer dans ressources c'est la propriété android.app.default_password.


