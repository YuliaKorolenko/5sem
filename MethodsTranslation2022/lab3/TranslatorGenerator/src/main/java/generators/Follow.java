package generators;

import info.MainInfo;
import info.Rule;

import java.util.*;

public class Follow {

    private static final String EPS = "ε";
    private final List<Rule> rules;
    private final First first;
    private final Map<String, Set<String>> follow = new HashMap<>();

    private final MainInfo info;
    public Map<String, Set<String>> getFollow() {
        return follow;
    }

    public Follow(final MainInfo info, First first) {
        this.rules = info.getRules();
        this.first = first;
        this.info = info;

        if (rules.size() == 0) {
            return;
        }
        constructFollow();
    }

    private void constructFollow() {
        boolean flag = true;
        follow.put(rules.get(0).token().name(), new HashSet<>(Set.of("END")));
        while (flag) {
            flag = false;
            for (final var rule : rules) {
                final List<String> parts = info.withoutCode(rule.parts());
                final String A = rule.token().name();
                for (int i = 0; i < parts.size(); i++) {
                    final String B = parts.get(i);
                    if (!B.matches("[A-Z]+") && !B.equals(EPS)) {
                        final int cur = follow.computeIfAbsent(B, k -> new HashSet<>()).size();
                        final Set<String> firstGamma = first.getFirst(parts.subList(i + 1, parts.size()));
                        if (firstGamma.contains(EPS)) {
                            follow.get(B).addAll(follow.computeIfAbsent(A, k -> new HashSet<>()));
                        }
                        firstGamma.remove(EPS);
                        follow.get(B).addAll(firstGamma);
                        if (flag | cur < follow.get(B).size()){
                            flag = true;
                        }
                    }
                }
            }
        }
    }
}
