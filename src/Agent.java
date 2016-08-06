import java.util.List;

/***
 * An interface to be implemented by all the players
 */
public interface Agent {
    /***
     * Possible choices in the prisoner's dilemma
     */
    public enum Action {COOPERATE, DEFECT}

    /***
     * Choose an action based on the opponent's previous actions
     * @param opponentPreviousActions opponent's actions from the previous rounds,
     *                                empty list if it is the first round
     * @return action of the player in the current round
     */
    Action dilemma(List<Action> opponentPreviousActions);
}