module HW3.Pretty(
   prettyValue
) where

import HW3.Base(HiValue(..), HiFun(..))  
import Prettyprinter
import Prettyprinter.Render.Terminal
import Data.Ratio (denominator, numerator)
import Numeric (showFFloat)
import Data.Scientific (fromRationalRepetendUnlimited, toRealFloat)

prettyValue :: HiValue -> Doc AnsiStyle
prettyValue (HiValueNumber number) =  showNumber number (numerator number) (denominator number)
prettyValue (HiValueFunction fun)  = showFun fun
prettyValue (HiValueBool bool)     = showBool bool  
prettyValue (HiValueString str)    = pretty str
prettyValue (HiValueNull )         = pretty "null"

showFun :: HiFun -> Doc AnsiStyle
showFun a =
    pretty $ 
    case a of
        HiFunDiv -> "div"
        HiFunMul -> "mul" 
        HiFunAdd -> "add"
        HiFunSub -> "sub"
        HiFunNot -> "not"
        HiFunAnd -> "and"
        HiFunOr ->  "or"
        HiFunLessThan -> "less-than"
        HiFunGreaterThan -> "greater-than"
        HiFunEquals -> "equals"
        HiFunNotLessThan -> "not-less-than"
        HiFunNotGreaterThan -> "not-greater-than"
        HiFunNotEquals -> "not-equals"
        HiFunIf -> "if"
        HiFunLength -> "length"
        HiFunToUpper -> "to-upper"
        HiFunToLower -> "to-lower"  
        HiFunReverse -> "reverse"  
        HiFunTrim -> "trim"

showBool :: Bool -> Doc AnsiStyle
showBool bool =
    pretty $
    case bool of
        True -> "true"
        False -> "false"


showNumber :: Rational -> Integer -> Integer -> Doc AnsiStyle
showNumber _ num 1 = pretty $ show num
showNumber x num den = pretty $ showDecimalOrFractional x num den


showDecimalOrFractional :: Rational -> Integer -> Integer -> String
showDecimalOrFractional x n d =  
    case fromRationalRepetendUnlimited x of
        (s, Nothing) -> showFFloat Nothing (toRealFloat s :: Double) ""
        (_, Just _)  -> showFractional d (quotRem n d)


showFractional :: Integer -> (Integer, Integer) -> String
showFractional d (0, x) = show x ++ "/" ++ show d
showFractional d (x, y) = show x ++ (if y > 0 then " + " else " - ") ++ showFractional d (0, abs y)        
