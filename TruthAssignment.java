public class TruthAssignment {
    String pc;
    String tv;
    
    TruthAssignment(String pc, String tv) {
        this.pc = pc;
        this.tv = tv;
    }

    public static String instantiate(String Prop, TruthAssignment Val) {
        String retval = "";
        Prop = lastparen(Prop);
        //updates prop immediately by putting it through lastparen.

        for(int i = 0; i < Prop.length(); i++) {
            char eVal = Prop.charAt(i);
            //eval is the current character in the string we are changing
            int index = Val.pc.indexOf(eVal);
            //the int index is the index of eval in the "pc" string of the instatiated truth assignment.
            if(index >= 0) {
                retval = retval + Val.tv.charAt(index);
            //we are reconstructing the string piece by piece.
            }
            else {
                retval = retval + eVal;
            //if there is nothing in tv's index for us to add to retval, then it just adds the letter without changing it.
            }
        }
        retval = operation.semantic(retval);
        return retval;
        //retval is returned after updating.
    }
    public static String lastparen (String sentence) {
        int i = -1;
        //the +1 neutralizes this to be a 0 if there is no left parenthesis.
        int Hi = sentence.length();
        //so that if theres no right parenthesis the substring is the whole sentence.
        if (sentence.contains("(") && sentence.contains(")")) {
            i = sentence.lastIndexOf('(');
            String firsthalf = sentence.substring(0, i+1);
            String amend = sentence.substring(i+1, sentence.length());
            //splitting the sentence up into after last left parenthesis(amend) and before last left parenthesis(firsthalf).
            Hi = firsthalf.length() + amend.indexOf(')');
            //hi needed to be the index of first right parenthesis after the last left parenthesis in the sentence.
        }
        sentence = sentence.substring(i+1, Hi);
        return sentence;
    }
public static void main (String[] args) {
    String Phi = "p&q";
    TruthAssignment Ta = new TruthAssignment("pq", "10");
    //making a variable so that "pq" is instantiated to "10"
    String actual = instantiate(Phi, Ta);
        System.out.println(actual);
        System.out.println(instantiate("q=>p <=>", Ta));
        System.out.println(instantiate("p<=>q", Ta));
        System.out.println(instantiate("q|p", Ta));
        System.out.println(instantiate("p|p q=>q", Ta));
        System.out.println(instantiate("~p ~q", Ta));
        System.out.println(instantiate("q<=>q p<=>q", Ta));
        System.out.println(instantiate("p<=>q p=>p", Ta));
    }

}