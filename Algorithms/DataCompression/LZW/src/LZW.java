package Algorithms.DataCompression.LZW.src;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LZW {

  public List<Integer> compress(String uncompressedString){

    int dictionarySize = 256;

    Map<String,Integer> dictionary = new HashMap<>();

    for(int i=0;i<dictionarySize;i++){
      dictionary.put(""+(char)i,i);
    }

    String tempString = "";

    List<Integer> result = new ArrayList<>();

    for( char c : uncompressedString.toCharArray() ){
      String tempString2 = tempString+c;

      if( dictionary.containsKey(tempString2)){
        tempString = tempString2;
      }else{
        result.add(dictionary.get(tempString));
        dictionary.put(tempString2, dictionarySize++);
        tempString=""+c;
      }
    }

    if( !tempString.equals("")){
      result.add(dictionary.get(tempString));
    }

    return result;
  }

  public String decompress(List<Integer> compressedString){

    int dictionarySize = 256;

    Map<Integer,String> dictionary = new HashMap<>();
    for(int i=0;i<dictionarySize;i++){
      dictionary.put(i, ""+(char)i);
    }

    String tempString = ""+(char)(int)compressedString.remove(0);
    StringBuffer stringBuffer = new StringBuffer(tempString);

    for(int k : compressedString ){
      String entry;
      if( dictionary.containsKey(k)){
        entry = dictionary.get(k);
      }else if( k == dictionarySize ){
        entry=tempString+tempString.charAt(0);
      }else{
        throw new IllegalArgumentException("Bad compressed k");
      }

      stringBuffer.append(entry);
      dictionary.put(dictionarySize++, tempString+entry.charAt(0));
      tempString=entry;
    }

    return stringBuffer.toString();
  }
}
