public class Vigenere {
    private static final char [] alphabet = {'А', 'Б', 'В', 'Г', 'Ґ', 'Д','Е',
            'Є','Ж','З','И','І','Ї','Й','К','Л','М',
            'Н','О','П','Р','С','Т','У','Ф','X','Ц','Ч','Ш','Щ','Ь','Ю','Я'};
    private int SIZE = alphabet.length;
    private char [][] createTable() {
        char[][] table = new char[SIZE+2][SIZE+2];
        int k = 0;
        for (int i = 0; i < SIZE+1; i++) {
            for (int j = 0; j < SIZE+1; j++) {
                if(i == 0 && j == 0){
                    table[0][0] = '_';
                }
                else if(i+j < SIZE+1){
                    k = j+i-1;
                    table[i][j] = alphabet[k];
                    if(k == SIZE-1)
                    {
                        k = 0;
                    }
                }
                else{
                    if(k < SIZE+1){
                        table[i][j] = alphabet[k];
                        k++;
                    }
                    else
                        break;
                }
            }
        }
        return table;
    }
    public String EncryprionAlgirithm(String str, String keyString){
        StringBuilder res = new StringBuilder();
        char [][]table = createTable();
        char [] strChar = str.toCharArray();
        char [] CharArray;
        CharArray = keyString.toCharArray();
        char [] keyCharArray = new char[str.length()];
        if(str.length()>keyString.length()){
            for(int i = 0, k = 0; i < keyString.length(); i++){
                keyCharArray[k] = CharArray[i];
                k++;
                if(i == keyString.length()-1){
                    i = -1;
                }
                if(k == str.length()){
                    break;
                }
            }
        }
        else {
            keyCharArray = CharArray;
        }

        //start encryption algorithm
        int [] indexesStr = new int[str.length()];
        int [] indexesKey = new int [str.length()];
        for(int i = 0, j = 0; j < keyCharArray.length && i < SIZE; i++){
            if(keyCharArray[j] == alphabet[i]){
                indexesKey[j] = i;
                j++;
                i = -1;
            }
        }

        for(int i = 0, j = 0; j < str.length() && i < SIZE; i++){
            if(strChar[j] == alphabet[i]){
                indexesStr[j] = i;
                j++;
                i = -1;
            }
        }

        for(int i = 0; i < str.length(); i++){
            res.append(table[indexesKey[i] + 1][indexesStr[i] + 1]);
        }
        return res.toString();
    }
}
