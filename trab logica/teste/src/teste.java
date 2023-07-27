import java.util.ArrayList;
import java.util.List;

public class teste {
    public static List<List<Integer>> teste(List<List<Integer>> sCnf) {
        List<List<Integer>> sCnfCopy = new ArrayList<>(sCnf);
        List<Integer> literal = new ArrayList<>();
        for (List<Integer> clause : sCnfCopy) {
            if (clause.size() == 1) {
                literal = clause;
                break;
            }
        }

        while (!literal.isEmpty()) {
            sCnfCopy.remove(literal);
            int cursorI = 0;
            for (int i = 0; i < sCnfCopy.size(); i++) {
                int cursorJ = 0;
                for (int j = 0; j < sCnfCopy.get(i - cursorI).size(); j++) {
                    if (literal.get(0).equals(sCnfCopy.get(i - cursorI).get(j - cursorJ))) {
                        sCnfCopy.remove(sCnfCopy.get(i - cursorI));
                        cursorI++;
                        break;
                    } else if (literal.get(0) * -1 == sCnfCopy.get(i - cursorI).get(j - cursorJ)) {
                        sCnfCopy.get(i - cursorI).remove(sCnfCopy.get(i - cursorI).get(j - cursorJ));
                        cursorJ++;
                        break;
                    }
                }
            }
            literal = findLiteral(sCnfCopy);
        }
        return sCnfCopy;
    }

    private static List<Integer> findLiteral(List<List<Integer>> sCnf) {
        for (List<Integer> clause : sCnf) {
            if (clause.size() == 1) {
                return clause;
            }
        }
        return new ArrayList<>();
    }

}