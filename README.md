# Search Algorithms in AI
In this project I implement most of the classical search algorithms using in AI, such as:
- Breath First Search(BFS)
- Depth First Search(DFS)
- Depth First Search(DFS) limited depth
- iterative deepening Depth First Search(DFS)
- uniform cost search
- greedy best first search
- A* (A star)

## How to use
To use these search algorithms for solving your problem, you should define your problem and it's state classes that extends from Problem and State class.

Use `MyProblem extends Problem` and `MyProblemState extends State` to achieve that.

For example, I model a navigation problem in Romania that should find a path from Arad to Bucharest, I solved it by defining NavigationProblem and NavState classes and use search algorithms. You can see the map of the cities below:

![picture](images/RomaniaMap.png)
  
 You can also see the CityIDs that I assume below:
 
 0. Arad
 1. Zerind
 2. Oradea
 3. Sibia
 4. Timisoara
 5. Lugoj
 6. Mehadia
 7. Dobreta
 8. Craiova
 9. Rimnicu Vilcea
 10. Pitesti
 11. Fagaras
 12. Bucharest
 13. Giurgiu
 14. Urziceni
 15. Hirsova
 16. Eforie
 17. Vaslui
 18. Iasi
 19. Neamt