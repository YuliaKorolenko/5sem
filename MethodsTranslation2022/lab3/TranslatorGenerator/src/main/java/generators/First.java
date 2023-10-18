package generators;

import info.MainInfo;
import info.Rule;

import java.util.*;

public class First {

    private static final String EPS = "ε";
    private final List<Rule> rules;
    private final Map<String, Set<String>> firstFun = new HashMap<>();

    private final Map<String, Set<String>> firstTable = new HashMap<>();
    private final MainInfo info;

    public First(final MainInfo info) {
        this.rules = info.getRules();
        this.info = info;
        if (rules.size() == 0) {
            return;
        }
        generate();
    }

    public Set<String> getFirst(final List<String> parts) {
        if (parts.isEmpty()) {
            return new HashSet<>(Set.of(EPS));
        }
        final HashSet<String> res = new HashSet<>();
        for (final var c : parts) {
            if (c.matches("[A-Z]+")) {
                res.add(c);
            } else if (firstFun.containsKey(c)) {
                res.addAll(firstFun.get(c));
                if (firstFun.get(c).contains(EPS)) {
                    continue;
                }
            }
            break;
        }
        return res;
    }

    private void generate() {
        boolean flag = true;
        while (flag) {
            flag = false;
            for (final var rule : rules) {
                final String name = rule.token().name();
                final int cur = firstFun.computeIfAbsent(name, k -> new HashSet<>()).size();
                firstFun.get(name).addAll(getFirst(info.withoutCode(rule.parts())));
                if (flag | cur < firstFun.get(name).size()) {
                    flag = true;
                }
            }
        }
    }
}
