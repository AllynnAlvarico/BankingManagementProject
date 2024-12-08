package util;

public class DataUtilities {

    public String capitalise(String str){
        if (str == null || str.isEmpty()) return str;

        String[] words = str.split(" ");
        StringBuilder result = new StringBuilder();

        for (String word : words) {
            result.append(word.substring(0, 1).toUpperCase()).append(word.substring(1)).append(" ");
        }
        return result.toString().trim();
    }

    public String generateAccountNumber(){
        int min = 1001;
        int max = 9999;
        int range = max - min;
        int randomNum = (int)(Math.random() * range)+ min;

        return "ACC" + randomNum + " " + randomNum + " " + randomNum;
    }
    public String generateCardNumber(){
        int min = 1001;
        int max = 9999;
        int range = max - min;
        int randomNum = (int)(Math.random() * range)+ min;
        return randomNum + " " + randomNum + " " + randomNum;
    }
    public int generatePin(){
        int min = 1001;
        int max = 9999;
        int range = max - min;
        return (int)(Math.random() * range)+ min;
    }
}
