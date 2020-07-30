import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;
import java.util.stream.Collectors;

public class GrammarExercise {
    public static void main(String[] args) {
        //需要从命令行读入
        Scanner input = new Scanner(System.in);
        String firstWordList = input.nextLine();
        String secondWordList = input.nextLine();

        List<String> result = findCommonWordsWithSpace(firstWordList,secondWordList);
        //按要求输出到命令行
        result.forEach(System.out::println);

    }

    public static List<String> findCommonWordsWithSpace(String firstWordList, String secondWordList) {
        //在这编写实现代码
        List<String> fwl=Stream.of(firstWordList.split(",")).map(i->i.toUpperCase()).distinct().collect(Collectors.toList());
        List<String> swl=Stream.of(secondWordList.split(",")).map(i->i.toUpperCase()).distinct().collect(Collectors.toList());
        fwl.forEach(it->{
            if(!it.matches("[a-zA-Z]")){
                throw new RuntimeException("input not valid");
            }
        });
        swl.forEach(it->{
            if(!it.matches("[a-zA-Z]")){
                throw new RuntimeException("input not valid");
            }
        });
        List res=fwl.stream().filter(it->swl.contains(it)).collect(Collectors.toList());
        res.stream().sorted();

        return res;
    }
}
