module HW3.Parser
(
    HW3.Parser.parse
) where


import HW3.Base(HiFun(..), HiValue(..), HiExpr(..))
import Data.Void
import Data.Text as T
import Text.Megaparsec.Char.Lexer as L
import Text.Megaparsec.Char    (space1, char)
import Text.Megaparsec.Byte    (string)
import Control.Monad.Combinators.Expr 
import Text.Megaparsec as M


parse :: String -> Either (M.ParseErrorBundle String Void) HiExpr
parse = runParser (sc *> parseExpr <* eof) ""

type Parser = M.Parsec Void String

parseExpr :: Parser HiExpr
parseExpr = makeExprParser pTerm operatorTable

pTerm :: Parser HiExpr
pTerm = (try (sc *> pExpression <* sc)) <|> ( sc *> (parens parseExpr) <* sc )

pExpression :: Parser HiExpr
pExpression = do
    x <- (try $ parens pExpression) <|> (HiExprValue <$> (sc *> pHiValue <* sc))
    let a = between (sym "(") (sym ")") 
    argsFun <- many $ a args
    return (Prelude.foldl HiExprApply x argsFun)

operatorTable :: [[Operator Parser HiExpr]]
operatorTable =
  [ [ infixL "*" $ createBinary HiFunMul,
      InfixL $ createBinary HiFunDiv <$ (lexm . try) (string "/" <* notFollowedBy (string "="))
    ],
    [ infixL "+" $ createBinary HiFunAdd,
      infixL "-" $ createBinary HiFunSub
    ],
    [ infixN ">=" $ createBinary HiFunNotLessThan,
      infixN "<=" $ createBinary HiFunNotGreaterThan,
      infixN "<" $ createBinary HiFunLessThan,
      infixN ">" $ createBinary HiFunGreaterThan,
      infixN "==" $ createBinary HiFunEquals,
      infixN "/=" $ createBinary HiFunNotEquals
    ],
    [ infixR "&&" $ createBinary HiFunAnd
    ],
    [ infixR "||" $ createBinary HiFunOr
    ]
  ]

infixL :: String -> (HiExpr -> HiExpr -> HiExpr) -> Operator Parser HiExpr
infixL name f = InfixL (f <$ sym name)

infixR :: String -> (HiExpr -> HiExpr -> HiExpr) -> Operator Parser HiExpr
infixR name f = InfixR (f <$ sym name)

infixN :: String -> (HiExpr -> HiExpr -> HiExpr) -> Operator Parser HiExpr
infixN name f = InfixN (f <$ sym name)

createBinary :: HiFun -> HiExpr -> HiExpr -> HiExpr
createBinary fun a b = HiExprApply (HiExprValue (HiValueFunction fun)) [a, b]  

parens :: Parser a -> Parser a
parens = between (sym "(") (sym ")")

pHiValue :: Parser HiValue
pHiValue =
        pHiValueNumber
    <|> pHiValueBool  
    <|> (HiValueFunction <$> pSheme)
    <|> pHiValueString
    <|> pHiValueNull

pHiValueBool :: Parser HiValue
pHiValueBool = lexm $ choice
  [ HiValueBool True  <$ chunk "true"
  , HiValueBool False <$ chunk "false"
  ]     

args :: Parser [HiExpr]
args = parseExpr `sepBy` (sym ",")

sym :: String -> Parser String
sym s = sc *> (chunk s) <* sc 

pSheme :: Parser HiFun
pSheme = choice
    [ HiFunAdd <$ chunk "add"
    , HiFunSub <$ chunk "sub"
    , HiFunMul <$ chunk "mul"
    , HiFunDiv <$ chunk "div"
    , HiFunAnd <$ chunk "and"
    , HiFunOr  <$ chunk "or"
    , HiFunIf <$ chunk "if"
    , HiFunEquals <$ chunk "equals"  
    , HiFunLessThan <$ chunk "less-than"
    , HiFunGreaterThan <$ chunk "greater-than"
    , HiFunNotLessThan <$ chunk "not-less-than"
    , HiFunNotGreaterThan <$ chunk "not-greater-than"
    , HiFunNotEquals <$ chunk "not-equals"
    , HiFunNot <$ chunk "not"
    , HiFunLength <$ chunk "length"
    , HiFunToUpper <$ chunk "to-upper"
    , HiFunToLower <$ chunk "to-lower"
    , HiFunReverse <$ chunk "reverse"
    , HiFunTrim <$ chunk "trim"
    ]

sc :: Parser ()
sc = L.space
  Text.Megaparsec.Char.space1                        
  (L.skipLineComment "//")       
  (L.skipBlockComment "/*" "*/") 

lexm :: Parser a -> Parser a
lexm = L.lexeme sc

pHiValueNumber :: Parser HiValue
pHiValueNumber =  HiValueNumber . toRational <$> (L.signed sc L.scientific)

pHiValueString :: Parser HiValue
pHiValueString =  HiValueString . T.pack <$> (char '\"' *> manyTill L.charLiteral (char '\"'))

pHiValueNull :: Parser HiValue
pHiValueNull = do
  _ <- string "null"
  return HiValueNull

