public class Vigenere {
    private static final char [] array = {'А', 'Б', 'В', 'Г', 'Ґ', 'Д','Е',
            'Є','Ж','З','И','І','Ї','Й','К','Л','М',
            'Н','О','П','Р','С','Т','У','Ф','X','Ц','Ч','Ш','Щ','Ь','Ю','Я'};
    private char [][] createTable() {
        char[][] table = new char[Vigenere.array.length+2][Vigenere.array.length+2];
        int k = 0;
        for (int i = 0; i < Vigenere.array.length+1; i++) {
            for (int j = 0; j < Vigenere.array.length+1; j++) {
                if(i == 0 && j == 0){
                    table[0][0] = '_';
                }
                else if(i+j < Vigenere.array.length+1){
                    k = j+i-1;
                    table[i][j] = Vigenere.array[k];
                    if(k == Vigenere.array.length-1)
                    {
                        k = 0;
                    }
                }
                else{
                    if(k < Vigenere.array.length+1){
                        table[i][j] = Vigenere.array[k];
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
        for (int i = 0; i < array.length+1; i++){
            for (int j = 0; j < array.length+1; j++){
                System.out.print(" " + table[i][j]);
            }
            System.out.println(" ");
        }
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
        for(int i = 0; i < str.length(); i ++){
            System.out.print(keyCharArray[i]);
        }
        System.out.println();
        //start encryption algorithm
        int [] indexesStr = new int[str.length()];
        int [] indexesKey = new int [str.length()];
        for(int i = 0, j = 0; j < keyCharArray.length && i < array.length; i++){
            if(keyCharArray[j] == array[i]){
                indexesKey[j] = i;
                j++;
                i = -1;
            }
        }
        for (int i = 0; i < str.length(); i++){
            System.out.print(" " + indexesKey[i]);
        }
        System.out.println(" ");


        for(int i = 0, j = 0; j < str.length() && i < array.length; i++){
            if(strChar[j] == array[i]){
                indexesStr[j] = i;
                j++;
                i = -1;
            }
        }
        for (int i = 0; i < str.length(); i++){
            System.out.print(" " + indexesStr[i]);
        }

        System.out.println(" ");
        for(int i = 0; i < str.length(); i++){
            res.append(table[indexesKey[i] + 1][indexesStr[i] + 1]);
        }
        return res.toString();
    }
}
