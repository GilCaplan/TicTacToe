package com.example.crosscircle_gilcaplan;

public class Controller {
    private Model myM;
    private String turn;//x or 0
    public Controller(){
        myM= new Model();
        this.turn=turn;
    }
    public String turn(){
        if (turn=="x"){ turn = "0";}
        else{ turn ="x";}
        return turn;
    }
    public void filler(int x){
        myM.fill(turn,x);
    }
    public void start(){
        myM.startGame();
    }
    public String checkspottey(int check){
        return myM.checkspot(check);
    }
    public String checkwinner(){ return myM.winner(); }
}
