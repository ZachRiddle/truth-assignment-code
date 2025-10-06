public class Logical {
    public static boolean Legal(String s) {
        s = s.replaceAll("\s", "");
        return simple(s)||complex(s); //returns true if simple or complex succeeds
    }
    public static boolean simple(String s) {
        String alphabet = "abcdefghijklmnopqrstuvwxyz"; //creates a string of all lowercase letters
        if(!(s.length() == 1)) return false; //checks if the string input is one character
        return alphabet.contains(s); //checks if the string input is contained in the alphabet
    }
        public static boolean complex(String s) {
        return negation(s)||biconditional(s)||implication(s)||conjunction(s)||disjunction(s);
    }
        public static boolean negation(String s) {
            if (s.length() < 2) return false;
            boolean negation = s.startsWith("~");
            boolean restLegal = Legal(s.substring(1));
            return negation && restLegal;
        }
        public static boolean biconditional(String s) {
            int leftPartEndIndex = s.indexOf("<=>");
            int rightPartStartIndex = leftPartEndIndex +3;

            if(leftPartEndIndex < 1) return false;
            if(rightPartStartIndex > s.length()-1) return false;

            String leftPart = s.substring(0, leftPartEndIndex);
            String rightPart= s.substring(rightPartStartIndex);
        
            return Legal(leftPart) && Legal(rightPart);
        }
        public static boolean implication(String s){
            int leftPartEndIndex = s.indexOf("=>");
            int rightPartStartIndex = leftPartEndIndex +2;

            if(leftPartEndIndex < 1) return false;
            if(rightPartStartIndex > s.length()-1) return false;

            String leftPart = s.substring(0, leftPartEndIndex);
            String rightPart= s.substring(rightPartStartIndex);
        
            return Legal(leftPart) && Legal(rightPart);
        }
        public static boolean conjunction(String s){
            int leftPartEndIndex = s.indexOf("&");
            int rightPartStartIndex = leftPartEndIndex +1;

            if(leftPartEndIndex < 1) return false;
            if(rightPartStartIndex > s.length()-1) return false;

            String leftPart = s.substring(0, leftPartEndIndex);
            String rightPart= s.substring(rightPartStartIndex);
        
            return Legal(leftPart) && Legal(rightPart);
        }
        public static boolean disjunction(String s){
            int leftPartEndIndex = s.indexOf("|");
            int rightPartStartIndex = leftPartEndIndex +1;

            if(leftPartEndIndex < 1) return false;
            if(rightPartStartIndex > s.length()-1) return false;

            String leftPart = s.substring(0, leftPartEndIndex);
            String rightPart= s.substring(rightPartStartIndex);
        
            return Legal(leftPart) && Legal(rightPart);
        }
}