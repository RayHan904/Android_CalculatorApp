package com.nseaf.mycalculator;

public class Calculator {
    String currentOperator = "";
    String numberString="0";
    String detailsString="";
    long intNumber;
    double realNumber;
    long intBuffer;
    double realNumberBuffer;
    boolean isIntNumber=true;
    boolean numHasRadixPoint=false;
    long memoryInt=0;
    double memoryDouble=0.0;
    boolean isIntMemory=true;

    public Calculator() {
    }

    public void processNumber(int i) {
        if(numberString.length()<12) {  // limit of 12 digits
            intNumber = intNumber * 10 + i;
            numberString = String.valueOf(intNumber);
            detailsString = "Clicked: "+i;
        }
        else
            detailsString="The number is too long..";
    }


    public  void processOperator(String s) {
        numberString = s;
        detailsString = "Operation:" + s;

            if(isIntNumber) {
                intBuffer= intNumber;
                intNumber = 0;
            }
            else {
                realNumberBuffer = realNumber;
                realNumber = 0.0;
            }
            currentOperator = s;

    }

    public void equals() {
        if(!currentOperator.isEmpty()) {
            switch (currentOperator) {
                case "+" : add(); break;
                case "-" : subs(); break;
                case "/"  : div(); break;
                case "x" : mul(); break;
                case "^" : pow(); break;
            }
        }
    }

    // operations


    public void add() {
        detailsString = "Answer";

            if(isIntNumber) {
                intNumber += intBuffer;
                numberString = String.valueOf(intNumber);
            }
            else {
                isIntNumber=false;
                realNumber += realNumberBuffer;
                numberString = String.valueOf(realNumber);
            }
    }
    public void subs() {
        detailsString = "Answer";

        if(isIntNumber) {
            intNumber = intBuffer - intNumber;
            numberString = String.valueOf(intNumber);
        }
        else {
            isIntNumber=false;
            realNumber = realNumberBuffer - realNumber;
            numberString = String.valueOf(  realNumber);
        }
    }
    public void div() {
        detailsString = "Answer";

        if(isIntNumber) {
            intNumber = intBuffer/intNumber + intBuffer % intNumber;
            numberString = String.valueOf(intNumber);
        }
        else {
            isIntNumber=false;
            realNumber = realNumberBuffer/realNumber + realNumberBuffer % realNumber;
            numberString = String.valueOf(realNumber);
        }
    }
    public void pow() {
        detailsString = "Answer";

        if(isIntNumber) {
            realNumber = Math.pow(intBuffer,intNumber);
            numberString = String.valueOf(realNumber);
        }
        else {
            isIntNumber=false;
            realNumber = Math.pow(realNumberBuffer,realNumber);

            numberString = String.valueOf(realNumber);
        }
    }
    public void mul() {
        detailsString = "Answer";

        if(isIntNumber) {
            intNumber = intBuffer * intNumber;
            numberString = String.valueOf(intNumber);
        }
        else {
            isIntNumber=false;
            realNumber = intBuffer * realNumber;
            numberString = String.valueOf(realNumber);
        }
    }

    public void radix() {
        if (isIntNumber) {
            numberString = numberString + ".";
            realNumber = (double) intNumber;
            isIntNumber = false;
        } else {

        }
    }

    public void perc() {
        numberString = String.valueOf(intNumber) + "%";
         realNumber = (double) intNumber/100;
        System.out.println("Real no:" + realNumber);
         isIntNumber = false;

    }








    public void clearClicked() {
        numberString="0";
        detailsString="";
        intNumber=0;
        realNumber=0.0;
        isIntNumber=true;
        numHasRadixPoint=false;
    }

    public void memPlusClicked() {
        if(isIntMemory){
            if(isIntNumber) {
                memoryInt += intNumber;
                detailsString = "Memory: "+memoryInt;
            }
            else {
                isIntNumber=false;
                memoryDouble = memoryInt + realNumber;
            }
        }
    }

    public void memMinusClicked() {
        if(isIntMemory){
            if(isIntNumber) {
                memoryInt -= intNumber;
                detailsString = "Memory: "+memoryInt;
            }
            else {
                isIntNumber=false;
                memoryDouble = memoryInt - realNumber;
            }
        }
    }

    public void memRecallClicked() {
        if(isIntMemory){
            if(isIntNumber) {
                numberString=String.valueOf(memoryInt);
                intNumber = memoryInt;
            }
            else {
                isIntNumber=false;
                numberString=String.valueOf(memoryDouble);
                realNumber = memoryDouble;
            }
        }
    }

    public void memClearClicked() {
        numberString="0";
        detailsString="";
        memoryInt = 0;

    }
}
