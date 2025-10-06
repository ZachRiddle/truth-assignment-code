public class TruthAssignment {
    String pc;
    String tv;
    
    TruthAssignment(String pc, String tv) {
        this.pc = pc;
        this.tv = tv;
    }

    public static String instantiate(String Prop, TruthAssignment Val) {
        String retval = "";

        for(int i = 0; i < Prop.length(); i++) {
            char eVal = Prop.charAt(i);
            int index = Val.pc.indexOf(eVal);
            if(index >= 0) {
                retval = retval + Val.tv.charAt(index);
            }
            else {
                retval = retval + eVal;
            }
        }
        return retval;
    }
public static void main (String[] args) {
    String Phi = "p&q";
    TruthAssignment Ta = new TruthAssignment("pq", "10");
    String actual = instantiate(Phi, Ta);
    String actualTest2 = instantiate("qp pq", Ta);
    String actualTest3 = instantiate("pq \"none of these letters have a truth assignment\"", Ta);
    String actualTest4 = instantiate("pqpqpq", new TruthAssignment("pq", "10"));
    System.out.println("(" + actual + ") (" + actualTest2 + ") (" + actualTest3 + ") (" + actualTest4 + ")");
    }
}