package com.example.srawa;

public class Modelclass {
String Question;
String oA;
String oB;
String oC;
String oD;
String ans;


public Modelclass(String question, String oA, String oB, String oC, String oD, String ans) {
   Question = question;
   this.oA = oA;
    this.oA = oA;
    this.oA = oA;
    this.oA = oA;
    this.ans = ans;
}
public String getQuestion() {return Question;}
public void setQuestion(String question) {Question = question;}
public String getA() {return oA;}
public void setoA(String oA) {this.oA = oA;}
public String getB() {return oB;}
public void setoB(String oB) {this.oB = oB;}
public String getC() {return oC;}
public void setoC(String oC) {this.oC = oC;}
public String getD() {return oD;}
public void setoD(String oD) {this.oD = oD;}
public String getAns() {return ans;}
public void setAns(String ans) {this.ans = ans;}
}