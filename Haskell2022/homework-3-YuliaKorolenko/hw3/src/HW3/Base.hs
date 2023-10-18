module HW3.Base
( HiError(..)
, HiValue(..)
, HiFun(..)
, HiExpr(..)
) where


import Data.Text 


-- function names (e.g. div, sort, length, ...)
data HiFun =
    HiFunDiv
  | HiFunMul
  | HiFunAdd
  | HiFunSub
  | HiFunNot
  | HiFunAnd
  | HiFunOr
  | HiFunLessThan
  | HiFunGreaterThan
  | HiFunEquals
  | HiFunNotLessThan
  | HiFunNotGreaterThan
  | HiFunNotEquals
  | HiFunIf
  | HiFunLength
  | HiFunToUpper
  | HiFunToLower
  | HiFunReverse
  | HiFunTrim
  deriving (Eq, Ord, Show)

-- values (numbers, booleans, strings, ...)
data HiValue =
    HiValueBool Bool
  | HiValueFunction HiFun
  | HiValueNumber Rational
  | HiValueNull
  | HiValueString Text
  deriving (Eq, Ord, Show)

-- expressions (literals, function calls, ...)
data HiExpr =
    HiExprValue HiValue
  | HiExprApply HiExpr [HiExpr]
  deriving (Eq, Ord, Show)

-- evaluation errors (invalid arguments, ...)
data HiError =
    HiErrorInvalidArgument
  | HiErrorInvalidFunction
  | HiErrorArityMismatch
  | HiErrorDivideByZero
  deriving (Eq, Ord, Show)