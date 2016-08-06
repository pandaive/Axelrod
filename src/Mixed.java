import java.util.List;
import java.util.Random;

public class Mixed implements Agent {
	
	double p;
	double q;
	TITforTAT tft;
	TITforOtherTAT tfot;
	
	public Mixed(){
		p = 2.0/3.0; //probability of tit-for-tat
		q = 1.0 - p; //probability of tit-for-other-tat
		tft = new TITforTAT();
		tfot = new TITforOtherTAT();
		
	}

	@Override
	public Action dilemma(List<Action> opponentPreviousActions) {
		// TODO Auto-generated method stub
		Random random = new Random();
		if ((random.nextDouble()) <= p) {
			return tft.dilemma(opponentPreviousActions);
		}
		else {
			return tfot.dilemma(opponentPreviousActions);
		}
	}

}