import java.lang.*;


public class CesarEncryption2 {
    private final String keyString;
    private final String enteredString;
    private final int key;
    private static final char [] alphabet = {'А', 'Б', 'В', 'Г', 'Ґ', 'Д','Е',
            'Є','Ж','З','И','І','Ї','Й','К','Л','М',
            'Н','О','П','Р','С','Т','У','Ф','X','Ц','Ч','Ш','Щ','Ь','Ю','Я'};

    public CesarEncryption2(String keyString, String enteredString, int key) {
        this.keyString = keyString;
        this.enteredString = enteredString;
        this.key = key;
    }

    public String encryptionAlgorithm(){
        StringBuilder res = new StringBuilder();
        char [] keyArray = keyString.toCharArray();
        int [] indexes = new int[keyArray.length];
        int [] values = new int[enteredString.length()]; //enteredString indexes

        char [] arrayWithoutCharsOfKeyWord = new char[26];
        char [] enteredArray = enteredString.toCharArray();
        for(int j = 0, counter = 0; j < enteredArray.length; j++){
            for (int i = 0; i < alphabet.length; i++){
                if(enteredArray[j] == alphabet[i]){
                    values[counter] = i;
                    counter++;
                }
            }
        }
        //find arrayWithoutCharsOfKeyWord
        for(int i = 0, counter = 0; i < alphabet.length; i++){
            for (char c : keyArray) {
                if (alphabet[i] == c) {
                    indexes[counter] = i;
                    counter++;
                }
            }
        }
        for(int i = 0, counter = 0, j = 0;  i < alphabet.length && j < keyArray.length; i++){
            if(i == indexes[j]){
                j++;
                if(j==keyArray.length){
                    j = 0;
                }
            }
            else {
                arrayWithoutCharsOfKeyWord[counter] = alphabet[i];
                counter++;

            }
        }
        //crete new key alphabet
        boolean flag1 = true;
        boolean flag2 = true;
        char [] keyAlphabet = new char[alphabet.length];
        for(int i = key, j = 0;  i < alphabet.length+1; i++){
            if(!flag1){
                keyAlphabet[i] = arrayWithoutCharsOfKeyWord[j];
                j++;
                if(j == arrayWithoutCharsOfKeyWord.length){
                    break;
                }
                if(i+1 == alphabet.length && flag2){
                    i = -1;
                    flag2 = false;
                    System.out.println("HERE YOU ARE");
                }
            }
            else {
                keyAlphabet[i] = keyArray[i-key];
                if(i - key >= keyArray.length-1){
                    flag1 = false;
                }
            }
        }
        for (char c : keyAlphabet) {
            System.out.println(c);
        }
        for (int value : values) {
            System.out.println(value);
        }
        for (int value : values) {
            res.append(keyAlphabet[value]);
        }
        return res.toString();
    }

}
