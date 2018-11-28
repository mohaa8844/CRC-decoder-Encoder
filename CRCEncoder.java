/*SnowLeopard */
package crc;

import java.util.Scanner;

public class CRC {

    public static void main(String[] args) {
        int lastBitNum;
        String reminder = "", data = "", dataWithZeros, generator, dataToSend = "", numberToDevide,result="";
        Scanner scn = new Scanner(System.in);
        System.out.println("Enter the Data:");
        data = scn.nextLine();
        dataWithZeros = data;
        System.out.println("Enter the Generator:");
        generator = scn.nextLine();
        lastBitNum = generator.length();
        for (int i = 0; i < generator.length() - 1; i++) {
            dataWithZeros += "0";
        }
        System.out.println("data with zeros: "+dataWithZeros);
        
            numberToDevide = dataWithZeros.substring(0, lastBitNum);
            System.out.println("Number to devide: "+numberToDevide);
        for (int i = 0; i < dataWithZeros.length(); i++) {
            result=devide(numberToDevide,generator);
            System.out.println("Result: "+ result);
            lastBitNum++;
            if (lastBitNum > dataWithZeros.length()) {
                reminder = result;
                break;
            }
            numberToDevide=result+dataWithZeros.charAt(lastBitNum-1);
            System.out.println("+++++++++++++++++++++++++++++++++++++++++++++");
            System.out.println("Number to devide: "+numberToDevide);
        }
        System.out.println("Reminder: "+reminder);
    }
    static String devide(String num,String gen){
     String res="",numToAdd;
     if(num.charAt(0)=='1'){
         numToAdd=gen;
     }else{
         numToAdd=gen.replace("1", "0");
     }
     for(int i=1;i<gen.length();i++){
         res+=num.charAt(i)^numToAdd.charAt(i);
     }
     return res;
    } 
}
