public class Vigenere {
    private static final char [] array = {'А', 'Б', 'В', 'Г', 'Ґ', 'Д','Е',
            'Є','Ж','З','И','І','Ї','Й','К','Л','М',
            'Н','О','П','Р','С','Т','У','Ф','X','Ц','Ч','Ш','Щ','Ь','Ю','Я'};
    private char [][] createTable(char [] array) {
        char[][] table = new char[array.length+2][array.length+2];
        int k = 0;
        for (int i = 0; i < array.length+1; i++) {
            for (int j = 0; j < array.length+1; j++) {
                if(i == 0 && j == 0){
                    table[0][0] = '_';
                }
                else if(i+j < array.length+1){
                    k = j+i-1;
                    table[i][j] = array[k];
                    if(k == array.length-1)
                    {
                        k = 0;
                    }
                }
                else{
                    if(k < array.length+1){
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
        for (int i = 0; i < array.length+1; i++){
            for (int j = 0; j < array.length+1; j++){
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
