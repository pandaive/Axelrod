import java.util.List;

public class TITforTAT implements Agent {

	@Override
	public Action dilemma(List<Action> opponentPreviousActions) {
		// TODO Auto-generated method stub
		if (opponentPreviousActions.isEmpty())
			return Action.COOPERATE;

		return opponentPreviousActions.get(opponentPreviousActions.size()-1);
	}

}
