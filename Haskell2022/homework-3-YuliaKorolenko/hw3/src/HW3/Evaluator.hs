module HW3.Evaluator
    ( eval
    ) 
    where

       
import HW3.Base (HiExpr(..), HiError(..), HiValue(..), HiFun(..))
import Control.Monad.Trans.Except
import Control.Monad.Except()
import Data.Text as T
import Data.Semigroup (stimes)
import Data.Ratio (denominator, numerator)
import Control.Monad.Except

eval :: Monad m => HiExpr -> m (Either HiError HiValue)
eval = runExceptT . evalHiExpr

evalHiExpr  :: Monad m => HiExpr -> ExceptT HiError m HiValue
evalHiExpr (HiExprValue val) = return val
evalHiExpr (HiExprApply funct list) = do
    f <- evalHiExpr funct
    evalApplyFun f list    


evalApplyFun :: Monad m => HiValue -> [HiExpr] ->  ExceptT HiError m HiValue
evalApplyFun (HiValueFunction a) par = valueF a par
evalApplyFun (HiValueString  a)  par =
    do
    params <- mapM evalHiExpr par    
    hiString a params 
evalApplyFun _ _ = throwE HiErrorInvalidFunction 

valueF :: Monad m => HiFun -> [HiExpr] -> ExceptT HiError m HiValue
valueF fun list =
   case fun of
      HiFunIf   -> hiIf list
      _ -> do
         params <- mapM evalHiExpr list
         valueFunction fun params


valueFunction :: Monad m => HiFun -> [HiValue] -> ExceptT HiError m HiValue
valueFunction fun = 
    case fun of
        HiFunAdd -> hiAdd
        HiFunSub -> hiSub
        HiFunDiv -> hiDiv
        HiFunMul -> hiMul
        HiFunNot -> hiNot
        HiFunAnd -> binaryBool (&&)
        HiFunOr  -> binaryBool (||)
        HiFunLength -> hiLength 
        HiFunToUpper -> hiToUpper
        HiFunToLower -> hiToLower
        HiFunReverse -> hiReverse
        HiFunTrim  -> hitrim
        hifun -> binaryEquals hifun


hiAdd :: Monad m => [HiValue] -> ExceptT HiError m HiValue
hiAdd [HiValueNumber first, HiValueNumber second] = pure . HiValueNumber $ first + second
hiAdd [HiValueString first, HiValueString second] = pure . HiValueString $ first <> second
hiAdd [HiValueString first, HiValueNull] = pure . HiValueString $ first
hiAdd [HiValueNull, HiValueString second] = pure . HiValueString $ second
hiAdd [_, _]        = throwE HiErrorInvalidArgument
hiAdd _ = throwE HiErrorArityMismatch

hiSub :: Monad m => [HiValue] -> ExceptT HiError m HiValue
hiSub [HiValueNumber first, HiValueNumber second] = pure . HiValueNumber $ first - second
hiSub [_, _]        = throwE HiErrorInvalidArgument
hiSub _ = throwE HiErrorArityMismatch

hiDiv :: Monad m => [HiValue] -> ExceptT HiError m HiValue
hiDiv [HiValueNumber _, HiValueNumber 0] = throwE HiErrorDivideByZero
hiDiv [HiValueNumber first, HiValueNumber second] = pure . HiValueNumber $ first / second
hiDiv [HiValueString first, HiValueString second] = pure . HiValueString $ (first <> T.pack "/" <> second)
hiDiv [_, _]        = throwE HiErrorInvalidArgument
hiDiv _ = throwE HiErrorArityMismatch

hiMul :: Monad m => [HiValue] -> ExceptT HiError m HiValue
hiMul [HiValueNumber first, HiValueNumber second] = pure . HiValueNumber $ first * second
hiMul [HiValueString _, HiValueNumber 0] = throwE HiErrorInvalidArgument
hiMul [HiValueString first, HiValueNumber second] = helperTimes HiValueString first second
hiMul [_, _]  = throwE HiErrorInvalidArgument
hiMul _               = throwE HiErrorArityMismatch

helperTimes :: (Monad m, Semigroup a) => (a -> HiValue) -> a -> Rational -> ExceptT HiError m HiValue
helperTimes fun a b = do
  ind <- fromRatToInt b
  if ind > 0
  then return $ fun $ stimes ind a
  else throwE HiErrorInvalidArgument


