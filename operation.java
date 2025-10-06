public class operation {
    public static String negatesimply(String str) {
    String newstr = str;
    if(str.contains("~0") && !str.contains("~1")) newstr = str.replaceFirst("~0", "1");
    //if the string only has ~0, replace it with 1
    else if(str.contains("~1") && !str.contains("~0"))newstr = str.replaceFirst("~1", "0");
    //if the string only has ~1, replace it with 0
    else {
        if(str.indexOf("~0") < (str.indexOf("~1"))) newstr = str.replaceFirst("~0", "1");
        //if it has both and 0 is earlier than 1, replace ~0 with 1.
        else newstr = str.replaceFirst("~1", "0");
            //otherwise if it has both replace ~1 with 0.
        }
    return newstr;
    }
    public static String semantic(String str) {
        String newstr = str;
        if(str.contains("~")) newstr = negatesimply(str);
        else if(str.contains("&")) newstr = conjunction(str);
        else if(str.contains("|")) newstr = disjunction(str);
        else if(standalone(str)) newstr = implication(str);
        else if(str.contains("<=>")) newstr = biconditional(str);
        return newstr;
    }
    public static boolean standalone(String str) {
        String piecestring = "";
        if(str.contains("<=>")) {
            piecestring = str.replaceAll("<=>", "");
        }
        if(piecestring.contains("=>")) return true;
        else return false;
    }
    public static String conjunction(String str) {
        String newstr = str;
        if(str.contains("&")) {
        int i = str.indexOf("&") -1;
        int Hi = i + 3;
        String partialstr = str.substring(i, Hi);
        if(partialstr.contentEquals("1&1")) newstr = str.replaceFirst("1&1", "1");
        else if(partialstr.contentEquals("1&0")) newstr = str.replaceFirst("1&0", "0");
        else if(partialstr.contentEquals("0&1")) newstr = str.replaceFirst("0&1", "0");
        }
        return newstr;
    }
        public static String disjunction(String str){
        String newstr = str;
        String partialstr = "";
        if(str.contains("|") && str.length() > 2) {
            int i = str.indexOf("|");
            if (i == 0) i++;
            int Hi = str.indexOf("|") + 2;
            partialstr = str.substring(i-1, Hi);
            if(partialstr.equals("1|1")) newstr = newstr.replaceFirst("1\\|1", "1");
            if(partialstr.equals("1|0")) newstr = newstr.replaceFirst("1\\|0", "1");
            if(partialstr.equals("0|1")) newstr = newstr.replaceFirst("0\\|1", "1");
            if(partialstr.equals("0|0")) newstr = newstr.replaceFirst("0\\|0", "0");
        }
        return newstr;
    }
    public static String implication(String str) {
        String newstr = str;
        if (str.contains("<=>"))newstr = newstr.replaceAll("<=>", "~~0");
        //the string will never contain ~~0 without replacing a <=> as negation has higher priority.
        String partialstr = "";
        if(str.contains("=>") && str.length() > 3) {
            int i = newstr.indexOf("=>");
            if (i == 0) i++;
            //to make sure we dont get out of bounds.
            int Hi = newstr.indexOf("=>") + 3;
            partialstr = newstr.substring(i-1, Hi);
            if(partialstr.equals("1=>0")) newstr = newstr.replaceFirst("1=>0", "0");
            if(partialstr.equals("0=>1")) newstr = newstr.replaceFirst("0=>1", "1");
            if(partialstr.equals("1=>1")) newstr = newstr.replaceFirst("1=>1", "1");
            if(partialstr.equals("0=>0")) newstr = newstr.replaceFirst("0=>0", "1");
        }
        if(newstr.contains("~~0")) newstr = newstr.replaceAll("~~0", "<=>");
        //turns the impossible to occur string back into a biconditional.
        return newstr;
    }
    public static String biconditional(String str){
        String newstr = str;
        String partialstr = "";
        if(str.contains("<=>") && str.length() > 4) {
            int i = str.indexOf("<=>");
            if (i == 0) i++;
            int Hi = str.indexOf("<=>") + 4;
            partialstr = str.substring(i-1, Hi);
            if(partialstr.equals("1<=>1")) newstr = str.replaceFirst("1<=>1", "1");
            if(partialstr.equals("0<=>0")) newstr = str.replaceFirst("0<=>0", "1");
            if(partialstr.equals("1<=>0")) newstr = str.replaceFirst("1<=>0", "0");
            if(partialstr.equals("0<=>1")) newstr = str.replaceFirst("0<=>1", "0");
        }
        return newstr;
    }
}
