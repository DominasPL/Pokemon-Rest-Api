![il_794xN 1036925932_92aj](https://user-images.githubusercontent.com/47396707/64368441-a061c580-d01a-11e9-997e-6acca7fab6b9.jpg)

# Pokemon-Rest-Api
It is a simple first generation pokemon Rest Web Service. There are endpoints which can be accessed sending HTTP requests. 
In response you will receive data like pokemon name, pokemon types etc. in JSON format. All endpoints are described below.

## Endpoints
#### Pokemons
* `(GET) /api/v1/pokemons` - to get all pokemons (pokemon name, pokemon types, pokemon base stats) sorted by pokemon name with 
active state,
* `(GET) /api/v1/pokemons/pokemon/{id}` - to get a pokemon by id (pokemon name, pokemon types, pokemon base stats). A pokemon must
have active state,
* `(POST) /api/v1/pokemons/pokemon` - to create a new pokemon. It is necessary to send pokemon name, pokemon types, pokemon base
stats in JSON format,
* `(PUT) /api/v1/pokemons/pokemon/pokemon/{id}` - to edit a pokemon or create a new pokemon when it is not in rest api. A pokemon
must have active state to edit its data. It is necessary to send pokemon name, pokemon types, pokemon base stats in JSON format,
* `(DELETE) /api/v1/pokemons/pokemon/pokemon` - to delete a pokemon from rest api. A pokemon is not removed from database.
This request change only pokemon state to not active.

![p1](https://user-images.githubusercontent.com/47396707/64370808-7d85e000-d01f-11e9-82a2-a9fcdb01efaf.png)
![p6](https://user-images.githubusercontent.com/47396707/64371023-e3726780-d01f-11e9-88e8-ffe9ffd25fdd.png)
![p3](https://user-images.githubusercontent.com/47396707/64370840-8c6c9280-d01f-11e9-8806-34324a02167f.png)
![p4](https://user-images.githubusercontent.com/47396707/64370852-91c9dd00-d01f-11e9-8a37-d3c70b1faacf.png)
![p5](https://user-images.githubusercontent.com/47396707/64370864-98585480-d01f-11e9-8ff0-680d2f4ecf05.png)

#### Types
* `(GET) /api/v1/pokemons/types` - to get all pokemon types (type name) sorted by type name with active state,
* `(GET) /api/v1/pokemons/types/type/{id}` - to get a type by id (type name). A type must have active state,
* `(POST) /api/v1/pokemons/types/type` - to create a new type. Only type name is required,
* `(PUT) /api/v1/pokemons/types/type/{id}` - to edit a type or create a new type when it is not in rest api. A type must have 
active state. Only type name is required,
* `(DELETE) /api/v1/pokemons/types/type{id}` - to delete a type from rest api. A type is not removed from database. 
This request change type state to not active. It also change pokemon state to not active when it has this type.

![t1](https://user-images.githubusercontent.com/47396707/64371289-81fec880-d020-11e9-9f55-d1d571a6987d.png)
![t2](https://user-images.githubusercontent.com/47396707/64371302-87f4a980-d020-11e9-98c1-fa93cad8f598.png)
![t3](https://user-images.githubusercontent.com/47396707/64371311-8f1bb780-d020-11e9-9510-5360e94a2533.png)
![t4](https://user-images.githubusercontent.com/47396707/64371320-9347d500-d020-11e9-8639-3a7ae4b8a989.png)
![t5](https://user-images.githubusercontent.com/47396707/64371354-a5297800-d020-11e9-86b9-51236cf523c3.png)

## Technologies
- Java
- REST
- Spring
- Spring Boot
- Spring Security
- Hibernate
- MySQL
- Tomcat
- Lombok
- Postman

## Database structure
![data](https://user-images.githubusercontent.com/47396707/64371699-87a8de00-d021-11e9-8103-92079fd3c4be.png)

