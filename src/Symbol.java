import java.util.ArrayList;

public class Symbol {
    public void  terminate(String text) throws Exception {
        int c = 0, d = 0;
            if (checkRome(text)) {
                c = (int) calculateRomeNumbers(text).get(0);
                d = (int) calculateRomeNumbers(text).get(1);
                doSomething(text, c, d);
            }
            else if (!checkRome(text)) {
                try {
                    int a = (int) getNumbers(text).get(0);
                    int b = (int) getNumbers(text).get(1);
                    doSomething(text, a, b);
                }catch (Exception e){
                    System.out.println("You've entered wrong statement");
                }

            }



        }
    public static boolean checkRome(String text){
        RomeNumbers[] rom = RomeNumbers.values();
        String str = text.replaceAll("[+*-/]", " ");
        String str2 = str.replaceAll("( )+", " ");
        int index = str2.indexOf(" ");
        boolean checkResult = false;
        String r1 = str2.substring(0, index);
        String r2 = str2.substring(index + 1);
        for (RomeNumbers r: rom) {
            if (r.name().equals(r1) || r.name().equals(r2)) {
                checkResult = true;
            }
            else if (!r.name().equals(r1)){
                 checkResult = false;
            }
        }
        return checkResult;
    }

    //проверим если в тексте мат выражения и выполняем соответсвующую операцию
    public  static int doSomething(String text, int a, int b){
        Operations operations = new Operations();
        int result = 0;
        if (text.contains("*")){
            result = operations.multiply(a, b);

        }
        else if (text.contains("/")){
            result = operations.devide(a, b);

        }
        else if (text.contains("-")){
            result = operations.minus(a, b);

        }
        else if (text.contains("+")){
            result = operations.plus(a, b);

        }
        System.out.println(result);

        return result;
    }


    // получаем числы из текста
    public static ArrayList getNumbers(String text){
        ArrayList<Integer> list = new ArrayList<>();
        String nettext =  text.replaceAll("[*-+/ ]", "");
        int a = Integer.parseInt(String.valueOf(nettext.charAt(0)));
        int b = Integer.parseInt(String.valueOf(nettext.charAt(1)));
        list.add(a);
        list.add(b);
        return list;
    }
    //список, возврашает занвчение enum
    public static ArrayList calculateRomeNumbers(String  text){
        RomeNumbers[] romeNumbers = RomeNumbers.values();
        ArrayList<Integer> romeValues = new ArrayList<>();
        //удаляем символы
        String str = text.replaceAll("[+*-/]", " ");
        String str2 = str.replaceAll("( )+", " ");
        int index = str2.indexOf(" ");
        String r1 = str2.substring(0, index);
        String r2 = str2.substring(index +1);
        int firstRomeNumber = 0;
        int secondRomeNumber = 0;
        //проходим по перечислению и сравним имя с текстамии r1, r2
        for (RomeNumbers rom : romeNumbers){
            if (rom.name().equals(r1)){
                firstRomeNumber = rom.getNumbers();
            }
        }
        for (RomeNumbers rom2 : romeNumbers) {
            if (rom2.name().equals(r2)){
                secondRomeNumber = rom2.getNumbers();
            }
        }
        romeValues.add(firstRomeNumber);
        romeValues.add(secondRomeNumber);
        return romeValues;
    }
}
