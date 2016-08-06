# Programming Axelrod Tournament
Project for Multi-agent systems and game theory on NTNU (Norwegian University of Science and Technology)
The project is an implementation of Axelrod Tournament (Prisoner's Dilemma)

Project information:
This assignment is similar to Axelrod’s tournament of iterated prisoner’s dilemma. Axelrod arranged
this tournament while he was studying how cooperation can be evolved. Axelrod’s main field is
political science and he used the ”evolution of cooperation” in political science but also in many other
disciplines, among others, for understanding how cancer cells evolve cancer tumors (you may want to
see the references at the end of this text).
In this task, you will compare different playing strategies to see their ability to promote cooperation
when they play an unknown (to the players) number of rounds (N).
You will arrange a tournament where each player plays with 5 other players. Therefore, there will be
6 players each of which with a different playing strategy. The strategies are:
1. The agent plays always cooperatively
2. The agent plays always defect
3. TIT-for-TAT (see the text book)
4. TIT-for-every-other-TAT (defects only if the last two actions of the opponent are defect,
cooperate otherwise)
5. A mixture of two of the strategies above (using any definition of mixture you want)
6. Your own strategy. If you can, try to find a strategy that beats all of the above strategies.

