import java.util.List;

public class TITforOtherTAT implements Agent {

	@Override
	public Action dilemma(List<Action> opponentPreviousActions) {
		// TODO Auto-generated method stub
		int size = opponentPreviousActions.size();
		if (size < 2)
			return Action.COOPERATE;
		if (opponentPreviousActions.get(size-1).equals(Action.DEFECT)
				&& opponentPreviousActions.get(size-2).equals(Action.DEFECT))
			return Action.DEFECT;
		else
			return Action.COOPERATE;
	}

}
