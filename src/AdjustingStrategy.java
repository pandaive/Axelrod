import java.util.List;
import java.util.Random;


public class AdjustingStrategy implements Agent {

	double count = 0.0;
	
	//just in case player can't remember calculations for whole game
	//I put the counting of cooperates in separate method
	//it's much less effective though as it calculates repeatedly the same
	private double count(List<Action> opponentPreviousActions){
		double c = 0.0;
		for (Agent.Action a : opponentPreviousActions) {
			if (a.equals(Action.COOPERATE))
				c += 1.0;
		}
		return c;
	}
	
	@Override
	public Action dilemma(List<Action> opponentPreviousActions) {
		//play cooperate in first move
		if (opponentPreviousActions.isEmpty())
			return Agent.Action.COOPERATE;
		
		int size = opponentPreviousActions.size();
		
		//count probability
		double p = count(opponentPreviousActions)/((double) size);
		
		Random random = new Random();
		double r = random.nextDouble();
		
		//if opponent played defect then we decrease p significantly because we want more to defect
		//even if he mostly played cooperate
		if (opponentPreviousActions.get(size-1).equals(Action.DEFECT))
			p = p/2;
		if (r <= p) {
				return Agent.Action.COOPERATE;
			}
			else {
				return Agent.Action.DEFECT;
			}
	}
}
