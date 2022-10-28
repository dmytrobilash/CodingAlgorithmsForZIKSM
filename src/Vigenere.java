public class Vigenere {
    private static final char [] array = {'А', 'Б', 'В', 'Г', 'Ґ', 'Д','Е',
            'Є','Ж','З','И','І','Ї','Й','К','Л','М',
            'Н','О','П','Р','С','Т','У','Ф','X','Ц','Ч','Ш','Щ','Ь','Ю','Я'};
    private char [][] createTable(char [] array) {
        char[][] table = new char[array.length][array.length];
        int k = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                if(i+j < array.length){
                    k = j+i;
                    table[i][j] = array[k];
                    if(k == array.length-1)
                    {
                        k = 0;
                    }
                }
                else{
                    if(k < array.length){
                        table[i][j] = array[k];
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
        char [][]table = createTable(array);
        for (int i = 0; i < array.length; i++){
            for (int j = 0; j < array.length; j++){
                System.out.print(" " + table[i][j]);
            }
            System.out.println(" ");
        }
        char [] CharArray = new char[keyString.length()];
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
        String res = "";
        return res;
    }
}
