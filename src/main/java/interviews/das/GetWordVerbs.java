package interviews.das;

import java.util.Arrays;
import java.util.function.Function;
import java.util.stream.Collectors;

public class GetWordVerbs {

    public void countAndPrintVerbs(String str){
        String words[]= str.replaceAll("[.,]","").split(" ");

        Arrays.stream(words).collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
                .entrySet().stream().filter(x->isVerbWord(x.getKey()))
                .forEach(x->System.out.println(x.getKey()+" "+x.getValue()));
    }


    boolean isVerbWord(String word){
//        Object obj[]=restTemplate.get("/dictionary/"+word);
//        JsonNode jsonNode[]=ObjectMapper(obj,JSONNOde.class);
//
//        for(JsonNode jsonNode1: jsonNode){
//            if(jsonNode1.get("partsofSpeech").equals("verb")){
//                return  true;
//            }
//        }
        return false;
    }
}
