import java.util.Arrays;

public class Bigrams {

    private final char[][] leftBigram = {
            {'К', 'Ф', 'А', 'М', 'У', '+'},
            {'Б', 'Х', 'П', 'Р', 'О', 'Е'},
            {'Ї', 'В', 'Я', 'Є', ' ', 'Д'},
            {'.', 'Л', 'Й', 'Ю', 'Ц', 'Г'},
            {'1', 'Ж', 'И', 'С', 'Т', 'Ш',},
            {'З', 'Ч', 'І', 'Ь', 'Н', 'Щ'}};
    private final char[][] rightBigram  = {
            {'Щ', ' ', 'Р', 'К', 'А', 'С'},
            {'Д', 'Й', 'Ь', 'Г', 'В', 'Ж',},
            {'Х', 'М', 'Ф', 'Т', 'І', 'Ї'},
            {'.', 'Л', 'Ш', 'Ч', 'У', 'Ю'},
            {'П', 'Е', 'З', 'Н', 'Я', 'Б'},
            {'1', 'И', '+', 'Є', 'Ц', 'О'}};

    private void getOneDemensional(char[] leftBigramOneDemensional, char[][] leftBigram) {
        for (int i = 0, m = 0; i < leftBigram.length * leftBigram.length && m < leftBigram.length; m++) {
            for (int j = 0; j < leftBigram.length; j++) {
                leftBigramOneDemensional[i] = leftBigram[m][j];
                i++;
            }
        }
    }
    public String encryption(String str) {
        //1
        StringBuilder res = new StringBuilder(); //result str
        char[] charStr = new char[str.length()];
        // 1.1
        char[] leftBigramOneDemensional = new char[leftBigram.length * leftBigram.length];
        char[] rightBigramOneDemensional = new char[leftBigram.length * leftBigram.length];

        getOneDemensional(leftBigramOneDemensional, leftBigram);
        getOneDemensional(rightBigramOneDemensional, rightBigram);

        for (int i = 0; i < str.length(); i++) {
            charStr[i] = str.charAt(i);
            System.out.println(charStr[i]);
        }

        // 1.2
        int [] indexes = new int [str.length()];
        for (int i = 0; i < charStr.length; i++) {
            if(i % 2 == 0){
                for (int j = 0; j < leftBigramOneDemensional.length; j++) {
                    if (charStr[i] == leftBigramOneDemensional[j]) {
                        indexes[i] = j;
                        break;
                    }
                }
            }else{
                for (int j = 0; j < rightBigramOneDemensional.length; j++) {
                    if (charStr[i] == rightBigramOneDemensional[j]) {
                        indexes[i] = j;
                        break;
                    }
                }
            }
        }
        //3
        int [][] index = new int[str.length()][2];
        for(int i = 0; i < str.length(); i ++){
            for( int j = 0; j < 2; j++){
                if(j == 0){
                    index[i][j] = indexes[i]/6;
                }
                else
                {
                    index[i][j] = indexes[i]%6;
                }
            }
        }
        for(int i = 0; i < str.length(); i ++){
            for( int j = 0; j < 2; j++){
                System.out.println(index[i][j]);
            }
        }


        for(int i = 0; i < indexes.length; i++){
            if(i % 2 == 0){
                res.append(rightBigram[index[i][0]][index[i + 1][1]]);
            }else
            {
                res.append(leftBigram[index[i][0]][index[i - 1][1]]);
            }
        }

            return res.toString();
        }
}