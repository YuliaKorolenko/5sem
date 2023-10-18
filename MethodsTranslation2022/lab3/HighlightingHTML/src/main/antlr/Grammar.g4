grammar Grammar;

@header {
   package org.example;
   import java.util.*;
}



file returns [String[] res]
    : {ArrayList<String> functions = new ArrayList<>();} (function {Collections.addAll(functions,$function.res);})* EOF
    {
    $res = functions.toArray(String[]::new);
    };


function returns [String[] res]
    :
    {String declarations = "";}
    ModAv Types ClassName '(' (declarationVar Semi {declarations+= $declarationVar.resString + ";";})* ')' area
    {
        ArrayList<String> myfunction = new ArrayList<>();
        String funString = "<span style=\"color:#E67E22;\">" + $ModAv.text + "</span>"
                         + " " + "<span style=\"color:#E67E22;\">" + $Types.text + "</span>"
                         + " " + "<span style=\"color:#F4D03F;\">" + $ClassName.text + "</span>"
                         + "(" + declarations + ")" + " {";
        myfunction.add(funString);
        Collections.addAll(myfunction, $area.res);
        $res = myfunction.toArray(String[]::new);
    };


statements returns [String[] res]
    : controlStructure {$res = $controlStructure.res;}
    | variableDeclaration {$res = new String[]{$variableDeclaration.resString+"<br>"};}
    | newVariableValue {$res = new String[]{$newVariableValue.resString + ";<br>"};}
    | outInput {$res = new String[]{$outInput.resString};}
    ;

declarationVar returns [String resString]
    : Types VarName
    {
        $resString = "<span style=\"color:#E67E22;\">" + $Types.text + "</span>" + " " + $VarName.text;
    };


variableDeclaration returns [String resString]
    : declarationVar '=' operation Semi
    {
    $resString = $declarationVar.resString + " = " + $operation.resString + "  ;";
    };

newVariableValue returns [String resString]
    : VarName '=' operation
    {
        $resString = $VarName.text + " = " + $operation.resString;
    };

outInput returns [String resString]
    : 'System.out.' OutInput '(' outHelper ')' Semi
    {
        $resString =  "System." + "<span style=\"color:#8E44AD;\">" + "out" + "</span>" + "."
        + $OutInput.text + "(" + $outHelper.resString + ")" + $Semi.text + "<br>";
    };

outHelper returns [String resString]
    : Integer  {$resString = $Integer.text;}
     | VarName {$resString = $VarName.text;}
     | String  {$resString =  $String.text;}
     ;

controlStructure returns [String[] res]
    : myIf {$res = $myIf.res;}
    | myFor {$res = $myFor.res;}
    | myWhile {$res = $myWhile.res;}
    ;

area returns [String[] res]
    : { ArrayList<String> myStatements = new ArrayList<>();
        myStatements.add("<br>");
      }
    '{' (statements { Collections.addAll(myStatements,$statements.res);})* '}'
    {
        for (int i = 0; i < myStatements.size(); i++){
            myStatements.set(i, "&nbsp;&nbsp;&nbsp;&nbsp;" + myStatements.get(i));
        }
        myStatements.add("}<br>");

        $res = myStatements.toArray(String[]::new);
    };

myIf returns [String[] res]
    : If '(' operation ')' area myElse
    {
        ArrayList<String> ifStrings = new ArrayList<>();
        ifStrings.add("<span style=\"color:#2980B9;\">" + $If.text + "</span>"
        + " (" + $operation.resString + ") {");
        Collections.addAll(ifStrings, $area.res);
        Collections.addAll(ifStrings, $myElse.res);
        $res = ifStrings.toArray(String[]::new);
    }
    ;

myElse returns [String[] res]
    : Else area
    {
         ArrayList<String> elseStrings = new ArrayList<>();
         elseStrings.add("<span style=\"color:#2980B9;\">" + $Else.text + "</span>" +" {");
         Collections.addAll(elseStrings, $area.res);
         $res = elseStrings.toArray(String[]::new);
    }
    | Else myIf{
        ArrayList<String> elseStrings = new ArrayList<>();
        elseStrings.add("<span style=\"color:#2980B9;\">" + $Else.text + "</span>");
        Collections.addAll(elseStrings, $myIf.res);
        $res = elseStrings.toArray(String[]::new);
    }
    | {$res = new String[0];};

myWhile returns [String[] res]
    : While '(' operation ')' area
    {
        ArrayList<String> whileStrings = new ArrayList<>();
        whileStrings.add("<span style=\"color:#2980B9;\">" + $While.text + "</span>"
        + " (" + $operation.resString + ") {");
        Collections.addAll(whileStrings, $area.res);
        $res = whileStrings.toArray(String[]::new);
    }
    ;

myFor returns [String[] res]
    : For '(' variableDeclaration operation ';' newVariableValue ')' area
    {
        ArrayList<String> forStrings = new ArrayList<>();
        forStrings.add("<span style=\"color:#2980B9;\">" + $For.text +  "</span>"
        + " (" + $variableDeclaration.resString + " " + $operation.resString + " ; "
        + $newVariableValue.resString + ") {");
        Collections.addAll(forStrings, $area.res);
        $res = forStrings.toArray(String[]::new);
    }
    ;



operation returns[String resString]
    : boolF {$resString = $boolF.resString;};

boolF returns[String resString]
    : equal boolFS
    {$resString = $equal.resString + $boolFS.resString;}
    ;

boolFS returns[String resString]
    : BoolFun equal boolFS {$resString = "abf" + $BoolFun.text + "bbf" + $equal.resString + $boolFS.resString;}
    | {$resString="";} ;

equal returns [String resString]
    : addMin equalS {$resString= $addMin.resString + $equalS.resString;};

equalS returns [String resString]
    : MyEquals addMin equalS
    {$resString = " " + $MyEquals.text + " " + $addMin.resString  + $equalS.resString;}
    | {$resString = "";};

addMin returns [String resString]
    : mulDiv addMinS {$resString = $mulDiv.resString + $addMinS.resString;};

addMinS returns [String resString]
    : AddMinus mulDiv addMinS {$resString= " " + $AddMinus.text + " " + $mulDiv.resString + $addMinS.resString;}
    | {$resString = "";};

mulDiv returns [String resString]
    : myVars mulDivS
    {$resString = $myVars.resString + $mulDivS.resString;};

mulDivS returns [String resString]
    : MulDiv myVars mulDivS { $resString = " " + $MulDiv.text + " " + $myVars.resString + $mulDivS.resString;}
    | {$resString = "";} ;


myVars returns [String resString]
    : '(' operation ')' {$resString = "(" + $operation.resString + ")" ;}
    | Integer {$resString = $Integer.text;}
    | VarName {$resString = $VarName.text;}
    ;


AddMinus : '+' | '-';
MulDiv : '*' | '/' | '%';
BoolFun : '&&' | '||';
MyEquals : '>' | '<' | '==' | '!=' | '>=' | '<=';
OutInput : 'println' |  'readln' | 'print' | 'read';
If : 'if';
For : 'for';
While : 'while';
Else : 'else';
Semi : ';';
Types : 'int' | 'boolean' | 'char' | 'byte' | 'short' | 'long' | 'void' | 'float' | 'double' ;
WS : [ \t\r\n]+ -> skip ;
ModAv : 'private' | 'public' | 'protected';
Integer : [1-9][0-9]*;
VarName : [a-z][a-zA-Z0-9]*;
ClassName : [A-Z][a-zA-Z0-9]*;
String: '"' (~["\\])* '"';
