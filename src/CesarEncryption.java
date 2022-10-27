import java.lang.*;
import java.util.*;

public class CesarEncryption {
    //private int key1, key2;
    //private String str;
    private static final char [] array = {'А', 'Б', 'В', 'Г', 'Ґ', 'Д','Е',
            'Є','Ж','З','И','І','Ї','Й','К','Л','М',
            'Н','О','П','Р','С','Т','У','Ф','X','Ц','Ч','Ш','Щ','Ь','Ю','Я'};
    public String encryptionAlgorithm(String str, int key1, int key2){
        StringBuilder res = new StringBuilder();
        char a;
        int value;
        char[] ch = new char[str.length()];
        for (int i = 0; i < str.length(); i++) {
            ch[i] = str.charAt(i);
        }
        for(var i = 0; i < str.length(); i++){
            a = ch[i];
            value = new String(array).indexOf(a);
            //a = Arrays.asList(array).contains((key1 * value + key2) % 33);
            a = array[(key1 * value + key2) % 33];
            res.append(a);
        }
        return res.toString();
    }
}
