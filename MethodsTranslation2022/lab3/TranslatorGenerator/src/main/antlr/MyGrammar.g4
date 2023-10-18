grammar MyGrammar;

@header {
   import info.*;
   import java.util.*;
}

myGrammar returns[MainInfo info]@init
    {MainInfo info = new MainInfo();
    $info = info;}
    : grammarHeader[info] rules[info] EOF;

grammarHeader[MainInfo info]
    : GRAMMAR name SEMICOLON
    {info.setName($name.text);}
    ;


rules[MainInfo info]
    : (rule[info])*;


rule[MainInfo info]
    : terminalRule[info]
    | nonTerminalRule[info];



terminalRule[MainInfo info]
    : name COLON REGEXP SEMICOLON { $info.addToken($name.text, $REGEXP.text); };

nonTerminalRule[MainInfo info]
    : name ATTR RETURN_VALUES START_FUNC {NonTerminalToken token = new NonTerminalToken($name.text, $ATTR.text, $RETURN_VALUES.text);}
     parts[info, token] SEMICOLON;

parts[MainInfo info, NonTerminalToken token]
: part[info, token] ('|' part[info, token])*;

part[MainInfo info, NonTerminalToken token]
 @init
 {List<Part> parts = new ArrayList<>();}
    : (call {parts.add($call.part_);} )+ {info.addRule(token, parts);}
    | EPS CODE? {$info.addRule(token, List.of(new Part(List.of(), $CODE.text)));};

call returns [Part part_] @init {
  List<Call> calls = new ArrayList<>();
  }
    : (name ATTR? {Call call_ = new Call($name.text, $ATTR.text);
                   calls.add(call_);})+
    CODE? {$part_ = new Part(calls, $CODE.text);};

name
    : TOKEN_NAME
    | NAME;


EPS: 'ε';
GRAMMAR : 'grammar';
COLON : ':';
START_FUNC : '->';
REGEXP: '"'.*?'"';
SEMICOLON : ';' ;
ATTR : '(' .*? ')' ;
RETURN_VALUES : '[' .*? ']';
CODE : '{' .*? '}';
TOKEN_NAME: [A-Z]+;
NAME: [a-z][a-zA-Z]*;

WHITESPACE: [ \t\r\n]+ -> skip;