package main.java.player;

import main.java.information.UserInterface;

public class IASup extends IA {
    
  private boolean onInvalidMove = false;
  private MyEvaluator evaluator;
  
  public IASup(int numPlayer, String name,String symbPlayer,int numOfCol){ //super: objet père -->éditer classe de base
    super(numPlayer, name, symbPlayer,numOfCol);
    evaluator = new MyEvaluator();
  }

  @Override
  public final int play(UserInterface mInterface,double[] board){
    if (onInvalidMove){
      onInvalidMove = false;
      return (int)( Math.random() * (this.numberOfColumns) );
    }
    for (int k = 0; k < board.length; k ++){//To avoid the problem of which player will play
			if (board[k] > 0){//0 represents empty places
				if (board[k] == Double.valueOf(this.numPlayer)){
					board[k] = 1;//The player who play is represented by ones
				}
				else{
					board[k] = 2;//Other player is represented by two
				}
			}
		}
		//int i = SVC.run(board);
		//KNeighborsClassifier knn = new KNeighborsClassifier();
    //int j = knn.predict(board);
    int j = DecisionTreeClassifier.predict(board);
    int a = evaluator.evaluate(board);
    //System.out.println("predict: "+ a );
		return a;
  }
  
  @Override
  public void invalidMove(){
    this.onInvalidMove = true;
  }
	
}
