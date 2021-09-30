# trello2eisenhower
Generates Eisenhower Decision Matrix from a trello board
This application was inspired by [Jennifer Wadella's keynote : Hacking your work life __ balance to take over the world](https://marc-bouvier.github.io/2018/08/13/hacking-your-work-life-balance-Jennifer-Wadella/) 

## Roadmap
* [X] Bootstrap project with vue-cli 3.0.0
* [X] Bootstrap Architecture Decision Records
* [ ] Quadrant view
  * [ ] Quadrant component
* [ ] Graph view 
  * [ ] X -> urgence
  * [ ] Y -> importance
  * [ ] Circle size -> effort required
* [ ] Trello API communication
  * [ ] Get and setup externalized trello API key
* [ ] User highlight
* [ ] Multi-user
* [ ] Load trello data to VueX State
  * [ ] Load Quadrants title
  * [ ] Load Board metadata -> Labels with colors == category
  * [ ] Load Cards title
    * [ ] extract effort value
    * [ ] extract title
* [ ] Link to a board feature
* [ ] propose trello board sample to fork
* [ ] Host and promote the application to Trello newsletter
* [ ] Autogenerate board from API ?


## Project setup
```
npm install
```

### Compiles and hot-reloads for development
```
npm run serve
```

### Compiles and minifies for production
```
npm run build
```

### Lints and fixes files
```
npm run lint
```
