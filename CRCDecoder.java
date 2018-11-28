
package crc;

import java.util.Scanner;

public class CRCDecoder {
   
    public static void main(String[] args) {
        int lastBitNum;
        String reminder = "", recievedData , finalData, generator, numberToDevide, result = "";
        Scanner scn = new Scanner(System.in);
        System.out.println("Enter the RecievedData:");
        recievedData = scn.nextLine();
        System.out.println("Enter the Generator:");
        generator = scn.nextLine();
        lastBitNum = generator.length();
        numberToDevide = recievedData.substring(0, lastBitNum);
        System.out.println("Number to devide: " + numberToDevide);
        for (int i = 0; i < recievedData.length(); i++) {
            result = devide(numberToDevide, generator);
            System.out.println("Result: " + result);
            lastBitNum++;
            if (lastBitNum > recievedData.length()) {
                reminder = result;
                break;
            }
            numberToDevide = result + recievedData.charAt(lastBitNum - 1);
            System.out.println("+++++++++++++++++++++++++++++++++++++++++++++");
            System.out.println("Number to devide: " + numberToDevide);
        }
        System.out.println("Reminder: " + reminder);
        if(reminder.equals("000")){
            System.out.println("No Error during transection.");
            finalData=recievedData.substring(0, recievedData.length()-(generator.length()-1));
            System.out.println("Data:");
            System.out.println(finalData);
        }
    }

    static String devide(String num, String gen) {
        String res = "", numToAdd;
        if (num.charAt(0) == '1') {
            numToAdd = gen;
        } else {
            numToAdd = gen.replace("1", "0");
        }
        for (int i = 1; i < gen.length(); i++) {
            res += num.charAt(i) ^ numToAdd.charAt(i);
        }
        return res;
    }
}
