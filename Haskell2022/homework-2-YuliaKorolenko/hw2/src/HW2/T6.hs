{-# LANGUAGE DerivingStrategies         #-}
{-# LANGUAGE GeneralizedNewtypeDeriving #-}

module HW2.T6
( ParseError(..)
, runP
, pChar
, parseError
, pEof
, parseExpr
) where

import GHC.Natural
import Control.Applicative (Alternative (..))
import Control.Monad (MonadPlus (..))
import HW2.T5(ExceptState(..))  
import HW2.T1 (Except(..), Annotated(..))
import HW2.T4 (Expr(..))



data ParseError = ErrorAtPos Natural

newtype Parser a = P (ExceptState ParseError (Natural, String) a)
  deriving newtype (Functor, Applicative, Monad)    

runP :: Parser a -> String -> Except ParseError a
runP (P a) s =
    case runES a (0, s)  of
        (Error e )        -> Error e
        (Success (k :# _)) -> Success k

-- Если на вход принимается пустая строка, то возвращается ошибка ы текущей позиции
-- Если (c:cs), то тогда текущая позиция увеличивается на 1
pChar :: Parser Char
pChar = P $ ES $ \(pos, s) ->
  case s of
    []     -> Error (ErrorAtPos pos)
    (c:cs) -> Success (c :# (pos + 1, cs))


parseError :: Parser a
parseError = P $ ES $ \(pos, _) -> Error (ErrorAtPos pos)

instance Alternative Parser where
  empty = parseError
  (<|>) (P p) (P q) = P $ ES $ \(pos, str) ->
    case runES p (pos, str) of
        Error _ -> runES q (pos,  str)
        a -> a

instance MonadPlus Parser 

pEof :: Parser ()
pEof = P $ ES $ \(pos, s) ->
  case s of
    []     -> Success (() :# (pos + 1, ""))
    (_:_) -> Error (ErrorAtPos pos)

parseExpr :: String -> Except ParseError Expr
parseExpr = undefined