module HW2.T5
( ExceptState(..)    
, mapExceptState 
, wrapExceptState 
, joinExceptState 
, modifyExceptState 
, throwExceptState
, eval 
) where
    
import qualified Control.Monad    
import HW2.T1   (Annotated (..), Except (..), mapAnnotated, mapExcept)    
import HW2.T4   (Expr (..), Prim(..))

data ExceptState e s a = ES { runES :: s -> Except e (Annotated s a) }

wrapExceptState :: a -> ExceptState e s a
wrapExceptState a = ES (\s -> Success (a :# s))

mapExceptState :: (a -> b) -> ExceptState e s a -> ExceptState e s b
mapExceptState f exState = ES (\s -> mapExcept (mapAnnotated f) (runES exState s))

joinExceptState :: ExceptState e s (ExceptState e s a) -> ExceptState e s a
joinExceptState exState = ES (\s -> 
    case runES exState s of
        Success (a :# e) -> runES a e
        Error e          -> Error e )

modifyExceptState :: (s -> s) -> ExceptState e s ()
modifyExceptState f = ES (\s -> Success (() :# f s))

-- error
throwExceptState :: e -> ExceptState e s a
throwExceptState e = ES (\_ -> Error e)

instance Functor (ExceptState e s) where
  fmap = mapExceptState

instance Applicative (ExceptState e s) where
  pure = wrapExceptState
  p <*> q = Control.Monad.ap p q

instance Monad (ExceptState e s) where
  m >>= f = joinExceptState (fmap f m)


data EvaluationError = DivideByZero

eval :: Expr -> ExceptState EvaluationError [Prim Double] Double 
eval (Val var) = return var
eval (Op oper) = 
    case oper of
        (Add x y) -> binaryOp x y Add (+)
        (Sub x y) -> binaryOp x y Sub (-)
        (Mul x y) -> binaryOp x y Mul (*)
        (Div x y) -> do
            x1 <- eval x
            y1 <- eval y
            if (y1 == 0)
            then throwExceptState DivideByZero
            else do
                modifyExceptState (Div x1 y1 :)
                return (x1 / y1)
        (Abs x)   -> unaryOp x Abs abs
        (Sgn x)   -> unaryOp x Sgn signum

binaryOp :: Expr -> Expr -> (Double -> Double -> Prim Double) -> (Double -> Double -> Double) -> ExceptState EvaluationError [Prim Double] Double
binaryOp x y pr f
    = do x1 <- eval x
         y1 <- eval y
         modifyExceptState (pr x1 y1 :)
         return (f x1 y1)

unaryOp :: Expr -> (Double -> Prim Double) -> (Double -> Double) -> ExceptState EvaluationError [Prim Double] Double
unaryOp x pr f = do
    x1 <- eval x
    modifyExceptState (pr x1 :)
    return $ f x1
