import java.util.ArrayList;
import java.util.List;

public class DPLL {
    private List<List<Integer>> clauses;

    public DPLL() {
        clauses = new ArrayList<>();
    }

    private int getFirstLiteral(List<List<Integer>> cnf) {
        for (List<Integer> clause : cnf) {
            for (int literal : clause) {
                boolean containsOpposite = false;
                for (int l : clause) {
                    if (l == -literal) {
                        containsOpposite = true;
                        break;
                    }
                }
                if (!containsOpposite) {
                    return literal;
                }
            }
        }
        return cnf.get(0).get(0);
    }

    private boolean solve(List<List<Integer>> cnf) {
        List<List<Integer>> simplifiedCnf = simplify(cnf);

        if (simplifiedCnf.isEmpty()) {
            return true;
        } else if (simplifiedCnf.contains(new ArrayList<>())) {
            return false;
        }

        int literal = getFirstLiteral(simplifiedCnf);

        if (solve(merge(simplifiedCnf, literal))) {
            return true;
        } else if (solve(merge(simplifiedCnf, -literal))) {
            return true;
        } else {
            return false;
        }
    }

    private List<List<Integer>> merge(List<List<Integer>> cnf, int literal) {
        List<List<Integer>> mergedCnf = new ArrayList<>(cnf);
        List<Integer> newClause = new ArrayList<>();
        newClause.add(literal);
        mergedCnf.add(newClause);
        return mergedCnf;
    }

    private List<List<Integer>> simplify(List<List<Integer>> cnf) {
        return cnf;
    }

    public void addClause(List<Integer> clause) {
        clauses.add(clause);
    }

    public boolean solve() {
        return solve(clauses);
    }

}