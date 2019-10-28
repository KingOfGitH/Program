package zifuchuan;

import java.util.logging.Level;

public class _557反转字符串中的单词III {
    public String reverseWords(String s) {
        StringBuilder stringBuilder = new StringBuilder();
        String[] split = s.split("\\s");
        for (int i = 0; i < split.length; i++) {
            stringBuilder.append(new StringBuilder(split[i].trim()).reverse()+" ");
        }
        return stringBuilder.substring(0,stringBuilder.length()-1);
    }

    public String reverseWords1(String s) {
        StringBuilder stringBuilder = new StringBuilder();
        char[] chars = s.toCharArray();
        int b=0,e=0;
        for (int i = 0; i <chars.length; i++) {
            if (chars[i]==' '){
                e=i-1;
                new _557反转字符串中的单词III().swap(chars,b,e);
                b=i+1;
            }
        }
        if (b!= chars.length-1){
            new _557反转字符串中的单词III().swap(chars,b,chars.length-1);
        }

        return new String(chars);
    }

    private void swap(char[] chars, int b, int e) {
        while (b<e){
            chars[b]^=chars[e];
            chars[e]^=chars[b];
            chars[b++]^=chars[e--];
        }
    }

}
