import java.lang.*;

public class CesarEncryption {
    private static final char [] alphabet = {'А', 'Б', 'В', 'Г', 'Ґ', 'Д','Е',
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
            value = new String(alphabet).indexOf(a);
            a = alphabet[(key1 * value + key2) % 33];
            res.append(a);
        }
        return res.toString();
    }
    public String decryptionAlgorithm(String str, int key1, int key2){
        String res = "";
        char a;
        int value;
        char[] ch = new char[str.length()];
        for (int i = 0; i < str.length(); i++) {
            ch[i] = str.charAt(i);
        }
        for(var i = 0; i < str.length()-2; i++){
            a = ch[i];
            value = new String(alphabet).indexOf(a);
            //to do
            res +=a;
        }

        return res;
    }

}