binaryBool :: Monad m => (Bool -> Bool -> Bool) -> [HiValue] -> ExceptT HiError m HiValue
binaryBool f [HiValueBool first, HiValueBool second] = pure . HiValueBool $ f first second
binaryBool _ [_, _]        = throwE HiErrorInvalidArgument
binaryBool _ _ = throwE HiErrorArityMismatch

hiNot :: Monad m => [HiValue] -> ExceptT HiError m HiValue
hiNot [HiValueBool x] =  pure (HiValueBool $ not x)
hiNot [_] = throwE HiErrorInvalidArgument
hiNot _ = throwE HiErrorArityMismatch

binaryEquals :: Monad m => HiFun -> [HiValue]  -> ExceptT HiError m HiValue
binaryEquals fun [first, second] = 
    pure . HiValueBool $
    case fun of
        HiFunLessThan -> (first < second)
        HiFunGreaterThan -> (first > second)
        HiFunEquals -> (first == second)
        HiFunNotLessThan -> (first >= second)
        HiFunNotGreaterThan -> (first <= second)
        HiFunNotEquals -> (first /= second)
        _ -> undefined
binaryEquals _ [_, _] = throwE HiErrorInvalidArgument   
binaryEquals _ _ = throwE HiErrorArityMismatch

hiIf :: Monad m => [HiExpr] -> ExceptT HiError m HiValue
hiIf [bool, first, second] = do
    evalBool <- evalHiExpr bool
    case evalBool of
       (HiValueBool True)  -> evalHiExpr first
       (HiValueBool False) -> evalHiExpr second
       _                   -> throwE HiErrorInvalidArgument
hiIf [_, _, _] = throwE HiErrorInvalidArgument      
hiIf _ = throwE HiErrorArityMismatch

hiLength :: Monad m => [HiValue] -> ExceptT HiError m HiValue
hiLength [HiValueString first] = pure . HiValueNumber $ fromIntegral $ T.length first
hiLength [_] = throwE HiErrorInvalidArgument
hiLength _ = throwE HiErrorArityMismatch

hiToUpper :: Monad m => [HiValue] -> ExceptT HiError m HiValue
hiToUpper [HiValueString first] = pure . HiValueString $ T.toUpper first
hiToUpper [_] = throwE HiErrorInvalidArgument
hiToUpper _ = throwE HiErrorArityMismatch

hiToLower :: Monad m => [HiValue] -> ExceptT HiError m HiValue
hiToLower [HiValueString first] = pure . HiValueString $ T.toLower first
hiToLower [_] = throwE HiErrorInvalidArgument
hiToLower _ = throwE HiErrorArityMismatch

hiReverse :: Monad m => [HiValue] -> ExceptT HiError m HiValue
hiReverse [HiValueString first] = pure . HiValueString $ T.reverse first
hiReverse [_] = throwE HiErrorInvalidArgument
hiReverse _ = throwE HiErrorArityMismatch

hitrim :: Monad m => [HiValue] -> ExceptT HiError m HiValue
hitrim [HiValueString first] = pure . HiValueString $ T.strip first
hitrim [_] = throwE HiErrorInvalidArgument
hitrim _ = throwE HiErrorArityMismatch

hiString :: Monad m => Text -> [HiValue] -> ExceptT HiError m HiValue
hiString text [HiValueNumber x] = do
    intX <- fromRatToInt x
    if intX >= 0 && intX <= fromIntegral (T.length text)
    then return . HiValueString . T.pack $ [T.index text (fromIntegral intX)]
    else return HiValueNull    
hiString text [HiValueNumber first, HiValueNumber second] = do
     f <- fromRatToInt first
     s <- fromRatToInt second
     pure . HiValueString $ slice f s text
hiString text [HiValueNumber first, HiValueNull] = do
    f <- fromRatToInt first
    pure . HiValueString $ slice f (toInteger (T.length text)) text
hiString text [HiValueNull, HiValueNumber second] = do
     s <- fromRatToInt second
     pure . HiValueString $ slice 0 s text
hiString _ [_] = throwE HiErrorInvalidArgument
hiString _ _ =   throwE HiErrorArityMismatch

fromRatToInt :: Monad m => Rational -> ExceptT HiError m Integer
fromRatToInt rat = 
    case (numerator rat, denominator rat) of
        (n, 1) -> return n
        _ -> throwError HiErrorInvalidArgument

slice :: Integer ->  Integer -> Text -> Text
slice first second text = (T.drop f . T.take (T.length text - s)) text
    where
        size = T.length text
        f = if first < 0 then size - abs (truncate (toRational first)) else (truncate (toRational first))
        s = if second < 0 then abs (truncate (toRational second)) else size - (truncate (toRational second))


