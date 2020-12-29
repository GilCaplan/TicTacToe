package com.example.crosscircle_gilcaplan;

public class Model {
    private String[] luach= new String[9];//creates the platform
    private String check;
    public Model(){
        this.luach=luach;
        this.check=check;
    }
    public void startGame(){
            for(int i=0; i<9;i++){
                    luach[i]="";
            }
    }
    public String checkspot(int checker){
        if(luach[checker]== "x" ){
            return "x";
        }
        else if(luach[checker]== "0"){
            return "0";
        }
        else{
            return "";
        }
    }
    public void fill(String turn, int turns){
        if(turn== "x"){
            luach[turns]="x";
        }
        else if(turn == "0"){
            luach[turns]="0";
        }

    }
    public String winner(){
        if( (luach[0]=="x" && luach[1]=="x" &&luach[2]=="x") || (luach[3]=="x" && luach[4]=="x" &&luach[5]=="x") ||  (luach[6]=="x" && luach[7]=="x" &&luach[8]=="x") ||   (luach[0]=="x" && luach[3]=="x" &&luach[6]=="x") || (luach[1]=="x" && luach[4]=="x" &&luach[7]=="x") ||  (luach[2]=="x" && luach[5]=="x" &&luach[8]=="x") ||  (luach[0]=="x" && luach[4]=="x" &&luach[8]=="x") ||  (luach[6]=="x" && luach[4]=="x" &&luach[2]=="x") ){
            this.check= "x";//x is winner
        }
        else if( (luach[0]=="0" && luach[1]=="0" &&luach[2]=="0") || (luach[3]=="0" && luach[4]=="0" &&luach[5]=="0") ||  (luach[6]=="0" && luach[7]=="0" &&luach[8]=="0") ||   (luach[0]=="0" && luach[3]=="0" &&luach[6]=="0") || (luach[1]=="0" && luach[4]=="0" &&luach[7]=="0") ||  (luach[2]=="0" && luach[5]=="0" &&luach[8]=="0") ||  (luach[0]=="0" && luach[4]=="0" &&luach[8]=="0") ||  (luach[6]=="0" && luach[4]=="0" &&luach[2]=="0") ){

            this.check="0";//0 is winner
        }
        else{
            int sum=0;
            for (int i=0;i<luach.length;i++){
                    if(luach[i]=="x"|| luach[i]=="0"||checkspot(i)=="filled"){
                        sum++;
                }
            }
            if(sum==9){
                this.check="tie";
            }
            else{
                check=" ";
            }
        }
            return check;
    }
}
