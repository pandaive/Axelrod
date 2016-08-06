import java.util.ArrayList;
import java.util.List;

public class Tournament {
	
	static final int N =10; //number of rounds
	static final int NB_P = 6; //number of player
	
	static final int COOP = 0;
	static final int DEF = 1;
	static final int TFT = 2;
	static final int TFOT = 3;
	static final int MIX = 4;
	static final int MY_STRATEGY = 5;
	
	static Cooperative coop;
	static Defect def;
	static TITforTAT tft;
	static TITforOtherTAT tfot;
	static Mixed mix;
	static AdjustingStrategy atfot;
	
	private static double[] scores(List<Agent.Action> first, List<Agent.Action> second){
		double[] score = {0.0, 0.0};
		
		for (int i = 0; i < N; i++) {
			if (first.get(i).equals(second.get(i)))
				if (first.get(i).equals(Agent.Action.COOPERATE)) {
					score[0] += 3.0;
					score[1] += 3.0;
				}
				else {
					score[0] += 2.0;
					score[1] += 2.0;
				}
			else if (first.get(i).equals(Agent.Action.COOPERATE)) {
				score[1] += 5.0;
			}
			else
				score[0] += 5.0;
		}	
		score[0] /= (double)N;
		score[1] /= (double)N;
		return score;
	}
	
	private static double[] play(int first, int second) {
		List<Agent.Action> firstPlayer = new ArrayList<Agent.Action>();
		List<Agent.Action> secondPlayer = new ArrayList<Agent.Action>();
		
		for (int i = 0; i < N; i++) {			
			Agent.Action tempChoice = choice(first, secondPlayer);
			secondPlayer.add(choice(second, firstPlayer));
			firstPlayer.add(tempChoice);
		}
		
		double scores[] = scores(firstPlayer, secondPlayer);
		
		return scores;
	}
	
	private static Agent.Action choice(int i, List<Agent.Action> list){
		switch(i) {
		case COOP:
			return coop.dilemma(list);
		case DEF:
			return def.dilemma(list);
		case TFT:
			return tft.dilemma(list);
		case TFOT:
			return tfot.dilemma(list);
		case MIX:
			return mix.dilemma(list);
		case MY_STRATEGY:
			return atfot.dilemma(list);
		}
		
		return null;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		coop = new Cooperative();
		def = new Defect();
		tft = new TITforTAT();
		tfot = new TITforOtherTAT();
		mix = new Mixed();
		atfot = new AdjustingStrategy();

		double[] f_scores = new double[NB_P];
		
		for (int i = 0; i < NB_P; i++)
			f_scores[i] = 0.0;
		double[] tempScores;
		
		System.out.println("Running tournament for " + N + " rounds..");
		for (int i = 0; i < NB_P; i++)
			for (int j = 0 ; j < NB_P && j != i; j++) {
				tempScores = play(i,j);
				f_scores[i] += tempScores[0];
				f_scores[j] += tempScores[1];
			}
		
		for (int i = 0; i < NB_P; i++) {
			f_scores[i] /= ((double)NB_P-1.0);
			System.out.println("F_SCORE for " + (i+1) + " = " + f_scores[i]);
		}
	}
}